package ejercicio1;

import java.util.Scanner;

public class Cuadratica {

    // Método para calcular el discriminante de la ecuación cuadrática
    // Fórmula: D = b² - 4ac
    public static double getDiscriminante(double a, double b, double c) {
        return Math.pow(b, 2) - 4 * a * c;
    }
    // Método para calcular una raíz de la ecuación cuadrática
    // Si el parámetro "positiva" es verdadero, usa la suma en la fórmula; de lo contrario, usa la resta
    public static double calcularRaiz(double a, double b, double discriminante, boolean positiva) {
        return (-b + (positiva ? Math.sqrt(discriminante) : -Math.sqrt(discriminante))) / (2 * a);
    }
    // Método que resuelve la ecuación cuadrática y muestra el resultado en pantalla
    public static void resolverEcuacion(double a, double b, double c) {
        double discriminante = getDiscriminante(a, b, c);

        // Si el discriminante es mayor que 0, hay dos soluciones reales
        if (discriminante > 0) {
            double raiz1 = calcularRaiz(a, b, discriminante, true);  // Primera raíz con el signo positivo
            double raiz2 = calcularRaiz(a, b, discriminante, false); // Segunda raíz con el signo negativo
            System.out.printf("La ecuación tiene dos raíces %.6f y %.6f%n", raiz1, raiz2);
        } 
        // Si el discriminante es 0, hay una única solución real
        else if (discriminante == 0) {
            double raiz = calcularRaiz(a, b, discriminante, true); // Ambas raíces son iguales, solo calculamos una
            System.out.printf("La ecuación tiene una raíz %.6f%n", raiz);
        } 
        // Si el discriminante es negativo, no hay soluciones reales
        else {
            System.out.println("La ecuación no tiene raíces reales.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        // Se llama para resolver la ecuación cuadrática
        resolverEcuacion(a, b, c);

        // Se cierra el Scanner para evitar fugas de recursos
        scanner.close();
    }
}
