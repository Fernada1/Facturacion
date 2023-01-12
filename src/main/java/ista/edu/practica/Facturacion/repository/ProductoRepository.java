/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ista.edu.practica.Facturacion.repository;

import ista.edu.practica.Facturacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ferna
 */
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    
}
