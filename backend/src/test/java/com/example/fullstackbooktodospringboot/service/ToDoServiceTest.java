package com.example.fullstackbooktodospringboot.service;

import com.example.fullstackbooktodospringboot.dto.UserDto;
import com.example.fullstackbooktodospringboot.model.User;
import com.example.fullstackbooktodospringboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class ToDoServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getUsersShouldReturnUsers() throws Exception {
        List<User> users = new ArrayList<>();
        User user = new User();
        Date dRegister = new Date(2023/04/19);
        user.setIdUser(1L);
        user.setName("User345");
        user.setDateRegister(dRegister);
        user.setUsername("user345");
        user.setPassword("passwrd");
        users.add(user);
        when(userRepository.findAll()).thenReturn(users);
        List<UserDto> userDtoList = userService.getUsers();
        assertThat(userDtoList).hasSize(1);
    }
}
