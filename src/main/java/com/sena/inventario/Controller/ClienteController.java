package com.sena.inventario.Controller;

import com.sena.inventario.Model.Cliente;
import com.sena.inventario.service.ClienteService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/Cliente")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/")
    public ResponseEntity<Cliente> agregar(@RequestBody Cliente cliente) {
        Cliente obj = clienteService.save(cliente);
        return new ResponseEntity<>(obj, HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Cliente> eliminar(@PathVariable String id) {
        Cliente obj = clienteService.findBYId(id);
        if (obj != null) {
            clienteService.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Cliente> editar(@RequestBody Cliente cliente) {
        Cliente obj = clienteService.findBYId(cliente.getId_cliente());
        if (obj != null) {
            obj.setNombre_cliente(cliente.getNombre_cliente());
            obj.setClave_cliente(cliente.getClave_cliente());
            clienteService.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Cliente> consultarTodo() {
        return clienteService.findByAll();
    }

    @GetMapping("/list/{id}")
    public Cliente consultaPorId(@PathVariable String id) {
        return clienteService.findBYId(id);
    }

    @GetMapping("/login")
    public Cliente login(@RequestParam("usuario") String usuario, @RequestParam("clave") String clave) {
        return clienteService.login(usuario, clave);

    }

}
