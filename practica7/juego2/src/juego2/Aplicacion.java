package juego2;

public class Aplicacion {

    public static void main(String[] args) {
        // Crear instancias de los tres juegos
        JuegoAdivinaNumero juego1 = new JuegoAdivinaNumero(3);
        JuegoAdivinaPar juego2 = new JuegoAdivinaPar(3);
        JuegoAdivinaImpar juego3 = new JuegoAdivinaImpar(3);

        // Iniciar el primer juego
        System.out.println("Iniciando juego Adivina Número:");
        juego1.juega();

        // Iniciar el segundo juego
        System.out.println("\nIniciando juego Adivina Par:");
        juego2.juega();

        // Iniciar el tercer juego
        System.out.println("\nIniciando juego Adivina Impar:");
        juego3.juega();
    }
}

