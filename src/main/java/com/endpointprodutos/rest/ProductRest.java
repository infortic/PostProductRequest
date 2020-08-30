
package com.endpointprodutos.rest;

import java.util.Timer;
import java.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.endpointprodutos.entity.Product;
import com.endpointprodutos.util.ValidityObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "product API")
@RequestMapping("/product")
public class ProductRest{
	
	long segund = (1000);
	long minute = (segund * 60);
	long temp = (minute * 10);
	
	@Autowired
	private ValidityObject validityObject;
	Boolean executando = false;
	
	Product productValidade = new Product();

	
	@ApiOperation(value = "Post Issues Events")
	@PostMapping(path = "/save")
	public ResponseEntity<?> saveProduct(@RequestBody Product product) throws InterruptedException {
		Long productId = productValidade.getId();
		if (productId == null) {
			this.productValidade = product;
			this.clearProductValidadeByTime(this.temp);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			Boolean isEquals = validityObject.validityProduct(productValidade, product);
			if (isEquals && executando) {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			} else {
				productValidade = product;
				this.clearProductValidadeByTime(this.temp);
				return new ResponseEntity<>(product, HttpStatus.OK);
			}

		}
	}
	
	public void clearProductValidadeByTime (long time) {
		executando = true;
		Timer timer = new Timer();
		TimerTask tarefa = new TimerTask() {
			@Override
			public void run() {
				productValidade = new Product();
				executando = false;
				System.out.println("requicição repetida ja pode ser aceita");
			}
		};
		timer.scheduleAtFixedRate(tarefa, time, time);
	}	
}
