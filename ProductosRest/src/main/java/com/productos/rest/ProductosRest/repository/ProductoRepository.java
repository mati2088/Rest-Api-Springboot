package com.productos.rest.ProductosRest.repository;

import com.productos.rest.ProductosRest.productos.modelo.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository  extends JpaRepository<Productos, Integer> {

}
