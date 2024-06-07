package Controlador;
import java.io.File;
import java.util.*;

import InputOutput.*;
import ClasesLab.*;

/**
 * Clase que modela el laboratorio.
 * El laboratorio tiene una lista de experimentos, un experimento actual y una lista de archivos.
 * @param experimentos Lista de experimentos del laboratorio.
 * @param experimentoActual Experimento actual.
 * @param archivos Lista de archivos del laboratorio.
 */

public class Laboratorio {

    private ArrayList<Experimento> experimentos;
    protected Experimento experimentoActual;
    private ArrayList<Archivos> archivos;

    /**
     * Constructor de la clase Laboratorio.
     * Inicializa las listas de experimentos y archivos.
     * Inicializa el experimento actual a null.
     * Inicializa el experimento actual a null.
     */

    public Laboratorio(){
        this.experimentoActual=null;
        this.archivos= new ArrayList<Archivos>();
        this.experimentos = new ArrayList<Experimento>();
    }

    /**
     * Getters y setters de la clase Laboratorio.
     * @return
     */

    public ArrayList<Experimento> getExperimentos(){
        return experimentos;
    }

    public void setExperimentos(ArrayList<Experimento> experimentos){
        this.experimentos = experimentos;
    }

    public ArrayList<Archivos> getArchivos(){
        return archivos;
    }

    public Experimento getExperimentoActual(){
        return experimentoActual;
    }

    public void setExperimentoActual(Experimento experimentoActual){
        this.experimentoActual = experimentoActual;
    }
    
    /**
     * Método que añade un archivo a la lista de archivos del laboratorio.
     * @param a
     */

    public void addArchivo(Archivos a){
        this.archivos.add(a);
    }

    /**
     * Método que verifica que el archivo existe.
     * @param a
     * @return
     */

    public boolean archivoExist(String nombre){
        for(Archivos a: archivos){
            if(a.getFile().getName().equals(nombre)){
                return true;
            }
        }
        return false;
    }

    /**
     * Método que busca un archivo por su nombre.
     * @param nombre
     * @return
     */

    public File getArchivo(String nombre){
        for(Archivos a: archivos){
            if(a.getFile().getName().equals(nombre)){
                return a.getFile();
            }
        }
        return null;
    }
    
    /**
     * Método que crea un experimento y lo añade a la lista de experimentos del laboratorio.
     * @return
     */

    public Experimento crearExperimento(){
        Salida salida = new Salida();
        Experimento e= salida.pedirDatosExperimentos();
        experimentos.add(e);
        experimentoActual=e;    
        System.out.println("Bienvenido al experimento: '" +e.getNombre() + "'");
        return e;
    }

    /**
     * Método que busca un experimento por su nombre.
     * @return
     */

    public Experimento buscarExperimento(){
        String nombre= Comprobaciones.leerString("Introduce el nombre del experimento: ");
        for(Experimento e: experimentos){
            if(e.getNombre().equals(nombre)){
                return e;
            }
        }
        System.out.println("No existe ningún experimento con ese nombre");
        return null;
    }

    /**
     * Método que añade un experimento del laboratorio.
     * @param e
     */

    public void addExperimento(Experimento e){
        experimentos.add(e);
        experimentoActual=e;
    }

    /**
     * Método que elimina un experimento del laboratorio.
     * @param e
     */

    public void eliminarExperimento(Experimento e){
        experimentos.remove(e);
    }

}