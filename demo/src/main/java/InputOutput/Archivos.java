package InputOutput;

import java.io.*;

import Interfaces.ManejadorArchivos;
import Modelo.Experimento;

public class Archivos implements ManejadorArchivos{
    private File archivo;
    private Experimento experimento;
    private ArrayList<Archivos> listaArchivos = new ArrayList<Archivos>();
    public Archivos(File archivo, Experimento experimento) {
        this.archivo=archivo;
        this.experimento = experimento;
    }

    public Archivos(File archivo){
        this.archivo=file;
    }

    public File getarch(){
        return archivo;
    }

    public Experimento getExperimento(){
        return experimento;
    }

    public void guardarComo(Experimento e){
        String nombre= e.getNombre();
        String ruta= nombre+".txt";
        File archivo = new File(ruta.getAbsolutePath(), nombre);
        //comprobar que no se haya guardado ya antes:
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
        listaArchivos.add(Arch);

    }

    public Archivo getFileOfExperiment(Experimento e){
        File f = null;
        for(Archivos a: listaArchivos){
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
            }
        }

    }

    public Experimento abrirArchivo(){


    }


}
