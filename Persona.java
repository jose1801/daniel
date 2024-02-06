/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo001po;

/**
 *
 * @author Jaime
 */
public class Persona {

    private String cedula;
    private String nombres;
    private int edad;
    private float sueldo;
    private String direccion;

    public Persona() {
    }

    public Persona(String cedula, String nombres, int edad, float sueldo, String direccion) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.edad = edad;
        this.sueldo = sueldo;
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void mostrar() {
        System.out.println("CEDULA: " + cedula);
        System.out.println("NOMBRES: " + nombres);
        System.out.println("EDAD: " + edad);
        System.out.println("SUELDO: " + sueldo);
        System.out.println("DIRECCIÓN: " + direccion);
    }

}
