package ejercicio_1;

public class App {
    public static void main(String[] args) {     
    	// a) Crear dos pinturas con anuncios 
        Artista a1 = new Artista("Lucas", "99900011", 4);
        Artista a2 = new Artista("Donald", "88877766", 2);
        Artista a3 = new Artista("X", "12398745", 5);

        Anuncio an1 = new Anuncio(401, 2700);
        Anuncio an2 = new Anuncio(402, 3100);

        Pintura p1 = new Pintura("Travesía", "Cartulina", new Artista[]{a1, a2}, "Surrealista", an1);
        Pintura p2 = new Pintura("Silencio", "Papel", new Artista[]{a3}, "Minimalista", an2);
        // b) Promedio de años de experiencia
        Artista[] todos = {a1, a2, a3};
        int suma = 0;
        for (Artista a : todos) suma += a.getAñosExperiencia();
        System.out.println("El promedio de años de experiencia: " + (suma / (double) todos.length));
        // c) Incrementar precio de pintura con artista "X"
        String nombreBuscado = "X";
        double incremento = 650;
        for (Pintura p : new Pintura[]{p1, p2}) {
            for (Artista a : p.getArtistas()) {
                if (a.getNombre().equals(nombreBuscado)) {
                    p.getAnuncio().precio += incremento;
                }
            }
        }
        System.out.println("Nuevo precio de pintura de X: " + p2.getAnuncio().getPrecio());
    }
}