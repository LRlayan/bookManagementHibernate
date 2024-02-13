package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import lk.ijse.bo.custom.HomeBO;
import lk.ijse.bo.custom.impl.HomeBOImpl;
import lk.ijse.dto.BookDTO;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class viewBooksDetailsFormController implements Initializable {

    HomeBO home = new HomeBOImpl();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
