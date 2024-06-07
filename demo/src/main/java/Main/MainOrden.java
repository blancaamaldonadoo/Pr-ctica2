package Main;

import java.util.ArrayList;

import InputOutput.Comprobaciones;
import InputOutput.Ordenaciones;
import ClasesLab.Poblacion;

/**
 * Clase que modela el menú de ordenación de poblaciones.
 * El menú de ordenación tiene las opciones de ordenar por fecha de inicio, por nombre de población o por número de bacterias iniciales.
 * @param poblaciones Lista de poblaciones.
 */

public class MainOrden {
    
    /**
     * Método que muestra el menú de ordenación de poblaciones.
     * @param poblaciones Lista de poblaciones.
     */
    
    public static void MenuOrden(ArrayList<Poblacion> poblaciones){

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
