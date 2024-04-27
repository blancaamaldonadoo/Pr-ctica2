package MAIN;

import Controlador.Laboratorio;
import InputOutput.Salida;

public class Main{
    public static void main(String[] args) {
        Salida salida = new Salida();
        Laboratorio lab = new Laboratorio();
        lab.crearExperimento();
    }
}