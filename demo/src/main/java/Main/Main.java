package Main;
import java.io.*;
import java.util.ArrayList;

import Excepciones.ExcepcionFechas;
import Excepciones.ExceptionCantidad;
import InputOutput.Archivos;
import InputOutput.Comprobaciones;
import InputOutput.Ordenaciones;
import SimulacionBacterias.SimulacionMonteCarlo;
import ClasesLab.Experimento;
import ClasesLab.Poblacion;
import Controlador.Laboratorio;

/**
 * Clase que modela el menú principal del laboratorio de bacterias.
 * El menú principal tiene las opciones de abrir un experimento, crear un nuevo experimento y simular un experimento.
 * @param laboratorio Laboratorio.
 */

public class Main{

    private static Laboratorio laboratorio;

    /**
     * Método principal del laboratorio de bacterias.
     * @param args
     * @throws IOException
     * @throws ExceptionCantidad
     * @throws ExcepcionFechas
     */

    public static void main(String[] args) throws IOException, ExceptionCantidad, ExcepcionFechas {
        laboratorio = new Laboratorio();
        System.out.println("\n¡Bienvenido al laboratorio de bacterias!");
        menuPrincipal();
    }

    /**
     * Método que muestra el menú principal del laboratorio de bacterias.
     * @throws ExceptionCantidad
     * @throws ExcepcionFechas
     */

    public static void menuPrincipal() throws ExceptionCantidad, ExcepcionFechas{
        System.out.println("\nElige una opción: ");
        System.out.println("1. Abrir un experimento ");
        System.out.println("2. Crear un nuevo experimento ");
        System.out.println("3. Simular un experimento ");

        int opcion = Comprobaciones.leerInt("");
        switch(opcion){
                
                case 1:{
                    abrirArchivo();
                    break;
                }
    
                case 2:{
                    Experimento e= laboratorio.crearExperimento();
                    laboratorio.setExperimentoActual(e);
                    menuExperimento(e);
                    break;
                }

                case 3:{
                    simulacionExperimento();
                    break;
                }
    
                default:{
                    System.out.println("Opción no válida");
                    break;
                }
        }
    }

    /**
     * Método que abre un archivo.
     * @throws ExceptionCantidad
     * @throws ExcepcionFechas
     */

    public static void abrirArchivo() throws ExceptionCantidad, ExcepcionFechas{
        System.out.println("Introduce el nombre del archivo: ");
        String nombre = Comprobaciones.leerString("");
        File archivo = new File(nombre + ".csv");
        if(archivo.exists()){
            Archivos archivos = new Archivos(archivo);
            try {
                Experimento e = archivos.abrirArchivo(archivo);
                if (e != null) {
                    laboratorio.setExperimentoActual(e);
                    laboratorio.addArchivo(archivos);
                    menuExperimento(e);
                }
            }catch (ExceptionCantidad | ExcepcionFechas ex) {
                System.out.println("Error al abrir el experimento.");
                ex.printStackTrace();
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }

    /**
     * Método que simula un experimento.
     * @throws ExceptionCantidad
     * @throws ExcepcionFechas
     */

    public static void simulacionExperimento() throws ExceptionCantidad, ExcepcionFechas{
        Experimento e= laboratorio.buscarExperimento();
        if(e==null) menuPrincipal();
        String nombrePob=Comprobaciones.leerString("Introduce el nombre de la población que quiera simular");
        Poblacion p=e.buscarPoblacion(nombrePob);
        if (p==null) menuPrincipal();
        int dias= Comprobaciones.leerInt("Introduce el número de días que quieres simular: ");
        SimulacionMonteCarlo simulacion = new SimulacionMonteCarlo(p,dias);
        simulacion.ejecutarSimulacion();
        menuPrincipal();
    }

    /**
     * Método que muestra el menú de un experimento.
     * @param e Experimento.
     * @throws ExceptionCantidad
     * @throws ExcepcionFechas
     */

    public static void menuExperimento(Experimento e) throws ExceptionCantidad, ExcepcionFechas{
        System.out.println("\nElige una opción: ");
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
                    Poblacion p = e.crearPoblacion();
                    laboratorio.getExperimentoActual().addPoblacion(p);
                    menuExperimento(e);
                    break;
                }
    
                case 2:{
                    visualizarNombresPoblaciones(e);
                    menuExperimento(e);
                    break;
                }
    
                case 3:{
                    borrarPoblacion();
                    menuExperimento(e);
                    break;
                }
    
                case 4:{
                    verDetallesPoblacion(e);
                    break;
                }
    
                case 5:{
                    guardarExperimento(e);
                    break;
                }
    
                case 6:{
                    guardarExperimentoComo(e);
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

    /**
     * Método que visualiza los nombres de las poblaciones de un experimento.
     * @param e
     * @throws ExceptionCantidad
     * @throws ExcepcionFechas
     */

    public static void visualizarNombresPoblaciones(Experimento e) throws ExceptionCantidad, ExcepcionFechas{
        if(e.getPoblaciones().isEmpty()){
            System.out.println("No hay poblaciones en el experimento actual");
            menuExperimento(e);
        }
        else{
        ArrayList<Poblacion> poblaciones = new ArrayList<Poblacion>();
        poblaciones= e.getPoblaciones();
        menuOrden(poblaciones);
        }
    }

    /**
     * Método que borra una población de un experimento.
     */

    public static void borrarPoblacion(){
        System.out.println("Introduce el nombre de la población que quieres borrar: ");
        String nombre = Comprobaciones.leerString("");
        Poblacion p= laboratorio.getExperimentoActual().buscarPoblacion(nombre);
        laboratorio.getExperimentoActual().eliminarPoblacion(p);
    }

    /**
     * Método que muestra los detalles de una población.
     * @throws ExceptionCantidad
     * @throws ExcepcionFechas
     */

    public static void verDetallesPoblacion(Experimento e) throws ExceptionCantidad, ExcepcionFechas{
        System.out.println("Introduce el nombre de la población de la que quieres ver los detalles: ");
        String nombre = Comprobaciones.leerString("");
        laboratorio.setExperimentoActual(e);
        Poblacion p= laboratorio.getExperimentoActual().buscarPoblacion(nombre);
        laboratorio.getExperimentoActual().verDetallesPoblacion(p);
        menuPrincipal();
    }

    /**
     * Método que guarda un experimento.
     * @param e
     * @throws ExcepcionFechas 
     * @throws ExceptionCantidad 
     */

    public static void guardarExperimento(Experimento e) throws ExceptionCantidad, ExcepcionFechas{
        Archivos archivos = new Archivos(e.getNombre());
        Experimento experimento = new Experimento();
        try {
            archivos.guardar(experimento);
        } catch (IOException ex) {
            System.out.println("Error al guardar el experimento.");
            ex.printStackTrace();
        }
        menuPrincipal();
    }

    /**
     * Método que guarda un experimento como.
     * @param e
     */

    public static void guardarExperimentoComo(Experimento e){
        Archivos archivos = new Archivos(e.getNombre());
        Experimento experimento = new Experimento();
        File newFile = new File("ruta/del/archivo.csv");
        archivos.guardarComo(experimento, newFile);
    }

    /**
     * Método que permite elegir el orden las poblaciones de un experimento.
     * @param poblaciones
     */

    public static void menuOrden(ArrayList<Poblacion> poblaciones){

        System.out.println("Elige una opción: ");
        System.out.println("1. Ordenar por fecha de inicio ");
        System.out.println("2. Ordenar por nombre de población ");
        System.out.println("3. Ordenar por número de bacterias iniciales ");
        int opcion= Comprobaciones.leerInt("");

        switch(opcion){

            case 1:{
                System.out.println(Ordenaciones.ordenCronologico(poblaciones));
                break;
            }

            case 2:{
                System.out.println(Ordenaciones.ordenNombrePoblacion(poblaciones));
                break;
            }

            case 3:{
                System.out.println(Ordenaciones.ordenNumBacterias(poblaciones));
                break;
            }

            default:{
                System.out.println("Opción no válida, por favor, elija una opción válida.");
                menuOrden(poblaciones);
                break;
            }
        }
    }

}

    