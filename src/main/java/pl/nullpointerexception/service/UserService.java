package pl.nullpointerexception.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nullpointerexception.model.User;
import pl.nullpointerexception.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User1 nie istnieje"));
    }
}
