package pl.nullpointerexception.p3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CollectionClassTest {

    private CollectionClass collectionClass = new CollectionClass();

    @Test
    void shouldGetAllUsers() {
        // when
        List<User> users = collectionClass.getAllUsers();
        // then
        assertThat(users)
                .isNotNull()
                .hasSize(5);
    }

    @Test
    void shouldGetAllActiveUsers() {
        // when
        List<User> allActiveUsers = collectionClass.getAllActiveUsers();
        // then
        assertThat(allActiveUsers)
                .extracting("active")
                .containsOnly(true);

    }

    @Test
    void shouldGetAllInActiveUsers() {
        // when
        List<User> allActiveUsers = collectionClass.getAllInactiveUsers();
        // then
        assertThat(allActiveUsers)
                .extracting("active")
                .containsOnly(false);

    }

    @Test
    void shouldContainsSpecificOrder() {
        // when
        List<User> allActiveUsers = collectionClass.getAllActiveUsers();
        // then
        assertThat(allActiveUsers)
                .extracting("active")
                .containsOnly(true);

        assertThat(allActiveUsers)
                .extracting("name")
                .containsExactly("jkowalski", "akowalski");

    }


}