package juego1;

import java.util.Scanner;
import java.util.Random;

public class JuegoAdivinaNumero extends Juego {
    private int numeroAAdivinar;

    public JuegoAdivinaNumero(int vidas) {
        super(vidas);
    }

    public void juega() {
        reiniciaPartida();
        Random rand = new Random();
        numeroAAdivinar = rand.nextInt(11);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adivina un número entre 0 y 10:");
        
        boolean acertado = false;
        do {
            int intento = scanner.nextInt();

            if (intento == numeroAAdivinar) {
                acertado = true;
                System.out.println("¡Acertaste!");
                actualizaRecord();
            } else if (intento < numeroAAdivinar) {
                System.out.println("El número es mayor. Tienes " + (numeroDeVidas - 1) + " vidas restantes.");
            } else {
                System.out.println("El número es menor. Tienes " + (numeroDeVidas - 1) + " vidas restantes.");
            }
        } while (!acertado && quitaVida());
    }
}
