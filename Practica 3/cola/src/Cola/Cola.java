package Cola;

class Cola {
    private long[] arreglo;
    private int inicio;
    private int fin;
    private int n;
    private int size;

    public Cola(int n) {
        this.n = n;
        this.arreglo = new long[n];
        this.inicio = 0;
        this.fin = -1;
        this.size = 0;
    }

    public void insert(long e) {
        if (isFull()) {
            System.out.println("Cola llena! No se pudo agregar " + e);
            return;
        }
        fin = (fin + 1) % n;
        arreglo[fin] = e;
        size++;
        System.out.println("Elemento añadido: " + e + ", Cola actual: " + mostrarCola());
    }

    public long remove() {
        if (isEmpty()) {
            System.out.println("Cola vacía! No se puede eliminar.");
            return -1;
        }
        long elemento = arreglo[inicio];
        inicio = (inicio + 1) % n;
        size--;
        System.out.println("Elemento eliminado: " + elemento + ", Cola actual: " + mostrarCola());
        return elemento;
    }

    public long peek() {
        if (isEmpty()) {
            System.out.println("Cola vacía! No hay elementos en la cima.");
            return -1;
        }
        return arreglo[inicio];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == n;
    }

    public int size() {
        return size;
    }

    private String mostrarCola() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(arreglo[(inicio + i) % n]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Cola cola = new Cola(5);
        int[] elementos = {10, 20, 30, 40, 50, 60};

        for (int num : elementos) {
            cola.insert(num);
        }

        System.out.println("Elemento eliminado: " + cola.remove());
        System.out.println("Elemento en la cima: " + cola.peek());
    }
}
