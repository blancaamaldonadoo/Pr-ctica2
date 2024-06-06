import org.junit.jupiter.api.Test;

import ClasesLab.Dosis;
import InputOutput.Salida;
public class testSalida {
    Salida salida= new Salida();

    @Test
    public void testPedirDatosPoblacion() {
        String nombre = "Poblacion1";
        LocalDate fechaInicio = LocalDate.of(2021, 5, 5);
        LocalDate fechaFin = LocalDate.of(2021, 5, 10);
        int numBacteriasIniciales = 100;
        double temperatura = 25.0;
        Luminosidad nivelLuz = Luminosidad.ALTA;
        Dosis dosis = Dosis.BAJA;
        Poblacion resultado = salida.pedirDatosPoblacion();
        assertEquals(nombre, resultado.getNombre());
        assertEquals(fechaInicio, resultado.getFechaInicio());
        assertEquals(fechaFin, resultado.getFechaFin());
        assertEquals(numBacteriasIniciales, resultado.getNumBacteriasIniciales());
        assertEquals(temperatura, resultado.getTemperatura());
        assertEquals(nivelLuz, resultado.getNivelLuz());
        assertEquals(dosis, resultado.getDosis());       
    }

    @Test
    public void testComprobarFechas() {
        LocalDate fechaInicio = LocalDate.of(2021, 5, 5);
        LocalDate fechaFin = LocalDate.of(2021, 5, 10);
        LocalDate[] resultado = salida.comprobarFechas();
        assertEquals(fechaInicio, resultado[0]);
        assertEquals(fechaFin, resultado[1]);
    }

    @Test
    public void testComprobarCantidadComida() {
        long cantidad = 200;
        salida.comprobarCantidadComida(cantidad);
        assertEquals(200, cantidad);
    }


    @Test
    public void testCalcularDosisConstante() {
        double dosis = 0.5;
        double resultado = salida.calcularDosisConstante();
        assertEquals(dosis, resultado);     
    }
 
    @Test
    public void testCalcularDosisInicioFin() {
        double dosis = 0.5;
        double resultado = salida.calcularDosisInicioFin();
        assertEquals(dosis, resultado);
    }


    @Test
    public void testCalcularDosisIntermitente() {
        double dosis = 0.5;
        double resultado = salida.calcularDosisIntermitente();
        assertEquals(dosis, resultado);   
    }


    @Test
    public void testDatosModificarDosis() {
        double dosis = 0.5;
        double resultado = salida.datosModificarDosis();
        assertEquals(dosis, resultado);
    }

}
