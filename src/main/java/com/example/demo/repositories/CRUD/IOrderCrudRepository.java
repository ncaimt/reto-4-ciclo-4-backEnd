/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repositories.CRUD;

import com.example.demo.models.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author nacai
 */
public interface IOrderCrudRepository extends MongoRepository<Order, Integer> {
    
    // retornan las ordenes que tengan la zona indicada como argumento
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);
    // listar las ordenes de acuerdo al estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    //Para seleccionar la orden con el id mayor
    Optional<Order> findTopByOrderByIdDesc();
   
}
