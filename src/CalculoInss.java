import java.util.Scanner;
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
