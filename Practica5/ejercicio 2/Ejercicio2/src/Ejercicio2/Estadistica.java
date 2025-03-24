package Ejercicio2;

import java.util.Scanner;

public class Estadistica {
    public static double promedio(double[] numeros) {
        double suma = 0;
        for  (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }
        return suma / numeros.length;
    }

    public static double desviacion(double[] numeros, double promedio) {
        double sumaDiferencias = 0;
        for (double num : numeros) {
            sumaDiferencias += Math.pow(num - promedio, 2);
        }
        return Math.sqrt(sumaDiferencias / (numeros.length - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numeros = new double[10];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = scanner.nextDouble();
        }

        double prom = promedio(numeros);
        double desv = desviacion(numeros, prom);

        System.out.printf("El promedio es %.2f\n", prom);
        System.out.printf("La desviación estándar es %.6f\n", desv);

        scanner.close();
    }
}