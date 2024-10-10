package com.sena.inventario.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "cliente")

public class Cliente implements Serializable {

    @Id
    @Column(name = "id_cliente")
    private String id_cliente;
    @Column(name = "nombre_cliente")
    private String nombre_cliente;
    @Column(name = "clave_cliente")
    private String clave_cliente;

    public Cliente() {
    }

    public Cliente(String id_cliente, String nombre_cliente, String clave_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.clave_cliente = clave_cliente;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getClave_cliente() {
        return clave_cliente;
    }

    public void setClave_cliente(String clave_cliente) {
        this.clave_cliente = clave_cliente;
    }

}
