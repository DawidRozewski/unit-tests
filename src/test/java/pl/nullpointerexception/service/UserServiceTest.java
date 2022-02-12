package pl.nullpointerexception.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.nullpointerexception.model.User;
import pl.nullpointerexception.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    public static final boolean IS_SUPERUSER = true;
    public static final boolean IS_NOT_SUPERUSER = false;
    public static final boolean ACTIVE = true;
    public static final boolean INACTIVE = false;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        when(userRepository.findAll())
                .thenReturn(Arrays.asList(
                        new User(1L, "test1", ACTIVE, IS_SUPERUSER),
                        new User(1L, "test2", ACTIVE, IS_NOT_SUPERUSER),
                        new User(1L, "test2", INACTIVE, IS_NOT_SUPERUSER)
                ));
    }

    @Test
    void shouldGetActiveSuperUser() {
        // when
        List<User> activeSuperUsers = userService.getActiveSuperUsers();
        // then
        assertThat(activeSuperUsers).hasSize(1);
        assertThat(activeSuperUsers)
                .extracting("active")
                .containsOnly(true);
        assertThat(activeSuperUsers)
                .extracting("superuser")
                .containsOnly(true);
    }

    @Test
    void shouldGetActiveUser() {
        // when
        List<User> activeUsers = userService.getActiveUsers();
        // then
        assertThat(activeUsers).hasSize(2);
        assertThat(activeUsers)
                .extracting("active")
                .containsOnly(true);
    }

    @Test
    void shouldGetAllUsers() {
        // when
        List<User> users = userService.getAllUsers();
        // then
        assertThat(users).hasSize(3);

    }
}
