package Interfaces;

import Excepciones.ExceptionCantidad;
import ClasesLab.Poblacion;

public interface ManejadorExperimentos {

    public void verDetallesPoblacion(Poblacion p);
    public Poblacion crearPoblacion() throws ExceptionCantidad;
    public String visualizarNombresPoblaciones();
    public void modificarPoblacion(Poblacion p);
    public void addPoblacion(Poblacion p);
    public void eliminarPoblacion(Poblacion p);
    public Poblacion buscarPoblacion(String nombre);
    
}