package com.springdatagpt.springgpt;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import com.springdatagpt.springgpt.service.CrudProdutoService;

@SpringBootApplication
public class SpringgptApplication implements CommandLineRunner{
	public CrudProdutoService produtoService;

//CONSTRUTOR
public SpringgptApplication(CrudProdutoService produtoService){
	this.produtoService = produtoService;
}

	public static void main(String[] args) {
		SpringApplication.run(SpringgptApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		Boolean isTrue = true;
		Scanner scanner = new Scanner(System.in);
		while(isTrue){
			System.out.println("### MENU PRINCIPAL ###");
			System.out.println("# Escolha uma OPCAO #");
			System.out.println("# [1] PRODUTO");
			System.out.println("# [0] SAIR");
			int opcao = scanner.nextInt();

			switch(opcao){
				case 1:
					this.produtoService.menu(scanner);
				break;
				default:
					isTrue = false;
				break;
			}
			
		}
	}

}
