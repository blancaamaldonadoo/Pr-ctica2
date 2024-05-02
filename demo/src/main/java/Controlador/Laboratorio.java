package Controlador;
import java.util.*;

import Excepciones.ExceptionCantidad;
import InputOutput.*;
import Modelo.*;


public class Laboratorio {
 
    private ArrayList<Experimento> experimentos;
    private Experimento experimentoActual;

    public Laboratorio(){
        this.experimentoActual=null;
        this.experimentos = new ArrayList<Experimento>();
    }

    public ArrayList<Experimento> getExperimentos(){
        return experimentos;
    }

    public void setExperimentos(ArrayList<Experimento> experimentos){
        this.experimentos = experimentos;
    }

    public Experimento getExperimentoActual(){
        return experimentoActual;
    }

    public void setExperimentoActual(Experimento experimentoActual){
        this.experimentoActual = experimentoActual;
    }
    
    public void crearExperimento() throws ExceptionCantidad{
        //createNewFile();
        Salida salida = new Salida();
        salida.pedirDatosExperimentos();
    }

    public Experimento CambiarNombreExperimento(Experimento experimento){
        String nombre=Comprobaciones.leerString("Introduce el nuevo nombre del Experimento: ");
        if(nombre.isEmpty()){
            System.out.println("No se ha introducido ningún nombre");
            return experimento;
        }
        for(Experimento e: experimentos){
            if(e.getNombre().equals(nombre)){
                System.out.println("Ya existe un experimento con ese nombre");
                return experimento;
            }
        }
        experimento.setNombre(nombre);
        return experimento;
    }

    public void addExperimento(Experimento e){
        experimentos.add(e);
        experimentoActual=e;
    }


    public void eliminarExperimento(Experimento e){
        experimentos.remove(e);
    }

}