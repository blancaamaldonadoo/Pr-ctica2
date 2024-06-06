import org.junit.jupiter.api.Test;
import ClasesLab.Poblacion;

public class PoblacionTest {
    
    
    @Test
    public void testCrearDosis() {
        Poblacion p = new Poblacion();
        p.crearDosis(10);
        assertEquals(10, p.getDosis().size());
    }


    @Test
    public void testModificarDosis() {
        Poblacion p = new Poblacion();
        p.crearDosis(10);
        p.modificarDosis(0, 5);
        assertEquals(5, p.getDosis().get(0));       
    }


    @Test
    public void testVisualizarDosis() {
        Poblacion p = new Poblacion();
        p.crearDosis(10);
        String dosis = p.visualizarDosis();
        assertEquals("0 0 0 0 0 0 0 0 0 0", dosis);        
    }
}
