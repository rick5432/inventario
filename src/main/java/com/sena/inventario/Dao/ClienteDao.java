package com.sena.inventario.Dao;

import com.sena.inventario.Model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ClienteDao extends CrudRepository<Cliente, String> {

    @Transactional(readOnly = true)
    @Query(value = "select * from cliente where id_cliente=:usuario and clave_cliente=:clave", nativeQuery = true)
    public Cliente login(@Param("ususario") String usuario, @Param("clave") String clave);

}
