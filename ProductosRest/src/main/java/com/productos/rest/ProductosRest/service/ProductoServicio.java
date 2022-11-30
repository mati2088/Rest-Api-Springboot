package com.productos.rest.ProductosRest.service;

import com.productos.rest.ProductosRest.productos.modelo.Productos;
import com.productos.rest.ProductosRest.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepository productoRepository;
    public List<Productos> listarProductos(){
        return productoRepository.findAll();
    }
    public void guardarProducto(Productos productos){
        productoRepository.save(productos);
    }
    public Productos obtenerProductoPorId(Integer id){
        return productoRepository.findById(id).get();
    }
    public void eliminarProducto(Integer id){
        productoRepository.deleteById(id);
    }
}
