package ejercicio_1;

public class Pintura extends Obra {
    String genero;

    public Pintura(String titulo, String material, Artista[] artistas, String genero, Anuncio anuncio) {
        super(titulo, material, artistas, anuncio);
        this.genero = genero;
    }
}