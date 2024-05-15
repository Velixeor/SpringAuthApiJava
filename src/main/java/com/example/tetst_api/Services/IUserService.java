package com.example.tetst_api.Services;

import com.example.tetst_api.Exeptions.EtAuthExeption;
import com.example.tetst_api.Models.UserModel;

public interface IUserService {

    UserModel ValidateUser(String email,String password)throws EtAuthExeption;
    UserModel RegisterUser(String first_name, String last_name, String middle_name, String title, String login, String number_phone, Boolean is_admin, String mail, String password, Integer cabinet_id, Integer user_status_id,Integer role_id )throws EtAuthExeption;

}
