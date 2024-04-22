package hh_sof.kahvilaakso;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import hh_sof.kahvilaakso.domain.KahviRepository;
import hh_sof.kahvilaakso.domain.Kahvi;

@DataJpaTest
public class KahviRepositoryTest {

    @Autowired
    private KahviRepository kahviRepository;

    @Test
    public void findByNimiShouldReturnKahvi() {

        Kahvi savedKahvi = kahviRepository.save(new Kahvi("Test Kahvi", "Test Description", "Test Origin", 1, false));

        Kahvi foundKahvi = kahviRepository.findByNimi("Test Kahvi").get(0);

        assertThat(foundKahvi).isNotNull();
        assertThat(foundKahvi.getNimi()).isEqualTo("Test Kahvi");
    }

    @Test
    public void saveKahvi() {

        Kahvi kahvi = new Kahvi("New Kahvi", "New Description", "New Origin", 2, true);

        Kahvi savedKahvi = kahviRepository.save(kahvi);

        assertThat(savedKahvi).isNotNull();
        assertThat(savedKahvi.getKahviId()).isNotNull();
    }
}