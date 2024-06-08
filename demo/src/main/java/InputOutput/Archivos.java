package InputOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ClasesLab.Dosis;
import ClasesLab.Experimento;
import ClasesLab.Poblacion;
import Controlador.Laboratorio;
import Excepciones.ExceptionCantidad;

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
                    String line = String.format("%s,%s\n",
                        experimento.getNombre(),
                        poblacion.toString());
                    writer.append(line);
                }
            }
        } else {
            guardarComo(experimento);
        }
    }

    /**
     * Método que guarda un experimento en un archivo.
     * @param e
     * @param newFile
     * @throws IOException 
     */

    public void guardarComo(Experimento e) throws IOException{
        File file;
        String nombre;
        nombre = Comprobaciones.leerString("Introduce el nombre del archivo: ");
        file = new File(nombre + ".csv");
        try(FileWriter writer = new FileWriter(file)){
            writer.append("Experimento, Poblaciones\n");
            for(Poblacion poblacion: e.getPoblaciones()){
                String line = String.format("%s,%s\n",
                    e.getNombre(),
                    poblacion.toString());
                writer.append(line);
            }
        writer.flush();
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
     * @throws ExceptionCantidad 
     */

    public static Experimento abrirArchivo() throws IOException, ExceptionCantidad{
        String nombre = Comprobaciones.leerString("Introduce el nombre del archivo del experimento: ");
        File file = new File(nombre + ".csv");
            if (!file.exists()) {
                System.out.println("El archivo no existe.");
                return null;
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine(); 
                if(line==null){
                    System.out.println("El archivo está vacío.");
                    return null;
                }
                String nombreExperimento = null;
                ArrayList<Poblacion> poblaciones = new ArrayList<>();

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if(parts.length != 3){
                        System.out.println("El archivo no tiene el formato correcto.");
                        return null;
                    }
                    nombreExperimento = parts[0];
                    Poblacion poblacion = Poblacion.fromString(parts[1]);
                    poblaciones.add(poblacion);
                }

                Experimento experimento = new Experimento(nombreExperimento, poblaciones);
                System.out.println("El experimento ha sido cargado exitosamente.");
                return experimento;
            } catch (IOException ex) {
                System.out.println("Error al abrir el experimento.");
                ex.printStackTrace();
                return null;
            }
            }
}