package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
	
	
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===== TEST 1: seller findByd ====");
		
		Seller seller = sellerDao.findById(9);
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 3: seller findAll ====");
		Department department = new Department (4 ," " );
		List< Seller > list = sellerDao.findAll();
		
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: seller insert ====");
		Seller newSeller = new Seller (null, "ORGGreg", " orggreg@gmail.com", new Date(), 5000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 6: seller delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println("\n=== TEST 2: seller findBydDepartment ====");
		
		list = sellerDao.findByDepartment(department);
		
		for (Seller obj: list) {
			System.out.println(obj);
		}

		
		System.out.println("\n=== TEST 5: seller update ====");
		seller = sellerDao.findById(10);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		
	}

}
