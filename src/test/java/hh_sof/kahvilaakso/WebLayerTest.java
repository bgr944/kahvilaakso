package hh_sof.kahvilaakso;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "classpath:kahvitTest.sql")
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    // testaa admin käyttäjällä joka luodaan myös sovelluksen käynnistyksessä
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_ROLES = "ADMIN";
    private static final String ADMIN_HASHED_PASSWORD = "$2a$10$IipQNXVRjHKIQOZXgwhF2.cv8WMVr/asPow9htX4Txrv/lRE6RQzy"; // Hashed password from User object

    @Test
    @WithMockUser(username = ADMIN_USERNAME, password = ADMIN_HASHED_PASSWORD, roles = ADMIN_ROLES)
    public void testGetKaikkiKahvit() throws Exception {
        this.mockMvc.perform(get("/kahvit"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @WithMockUser(username = ADMIN_USERNAME, password = ADMIN_HASHED_PASSWORD, roles = ADMIN_ROLES)
    public void testGetYksiKahvi() throws Exception {
        this.mockMvc.perform(get("/kahvit/{id}", 1L))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}