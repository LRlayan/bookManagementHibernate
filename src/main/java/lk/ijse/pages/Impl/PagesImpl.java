package lk.ijse.pages.Impl;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.pages.Pages;

import java.io.IOException;

public class PagesImpl implements Pages {
    public void popUpWindow(String fxml) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    @Override
    public void closeWindow(JFXButton button) {
       Stage stage = (Stage) button.getScene().getWindow();
       stage.close();
    }
}
