//jose salinas clemente    ti3/1

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Provincia {
    private String nombre;
    private List<Canton> cantones;

    public Provincia(String nombre) {
        this.nombre = nombre;
        this.cantones = new ArrayList<>();
    }

    public void agregarCanton(Canton canton) {
        cantones.add(canton);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Canton> getCantones() {
        return cantones;
    }
}

class Canton {
    private String nombre;
    private List<Parroquia> parroquias;

    public Canton(String nombre) {
        this.nombre = nombre;
        this.parroquias = new ArrayList<>();
    }

    public void agregarParroquia(Parroquia parroquia) {
        parroquias.add(parroquia);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Parroquia> getParroquias() {
        return parroquias;
    }
}

class Parroquia {
    private String nombre;

    public Parroquia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

public class RegistroProvincias {
    private List<Provincia> provincias;

    public RegistroProvincias() {
        this.provincias = new ArrayList<>();
    }

    public void registrarProvincia(Provincia provincia) {
        provincias.add(provincia);
    }

    public void registrarCanton(String provinciaNombre, Canton canton) {
        for (Provincia provincia : provincias) {
            if (provincia.getNombre().equalsIgnoreCase(provinciaNombre)) { //equalsIgnoreCase sirve para compara dos strings para ver si son iguales ignorando las diferencias entre mayúsculas y minúsculas
                provincia.agregarCanton(canton);
                break;
            }
        }
    }

    public void registrarParroquia(String provinciaNombre, String cantonNombre, Parroquia parroquia) {
        for (Provincia provincia : provincias) {
            if (provincia.getNombre().equalsIgnoreCase(provinciaNombre)) {
                for (Canton canton : provincia.getCantones()) {
                    if (canton.getNombre().equalsIgnoreCase(cantonNombre)) {
                        canton.agregarParroquia(parroquia);
                        break;
                    }
                }
                break;
            }
        }
    }

    public void listarProvincias() {
        for (Provincia provincia : provincias) {
            System.out.println("Provincia: " + provincia.getNombre());
            for (Canton canton : provincia.getCantones()) {
                System.out.println(" - Cantón: " + canton.getNombre());
                for (Parroquia parroquia : canton.getParroquias()) {
                    System.out.println("   - Parroquia: " + parroquia.getNombre());
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RegistroProvincias registro = new RegistroProvincias();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar Provincia");
            System.out.println("2. Registrar Cantón");
            System.out.println("3. Registrar Parroquia");
            System.out.println("4. Listar Provincias con sus respectivos cantones y parroquias");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de la provincia:");
                    String nombreProvincia = scanner.nextLine();
                    registro.registrarProvincia(new Provincia(nombreProvincia));
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la provincia:");
                    String provinciaParaCanton = scanner.nextLine();
                    System.out.println("Ingrese el nombre del cantón:");
                    String nombreCanton = scanner.nextLine();
                    registro.registrarCanton(provinciaParaCanton, new Canton(nombreCanton));
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la provincia:");
                    String provinciaParaParroquia = scanner.nextLine();
                    System.out.println("Ingrese el nombre del cantón:");
                    String cantonParaParroquia = scanner.nextLine();
                    System.out.println("Ingrese el nombre de la parroquia:");
                    String nombreParroquia = scanner.nextLine();
                    registro.registrarParroquia(provinciaParaParroquia, cantonParaParroquia, new Parroquia(nombreParroquia));
                    break;
                case 4:
                    registro.listarProvincias();
                    break;
                case 0:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);
        
        scanner.close();
    }
}
