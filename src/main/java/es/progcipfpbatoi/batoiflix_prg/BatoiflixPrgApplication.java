package es.progcipfpbatoi.batoiflix_prg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BatoiflixPrgApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatoiflixPrgApplication.class, args);
	}

}
