package ClasesLab;
import java.time.LocalDate;

import Excepciones.ExceptionCantidad;
import InputOutput.Salida;

/**
 * Clase que modela una población de bacterias en el laboratorio.
 * Una población tiene un nombre, una fecha de inicio, una fecha de fin, un número de bacterias iniciales, una temperatura, un nivel de luz y una dosis de antibiótico.
 * @param nombre Nombre de la población.
 * @param fechaInicio Fecha de inicio de la población.
 * @param fechaFin Fecha de fin de la población.
 * @param numBacteriasIniciales Número de bacterias iniciales.
 * @param temperatura Temperatura de la población.
 * @param nivelLuz Nivel de luz de la población.
 * @param dosis Dosis de comida de la población.
 */

public class Poblacion extends Experimento{
    
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int numBacteriasIniciales;
    private double temperatura;
    private Luminosidad nivelLuz;
    private Dosis dosis;

    /**
     * Constructor de la clase Población.
     * @param nombre
     * @param fechaInicio
     * @param fechaFin
     * @param numBacteriasIniciales
     * @param temperatura
     * @param nivelLuz
     * @param dosis
     */

    public Poblacion(String nombre, LocalDate fechaInicio, LocalDate fechaFin, int numBacteriasIniciales, double temperatura, Luminosidad nivelLuz, Dosis dosis) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numBacteriasIniciales = numBacteriasIniciales;
        this.temperatura = temperatura;
        this.dosis=dosis;
        this.nivelLuz = nivelLuz;
    }

    /**
     * Constructor de la clase Población.
     * @param nombre
     * @param numBacteriasIniciales
     */

    public Poblacion(String nombre, int numBacteriasIniciales){
        this.nombre=nombre;
        this.numBacteriasIniciales=numBacteriasIniciales;
    }

    /**
     * Constructor de la clase Población.
     */

    public Poblacion(){
    }

    /**
     * Getters y setters de la clase Poblacion.
     * @return
     */

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public LocalDate getFechaInicio(){
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio){
        this.fechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin(){
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin){
        this.fechaFin = fechaFin;
    }
    public int getNumBacteriasIniciales(){
        return numBacteriasIniciales;
    }

    public void setNumBacteriasIniciales(int numBacteriasIniciales){
        this.numBacteriasIniciales = numBacteriasIniciales;
    }
    public double getTemperatura(){
        return temperatura;
    }
    public void setTemperatura(double temperatura){
        this.temperatura = temperatura;
    }
    public Luminosidad getNivelLuz(){
        return nivelLuz;
    }
    public void setNivelLuz(Luminosidad nivelLuz){
        this.nivelLuz = nivelLuz;
    }
    public Dosis getDosis(){
        return dosis;
    }
    public void setDosis(Dosis dosis){
        this.dosis = dosis;
    }

    /**
     * Método que muestra los detalles de una población.
     * @return
     */

    @Override
    public String toString() {
        String texto="";
        texto+="Nombre: "+nombre+"\n";
        texto+="Fecha de inicio: "+fechaInicio+"\n";
        texto+="Fecha de fin: "+fechaFin+"\n";
        texto+="Número de bacterias iniciales: "+numBacteriasIniciales+"\n";
        texto+="Temperatura: "+temperatura+"\n";
        texto+="Nivel de luz: "+nivelLuz+"\n";
        texto+="Dosis: "+dosis+"\n";
        return texto;
    }

    /**
     * Método que crea una dosis.
     * @throws ExceptionCantidad
     */

    public void crearDosis() throws ExceptionCantidad{
        Salida salida= new Salida(); 
        dosis=salida.opcionesDosis();
    }

    /**
     * Método que modifica una dosis.
     * @param dosis
     * @throws ExceptionCantidad
     */

    public void modificarDosis(Dosis dosis) throws ExceptionCantidad{
        Salida salida= new Salida();
        salida.datosModificarDosis(dosis);
    }

    /**
     * Método que visualiza una dosis.
     * @param d
     */
    
    public void visualizarDosis(Dosis d){
        System.out.println(d.toString());
    }
    
    public static Poblacion fromString(String s) throws ExceptionCantidad {
        String[] partes = s.split(",");
        String nombre = partes[0];
        LocalDate fechaInicio = LocalDate.parse(partes[1]);
        LocalDate fechaFin = LocalDate.parse(partes[2]);
        int numBacteriasIniciales = Integer.parseInt(partes[3]);
        double temperatura = Double.parseDouble(partes[4]);
        Luminosidad nivelLuz = Luminosidad.valueOf(partes[5]);
        Dosis dosis = Dosis.valueOf(partes[6]);
        return new Poblacion(nombre, fechaInicio, fechaFin, numBacteriasIniciales, temperatura, nivelLuz, dosis);
    }
}