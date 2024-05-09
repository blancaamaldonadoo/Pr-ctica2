package Interfaces;

import Modelo.Experimento;

public interface ManejadorArchivos {
    public void guardarComo(Experimento e);
    public void guardar();
    public File getFileOfExperiment(Experimento e);
}
