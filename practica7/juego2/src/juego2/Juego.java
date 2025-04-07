package juego2;

public class Juego {
    protected int numeroDeVidas;
    protected int record;

    public Juego() {
        this.numeroDeVidas = 0;
        this.record = 0;
    }

    public void reiniciaPartida() {
        this.numeroDeVidas = 3;
    }

    public void actualizaRecord() {
        if (numeroDeVidas > record) {
            record = numeroDeVidas;
            System.out.println("¡Nuevo récord!");
        }
    }

    public boolean quitaVida() {
        numeroDeVidas--;
        boolean sigueVivo = numeroDeVidas > 0;
        if (!sigueVivo) {
        	System.out.println("No te quedan más vidas. ¡Perdiste!");
        }
        return sigueVivo;
    }
}

