package ejer2;
import java.util.ArrayList;

public class Ministerio {
    private String nombre;
    private String direccion;
    private int nroEmpleados;
    private ArrayList<String> empleados;
    private ArrayList<Integer> edades;
    private ArrayList<Integer> sueldos;
    private ArrayList<String> eliminados;

    public Ministerio(String nombre, String direccion, int nroEmpleados, ArrayList<String> 
    empleados, ArrayList<Integer> edades, ArrayList<Integer> sueldos) {
        if (nroEmpleados < 0 || (nroEmpleados > 0 && (empleados.size() != edades.size() 
        		|| edades.size() != sueldos.size()))) {
            throw new IllegalArgumentException("Datos inconsistentes");
        }
        this.nombre = nombre;
        this.direccion = direccion;
        this.nroEmpleados = nroEmpleados;
        this.empleados = new ArrayList<>(empleados);
        this.edades = new ArrayList<>(edades);
        this.sueldos = new ArrayList<>(sueldos);
        this.eliminados = new ArrayList<>();
    }

    public Ministerio(String nombre, String direccion) {
        this(nombre, direccion, 0,
            new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>()
        );
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarEmpleado(String empleado, int edad, int sueldo) {
        empleados.add(empleado);
        edades.add(edad);
        sueldos.add(sueldo);
        nroEmpleados++;
    }

    public void eliminarPorEdad(int edadObjetivo) {
        for (int i = edades.size() - 1; i >= 0; i--) {
            if (edades.get(i) == edadObjetivo) {
                eliminados.add(empleados.get(i));
                empleados.remove(i);
                edades.remove(i);
                sueldos.remove(i);
                nroEmpleados--;
            }
        }
    }

    public void transferirEmpleado(Ministerio otro, String dato) {
        dato = dato.trim().toLowerCase();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).toLowerCase().contains(dato)) {
                otro.agregarEmpleado(empleados.get(i), edades.get(i), sueldos.get(i));
                System.out.println(">> Transferencia realizada:");
                System.out.printf(" - %s | Edad: %d | Sueldo: %d\n", empleados.get(i), 
                		edades.get(i), sueldos.get(i));
                empleados.remove(i);
                edades.remove(i);
                sueldos.remove(i);
                nroEmpleados--;  
                return;
            }
        }
        System.out.printf(">> Empleado '%s' no encontrado.\n", dato);
    }

    public void mostrarMenores(String tipo) {
        if (nroEmpleados == 0) {
            System.out.println(">> No hay empleados.");
            return;
        }

        if (tipo.equals("edad")) {
            int minEdad = edades.stream().min(Integer::compare).orElse(-1);
            System.out.printf("\n>> Empleados con menor edad (%d):\n", minEdad);
            for (int i = 0; i < edades.size(); i++) {
                if (edades.get(i) == minEdad) {
                    System.out.printf(" - %s | Edad: %d\n", empleados.get(i), edades.get(i));
                }
            }
        } else if (tipo.equals("sueldo")) {
            int minSueldo = sueldos.stream().min(Integer::compare).orElse(-1);
            System.out.printf("\n>> Empleados con menor sueldo (%d):\n", minSueldo);
            for (int i = 0; i < sueldos.size(); i++) {
                if (sueldos.get(i) == minSueldo) {
                    System.out.printf(" - %s | Sueldo: %d\n", empleados.get(i), sueldos.get(i));
                }
            }
        }
    }

    public void mostrarInfo() {
        System.out.println("====================================");
        System.out.printf("== %s\nDirección: %s\n", nombre.toUpperCase(), direccion);
        System.out.printf("Nro. de empleados: %d\nListado de empleados:\n", nroEmpleados);
        for (int i = 0; i < empleados.size(); i++) {
            System.out.printf(" %d. %-25s | Edad: %2d | Sueldo: %5d\n", i + 1, empleados.get(i), 
            		edades.get(i), sueldos.get(i));
        }

        if (!eliminados.isEmpty()) {
            System.out.println("\n>> Empleados eliminados:");
            for (String eliminado : eliminados) {
                System.out.printf(" - %s\n", eliminado);
            }
        }

        System.out.println("====================================");
    }
}
