package ejercicio_1;

public class App {
    public static void main(String[] args) {
    	// a) Crear dos objetos Pintura con diferentes datos
        Artista a1 = new Artista("Manolo", "998877", 3);
        Artista a2 = new Artista("Tomas", "223344", 7);
        Artista a3 = new Artista("Arthas", "556677", 6);

        Anuncio anuncio1 = new Anuncio(301, 1800);
        Pintura pintura1 = new Pintura("Travesía", "Cartulina", new Artista[]{a1, a2}, "Surrealista", anuncio1);
        Pintura pintura2 = new Pintura("Silencio", "Papel", new Artista[]{a3}, "Minimalista", null);
        // b) Mostrar artista con más experiencia
        Pintura[] pinturas = {pintura1, pintura2};
        Artista mayor = pinturas[0].getArtistas()[0];
        for (Pintura p : pinturas) {
            for (Artista art : p.getArtistas()) {
                if (art.getAñosExperiencia() > mayor.getAñosExperiencia()) {
                    mayor = art;
                }
            }
        }
        System.out.println("Artista con más experiencia: " + mayor.getNombre());
        // c) Agregar anuncio a pintura2 y mostrar total
        Anuncio anuncio2 = new Anuncio(302, 2200);
        pintura2.setAnuncio(anuncio2);
        double total = pintura1.getAnuncio().getPrecio() + pintura2.getAnuncio().getPrecio();
        System.out.println("Monto total de venta: " + total);
    }
}