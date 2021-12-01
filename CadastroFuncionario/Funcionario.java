package CadastroFuncionario;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Funcionario {

        private int codFuncionario;
        private String nome;
        private String valorSalario;
        private LocalDate dataAdimissao;
        private LocalDate dataAtual = LocalDate.now();


    public Funcionario() throws ParseException {
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

    public LocalDate getDataAdimissao() {
        return dataAdimissao;
    }

    public void setDataAdimissao(LocalDate dataAdimissao) {
        this.dataAdimissao = dataAdimissao;
    }


    public long tempodeEmpresa(){
        return ChronoUnit.DAYS.between(this.dataAdimissao, dataAtual);
    }


    @Override
    public String toString() {


        return "\n------Funcionario-------\nCodigo= "+codFuncionario+"\nNome: "+nome+"\nSalario: "+valorSalario+"\nTempo de empresa: "+tempodeEmpresa()+" dias";
    }
}
