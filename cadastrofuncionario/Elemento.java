package cadastrofuncionario;

public class Elemento  {
    private Elemento anterior, proximo;
    private Funcionario funcionario;

    public Elemento(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Elemento getAnterior() {
        return anterior;
    }

    public void setAnterior(Elemento anterior) {
        this.anterior = anterior;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }

    public Funcionario getFuncionario() { return funcionario; }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }


}
