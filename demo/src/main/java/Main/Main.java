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


public class Main{

    private static Laboratorio laboratorio;

    public static void main(String[] args) throws IOException, ExceptionCantidad, ExcepcionFechas {
        laboratorio = new Laboratorio();
        System.out.println("\n¡Bienvenido al laboratorio de bacterias!");
        menuPrincipal();
    }

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

    public static void abrirArchivo() throws ExceptionCantidad, ExcepcionFechas{
        String nombre= Comprobaciones.leerString("Introduce el nombre del archivo: ");
        if(laboratorio.archivoExist(nombre)!=false){
            System.out.println("El archivo no existe.");
            menuPrincipal();
        }
        else{
        File f= new File(nombre);
        f= laboratorio.getArchivo(nombre);
        Archivos a= new Archivos(f);
        a.abrirArchivo(f);
        }
        
    }

    public static void simulacionExperimento() throws ExceptionCantidad, ExcepcionFechas{
        Experimento e= laboratorio.buscarExperimento();
        if(e==null) menuPrincipal();
        String nombrePob=Comprobaciones.leerString("Introduce el nombre de la población que quiera simular");
        Poblacion p=e.buscarPoblacion(nombrePob);
        if (p==null) menuPrincipal();
        int dias= Comprobaciones.leerInt("Introduce el número de días que quieres simular: ");
        SimulacionMonteCarlo simulacion = new SimulacionMonteCarlo(p,dias);
        //simulacion.imprimirSimulacion();
    }

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
                    break;
                }
    
                case 3:{
                    borrarPoblacion();
                    menuExperimento(e);
                    break;
                }
    
                case 4:{
                    verDetallesPoblacion();
                    break;
                }
    
                case 5:{
                    guardar(e);
                    break;
                }
    
                case 6:{
                    guardarComo(e);
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

    public static void borrarPoblacion(){
        System.out.println("Introduce el nombre de la población que quieres borrar: ");
        String nombre = Comprobaciones.leerString("");
        Poblacion p= laboratorio.getExperimentoActual().buscarPoblacion(nombre);
        laboratorio.getExperimentoActual().eliminarPoblacion(p);
    }

    public static void verDetallesPoblacion() throws ExceptionCantidad, ExcepcionFechas{
        System.out.println("Introduce el nombre de la población de la que quieres ver los detalles: ");
        String nombre = Comprobaciones.leerString("");
        Poblacion p= laboratorio.getExperimentoActual().buscarPoblacion(nombre);
        laboratorio.getExperimentoActual().verDetallesPoblacion(p);
        menuPrincipal();
    }

    public static void guardar(Experimento e){
        String nombre= Comprobaciones.leerString("Introduce el nombre del archivo: ");
        if(laboratorio.archivoExist(nombre)!=false){
           guardarComo(e);
        }
        else{
            File file = new File(nombre);
            Archivos a= new Archivos(nombre,file, e);
            a.guardar(e);
            laboratorio.addArchivo(a);
        }
    }

    public static void guardarComo(Experimento e){
        String nombre= Comprobaciones.leerString("Introduce el nombre del archivo: ");
        File file= new File(nombre);
        Archivos a= new Archivos(nombre,file,e);
        a.guardarComo(e);
        laboratorio.addArchivo(a);
    }

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

    