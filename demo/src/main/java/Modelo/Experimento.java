package Modelo;
import java.util.*;

import InputOutput.Salida;

public class Experimento {

    private String nombre;
    private int numBacterias;
    private double temperatura;
    private Dosis dosisComida;
    private ArrayList<Poblacion> poblaciones;

    public Experimento(){
        this.poblaciones = new ArrayList<Poblacion>();
    }
    public Experimento(int numBacterias, double temperatura, Dosis dosisComida){
        this.temperatura = temperatura;
        this.numBacterias = numBacterias;
        this.dosisComida = dosisComida;
    }

    public Experimento(String nombre, int numBacterias, double temperatura, Dosis dosisComida) {
        this.nombre = nombre;
        this.numBacterias = numBacterias;
        this.temperatura = temperatura;
        this.dosisComida = dosisComida;
        this.poblaciones = new ArrayList<Poblacion>();
    }
    
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getNumeroDeBacterias(){
        return numBacterias;
    }
    public void setNumeroDeBacterias(int numBacterias){
        this.numBacterias = numBacterias;
    }
    public double getTemperatura(){
        return temperatura;
    }
    public void setTemperatura(double temperatura){
        this.temperatura = temperatura;
    }
    public Dosis getDosisComida(){
        return dosisComida;
    }
    public void setDosisComida(Dosis dosisComida){
        this.dosisComida = dosisComida;
    }
   
    public void verDetallesPoblacion(Poblacion p){
        System.out.println(p.toString());
    }

    public void crearPoblacion(){
       Salida salida= new Salida();
       salida.pedirDatosPoblacion();
    }
    

    public void modificarPoblacion(Poblacion p){
        
    }

    public void addPoblacion(Poblacion p){
        poblaciones.add(p);
    }
    public void eliminarPoblacion(Poblacion p){
        poblaciones.remove(p);
    }
}