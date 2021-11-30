import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CalculoParcela {
    public static void main(String[] args){
        Scanner en = new Scanner(System.in);
        BigDecimal diferenca, somaFinal;

        System.out.print("Valor financiado em R$: ");
        BigDecimal valorFinanciado = en.nextBigDecimal();

        System.out.print("Numero de parcelas: ");
        BigDecimal nroParcelas = en.nextBigDecimal();

        System.out.println("--------------");
        System.out.println("PARCELAS");
        System.out.println("--------------");


        BigDecimal valorParcela = valorFinanciado.divide(nroParcelas,2, RoundingMode.FLOOR);
        somaFinal = valorParcela.multiply(nroParcelas);
        diferenca = valorFinanciado.subtract(somaFinal);

        for(int i=1; i<=nroParcelas.intValue();i++) {
            if (somaFinal.compareTo(valorFinanciado)!=0 && i==nroParcelas.intValue()){
                System.out.println("Parcela " + i + " : R$ "+valorParcela.add(diferenca));
            }
            else System.out.println("Parcela " + i + " : R$ "+valorParcela);
        }

        System.out.println("--------------");
        System.out.format("Total .....: R$ %.2f", somaFinal.add(diferenca));
        en.close();
    }
}