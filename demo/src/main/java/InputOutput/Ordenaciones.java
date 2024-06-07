package InputOutput;

import java.util.ArrayList;

import ClasesLab.Poblacion;

/**
 * Clase que modela las ordenaciones de las poblaciones.
 * Las ordenaciones pueden ser cronológicas, por nombre de población o por número de bacterias.
 */

public class Ordenaciones {

    /**
     * Método que ordena las poblaciones de forma cronológica.
     * @param poblaciones Lista de poblaciones a ordenar.
     * @return Lista de poblaciones ordenadas de forma cronológica.
     */

    public static ArrayList<Poblacion> ordenCronologico(ArrayList<Poblacion> poblaciones){
        for(int i = 0; i< poblaciones.size()-1; i++) {
            for(int j = 0; j<poblaciones.size()-1-i; j++) {
                if(poblaciones.get(j).getFechaInicio().isAfter(poblaciones.get(j+1).getFechaInicio()));
                intercambiarPoblaciones(poblaciones, j, j+1);
                }
            }
        return poblaciones;
    }

    /**
     * Método que intercambia dos poblaciones de una lista.
     * @param poblaciones Lista de poblaciones.
     * @param pos1 Posición de la primera población.
     * @param pos2 Posición de la segunda población.
     */
    
    public static void intercambiarPoblaciones(ArrayList<Poblacion> poblaciones, int pos1, int pos2) {
        Poblacion aux = poblaciones.get(pos1);
        poblaciones.set(pos1, poblaciones.get(pos2));
        poblaciones.set(pos2, aux);
    }

    /**
     * Método que ordena las poblaciones por nombre.
     * @param poblaciones Lista de poblaciones a ordenar.
     * @return Lista de poblaciones ordenadas por nombre.
     */

    public static ArrayList<Poblacion> ordenNombrePoblacion(ArrayList<Poblacion> poblaciones){
        for(int i = 0; i< poblaciones.size()-1; i++) {
            for(int j = 0; j<poblaciones.size()-1-i; j++) {
                if(poblaciones.get(j).getNombre().compareTo(poblaciones.get(j+1).getNombre())>0);
                intercambiarPoblaciones(poblaciones, j, j+1);
                }
            }
        return poblaciones;

    }

    /**
     * Método que ordena las poblaciones por número de bacterias.
     * @param poblaciones Lista de poblaciones a ordenar.
     * @return Lista de poblaciones ordenadas por número de bacterias.
     */
    
    public static void intercambiar(float[] datos, int pos1, int pos2) {
		float aux = datos[pos1];
		datos[pos1] = datos[pos2];
		datos[pos2] = aux;
	}
    
    /**
     * Método que ordena las poblaciones por número de bacterias.
     * @param poblaciones
     * @return
     */

    public static ArrayList<Poblacion> ordenNumBacterias(ArrayList<Poblacion> poblaciones){
        float [] numBacterias = new float[poblaciones.size()];
        for(int i = 0; i< numBacterias.length-1; i++) {
            for(int j = 0; j<numBacterias.length-1-i; j++) {
                if(numBacterias[j] > (numBacterias[j+1]));
                intercambiar(numBacterias, j, j+1);
                }
            }
        return poblaciones;
        }
    }
    