package InputOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import ClasesLab.Dosis;
import ClasesLab.Experimento;
import ClasesLab.Poblacion;
import Controlador.Laboratorio;

/**
 * Clase que modela un archivo en el laboratorio.
 * Un archivo tiene un nombre, un archivo y un experimento.
 * @param nombre Nombre del archivo.
 * @param file Archivo.
 * @param experimento Experimento.
 * @param laboratorio Laboratorio.
 */

public class Archivos extends Laboratorio{
    private String nombre;
    private File file;
    private Experimento experimento;

    /**
     * Constructor de la clase Archivos.
     * @param nombre
     * @param file
     * @param experimento
     */

    public Archivos(String nombre, File file, Experimento experimento) {
        this.nombre=nombre;
        this.file=file;
        this.experimento = experimento;
    }

    /**
     * Constructor de la clase Archivos.
     * @param file
     * @param experimento
     */

    public Archivos(File file, Experimento experimento){
        this.file=file;
        this.experimento=experimento;
    }

    /**
     * Constructor de la clase Archivos.
     * @param file
     */

    public Archivos(File file){
        this.file=file;
    }

    /**
     * Constructor de la clase Archivos.
     * @param nombre
     */

    public Archivos(String nombre){
    this.nombre=nombre;
    }

    /**
     * Getters y setters de la clase Archivos.
     * @return
     */

    public File getFile(){
        return file;
    }

    public void setFile(File file){
        this.file=file;
    }

    public Experimento getExperimento(){
        return experimento;
    }

    public void setExperimento(Experimento experimento){
        this.experimento=experimento;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    /**
     * Método que guarda un experimento en un archivo.
     * @param experimento
     * @throws IOException 
     */

    public void guardar(Experimento experimento) throws IOException{
        String csvFile = nombre + ".csv";
        File archivo = new File(csvFile);

        if (archivo.exists()) {
            try (FileWriter writer = new FileWriter(csvFile, true)) {
                for (Poblacion poblacion : experimento.getPoblaciones()) {
                    String line = String.format("%s,%s,%d\n",
                        experimento.getNombre(),
                        poblacion.getNombre(),
                        poblacion.getDosis());
                    writer.append(line);
                }
            }
        } else {
            guardarComo(experimento, archivo);
        }
    }

    /**
     * Método que guarda un experimento en un archivo.
     * @param e
     * @param newFile
     */

    public void guardarComo(Experimento e,File newFile){
        File file;
        String nombre;
        do {
            nombre = Comprobaciones.leerString("Introduce el nombre del archivo: ");
            file = new File(nombre + ".csv");
            if (file.exists()) {
                System.out.println("El archivo ya existe");
            }
        } while (file.exists());
    
        try (FileWriter writer = new FileWriter(file)) {
            writer.append("Nombre del Experimento,Nombre de la Poblacion,Dosis de Comida\n");
            for (Poblacion poblacion : e.getPoblaciones()) {
                String line = String.format("%s,%s,%d\n",
                    e.getNombre(),
                    poblacion.getNombre(),
                    poblacion.getDosis());
                writer.append(line);
            }
            System.out.println("El experimento ha sido guardado exitosamente.");
        } catch (IOException ex) {
            System.out.println("Error al guardar el experimento.");
            ex.printStackTrace();
        }
 }

    

    /**
     * Método que abre un archivo.
     * @return
     * @throws IOException 
     */

    public Experimento abrirArchivo(File archivo) throws IOException{
        Experimento experimento = null;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            ArrayList<Poblacion> poblaciones = new ArrayList<>();

            while((linea= br.readLine()) != null){
                String [] campos = linea.split(",");
                if(campos.length >= 3){
                    String nombreExperimento = campos[0];
                    String nombrePoblacion = campos[1];
                    int cantidadInicial = Integer.parseInt(campos[2]);

                    if(experimento == null){
                        experimento = new Experimento(nombreExperimento, poblaciones);
                    }

                    Poblacion poblacion = new Poblacion(nombrePoblacion, cantidadInicial);
                    poblaciones.add(poblacion);
                }
            }
            if (experimento!= null) {
                experimento.setPoblaciones(poblaciones);
            }


        } catch (IOException e) {
            System.err.println("Error al abrir el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error en el formato de los datos: " + e.getMessage());
        }

        try(PrintWriter pw= new PrintWriter(new FileWriter(archivo, true))){
            if(experimento!=null){
                for(Poblacion poblacion: experimento.getPoblaciones()){
                    pw.println(poblacion.getNombre()+","+poblacion.getDosis());
                }
            }
        }catch(IOException e){
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        return experimento;
    }
}