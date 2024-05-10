package Interfaces;

import java.io.File;

import Modelo.Experimento;

public interface ManejadorArchivos {
    public void guardarComo(Experimento e);
    public File getFileOfExperiment(Experimento e);
    public void guardar(Experimento e);
    
}
