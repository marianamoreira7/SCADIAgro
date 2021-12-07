package cadastrofuncionario;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ListaEncadeada {
    private Elemento inicio, fim, elemento;

    public ListaEncadeada() {
        inicio=fim=null;
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
        try {
            Funcionario funcionario = inicio.getFuncionario();
            inicio = inicio.getProximo();
            if (inicio == null) {
                fim = null;
            } else {
                inicio.setAnterior(null);
            }
            System.out.println("Funcionario Removido: \n" + funcionario +"\n");
            return funcionario;
        } catch (NullPointerException e){
            System.out.println("Não há Funcionarios para remover");
        }
    return null;
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
                this.removeFirst();
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
        boolean troca;
        Funcionario auxFuncionario;

        do {
        elemento = inicio;
        troca = false;

            while (elemento.getProximo() != null) {
                if (elemento.getFuncionario().getCodFuncionario() > elemento.getProximo().getFuncionario().getCodFuncionario()) {
                    auxFuncionario = elemento.getFuncionario();
                    elemento.setFuncionario(elemento.getProximo().getFuncionario());
                    elemento.getProximo().setFuncionario(auxFuncionario);
                    troca=true;
                    }
                elemento = elemento.getProximo();
                }
        }while (troca);
    }

    public void ordenarporOrdemAlfabetica(){
        boolean troca;
        Funcionario auxFuncionario;

        do {
            elemento = inicio;
            troca = false;

            while (elemento.getProximo() != null) {
                if (elemento.getFuncionario().getNome().compareTo(elemento.getProximo().getFuncionario().getNome())>0) {
                    auxFuncionario = elemento.getFuncionario();
                    elemento.setFuncionario(elemento.getProximo().getFuncionario());
                    elemento.getProximo().setFuncionario(auxFuncionario);
                    troca=true;
                }
                elemento = elemento.getProximo();
            }
        }while (troca);
        }

    public void infoSalario(){
        elemento = inicio;
        double somaSalario=0, maiorSalario=0;
        double menorSalario = Double.parseDouble(elemento.getFuncionario().getValorSalario());

        while (elemento != null) {
            somaSalario += Double.parseDouble(elemento.getFuncionario().getValorSalario());
                if(Double.parseDouble(elemento.getFuncionario().getValorSalario()) > maiorSalario)
                maiorSalario = Double.parseDouble(elemento.getFuncionario().getValorSalario());
            if(Double.parseDouble(elemento.getFuncionario().getValorSalario()) < menorSalario)
                menorSalario = Double.parseDouble(elemento.getFuncionario().getValorSalario());

            elemento = elemento.getProximo();
        }
        System.out.println("-------Informações de Salário-------");
        System.out.printf("Soma Salarial dos funcionarios da empresa: R$ %.2f\n", somaSalario);
        System.out.printf("Média Salarial dos funcionarios da empresa: R$ %.2f\n", somaSalario/this.size());
        System.out.printf("Maior Salário: R$ %.2f\n", maiorSalario);
        System.out.printf("Menor Salário: R$ %.2f\n", menorSalario);
        System.out.println("------------------");
    }


    public void gravar(String nomeArquivo) throws IOException {
        elemento = inicio;
        FileWriter arquivo = new FileWriter("C:\\Users\\maria\\IdeaProjects\\SCADIAgro_ex\\src\\cadastrofuncionario\\" + nomeArquivo);
        PrintWriter gravarArq = new PrintWriter(arquivo);

        while (elemento != null) {
            gravarArq.printf("CodFuncionario -> " + arrumarcodFuncionario(elemento.getFuncionario().getCodFuncionario()));
            gravarArq.printf("\nNome -> " + elemento.getFuncionario().getNome());
            gravarArq.printf("\nValorSalario -> " + elemento.getFuncionario().getValorSalario());
            gravarArq.printf("\nDataAdmissao -> " + elemento.getFuncionario().getDataAdimissao()+"\n");
            elemento = elemento.getProximo();

        }
        arquivo.close();
    }

    public void gravarArquivo() throws IOException {
        this.gravar("funcionario.dat");
        this.ordenarporCodFuncionario();
        this.gravar("funcionario_idx01.idx");
        this.ordenarporOrdemAlfabetica();
        this.gravar("funcionario_idx02.idx");

    }

    public String arrumarcodFuncionario(int codFuncionario){
        String textocodFuncionario = ""+codFuncionario;
            while (textocodFuncionario.length()<6){
                textocodFuncionario = "0" + textocodFuncionario;
            }
    return textocodFuncionario;}


}
