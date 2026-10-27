package dam2.accesodatos;

import java.util.List;
import dao.localDAO;
import model.Productos;


public class ejercicio {
    public static void main(String[] args) {
        localDAO ld = new localDAO("json\\src\\main\\java\\dam2\\accesodatos\\data\\list.json");
        boolean b = true;
       
        List<Productos> a = ld.listarTodos();
        while (b == true) {
            System.out.println("--------------");
            System.out.println(" 1. Leer      ");
            System.out.println(" 2. Guardar   ");
            System.out.println("--------------");

            String op = IO.readln("Elige una opción");

            switch (op) {
                case "1":
                    for(Productos pro : a){
                        System.out.println("ID: "+pro.getId()+" - "+"Nombre: "+pro.getNombre()+" - "+"Precio: "+pro.getPrecio());
                    }
                    break;
                case "2":
                    ld.guardarTodos(a);
                    break;
                default:
                    b = false;
                    break;
            }

        }

    }

}
