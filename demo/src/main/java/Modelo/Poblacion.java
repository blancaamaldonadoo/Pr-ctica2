package Modelo;
import java.sql.*;
import java.time.*;

import InputOutput.Salida;

public class Poblacion extends Experimento{
    
    private String nombre;
    private LocalDate fechaInicio;
    private Date fechaFin;
    private int numBacteriasIniciales;
    private double temperatura;
    private Luminosidad nivelLuz;
    private Dosis dosis;
    private Salida salida;

    public Poblacion(String nombre, LocalDate fechaInicio, Date fechaFin, int numBacteriasIniciales, double temperatura, Luminosidad nivelLuz, Dosis dosis) {
        super(numBacteriasIniciales, temperatura, dosis);
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.temperatura = temperatura;
        this.nivelLuz = nivelLuz;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public LocalDate getFechaInicio(){
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio){
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin(){
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin){
        this.fechaFin = fechaFin;
    }
    public int getNumBacteriasIniciales(){
        return numBacteriasIniciales;
    }

    public void setNumBacteriasIniciales(int numBacteriasIniciales){
        this.numBacteriasIniciales = numBacteriasIniciales;
    }
    public double getTemperatura(){
        return temperatura;
    }
    public void setTemperatura(double temperatura){
        this.temperatura = temperatura;
    }
    public Luminosidad getNivelLuz(){
        return nivelLuz;
    }
    public void setNivelLuz(Luminosidad nivelLuz){
        this.nivelLuz = nivelLuz;
    }
    public Dosis getDosis(){
        return dosis;
    }
    public void setDosis(Dosis dosis){
        this.dosis = dosis;
    }

    @Override
    public String toString() {
        String texto="";
        texto+="Nombre: "+nombre+"\n";
        texto+="Fecha de inicio: "+fechaInicio+"\n";
        texto+="Fecha de fin: "+fechaFin+"\n";
        texto+="Número de bacterias iniciales: "+numBacteriasIniciales+"\n";
        texto+="Temperatura: "+temperatura+"\n";
        texto+="Nivel de luz: "+nivelLuz+"\n";
        texto+="Dosis: "+dosis+"\n";
        return texto;
    }

    public void crearDosis(int cantidadInicial, int diaStopIncremento, int dosisDiaStopIncremento, int dosisDia30){
        salida.pedirDatosDosis();
        Dosis d= new Dosis(cantidadInicial, diaStopIncremento, dosisDiaStopIncremento, dosisDia30);
    }

    public void modificarDosis(){

    }

    public void visualizarDosis(Dosis d){
        System.out.println(d.toString());
    }
    
}