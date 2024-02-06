// Interfaz para vehículos
interface Vehiculo {
    void acelerar();
    void frenar();
}

// Clase Avion que implementa la interfaz Vehiculo
class Avion implements Vehiculo {
    @Override
    public void acelerar() {
        System.out.println("El avión está acelerando.");
    }
    
    @Override
    public void frenar() {
        System.out.println("El avión está frenando.");
    }
    
    // Otros métodos y atributos específicos de aviones
}

// Clase Barco que implementa la interfaz Vehiculo
class Barco implements Vehiculo {
    @Override
    public void acelerar() {
        System.out.println("El barco está acelerando.");
    }
    
    @Override
    public void frenar() {
        System.out.println("El barco está frenando.");
    }
    
    // Otros métodos y atributos específicos de barcos
}

// Ejemplo de uso
public class EjemploHerenciaMultiple {
    public static void main(String[] args) {
        Avion avion = new Avion();
        avion.acelerar(); // Output: El avión está acelerando.
        avion.frenar(); // Output: El avión está frenando.
        
        Barco barco = new Barco();
        barco.acelerar(); // Output: El barco está acelerando.
        barco.frenar(); // Output: El barco está frenando.
    }
}