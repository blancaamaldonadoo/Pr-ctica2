import org.junit.jupiter.api.Test;

import ClasesLab.Poblacion;

import static org.junit.jupiter.api.Assertions.*;


   public class ExperimentoTest {

        @Test
        public void testVerDetallesPoblacion() {
            Experimento experimento = new Experimento();
            Poblacion p = new Poblacion();
            p.setNombre("Test");
            experimento.verDetallesPoblacion(p);
            assertEquals("Test", p.getNombre());
        }

        @Test
        public void testCrearPoblacion() {
            Experimento experimento = new Experimento();
            Poblacion p = experimento.crearPoblacion();
            assertNotNull(p);
        }


        @Test
        public void testVisualizarNombresPoblacion() {
            Experimento experimento = new Experimento();
            numBacterias = 10;
            experimento.addPoblacion(new Poblacion("Test", numBacterias));
            String nombres = experimento.visualizarNombresPoblacion();
            assertEquals("Test", nombres);
        }

        @Test
        public void testBuscarPoblacion() {
            Experimento experimento = new Experimento();
            Poblacion p = new Poblacion("Test", 10);
            experimento.addPoblacion(p);
            Poblacion pob = experimento.buscarPoblacion("Test");
            assertEquals(p, pob);
        }


        @Test
        public void testAddPoblacion() {
            Experimento experimento = new Experimento();
            Poblacion p = new Poblacion("Test", 10);
            experimento.addPoblacion(p);
            assertTrue(experimento.getPoblaciones().contains(p));
        }

        @Test
        public void testRemovePoblacion() {
            Experimento experimento = new Experimento();
            Poblacion p = new Poblacion("Test", 10);
            experimento.addPoblacion(p);
            experimento.removePoblacion(p);
            assertFalse(experimento.getPoblaciones().contains(p));
        }

        @Test
        public void testGetResult() {
            Experimento experimento = new Experimento();
            experimento.setResult("Test");
            String result = experimento.getResult();
            assertEquals("Test", result);
        }
    }

