package co.historicoVacuna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HistoricoVacunaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistoricoVacunaApplication.class, args);
	}

}
