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

        System.out.println("Total de funcionarios: "+funcionarios.size());
            do {
                System.out.println("Selecione a opção \n" +
                        "1->Listar Funcionarios \n" +
                        "2->Remover algum funcionario \n" +
                        "3->Salários: \n" +
                        "4->Gravar Arquivo\n" +
                        "5->Sair\"");
                opcao = scanner.nextInt();

                if (opcao == 1) {
                    System.out.println("Selecione a opção \n" +
                            "1->Listar por CodFuncionario \n" +
                            "2->Listar por Nome \n");
                    opcao = scanner.nextInt();

                    if (opcao==1){
                        funcionarios.ordenarporCodFuncionario();
                    }
                    if (opcao==2){
                        funcionarios.ordenarporOrdemAlfabetica();
                    }
                        funcionarios.listar();

                } else if (opcao == 2) {
                    System.out.println("Selecione a opção \n" +
                            "1->Remover o primeiro \n" +
                            "2->Remover o ultimo \n");
                    opcao = scanner.nextInt();

                    if (opcao==1){
                        funcionarios.removeFirst();
                    }
                    if (opcao==2){
                        funcionarios.removeLast();
                    }

                } else if (opcao == 3) {
                    funcionarios.infoSalario();
                }
                else if (opcao == 4) {
                    funcionarios.gravarArquivo();
                    funcionarios.gravarArquivocodFuncionario();
                    funcionarios.gravarArquivoNome();
                }

                else if (opcao == 5) {
                    break;
                }
                else {
                    System.out.println("Opcao invalida");
                }
            }while (opcao!=5);
    }
}
