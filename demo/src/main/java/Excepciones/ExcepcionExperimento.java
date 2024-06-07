package Excepciones;

/**
 * Excepción que se lanza cuando se intenta realizar un experimento con fechas incorrectas.
 */

 public class ExcepcionExperimento extends Exception{

    public ExcepcionExperimento(String mensaje){
        super(mensaje);
    }
    
}