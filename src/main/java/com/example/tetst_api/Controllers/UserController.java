package com.example.tetst_api.Controllers;


import com.example.tetst_api.Constants;
import com.example.tetst_api.Models.UserModel;
import com.example.tetst_api.Services.UserServise;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
@Autowired
    UserServise us;
    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> LoginUser(@RequestBody Map<String, Object> userMap){
        String mail = (String) userMap.get("mail");
        String password = (String) userMap.get("password");
        UserModel user=us.ValidateUser(mail,password);


        return new ResponseEntity<>( generateJWTToken(user), HttpStatus.OK) ;

    }
    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> RegisterUser(@RequestBody Map<String, Object> userMap) {
        String first_name = (String) userMap.get("first_name");
        String last_name = (String) userMap.get("last_name");
        String middle_name = (String) userMap.get("middle_name");
        String title = (String) userMap.get("title");
        String login = (String) userMap.get("login");
        String number_phone = (String) userMap.get("number_phone");
        Boolean is_admin = (Boolean) userMap.get("is_admin");
        String mail = (String) userMap.get("mail");
        String password = (String) userMap.get("password");
        Integer cabinet_id = (Integer) userMap.get("cabinet_id");
        Integer user_status_id = (Integer) userMap.get("user_status_id");
        Integer role_id = (Integer) userMap.get("role_id");
        Map<String,Object> map=new HashMap<>();
        UserModel user= us.RegisterUser(first_name, last_name, middle_name, title, login, number_phone, is_admin, mail, password, cabinet_id, user_status_id, role_id);
        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK) ;
    }

    private Map<String,String> generateJWTToken(UserModel user){
        long timestamp=System.currentTimeMillis();
        String token= Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp+Constants.TOKEN_VALIDITY))
                .claim("Id",user.getId())
                .claim("first_name", user.getFirst_name())
                .claim("last_name", user.getLast_name())
                .claim("middle_name", user.getMiddle_name())
                .claim("title", user.getTitle())
                .claim("login", user.getLogin())
                .claim("number_phone", user.getNumber_phone())
                .claim("is_admin", user.getIs_admin())
                .claim("is_deleted", user.getIs_deleted())
                .claim("mail", user.getMail())
                .claim("cabinet_id", user.getCabinet_id())
                .claim("user_status_id", user.getUser_status_id())
                .claim("date_created", user.getDate_created())
                .claim("date_deleted", user.getDate_deleted())
                .compact();
                Map<String,String> map=new HashMap<>();
                map.put("token",token);
                return map;

    }





}
