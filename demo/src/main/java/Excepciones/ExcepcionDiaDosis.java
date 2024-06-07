package Excepciones;

/**
 * Excepción que se lanza cuando el día de la dosis es mayor a la duración de la dosis.
 */

public class ExcepcionDiaDosis extends Exception{
    public ExcepcionDiaDosis(String mensaje){
        super(mensaje);
    }
}
