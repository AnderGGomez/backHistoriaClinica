package co.edu.utp.isc.gia.historia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class HistoriasClinicasApplication {
	@PostConstruct
	public void init(){
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault(TimeZone.getTimeZone("UTC-5"));
	}

	public static void main(String[] args) {
		SpringApplication.run(HistoriasClinicasApplication.class, args);
	}

}
