package ejercicio_1;

public class Obra {
    String titulo;
    String material;
    Artista[] artistas;
    Anuncio anuncio;

    public Obra(String titulo, String material, Artista[] artistas, Anuncio anuncio) {
        this.titulo = titulo;
        this.material = material;
        this.artistas = artistas;
        this.anuncio = anuncio;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public Artista[] getArtistas() {
        return artistas;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
}