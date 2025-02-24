package Circulo; 

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Punto {
    public int x;
    public int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Circulo extends JPanel { 
    public Punto centro;
    public int radio;

    public Circulo(Punto centro, int radio) {
        this.centro = centro;
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Circulo con centro en el punto (" + centro.x + "," + centro.y + ") y con radio de" + radio;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(centro.x - radio, centro.y - radio, 2 * radio, 2 * radio);
    }
    public static void main(String[] args) {
        Punto centro = new Punto(100, 100);
        int radio = 100;
        Circulo objeto = new Circulo(centro, radio);
        JFrame ventana = new JFrame("Gráfico Círculo");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 500);
        ventana.setLocationRelativeTo(null);
        ventana.add(objeto);
        ventana.setVisible(true);
        System.out.println(objeto.toString());
    }
}
