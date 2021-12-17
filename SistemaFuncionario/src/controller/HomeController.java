package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeController implements Initializable {

    private static String path;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnList;

    @FXML
    private Button btnInfo;

    @FXML
    private Pane contentArea;

    @FXML
    private TextField txtṔath;

    public static String getPath() {
        return path;
    }

    @FXML
    void initialize() {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    void sendPath(ActionEvent event) {
        this.path = txtṔath.getText();
    }

    @FXML
    void btnHome(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/home.fxml"));
        contentArea.getChildren().setAll(root);
    }

    @FXML
    void btnAdicionar(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/addfuncionario.fxml"));
        contentArea.getChildren().setAll(root);
    }

    @FXML
    void btnListar(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/listfuncionario.fxml"));
        contentArea.getChildren().setAll(root);
    }

    @FXML
    void btninfoSalario(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/infosalario.fxml"));
        //contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

}

