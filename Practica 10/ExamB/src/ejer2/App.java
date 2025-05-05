package ejer2;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // a Crear e instanciar dos objetos Ministerio de diferente forma
        ArrayList<String> empleados1 = new ArrayList<>();
        empleados1.add("Pedro Rojas Luna");
        empleados1.add("Lucy Sosa Rios");
        empleados1.add("Ana Perez Rojas");
        empleados1.add("Saul Arce Calle");

        ArrayList<Integer> edades1 = new ArrayList<>();
        edades1.add(35);
        edades1.add(43);
        edades1.add(26);
        edades1.add(29);

        ArrayList<Integer> sueldos1 = new ArrayList<>();
        sueldos1.add(2500);
        sueldos1.add(3250);
        sueldos1.add(2700);
        sueldos1.add(2500);

        Ministerio ministerio1 = new Ministerio("Ministerio de Salud", "Av. Arce #123", 4, 
        		empleados1, edades1, sueldos1);
        Ministerio ministerio2 = new Ministerio("Ministerio de Educación", "Calle Ayacucho #456");

        // b Eliminar a los empleados con edad específica (en este caso, 26 años)
        ministerio1.eliminarPorEdad(26);

        // c Transferir un empleado desde el primer ministerio hacia el segundo
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre o apellido del empleado a transferir: ");
        String nombreInput = scanner.nextLine();
        ministerio1.transferirEmpleado(ministerio2, nombreInput);

        ministerio1.mostrarInfo();
        ministerio2.mostrarInfo();

        // d Mostrar a los empleados con la menor edad en cada ministerio
        ministerio1.mostrarMenores("edad");
        ministerio2.mostrarMenores("edad");

        // d Mostrar a los empleados con el menor sueldo en cada ministerio
        ministerio1.mostrarMenores("sueldo");
        ministerio2.mostrarMenores("sueldo");
    }
}