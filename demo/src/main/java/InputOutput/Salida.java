package InputOutput;
import java.time.LocalDate;
import java.util.*;

import Excepciones.ExceptionCantidad;
import Modelo.*;

public class Salida{
    private Salida salida;
    public Poblacion pedirDatosPoblacion() throws ExceptionCantidad{
        String nombre= Comprobaciones.leerString("Introduce el nombre de la población: ");
        LocalDate fechaInicio= Comprobaciones.leerFecha("Introduce la fecha de incio: ");
        LocalDate fechaFin=Comprobaciones.leerFecha("Introduce la fecha de fin: ");
        int numBacteriasIniciales= Comprobaciones.leerInt("Introduce el número de bacterias iniciales: ");
        double temperatura= Comprobaciones.leerDouble("Introduce la temperatura: ");
        Luminosidad nivelLuz=Comprobaciones.leerLuminosidad("Introduce el nivel de luminosidad {ALTA, MEDIA, BAJA}: ");
        System.out.println("Para la dosis de comida: ");
        Poblacion p = new Poblacion(nombre, fechaInicio, fechaFin, numBacteriasIniciales, temperatura, nivelLuz, pedirDatosDosis());
        return p;
    }

    public void comprobarCantidadComida(long cantidad) throws ExceptionCantidad{
        if(cantidad>=300000 || cantidad<=0){
            throw new ExceptionCantidad("La cantidad inicial debe ser un número entero menor de 300000 miligramos");
        }
    }

    public void opcionesDosis() throws ExceptionCantidad{
        System.out.println("Introduce el tipo de dosis que quieras emplear: ");
        int opcion= Comprobaciones.leerInt("1) Incremento lineal de comida seguido de un decremento lineal a partir del día x. "+ 
        "\n2) Dosis constante durante x días de experimento. \n3) Dosis linealmente creciente hasta x valor de comida." +
        "\n4) Porporcionar comida intermitente (día sí, día no). ");
        switch(opcion){
            case 1: {
                salida.pedirDatosDosis();
                break;
            }
            case 2:{
                salida.pedirDatosDosisConstante();
                break;
            }
            case 3:{
                salida.pedirDatosDosisInicioFin();
                break;
            }
            case 4: {
                salida.pedirDatosDosisIntermitente();
                break;
            }      
        }
    }

    public Dosis pedirDatosDosis()throws ExceptionCantidad{
        int duracionDias=Comprobaciones.leerInt("Introduce la duración de la dosis en días: ");
        long cantidadInicial=Comprobaciones.leerLong("Introduce la cantidad inicial de comida (mg): ");
        comprobarCantidadComida(cantidadInicial);
        int diaStopIncremento=Comprobaciones.leerInt("Introduce el día en el que quiere dejar de "+
                    " incrementar la dosis (De entre los 30 que dura el exeprimento): ");
        long dosisDiaStopIncremento=Comprobaciones.leerLong("Introduce la cantidad que quiera dar ese día (mg): ");
        comprobarCantidadComida(dosisDiaStopIncremento);
        long dosisDiaFinal=Comprobaciones.leerLong("Introduce la cantidad final (dia " + duracionDias +"): ");
        comprobarCantidadComida(dosisDiaFinal);
        Dosis d = new Dosis(duracionDias,cantidadInicial, diaStopIncremento, dosisDiaStopIncremento, dosisDiaFinal);
        return d;
    }

    public Dosis pedirDatosDosisConstante() throws ExceptionCantidad{
        int duracionDias=Comprobaciones.leerInt("Introduce la duración de la dosis en días: ");
        long cantidadConstante=Comprobaciones.leerLong("Introduce una cantidad constante de comida (mg)");
        comprobarCantidadComida(cantidadConstante);
        Dosis d= new Dosis(duracionDias, cantidadConstante);
        return d;
    }

    public Dosis pedirDatosDosisInicioFin() throws ExceptionCantidad{
        int duracionDias=Comprobaciones.leerInt("Introduce la duración de la dosis en días: ");
        long cantidadInicial=Comprobaciones.leerLong("Introduce la cantidad de comida del día incial (mg)");
        comprobarCantidadComida(cantidadInicial);
        long dosisDiaFinal=Comprobaciones.leerLong("Introduce la cantidad de comida del último día (dia "+ duracionDias+") (mg)");
        comprobarCantidadComida(dosisDiaFinal);
        Dosis d= new Dosis(duracionDias, cantidadInicial, dosisDiaFinal);
        return d;
    }

    public Dosis pedirDatosDosisIntermitente() throws ExceptionCantidad{
        int duracionDias=Comprobaciones.leerInt("Introduce la duración de la dosis en días: ");
        long cantidadConstante=Comprobaciones.leerLong("Introduce la cantidad de comida del día incial (mg)");
        comprobarCantidadComida(cantidadConstante);
        Dosis d= new Dosis(duracionDias, cantidadConstante);
        return d;
    }

    public Experimento pedirDatosExperimentos(){
        String nombre= Comprobaciones.leerString("Introduce el nombre del Experimento: ");
        Experimento experimento= new Experimento(nombre, new ArrayList<Poblacion>());
        return experimento;
    }

    public Dosis DatosModificarDosis(Dosis dosis)throws ExceptionCantidad{
        int duracionDias=Comprobaciones.leerInt("Introduce la nueva duración de la dosis en días: ");
        dosis.setDuracionDias(duracionDias);

        if(dosis.getCantidadInicial()!=0){
            long cantidadInicial=Comprobaciones.leerLong("Introduce la nueva cantidad inicial de comida(mg): ");
            comprobarCantidadComida(cantidadInicial);
            dosis.setCantidadInicial(cantidadInicial);
        }

        if(dosis.getDiaStopIncremento()!=0){
            int diaStopIncremento= Comprobaciones.leerInt("Introduce el día en el que quiere dejar de "+
                        " incrementar la dosis (De entre los " + dosis.getDuracionDias() +" días que dura el exeprimento): ");
            dosis.setDiaStopIncremento(diaStopIncremento);

            long dosisDiaStopIncremento=Comprobaciones.leerLong("Introduce la cantidad que quiera dar ese día(mg): ");
            comprobarCantidadComida(dosisDiaStopIncremento);
            dosis.setDosisDiaStopIncremento(dosisDiaStopIncremento);
        }

        if(dosis.getDosisDiaFinal()!=0){
            long dosisDiaFinal=Comprobaciones.leerLong("Introduce la cantidad final (dia " + dosis.getDuracionDias() + ") (mg): ");
            comprobarCantidadComida(dosisDiaFinal);
            dosis.setDosisDia30(dosisDiaFinal);
        }

        if(dosis.getCantidadConstante()!=0){
            long cantidadConstante=Comprobaciones.leerLong("Introduce la nueva cantidad de comida constante (mg)");
            comprobarCantidadComida(cantidadConstante);
            dosis.setCantidadConstante(cantidadConstante);
        }

        return dosis;
    }

}