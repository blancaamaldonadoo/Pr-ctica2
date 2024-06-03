package Controlador;
import java.util.*;

import InputOutput.*;
import ClasesLab.*;


public class Laboratorio implements Interfaces.ManejadorLaboratorio{

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
    
    public void crearExperimento(){
        Salida salida = new Salida();
        Experimento e= salida.pedirDatosExperimentos();
        experimentos.add(e);
        experimentoActual=e;    
        System.out.println("Bienvenido al experimento: '" +e.getNombre() + "'");
    }

    public Experimento cambiarNombreExperimento(Experimento experimento){
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