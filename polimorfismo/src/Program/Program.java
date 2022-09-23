package Program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;
import revision.Employee;

public class Program {
  public static void main(String[] args) throws ParseException {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	List<Product> list = new ArrayList<>();
	
	System.out.println("Enter the number of products: ");
	int n = sc.nextInt();
	
	for (int i = 0; i < n; i++) {
		System.out.println("Product #"+i+ " data: ");
		
		System.out.print("Common, used or imported (c/u/i)? ");
		char ch = sc.next().charAt(0);
		
		System.out.print("Name: ");
		sc.next();
		String name = sc.nextLine();
		
		System.out.print("Price: ");
		Double price = sc.nextDouble();
	
		if(ch == 'i') {
			System.out.print("Customs Fee: ");
			Double customFee = sc.nextDouble();
			
			Product prod = new ImportedProduct(name, price, customFee);
			list.add(prod);
			
		}else if(ch == 'u'){
			System.out.println("Manufacture date:  ");
			Date manufactureDate = sdf.parse(sc.next());
			Product prod2 = new UsedProduct(name, price, manufactureDate); 
			list.add(prod2);
		
		}else if(ch == 'c') {
			Product prod3 = new Product(name, price);
			list.add(prod3);
			
		}else {
			System.out.println("invalid information!");
		}
		System.out.println("");
		System.out.println("PRICE TAGS: ");
		
		for(Product prod : list) {
				 System.out.println(prod.getName() +" - $" + String.format(prod.priceTag()));
			}
				}
		
  					}	
						}
	
	
  				

						
