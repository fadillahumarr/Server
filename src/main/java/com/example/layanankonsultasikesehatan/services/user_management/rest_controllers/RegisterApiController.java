package com.example.layanankonsultasikesehatan.services.user_management.rest_controllers;

import com.example.layanankonsultasikesehatan.services.user_management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/api/v1")
public class RegisterApiController {

    @Autowired
    UserService userServices;

    @PostMapping("/user/signup")
    public ResponseEntity registerNewUser(@RequestParam("nama_lengkap")String nama_lengkap,
                                          @RequestParam("jenis_kelamin")String jenis_kelamin,
                                          @RequestParam("tanggal_lahir")String tanggal_lahir,
                                          @RequestParam ("alamat") String alamat,
                                          @RequestParam("nomor_hp")String nomor_hp,
                                          @RequestParam("email")String email,
                                          @RequestParam("kata_sandi")String kata_sandi)
    {
        if(nama_lengkap.isEmpty() || jenis_kelamin.isEmpty() || tanggal_lahir.isEmpty() || alamat.isEmpty() || nomor_hp.isEmpty() || email.isEmpty() || kata_sandi.isEmpty()){
            return new ResponseEntity<>("Belum Terisi", HttpStatus.BAD_REQUEST);
        }

        //Encrypt / Hash Password:
        String hash_password = BCrypt.hashpw(kata_sandi, BCrypt.gensalt());

        //Register New User:
        int result = userServices.registerNewUserServiceMethod(nama_lengkap, jenis_kelamin,tanggal_lahir,alamat,nomor_hp, email, hash_password);
        if(result != 1){
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
