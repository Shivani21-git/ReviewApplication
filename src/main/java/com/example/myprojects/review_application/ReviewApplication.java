package com.example.myprojects.review_application;

import com.example.myprojects.review_application.model.Product;
import com.example.myprojects.review_application.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class ReviewApplication extends SpringBootServletInitializer {
	public ReviewApplication() throws ParseException {
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ReviewApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	SimpleDateFormat obj = new SimpleDateFormat("yyyy/MM/dd");

	@Bean
	public CommandLineRunner getCommandLineRunner(ProductRepo productRepo) {

		return (args) -> {

			Product product1 = new Product("Dettol", "Handwash", obj.parse("2022/05/21"));
			Product product2 = new Product("Vim", "Dishwasher", obj.parse("2023/02/12"));
			Product product3 = new Product("Bambino", "Pasta", obj.parse("2025/01/23"));
			Product product4 = new Product("Solimo", "Water Bottle", obj.parse("2023/07/23"));
			productRepo.saveAll(Arrays.asList(product1,product2,product3,product4));

		};

	}
}
