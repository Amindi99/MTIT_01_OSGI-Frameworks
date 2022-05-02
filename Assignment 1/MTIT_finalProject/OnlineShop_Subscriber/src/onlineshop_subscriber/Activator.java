package onlineshop_subscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
//import kids.Kidsclothes;
//import mens.Mensclothes;
//import shoes.Shoes;
//import womens.Womensclothes;

import com.kids.publisher.Kidsclothes;
import com.mens.publisher.Mensclothes;
import com.shoes.publisher.Shoes;
import com.womens.publisher.Womensclothes;



public class Activator  implements BundleActivator  {

	
	ServiceReference serviceReferenceKids;
	ServiceReference serviceReferenceWomens;
	ServiceReference serviceReferenceMens;
	ServiceReference serviceReferenceShoes;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("start subscriber service Onlineshop");
		serviceReferenceKids = context.getServiceReference(Kidsclothes.class.getName());
		Kidsclothes kids = (Kidsclothes)context.getService(serviceReferenceKids);
		System.out.println(kids.publishService());
		
		serviceReferenceWomens = context.getServiceReference(Womensclothes.class.getName());
		Womensclothes womens = (Womensclothes)context.getService(serviceReferenceWomens);
		System.out.println(womens.publishService());
		
		serviceReferenceMens = context.getServiceReference(Mensclothes.class.getName());
		Mensclothes mens = (Mensclothes)context.getService(serviceReferenceMens);
		System.out.println(mens.publishService());
		
		serviceReferenceShoes = context.getServiceReference(Shoes.class.getName());
		Shoes shoes = (Shoes)context.getService(serviceReferenceShoes);
		System.out.println(shoes.publishService());
		
        Scanner scan = new Scanner(System.in);
		
        while (true) {
		
		System.out.println();
		System.out.println("-- Welcome to the Earth Wind Online Shop --");
		System.out.println();
		System.out.println("Kids clothes  | Enter 1");
		System.out.println("Women clothes | Enter 2");
		System.out.println("Men clothes   | Enter 3");
		System.out.println("Shoes         | Enter 4");
		System.out.println("Exit          | Enter 0");

		System.out.println("Select the category u like :");
		int num = scan.nextInt();
		
		if (num == 1) {
			System.out.println("Enter the price you looking for : ");
			int price = scan.nextInt();
			kids.calculateKidsClothesPrice(price);
		}
		if (num == 2) {
			System.out.println("Enter the price you looking for : ");
			int price = scan.nextInt();
			womens.calculateWomensClothesPrice(price);
		}
		if (num == 3) {
			System.out.println("Enter the price you looking for : ");
			int price = scan.nextInt();
			mens.calculateMensClothesPrice(price);
		}
		if (num == 4) {
			System.out.println("Enter the price you looking for : ");
			int price = scan.nextInt();
			shoes.calculateShoesPrice(price);
		}
		if(num == 0) {
			System.out.println("Exit the online-shop");
			break;
		}
        }
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("good bye subscriber service Onlineshop");
		context.ungetService(serviceReferenceKids);
		context.ungetService(serviceReferenceWomens);
		context.ungetService(serviceReferenceMens);
		context.ungetService(serviceReferenceShoes);
	}

	

}
