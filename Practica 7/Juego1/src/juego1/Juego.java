package juego1;

public class Juego {
    protected int numeroDeVidas;
    protected int record;

    public Juego(int vidas) {
        this.numeroDeVidas = vidas;
        this.record = 0;
    }

    public void reiniciaPartida() {
        numeroDeVidas = 3;
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
