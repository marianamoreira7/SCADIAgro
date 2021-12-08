package cadastrofuncionario;

import java.util.Scanner;

public class SistemaListaEncadeada {
    public static void main(String[] args) throws Exception {
        ListaEncadeada funcionarios = new ListaEncadeada();
        Scanner scanner = new Scanner(System.in);
        int opcao, codFuncionario;
        String nome, valorSalario, dataAdimissao;

        do {
                System.out.println("Digite o Codigo do funcionario: ");
                codFuncionario = scanner.nextInt();
                if(codFuncionario==0) break;
                System.out.println("Digite o Nome do funcionario: ");
                nome = scanner.next();

                System.out.println("Digite o Valor do salário do funcionario: ");
                valorSalario = scanner.next().replace(",", ".");

                System.out.println("Digite a Data de admissão do funcionario dd/mm/aaaa: ");
                dataAdimissao = scanner.next();
                
                    funcionarios.addLast(new Funcionario(codFuncionario, nome, valorSalario, dataAdimissao));

            }while (codFuncionario!=0);

        System.out.println("Total de funcionarios: "+funcionarios.size());

        if (funcionarios.size()!=0){

            funcionarios.infoSalario();

            do {System.out.println("Selecione a opção \n" +
                        "1->Listar Funcionarios por inserção \n" +
                        "2->Listar Funcionarios por CodFuncionario \n" +
                        "3->Listar Funcionarios por Ordem Alfabética \n" +
                        "4->Remover último funcionario \n" +
                        "5->Gravar Arquivo\n" +
                        "6->Ler Arquivo\n" +
                        "7->Sair\"");
                opcao = scanner.nextInt();

                switch (opcao){
                    case 1: funcionarios.list(); break;
                    case 2: funcionarios.orderbyCodFuncionario(); funcionarios.list(); break;
                    case 3: funcionarios.orderbyNome(); funcionarios.list(); break;
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
