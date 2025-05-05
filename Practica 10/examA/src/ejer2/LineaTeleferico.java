package ejer2;
import java.util.ArrayList;
import java.util.List;

public class LineaTeleferico {
    String color;
    String tramo;
    int nroCabinas;
    int nroEmpleados;
    List<String> empleados;
    List<Integer> edades;
    List<Integer> sueldos;
    List<String> eliminados;

    public LineaTeleferico(String color, String tramo, int nroCabinas, List<String> 
    empleados, List<Integer> edades, List<Integer> sueldos) {
        if (nroCabinas < 4) {
            throw new IllegalArgumentException("El número mínimo de empleados es 4.");
        }
        if (empleados.size() != edades.size() || empleados.size() != sueldos.size()) {
            throw new IllegalArgumentException("El número de empleados, edades y sueldos deben coincidir.");
        }
        this.color = color;
        this.tramo = tramo;
        this.nroCabinas = nroCabinas;
        this.nroEmpleados = empleados.size();
        this.empleados = empleados;
        this.edades = edades;
        this.sueldos = sueldos;
        this.eliminados = new ArrayList<>();
    }

    public void agregarEmpleado(String nombreCompleto, int edad, int sueldo) {
        empleados.add(nombreCompleto);
        edades.add(edad);
        sueldos.add(sueldo);
        nroEmpleados++;
    }

    public void eliminarPorApellido(String apellido) {
        apellido = apellido.trim().toLowerCase();
        for (int i = 0; i < empleados.size(); i++) {
            String[] nombres = empleados.get(i).split(" ");
            if (nombres.length >= 3 && (nombres[1].toLowerCase().contains(apellido) 
            		|| nombres[2].toLowerCase().contains(apellido))) {
                eliminados.add(empleados.get(i));
                empleados.remove(i);
                edades.remove(i);
                sueldos.remove(i);
                nroEmpleados--;
                i--;  
            }
        }
    }

    public void mostrarEliminados() {
        if (eliminados.isEmpty()) return;
        System.out.println("\n>> Empleados eliminados:");
        for (String e : eliminados) {
            System.out.println(" - " + e);
        }
    }

    public void transferirEmpleado(LineaTeleferico otro, String dato) {
        dato = dato.trim().toLowerCase();
        for (int i = 0; i < empleados.size(); i++) {
            String nombreCompleto = empleados.get(i).toLowerCase();
            if (nombreCompleto.contains(dato)) {
                otro.agregarEmpleado(empleados.get(i), edades.get(i), sueldos.get(i));
                System.out.println("\n>> Transferencia realizada:");
                System.out.println(" - " + empleados.get(i) + " | Edad: " + edades.get(i) 
                + " | Sueldo: " + sueldos.get(i));
                empleados.remove(i);
                edades.remove(i);
                sueldos.remove(i);
                nroEmpleados--;
                return;
            }
        }
        System.out.println("\n>> Empleado '" + dato + "' no encontrado.");
    }

    public void mostrarMayores(String tipo) {
        if (nroEmpleados == 0) {
            System.out.println("\n>> No hay empleados en la línea.");
            return;
        }

        if (tipo.equals("edad")) {
            int maxEdad = edades.stream().max(Integer::compare).get();
            System.out.println("\n>> Empleados con mayor edad (" + maxEdad + "):");
            for (int i = 0; i < empleados.size(); i++) {
                if (edades.get(i) == maxEdad) {
                    System.out.println(" - " + empleados.get(i) + " | Edad: " + edades.get(i));
                }
            }
        } else if (tipo.equals("sueldo")) {
            int maxSueldo = sueldos.stream().max(Integer::compare).get();
            System.out.println("\n>> Empleados con mayor sueldo (" + maxSueldo + "):");
            for (int i = 0; i < empleados.size(); i++) {
                if (sueldos.get(i) == maxSueldo) {
                    System.out.println(" - " + empleados.get(i) + " | Sueldo: " + sueldos.get(i));
                }
            }
        }
    }

    public void mostrarInfo() {
        System.out.println("\n====================================");
        System.out.println("== LÍNEA DE TELEFÉRICO: " + color.toUpperCase());
        System.out.println("Tramo: " + tramo);
        System.out.println("Nro. de cabinas: " + nroCabinas);
        System.out.println("Nro. de empleados: " + nroEmpleados);
        System.out.println("Listado de empleados:");
        for (int i = 0; i < empleados.size(); i++) {
            System.out.printf(" %d. %-25s | Edad: %2d | Sueldo: %5d\n", i + 1, empleados.get(i),
            		edades.get(i), sueldos.get(i));
        }
        System.out.println("====================================");
    }
}
