package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.custom.impl.HomeBOImpl;
import lk.ijse.dao.custom.AuthorDAO;
import lk.ijse.dao.custom.impl.AuthorDAOImpl;
import lk.ijse.dto.AuthorDTO;
import lk.ijse.dto.tm.AuthorTM;
import lk.ijse.entity.Author;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class viewBooksDetailsFormController implements Initializable {
    @FXML
    private TableView<AuthorTM> bookDetailsTable;

    @FXML
    private TableColumn<?, ?> colAuthorId;

    @FXML
    private TableColumn<?, ?> colAuthorName;

    @FXML
    private TableColumn<?, ?> colUpdate;

    @FXML
    private TableColumn<?, ?> colDelete;

    HomeBOImpl homeBO = new HomeBOImpl();
    AuthorDAO authorDAO = new AuthorDAOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCellValueFactory();
        loadAllAuthors();
    }

    private void loadAllAuthors() {
        ObservableList<AuthorTM> tmList = FXCollections.observableArrayList();

//        JFXButton update = new JFXButton("Update");
//        update.setStyle("-fx-background-color: #0D9276");
//        JFXButton delete = new JFXButton("Delete");
//        update.setStyle("-fx-background-color: #B80000");
//        for (Author authorDTO :authorDAO.findAll()){
//            tmList.add(new AuthorTM(
//                authorDTO.getId(),
//                authorDTO.getName(),
//                new JFXButton("Update"),
//                new JFXButton("Delete")
//            ));
//        }
      // bookDetailsTable.setItems(tmList);
        List<AuthorDTO> author = homeBO.findAllAuthor();
        for (int i = 0; i < author.size(); i++ ){
            System.out.println(author.get(i));
        }
    }

    public void setCellValueFactory(){
        colAuthorId.setCellValueFactory(new PropertyValueFactory<>("Author id"));
        colAuthorName.setCellValueFactory(new PropertyValueFactory<>("Author"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<>("Update"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("Delete"));
    }
}
