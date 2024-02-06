
import java.util.*;
import java.util.Date;


public class Biblioteca {
    private static Map<String, Libro> libros = new HashMap<>();
    private static Map<String, Usuario> usuarios = new HashMap<>();
    private static List<Prestamo> prestamos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ejecutar = true;

        while (ejecutar) {
            System.out.println("Seleccione una opción:");
            System.out.println("A. Registrar y modificar libro");
            System.out.println("B. Registrar usuario");
            System.out.println("C. Buscar libro");
            System.out.println("D. Registrar préstamo");
            System.out.println("E. Registrar devolución");
            System.out.println("F. Listar los libros prestados en una fecha determinada");
            System.out.println("G. Consultar la cantidad de veces que se ha prestado cada libro");
            System.out.println("H. Eliminar un libro (solo si no ha sido prestado)");
            System.out.println("I. Ordenar los libros en función de los años de edición");
            System.out.println("J. Mostrar listado de libros");
            System.out.println("X. Salir");

            String opcion = scanner.nextLine().toUpperCase();

            switch (opcion) {
                case "A":
                    registrarModificarLibro();
                    break;
                case "B":
                    registrarUsuario();
                    break;
                case "C":
                    buscarLibro();
                    break;
                case "D":
                    registrarPrestamo();
                    break;
                case "E":
                    registrarDevolucion();
                    break;
                case "F":
                    listarLibrosPrestadosFecha();
                    break;
                case "G":
                    consultarVecesPrestado();
                    break;
                case "H":
                    eliminarLibro();
                    break;
                case "I":
                    ordenarLibrosPorAnio();
                    break;
                case "J":
                    mostrarListadoLibros();
                    break;
                case "X":
                    ejecutar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    public static void registrarModificarLibro() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el ISBN del libro:");
    String isbn = scanner.nextLine();

    if (libros.containsKey(isbn)) {
        // El libro ya existe, se solicita la modificación
        Libro libroExistente = libros.get(isbn);
        System.out.println("El libro ya existe. Ingrese los nuevos datos:");

        System.out.println("Título:");
        String titulo = scanner.nextLine();
        libroExistente.setTitulo(titulo);

        System.out.println("Autor:");
        String autor = scanner.nextLine();
        libroExistente.setAutor(autor);

        System.out.println("Año de edición:");
        int anioEdicion = scanner.nextInt();
        libroExistente.setAnioEdicion(anioEdicion);

        System.out.println("El libro ha sido modificado exitosamente.");
    } else {
        // El libro no existe, se registra uno nuevo
        System.out.println("El libro no existe. Ingrese los datos:");

        System.out.println("Título:");
        String titulo = scanner.nextLine();

        System.out.println("Autor:");
        String autor = scanner.nextLine();

        System.out.println("Año de edición:");
        int anioEdicion = scanner.nextInt();

        Libro nuevoLibro = new Libro(isbn, titulo, autor, anioEdicion);
        libros.put(isbn, nuevoLibro);

        System.out.println("El libro ha sido registrado exitosamente.");
    }
}
    

    public static void registrarUsuario() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el ID del usuario:");
    String idUsuario = scanner.nextLine();

    if (usuarios.containsKey(idUsuario)) {
        System.out.println("El usuario ya existe en el registro.");
    } else {
        System.out.println("Ingrese el nombre del usuario:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el email del usuario:");
        String email = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(idUsuario, nombre, email);
        usuarios.put(idUsuario, nuevoUsuario);

        System.out.println("El usuario ha sido registrado exitosamente.");
    }
}
    

    public static void buscarLibro() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el ISBN del libro:");
    String isbn = scanner.nextLine();

    if (libros.containsKey(isbn)) {
        Libro libroEncontrado = libros.get(isbn);
        System.out.println("Título: " + libroEncontrado.getTitulo());
        System.out.println("Autor: " + libroEncontrado.getAutor());
        System.out.println("Año de edición: " + libroEncontrado.getAnioEdicion());
    } else {
        System.out.println("El libro no se encuentra en el registro.");
    }
}


    public static void registrarPrestamo() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el ISBN del libro:");
    String isbn = scanner.nextLine();

    if (libros.containsKey(isbn)) {
        Libro libro = libros.get(isbn);

        System.out.println("Ingrese el ID del usuario que realiza el préstamo:");
        String idUsuario = scanner.nextLine();

        if (usuarios.containsKey(idUsuario)) {
            Usuario usuario = usuarios.get(idUsuario);

            System.out.println("Ingrese la fecha de préstamo (en formato dd-mm-aaaa):");
            String fechaPrestamo = scanner.nextLine();

            Prestamo prestamo = new Prestamo(libro, usuario, fechaPrestamo);
            prestamos.add(prestamo);

            System.out.println("El préstamo ha sido registrado exitosamente.");
        } else {
            System.out.println("El usuario no se encuentra registrado.");
        }
    } else {
        System.out.println("El libro no se encuentra en el registro.");
    }
}

    public static void registrarDevolucion() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el ISBN del libro:");
    String isbn = scanner.nextLine();

    if (libros.containsKey(isbn)) {
        Libro libro = libros.get(isbn);

        System.out.println("Ingrese el ID del usuario que realiza la devolución:");
        String idUsuario = scanner.nextLine();

        if (usuarios.containsKey(idUsuario)) {
            Usuario usuario = usuarios.get(idUsuario);

            // Buscar el préstamo correspondiente al libro y usuario
            Prestamo prestamo = null;
            for (Prestamo p : prestamos) {
                if (p.getLibro().equals(libro) && p.getUsuario().equals(usuario)) {
                    prestamo = p;
                    break;
                }
            }

            if (prestamo != null) {
                prestamos.remove(prestamo);
                System.out.println("La devolución ha sido registrada exitosamente.");
            } else {
                System.out.println("No se encontró un préstamo activo para el libro y usuario especificados.");
            }
        } else {
            System.out.println("El usuario no se encuentra registrado.");
        }
    } else {
        
        System.out.println("El libro no se encuentra en el registro.");
        }
}

    public static void listarLibros() {
    if (libros.isEmpty()) {
        System.out.println("No hay libros registrados.");
    } else {
        System.out.println("Libros registrados:");

        for (Map.Entry<String, Libro> entry : libros.entrySet()) {
            Libro libro = entry.getValue();
            System.out.println("ISBN: " + libro.getIsbn());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Año de edición: " + libro.getAnioEdicion());
            System.out.println("--------------------");
        }
    }
}

    public static void listarPrestamos() {
    if (prestamos.isEmpty()) {
        System.out.println("No hay préstamos registrados.");
    } else {
        System.out.println("Préstamos registrados:");

        for (Prestamo prestamo : prestamos) {
            System.out.println("ISBN: " + prestamo.getLibro().getIsbn());
            System.out.println("Título: " + prestamo.getLibro().getTitulo());
            System.out.println("Autor: " + prestamo.getLibro().getAutor());
            System.out.println("Año de edición: " + prestamo.getLibro().getAnioEdicion());
            System.out.println("ID de usuario: " + prestamo.getUsuario().getIdUsuario());
            System.out.println("Nombre de usuario: " + prestamo.getUsuario().getNombre());
            System.out.println("Email de usuario: " + prestamo.getUsuario().getEmail());
            System.out.println("Fecha de préstamo: " + prestamo.getFechaPrestamo());
            System.out.println("--------------------");
        }
    }
}

    public static void eliminarLibro() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el ISBN del libro que desea eliminar:");
    String isbn = scanner.nextLine();

    if (libros.containsKey(isbn)) {
        libros.remove(isbn);
        System.out.println("El libro ha sido eliminado exitosamente.");
    } else {
        System.out.println("El libro no se encuentra en el registro.");
    }
}

    public static void ordenarLibrosPorAnioEdicion() {
    List<Libro> listaLibros = new ArrayList<>(libros.values());

    // Ordenar la lista de libros por el año de edición
    Collections.sort(listaLibros, new Comparator<Libro>() {
        @Override
        public int compare(Libro libro1, Libro libro2) {
            return libro1.getAnioEdicion() - libro2.getAnioEdicion();
        }
    });

    // Imprimir la lista de libros ordenada
    System.out.println("Libros ordenados por año de edición:");
    for (Libro libro : listaLibros) {
        System.out.println("ISBN: " + libro.getIsbn());
        System.out.println("Título: " + libro.getTitulo());
        System.out.println("Autor: " + libro.getAutor());
        System.out.println("Año de edición: " + libro.getAnioEdicion());
        System.out.println("--------------------");
    }
}

   public static void mostrarListadoLibros() {
    if (libros.isEmpty()) {
        System.out.println("No hay libros registrados.");
    } else {
        System.out.println("Listado de libros:");

        for (Map.Entry<String, Libro> entry : libros.entrySet()) {
            Libro libro = entry.getValue();
            System.out.println("ISBN: " + libro.getIsbn());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Año de edición: " + libro.getAnioEdicion());
            System.out.println("--------------------");
        }
    }
}
}

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anioEdicion;

    public Libro(String isbn, String titulo, String autor, int anioEdicion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioEdicion = anioEdicion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(int anioEdicion) {
        this.anioEdicion = anioEdicion;
    }
}


public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anioEdicion;

    public Libro(String isbn, String titulo, String autor, int anioEdicion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioEdicion = anioEdicion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(int anioEdicion) {
        this.anioEdicion = anioEdicion;
    }
}

public class Prestamo {
    private int idPrestamo;
    private Usuario usuario;
    private Libro libro;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo(int idPrestamo, Usuario usuario, Libro libro, Date fechaPrestamo, Date fechaDevolucion) {
        this.idPrestamo = idPrestamo;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}

