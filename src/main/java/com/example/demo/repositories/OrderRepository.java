/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repositories;


import com.example.demo.models.Order;
import com.example.demo.repositories.CRUD.IOrderCrudRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


/**
 *
 * @author nacai
 */
@Repository
public class OrderRepository {
    
    
    @Autowired
    private IOrderCrudRepository orderCrudRepository;
    
    
    //Reto4 
    @Autowired 
    private MongoTemplate mongotemplate;  
    
    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }
    
    public Optional<Order> lastUserId(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }
    
    public List<Order> findByZone(String zona) {
        return orderCrudRepository.findByZone(zona);
    }
    
    //Reto4 
    
    //Peticion de las ordenes de un asesor por id
    public List<Order> ordersSalesManByID(Integer id) {
        Query query = new Query();

        Criteria criterio = Criteria.where("salesMan.id").is(id);
        query.addCriteria(criterio);
        List<Order> orders = mongotemplate.find(query, Order.class);

        return orders;
    }
    
    //Ordenes de un asesor X estado y id 
    public List<Order> ordersSalesManByState(String state, Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id).and("status").is(state);
        query.addCriteria(criterio);
        List<Order> orders = mongotemplate.find(query, Order.class);
        return orders;
    }
    
    //Ordenes de un asesor por fecha o el id 
    public List<Order> ordersSalesManByDate(String dateStr, Integer id){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();
        
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);
        query.addCriteria(dateCriteria);
        
        List<Order> orders = mongotemplate.find(query, Order.class);
        return orders;
    }
      

}
