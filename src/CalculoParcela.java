import java.util.Scanner;

public class CalculoParcela {
    public static void main(String[] args){
        Scanner en = new Scanner(System.in);
        System.out.print("Valor financiado em R$: ");
        double valor = en.nextDouble();
        System.out.print("Numero de parcelas: ");
        double parcelas = en.nextDouble();
        double soma=0;

        System.out.println("--------------");
        System.out.println("PARCELAS");
        System.out.println("--------------");

        for(int i=0; i<parcelas;i++){
            System.out.format("Parcela "+(i+1)+" : R$ %.2f\n", valor/parcelas);
            soma+=valor/parcelas;
        }
        System.out.println("--------------");
        System.out.format("Total .....: R$ %.2f",soma);
        en.close();
    }
}
