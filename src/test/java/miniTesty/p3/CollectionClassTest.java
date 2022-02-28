package miniTesty.p3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CollectionClassTest {

    CollectionClass collectionClass = new CollectionClass();

    @Test
    void shouldGetAllUsers() {
        // given
        // when
        List<User> allUsers = collectionClass.getAllUsers();
        // then
        assertThat(allUsers).isNotNull();
        assertThat(allUsers.size()).isEqualTo(5);
    }

    @Test
    void shouldGetAllActiveUsers() {
        // given
        // when
        List<User> allActiveUsers = collectionClass.getAllActiveUsers();
        // then
        assertThat(allActiveUsers).isNotNull();
        assertThat(allActiveUsers.size()).isEqualTo(2);
    }
    @Test
    void shouldGetAllInActiveUsers() {
        // given
        // when
        List<User> allInActiveUsers = collectionClass.getAllInactiveUsers();
        // then
        assertThat(allInActiveUsers).isNotNull();
        assertThat(allInActiveUsers.size()).isEqualTo(3);
    }
}