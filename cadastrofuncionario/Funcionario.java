package cadastrofuncionario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Funcionario {

        private int codFuncionario;
        private String nome;
        private String valorSalario;
        private LocalDate dataAdimissao;
        private final LocalDate dataAtual = LocalDate.now();
        private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Funcionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public Funcionario(int codFuncionario, String nome, String valorSalario, String dataAdmissao) {
        this.codFuncionario = codFuncionario;
        this.nome = nome;
        this.valorSalario = valorSalario;
        this.setDataAdimissao(dataAdmissao);
    }

    public int getCodFuncionario() {
        return codFuncionario;
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

    public LocalDate getDataAdimissao() {
        return dataAdimissao;
    }

    public void setDataAdimissao(String dataAdimissao) {
        this.dataAdimissao = LocalDate.parse(dataAdimissao, formato);
    }

    public long tempodeEmpresa(){
        return ChronoUnit.DAYS.between(this.dataAdimissao, dataAtual);
    }

   @Override
    public String toString() {
        return "\n----Funcionario-----\nCodigo= "+codFuncionario+"\nNome: "+nome+"\nSalario: "+valorSalario+"\nTempo de empresa: "+tempodeEmpresa()+" dias";
    }

}
