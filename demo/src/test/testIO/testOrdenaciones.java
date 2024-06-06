import org.junit.jupiter.api.Test;
import InputOutput.Ordenaciones;
public class testOrdenaciones {
    @Test
    public void testOrdenCronologico() {
        Poblacion p1 = new Poblacion("Poblacion1", LocalDate.of(2021, 5, 5), LocalDate.of(2021, 5, 10), 100, 25.0, Luminosidad.ALTA, Dosis.BAJA);
        Poblacion p2 = new Poblacion("Poblacion2", LocalDate.of(2021, 5, 6), LocalDate.of(2021, 5, 11), 200, 30.0, Luminosidad.BAJA, Dosis.ALTA);
        Poblacion p3 = new Poblacion("Poblacion3", LocalDate.of(2021, 5, 7), LocalDate.of(2021, 5, 12), 300, 35.0, Luminosidad.MEDIA, Dosis.MEDIA);
        Poblacion[] poblaciones = {p2, p1, p3};
        Ordenaciones.ordenCronologico(poblaciones);
        assertEquals(p1, poblaciones[0]);
        assertEquals(p2, poblaciones[1]);
        assertEquals(p3, poblaciones[2]);
    }

    @Test
    public void testIntercambiarPoblaciones() {
        Poblacion p1 = new Poblacion("Poblacion1", LocalDate.of(2021, 5, 5), LocalDate.of(2021, 5, 10), 100, 25.0, Luminosidad.ALTA, Dosis.BAJA);
        Poblacion p2 = new Poblacion("Poblacion2", LocalDate.of(2021, 5, 6), LocalDate.of(2021, 5, 11), 200, 30.0, Luminosidad.BAJA, Dosis.ALTA);
        Poblacion[] poblaciones = {p1, p2};
        Ordenaciones.intercambiar(poblaciones, 0, 1);
        assertEquals(p2, poblaciones[0]);
        assertEquals(p1, poblaciones[1]);  
    }


    @Test
    public void testOrdenNombrePoblacion() {
        Poblacion p1 = new Poblacion("Poblacion1", LocalDate.of(2021, 5, 5), LocalDate.of(2021, 5, 10), 100, 25.0, Luminosidad.ALTA, Dosis.BAJA);
        Poblacion p2 = new Poblacion("Poblacion2", LocalDate.of(2021, 5, 6), LocalDate.of(2021, 5, 11), 200, 30.0, Luminosidad.BAJA, Dosis.ALTA);
        Poblacion p3 = new Poblacion("Poblacion3", LocalDate.of(2021, 5, 7), LocalDate.of(2021, 5, 12), 300, 35.0, Luminosidad.MEDIA, Dosis.MEDIA);
        Poblacion[] poblaciones = {p2, p1, p3};
        Ordenaciones.ordenNombrePoblacion(poblaciones);
        assertEquals(p1, poblaciones[0]);
        assertEquals(p2, poblaciones[1]);
        assertEquals(p3, poblaciones[2]);    
    }


    @Test
    public void testIntercambiar() {
        Poblacion p1 = new Poblacion("Poblacion1", LocalDate.of(2021, 5, 5), LocalDate.of(2021, 5, 10), 100, 25.0, Luminosidad.ALTA, Dosis.BAJA);
        Poblacion p2 = new Poblacion("Poblacion2", LocalDate.of(2021, 5, 6), LocalDate.of(2021, 5, 11), 200, 30.0, Luminosidad.BAJA, Dosis.ALTA);
        Poblacion[] poblaciones = {p1, p2};
        Ordenaciones.intercambiar(poblaciones, 0, 1);
        assertEquals(p2, poblaciones[0]);
        assertEquals(p1, poblaciones[1]);
    }

    @Test
    public void testOrdenNumBacterias() {
        Poblacion p1 = new Poblacion("Poblacion1", LocalDate.of(2021, 5, 5), LocalDate.of(2021, 5, 10), 100, 25.0, Luminosidad.ALTA, Dosis.BAJA);
        Poblacion p2 = new Poblacion("Poblacion2", LocalDate.of(2021, 5, 6), LocalDate.of(2021, 5, 11), 200, 30.0, Luminosidad.BAJA, Dosis.ALTA);
        Poblacion p3 = new Poblacion("Poblacion3", LocalDate.of(2021, 5, 7), LocalDate.of(2021, 5, 12), 300, 35.0, Luminosidad.MEDIA, Dosis.MEDIA);
        Poblacion[] poblaciones = {p2, p1, p3};
        Ordenaciones.ordenNumBacterias(poblaciones);
        assertEquals(p1, poblaciones[0]);
        assertEquals(p2, poblaciones[1]);
        assertEquals(p3, poblaciones[2]);
    }


}
