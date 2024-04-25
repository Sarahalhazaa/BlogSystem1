package com.example.blogsystem1.Controller;

import com.example.blogsystem1.API.ApiResponse;
import com.example.blogsystem1.Model.User;
import com.example.blogsystem1.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/auth")
@RequiredArgsConstructor
public class AuthController {
    Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(String username, String password){
        logger.info("login user");
        return ResponseEntity.ok().body(" ");
    }


    @PostMapping("/register")
    public ResponseEntity  register(@RequestBody @Valid User user){
        logger.info("register user");
        authService.register(user);
        return ResponseEntity.ok().body("user add");
    }

    @PutMapping("/Update/{userName}")
    public ResponseEntity UpdateUser(@PathVariable String userName, @RequestBody @Valid User user){
        logger.info("Update User");
        authService.updateUser(userName,user);
        return ResponseEntity.ok().body(new ApiResponse("User Update"));

    }

    @PostMapping("/logOut")
    public ResponseEntity  logOut(){
        logger.info("logOut user");
        return ResponseEntity.ok().body(" ");
    }

    @GetMapping("/get")
    public ResponseEntity getUser(){
        logger.info("get all User");
        return ResponseEntity.status(200).body(authService.getUser());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        logger.info("delete User");
        authService.deleteUser(id);
        return ResponseEntity.ok().body(new ApiResponse("User Deleted"));

    }

}