package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pages.Impl.PagesImpl;
import lk.ijse.pages.Pages;

import java.io.IOException;

public class dashboardController {

    @FXML
    private AnchorPane mainAnchorpane;
    @FXML
    private JFXButton button;

    Pages pages = new PagesImpl();

    public void goToHomeBtnOnAction(ActionEvent actionEvent) throws IOException {
        pages.popUpWindow("/view/HomePageForm.fxml");
        pages.closeWindow(button);
    }
}
