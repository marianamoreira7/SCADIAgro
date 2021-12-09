package cadastrofuncionario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
    public void removeFirst() {
        try {
            Funcionario funcionario = inicio.getFuncionario();
            inicio = inicio.getProximo();
            if (inicio == null) {
                fim = null;
            } else {
                inicio.setAnterior(null);
            }
            System.out.println("Funcionario Removido: \n" + funcionario +"\n");
        } catch (NullPointerException e){
            System.out.println("Não há Funcionarios para remover");
        }
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

    public void clean() {
        while (!this.isEmpty()) {
                this.removeFirst();
        }

        System.out.println("Limpeza realizada!");
        System.out.println();
    }

    public void list() {
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

    public void orderbyCodFuncionario(){
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

    public void orderbyNome(){
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


    public void createFile(String nomeArquivo) throws IOException {
        elemento = inicio;
        FileWriter arquivo = new FileWriter("C:\\Users\\maria\\IdeaProjects\\SCADIAgro_ex\\src\\cadastrofuncionario\\" + nomeArquivo);
        PrintWriter gravarArq = new PrintWriter(arquivo);

        while (elemento != null) {
            gravarArq.printf("CodFuncionario -> " + arrumarCodFuncionario(elemento.getFuncionario().getCodFuncionario()));
            gravarArq.printf("\nNome -> " + arrumarNomeFuncionario(elemento.getFuncionario().getNome()));
            gravarArq.printf("\nValorSalario -> " + arrumarValorSalario(elemento.getFuncionario().getValorSalario()));
            gravarArq.printf("\nDataAdmissao -> " + elemento.getFuncionario().getDataAdimissao()+"\n");
            elemento = elemento.getProximo();

        }
        arquivo.close();
    }


    public void saveFile() throws IOException {
        this.createFile("funcionario.dat");
        this.orderbyCodFuncionario();
        this.createFile("funcionario_idx01.idx");
        this.orderbyNome();
        this.createFile("funcionario_idx02.idx");

    }

    public void readFile() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("C:\\Users\\maria\\IdeaProjects\\SCADIAgro_ex\\src\\cadastrofuncionario\\funcionario.dat"));
        this.addbyArq(in);
    }

    public void addbyArq(Scanner in) {
        int contLine=0;
        String nomeFuncionario = null, valorSalario = null, dataAdmissao = null;
        int codFuncionario = 0;

        while (in.hasNextLine()) {
        String line = in.nextLine();
        contLine++;
        if (line.startsWith("CodFuncionario -> ")) {
            int indice = 18;
            while (line.charAt(indice) == '0') {
                indice++;
            }
            codFuncionario = Integer.parseInt(line.substring(indice));
        }
        if (line.startsWith("Nome -> ")) {
            int indice = 8;
            while (line.charAt(indice) == '0') {
                indice++;
            }
            nomeFuncionario = line.substring(indice);

        }
        if (line.startsWith("ValorSalario -> ")) {
            int indice = 16;
            while (line.charAt(indice) == '0') {
                indice++;
            }
            valorSalario = line.substring(indice);

        }
        if (line.startsWith("DataAdmissao -> ")) {
            String dia,mes,ano;
            dataAdmissao = line.substring(16);
            ano = dataAdmissao.substring(0,4);
            mes = dataAdmissao.substring(5,7);
            dia = dataAdmissao.substring(8,10);
            dataAdmissao = dia+"/"+mes+"/"+ano;
           }

        if(contLine%4==0){
            this.addLast(new Funcionario(codFuncionario, nomeFuncionario, valorSalario, dataAdmissao));
        }

    }
    }


    public String arrumarCodFuncionario(int codFuncionario){
        String textocodFuncionario = ""+codFuncionario;
            while (textocodFuncionario.length()<6){
                textocodFuncionario = '0' + textocodFuncionario;
            }
    return textocodFuncionario;}

    public String arrumarNomeFuncionario(String nomeFuncionario){
        while (nomeFuncionario.length()<100){
            nomeFuncionario = '0' + nomeFuncionario;
        }
        return nomeFuncionario;}

    public String arrumarValorSalario(String valorSalario){
        while (valorSalario.length()<16){
            valorSalario = '0' + valorSalario;
        }
        return valorSalario;}


}
