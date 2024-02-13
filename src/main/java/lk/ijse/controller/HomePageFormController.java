package lk.ijse.controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.bo.custom.HomeBO;
import lk.ijse.bo.custom.impl.HomeBOImpl;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AuthorDAO;
import lk.ijse.dao.custom.impl.AuthorDAOImpl;
import lk.ijse.dto.AuthorDTO;
import lk.ijse.dto.BookDTO;
import lk.ijse.pages.Impl.PagesImpl;
import lk.ijse.pages.Pages;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class HomePageFormController {

    @FXML
    private JFXButton viewBtn;

    @FXML
    private TextField txtAuthorName;

    @FXML
    private TextField txtCountry;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtPublishedYear;

    Pages pages = new PagesImpl();

    HomeBO home = new HomeBOImpl();

    @FXML
    void viewBookDetailsOnAction(ActionEvent event) throws IOException {
        pages.popUpWindow("/view/viewBooksDetailsForm.fxml");
    }

    @FXML
    void saveAuthorOnAction(ActionEvent event) {
        var authorDTO = new AuthorDTO();
        authorDTO.setName(txtAuthorName.getText());
        authorDTO.setCountry(txtCountry.getText());

        boolean isSaved = home.saveAuthor(authorDTO);
        if (isSaved){
            new Alert(Alert.AlertType.INFORMATION,"Saved Author!").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Try Again!").show();
        }
    }

    @FXML
    void saveBookOnAction(ActionEvent event) {
        var bookDTO = new BookDTO();
        bookDTO.setTitle(txtBookTitle.getText());
        bookDTO.setPublicationYear(txtPublishedYear.getText());
        bookDTO.setPrice(Double.parseDouble(txtPrice.getText()));

        boolean isSaved = home.saveBook(bookDTO);
        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Saved Book!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Try Again!").show();
        }
    }
}
