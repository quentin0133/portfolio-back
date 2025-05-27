package fr.quentin.portfolio.portfolioback.group.categories;

import fr.quentin.portfolio.portfolioback.auth.UserSecurity;
import fr.quentin.portfolio.portfolioback.categories.CategoryRepository;
import fr.quentin.portfolio.portfolioback.core.tools.JwtUtils;
import fr.quentin.portfolio.portfolioback.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Project integration test.
 */
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProjectIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryRepository categoryRepository;

    private static String jwtToken;

    /**
     * Sets .
     */
    @BeforeEach
    public void setup() {
        UserDetails user = new UserSecurity(new User(0, 0, "johndoe", "password123", List.of("ADMIN")));
        jwtToken = JwtUtils.generateToken(user);
    }

    /**
     * Find all.
     *
     * @throws Exception the exception
     */
    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/api/projects"))
//                    .header("Authorization","Bearer " + jwtToken)
//                    .accept("application/json")
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isNotEmpty())
            .andExpect(jsonPath("$.size()").value(categoryRepository.findAll().size()));
    }

    //    @Test
    //    void save() {
    //    }
    //
    //    @Test
    //    void update() {
    //    }
    //
    //    @Test
    //    void deleteById() {
    //    }
    //
    //    @Test
    //    void findById() {
    //    }
}