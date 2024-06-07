package Excepciones;

/**
 * Excepción que se lanza cuando se intenta realizar un experimento con fechas incorrectas.
 */

public class ExcepcionFechas extends Exception{
    public ExcepcionFechas(String mensaje){
        super(mensaje);
    } 
}
