/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.practica.Facturacion.controller;

import ista.edu.practica.Facturacion.model.Producto;
import ista.edu.practica.Facturacion.service.ProductoService;
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
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> obtenerLista() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> crear(@RequestBody Producto c){
        return new ResponseEntity<>(productoService.save(c), HttpStatus.CREATED);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<Producto> updateUser(@PathVariable Integer id, @RequestBody Producto c) {
        if (productoService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setNombre(c.getNombre());
        c.setStock(c.getStock());
        c.setPrecio(c.getPrecio());

        Producto newObjeto = productoService.save(c);
        return ResponseEntity.ok(newObjeto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        productoService.delete(id);
    }
}
