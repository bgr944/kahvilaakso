package hh_sof.kahvilaakso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh_sof.kahvilaakso.domain.KahviRepository;
import hh_sof.kahvilaakso.domain.ArvosteluRepository;
import hh_sof.kahvilaakso.domain.Arvostelu;
import hh_sof.kahvilaakso.domain.Kahvi;
import hh_sof.kahvilaakso.domain.User;
import hh_sof.kahvilaakso.domain.UserRepository;

@SpringBootApplication
public class KahvilaaksoApplication {

	private static final Logger log = LoggerFactory.getLogger(KahvilaaksoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KahvilaaksoApplication.class, args);
	}

	@Bean
	public CommandLineRunner kahviRunner(KahviRepository KahviRepository,
	ArvosteluRepository aRepository, UserRepository uRepository) {
		return (args) -> {
			log.info("lisätään kahvia");

			KahviRepository.save(new Kahvi("Juhla Mokka", "Ankean perinteinen", "Suomi", 1, false));
			KahviRepository.save(new Kahvi("Presidentti", "Tietysti Pauligin", "Suomi", 1, false));

			User kayttaja1 = new User("user", "$2a$10$3xcYXSda5/AOBeHlM9tc6.EkVh17s9lRpx2P/zVZpGO8q38P9yWL6", "USER");
			User kayttaja2 = new User("admin", "$2a$10$IipQNXVRjHKIQOZXgwhF2.cv8WMVr/asPow9htX4Txrv/lRE6RQzy", "ADMIN");
			uRepository.save(kayttaja1);
			uRepository.save(kayttaja2);

			for (Kahvi kahvi : KahviRepository.findAll()) {
				log.info(kahvi.toString());
			}
			;
		};
	}
}
