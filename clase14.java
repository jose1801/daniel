/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo001po;

/**
 *
 * @author Estudiante
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jaime
 */
public class Ejemplo001PO {

    /**
     */
    public static Scanner scan=new Scanner(System.in).useDelimiter("\n");
    public static ArrayList<Persona> listapersonas=new ArrayList<>();
    public static void main(String[] args) {
        // TODO code application logic here
        int op;
        do{
            op=menu();
            operaciones(op);
            System.out.println("Desea realizar otra operacion si(1): ");
            op=scan.nextInt();
        }while(op==1);
    }
    public static int menu(){    
    int op;
    do{    
        System.out.println("***** MENU DE OPCIONES****");
        System.out.println("1: registrar persona");
        System.out.println("2: listar personas");
        System.out.println("3: listar personas");
        System.out.println("4: buscar personas"); 
        System.out.println("Elija una opcion.");
        op=scan.nextInt();
        scan.nextLine();
    }while(op<1||op>4);
        return op;
    }
    
    public static void operaciones(int op){
        switch(op){
            case 1:
                fun_registrarPersona();
                break;
            case 2:
                fun_listar();
                break;
            case 3:
                fun_listar2();
                break;
        }
                
    }

  
    public static void  fun_registrarPersona(){
        String cedula,nombres,direccion;
        int edad;
        float sueldo;
        System.out.println("Ingrese la cédula: ");
        cedula= scan.nextLine();
        System.out.println("Ingrese los nombres:");
        nombres=scan.nextLine();
        System.out.println("Ingrese la edad:");
        edad=scan.nextInt();
        System.out.println("Ingrese el sueldo: ");
        sueldo=scan.nextFloat();
        scan.nextLine();//flush
        System.out.println("Ingrese la dirección:");
        direccion=scan.nextLine();
        Persona objPersona=new Persona(cedula,nombres,edad,sueldo,direccion);
        
        listapersonas.add(objPersona);


        
    }
    
    public static void fun_listar(){
        System.out.println("---Lista de personas---");
        for(Persona objPersona : listapersonas){
            objPersona.mostrar();
            System.out.println("");
            
        }
    }

    public static void fun_listar2(){
        System.out.println("***LISTA DE PERSONAS***");
        for (int i = 0; i < listapersonas.size(); i++) {
            System.out.println("CEDULA:"+listapersonas.get(i).getCedula());
            System.out.println("NOMBRE:"+listapersonas.get(i).getNombres());
            System.out.println("EDAD:"+listapersonas.get(i).getEdad());
            System.out.println("Sueldo:"+listapersonas.get(i).getSueldo());
            System.out.println("Direccion:"+listapersonas.get(i).getDireccion());
            System.out.println("");
            
        }
        //otra forma
        /*for(Persona objPersona : listapersonas){
            System.out.println("CEDULA:"+listapersonas.get(i).getCedula());

    }*/
        
    }
} //fin de la clase
