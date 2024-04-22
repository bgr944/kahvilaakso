package hh_sof.kahvilaakso.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ArvosteluRepository extends CrudRepository<Arvostelu, Long> {
    List<Arvostelu> findByUser(User user);

    List<Arvostelu> findByKahviId(Long kahviId);
}
