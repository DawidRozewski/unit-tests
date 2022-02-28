package miniTesty.p4;

import java.util.List;
import java.util.stream.Collectors;

public class CollectionClassExtended {

    private final List<User> users;

    public CollectionClassExtended(List<User> users) {
        this.users = users;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public List<User> getAllActiveUsers() {
        return users.stream()
                .filter(User::isActive)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public List<User> getAllInactiveUsers() {
        return users.stream()
                .filter(user -> !user.isActive())
                .collect(Collectors.toList());
    }
}
