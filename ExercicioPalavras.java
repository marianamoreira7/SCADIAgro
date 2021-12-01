import java.util.Scanner;

public class ExercicioPalavras {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o texto: ");
        String texto = entrada.nextLine();
        String[] palavras = texto.replace(",","").split(" ");
        String[] palavrasComVirgula = texto.split(" ");

        int quantidadePalavras;

            System.out.println("Quantidade de caracteres (descontando os espaços): \n"+ texto.replace(" ", "").length());

            System.out.println("Quantidade de palavras: \n"+palavras.length);

            System.out.println("Cada palavra e o quantas vezes ela aparece no texto:");

                for (String palavra: palavras) {
                    quantidadePalavras=0;
                    for (String comparacao:palavras) {
                        if(comparacao.equals(palavra)){
                            quantidadePalavras++;
                        }
                    }
                    System.out.println("Palavra: "+palavra+" Quantidade: "+quantidadePalavras);
                }

            System.out.print("Texto na ordem inversa: \n");

                for (int i=texto.length()-1; i>=0;i--){
                    System.out.print(texto.charAt(i));
                }
                System.out.println();

            System.out.println("Texto palavra por palavra na ordem inversa:");

                for (int i= palavras.length-1; i>=0;i--){
                    System.out.print(palavrasComVirgula[i]+" ");
                }

            entrada.close();
    }
}
