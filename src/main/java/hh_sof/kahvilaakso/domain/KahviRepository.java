package hh_sof.kahvilaakso.domain;

import java.util.List;
import hh_sof.kahvilaakso.domain.Kahvi;

import org.springframework.data.repository.CrudRepository;

public interface KahviRepository extends CrudRepository<Kahvi, Long> {

    List<Kahvi> findByNimi(String nimi);

    List<Kahvi> findByNimiContaining(String nimi);
    
    Kahvi findByKahviId(Long kahviId);

    List<Arvostelu> findArvostelutByKahviId(Long kahviId);

    List<Kahvi> findByPaahtoaste(int paahtoaste);
}