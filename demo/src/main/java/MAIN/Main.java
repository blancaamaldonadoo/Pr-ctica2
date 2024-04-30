package MAIN;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import Controlador.Laboratorio;
import Excepciones.ExceptionCantidad;
import Modelo.Experimento;
import Modelo.Poblacion;


public class Main{
    public static void main(String[] args) {
       
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        Laboratorio Laboratorio = new Laboratorio();
        System.out.println("Elige una opción: ");
        System.out.println("1. Abrir un archivo ");
        System.out.println("2. Crear un nuevo experimento ");
        System.out.println("3. Crear una población de bacterias y añadirla al experimento actual");
        System.out.println("4. Visualizar los nombres de todas las poblaciones de bacterias del experimento ");
        System.out.println("5. Borrar una población de bacterias del experimento actual");
        System.out.println("6. Ver información detallada de una población de bacterias del experimento actual ");
        System.out.println("7. Guardar  ");
        System.out.println("8. Guardar como ");
    
        int opcion=0;

        try {
            opcion = Integer.parseInt(teclado.readLine());
        } catch (Exception e) {
            System.out.println("Error al leer la opción");
            e.printStackTrace();
        }

        switch(opcion){

            case 1:{
                break;
            }

            case 2:{
                try {
                    Laboratorio.crearExperimento();
                } catch (ExceptionCantidad e) {
                    System.out.println("Error al crear el experimento");
                    e.printStackTrace();
                }
                break;
            }

            case 3:{
                try {
                    Experimento experimento= Laboratorio.accederExperimentoActual();
                    experimento.addPoblacion(experimento.crearPoblacion());
                } catch (ExceptionCantidad e) {
                    System.out.println("Error al crear la población");
                    e.printStackTrace();
                }
                break;
            }

            case 4:{
                Experimento experimento= Laboratorio.accederExperimentoActual();
                experimento.visualizarNombresPoblaciones();
                break;
            }

            case 5:{
                Experimento experimento= Laboratorio.accederExperimentoActual();
                System.out.println("Introduce el nombre de la población que quieres borrar: ");
                String nombre="";
                try {
                    nombre = teclado.readLine();
                } catch (Exception e) {
                    System.out.println("Error al leer el nombre");
                    e.printStackTrace();
                }
                for(Poblacion pob: experimento.getPoblaciones()){
                    if(pob.getNombre().equals(nombre)){
                    experimento.eliminarPoblacion(pob);
                    }
                break;
                }
            }   

            case 6:{
                Experimento experimento= Laboratorio.accederExperimentoActual();
                System.out.println("Introduce el nombre de la población de la que quieres ver los detalles: ");
                String nombre="";
                try {
                    nombre = teclado.readLine();
                } catch (Exception e) {
                    System.out.println("Error al leer el nombre");
                    e.printStackTrace();
                }
                for(Poblacion pob: experimento.getPoblaciones()){
                    if(pob.getNombre().equals(nombre)){
                    experimento.verDetallesPoblacion(pob);
                    }
                break;
                }
            }

            case 7:{
                break;
            }

            case 8:{
                break;
            }

        }

    }

}
