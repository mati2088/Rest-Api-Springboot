package com.productos.rest.ProductosRest.productos.modelo;


import javax.persistence.*;

@Entity @Table(name = "productos")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private float precio;
    //Genero constructor


    public Productos(Integer id, String nombre, float precio) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
    public Productos( String nombre, float precio) {
        super();
        this.nombre = nombre;
        this.precio = precio;
    }
    public Productos() {
        super();
    }


    //Genero setters and getters

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
