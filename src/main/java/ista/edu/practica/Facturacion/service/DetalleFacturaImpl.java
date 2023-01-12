/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.practica.Facturacion.service;

import ista.edu.practica.Facturacion.model.Detalle_Factura;
import ista.edu.practica.Facturacion.repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferna
 */
@Service
public class DetalleFacturaImpl extends GenericServiceImpl<Detalle_Factura, Integer> implements DetalleFacturaService{
@Autowired
DetalleRepository detalleRepository;
    @Override
    public CrudRepository<Detalle_Factura, Integer> getDao() {
        return detalleRepository;
    }
    
}
