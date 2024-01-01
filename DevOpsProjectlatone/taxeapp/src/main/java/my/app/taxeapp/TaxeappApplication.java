package my.app.taxeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaxeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxeappApplication.class, args);
	}

		public static int add(int i, int i1) {
			return i + i1;
		}
}
