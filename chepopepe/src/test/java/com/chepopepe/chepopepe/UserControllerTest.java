package com.chepopepe.chepopepe;

import com.chepopepe.chepopepe.shared.GenericResponse;
import com.chepopepe.chepopepe.user.User;
import com.chepopepe.chepopepe.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UserRepository userRepository;

    @Before
    public void cleanup(){
        userRepository.deleteAll();
    }

    private static final String API_1_0_USERS = "/api/1.0/users";

    public User createValidUser(){
        User user = new User();
        user.setUsername("test-user");
        user.setDisplayName("test-name");
        user.setPassword("password");

        return user;
    }

    @Test
    public void postUser_whenUserIsValid_receiveOk() {
        User user = createValidUser();
        ResponseEntity <Object> response = testRestTemplate.postForEntity(API_1_0_USERS, user, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void postUser_whenUserIsValid_receiveSuccessMessage() {
        User user = createValidUser();
        ResponseEntity <GenericResponse> response = testRestTemplate.postForEntity(API_1_0_USERS, user, GenericResponse.class);

        assertThat(response.getBody().getMessage()).isNotNull();
    }

    @Test
    public void postUser_whenUserIsValid_userSavedToDatabase(){
        User user = createValidUser();
        testRestTemplate.postForEntity(API_1_0_USERS, user, Object.class);
        assertThat(userRepository.count()).isEqualTo(1);

    }
}
