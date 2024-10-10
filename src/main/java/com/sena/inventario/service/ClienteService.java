package com.sena.inventario.service;

import com.sena.inventario.Model.Cliente;
import java.util.List;

public interface ClienteService {

    public Cliente save(Cliente cliente);

    public void delete(String id);

    public Cliente findBYId(String id);

    public List<Cliente> findByAll();

    public Cliente login(String usuario, String clave);
}
