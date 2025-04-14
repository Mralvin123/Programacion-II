package herenciamultiple;

public class D implements A, B {
    private int x;
    private int y;
    private int z;

    public D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void incrementaXZ() {
        x++;
        z++;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void incrementaYZ() {
        y++;
        z++;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public void incrementaZ() {
        z++;
    }

    public void incrementaXYZ() {
        x++;
        y++;
        z++;
    }

    public void mostrar() {
        System.out.println("x = " + getX());
        System.out.println("y = " + getY());
        System.out.println("z desde a = " + getZ());
        System.out.println("z desde b = " + getZ());
    }

    public static void main(String[] args) {
        D obj = new D(2, 3, 4);
        obj.incrementaXYZ();
        obj.mostrar();
    }
}
