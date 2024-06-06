import org.junit.jupiter.api.Test;

public class LaboratorioTest {

    @Test
    public void testCrearExperimento() {
        Laboratorio lab = new Laboratorio();
        Experimento e = lab.crearExperimento();
        assertEquals(e.getNombre(), "Experimento 1");
        assertEquals(e.getDescripcion(), "Experimento 1");
        assertEquals(e.getFecha(), "Experimento 1");
        assertEquals(e.getInvestigador(), "Experimento 1");
        assertEquals(e.getObjetivo(), "Experimento 1");
        assertEquals(e.getObservaciones(), "Experimento 1");
        assertEquals(e.getTipo(), "Experimento 1");
    }
     
    @Test
    public void testBuscarExperimento() {
        Laboratorio lab = new Laboratorio();
        Experimento e = lab.crearExperimento();
        Experimento e2 = lab.buscarExperimento();
        assertEquals(e.getNombre(), e2.getNombre());
        assertEquals(e.getDescripcion(), e2.getDescripcion());
        assertEquals(e.getFecha(), e2.getFecha());
        assertEquals(e.getInvestigador(), e2.getInvestigador());
        assertEquals(e.getObjetivo(), e2.getObjetivo());
        assertEquals(e.getObservaciones(), e2.getObservaciones());
        assertEquals(e.getTipo(), e2.getTipo());
    }    

    @Test
    public void testCambiarNombreExperimento() {
        Laboratorio lab = new Laboratorio();
        Experimento e = lab.crearExperimento();
        lab.cambiarNombreExperimento("Experimento 2");
        assertEquals(e.getNombre(), "Experimento 2");
    }

    @Test
    public void testAddExperimento() {
        Laboratorio lab = new Laboratorio();
        Experimento e = lab.crearExperimento();
        lab.addExperimento(e);
        assertEquals(lab.getExperimentos().size(), 1);
    }

    @Test
    public void testEliminarExperimento() {
        Laboratorio lab = new Laboratorio();
        Experimento e = lab.crearExperimento();
        lab.eliminarExperimento(e);
        assertEquals(lab.getExperimentos().size(), 0);
    }



}
