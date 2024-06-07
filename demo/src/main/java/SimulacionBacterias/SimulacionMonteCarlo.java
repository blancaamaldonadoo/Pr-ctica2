package SimulacionBacterias;

import java.util.Random;

import ClasesLab.*;

/**
 * Clase que modela la simulación de Monte Carlo.
 * La simulación de Monte Carlo tiene una población de bacterias y un número de días.
 * @param poblacionBacterias Población de bacterias.
 * @param dias Número de días de la simulación.
 * @param celdas Número de celdas del cultivo.
 * @param simulacionesDia Número de simulaciones por día.
 * @param random Número aleatorio.
 * @param cultivo Cultivo de bacterias.
 * @param comida Comida de bacterias.
 */

public class SimulacionMonteCarlo{

    private static final int celdas=20;
    private static final int simulacionesDia=10;
    private static final Random random= new Random();
    private Poblacion poblacionBacterias;
    private int dias;
    private int[][][] cultivo;
    private int[][][] comida;

    /**
     * Constructor de la clase Simulación de Monte Carlo.
     * @param poblacionBacterias
     * @param dias
     */

    public SimulacionMonteCarlo(Poblacion poblacionBacterias, int dias){
        this.poblacionBacterias=poblacionBacterias;
        this.dias=dias;
        this.cultivo= new int[dias][celdas][celdas];
        this.comida= new int[dias][celdas][celdas];
        inicializarCultivo();
    }

    /**
     * Método que inicializa el cultivo de bacterias.
     * Se inicializa el cultivo con una cantidad de bacterias iniciales en el centro del cultivo.
     * Se inicializa la comida en todas las celdas del cultivo.
     */
    
    private void inicializarCultivo(){
        int contadorBacterias= (int) poblacionBacterias.getNumBacteriasIniciales();
        for(int i= 8; i<12; i++){
            for(int j=8; j<12; j++){
                cultivo[0][i][j]=contadorBacterias/16;
            }
        }
        int comida0=(int) poblacionBacterias.getDosis().getCantidadInicial();
        for(int i=0; i<celdas; i++){
            for(int j=0; j<celdas; j++){
                comida[0][i][j]=comida0;
            }
        }
    }

    /**
     * Método que simula la distribución de comida en el cultivo.
     * Se distribuye la comida en todas las celdas del cultivo.
     * @param dia
     */

    public void run(){
        for(int i=1; i<dias; i++){
        distribuirComida(i);
        simularDia(i);
        }
    }

    /**
     * Método que distribuye la comida en el cultivo.
     * @param dia
     */

    private void distribuirComida(int dia){
        float cantidadComida=calcularComidaDiaria(dia);
        for(int i=0; i<celdas; i++){
            for(int j=0; j<celdas; j++){
                comida[dia][i][j]= comida[dia-1][i][j]+(int) (cantidadComida/(celdas*celdas));
            }
        }
    }

    /**
     * Método que calcula la cantidad de comida diaria.
     * @param dia
     * @return
     */

    private float calcularComidaDiaria(int dia){
        float comida0= poblacionBacterias.getDosis().getCantidadInicial();
        float comidaMax= poblacionBacterias.getDosis().getDosisMax();
        float comidaFinal= poblacionBacterias.getDosis().getDosisDiaFinal();

        if(dia<= comidaMax){
            return comida0 + ((comidaMax-comida0)*dia/comidaMax);
        }
        else{
            return comidaMax + ((comidaFinal-comidaMax)*(dia-comidaMax)/(dias-comidaMax));
        }
    }

    /**
     * Método que simula un día en el cultivo.
     * @param dia
     */

    private void simularDia(int dia){

        for (int i=0; i<celdas; i++){
            for(int j=0; j<celdas; j++){
                int contador= cultivo[dia-1][i][j];
                int comida= cultivo[dia][i][j];
                for(int k=0; k<contador; k++){
                    simularBacterias(dia, i, j, comida);
                }
            }
        }

    }

    /**
     * Método que simula la evolución de las bacterias en una celda del cultivo.
     * @param dia
     * @param i
     * @param j
     * @param comida
     */

    private void simularBacterias(int dia, int i, int j, int comida){
        for (int c=0; c< simulacionesDia; c++){
            if(comida>=100){
                comida-=20;
                int numRandom=random.nextInt(100);
                if(numRandom<3){
                    cultivo[dia][i][j]--; //la bacteria muere
                }
                else if(numRandom>=60){
                    moverBacteria(dia, i, j, numRandom);
                }
            }else if(comida>9){
                comida-=10;
                int numRandom=random.nextInt(100);
                if(numRandom<6){
                    cultivo[dia][i][j]--; //la bacteria muere
                }else if(numRandom>=20){
                    moverBacteria(dia, i, j, numRandom);
                }
            }else{
                int numRandom=random.nextInt(100);
                if(numRandom<20){
                    cultivo[dia][i][j]--; //la bacteria muere
                }else if(numRandom>=60){
                    moverBacteria(dia, i, j, numRandom);
                }
            }
        }
    }

    /**
     * Método que mueve una bacteria a una celda adyacente.
     * @param dia
     * @param x
     * @param y
     * @param numRandom
     */


    private void moverBacteria(int dia, int x, int y, int numRandom){
        int i=x;
        int j=y;
        if(numRandom>=60&&numRandom<65) i= x-1;
        else if (numRandom>=65&&numRandom<70) j= x+1;
        else if (numRandom>=70&&numRandom<75) j= y-1;
        else if (numRandom>=75&&numRandom<80) j= y+1;
        else if (numRandom>=80&&numRandom<85){
            i=x-1;
            j=y-1;
        }
        else if (numRandom>=85&&numRandom<90){
            i=x-1;
            j=y+1;
        }
        else if (numRandom>=90&&numRandom<95){
            i=x+1;
            j=y-1;
        }
        else if (numRandom>=95&&numRandom<100){
            i=x+1;
            j=y+1;
        }

        if(i>=0 && i<celdas && j >=0 && j<celdas){
            cultivo[dia][i][j]++;
            cultivo[dia][x][y]--;
        }
    }

    /*public void imprimirSimulacion(){
        for(int i=0; i<dias; i++){
            System.out.println("Día "+i);
            for(int j=0; j<celdas; j++){
                for(int k=0; k<celdas; k++){
                    System.out.print(cultivo[i][j][k]+" ");
                }
                System.out.println();
            }
        }
    }*/
    
/**
     * Getters y setters de la clase SimulacionMonteCarlo.
     * @return
     */


    public int [][][] getCultivo(){
        return cultivo;
    }

    public int[][][] getComida(){
        return comida;
    }

}