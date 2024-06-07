package InputOutput;
import java.time.LocalDate;
import java.util.*;

import Excepciones.ExcepcionDiaDosis;
import Excepciones.ExceptionCantidad;
import ClasesLab.*;

/**
 * Clase que se encarga de la entrada y salida de datos en la aplicación.
 */

public class Salida{

    /**
     * Método que pide los datos de una población.
     * @return
     * @throws ExceptionCantidad
     */

    public Poblacion pedirDatosPoblacion() throws ExceptionCantidad{
        String nombre= Comprobaciones.leerString("Introduce el nombre de la población: ");
        LocalDate [] fechas = comprobarFechas();
        int numBacteriasIniciales= Comprobaciones.leerInt("Introduce el número de bacterias iniciales: ");
        double temperatura= Comprobaciones.leerDouble("Introduce la temperatura: ");
        Luminosidad nivelLuz=Comprobaciones.leerLuminosidad("Introduce el nivel de luminosidad {ALTA, MEDIA, BAJA}: ");
        System.out.println("\nPara la dosis de comida: ");
        Poblacion p = new Poblacion(nombre, fechas[0], fechas[1], numBacteriasIniciales, temperatura, nivelLuz, opcionesDosis());
        System.out.println("\nPoblación creada con éxito:");
        System.out.println(p);
        return p;
    }

    /**
     * Método que pide las fechas de inicio y fin de un experimento.
     * @return
     */

    public LocalDate[] comprobarFechas(){
        LocalDate [] fechas = new LocalDate[2];
        LocalDate fechaInicio;
        LocalDate fechaFin;
        do{
            fechaInicio= Comprobaciones.leerFecha("Introduce la fecha de inicio (yyyy-MM-dd): ");   
            fechaFin=Comprobaciones.leerFecha("Introduce la fecha de fin (yyyy-MM-dd): ");
            if(fechaInicio.isAfter(fechaFin)){
                System.out.println("La fecha de inicio no puede ser posterior a la fecha de fin");
            }
        }
        while(fechaInicio.isAfter(fechaFin));
        if(fechaInicio.isAfter(fechaFin)) comprobarFechas();
        fechas[0]=fechaInicio;
        fechas[1]=fechaFin;
        return fechas;
    }
    
    /**
     * Método que comprueba que la cantidad de comida inicial sea un número entero menor de 300000 miligramos.
     * @param cantidad
     * @throws ExceptionCantidad
     */

    public void comprobarCantidadComida(float cantidad) throws ExceptionCantidad{
        if(cantidad>=300000 || cantidad<0){
            throw new ExceptionCantidad("La cantidad inicial debe ser un número entero menor de 300000 miligramos");
        }
    }

    /**
     * Método que pide al usuario que introduzca el tipo de dosis que quiere emplear.
     * @return
     * @throws ExceptionCantidad
     */

    public Dosis opcionesDosis() throws ExceptionCantidad{
        System.out.println("Introduce el tipo de dosis que quieras emplear: ");
        int opcion= Comprobaciones.leerInt("1) Incremento lineal de comida seguido de un decremento lineal a partir del día x. "+ 
        "\n2) Dosis constante durante x días de experimento. \n3) Dosis linealmente creciente hasta x valor de comida." +
        "\n4) Porporcionar comida intermitente (día sí, día no). ");
        Dosis d;
        switch(opcion){

            case 1: {
                d = pedirDatosDosis();
                return d;
            }
            case 2:{
                d= pedirDatosDosisConstante();
                return d;
            }
            case 3:{
                d= pedirDatosDosisInicioFin();
                return d;
            }
            case 4: {
                d= pedirDatosDosisIntermitente();
                return d;
            }      
        }
        return null;
    }

    /**
     * Método que pide los datos de una dosis.
     * @return
     * @throws ExceptionCantidad
     */

    public Dosis pedirDatosDosis()throws ExceptionCantidad{
        int duracionDias=Comprobaciones.leerInt("Introduce la duración de la dosis en días: ");
        float cantidadInicial=Comprobaciones.leerFloat("Introduce la cantidad inicial de comida (mg): ");
        comprobarCantidadComida(cantidadInicial);
        int diaStopIncremento=Comprobaciones.leerInt("Introduce el día en el que quiere dejar de "+
                    " incrementar la dosis (De entre los 30 que dura el exeprimento): ");
        float dosisDiaStopIncremento=Comprobaciones.leerFloat("Introduce la cantidad que quiera dar ese día (mg): ");
        comprobarCantidadComida(dosisDiaStopIncremento);
        float dosisDiaFinal=Comprobaciones.leerFloat("Introduce la cantidad final (dia " + duracionDias +"): ");
        comprobarCantidadComida(dosisDiaFinal);
        Dosis d = new Dosis(duracionDias,cantidadInicial, diaStopIncremento, dosisDiaStopIncremento, dosisDiaFinal);
        return d;
    }

    /**
     * Método que pide los datos de una dosis constante.
     * @return
     * @throws ExceptionCantidad
     */

    public Dosis pedirDatosDosisConstante() throws ExceptionCantidad{
        int duracionDias=Comprobaciones.leerInt("Introduce la duración de la dosis (días): ");
        float cantidadConstante=Comprobaciones.leerFloat("Introduce una cantidad constante de comida (mg)");
        comprobarCantidadComida(cantidadConstante);
        Dosis d= new Dosis(duracionDias, cantidadConstante);
        return d;
    }

    /**
     * Método que calcula la dosis constante.
     * @param d
     * @return
     * @throws IllegalArgumentException
     * @throws ExcepcionDiaDosis
     */ 

    public ArrayList<Float> calcularDosisConstante(Dosis d) throws IllegalArgumentException, ExcepcionDiaDosis{
        ArrayList<Float> listDosis= new ArrayList<Float>();
        for(int i=0; i<d.calcularDosisConstante(i); i++){
            listDosis.add(d.getCantidadConstante());
        }
        return listDosis;
    }

    /**
     * Método que pide los datos de una dosis de comida con una fecha de inicio y de fin.
     * @return
     * @throws ExceptionCantidad
     */

    public Dosis pedirDatosDosisInicioFin() throws ExceptionCantidad{
        int duracionDias=Comprobaciones.leerInt("Introduce la duración de la dosis en días: ");
        float cantidadInicial=Comprobaciones.leerFloat("Introduce la cantidad de comida del día incial (mg)");
        comprobarCantidadComida(cantidadInicial);
        float dosisDiaStop=Comprobaciones.leerFloat("Introduce la cantidad límite para detener la dosis (mg)");
        comprobarCantidadComida(dosisDiaStop);
        Dosis d= new Dosis(duracionDias, cantidadInicial, dosisDiaStop);
        calcularDosisInicioFin(d);
        return d;
    }

    /**
     * Método que calcula la dosis de una dosis de comida de fecha de inicio y fin.
     * @param d
     * @return
     * @throws ExceptionCantidad
     */

    public ArrayList<Float> calcularDosisInicioFin(Dosis d) throws ExceptionCantidad{
        ArrayList<Float> listDosis= new ArrayList<Float>();
        for(int i=0; i<d.getDuracionDias(); i++){
            listDosis.add(d.calcularDosisInicioFin(i));
        }
        return listDosis;
    }

    /**
     * Método que pide los datos de una dosis intermitente.
     * @return
     * @throws ExceptionCantidad
     */

    public Dosis pedirDatosDosisIntermitente() throws ExceptionCantidad{
        int duracionDias=Comprobaciones.leerInt("Introduce la duración de la dosis en días: ");
        float cantidadConstante=Comprobaciones.leerFloat("Introduce la cantidad de comida del día incial (mg)");
        comprobarCantidadComida(cantidadConstante);
        Dosis d= new Dosis(duracionDias, cantidadConstante);
        return d;
    }

    /**
     * Método que calcula la dosis de una dosis intermitente.
     * @param d
     * @return
     * @throws ExcepcionDiaDosis
     */

    public ArrayList<Float> calcularDosisIntermitente(Dosis d) throws ExcepcionDiaDosis{
        ArrayList<Float> listDosis= new ArrayList<Float>();
        for(int i=0; i<d.getDuracionDias(); i++){
            listDosis.add(d.calcularDosisIntermitente(i));
        }
        return listDosis;
    }

    /**
     * Método que pide los datos de un experimento.
     * @return
     */

    public Experimento pedirDatosExperimentos(){
        String nombre= Comprobaciones.leerString("Introduce el nombre del Experimento: ");
        Experimento experimento= new Experimento(nombre, new ArrayList<Poblacion>());
        return experimento;
    }

    /**
     * Método que pide los datos de una dosis para modificarla.
     * @param dosis
     * @return
     * @throws ExceptionCantidad
     */

    public Dosis datosModificarDosis(Dosis dosis)throws ExceptionCantidad{
        int duracionDias=Comprobaciones.leerInt("Introduce la nueva duración de la dosis en días: ");
        dosis.setDuracionDias(duracionDias);

        if(dosis.getCantidadInicial()!=0){
            float cantidadInicial=Comprobaciones.leerFloat("Introduce la nueva cantidad inicial de comida(mg): ");
            comprobarCantidadComida(cantidadInicial);
            dosis.setCantidadInicial(cantidadInicial);
        }

        if(dosis.getDiaStopIncremento()!=0){
            int diaStopIncremento= Comprobaciones.leerInt("Introduce el día en el que quiere dejar de "+
                        " incrementar la dosis (De entre los " + dosis.getDuracionDias() +" días que dura el exeprimento): ");
            dosis.setDiaStopIncremento(diaStopIncremento);

            float dosisDiaStopIncremento=Comprobaciones.leerFloat("Introduce la cantidad que quiera dar ese día(mg): ");
            comprobarCantidadComida(dosisDiaStopIncremento);
            dosis.setDosisDiaStopIncremento(dosisDiaStopIncremento);
        }

        if(dosis.getDosisDiaFinal()!=0){
            float dosisDiaFinal=Comprobaciones.leerFloat("Introduce la cantidad final (dia " + dosis.getDuracionDias() + ") (mg): ");
            comprobarCantidadComida(dosisDiaFinal);
            dosis.setDosisDia30(dosisDiaFinal);
        }

        if(dosis.getCantidadConstante()!=0){
            float cantidadConstante=Comprobaciones.leerFloat("Introduce la nueva cantidad de comida constante (mg)");
            comprobarCantidadComida(cantidadConstante);
            dosis.setCantidadConstante(cantidadConstante);
        }

        return dosis;
    }

}