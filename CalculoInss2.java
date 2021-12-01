import java.util.Scanner;
public class CalculoInss2 {
    public static void main(String[] args){
        Scanner en = new Scanner(System.in);
        System.out.print("Digite o valor do seu salário em R$:" );
        double salario = en.nextDouble();
        double impostoInss=0, faixa1=1100, faixa2=2203.48, faixa3=3305.22, faixa4=6433.57;
        double porcentagem1 = 0.075, porcentagem2 = 0.09, porcentagem3 = 0.12, porcentagem4=0.14;
        double maximoImposto1= faixa1*porcentagem1;
        double maximoImposto2= faixa2*porcentagem2;
        double maximoImposto3= faixa3*porcentagem3;
        double maximoImposto4= faixa4*porcentagem4;


        if(salario <=faixa1)
            impostoInss = salario*porcentagem1;

        else if(salario <=faixa2)
            impostoInss += (salario-faixa1)*porcentagem2+maximoImposto1;

        else if(salario <=faixa3)
            impostoInss += (salario-faixa2)*porcentagem3+maximoImposto2+maximoImposto1;

        else if(salario <=faixa4)
            impostoInss = (salario-faixa3)*porcentagem4+maximoImposto3+maximoImposto2+maximoImposto1;

        else if(salario > faixa4)
            impostoInss = maximoImposto4;

        else System.out.println("Salario invalido");

        System.out.format("Seu imposto do inss é R$ %.2f",impostoInss);
        en.close();

    }

}
