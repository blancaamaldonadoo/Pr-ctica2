package InputOutput;
import java.sql.*;
import java.text.*;
import java.util.Scanner;

import Excepciones.ExceptionCantidad;
import Modelo.*;

public class Salida{
    
    private Scanner sc= new Scanner(System.in);
    
    public Poblacion pedirDatosPoblacion() throws ExceptionCantidad{
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce el nombre de la población: ");
        String nombre=sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Introduce la fecha de incio: ");
        String fechaInicioStr = sc.nextLine();
        Date fechaInicio = null;
        try {
             fechaInicio = (Date) sdf.parse(fechaInicioStr);
        } catch (ParseException e) {
             e.printStackTrace();
        }

        System.out.println("Introduce la fecha de fin: ");
        String fechaFinStr = sc.nextLine();
        Date fechaFin = null;
        try {
             fechaFin = (Date) sdf.parse(fechaFinStr);
        } catch (ParseException e) {
             e.printStackTrace();
        }

        System.out.println("Introduce el número de bacterias iniciales: ");
        int numBacteriasIniciales=sc.nextInt();
        System.out.println("Introduce la temperatura: ");
        double temperatura=sc.nextDouble();
        System.out.println("Introduce el nivel de luminosidad {ALTA, MEDIA, BAJA}: ");
        String nivelLuzStr = sc.nextLine();
        Luminosidad nivelLuz = Luminosidad.valueOf(nivelLuzStr);
        System.out.println("Para la dosis de comida: ");
        Poblacion p = new Poblacion(nombre, fechaInicio, fechaFin, numBacteriasIniciales, temperatura, nivelLuz, pedirDatosDosis());
        return p;
    }

    public void comprobarCantidadComida(int cantidad) throws ExceptionCantidad{
        if(cantidad>=300){
            throw new ExceptionCantidad("La cantidad inicial debe ser un número entero menor de 300");
        }
    }

    public Dosis pedirDatosDosis()throws ExceptionCantidad{
        System.out.println("Introduce la cantidad inicial de comida: ");
        int cantidadInicial=sc.nextInt();
        comprobarCantidadComida(cantidadInicial);
        System.out.println("Introduce el día en el que quiere dejar de "+
                    " incrementar la dosis (De entre los 30 que dura el exeprimento): ");
        int diaStopIncremento=sc.nextInt();
        System.out.println("Introduce la cantidad que quiera dar ese día: ");
        int dosisDiaStopIncremento=sc.nextInt();
        comprobarCantidadComida(dosisDiaStopIncremento);
        System.out.println("Introduce la cantidad final (dia 30): ");
        int dosisDia30=sc.nextInt();
        comprobarCantidadComida(dosisDia30);
        Dosis d = new Dosis(cantidadInicial, diaStopIncremento, dosisDiaStopIncremento, dosisDia30);
        return d;
    }

    public Experimento pedirDatosExperimentos() throws ExceptionCantidad{
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce el nombre del Experimento: ");
        String nombre=sc.nextLine();
        System.out.println("Introduce el número inicial de bacterias: ");
        int numBacterias=sc.nextInt();
        System.out.println("Introduce la temperatura: ");
        double temperatura=sc.nextDouble();
        System.out.println("Para la dosis de comida: ");
        Experimento e = new Experimento(nombre, numBacterias, temperatura, pedirDatosDosis());
        return e;
    }

}