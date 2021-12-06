package cadastrofuncionario;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ListaEncadeada {
    private Elemento inicio, fim;
    Elemento elemento = inicio;

    public ListaEncadeada() {
        inicio=fim=null;
    }

    public Elemento getInicio() {
        return inicio;
    }

    public void setInicio(Elemento inicio) {
        this.inicio = inicio;
    }

    public Elemento getFim() {
        return fim;
    }

    public void setFim(Elemento fim) {
        this.fim = fim;
    }

    public boolean isEmpty(){
        return inicio == null && fim == null;
    }


    public int size(){
        elemento = inicio;
        int tamanho = 0;

        while (elemento != null) {
            tamanho++;
            elemento = elemento.getProximo();
        }
        return tamanho;}

    public void addFirst(Funcionario funcionario) {
        System.out.println("Funcionario Adicionado");
        elemento = new Elemento(funcionario);
        elemento.setProximo(inicio);
        if(inicio != null) {
            inicio.setAnterior(elemento);
        }
        inicio = elemento;
        if(fim == null) {
            fim = elemento;
        }
    }

    public void addLast(Funcionario funcionario) {
        System.out.println("Funcionario Adicionado");
        elemento = new Elemento(funcionario);
        elemento.setAnterior(fim);

        if(fim != null) {
            fim.setProximo(elemento);
        }
        fim = elemento;
        if(inicio == null) {
            inicio = elemento;
        }
    }
    public Object removeFirst() {
            Funcionario funcionario = inicio.getFuncionario();
            inicio = inicio.getProximo();
            if(inicio == null) {
                fim = null;
            } else {
                inicio.setAnterior(null);
            }
            System.out.println("Funcionario Removido: " + funcionario);
            return funcionario;

    }
    public Funcionario removeLast()  {
            Funcionario funcionario = fim.getFuncionario();
            fim = fim.getAnterior();
            if(fim == null) {
                inicio = null;
            } else {
                fim.setProximo(null);
            }
            System.out.println("Funcionario Removido: " + funcionario);
            return funcionario;

    }

    public void limpar() {
        while (!this.isEmpty()) {
            try {
                this.removeFirst();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Limpeza realizada!");
        System.out.println();
    }

    public void listar() {
        elemento = inicio;
        System.out.println();
        System.out.println("-----------Lista de Funcionarios---------------");
        while (elemento != null) {
            System.out.println(elemento.getFuncionario());
            elemento = elemento.getProximo();
        }
        System.out.println("-----------Fim da Lista---------------");
        System.out.println();
    }

    public void ordenarporCodFuncionario(){


    }

    public void ordenarporOrdemAlfabetica(){

    }

    public void infoSalario(){
        elemento = inicio;
        double somaSalario=0;

        while (elemento != null) {
            somaSalario += Double.parseDouble(elemento.getFuncionario().getValorSalario());
            elemento = elemento.getProximo();
        }
        System.out.printf("Soma Salarial dos funcionarios da empresa: R$ %.2f\n", somaSalario);
        System.out.printf("Média Salarial dos funcionarios da empresa: R$ %.2f\n", somaSalario/this.size());
    }


    public void gravarArquivo() throws IOException {
        elemento = inicio;
        FileWriter arquivo = new FileWriter("C:\\Users\\maria\\IdeaProjects\\SCADIAgro_ex\\src\\cadastrofuncionario\\funcionario.dat");
        PrintWriter gravarArq = new PrintWriter(arquivo);

        while (elemento != null) {
            elemento = this.arrumarArquivo(elemento);
            gravarArq.printf("CodFuncionario -> " + elemento.getFuncionario().getCodFuncionario());
            gravarArq.printf("\nNome -> " + elemento.getFuncionario().getNome());
            gravarArq.printf("\nValorSalario -> " + elemento.getFuncionario().getValorSalario());
            gravarArq.printf("\nDataAdmissao -> " + elemento.getFuncionario().getDataAdimissao()+"\n");
            elemento = elemento.getProximo();

        }
        arquivo.close();
    }

    public void gravarArquivocodFuncionario() throws IOException {
        elemento = inicio;
        FileWriter arquivo = new FileWriter("C:\\Users\\maria\\IdeaProjects\\SCADIAgro_ex\\src\\cadastrofuncionario\\funcionario_idx01.idx");
        PrintWriter gravarArq = new PrintWriter(arquivo);
        this.ordenarporCodFuncionario();
        while (elemento != null) {
            elemento = this.arrumarArquivo(elemento);
            gravarArq.printf("CodFuncionario -> " + elemento.getFuncionario().getCodFuncionario());
            gravarArq.printf("\nNome -> " + elemento.getFuncionario().getNome());
            gravarArq.printf("\nValorSalario -> " + elemento.getFuncionario().getValorSalario());
            gravarArq.printf("\nDataAdmissao -> " + elemento.getFuncionario().getDataAdimissao()+"\n");
            elemento = elemento.getProximo();

        }
        arquivo.close();
    }

    public void gravarArquivoNome() throws IOException {
        elemento = inicio;
        FileWriter arquivo = new FileWriter("C:\\Users\\maria\\IdeaProjects\\SCADIAgro_ex\\src\\cadastrofuncionario\\funcionario_idx02.idx");
        PrintWriter gravarArq = new PrintWriter(arquivo);
        this.ordenarporOrdemAlfabetica();
        while (elemento != null) {
            elemento = this.arrumarArquivo(elemento);
            gravarArq.printf("CodFuncionario -> " + elemento.getFuncionario().getCodFuncionario());
            gravarArq.printf("\nNome -> " + elemento.getFuncionario().getNome());
            gravarArq.printf("\nValorSalario -> " + elemento.getFuncionario().getValorSalario());
            gravarArq.printf("\nDataAdmissao -> " + elemento.getFuncionario().getDataAdimissao()+"\n");
            elemento = elemento.getProximo();

        }
        arquivo.close();
    }

    public Elemento arrumarArquivo(Elemento elemento){
        String codFuncionario = ""+elemento.getFuncionario().getCodFuncionario();
            while (codFuncionario.length()<6){
                codFuncionario = "0" + codFuncionario;
            }
            elemento.getFuncionario().setCodFuncionario(Integer.parseInt(codFuncionario));
    return elemento;}
}
