package Excepciones;

/**
 * Excepción que se lanza cuando se intenta realizar un experimento con una cantidad incorrecta.
 */

public class ExceptionCantidad extends Exception{
    public ExceptionCantidad(String mensaje){
        super(mensaje);
    } 
}
