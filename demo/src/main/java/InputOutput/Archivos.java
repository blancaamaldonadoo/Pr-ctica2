package InputOutput;

import java.io.*;
import java.util.*;
import ClasesLab.Experimento;
import ClasesLab.Poblacion;
import Controlador.Laboratorio;

public class Archivos extends Laboratorio{
    private String nombre;
    private File archivo;
    private Experimento experimento;

    public Archivos(String nombre, File archivo, Experimento experimento) {
        this.nombre=nombre;
        this.archivo=archivo;
        this.experimento = experimento;
    }

    public Archivos(File archivo, Experimento experimento){
        this.archivo=archivo;
        this.experimento=experimento;
    }

    public Archivos(File archivo){
        this.archivo=archivo;
    }

    public File getArchivo(){
        return archivo;
    }

    public Experimento getExperimento(){
        return experimento;
    }

    public void setExperimento(Experimento experimento){
        this.experimento=experimento;
    }

    public void setArchivo(File archivo){
        this.archivo=archivo;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void guardarComo(Experimento e){
        String nombre= e.getNombre();
        String ruta= nombre+".txt";
        File archivo = new File(ruta, nombre);
        while(archivo.exists()){
           System.out.println("El archivo ya ha sido previamente guardado, por favor, seleccione la opción de guardar. ");
        }
        if(!archivo.exists()){
            try{
                archivo.createNewFile();
                FileWriter writer= new FileWriter(archivo);
                BufferedWriter bw= new BufferedWriter(writer);
                bw.write(e.toString());
                bw.close();
            }catch(IOException ex){
                System.out.println("Error al guardar el archivo");
                ex.printStackTrace();
            }
            System.out.println("El archivo se ha guardado con éxito");
        }
        
        Archivos Arch= new Archivos(archivo, experimento);
        addArchivo(Arch);

    }

    public File getFileOfExperiment(Experimento e){
        File f = null;
        for(Archivos a: getArchivos()){
            if(a.getExperimento().equals(e)) f = a.getarch();
        }
        return f;
    }

    public void guardar(Experimento e){
        File archivo= getFileOfExperiment(e);
        if(!archivo.exists()) 
            guardarComo(e);
        else{
            try(FileWriter writer= new FileWriter(archivo);
            BufferedWriter bw= new BufferedWriter(writer)){
                bw.write(e.toString());
                bw.close();
            }catch(IOException ex){
                System.out.println("Error al guardar el archivo");
                ex.printStackTrace();
            }
        }
    }

    public Experimento abrirArchivo(File f){
        FileInputStream fileInputStream=null;
        InputStreamReader inputStreamReader=null;
        BufferedReader bufferedReader=null;
        try{
            fileInputStream= new FileInputStream(f);
            inputStreamReader= new InputStreamReader(fileInputStream);
            bufferedReader= new BufferedReader(inputStreamReader);
        }catch(FileNotFoundException e){
            System.out.println("Error al abrir el archivo");
            e.printStackTrace();
        }

        String linea;
        String nombre="";
        ArrayList<Poblacion> poblaciones= new ArrayList<Poblacion>();
        try{
            while((linea=bufferedReader.readLine())!=null){
                if(linea.contains("Nombre:")){
                    nombre=linea.substring(8);
                }
                else if(linea.contains("Número de bacterias iniciales:")){
                    String[] datos= linea.split(",");
                    String nombreP= datos[0].substring(11);
                    int cantidad= Integer.parseInt(datos[1].substring(10));
                    Poblacion p= new Poblacion(nombreP, cantidad);
                    poblaciones.add(p);
                }
            }
        }catch(IOException e){
            System.out.println("Error al leer el archivo");
            e.printStackTrace();
        }

        Experimento experimento= new Experimento(nombre, poblaciones);
        return experimento;
    }
}