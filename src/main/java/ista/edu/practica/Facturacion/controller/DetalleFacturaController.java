/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.practica.Facturacion.controller;

import ista.edu.practica.Facturacion.model.Detalle_Factura;
import ista.edu.practica.Facturacion.service.DetalleFacturaService;
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
@RequestMapping("/detalleFactura")
public class DetalleFacturaController {
    @Autowired
    DetalleFacturaService DetalleFacturaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Detalle_Factura>> obtenerLista() {
        return new ResponseEntity<>(DetalleFacturaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Detalle_Factura> crear(@RequestBody Detalle_Factura c){
        return new ResponseEntity<>(DetalleFacturaService.save(c), HttpStatus.CREATED);
    }


    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        DetalleFacturaService.delete(id);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<Detalle_Factura> updateUser(@PathVariable Integer id, @RequestBody Detalle_Factura c) {
        if (DetalleFacturaService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setCantidad(c.getCantidad());
        c.setFactura(c.getFactura());
        c.setProducto(c.getProducto());

        Detalle_Factura newObjeto = DetalleFacturaService.save(c);
        return ResponseEntity.ok(newObjeto);
    }
}
