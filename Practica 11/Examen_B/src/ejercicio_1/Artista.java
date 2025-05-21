package ejercicio_1;

public class Artista {
    String nombre;
    String ci;
    int añosExperiencia;

    public Artista(String nombre, String ci, int añosExperiencia) {
        this.nombre = nombre;
        this.ci = ci;
        this.añosExperiencia = añosExperiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }
}