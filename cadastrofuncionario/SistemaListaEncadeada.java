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

                System.out.println("Digite a Data de admissão do funcionario dd/mm/aaaa: ");
                dataAdimissao = scanner.next();

                    funcionarios.addLast(new Funcionario(codFuncionario, nome, valorSalario, dataAdimissao));

            }while (codFuncionario!=0);


            do {
                System.out.println("Selecione a opção \n1-> Remover o primeiro funcionario: \n2->Remover o último funcionario: \n3->Listagem de funcionarios: \n4->Listagem por Codigo: \n5->Listagem por Nome:\n6->Gravar Arquivo\n7->Sair\"");
                opcao = scanner.nextInt();

                if (opcao == 1) {
                    funcionarios.removeFirst();
                } else if (opcao == 2) {
                    funcionarios.removeLast();
                } else if (opcao == 3) {
                    funcionarios.listar();
                }
                else if (opcao == 4) {
                    funcionarios.ordenarporCodFuncionario();
                    funcionarios.listar();
                    funcionarios.gravarArquivo();

                }
                else if (opcao == 5) {
                    funcionarios.ordenarporOrdemAlfabetica();
                    funcionarios.listar();
                    funcionarios.gravarArquivo();

                }
                else if (opcao == 6) {
                    funcionarios.gravarArquivo();
                }
                else if (opcao == 7) {
                    break;
                }
                else {
                    System.out.println("Opcao invalida");
                }
            }while (opcao!=5);
    }
}
