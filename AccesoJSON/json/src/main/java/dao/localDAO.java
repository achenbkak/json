package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Productos;

public class localDAO implements ProductoDAO<Productos>{

    String ruta;
    List<Productos> p;
    ObjectMapper om = new ObjectMapper();

    public localDAO (String ruta) {
        this.ruta = ruta;
        this.p = listarTodos();
    }

    @Override
    public void guardarTodos(List<Productos> productos) {
        try{
            om.writeValue(new File(this.ruta), productos);
        } catch (Exception e){
            System.err.println(e);
        }
    }

    @Override 
    public List<Productos> listarTodos() {
        List<Productos> aux = new ArrayList<>();
        try{
            aux = om.readValue(new File(this.ruta), new TypeReference<List<Productos>>() {});
        }catch(Exception e){
            System.err.println(e);
        }
        return aux;
    }

   

}
