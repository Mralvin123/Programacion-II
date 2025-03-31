package vectortridimensional;

import java.util.Scanner;

class vectortridimensional {
    public double x, y, z;

    // Constructor
    public vectortridimensional(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Suma de vectores
    public vectortridimensional add(vectortridimensional b) {
        return new vectortridimensional(this.x + b.x, this.y + b.y, this.z + b.z);
    }

    // Multiplicación por un escalar
    public vectortridimensional multiply(double r) {
        return new vectortridimensional(r * this.x, r * this.y, r * this.z);
    }

    // Longitud del vector
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Normalización del vector con verificación de división por cero
    public vectortridimensional normalize() {
        double len = length();
        if (len == 0) {
            System.out.println("No se puede normalizar un vector de longitud 0.");
            return new vectortridimensional(0, 0, 0);
        }
        return new vectortridimensional(x / len, y / len, z / len);
    }

    // Producto escalar
    public double dotProduct(vectortridimensional b) {
        return this.x * b.x + this.y * b.y + this.z * b.z;
    }

    // Producto vectorial
    public vectortridimensional crossProduct(vectortridimensional b) {
        return new vectortridimensional(
            this.y * b.z - this.z * b.y,
            this.z * b.x - this.x * b.z,
            this.x * b.y - this.y * b.x
        );
    }

    // Método toString para representar el vector
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el vector a : ");
        double ax = scanner.nextDouble();
        double ay = scanner.nextDouble();
        double az = scanner.nextDouble();
        vectortridimensional a = new vectortridimensional(ax, ay, az);
        
        System.out.print("Ingrese el vector b : ");
        double bx = scanner.nextDouble();
        double by = scanner.nextDouble();
        double bz = scanner.nextDouble();
        vectortridimensional b = new vectortridimensional(bx, by, bz);
        
        System.out.print("Ingrese el escalar: ");
        double r = scanner.nextDouble();
        
        // Imprimir los resultados de manera similar al primer código
        System.out.println("a + b = " + a.add(b));
        System.out.println("a * " + r + " = " + a.multiply(r));
        System.out.println("|a| = " + a.length());
        System.out.println("a normalizado = " + a.normalize());
        System.out.println("a · b = " + a.dotProduct(b));
        System.out.println("a × b = " + a.crossProduct(b));

    }
}
