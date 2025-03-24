package ejercicio1;

import java.util.Scanner;

public class Cuadratica {

    public static double getDiscriminante(double a, double b, double c) {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public static double calcularRaiz(double a, double b, double discriminante, boolean positiva) {
        return (-b + (positiva ? Math.sqrt(discriminante) : -Math.sqrt(discriminante))) / (2 * a);
    }

    public static void resolverEcuacion(double a, double b, double c) {
        double discriminante = getDiscriminante(a, b, c);

        if (discriminante > 0) {
            double raiz1 = calcularRaiz(a, b, discriminante, true);
            double raiz2 = calcularRaiz(a, b, discriminante, false);
            System.out.printf("La ecuación tiene dos raíces %.6f y %.6f%n", raiz1, raiz2);
        } else if (discriminante == 0) {
            double raiz = calcularRaiz(a, b, discriminante, true);
            System.out.printf("La ecuación tiene una raíz %.6f%n", raiz);
        } else {
            System.out.println("La ecuación no tiene raíces reales.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        resolverEcuacion(a, b, c);
        scanner.close();
    }
}
