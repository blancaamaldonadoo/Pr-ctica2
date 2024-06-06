import org.junit.jupiter.api.Test;

import ClasesLab.Dosis;
public class DosisTest {
    
    @Test
    public void testCalcularDosisConstante() {
        Dosis dosis = new Dosis(10, 100);
        assertEquals(dosis.calcularDosisConstante(), 100);
    }

    @Test
    public void testCalcularDosisInicioFin() {
        Dosis dosis = new Dosis(10, 100, 200);
        assertEquals(dosis.calcularDosisInicioFin(), 100);
    }

    @Test
    public void testCalcularDosisIntermitente() {
        Dosis dosis = new Dosis(10, 100, 5, 200, 300);
        assertEquals(dosis.calcularDosisIntermitente(), 100);       
    }

    @Test
    public void testGetDosisMax() {
        Dosis dosis = new Dosis(10, 100, 5, 200, 300);
        assertEquals(dosis.getDosisMax(), 300);      
    }

}
