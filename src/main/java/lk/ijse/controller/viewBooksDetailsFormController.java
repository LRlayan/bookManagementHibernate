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
import lk.ijse.bo.custom.HomeBO;
import lk.ijse.bo.custom.impl.HomeBOImpl;
import lk.ijse.dto.BookDTO;
import lk.ijse.dto.tm.BookTM;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCellValueFactory();
        loadAllBooks();
    }

    private void loadAllBooks() {
        ObservableList<BookTM> obList = FXCollections.observableArrayList();

        for (BookDTO bookDTO :home.findAllBook()){
            obList.add(new BookTM(
                    bookDTO.getId(),
                    bookDTO.getTitle(),
                    bookDTO.getPublicationYear(),
                    bookDTO.getPrice(),
                    bookDTO.getAuthor().getId(),
                    new JFXButton("Update"),
                    new JFXButton("Delete")
            ));
        }
        bookTable.setItems(obList);
    }

    private void setCellValueFactory(){

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
