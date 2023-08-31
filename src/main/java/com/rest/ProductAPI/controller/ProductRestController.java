package com.rest.ProductAPI.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.ProductAPI.exception.ProductNotFoundException;
import com.rest.ProductAPI.model.Product;

/**
 * 
 */
@RestController
public class ProductRestController {
	private static Map<Integer, Product> productsMap=new HashMap<>();
	
	static {
		Product laptop=new Product();
		laptop.setId(1000);
		laptop.setName("Lenovo");
		laptop.setStatus("Active");
		laptop.setPrice(45999.00);
		laptop.setQuantity(4);
		productsMap.put(laptop.getId(), laptop);
		
		Product mobile=new Product();
		mobile.setId(1001);
		mobile.setName("Iphone");
		mobile.setStatus("Active");
		mobile.setPrice(55999.00);
		mobile.setQuantity(10);
		productsMap.put(mobile.getId(), mobile);	
	}
   
	/**
	 * @return
	 */
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Object> getProducts(){
		return new ResponseEntity<>(productsMap.values(), HttpStatus.OK);
	}
	
	/**
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product){
		productsMap.put(product.getId(), product);
		return new ResponseEntity<>("Product Created Successfully", HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable String id){
		if(!productsMap.containsKey(Integer.valueOf(id)))throw new ProductNotFoundException();
		productsMap.remove(Integer.valueOf(id));
		return new ResponseEntity<>("Product deleted Successfully", HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getProduct(@PathVariable String id){
		if(!productsMap.containsKey(Integer.valueOf(id)))throw new ProductNotFoundException();
		return new ResponseEntity<>(productsMap.get(Integer.valueOf(id)), HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable String id, @RequestBody Product product){
		if(!productsMap.containsKey(Integer.valueOf(id)))throw new ProductNotFoundException();
		productsMap.remove(Integer.valueOf(id));
		product.setId(Integer.valueOf(id));
		productsMap.put(Integer.valueOf(id), product);
		return new ResponseEntity<>(productsMap.get(Integer.valueOf(id)), HttpStatus.OK);
	}
	
}
