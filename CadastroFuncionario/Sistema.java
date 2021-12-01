
package CadastroFuncionario;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) throws ParseException {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        double somaSalario;
        int codFuncionario;

        do{
            System.out.println("-------NOVO FUNCIONARIO----------");
            System.out.println("Digite o Codigo do funcionario: ");
            codFuncionario = entrada.nextInt();
                if(codFuncionario==0) break;
            funcionarios.add(new Funcionario(codFuncionario));
            System.out.println("Digite o Nome do funcionario: ");
            funcionarios.get(funcionarios.size()-1).setNome(entrada.next());

            System.out.println("Digite o Valor do salário do funcionario: ");
            funcionarios.get(funcionarios.size()-1).setValorSalario(entrada.next());

            System.out.println("Digite a Data de admissão do funcionario dd/mm/aaaa: ");
            funcionarios.get(funcionarios.size()-1).setDataAdimissao(entrada.next());

        } while(codFuncionario!=0);

        System.out.println("-----------INFORMAÇÕES---------------");
        System.out.println("Total de funcionarios na empresa: "+funcionarios.size());

        if(!funcionarios.isEmpty()){

        System.out.println("Lista de funcionarios e o tempo de empresa: "+ funcionarios);
        System.out.println("------------------");

        somaSalario = funcionarios.stream().mapToDouble(funcionario -> Double.parseDouble(funcionario.getValorSalario())).sum();

        System.out.printf("Soma Salarial dos funcionarios da empresa: R$ %.2f\n", somaSalario);
        System.out.printf("Média Salarial dos funcionarios da empresa: R$ %.2f\n", somaSalario/funcionarios.size());

        Comparator<Funcionario> comparadorSalario = (funcionario1, funcionario2) -> {
            if(Double.parseDouble(funcionario1.getValorSalario()) >= Double.parseDouble(funcionario2.getValorSalario())) return 1;
            if(Double.parseDouble(funcionario1.getValorSalario()) < Double.parseDouble(funcionario2.getValorSalario())) return -1;
            return 0;
        };

        System.out.println("------------------");
        System.out.println("Dados do Funcionario de Maior Salário: " + funcionarios.stream().max(comparadorSalario).get());
        System.out.println("------------------");
        System.out.println("Dados do Funcionario de Menor Salário: "+  funcionarios.stream().min(comparadorSalario).get());
        }
        entrada.close();


    }
}
