package dao;


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Productos;

public class ProductoBinario implements ProductoDAO<Productos>{

    String ruta;
   
    public ProductoBinario (String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void guardarTodos(List<Productos> productos) {
       
        try(
            FileOutputStream fos = new FileOutputStream(new File(this.ruta));
            ObjectOutputStream oos = new ObjectOutputStream(fos)
        ){
            for (Productos p : productos){
                oos.writeObject(p); 
            }
        } catch (IOException e){
            System.err.println(e);
        }
    }

    @Override
    public List<Productos> listarTodos() {
        List<Productos> p = new ArrayList<>();
        try{
            File f = new File(this.ruta);
            try(
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis)
            ){
                while(true){
                    Productos ps = (Productos)ois.readObject();
                    p.add(ps);
                }
            }
        }catch(EOFException e){
            System.out.println("Fin del archivo");
        }catch(Exception e){
            System.err.println(e);
        }
        return p;
    
    }

}
