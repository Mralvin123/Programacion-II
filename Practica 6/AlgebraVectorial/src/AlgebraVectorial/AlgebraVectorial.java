package AlgebraVectorial;

import java.util.Scanner;

class AlgebraVectorial {
    public double x, y, z;

    // Sobrecarga de constructores
    public AlgebraVectorial() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public AlgebraVectorial(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public AlgebraVectorial sumar(AlgebraVectorial v) {
        return new AlgebraVectorial(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public AlgebraVectorial restar(AlgebraVectorial v) {
        return new AlgebraVectorial(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    public double norma() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double productoEscalar(AlgebraVectorial v) {
        return (this.x * v.x) + (this.y * v.y) + (this.z * v.z);
    }

    public AlgebraVectorial productoVectorial(AlgebraVectorial v) {
        return new AlgebraVectorial(
            this.y * v.z - this.z * v.y,
            this.z * v.x - this.x * v.z,
            this.x * v.y - this.y * v.x
        );
    }

    public AlgebraVectorial proyeccionSobre(AlgebraVectorial v) {
        double factor = this.productoEscalar(v) / (v.norma() * v.norma());
        return new AlgebraVectorial(v.x * factor, v.y * factor, v.z * factor);
    }

    public double componenteEn(AlgebraVectorial v) {
        return this.productoEscalar(v) / v.norma();
    }

    public boolean esPerpendicular(AlgebraVectorial v) {
        double normaSuma = this.sumar(v).norma();
        double normaResta = this.restar(v).norma();
        return Math.abs(normaSuma - normaResta) < 1e-9; // Comparación con margen de error
    }

    public boolean esParalelo(AlgebraVectorial v) {
        AlgebraVectorial productoCruzado = this.productoVectorial(v);
        return productoCruzado.x == 0 && productoCruzado.y == 0 && productoCruzado.z == 0;
    }

    public void imprimir() {
        System.out.printf("(%.2f, %.2f, %.2f)%n", x, y, z);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca el vector a: ");
        double a1 = scanner.nextDouble();
        double b1 = scanner.nextDouble();
        double c1 = scanner.nextDouble();
        AlgebraVectorial vecA = new AlgebraVectorial(a1, b1, c1);

        System.out.println("Introduzca el vector b: ");
        double a2 = scanner.nextDouble();
        double b2 = scanner.nextDouble();
        double c2 = scanner.nextDouble();
        AlgebraVectorial vecB = new AlgebraVectorial(a2, b2, c2);

        AlgebraVectorial resultadoSuma = vecA.sumar(vecB);
        System.out.println("a+b:");
        resultadoSuma.imprimir();

        AlgebraVectorial resultadoResta = vecA.restar(vecB);
        System.out.println("a-b:");
        resultadoResta.imprimir();

        double productoPunto = vecA.productoEscalar(vecB);
        System.out.println("Producto escalar (a·b): " + productoPunto);

        System.out.println("Perpendicularidad:");
        if (vecA.esPerpendicular(vecB)) {
            System.out.println("a y b son ortogonales (perpendiculares)");
        } else {
            System.out.println("a y b no son ortogonales");
        }

        System.out.println("Paralelismo:");
        if (vecA.esParalelo(vecB)) {
            System.out.println("a y b son paralelos");
        } else {
            System.out.println("a y b no son paralelos");
        }

        System.out.println("Proyección de a sobre b:");
        AlgebraVectorial proyeccion = vecA.proyeccionSobre(vecB);
        proyeccion.imprimir();

        System.out.println("Componente de a en la dirección de b:");
        System.out.printf("%.2f%n", vecA.componenteEn(vecB));
    }
}
