package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.entities.Credential;
import com.revature.entities.Employee;
import com.revature.service.CredentialService;
import com.revature.service.EmployeeService;
import com.revature.util.ConnectionUtil;

public class Driver {
	
	public static EmployeeService eserv;
	public static CredentialService cserv;

	public Driver() {
	}

	public static void main(String[] args) {
		String username = System.getenv("DB_USERNAME"); 
		  String url =  System.getenv("DB_URL"); 
		  String password = System.getenv("DB_PASSWORD");

			System.out.println(username + " " + password + " " + url);


		 
		
		  
//		  Employee e1 = new Employee();
//		  Credential c1 = new Credential();
//			c1.setId(1);
//			c1.setUsername("happylittletrees");
//			c1.setPassword("bobbyboy1942");
//			
//			
//			e1.setId(1);
//			e1.setFirstName("Bob");
//			e1.setLastName("Ross");	
//			e1.setReportsTo(1);
//			e1.setCredentialid(c1);
//			System.out.println(e1); 
		
		Credential cr = new Credential(1, "Happy", "Littletrees");
		Employee empl = new Employee(1, "Bob", "Ross", 1, cr);
		eserv.createEmployee(empl);
		System.out.println(empl);
		
		  	
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		  Session s = sf.openSession(); 
		  System.out.println(s.getStatistics()); 
		  s.close();
		
		
	}
	
	
	
	static void test() {
		/*Employee e1 = (EmployeeWithSetter) ac.getBean("employeeWithSetter");
		f1.setTopic(FlashcardTopics.BEARS);
		f1.setQuestion("How many bears are there?");
		f1.setAnswer("7 bears");
		System.out.println(f1);
		
		Flashcard f2 = (FlashcardWithConstructor) ac.getBean("flashcardWithConstructor");
		f2.setTopic(FlashcardTopics.MATH);
		f2.setQuestion("What's 9 plus 10?");
		f2.setAnswer("7 bears");
		System.out.println(f2);
		
		Flashcard f3 = (FlashcardWithAutoByName) ac.getBean("flashcardWithAutoByName");
		f3.setTopic(FlashcardTopics.CODING);
		f3.setQuestion("What is Java?");
		f3.setAnswer("7 bears");
		System.out.println(f3);
		
		
		Flashcard f4 = (FlashcardWithAutoByType) ac.getBean("flashcardWithAutoByType");
		f4.setTopic(FlashcardTopics.CODING);
		f4.setQuestion("What is JavaScript?");
		f4.setAnswer("7 bears, or maybe not");
		System.out.println(f4);
		*/
		
		Employee e1 = new Employee();
		Credential c1 = new Credential();
		c1.setId(1);
		c1.setUsername("happylittletrees");
		c1.setPassword("bobbyboy1942");
		
		
		e1.setId(1);
		e1.setFirstName("Bob");
		e1.setLastName("Ross");	
		e1.setReportsTo(1);
		e1.setCredentialid(c1);
		System.out.println(e1); 
	}

}
