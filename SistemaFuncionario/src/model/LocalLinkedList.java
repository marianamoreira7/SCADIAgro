package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

import static javafx.collections.FXCollections.observableArrayList;

public class LocalLinkedList<T>{

    private Element<T> head, tail, element;

    public LocalLinkedList() { head=tail=null;}

    public boolean isEmpty(){
        return head == null && tail == null;
    }

    public int size(){
            element = head;
            int size = 0;
            while (element != null) {
                size++;
                element = element.getNext();
            }
            return size;
        }

        public void addFirst(T objeto) {
            element = new Element<>(objeto);
            element.setNext(head);
            if(head != null) {
                head.setPrevious(element);
            }
            head = element;
            if(tail == null) {
                tail = element;
            }
    }

        public void addLast(T objeto) {
            element = new Element(objeto);
            element.setPrevious(tail);

            if(tail != null) {
                tail.setNext(element);
                }
            tail = element;
            if(head == null) {
                head = element;
            }

        }

        public void removeFirst() {
            try {
                head = head.getNext();
                if (head == null) {
                    tail = null;
                } else {
                    head.setPrevious(null);
                } } catch (NullPointerException e){

                }
        }

        public void removebyID(int codObject) throws IOException {
            element = head;
            boolean troca = false;

            while (element != null) {

                if (element.getObjeto().getCodFuncionario() == codObject){
                    troca=true;
                }

                if(troca && element.getNext()!=null){
                        element.setObjeto(element.getNext().getObjeto());
                }
                element = element.getNext();
            }
            removeLast();
            saveFile();
        }

        public T removeLast()  {
            try {
            T object = (T) tail.getObjeto();
            tail = tail.getPrevious();
            if(tail == null) {
                head = null;
            } else {
                tail.setNext(null);
            }
            return object;
            } catch (NullPointerException e){
                return null;
            }
    }

        public void list() {
            element = head;
            System.out.println("\n-----------Lista---------------");
        while (element != null) {
            System.out.println(element.getObjeto());
            element = element.getNext();
        }
        System.out.println("-----------Fim da Lista---------------\n");
    }

        public ObservableList<Funcionario> listFuncionarios() {
            ObservableList<Funcionario> listaFuncionarios = observableArrayList();
            clear();
            readFile();
            element = head;
            while (element != null) {
                listaFuncionarios.add(element.getObjeto());
                element = element.getNext();
            }
        return FXCollections.observableArrayList(listaFuncionarios);
    }

    private String changeSalario(String salario) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(Double.parseDouble(salario));
    }

        public void clear() {
            while (!this.isEmpty()) {
            this.removeFirst();
        }
        }


    public void orderByNome(){
        element=head;
        if (element!=null){
        boolean order;
        Funcionario guardaFuncionario;
        do {
            element = head;
            order = true;
            while (element.getNext() != null) {
                if (element.getObjeto().getNome().compareTo(element.getNext().getObjeto().getNome())>0) {
                    guardaFuncionario = element.getObjeto();
                    element.setObjeto(element.getNext().getObjeto());
                    element.getNext().setObjeto(guardaFuncionario);
                    order=false;
                }
                element = element.getNext();
            }
        }while (!order);}
    }

    public void orderBycodFuncionario(){
        element=head;
        if (element!=null){
        boolean order;
        Funcionario guardaFuncionario;
        do {
            element = head;
            order = true;
            while (element.getNext() != null) {
                if (element.getObjeto().getCodFuncionario() > element.getNext().getObjeto().getCodFuncionario()) {
                    guardaFuncionario = element.getObjeto();
                    element.setObjeto(element.getNext().getObjeto());
                    element.getNext().setObjeto(guardaFuncionario);
                    order=false;
                }
                element = element.getNext();
            }
        }while (!order);}
    }

    public void infoSalario(){

        element = head;
        double somaSalario=0, maiorSalario=0;
        double menorSalario = Double.parseDouble(element.getObjeto().getValorSalario());
        while (element != null) {
            somaSalario += Double.parseDouble(element.getObjeto().getValorSalario());

            if(Double.parseDouble(element.getObjeto().getValorSalario()) > maiorSalario)
                maiorSalario = Double.parseDouble(element.getObjeto().getValorSalario());
            if(Double.parseDouble(element.getObjeto().getValorSalario()) < menorSalario)
                menorSalario = Double.parseDouble(element.getObjeto().getValorSalario());

            element = element.getNext();
        }
        System.out.println("-------Informações de Salário-------");
        System.out.printf("Soma Salarial dos Objetos da empresa: R$ %.2f\n", somaSalario);
        System.out.printf("Média Salarial dos Objetos da empresa: R$ %.2f\n", somaSalario/this.size());
        System.out.printf("Maior Salário: R$ %.2f\n", maiorSalario);
        System.out.printf("Menor Salário: R$ %.2f\n", menorSalario);
        System.out.println("------------------");
    }

    public String somaSalario(){
        element = head;
        double somaSalario=0;
        while (element != null) {
            somaSalario += Double.parseDouble(element.getObjeto().getValorSalario());
            element = element.getNext();
        }
        return String.valueOf(somaSalario);
    }

    public String mediaSalario(){
        return String.valueOf(Double.parseDouble(this.somaSalario())/this.size());
    }

    public String maiorSalario(){
        element = head;
        double maiorSalario=0;
        while (element != null) {
            if(Double.parseDouble(element.getObjeto().getValorSalario()) > maiorSalario)
                maiorSalario = Double.parseDouble(element.getObjeto().getValorSalario());
            element = element.getNext();
        }
        return String.valueOf(maiorSalario);
    }

    public T maiorSalario2(){
        element = head;
        T funcionarioMaiorSalario = null;
        double maiorSalario=0;
        while (element != null) {
            if(Double.parseDouble(element.getObjeto().getValorSalario()) >= maiorSalario){
                maiorSalario = Double.parseDouble(element.getObjeto().getValorSalario());
                funcionarioMaiorSalario = (T) element.getObjeto();}
            element = element.getNext();
        }
        return funcionarioMaiorSalario;
    }

    public String menorSalario(){
        element = head;
        double menorSalario = Double.parseDouble(element.getObjeto().getValorSalario());
        while (element != null) {
            if(Double.parseDouble(element.getObjeto().getValorSalario()) <= menorSalario)
                menorSalario = Double.parseDouble(element.getObjeto().getValorSalario());
            element = element.getNext();
        }
        return String.valueOf(menorSalario);
    }

    public T menorSalario2(){
        element = head;
        T funcionarioMenorSalario = null;
        double menorSalario = Double.parseDouble(element.getObjeto().getValorSalario());
        while (element != null) {
            if(Double.parseDouble(element.getObjeto().getValorSalario()) <= menorSalario){
                menorSalario = Double.parseDouble(element.getObjeto().getValorSalario());
                funcionarioMenorSalario = (T) element.getObjeto();
            }
            element = element.getNext();
        }
        return funcionarioMenorSalario;
    }

    private void createFile(String nomeArquivo) throws IOException {
        element = head;
        FileWriter arquivo = new FileWriter("C:\\Users\\maria\\IdeaProjects\\SistemaFuncionario\\src\\model\\file\\" + nomeArquivo);
        PrintWriter gravarArq = new PrintWriter(arquivo);

        while (element != null) {
            gravarArq.printf("CodFuncionario -> " + arrangeCodFuncionario(element.getObjeto().getCodFuncionario()));
            gravarArq.printf("\nNome -> " + arrangeNomeFuncionario(element.getObjeto().getNome()));
            gravarArq.printf("\nValorSalario -> " + arrangeValorSalario(element.getObjeto().getValorSalario()));
            gravarArq.printf("\nDataAdmissao -> " + element.getObjeto().getDataAdmissao()+"\n");
            element = element.getNext();

        }
        arquivo.close();
    }


    public void saveFile() {
        try {
            this.createFile("funcionario.dat");
            this.orderBycodFuncionario();
            this.createFile("funcionario_idx01.idx");
            this.orderByNome();
            this.createFile("funcionario_idx02.idx");
        } catch (NullPointerException | IOException e ){
            System.out.println(e);
        }

    }

    public void readFile() {
        try {
            FileReader file = new FileReader("C:\\Users\\maria\\IdeaProjects\\SistemaFuncionario\\src\\model\\file\\funcionario.dat");
            Scanner in = new Scanner(file);
            this.addbyArq(in);
        } catch (FileNotFoundException e){

        }

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
                this.addLast((T) new Funcionario(codFuncionario, nomeFuncionario, valorSalario, dataAdmissao));
            }

        }
    }


    private String arrangeCodFuncionario(int codFuncionario){
        String textocodFuncionario = ""+codFuncionario;
        while (textocodFuncionario.length()<6){
            textocodFuncionario = '0' + textocodFuncionario;
        }
        return textocodFuncionario;}

    private String arrangeNomeFuncionario(String nomeFuncionario){
        while (nomeFuncionario.length()<100){
            nomeFuncionario = '0' + nomeFuncionario;
        }
        return nomeFuncionario;}

    private String arrangeValorSalario(String valorSalario){
        DecimalFormat decimalFormat = new DecimalFormat("0000000000000.00");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(Double.parseDouble(valorSalario)).replace(",",".");
    }
    

    public boolean checkCod(String cod){
        try{
            int codFuncionario = Integer.parseInt(cod);
        element = head;
        while (element != null) {
            if(codFuncionario==element.getObjeto().getCodFuncionario()){
                return false;
            }
            element = element.getNext();
        } }catch (NumberFormatException e){
        }
        return true;
    }

}
