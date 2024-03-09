package com.example.demo;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.EmployeeCrud;
import com.example.demo.dao.LibrayCrud;
import com.example.demo.dao.StudentCrud;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Libray;
import com.example.demo.pojo.Student;

@SpringBootApplication
public class SpringDemoApplication {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ConfigurableApplicationContext ac = SpringApplication.run(SpringDemoApplication.class, args);
		
		while(true) {
			
			System.out.println("Press\n1.SQl\n2.Hiebernate\n3.Java\n4.Exit");
			int choice = sc.nextInt();
			if(choice == 4) {
				break;
			}
			else if(choice== 1) {
				while (true) {

					System.out.println("Press\n1.Insert\n2.Read\n3.Update\n4.Delete\n5.Exit");
					int index = sc.nextInt();
					if (index == 5)
						break;

					switch (index) {
					case 1:
						insertSql();
						break;
					case 2:
						readSql();
						break;

					case 3:
						updateSql();
						break;

					case 4:
						deleteSql();
						break;

					case 5:

						break;

					default:
						break;
					}
				}

			}
			else if(choice == 2) {
				
				while (true) {

					System.out.println("Press\n1.Insert\n2.Read\n3.Update\n4.Delete\n5.Exit");
					int index = sc.nextInt();
					if (index == 5)
						break;

					switch (index) {
					case 1:
						insertHQL();
						break;
					case 2:
						readHQL();
						break;

					case 3:
						updateHQL();
						break;

					case 4:
						deleteHQL();
						break;

					case 5:

						break;

					default:
						break;
					}
				}

			}
			
		
			
            else if(choice == 3) {
            	
            	
            	while (true) {

        			System.out.println("Press\n1.Insert\n2.Read\n3.Update\n4.Delete\n5.Exit");
        			int index = sc.nextInt();
        			if (index == 5)
        				break;

        			switch (index)
        			{
        			case 1:
        				insertJava();
        				break;
        			case 2:
        				readJava();
        				break;

        			case 3:
        				updateJava();
        				break;

        			case 4:
        				deleteJava();
        				break;

        			case 5:

        				break;

        			default:
        				break;
        			}
        		}

        	}
				
			
			
			}
			
		}
	
	private static void deleteJava() {
		
		System.out.println("Enter Id");
		int id = sc.nextInt();
		ApplicationContext ac = ApplicationContextClass.getApplicationContext();
		LibrayCrud bean = ac.getBean(LibrayCrud.class);
		bean.deleteById(id);
		System.out.println("Deleted!!!");
		
	}

	private static void updateJava() {
		// TODO Auto-generated method stub
		
	}

	private static void readJava() {
		System.out.println("1.Read All Data\n2.Specific Data");
		int choice = sc.nextInt();
		if(choice == 2) {
			System.out.println("Enter Id");
			int id = sc.nextInt();
			ApplicationContext ac = ApplicationContextClass.getApplicationContext();
			LibrayCrud bean = ac.getBean(LibrayCrud.class);
			Optional<Libray> data = bean.findById(id);
			Libray spcifyData = data.get();
			System.out.println(spcifyData.toString());
		}
		else {
			ApplicationContext ac = ApplicationContextClass.getApplicationContext();
			LibrayCrud bean = ac.getBean(LibrayCrud.class);
			Iterable<Libray> list = bean.findAll();
			
			for(Libray li:list) {
				System.out.println(li.toString());
			}
			

		}

		
	}

	private static void insertJava() {
		
		while(true) {
			
			System.out.println("Enter Id");
			int id = sc.nextInt();
			System.out.println("Enter Name");
			String name = sc.next();
			System.out.println("Enter Author");
			String auhtor = sc.next();
			
			Libray libray = new Libray(id, name, auhtor);
			ApplicationContext ac = ApplicationContextClass.getApplicationContext();
			LibrayCrud bean = ac.getBean(LibrayCrud.class);
			bean.save(libray);
			System.out.println("Saved!!!!");
			System.out.println("Add More Data Press Y/N");
			char ch = sc.next().charAt(0);
			if(ch == 'N' || ch =='n')break;
		}
		
		
	}

	private static void insertHQL() {
		// TODO Auto-generated method stub
		
	}
	
	

	private static void readHQL() {
		
		ApplicationContext ac = ApplicationContextClass.getApplicationContext();
		StudentCrud bean = ac.getBean(StudentCrud.class);
		List<Student> list = bean.read();

		for(Student li:list) {
			System.out.println(li.toString());
		}
	}

	private static void updateHQL() {
		
		System.out.println("Enter ID");
		int id = sc.nextInt();
		System.out.println("Enter Dept");
		String dept = sc.next();
		
		ApplicationContext ac = ApplicationContextClass.getApplicationContext();
		StudentCrud bean = ac.getBean(StudentCrud.class);
		int rows = bean.update(id, dept);
		if(rows == 1) {
			System.out.println("Updated!!!!");
		}
		
	}

	private static void deleteHQL() {

		System.out.println("Enter ID");
		int id = sc.nextInt();
		ApplicationContext ac = ApplicationContextClass.getApplicationContext();
		StudentCrud bean = ac.getBean(StudentCrud.class);
		int rows = bean.delete(id);
		if(rows == 1) {
			System.out.println("Deleted!!!2");
		}
	}

	private static void deleteSql() {

		System.out.println("Enter Id");
		int id = sc.nextInt();
		ApplicationContext ac = ApplicationContextClass.getApplicationContext();
		EmployeeCrud bean = ac.getBean(EmployeeCrud.class);
		int rows = bean.delete(id);

		if (rows == 1) {
			System.out.println("Deleted!!!" + rows);

		}
	}

	private static void updateSql() {

		System.out.println("Enter Id");
		int id = sc.nextInt();
		System.out.println("Enter Sallary");
		int sallary = sc.nextInt();
		ApplicationContext ac = ApplicationContextClass.getApplicationContext();
		EmployeeCrud bean = ac.getBean(EmployeeCrud.class);
		int row = bean.update(id, sallary);
		if (row == 1) {
			System.out.println("Updated!!!!" + row);
		}

	}

	private static void readSql() {

		ApplicationContext ac = ApplicationContextClass.getApplicationContext();
		EmployeeCrud bean = ac.getBean(EmployeeCrud.class);
		List<Employee> list = bean.read();
		for (Employee li : list) {
			System.out.println(li.toString());
		}

	}

	private static void insertSql() {

		System.out.println("Enter ID");
		int id = sc.nextInt();

		System.out.println("Enter Name");
		String name = sc.next();

		System.out.println("Enter Address");
		String address = sc.next();

		System.out.println("Enter Sallary");
		int sallary = sc.nextInt();

		ApplicationContext ac = ApplicationContextClass.getApplicationContext();
		EmployeeCrud bean = ac.getBean(EmployeeCrud.class);
		int rows = bean.insert(id, name, address, sallary);
		if (rows == 1) {
			System.out.println("Inserted!!!!");
		}



	}


}