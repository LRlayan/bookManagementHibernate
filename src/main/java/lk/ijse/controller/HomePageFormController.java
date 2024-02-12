package lk.ijse.controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.ijse.config.FactoryConfiguration;
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
    private TextField txtBookTitle;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtPublishedYear;

    Pages pages = new PagesImpl();



    @FXML
    void viewBookDetailsOnAction(ActionEvent event) throws IOException {
        pages.popUpWindow("/view/viewBooksDetailsForm.fxml");
    }

    @FXML
    public void saveRecordOnAction(ActionEvent actionEvent) {

        var authorDTO = new AuthorDTO();
        authorDTO.setName(txtAuthorName.getText());

        var bookDTO = new BookDTO();
        bookDTO.setTitle(txtBookTitle.getText());
        bookDTO.setPublicationYear(txtPublishedYear.getText());
        bookDTO.setPrice(Double.parseDouble(txtPrice.getText()));
    }

//    public void saveRecord(String author, String bookTitle, String publishedYear, double price){
//
//        var authorDTO = new AuthorDTO();
//        authorDTO.setName(author);
//
//        var bookDTO = new BookDTO();
//        bookDTO.setTitle(bookTitle);
//        bookDTO.setPublicationYear(publishedYear);
//        bookDTO.setPrice(price);
//
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        session.save(authorDTO);
//        session.save(bookDTO);
//
//        transaction.commit();
//        session.close();

}
