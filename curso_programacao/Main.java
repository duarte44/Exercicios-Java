package curso_programacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int x = sc.nextInt();
		
		for(int i = 0; i < x; i++) {
			System.out.println("Product "+ (i+1) + " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char ch = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();			
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Customs fee: ");
				double valor = sc.nextDouble();
				Product emp = new ImportedProduct(name, price, valor);
				list.add(emp);
			}
			else if(ch == 'c') {				
				Product emp = new Product(name, price);
				list.add(emp);
			}
			else if(ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			}
						
		}
		
		System.out.println();
		System.out.println("Price Tags: ");
		for(Product product : list) {
			System.out.println(product.priceTag());			
			
		}
		
		
		sc.close();
	}

}
