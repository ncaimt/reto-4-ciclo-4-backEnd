package com.example.demo;


import com.example.demo.repositories.CRUD.ILaptopCrudRepository;
import com.example.demo.repositories.CRUD.IOrderCrudRepository;
import com.example.demo.repositories.CRUD.IUsuarioCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    
    @Autowired
    private ILaptopCrudRepository laptopCrudRepository;    
        
    @Autowired
    private IUsuarioCrudRepository userCrudRepository;
       
    @Autowired
    private IOrderCrudRepository orderCrudRepository;


    public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
//               SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                laptopCrudRepository.deleteAll();
//                userCrudRepository.deleteAll();
//                orderCrudRepository.deleteAll();
//
//                laptopCrudRepository.saveAll(List.of(
//                        new Laptop(1, "ACME", "MATERIAL 1", "PRESENTACION 1", "DESCRIPCION DETALLADA", true, 120000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-006127.jpg"),
//                        new Laptop(2, "ACME", "MATERIAL 2","PRESENTACION 2", "DESCRIPCION DETALLADA",  true, 130000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-007.jpg")
//                ));
//        
//                userCrudRepository.saveAll(List.of(
//                        new Usuario(1, "123123", "ALAN BRITO", ft.parse("1986-11-15"),"11","CR 34-45", "311222222", "abrito@gmail.com", "Demo123.", "ZONA 2", "ADM"),
//                        new Usuario(2, "61123211", "NAPOLEON BONAPARTE", ft.parse("1966-11-15"),"11","CR 34-45", "3168965645", "nbonaparte@gmail.com", "Demo123.", "ZONA 2", "COORD"),
//                        new Usuario(3, "46669989", "BLODY MARRY", ft.parse("1996-11-15"),"11","CR 34-45", "3174565625", "stellez@gmail.com", "Demo123.", "ZONA 2", "ASE"),
//                        new Usuario(4, "52369563", "JUANA DE ARCO", ft.parse("1987-05-15"),"05","CR 34-45", "3265632", "jdarco@gmail.com", "Demo123.", "ZONA 2", "ASE"),
//                        new Usuario(5, "123456789", "ALCIRA LA ALPACA", ft.parse("1966-02-15"),"02","CR 34-45", "3168965645", "aalpaca@gmail.com", "Demo123.", "ZONA 1", "COORD"),
//                        new Usuario(6, "213456789", "PEDRO CAPAROSA", ft.parse("1966-02-15"),"02","CR 34-45", "3168965645", "pcaparosa@gmail.com", "Demo123.", "ZONA 1", "ASE"),
//                        new Usuario(7, "312456789", "LUIS IXV UN SOL", ft.parse("1966-02-15"),"02","CR 34-45", "3168965645", "reysol@gmail.com", "Demo123.", "ZONA 1", "ASE")
//                ));
//        
//                //Instanciar las ordenes
//                Order orderOne = new Order();
//                orderOne.setId(1);
//                Order orderTwo = new Order();
//                orderTwo.setId(2);
//                
//                //Recuperar vendedores
//                Optional<Usuario> salesManOne = userCrudRepository.findById(3);
//                Optional<Usuario> salesManTwo = userCrudRepository.findById(6);
//        
//                //Mapa de productos asociados a una orden
//                Map<Integer, Laptop> productOrderOne = new HashMap<Integer, Laptop>();
//                Map<Integer, Laptop> productOrderTwo = new HashMap<Integer, Laptop>();
//        
//                //Mapa de cantidades de producto asociados a una orden
//                Map<Integer, Integer> quantitiesOrderOne = new HashMap<Integer, Integer>();
//                Map<Integer, Integer> quantitiesOrderTwo = new HashMap<Integer, Integer>();
//                
//                //lista de producto de la orden 1
//                productOrderOne.put(1, laptopCrudRepository.findById(1).get());
//                productOrderOne.put(2, laptopCrudRepository.findById(2).get());
//        
//                //Cantidades de producto de la orden 1      
//                quantitiesOrderOne.put(1, 1);
//                quantitiesOrderOne.put(2, 2);
//        
//                //lista de producto de la orden 2
//                productOrderTwo.put(1, laptopCrudRepository.findById(1).get());
//                productOrderTwo.put(2, laptopCrudRepository.findById(2).get());
//        
//                //Cantidades de producto de la orden 2
//                quantitiesOrderTwo.put(1, 1);
//                quantitiesOrderTwo.put(2, 1);
//                     
//                //Configuraciòn datos orden 1
//                orderOne.setRegisterDay(ft.parse("2021-09-15"));
//                orderOne.setStatus(Order.PENDING);
//                orderOne.setSalesMan(salesManOne.get());
//                orderOne.setProducts(productOrderOne);
//                orderOne.setQuantities(quantitiesOrderOne);
//                
//                //Configuraciòn datos orden 2
//                orderTwo.setRegisterDay(ft.parse("2021-09-15"));
//                orderTwo.setStatus(Order.PENDING);
//                orderTwo.setSalesMan(salesManTwo.get());
//                orderTwo.setProducts(productOrderTwo);
//                orderTwo.setQuantities(quantitiesOrderTwo);
//        
//        
//                //registra las ordenes en la base de datos
//                //imprime el los datos de las ordenes
//                orderCrudRepository.saveAll(List.of(orderOne, orderTwo));
//        //        
//                System.out.println("Listado de ordenes");
//               orderCrudRepository.findAll().forEach(System.out::println);       
        
  
         
    }    
}