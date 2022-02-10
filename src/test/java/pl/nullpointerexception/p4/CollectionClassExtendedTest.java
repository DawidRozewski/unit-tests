package pl.nullpointerexception.p4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CollectionClassExtendedTest {

    public static final boolean ACTIVE = true;
    public static final boolean INACTIVE = false;
    private CollectionClassExtended classExtended;

    @BeforeEach
     void beforeAll() {
        List<User> users = Arrays.asList(
                new User("jkowalski", ACTIVE),
                new User("jkowalski", INACTIVE),
                new User("jkowalski", ACTIVE),
                new User("jkowalski", INACTIVE),
                new User("jkowalski", ACTIVE)
        );
        classExtended =  new CollectionClassExtended(users);
    }

    @Test
    void shouldGetAllUsers() {
        // when
        List<User> allUsers = classExtended.getAllUsers();
        // then
        assertThat(allUsers).hasSize(5);
    }

}