import java.awt.*;
import java.util.Scanner;
public class vari {
    public static void main(String[] args) {
        Scanner probando = new Scanner(System.in);
        double[] numeros = {10, 20, 30, 40, 50};
        double sumv = 0, sumcuadrado = 0;
        int cod = 0;
        System.out.println("Aca para ingresar el pedido de codigo");
        cod = probando.nextInt();
        //Imprime los numeros repetidos? no se si es al pedo jaj lo podemos quitar
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(i + ": " + numeros[i]);
        }
        //CODIGO VARIANZA conte el codigo con lo de mis notas, pero si esta mal lo pueden cambiar
        if (cod == 4 || cod == 5) {
            for (int i = 0; i < numeros.length; i++) {
                sumv = sumv + numeros[i];
            }
            double mediav = sumv / numeros.length;
            for (int i = 0; i < numeros.length; i++) {
                double restav = numeros[i] - mediav;
                sumcuadrado = sumcuadrado + (restav * restav);
            }
            double varianza = sumcuadrado / numeros.length;
            if (cod == 4) {
                System.out.println("Varianza:" + varianza);
            } else if (cod == 5) {
                double desvest = Math.sqrt(varianza);
                System.out.println("Desviación Estándar:" + desvest);
            }
        }
    }
}
