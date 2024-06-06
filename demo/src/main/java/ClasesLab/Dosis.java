package ClasesLab;

import Excepciones.ExcepcionDiaDosis;
import Excepciones.ExceptionCantidad;

public class Dosis{

    private int duracionDias=0;
    private float cantidadInicial=0;
    private int diaStopIncremento=0;
    private float dosisDiaStopIncremento;
    private float dosisDiaFinal=0;    
    private float cantidadConstante=0;

    public Dosis( int duracionDias, float cantidadInicial, int diaStopIncremento, float dosisDiaStopIncremento, float dosisDiaFinal) throws ExceptionCantidad{
        this.duracionDias = duracionDias;
        if(cantidadInicial>300000||dosisDiaFinal>300000){
            throw new ExceptionCantidad("Las dosis no pueden ser mayores a 300000 miligramos");
        }
        this.cantidadInicial = cantidadInicial;
        this.diaStopIncremento = diaStopIncremento;
        this.dosisDiaStopIncremento = dosisDiaStopIncremento;
       
        this.dosisDiaFinal = dosisDiaFinal;
    }

    public Dosis(int duracionDias, float cantidadConstante){
        this.duracionDias=duracionDias;
        this.cantidadConstante=cantidadConstante;
    }

    public Dosis(int duracionDias, float cantidadInicial, float dosisDiaFinal){
        this.duracionDias=duracionDias;
        this.cantidadInicial=cantidadInicial;
        this.dosisDiaFinal=dosisDiaFinal;
    }

    public int getDuracionDias(){
        return duracionDias;
    }
    public void setDuracionDias(int duracionDias){
        this.duracionDias = duracionDias;
    }
    public float getCantidadInicial(){
        return cantidadInicial;
    }
    public void setCantidadInicial(float cantidadInicial){
        this.cantidadInicial = cantidadInicial;
    }
    public int getDiaStopIncremento(){
        return diaStopIncremento;
    }
    public void setDiaStopIncremento(int diaStopIncremento){
        this.diaStopIncremento = diaStopIncremento;
    }
    public float getDosisDiaStopIncremento(){
        return dosisDiaStopIncremento;
    }
    public void setDosisDiaStopIncremento(float dosisDiaStopIncremento){
        this.dosisDiaStopIncremento = dosisDiaStopIncremento;
    }
    public float getDosisDiaFinal(){
        return dosisDiaFinal;
    }
    public void setDosisDia30(float dosisDiaFinal){
        this.dosisDiaFinal = dosisDiaFinal;
    }
    public float getCantidadConstante(){
        return cantidadConstante;
    }
    public void setCantidadConstante(float cantidadConstante){
        this.cantidadConstante=cantidadConstante;
    }

    public String toString(){
        String texto="\n";
        texto+="La dosis dura: "+duracionDias+" días\n";
        if(cantidadConstante==0){
        texto+="Cantidad inicial: "+cantidadInicial+"\n";
        texto+="Dia de fin de incremento: "+diaStopIncremento+"\n";
        texto+="Dosis de fin de incremento: "+dosisDiaStopIncremento+"\n";
        texto+="Dosis del dia 30: "+dosisDiaFinal+"\n";
        }
        else texto+= "Cantidad de comida constante: " + cantidadConstante;
        return texto;
    }

    public float calcularDosisConstante(int dia) throws ExcepcionDiaDosis, IllegalArgumentException{
        float dosis=0;
        if (dia>duracionDias){
            throw new ExcepcionDiaDosis("El día no puede ser mayor a la duración del experimento.");
        }
        if(dia<0){
            throw new IllegalArgumentException("El día no puede ser negativo.");
        }
        if(dia<diaStopIncremento){
            double incremento= (dosisDiaStopIncremento-cantidadInicial)/(double)diaStopIncremento;
            dosis= ((float)incremento* dia) + cantidadInicial;
        }else if(dia==diaStopIncremento){
            dosis=dosisDiaStopIncremento;
        }
        else {
            double decremento= (dosisDiaStopIncremento-dosisDiaFinal)/(double)(duracionDias-diaStopIncremento);
            dosis= dosisDiaStopIncremento- ((float)decremento*(dia-diaStopIncremento));
        }
        return dosis;
    }

    public float calcularDosisInicioFin(int dia) throws ExceptionCantidad {
        float dosis=0;
        if(dosisDiaFinal<cantidadInicial) throw new ExceptionCantidad("La cantidad final tiene que ser mayor que la inicial");
        else{
            double incremento= (dosisDiaFinal-cantidadInicial)/(double)duracionDias;
            dosis= ((float)incremento* dia) + cantidadInicial;
        }
        return dosis;
    }

    public float calcularDosisIntermitente(int dia) throws ExcepcionDiaDosis{
        float dosis=0;
        if(dia>duracionDias) throw new ExcepcionDiaDosis("El día no entra dentro del rango establecido");
        if(dia<0) throw new IllegalArgumentException("El día no puede ser negativo.");
        if(dia%2==0){
            dosis= cantidadConstante;
        }
        return dosis;
    }

    public float getDosisMax(){
        float dosisMax=0;
        if(diaStopIncremento>0){
            double incremento= (dosisDiaStopIncremento-cantidadInicial)/(double)diaStopIncremento;
            dosisMax= ((float)incremento* diaStopIncremento) + cantidadInicial;
        }else{
            dosisMax=dosisDiaStopIncremento;
        }
        return dosisMax;
    }
}