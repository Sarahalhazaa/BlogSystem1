package com.example.blogsystem1.Repository;

import com.example.blogsystem1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User,Integer> {
    User findUserByUserName(String userName);
    User findUserById(Integer id);
}