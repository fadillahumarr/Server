package com.example.layanankonsultasikesehatan.services.user_management.services;

import com.example.layanankonsultasikesehatan.services.user_management.models.User;
import com.example.layanankonsultasikesehatan.services.user_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public int registerNewUserServiceMethod(String nama_lengkap, String jenis_kelamin, String tanggal_lahir, String alamat, String nomor_hp, String email, String kata_sandi){
        return userRepository.registerNewUser(nama_lengkap, jenis_kelamin, tanggal_lahir, alamat, nomor_hp, email, kata_sandi);
    }
    public List<String> checkUserEmail(String email){
        return userRepository.checkUserEmail(email);
    }

    public String checkUserPasswordByEmail(String email){
        return userRepository.checkUserPasswordByEmail(email);
    }

    public User getUserDetailsByEmail(String email){
        return  userRepository.getUserDetailsByEmail(email);
    }

}
