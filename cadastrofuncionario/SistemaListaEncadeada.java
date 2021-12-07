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
                valorSalario = scanner.next();

                //System.out.println("Digite a Data de admissão do funcionario dd/mm/aaaa: ");
                //dataAdimissao = scanner.next();
                dataAdimissao = "12/12/2020";
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
                        "6->Sair\"");
                opcao = scanner.nextInt();

                switch (opcao){
                    case 1: funcionarios.listar(); break;
                    case 2: funcionarios.ordenarporCodFuncionario(); funcionarios.listar(); break;
                    case 3: funcionarios.ordenarporOrdemAlfabetica(); funcionarios.listar(); break;
                    case 4: funcionarios.removeFirst(); break;
                    case 5: funcionarios.gravarArquivo(); break;
                    case 6: break;
                    default: System.out.println("Opcão inválida"); break;
                }
                System.out.println("---------------");
            }while (opcao!=6);
    }
    }
}
