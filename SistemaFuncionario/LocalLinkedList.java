package SistemaFuncionario;

import java.io.*;
import java.util.Scanner;

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
            element = new Element(objeto);
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
                T object = (T) head.getObjeto();
                head = head.getNext();
                if (head == null) {
                    tail = null;
                } else {
                    head.setPrevious(null);
                }
                System.out.println("Removido: \n" + object +"\n");
                } catch (NullPointerException e){
                System.out.println("Não há nenhum registro para remover");
                }
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
            System.out.println("Removido: \n" + object +"\n");
            return object;
            } catch (NullPointerException e){
                System.out.println("Não há nenhum registro para remover");
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

        public void clear() {
            while (!this.isEmpty()) {
            this.removeFirst();
        }
        }


    public void orderByNome(){
        boolean order;
        Funcionario guardaFuncionario;
        do {
            element = head;
            order = true;
            while (element.getNext() != null) {
                if (element.getObjeto().getNome().compareTo(element.getNext().getObjeto().getNome())>0) {
                    guardaFuncionario = element.getObjeto();
                    element.setObjeto((T) element.getNext().getObjeto());
                    element.getNext().setObjeto(guardaFuncionario);
                    order=false;
                }
                element = element.getNext();
            }
        }while (!order);
    }

    public void orderBycodFuncionario(){
        boolean order;
        Funcionario guardaFuncionario;
        do {
            element = head;
            order = true;
            while (element.getNext() != null) {
                if (element.getObjeto().getCodFuncionario() > element.getNext().getObjeto().getCodFuncionario()) {
                    guardaFuncionario = element.getObjeto();
                    element.setObjeto((T) element.getNext().getObjeto());
                    element.getNext().setObjeto(guardaFuncionario);
                    order=false;
                }
                element = element.getNext();
            }
        }while (!order);
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


    private void createFile(String nomeArquivo) throws IOException {
        element = head;
        FileWriter arquivo = new FileWriter("C:\\Users\\maria\\IdeaProjects\\SCADIAgro_ex\\src\\SistemaFuncionario\\" + nomeArquivo);
        PrintWriter gravarArq = new PrintWriter(arquivo);

        while (element != null) {
            gravarArq.printf("CodFuncionario -> " + arrumarCodFuncionario(element.getObjeto().getCodFuncionario()));
            gravarArq.printf("\nNome -> " + arrumarNomeFuncionario(element.getObjeto().getNome()));
            gravarArq.printf("\nValorSalario -> " + arrumarValorSalario(element.getObjeto().getValorSalario()));
            gravarArq.printf("\nDataAdmissao -> " + element.getObjeto().getDataAdimissao()+"\n");
            element = element.getNext();

        }
        arquivo.close();
    }


    public void saveFile() throws IOException {
        try {
            this.createFile("funcionario.dat");
            this.orderBycodFuncionario();
            this.createFile("funcionario_idx01.idx");
            this.orderByNome();
            this.createFile("funcionario_idx02.idx");
        } catch (NullPointerException e ){
            System.out.println("Não Há Registros para gravar");
        }

    }

    public void readFile() {
        try {
            FileReader file = new FileReader("C:\\Users\\maria\\IdeaProjects\\SCADIAgro_ex\\src\\SistemaFuncionario\\funcionario.dat");
            Scanner in = new Scanner(file);
            this.addbyArq(in);
        } catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
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


    private String arrumarCodFuncionario(int codFuncionario){
        String textocodFuncionario = ""+codFuncionario;
        while (textocodFuncionario.length()<6){
            textocodFuncionario = '0' + textocodFuncionario;
        }
        return textocodFuncionario;}

    private String arrumarNomeFuncionario(String nomeFuncionario){
        while (nomeFuncionario.length()<100){
            nomeFuncionario = '0' + nomeFuncionario;
        }
        return nomeFuncionario;}

    private String arrumarValorSalario(String valorSalario){
        while (valorSalario.length()<16){
            valorSalario = '0' + valorSalario;
        }
        return valorSalario;}
    


}
