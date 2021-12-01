package CadastroFuncionario;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Sistema {
    public static void main(String[] args) throws ParseException {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner entrada = new Scanner(System.in);
        double somaSalario = 0;

        do {
            System.out.println("-------NOVO FUNCIONARIO----------");

            funcionarios.add(new Funcionario());
            System.out.println("Digite o Codigo do funcionario: ");
            funcionarios.get(funcionarios.size()-1).setCodFuncionario(entrada.nextInt());

            System.out.println("Digite o Nome do funcionario: ");
            funcionarios.get(funcionarios.size()-1).setNome(entrada.next());

            System.out.println("Digite o Valor do salário do funcionario: ");
            funcionarios.get(funcionarios.size()-1).setValorSalario(entrada.next());

            System.out.println("Digite a Data de admissão do funcionario dd/mm/aaaa: ");
            funcionarios.get(funcionarios.size()-1).setDataAdimissao(LocalDate.parse(entrada.next(), formato));


        }while (funcionarios.get(funcionarios.size()-1).getCodFuncionario()!=0);

        System.out.println("-----------INFORMAÇÕES---------------");
        System.out.println("Total de funcionarios na empresa: "+funcionarios.size());
        System.out.println("Lista de funcionarios e o tempo de empresa: "+ funcionarios);
        System.out.println("------------------");

        somaSalario = funcionarios.stream().mapToDouble(funcionario -> Double.parseDouble(funcionario.getValorSalario())).sum();

        System.out.println("Soma Salarial dos funcionarios da empresa: " + somaSalario);
        System.out.println("Média Salarial dos funcionarios da empresa: " + somaSalario/funcionarios.size());

        Comparator<Funcionario> comparadorSalario = (funcionario1, funcionario2) -> {
            if(Double.parseDouble(funcionario1.getValorSalario()) >= Double.parseDouble(funcionario2.getValorSalario())) return 1;
            if(Double.parseDouble(funcionario1.getValorSalario()) < Double.parseDouble(funcionario2.getValorSalario())) return -1;
            return 0;
        };

        System.out.println("Dados do Maior Salário: " + funcionarios.stream().max(comparadorSalario).get());
        System.out.println("Dados do Menor Salário: "+  funcionarios.stream().min(comparadorSalario).get());
        entrada.close();
    }
}
