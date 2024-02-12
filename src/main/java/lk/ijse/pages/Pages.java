package lk.ijse.pages;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;

public interface Pages{
    void popUpWindow(String fxml) throws IOException;
    void closeWindow(JFXButton button);
}
