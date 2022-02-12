package pl.nullpointerexception.service;

import org.springframework.stereotype.Service;
import pl.nullpointerexception.model.User;
import pl.nullpointerexception.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository usersRepository) {
        this.userRepository = usersRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getActiveUsers() {
        return userRepository.findAll().stream()
                .filter(User::isActive)
                .collect(Collectors.toList());
    }

    public List<User> getActiveSuperUsers() {
        return userRepository.findAll().stream()
                .filter(User::isActive)
                .filter(User::isSuperuser)
                .collect(Collectors.toList());
    }
}
