package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.Funcionario;
import model.LocalLinkedList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListFuncionarioController implements Initializable {

    private final LocalLinkedList<Funcionario> funcionarios = new LocalLinkedList<>();

    @FXML
    private Pane contentArea;

    @FXML
    private TableView<Funcionario> table;

    @FXML
    private TableColumn<Funcionario, Integer> tablecodFuncionario;

    @FXML
    private TableColumn<Funcionario, String> tablenome;

    @FXML
    private TableColumn<Funcionario, String> tablevalorSalario;

    @FXML
    private TableColumn<?, ?> tabletempodeEmpresa;

    @FXML
    private TableColumn<Funcionario, String> tabledataAdmissao;

    @FXML
    private Button btnRemoverFuncionario;

    @FXML
    private Button btnClearList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createTable();
    }

    private void createTable(){
        tablecodFuncionario.setCellValueFactory(new PropertyValueFactory<>("codFuncionario"));
        tablenome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tablevalorSalario.setCellValueFactory(new PropertyValueFactory<>("valorSalario"));
        tabletempodeEmpresa.setCellValueFactory(new PropertyValueFactory<>("tempodeEmpresa"));
        tabledataAdmissao.setCellValueFactory(new PropertyValueFactory<>("dataAdmissao"));
        table.setItems(funcionarios.listFuncionarios());
    }

    @FXML
    void removerFuncionario(ActionEvent event) throws IOException {
        funcionarios.removebyID(table.getSelectionModel().getSelectedItem().getCodFuncionario());
        createTable();

    }

    @FXML
    void clearList(ActionEvent event) throws IOException {
        funcionarios.clear();
        funcionarios.saveFile();
        createTable();
    }
}
