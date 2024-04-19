package com.fanta.newspriborzhavalyceum.database.service;

import com.fanta.newspriborzhavalyceum.database.entity.User;
import com.fanta.newspriborzhavalyceum.database.exception.CustomAuthenticationException;
import com.fanta.newspriborzhavalyceum.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final static String USER_NOT_FOUND_MSG =
            "користувача &s поштою не знайдено ";
    private final UserRepository userRepository;


    public User createUser(User user) {
        if (!isEmailPresent(user.getEmail())) {
            throw new CustomAuthenticationException("Електронна адреса уже використовується.");
        }

        return userRepository.save(user);
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public User updateUser(User user) {
        return userRepository.findById(user.getId())
                .map(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setPassword(user.getPassword());
                    existingUser.setUserRole(user.getUserRole());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new EntityNotFoundException("User with id " + user.getId() + " not found"));
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    /*   public Optional<User> findByEmail(String email) {
           if (isEmailPresent(email)) {
               return userRepository.findByEmail(email);
           } else {
               throw new EmailAlreadyExistsException("Електронна адреса уже використовується.");
           }
       }*/
    public boolean isEmailPresent(String email) {
        return !userRepository.findByEmail(email).isPresent();
    }


}
