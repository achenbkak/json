package dao;

import java.util.List;

public interface ProductoDAO<E> {
    void guardarTodos(List<E> productos);
    List<E> listarTodos();
    
} 
