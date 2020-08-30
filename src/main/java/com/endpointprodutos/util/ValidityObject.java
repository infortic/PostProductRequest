package com.endpointprodutos.util;

import org.springframework.stereotype.Service;

import com.endpointprodutos.entity.Product;

@Service
public class ValidityObject {
	public Boolean validityProduct(Product productOne, Product productTwo) {
		Boolean isEquals = false;
		if(productOne.getId().equals(productOne.getId())) {
			if(productOne.getNome().equals(productTwo.getNome())) {
				isEquals = true;
			}
		}
		return isEquals;
	}
}
