package com.example.tetst_api.Services;

import com.example.tetst_api.Exeptions.EtAuthExeption;
import com.example.tetst_api.Models.UserModel;
import com.example.tetst_api.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServise implements IUserService{

    @Autowired
    UserRepository userrepisitory;
    @Override
    public UserModel ValidateUser(String mail, String password) throws EtAuthExeption {
        return userrepisitory.FindUserByEmailAndPassword(mail,password);
    }

    @Override
    public UserModel RegisterUser(String first_name, String last_name, String middle_name, String title, String login, String number_phone, Boolean is_admin, String mail, String password, Integer cabinet_id, Integer user_status_id,Integer role_id) throws EtAuthExeption {
        Integer id;
        if(userrepisitory.FindByMailPhoneLogin(mail,number_phone,login)){
            id=userrepisitory.Create(first_name,last_name,middle_name,title,login,number_phone,is_admin,mail,password,cabinet_id,user_status_id,role_id);
       }else{
           throw new EtAuthExeption("Email already in use");
        }
        return userrepisitory.FindById(id);

    }
}
