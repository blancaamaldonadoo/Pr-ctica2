package Controlador;
import java.util.*;

import InputOutput.*;
import Modelo.*;


public class Laboratorio {
 
    private ArrayList<Experimento> experimentos;

    public Laboratorio(){
        this.experimentos = new ArrayList<Experimento>();
    }
    
    public void crearExperimento(){
        Salida salida = new Salida();
        salida.pedirDatosExperimentos();
    }

    public void modificarExperimento(){
        
    }

    public void addExperimento(Experimento e){
        experimentos.add(e);
    }


    public void eliminarExperimento(Experimento e){
        experimentos.remove(e);
    }


}