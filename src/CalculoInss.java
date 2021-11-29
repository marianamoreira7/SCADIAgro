import java.util.Scanner;

/*Realizar a leitura do salário do colaborador e calcular o valor do INSS de acordo com a tabela de valores abaixo :
        Salário do contribuinte Alíquota de INSS
        Até R$ 1.100 7,5%
        De R$ 1.100,01 a R$ 2.203,48 9%
        De R$ 2.203,49 até R$ 3.305,22 12%
        De R$ 3.305,23 até R$ 6.433,57 14%
*/
public class CalculoInss {
    public static void main(String[] args){
        Scanner en = new Scanner(System.in);
        System.out.print("Digite o valor do seu salário em R$:" );
        double salario = en.nextDouble();
        double imposto=0;

        if(salario <=1100)
            imposto = 0.075*salario;

       else if(salario <=2203.48)
            imposto = 0.09*salario;

       else if(salario <=3305.22)
            imposto = 0.12*salario;

       else if(salario <=6433.57)
            imposto = 0.14*salario;

       System.out.format("Seu imposto do inss é R$ %.2f",imposto);
       en.close();

    }

}
