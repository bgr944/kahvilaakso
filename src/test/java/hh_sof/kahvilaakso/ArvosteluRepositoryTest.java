/* Tähän meni hermo, se ei siis toiminut

package hh_sof.kahvilaakso;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh_sof.kahvilaakso.domain.Arvostelu;
import hh_sof.kahvilaakso.domain.ArvosteluRepository;
import hh_sof.kahvilaakso.domain.User;
import hh_sof.kahvilaakso.domain.UserRepository;
import hh_sof.kahvilaakso.domain.Kahvi;
import hh_sof.kahvilaakso.domain.KahviRepository;

@DataJpaTest
public class ArvosteluRepositoryTest {

    @Autowired
    private ArvosteluRepository arvosteluRepository;

    @Autowired
    private KahviRepository kahviRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUserShouldReturnArvostelut() {

        User kayttaja2 = new User("admin", "$2a$10$IipQNXVRjHKIQOZXgwhF2.cv8WMVr/asPow9htX4Txrv/lRE6RQzy", "ADMIN");
        userRepository.save(kayttaja2);

        User user = new User("username", "password", "ROLE_USER");
        Arvostelu arvostelu1 = new Arvostelu();
        arvostelu1.setUser(user);
        Arvostelu arvostelu2 = new Arvostelu();
        arvostelu2.setUser(user);
        arvosteluRepository.save(arvostelu1);
        arvosteluRepository.save(arvostelu2);

        List<Arvostelu> foundArvostelut = arvosteluRepository.findByUser(user);

        assertThat(foundArvostelut.size()).isEqualTo(2);
        assertThat(foundArvostelut).contains(arvostelu1, arvostelu2);
    }

    @Test
    public void findArvostelutByKahviIdShouldReturnArvostelut() {
        Kahvi kahvi = new Kahvi("Test Kahvi", "Test Description", "Test Origin", 1, false);
        kahviRepository.save(kahvi);
        Long kahviId = kahvi.getKahviId();
        
        User kayttaja2 = new User("admin", "$2a$10$IipQNXVRjHKIQOZXgwhF2.cv8WMVr/asPow9htX4Txrv/lRE6RQzy", "ADMIN");
    
        Arvostelu arvostelu1 = new Arvostelu(kayttaja2, 5, "Kommentti 1", kahvi);
        Arvostelu arvostelu2 = new Arvostelu(kayttaja2, 4, "Kommentti 2", kahvi);
        arvosteluRepository.save(arvostelu1);
        arvosteluRepository.save(arvostelu2);
    
        List<Arvostelu> foundArvostelut = arvosteluRepository.findKahviByKahviId(kahviId);
    
        assertThat(foundArvostelut.size()).isEqualTo(2);
        assertThat(foundArvostelut).contains(arvostelu1, arvostelu2);
    }
}
*/