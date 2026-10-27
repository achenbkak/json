package dam2.accesodatos;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.persona;

public class Main {
    public static void main(String[] args) {
        persona p = new persona("Chrí","Barber",32);
        File f = new File("json\\src\\main\\java\\dam2\\accesodatos\\data\\personas.json");
        File f1 = new File("json\\src\\main\\java\\dam2\\accesodatos\\data\\personas1.json");
        ObjectMapper mapeador = new ObjectMapper();

        try {
            mapeador.writerWithDefaultPrettyPrinter().writeValue(f, p);
            mapeador.writeValue(f1, p);
            String s = mapeador.writeValueAsString(p);
            System.out.println(s);
        } catch (StreamWriteException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) { 
            e.printStackTrace();
        }
        
    }
}