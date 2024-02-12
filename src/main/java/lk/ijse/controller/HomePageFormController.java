package lk.ijse.controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.ijse.pages.Impl.PagesImpl;
import lk.ijse.pages.Pages;

import java.io.IOException;

public class HomePageFormController {

    @FXML
    private JFXButton viewBtn;

    Pages pages = new PagesImpl();

    @FXML
    void saveAuthorOnAction(ActionEvent event) {

    }

    @FXML
    void saveBookOnAction(ActionEvent event) {

    }

    @FXML
    void viewBookDetailsOnAction(ActionEvent event) throws IOException {
        pages.popUpWindow("/view/viewBooksDetailsForm.fxml");
    }
}
