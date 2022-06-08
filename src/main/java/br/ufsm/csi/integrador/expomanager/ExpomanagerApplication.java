package br.ufsm.csi.integrador.expomanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpomanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpomanagerApplication.class, args);
		System.out.println("RODANDO expomanager");
	}

}
