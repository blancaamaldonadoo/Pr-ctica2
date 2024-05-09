package Interfaces;

import Modelo.Experimento;

public interface ManejadorArchivos {
    public void guardarComo(Experimento e);
    public Archivo getFileOfExperiment(Experimento e);
    public void guardar();
    
}
