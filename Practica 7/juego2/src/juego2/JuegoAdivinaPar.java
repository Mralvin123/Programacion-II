package juego2;

import java.util.Random;

public class JuegoAdivinaPar extends JuegoAdivinaNumero {

    public JuegoAdivinaPar(int vidas) {
        super(vidas);
        Random random = new Random();
        numeroAAdivinar = random.nextInt(6) * 2;
    }

    @Override
    public boolean validaNumero(int numero) {
        if (numero < 0 || numero > 10) {
            System.out.println("El número está fuera del rango permitido (0-10).");
            return false;
        }
        if (numero % 2 != 0) {
            System.out.println("El número no es par.");
            return false;
        }
        return true;
    }
}