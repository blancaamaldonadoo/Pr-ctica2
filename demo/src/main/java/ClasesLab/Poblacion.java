package ClasesLab;
import java.time.LocalDate;

import Excepciones.ExceptionCantidad;
import InputOutput.Salida;

public class Poblacion extends Experimento{
    
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int numBacteriasIniciales;
    private double temperatura;
    private Luminosidad nivelLuz;
    private Dosis dosis;

    public Poblacion(String nombre, LocalDate fechaInicio, LocalDate fechaFin, int numBacteriasIniciales, double temperatura, Luminosidad nivelLuz, Dosis dosis) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numBacteriasIniciales = numBacteriasIniciales;
        this.temperatura = temperatura;
        this.dosis=dosis;
        this.nivelLuz = nivelLuz;
    }

    public Poblacion(String nombre, int numBacteriasIniciales){
        this.nombre=nombre;
        this.numBacteriasIniciales=numBacteriasIniciales;
    }

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

    public void crearDosis() throws ExceptionCantidad{
        Salida salida= new Salida(); 
        salida.opcionesDosis();
    }

    public void modificarDosis(Dosis dosis) throws ExceptionCantidad{
        Salida salida= new Salida();
        salida.DatosModificarDosis(dosis);
    }

    public void visualizarDosis(Dosis d){
        System.out.println(d.toString());
    }
    
}