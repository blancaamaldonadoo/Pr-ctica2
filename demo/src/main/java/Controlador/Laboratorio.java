package Controlador;
import java.util.*;

import Excepciones.ExceptionCantidad;
import InputOutput.*;
import Modelo.*;


public class Laboratorio {
 
    private ArrayList<Experimento> experimentos;

    public Laboratorio(){
        this.experimentos = new ArrayList<Experimento>();
    }
    
    public void crearExperimento() throws ExceptionCantidad{
        //createNewFile();
        Salida salida = new Salida();
        salida.pedirDatosExperimentos();
    }

    public Experimento CambiarNombreExperimento(Experimento experimento){
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce el nuevo nombre del Experimento: ");
        String nombre=sc.nextLine();
        sc.close();

        if(nombre.isEmpty()){
            System.out.println("No se ha introducido ningún nombre");
            return experimento;
        }else if(nombre.equals(experimento.getNombre())){
            System.out.println("El nombre introducido es el mismo que el actual");
            return experimento;
        }        
        experimento.setNombre(nombre);
        return experimento;
    }

    public void addExperimento(Experimento e){
        experimentos.add(e);
    }


    public void eliminarExperimento(Experimento e){
        experimentos.remove(e);
    }

    public Experimento accederExperimentoActual(){
        return experimentos.get(experimentos.size()-1); //Habría que localizar el file o así vale???
    }

}