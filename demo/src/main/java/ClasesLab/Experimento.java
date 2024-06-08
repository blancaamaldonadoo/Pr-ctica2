package ClasesLab;
import java.io.Serializable;
import java.util.*;

import Excepciones.ExcepcionFechas;
import Excepciones.ExceptionCantidad;
import InputOutput.Salida;

/**
 * Clase que modela un experimento en el laboratorio.
 * Un experimento tiene un nombre y una lista de poblaciones.
 * @param nombre Nombre del experimento.
 * @param poblaciones Lista de poblaciones del experimento.
 */

public class Experimento implements Serializable{

    private String nombre;
    private ArrayList<Poblacion> poblaciones;
    
    /**
     * Constructor de la clase Experimento.
     * Inicializa la lista de poblaciones.
     */

    public Experimento(){
        this.poblaciones = new ArrayList<Poblacion>();
    }

    /**
     * Constructor de la clase Experimento.
     * @param nombre
     * @param poblaciones
     */

    public Experimento(String nombre, ArrayList<Poblacion> poblaciones){
        this.nombre = nombre;
        this.poblaciones = poblaciones;
    }    
    
    /**
     * Getters y setters de la clase Experimento.
     * @return
     */


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
    
    /**
     * Método que añade una población al experimento.
     * @param p
     */

    public void verDetallesPoblacion(Poblacion p){
        if(poblaciones.contains(p))
        System.out.println(p.toString());
        else System.out.println("No existe la poblacion");
    }

    /**
     * Método que crea una población.
     * @return
     * @throws ExceptionCantidad
     * @throws ExcepcionFechas
     */
    
    public Poblacion crearPoblacion() throws ExceptionCantidad, ExcepcionFechas{
       Salida salida= new Salida();
       Poblacion p= salida.pedirDatosPoblacion();
       poblaciones.add(p);
       return p;
    }
    
    /**
     * Método que visualiza los nombres de las poblaciones.
     * @return
     */

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

    /**
     * Método que busca una población por su nombre.
     * @param nombre
     * @return
     */

    public Poblacion buscarPoblacion(String nombre){
        Poblacion pob=null;
        if(poblaciones.isEmpty()){
            System.out.println("No hay poblaciones en el experimento");
        }
        else{
        for(Poblacion p: poblaciones){
            if(p.getNombre().equals(nombre)){
                pob=p;
                return pob;
            }
        }
    }
        return pob;
    }

    /**
     * Método que elimina una población del experimento.
     * @param p
     */

    public void addPoblacion(Poblacion p){
        poblaciones.add(p);
    }

    /**
     * Método que elimina una población del experimento.
     * @param p
     */

    public void eliminarPoblacion(Poblacion p){
        poblaciones.remove(p);
    }

    
}