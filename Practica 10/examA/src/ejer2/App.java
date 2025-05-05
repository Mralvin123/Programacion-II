package ejer2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<String> empleados1 = new ArrayList<>();
        empleados1.add("Pedro Rojas Luna");
        empleados1.add("Lucy Sosa Rios");
        empleados1.add("Ana Perez Rojas");
        empleados1.add("Saul Arce Calle");

        List<Integer> edades1 = new ArrayList<>();
        edades1.add(35);
        edades1.add(43);
        edades1.add(26);
        edades1.add(29);

        List<Integer> sueldos1 = new ArrayList<>();
        sueldos1.add(2500);
        sueldos1.add(3250);
        sueldos1.add(2700);
        sueldos1.add(2500);

        // a) Instanciar 2 objetos LineaTeleferico de diferente forma
        LineaTeleferico linea1 = new LineaTeleferico("Rojo", "Estación Central, Estación Cementerio, " + 
        		"Estación 16 de Julio", 20, empleados1, edades1, sueldos1);
        LineaTeleferico linea2 = new LineaTeleferico("Verde", "Tramo B", 15, new ArrayList<>(), 
        		new ArrayList<>(), new ArrayList<>());

        // b) Eliminar a los empleados con apellido X, paterno o materno
        linea1.eliminarPorApellido("Sosa");

        // c) Transferir al empleado X del primer objeto al segundo objeto
        Scanner scanner = new Scanner(System.in);
        System.out.print(">> Ingrese el nombre o apellido del empleado a transferir: ");
        String entrada = scanner.nextLine();
        linea1.transferirEmpleado(linea2, entrada);

        // Mostrar resultados
        linea1.mostrarInfo();

        // d) Mostrar a los empleados con la mayor edad
        linea1.mostrarMayores("edad");

        // d) Mostrar a los empleados con el mayor sueldo
        linea1.mostrarMayores("sueldo");

        linea1.mostrarEliminados();

        linea2.mostrarInfo();
        linea2.mostrarMayores("edad");
        linea2.mostrarMayores("sueldo");
    }
}
