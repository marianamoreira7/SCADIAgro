package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.Funcionario;
import model.LocalLinkedList;

import javax.swing.*;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class InfoSalarioController implements Initializable {

    private final LocalLinkedList<Funcionario> funcionarios = new LocalLinkedList<>();

    @FXML
    private Pane contentArea;

    @FXML
    private TextField txtqtdFuncionarios;

    @FXML
    private TextField txtsomaSalarial;

    @FXML
    private TextField txtmediaSalarial;

    @FXML
    private TextField txtmaiorSalario;

    @FXML
    private TextField txtmenorSalario;

    @FXML
    void btninfoMaiorSalario(ActionEvent event) {
        JOptionPane.showMessageDialog(null, funcionarios.maiorSalario2(), "Funcionario de Maior Salario", 1);
    }

    @FXML
    void btninfoMenorSalario(ActionEvent event) {
        JOptionPane.showMessageDialog(null, funcionarios.menorSalario2(), "Funcionario de Menor Salario", 1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        info();
    }

    private void info(){
        funcionarios.readFile();
        if (funcionarios.size()>0) {
            txtqtdFuncionarios.setText(funcionarios.size()+" Funcionarios");
            txtsomaSalarial.setText("R$ "+ changeSalario(funcionarios.somaSalario()));
            txtmediaSalarial.setText("R$ "+ changeSalario(funcionarios.mediaSalario()));
            txtmaiorSalario.setText("R$ "+ changeSalario(funcionarios.maiorSalario()));
            txtmenorSalario.setText("R$ "+ changeSalario(funcionarios.menorSalario()));
    }}

    private String changeSalario(String salario) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(Double.parseDouble(salario));
    }
}
