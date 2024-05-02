package Modelo;
import java.util.*;

import Excepciones.ExceptionCantidad;
import InputOutput.Salida;

public class Experimento {

    private String nombre;
    private ArrayList<Poblacion> poblaciones;

    public Experimento(){
        this.poblaciones = new ArrayList<Poblacion>();
    }

    public Experimento(String nombre, ArrayList<Poblacion> poblaciones){
        this.nombre = nombre;
        this.poblaciones = poblaciones;
    }    
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public ArrayList<Poblacion> getPoblaciones(){
            return poblaciones;
    }
        
    public void setPoblaciones(ArrayList<Poblacion> poblaciones){
        this.poblaciones = poblaciones;
    }

    public void verDetallesPoblacion(Poblacion p){
        if(poblaciones.contains(p))
        System.out.println(p.toString());
        else System.out.println("No existe la poblacion");
    }

    
    public Poblacion crearPoblacion() throws ExceptionCantidad{
       Salida salida= new Salida();
       Poblacion p= salida.pedirDatosPoblacion();
        return p;
    }
    
    public String visualizarNombresPoblaciones(){
        String nombres="";
        if(poblaciones.isEmpty()){
            return "No hay poblaciones";
        }
        else{
        for(Poblacion p: poblaciones){
            nombres+=p.getNombre()+"\n";
        }
        return nombres;
        }
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