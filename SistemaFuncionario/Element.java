package SistemaFuncionario;

public class Element<T>{
    private Element next, previous;
    private Funcionario funcionario;

    public Element(T objeto) {
        this.funcionario = (Funcionario) objeto;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public Element getPrevious() {
        return previous;
    }

    public void setPrevious(Element previous) {
        this.previous = previous;
    }

    public Funcionario getObjeto() {
        return funcionario;
    }

    public void setObjeto(T objeto) {
        this.funcionario = (Funcionario) objeto;
    }

}
