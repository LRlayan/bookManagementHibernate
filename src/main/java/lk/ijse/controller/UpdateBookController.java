package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.bo.custom.UpdateBookBO;
import lk.ijse.bo.custom.impl.UpdateBookBOImpl;
import lk.ijse.dto.BookDTO;
import lk.ijse.pages.Impl.PagesImpl;
import lk.ijse.pages.Pages;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class UpdateBookController implements Initializable {
    @FXML
    private JFXButton btnClose;

    @FXML
    private TextField txtAuthorId;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtPublishedYear;

    @FXML
    private TextField searchBook;

    @FXML
    private TextField txtPercentage;

    UpdateBookBO updateBook = new UpdateBookBOImpl();
    private List<BookDTO> bookDTOList = updateBook.findAllBooks();
    private Set<String> _bookDTOList = new HashSet<>();
    Pages pages = new PagesImpl();
    UpdateBookBO updateBookBO = new UpdateBookBOImpl();

    @FXML
    void closeOnAction(ActionEvent event) {
        pages.closeWindow(btnClose);
    }

    @FXML
    void updateBooksOnAction(ActionEvent event) {
        int percentage = Integer.parseInt(txtPercentage.getText());

       boolean isUpdate = updateBookBO.updateBook(percentage);
       if (isUpdate){
           new Alert(Alert.AlertType.INFORMATION,"Update Book!").show();
       }else {
           new Alert(Alert.AlertType.ERROR,"Try Again!").show();
       }
    }

    @FXML
    void searchBarOnAction(ActionEvent event) {
        searchResultSetTextFields();
    }

    private void searchResultSetTextFields() {
        String title = searchBook.getText();

        for (int i = 0; i < bookDTOList.size(); i++){
            if (title.equals(bookDTOList.get(i).getTitle())){
                txtBookId.setText(String.valueOf(bookDTOList.get(i).getId()));
                txtAuthorId.setText(String.valueOf(bookDTOList.get(i).getAuthorId()));
                txtBookTitle.setText(bookDTOList.get(i).getTitle());
                txtPublishedYear.setText(bookDTOList.get(i).getPublicationYear());
                txtPrice.setText(String.valueOf(bookDTOList.get(i).getPrice()));
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchBar();
    }

    private void searchBar() {
        bookDTOList.forEach(bookDTO ->  {
            _bookDTOList.add(bookDTO.getTitle());
        });
        TextFields.bindAutoCompletion(searchBook,_bookDTOList);
    }
}
