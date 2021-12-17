package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Funcionario {

    private int codFuncionario;
    private String nome;
    private String valorSalario;
    private LocalDate dataAdmissao;
    private long tempodeEmpresa;
    private final LocalDate dataAtual = LocalDate.now();
    private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Funcionario(int codFuncionario, String nome, String valorSalario, String dataAdmissao) {
        this.codFuncionario = codFuncionario;
        this.nome = nome;
        this.valorSalario = valorSalario;
        this.setDataAdmissao(dataAdmissao);
        this.tempodeEmpresa = tempodeEmpresa();
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValorSalario() {
        return valorSalario;
    }

    public void setValorSalario(String valorSalario) {
        this.valorSalario = valorSalario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = LocalDate.parse(dataAdmissao, formato);
    }

    public long tempodeEmpresa(){
        return ChronoUnit.DAYS.between(this.dataAdmissao, dataAtual);
    }

    public long getTempodeEmpresa() {
        return tempodeEmpresa;
    }


    @Override
    public String toString() {
        return "\n----Funcionario-----\nCodigo: "+codFuncionario+"\nNome: "+nome+"\nSalario: R$ "+valorSalario.replace(".",",")+"\nTempo de empresa: "+tempodeEmpresa+" dias";
    }



}
