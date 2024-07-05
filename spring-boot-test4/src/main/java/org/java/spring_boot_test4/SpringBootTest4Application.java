package org.java.spring_boot_test4;

import java.util.List;
import java.util.Optional;

import org.java.spring_boot_test4.db.pojo.ContoBancario;
import org.java.spring_boot_test4.db.service.ContoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTest4Application implements CommandLineRunner{

	@Autowired
	private ContoService contoService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTest4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try{
			ContoBancario c1 = new ContoBancario(0);
			c1.getDeposito(100);
			System.out.println(c1);
			ContoBancario c2 = new ContoBancario(0);
			c2.getDeposito(1400);
			System.out.println(c2);
			ContoBancario c3 = new ContoBancario(0);
			c3.getDeposito(350);
			System.out.println(c3);

			c2.getPrelievo(1000);
			System.out.println(c2);

			
			System.out.println("-------------------------------------------------------------------------");

			contoService.save(c1);
			contoService.save(c2);
			contoService.save(c3);

			contoService.getAllConti().forEach(System.out::println);

			
			System.out.println("-------------------------------------------------------------------------");


			Optional<ContoBancario> oldContoOpt = contoService.getContoById(3);
			if(oldContoOpt.isEmpty()){
				System.out.println("Conto non trovato");
				return;
			}

			ContoBancario oldConto = oldContoOpt.get();

			oldConto.setId(0);
			oldConto.setSaldo(15000);
			contoService.save(oldConto);
			contoService.getAllConti().forEach(System.out::println);

			System.out.println("-------------------------------------------------------------------------");

			Optional<ContoBancario> oldContoOpt2 = contoService.getContoById(2);
			if(oldContoOpt2.isEmpty()){
				System.out.println("Conto non trovato");
				return;
			}

			ContoBancario oldConto2 = oldContoOpt2.get();
			contoService.delete(oldConto2);

			contoService.getAllConti().forEach(System.out::println);



		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		
	}

}
