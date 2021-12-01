import java.util.Scanner;
public class CalculoInss {
    public static void main(String[] args){
        Scanner en = new Scanner(System.in);
        System.out.print("Digite o valor do seu salário em R$:" );
        double salario = en.nextDouble();
        double impostoInss=0, faixa1=1100, faixa2=2203.48, faixa3=3305.22, faixa4=6433.57;
        double porcentagem1 = 0.075, porcentagem2 = 0.09, porcentagem3 = 0.12, porcentagem4=0.14;
        double imposto=0;

        if(salario <=faixa1)
            imposto = porcentagem1*salario;

        else if(salario <=faixa2)
            imposto = porcentagem2*salario;

        else if(salario <=faixa3)
            imposto = porcentagem3*salario;

        else if(salario <=faixa4)
            imposto = porcentagem4*salario;

        else if(salario >faixa4)
            imposto = faixa4*porcentagem4;

        System.out.format("Seu imposto do inss é R$ %.2f",imposto);
        en.close();

    }

}