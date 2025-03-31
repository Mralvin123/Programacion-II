package Ejercicio2;

import java.util.Scanner;

public class Estadistica {

    // Método para calcular el promedio de unos numeros
    public static double promedio(double[] numeros) {
        double suma = 0;
        // Se suman todos los valores en el arreglo
        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }
        // Se divide la suma total entre la cantidad de elementos
        return suma / numeros.length;
    }

    // Método para calcular la desviación estándar de un conjunto de números
    public static double desviacion(double[] numeros, double promedio) {
        double sumaDiferencias = 0;
        // Se calcula la diferencia de cada número con el promedio, se eleva al cuadrado y se suma
        for (double num : numeros) {
            sumaDiferencias += Math.pow(num - promedio, 2);
        }
        // Se usa la fórmula de la desviación estándar
        return Math.sqrt(sumaDiferencias / (numeros.length - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numeros = new double[10];

        // ingresar 10numeros
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = scanner.nextDouble();
        }

        double prom = promedio(numeros);
        double desv = desviacion(numeros, prom);

        System.out.printf("El promedio es %.2f\n", prom);
        System.out.printf("La desviación estándar es %.6f\n", desv);

        // Se cierra el scanner para evitar fugas de recursos
        scanner.close();
    }
}
