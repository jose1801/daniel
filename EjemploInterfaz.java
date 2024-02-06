// Definición de la interfaz
interface Animal {
    void hacerSonido();
    void moverse();
}

// Implementación de la interfaz en una clase
class Perro implements Animal {
    @Override
    public void hacerSonido() {
        System.out.println("El perro hace: ¡Guau guau!");
    }
    
    @Override
    public void moverse() {
        System.out.println("El perro se mueve corriendo.");
    }
}

// Implementación de la interfaz en otra clase
class Gato implements Animal {
    @Override
    public void hacerSonido() {
        System.out.println("El gato hace: ¡Miau miau!");
    }
    
    @Override
    public void moverse() {
        System.out.println("El gato se mueve saltando.");
    }
}

// Ejemplo de uso
public class EjemploInterfaz {
    public static void main(String[] args) {
        Animal perro = new Perro();
        perro.hacerSonido(); // Output: El perro hace: ¡Guau guau!
        perro.moverse(); // Output: El perro se mueve corriendo.
        
        Animal gato = new Gato();
        gato.hacerSonido(); // Output: El gato hace: ¡Miau miau!
        gato.moverse(); // Output: El gato se mueve saltando.
    }
}