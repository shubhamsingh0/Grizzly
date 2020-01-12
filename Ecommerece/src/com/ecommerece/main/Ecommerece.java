package com.ecommerece.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.ecommerece.model.Product;
import com.ecommerece.model.ProductDetails;

public class Ecommerece {

	public Map<Integer,ProductDetails> addProduct(){
		Scanner sc=new Scanner(System.in);
		Product product=new Product();
		System.out.println("Generating id for your product...");
		product.setId((int)(Math.random()*10000));
		System.out.println("Id for your product is "+product.getId());
		ProductDetails productDetails=new ProductDetails();
		System.out.println("Enter Product Name");
		productDetails.setName(sc.next());
		System.out.println("Enter Product Description");
		productDetails.setDescription(sc.next());
		System.out.println("Enter Product Brand");
		productDetails.setBrand(sc.next());
		System.out.println("Enter Product Cost");
		productDetails.setCost(sc.nextInt());
		System.out.println("Enter Product quantity");
		productDetails.setQuantity(sc.nextInt());
		
		product.setProductDetails(productDetails);
		
		Map<Integer,ProductDetails> store=new HashMap<Integer,ProductDetails>();
		store.put(product.getId(), product.getProductDetails());
		return store;
		
	}
	public Product findProductById(List<Map<Integer,ProductDetails>> storageList,int id){
		 ProductDetails details=storageList.stream().filter(x->x.containsKey(id)).collect(Collectors.toList()).get(0).get(id);
		Product product =new Product();
		product.setId(id);
		product.setProductDetails(details);
		 return product;
	}
	public void getAllProduct(List<Map<Integer,ProductDetails>> storageList){
		 storageList.stream().forEach(x->{
			System.out.println(x);
		});
		
	}
	
	
	public static void main(String[] args){
		Ecommerece ecommerece=new Ecommerece();
		Scanner scs=new Scanner(System.in);
		List<Map<Integer,ProductDetails>> storageList=new ArrayList<Map<Integer,ProductDetails>>();
		System.out.println("Enter your Choice ");
		System.out.println("1. Add Product");
		System.out.println("2. search Product");
		System.out.println("3. Show All Products");
		int choice=scs.nextInt();
		while(choice>0){
		switch(choice){
		case 1:
		{
			
			storageList.add(ecommerece.addProduct());
			//System.out.println(storageList.get(0).get(storageList.get(0).keySet().toArray()[0]));
			break;
			
		}
		case 2:
		{
			System.out.println("Enter Product Id To Search ");
			System.out.println(ecommerece.findProductById(storageList,scs.nextInt()));
			break;
			
		}
		case 3:
		{
			System.out.println("List Of Available Products ");
			ecommerece.getAllProduct(storageList);
			
			break;
		}
		
		
		}
		
		System.out.println("Enter your Choice ");
		System.out.println("1. Add Product");
		System.out.println("2. search Product");
		System.out.println("3. Show All Products");
		
		 choice=scs.nextInt();
		
		}
		
		}
}
