import java.util.Scanner;
public class CalculoInss2 {
        public static void main(String[] args){
            Scanner en = new Scanner(System.in);
            System.out.print("Digite o valor do seu salário em R$:" );
            double salario = en.nextDouble();
            double imposto=0;

            if(salario <=1100)
                imposto = 0.075*salario;

            else if(salario <=2203.48)
                imposto = (salario-1100)*0.09+1100*0.075;

            else if(salario <=3305.22)
                imposto = (salario-2203.49)*0.12+1103.48*0.09+1100*0.075;

            else if(salario <=6433.57)
                imposto = (salario-3305.23)*0.14+1101.73*0.12+1103.48*0.09+1100*0.075;

            else if(salario >6433.57)
                imposto = 0.14*6433.57;

            else System.out.println("Salario invalido");

            System.out.format("Seu imposto do inss é R$ %.2f",imposto);
            en.close();

        }

    }


