package hh_sof.kahvilaakso;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import hh_sof.kahvilaakso.web.KahviController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class KahvilaaksoApplicationTests {

	@Autowired
	private KahviController controller;
	
	 @Test
	 public void contexLoads() throws Exception {
	assertThat(controller).isNotNull();
	}
 }
