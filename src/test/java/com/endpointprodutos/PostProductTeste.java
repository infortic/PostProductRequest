package com.endpointprodutos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.endpointprodutos.entity.Product;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PostProductTeste {


	@Autowired
	private TestRestTemplate restTemplet;

	@Test
	public void testPostResponseStatusCode200() {
		Product product = new Product();
		product.setId(new Long(0));
		product.setNome("Mesa");
		ResponseEntity<?> response = this.restTemplet.postForEntity("/product/save", product, Product.class);
		System.out.println("Primeira solicitação retornar 200-ok");
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void testPostResponseStatusCode403() {
		Product product = new Product();
		product.setId(new Long(0));
		product.setNome("Mesa");
		ResponseEntity<?> response = this.restTemplet.postForEntity("/product/save", product, Product.class);
		System.out.println("Primeira solicitação retornar 200-ok");
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(403);
	}
	
}
