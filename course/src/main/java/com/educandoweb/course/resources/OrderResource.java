package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	@Autowired
	private OrderService sevice;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		//Order u = new Order(1L, "Maria", "maria@gmail.com", "99999999","12345");
		List<Order> list = sevice.findAll();
		return ResponseEntity.ok().body(list);
		    
	}
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
    	Order obj = sevice.findById(id);
    	return ResponseEntity.ok().body(obj);
    }
}
