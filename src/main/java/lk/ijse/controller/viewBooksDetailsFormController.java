package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import lk.ijse.bo.custom.HomeBO;
import lk.ijse.bo.custom.ViewBooksDetailsBO;
import lk.ijse.bo.custom.impl.HomeBOImpl;
import lk.ijse.bo.custom.impl.ViewBooksDetailsBOImpl;
import lk.ijse.dto.AuthorDTO;
import lk.ijse.dto.BookDTO;
import lk.ijse.dto.tm.AuthorTM;
import lk.ijse.dto.tm.BookTM;
import lk.ijse.pages.Impl.PagesImpl;
import lk.ijse.pages.Pages;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class viewBooksDetailsFormController implements Initializable {

    @FXML
    private TableView<BookTM> bookTable;

    @FXML
    private TableColumn<?, ?> colAuthorId;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colBookTitle;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colPublishedYear;

    @FXML
    private TableColumn<?, ?> colUpdate;

    @FXML
    private TableColumn<?, ?> colDelete;

    @FXML
    private TableView<AuthorTM> authorTable;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colAuthorName;

    @FXML
    private TableColumn<?, ?> colCountry;

    @FXML
    private TableColumn<?, ?> colAuthorDelete;

    @FXML
    private Label lblAveragePrice;

    @FXML
    private TextField txtCountry;

    ObservableList<BookTM> obList = FXCollections.observableArrayList();
    ObservableList<AuthorTM> obListAuthor = FXCollections.observableArrayList();
    ViewBooksDetailsBO viewBooksDetails = new ViewBooksDetailsBOImpl();
    HomeBO home = new HomeBOImpl();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCellValueFactory();
        loadAllBooks();
        setCellValueFactoryInAuthor();
        loadAllAuthor();
    }

    private void setCellValueFactoryInAuthor() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colAuthorName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("Country"));
        colAuthorDelete.setCellValueFactory(new PropertyValueFactory<>("Delete"));
    }

    private void loadAllAuthor() {
        List<AuthorDTO> authors = viewBooksDetails.findAllAuthors();
        for (AuthorDTO authorDTO :authors){
            obListAuthor.add(new AuthorTM(
                    authorDTO.getId(),
                    authorDTO.getName(),
                    authorDTO.getCountry(),
                    new JFXButton("Delete")
            ));
        }
        buttonsDesign("obListAuthor");
        authorTable.setItems(obListAuthor);

        for (int i = 0; i < obListAuthor.size(); i++) {
            int authorId = obListAuthor.get(i).getId();
            obListAuthor.get(i).getDelete().setOnAction(event -> {
                ButtonType yes = new ButtonType("Yes",ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);

                Optional<ButtonType> type = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure delete Author",yes , no).showAndWait();
                if (type.get().getText() == "Yes"){
                    try {
                       boolean isDelete = viewBooksDetails.deleteAuthor(authorId);
                       if (isDelete){
                           new Alert(Alert.AlertType.INFORMATION,"Delete Successfully").show();
                       }
                    }catch (Exception e){
                        e.printStackTrace();
                       // new Alert(Alert.AlertType.ERROR,"Try Again!").show();
                    }
                }
                authorTable.refresh();
                loadAllAuthor();
            });
        }
    }

    private void loadAllBooks() {
         List<BookDTO> books = viewBooksDetails.findAllBook();
        for (BookDTO bookDTO : books ){
            obList.add(new BookTM(
                    bookDTO.getId(),
                    bookDTO.getTitle(),
                    bookDTO.getPublicationYear(),
                    bookDTO.getPrice(),
                    bookDTO.getAuthorId(),
                    new JFXButton("Update"),
                    new JFXButton("Delete")
            ));
        }
        buttonsDesign("obList");
        bookTable.setItems(obList);

        for (int i = 0; i < obList.size(); i++) {
            obList.get(i).getUpdate().setOnAction(event -> {
                Pages pages = new PagesImpl();
                try {
                    pages.popUpWindow("/view/updateBook.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                bookTable.refresh();
            });

            int bookId = obList.get(i).getBookId();
            obList.get(i).getDelete().setOnAction(event -> {
                ButtonType buttonYes = new ButtonType("Yes" , ButtonBar.ButtonData.OK_DONE);
                ButtonType buttonNo = new ButtonType("No" , ButtonBar.ButtonData.CANCEL_CLOSE);

                Optional<ButtonType> type = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure delete book!",buttonYes,buttonNo).showAndWait();
                if (type.get().getText() == "Yes"){

                    try{
                        boolean isDelete = viewBooksDetails.deleteBook(bookId);
                        if (isDelete) {
                             new Alert(Alert.AlertType.INFORMATION, "Delete Successfully!").show();
                        }
                    }catch (Exception e){
                        new Alert(Alert.AlertType.ERROR,"Try Again").show();
                    }
                }
                bookTable.refresh();
                loadAllBooks();
            });
        }
    }

    private void buttonsDesign(String name) {
        if (name.equals("obList")) {
            for (int i = 0; i < obList.size(); i++) {
                obList.get(i).getUpdate().setTextFill(Color.WHITE);
                obList.get(i).getUpdate().setBackground(Background.fill(Color.GREEN));
                obList.get(i).getDelete().setTextFill(Color.WHITE);
                obList.get(i).getDelete().setBackground(Background.fill(Color.RED));
            }
        } else {
            for (int i = 0; i < obListAuthor.size(); i++) {
                obListAuthor.get(i).getDelete().setTextFill(Color.WHITE);
                obListAuthor.get(i).getDelete().setBackground(Background.fill(Color.RED));
            }
        }
    }

    private void setCellValueFactory(){
        colBookId.setCellValueFactory(new PropertyValueFactory<>("BookId"));
        colBookTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colPublishedYear.setCellValueFactory(new PropertyValueFactory<>("PublishedYear"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colAuthorId.setCellValueFactory(new PropertyValueFactory<>("AuthorId"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<>("Update"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("Delete"));
    }

    public void question1OnAction(ActionEvent actionEvent) {
        List<BookDTO> books = viewBooksDetails.books();
        for (int i=0; i < books.size(); i++) {
            System.out.println(books.get(i).getTitle());
        }
    }

    public void averagePriceOnAction(ActionEvent actionEvent) {
        double avgPrice = (double) viewBooksDetails.sumOfPrices();
        lblAveragePrice.setText(String.valueOf(avgPrice));
    }

    @FXML
    void allBooksByAuthorOnAction(ActionEvent event) {
        List<Object[]> allBooksByAuthor = viewBooksDetails.allBooksByAuthor();
        for (Object[] authorsBook : allBooksByAuthor) {
            for (int i = 0; i <allBooksByAuthor.size(); i++) {
                String name = (String) authorsBook[0];
                Long count = (Long) authorsBook[1];

                System.out.println(name);
                System.out.println(count);
            }
        }
    }

    @FXML
    void question6OnAction(ActionEvent event) {
        String country = txtCountry.getText();
        List<BookDTO> bookDTOS = viewBooksDetails.question6(country);

        for (BookDTO bookDTO : bookDTOS){
            System.out.println(bookDTO);
        }
    }
}
