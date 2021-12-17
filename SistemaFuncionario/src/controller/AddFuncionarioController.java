package controller;

import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import model.Funcionario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.LocalLinkedList;

import javax.swing.*;
import java.io.IOException;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

public class AddFuncionarioController implements Initializable {

    private final LocalLinkedList<Funcionario> funcionarios = new LocalLinkedList<>();


    @FXML
    private Pane contentArea;

    @FXML
    private Button btnCadastro;

    @FXML
    private TextField codFuncionario;

    @FXML
    private TextField nome;

    @FXML
    private TextField valorSalario;

    @FXML
    private TextField dataAdmissao;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        funcionarios.readFile();
    }

    @FXML
    private void cadastrarFuncionario(javafx.event.ActionEvent actionEvent) {
        if (isblanckField()){
            if(funcionarios.checkCod(codFuncionario.getText())) {
                try {
                    addFuncionario();
                } catch (IllegalArgumentException | IOException e) {
                    showMessage("Campo Digitado no Formato incorreto!", "Formato Incorreto", 0);

                } catch (DateTimeParseException e) {
                    showMessage("Data Digitada no Formato incorreto!", "Formato Incorreto", 0);
                }
            }else showMessage("Código de Funcionário Já Cadastrado", "Campo Único",0);
        }
        else showMessage("Preencha todos os campos para adicionar um funcionário!", "Campos Em Branco",0);
    }

    private void addFuncionario() throws IOException {
            funcionarios.addLast(new Funcionario(Integer.parseInt(codFuncionario.getText()), nome.getText().toUpperCase(), changeSalario(), dataAdmissao.getText()));
            showMessage("Funcionário Adicionado Com sucesso", "Registrado", 1);
            clearTextField();
            funcionarios.saveFile();
    }

    private void showMessage(String mensagem, String aviso, int tipo){
        JOptionPane.showMessageDialog(null, mensagem, aviso, tipo);
    }

    private boolean isblanckField(){
        return !codFuncionario.getText().equals("") && !nome.getText().equals("") && !valorSalario.getText().equals("") && !dataAdmissao.getText().equals("");
    }

    private void clearTextField(){
        codFuncionario.setText("");
        nome.setText("");
        valorSalario.setText("");
        dataAdmissao.setText("");
    }

    private String changeSalario() {
        String salario = valorSalario.getText().replace(",",".");
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(Double.parseDouble(salario)).replace(",",".");
    }


}
