package Main;

import java.util.ArrayList;

import InputOutput.Comprobaciones;
import InputOutput.Ordenaciones;
import Modelo.Poblacion;

public class MainOrden {
    
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
