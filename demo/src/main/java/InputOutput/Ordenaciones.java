package InputOutput;

import java.util.ArrayList;

import ClasesLab.Poblacion;

public class Ordenaciones {

    public static ArrayList<Poblacion> ordenCronologico(ArrayList<Poblacion> poblaciones){
        for(int i = 0; i< poblaciones.size()-1; i++) {
            for(int j = 0; j<poblaciones.size()-1-i; j++) {
                if(poblaciones.get(j).getFechaInicio().isAfter(poblaciones.get(j+1).getFechaInicio()));
                intercambiarPoblaciones(poblaciones, j, j+1);
                }
            }
        return poblaciones;
    }
    
    public static void intercambiarPoblaciones(ArrayList<Poblacion> poblaciones, int pos1, int pos2) {
        Poblacion aux = poblaciones.get(pos1);
        poblaciones.set(pos1, poblaciones.get(pos2));
        poblaciones.set(pos2, aux);
    }

    public static ArrayList<Poblacion> ordenNombrePoblacion(ArrayList<Poblacion> poblaciones){
        for(int i = 0; i< poblaciones.size()-1; i++) {
            for(int j = 0; j<poblaciones.size()-1-i; j++) {
                if(poblaciones.get(j).getNombre().compareTo(poblaciones.get(j+1).getNombre())>0);
                intercambiarPoblaciones(poblaciones, j, j+1);
                }
            }
        return poblaciones;

    }
    
    public static void intercambiar(float[] datos, int pos1, int pos2) {
		float aux = datos[pos1];
		datos[pos1] = datos[pos2];
		datos[pos2] = aux;
	}
    
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
    