package SistemaFuncionario;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SystemFuncionario {

    public static void main(String[] args) throws IOException {

        LocalLinkedList<Funcionario> funcionarios = new LocalLinkedList<>();

        Scanner scanner = new Scanner(System.in);
        int opcao, codFuncionario = 0;
        String nome, valorSalario, dataAdimissao;


        System.out.println("Você gostaria de:\n"+
                "1->Adicionar Funcionario\n" +
                "2->Ler Arquivo\n");
        opcao = scanner.nextInt();
        if (opcao==1) {

            do {
                try {
                    System.out.println("Digite o Codigo do funcionario: ");
                    codFuncionario = scanner.nextInt();
                    scanner.nextLine();
                    if (codFuncionario == 0) break;

                }catch (InputMismatchException e){
                    System.out.println("Formato errado");}

                System.out.println("Digite o Nome do funcionario: ");
                nome = scanner.nextLine();

                System.out.println("Digite o Valor do salário do funcionario: ");
                valorSalario = scanner.next().replace(",", ".");

                    /*
                    System.out.println("Digite a Data de admissão do funcionario dd/mm/aaaa: ");
                    dataAdimissao = scanner.next();
                    */
                dataAdimissao = "12/01/2020";
                funcionarios.addLast(new Funcionario(codFuncionario, nome, valorSalario, dataAdimissao));

            } while (codFuncionario != 0);
        }

        if (opcao==2)funcionarios.readFile();
        else System.out.println("Opção Invalida");

        if (funcionarios.size()!=0){

            System.out.println("-------------------");
            System.out.println("Total de funcionarios: "+funcionarios.size());
            System.out.println("-------------------");
            funcionarios.infoSalario();

            do {System.out.println("Selecione a opção \n" +
                    "1->Listar Funcionarios por inserção \n" +
                    "2->Listar Funcionarios por CodFuncionario \n" +
                    "3->Listar Funcionarios por Ordem Alfabética \n" +
                    "4->Remover último funcionario \n" +
                    "5->Gravar Arquivo\n" +
                    "6->Ler Arquivo\n" +
                    "7->Sair\n");
                opcao = scanner.nextInt();

                switch (opcao){
                    case 1: funcionarios.list(); break;
                    case 2: funcionarios.orderBycodFuncionario(); funcionarios.list(); break;
                    case 3: funcionarios.orderByNome(); funcionarios.list(); break;
                    case 4: funcionarios.removeFirst(); break;
                    case 5: funcionarios.saveFile(); break;
                    case 6: funcionarios.readFile(); break;
                    case 7: break;
                    default: System.out.println("Opcão inválida"); break;
                }
                System.out.println("---------------");
            }while (opcao!=7);
        }



    }
}