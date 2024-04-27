package Controlador;
import java.util.*;

import InputOutput.*;
import Modelo.*;


public class Laboratorio {
 
    private ArrayList<Experimento> experimentos;
    private Salida salida;

    public Laboratorio(){
        this.experimentos = new ArrayList<Experimento>();
    }
    
    public void crearExperimento(){
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