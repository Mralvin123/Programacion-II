package Pila;

class Pila {
    private int n;
    private int[] arreglo;
    private int top;

    public Pila(int n) {
        this.n = n;
        this.arreglo = new int[n];
        this.top = -1;
    }

    public void push(int e) {
        if (isFull()) {
            System.out.println("Pila llena! No se pudo agregar " + e);
            return;
        }
        top++;
        arreglo[top] = e;
        System.out.println("Elemento añadido: " + e + ", Pila actual: " + java.util.Arrays.toString(java.util.Arrays.copyOfRange(arreglo, 0, top + 1)));
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Pila vacía! No se puede eliminar.");
            return -1;
        }
        int elemento = arreglo[top];
        top--;
        System.out.println("Elemento eliminado: " + elemento + ", Pila actual: " + java.util.Arrays.toString(java.util.Arrays.copyOfRange(arreglo, 0, top + 1)));
        return elemento;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Pila vacía! No hay elementos en la cima.");
            return -1;
        }
        return arreglo[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top >= n - 1;
    }

    public static void main(String[] args) {
        Pila pila = new Pila(6);
        int[] elementos = {10, 20, 30, 40, 50, 60, 70, 80};

        for (int num : elementos) {
            pila.push(num);
        }

        System.out.println("Elemento eliminado: " + pila.pop());
        System.out.println("Elemento en la cima: " + pila.peek());
    }
}
