package com.example.blogsystem1.Service;

import com.example.blogsystem1.API.ApiException;
import com.example.blogsystem1.Model.User;
import com.example.blogsystem1.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = authRepository.findUserByUserName(username);

        if (user == null) {
            throw new ApiException("NOT found");
        }
        return  user;
    }
}
