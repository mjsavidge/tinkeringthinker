package com.infosys.thecookbook.controller;

import com.infosys.thecookbook.model.LoginModel;
import com.infosys.thecookbook.model.UserModel;
import com.infosys.thecookbook.repo.UserRepo;
import com.infosys.thecookbook.service.ResetPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin (origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ResetPassword resetPassword;



    @PostMapping("signup")
    public UserModel signup(@RequestBody UserModel userModel){
        return userRepo.save(userModel);
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginModel loginModel){
        UserModel userModel = userRepo.findByEmail(loginModel.getEmail());
        if(userModel != null){
            System.out.println(userModel.getEmail());
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("resetpwd")
    public ResponseEntity<String> resetPwd(@RequestBody LoginModel loginModel){
        resetPassword.reset(loginModel.getEmail());
        System.out.println(loginModel.getEmail());
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
