package Main;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Excepciones.ExceptionCantidad;
import InputOutput.Comprobaciones;
import InputOutput.Ordenaciones;
import Interfaces.ManejadorExperimentos;
import Interfaces.ManejadorLaboratorio;
import Modelo.Poblacion;


public class Main{

    private static ManejadorLaboratorio labManager;
    private static ManejadorExperimentos expManager;
    public static void main(String[] args) throws IOException, ExceptionCantidad {
        menuPrincipal();
    }

    public static void menuPrincipal() throws ExceptionCantidad{
        System.out.println("\n¡Bienvenido al laboratorio de bacterias!");
        System.out.println("Elige una opción: ");
        System.out.println("1. Abrir un experimento ");
        System.out.println("2. Crear un nuevo experimento ");

        int opcion = Comprobaciones.leerInt("");
        switch(opcion){
                
                case 1:{
                    //abrirArchivo();
                    break;
                }
    
                case 2:{
                    labManager.crearExperimento();
                    menuExperimento();
                    break;
                }
    
                default:{
                    System.out.println("Opción no válida");
                    break;
                }
        }
    }

    public static void menuExperimento() throws ExceptionCantidad{
        System.out.println("Elige una opción: ");
        System.out.println("1. Crear una población de bacterias y añadirla al experimento actual");
        System.out.println("2. Visualizar los nombres de todas las poblaciones de bacterias");
        System.out.println("3. Borrar una población de bacterias");
        System.out.println("4. Ver información detallada de una población de bacterias");
        System.out.println("5. Guardar");
        System.out.println("6. Guardar como");
        System.out.println("7. Volver al menú principal");

        int opcion = Comprobaciones.leerInt("");
        switch(opcion){
                
                case 1:{
                    expManager.crearPoblacion();
                    break;
                }
    
                case 2:{
                    visualizarNombresPoblaciones();
                    break;
                }
    
                case 3:{
                    borrarPoblacion();
                    break;
                }
    
                case 4:{
                    verDetallesPoblacion();
                    break;
                }
    
                case 5:{
                    //guardar();
                    break;
                }
    
                case 6:{
                    //guardarComo();
                    break;
                }
    
                case 7:{
                    menuPrincipal();
                    break;
                }
    
                default:{
                    System.out.println("Opción no válida");
                    break;
                }
        }
    }

    public static void visualizarNombresPoblaciones(){
        ArrayList<Poblacion> poblaciones = 
        menuOrden(poblaciones);
        expManager.visualizarNombresPoblaciones();
    }

    public static void borrarPoblacion(){
        System.out.println("Introduce el nombre de la población que quieres borrar: ");
        String nombre = Comprobaciones.leerString("");
        Poblacion p= expManager.buscarPoblacion(nombre);
        expManager.eliminarPoblacion(p);
    }

    public static void verDetallesPoblacion(){
        System.out.println("Introduce el nombre de la población de la que quieres ver los detalles: ");
        String nombre = Comprobaciones.leerString("");
        Poblacion p= expManager.buscarPoblacion(nombre);
        expManager.verDetallesPoblacion(p);
    }

    public static void menuOrden(ArrayList<Poblacion> poblaciones){

        System.out.println("Elige una opción: ");
        System.out.println("1. Ordenar por fecha de inicio ");
        System.out.println("2. Ordenar por nombre de población ");
        System.out.println("3. Ordenar por número de bacterias iniciales ");
        int opcion= Comprobaciones.leerInt("");

        switch(opcion){

            case 1:{
                Ordenaciones.ordenCronologico(poblaciones);
                break;
            }

            case 2:{
                Ordenaciones.ordenNombrePoblacion(poblaciones);
                break;
            }

            case 3:{
                Ordenaciones.ordenNumBacterias(poblaciones);
                break;
            }

            default:{
                System.out.println("Opción no válida, por favor, elija una opción válida.");
                MenuOrden(poblaciones);
                break;
            }
        }
    }

}

    