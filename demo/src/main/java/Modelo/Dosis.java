package Modelo;

public class Dosis{

    private int cantidadInicial;
    private int diaStopIncremento;
    private int dosisDiaStopIncremento;
    private int dosisDia30;


    public Dosis(int cantidadInicial, int diaStopIncremento, int dosisDiaStopIncremento, int dosisDia30) {
        this.cantidadInicial = cantidadInicial;
        this.diaStopIncremento = diaStopIncremento;
        this.dosisDiaStopIncremento = dosisDiaStopIncremento;
        this.dosisDia30 = dosisDia30;
    }

    public int getCantidadInicial(){
        return cantidadInicial;
    }
    public void setCantidadInicial(int cantidadInicial){
        this.cantidadInicial = cantidadInicial;
    }
    public int getDiaStopIncremento(){
        return diaStopIncremento;
    }
    public void setDiaStopIncremento(int diaStopIncremento){
        this.diaStopIncremento = diaStopIncremento;
    }
    public int getDosisDiaStopIncremento(){
        return dosisDiaStopIncremento;
    }
    public void setDosisDiaStopIncremento(int dosisDiaStopIncremento){
        this.dosisDiaStopIncremento = dosisDiaStopIncremento;
    }
    public int getDosisDia30(){
        return dosisDia30;
    }
    public void setDosisDia30(int dosisDia30){
        this.dosisDia30 = dosisDia30;
    }

    public String toString(){
        String texto="";
        texto+="Cantidad inicial: "+cantidadInicial+"\n";
        texto+="Dia de fin de incremento: "+diaStopIncremento+"\n";
        texto+="Dosis de fin de incremento: "+dosisDiaStopIncremento+"\n";
        texto+="Dosis del dia 30: "+dosisDia30+"\n";
        return texto;

    }

}