package Modelo;

import Excepciones.ExcepcionDiaDosis;
import Excepciones.ExceptionCantidad;

public class Dosis{

    private int duracionDias;
    private long cantidadInicial;
    private int diaStopIncremento;
    private long dosisDiaStopIncremento;
    private long dosisDiaFinal;
    
    private long cantidadConstante=0;

    public Dosis( int duracionDias, long cantidadInicial, int diaStopIncremento, long dosisDiaStopIncremento, long dosisDiaFinal) throws ExceptionCantidad{
        this.duracionDias = duracionDias;
        if(cantidadInicial>300000||dosisDiaFinal>300000){
            throw new ExceptionCantidad("Las dosis no pueden ser mayores a 300000 miligramos");
        }
        this.cantidadInicial = cantidadInicial;
        this.diaStopIncremento = diaStopIncremento;
        this.dosisDiaStopIncremento = dosisDiaStopIncremento;
       
        this.dosisDiaFinal = dosisDiaFinal;
    }

    public Dosis(long cantidadConstante, int duracionDias){
        this.cantidadConstante=cantidadConstante;
        this.duracionDias=duracionDias;
    }

    public int getDuracionDias(){
        return duracionDias;
    }
    public void setDuracionDias(int duracionDias){
        this.duracionDias = duracionDias;
    }
    public long getCantidadInicial(){
        return cantidadInicial;
    }
    public void setCantidadInicial(long cantidadInicial){
        this.cantidadInicial = cantidadInicial;
    }
    public int getDiaStopIncremento(){
        return diaStopIncremento;
    }
    public void setDiaStopIncremento(int diaStopIncremento){
        this.diaStopIncremento = diaStopIncremento;
    }
    public long getDosisDiaStopIncremento(){
        return dosisDiaStopIncremento;
    }
    public void setDosisDiaStopIncremento(long dosisDiaStopIncremento){
        this.dosisDiaStopIncremento = dosisDiaStopIncremento;
    }
    public long getDosisDiaFinal(){
        return dosisDiaFinal;
    }
    public void setDosisDia30(long dosisDiaFinal){
        this.dosisDiaFinal = dosisDiaFinal;
    }

    public String toString(){
        String texto="";
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

    public long calcularDosis(int dia) throws ExcepcionDiaDosis, IllegalArgumentException{
        long dosis=0;
        if (dia>duracionDias){
            throw new ExcepcionDiaDosis("El día no puede ser mayor a la duración del experimento.");
        }
        if(dia<0){
            throw new IllegalArgumentException("El día no puede ser negativo.");
        }
        if(dia<diaStopIncremento){
            double incremento= (dosisDiaStopIncremento-cantidadInicial)/(double)diaStopIncremento;
            dosis= ((long)incremento* dia) + cantidadInicial;
        }else if(dia==diaStopIncremento){
            dosis=dosisDiaStopIncremento;
        }
        else {
            double decremento= (dosisDiaStopIncremento-dosisDiaFinal)/(double)(duracionDias-diaStopIncremento);
            dosis= dosisDiaStopIncremento- ((long)decremento*(dia-diaStopIncremento));
        }
        return dosis;
    }

    

}