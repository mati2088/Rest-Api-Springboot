package com.productos.rest.ProductosRest.controllers;


import com.productos.rest.ProductosRest.productos.modelo.Productos;
import com.productos.rest.ProductosRest.service.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Productos> listarProductos(){
        return productoServicio.listarProductos();
    }
    @GetMapping("/productos/{id}")
    public ResponseEntity<Productos> obtenerProducto(@PathVariable Integer id){
        try {
            Productos productos = productoServicio.obtenerProductoPorId(id);
            return new ResponseEntity<Productos>(productos,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/productos")
    public void guardarProductos(@RequestBody Productos productos){
        productoServicio.guardarProducto(productos);
    }
    @PutMapping("/productos/{id}")
    public ResponseEntity<?> actualizarProductos(@RequestBody Productos productos ,@PathVariable Integer id){
        try {
        Productos productosActual= productoServicio.obtenerProductoPorId(id);
        productosActual.setNombre(productos.getNombre());
        productosActual.setPrecio(productos.getPrecio());


        productoServicio.guardarProducto(productosActual);
            return new ResponseEntity<Productos>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        productoServicio.eliminarProducto(id);
    }
}
