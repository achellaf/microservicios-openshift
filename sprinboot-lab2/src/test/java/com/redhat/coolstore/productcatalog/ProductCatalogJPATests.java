package com.redhat.coolstore.productcatalog;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ProductCatalogJPATests {
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void testFindByName() {
		Product product = productRepository.findByName("Oculus Rift");
		assertTrue(444435L == product.getItemId());
	}
	
	public void testFindAll() {
		List<Product> productList = productRepository.findAll();
		assertEquals(productList.size(), 8);
	}
	
	public void testSaveAndDeleteProduct() {

		Product newProduct = new Product();
		newProduct.setName("Test Prod");
		newProduct.setDescription("This is a description");
		newProduct.setPrice(10.00d);

		 Product product = productRepository.save(newProduct);
		long id = product.getItemId();

		assertNotNull(productRepository.findOne(id));

		productRepository.delete(product);

		assertNull(productRepository.findOne(id));
	}

}