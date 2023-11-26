package com.example.layanankonsultasikesehatan.services.user_management.rest_controllers;

import com.example.layanankonsultasikesehatan.services.user_management.models.Login;
import com.example.layanankonsultasikesehatan.services.user_management.models.User;
import com.example.layanankonsultasikesehatan.services.user_management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LoginApiController {

    @Autowired
    UserService userService;
    @PostMapping("/user/login")
    public ResponseEntity authenticateUser(@RequestBody Login login){

        //Get User Email
        List<String> userEmail = userService.checkUserEmail(login.getEmail());
        if(userEmail.isEmpty() || userEmail == null){
            return new ResponseEntity("Email tidak ada", HttpStatus.NOT_FOUND);
        }

        String hashed_password = userService.checkUserPasswordByEmail(login.getEmail());

        if(!BCrypt.checkpw(login.getKata_sandi(), hashed_password)){
            return  new ResponseEntity("Email dan kata sandi salah", HttpStatus.BAD_REQUEST);
        }

        User user = userService.getUserDetailsByEmail(login.getEmail());
        return new ResponseEntity(user, HttpStatus.OK);
    }

}
