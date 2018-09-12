package com.redhat.coolstore.productcatalog;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@RestController("/products")
public class ProductCatalogService {
	
	@Autowired
	private ProductRepository productRepository;
	
    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> list() {
        return productRepository.findAll();
    }
   
	
}
