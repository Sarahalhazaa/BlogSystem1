package com.example.blogsystem1.Service;

import com.example.blogsystem1.API.ApiException;
import com.example.blogsystem1.Model.User;
import com.example.blogsystem1.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public List<User> getUser() {
        return authRepository.findAll();
    }

    public void register(User user) {

        String hash = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hash);
        authRepository.save(user);

    }

    public void updateUser( String userName , User user) {
        User user1 = authRepository.findUserByUserName(userName);
        if (user1 == null) {
            throw new ApiException("not found");
        }
        user.setPassword(user.getPassword());


    }

    public void deleteUser(Integer id) {
        User user = authRepository.findUserById(id);
        if (user == null) {
            throw new ApiException("not found");
        }
        authRepository.delete(user);
    }


}