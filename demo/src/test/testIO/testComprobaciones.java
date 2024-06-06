import org.junit.jupiter.api.Test;
import InputOutput.Comprobaciones;
public class testComprobaciones {
    @Test
    public void testLeerString() {
        String mensaje = "Introduce un string";
        String resultado = Comprobaciones.leerString(mensaje);
        assertEquals("Hola", resultado);
    }

    @Test
    public void testLeerInt() {
        String mensaje = "Introduce un entero";
        int resultado = Comprobaciones.leerInt(mensaje);
        assertEquals(5, resultado);  
    }

    @Test
    public void testLeerDouble() {
        String mensaje = "Introduce un double";
        double resultado = Comprobaciones.leerDouble(mensaje);
        assertEquals(5.0, resultado);
    }
    @Test
    public void testLeerLong() {
        String mensaje = "Introduce un long";
        long resultado = Comprobaciones.leerLong(mensaje);
        assertEquals(5, resultado);
    }
    @Test
    public void testLeerFecha() {
        String mensaje = "Introduce una fecha";
        LocalDate resultado = Comprobaciones.leerFecha(mensaje);
        assertEquals(LocalDate.of(2021, 5, 5), resultado);
    }
    @Test
    public void testLeerLuminosidad() {
        String mensaje = "Introduce un nivel de luz";
        Luminosidad resultado = Comprobaciones.leerLuminosidad(mensaje);
        assertEquals(Luminosidad.ALTA, resultado);
    }
    @Test
    public void testLeerArchivo() {
        String mensaje = "Introduce un archivo";
        File resultado = Comprobaciones.leerArchivo(mensaje);
        assertEquals("archivo.txt", resultado.getName());
    }
}
