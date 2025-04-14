package juego2;

import java.util.Random;

public class JuegoAdivinaImpar extends JuegoAdivinaNumero {

    public JuegoAdivinaImpar(int vidas) {
        super(vidas);
        Random random = new Random();
        numeroAAdivinar = random.nextInt(5) * 2 + 1; 
    }

    @Override
    public boolean validaNumero(int numero) {
        if (numero < 1 || numero > 9) {
            System.out.println("El número está fuera del rango permitido (1-9).");
            return false;
        }
        if (numero % 2 == 0) {
            System.out.println("El número no es impar.");
            return false;
        }
        return true;
    }
}
