package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.sun.javafx.scene.control.skin.FXVK;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import lk.ijse.bo.custom.HomeBO;
import lk.ijse.bo.custom.impl.HomeBOImpl;
import lk.ijse.dto.BookDTO;
import lk.ijse.dto.tm.BookTM;
import lk.ijse.pages.Impl.PagesImpl;
import lk.ijse.pages.Pages;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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

    HomeBO home = new HomeBOImpl();

    ObservableList<BookTM> obList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCellValueFactory();
        loadAllBooks();
    }

    private void loadAllBooks() {

        for (BookDTO bookDTO : home.findAllBook()){
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
        buttonsDesign();
        bookTable.setItems(obList);

        for (int i = 0; i < obList.size(); i++) {
            obList.get(i).getUpdate().setOnAction(event -> {
                Pages pages = new PagesImpl();
                try {
                    pages.popUpWindow("/view/updateBook.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            obList.get(i).getDelete().setOnAction(event -> {

            });
        }
    }

    private void buttonsDesign() {
        for (int i = 0; i < obList.size(); i++) {
             obList.get(i).getUpdate().setTextFill(Color.WHITE);
             obList.get(i).getUpdate().setBackground(Background.fill(Color.GREEN));
             obList.get(i).getDelete().setTextFill(Color.WHITE);
             obList.get(i).getDelete().setBackground(Background.fill(Color.RED));
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
        List<BookDTO> books = home.books();
        for (int i=0; i < books.size(); i++) {
            System.out.println(books.get(i).getTitle());
        }
    }

    public void question2OnAction(ActionEvent actionEvent) {

    }
}
