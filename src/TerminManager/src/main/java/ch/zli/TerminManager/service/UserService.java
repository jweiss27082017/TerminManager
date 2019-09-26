package ch.zli.TerminManager.service;

import ch.zli.TerminManager.domain.User;
import ch.zli.TerminManager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    public User createUser(User entry) {
        return userRepository.saveAndFlush(entry);
    }

    public void deleteUserById(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    public User updateEntry(User entry, Long id) {
        User updatedUser;
        Optional<User> optionalUpdatedUser = findUserById(id);

        if (optionalUpdatedUser.isPresent()) {
            updatedUser = optionalUpdatedUser.get();
            updatedUser.setUsername(entry.getUsername());
            updatedUser.setPassword(entry.getPassword());
        } else {
            updatedUser = entry;
            updatedUser.setId(id);
        }
        return userRepository.saveAndFlush(updatedUser);
    }
}