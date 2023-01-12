/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.practica.Facturacion.controller;

import ista.edu.practica.Facturacion.model.Factura;
import ista.edu.practica.Facturacion.service.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ferna
 */

@RestController
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    FacturaService facturaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Factura>> obtenerLista() {
        return new ResponseEntity<>(facturaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Factura> crear(@RequestBody Factura c){
        return new ResponseEntity<>(facturaService.save(c), HttpStatus.CREATED);
    }


    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        facturaService.delete(id);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<Factura> updateUser(@PathVariable Integer id, @RequestBody Factura c) {
        if (facturaService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setCliente(c.getCliente());
        c.setFecha(c.getFecha());
        c.setDetalles(c.getDetalles());

        Factura newObjeto = facturaService.save(c);
        return ResponseEntity.ok(newObjeto);
    }
}
