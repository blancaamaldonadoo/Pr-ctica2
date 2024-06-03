package Interfaces;

import ClasesLab.Experimento;
import InputOutput.Archivos;

public interface ManejadorLaboratorio {
    public Experimento crearExperimento();
    public void addArchivo(Archivos s);
    public Experimento cambiarNombreExperimento(Experimento experimento);
    public void addExperimento(Experimento e);
    public void eliminarExperimento(Experimento e);
    public Experimento getExperimentoActual();
}
