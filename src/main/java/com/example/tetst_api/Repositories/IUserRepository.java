package com.example.tetst_api.Repositories;


import com.example.tetst_api.Exeptions.EtAuthExeption;
import com.example.tetst_api.Models.UserModel;

public interface IUserRepository {


    public  Integer Create(String first_name, String last_name, String middle_name, String title, String login, String number_phone, Boolean is_admin, String mail, String password, Integer cabinet_id, Integer user_status_id,Integer role_id ) throws EtAuthExeption;

    public UserModel FindUserByEmailAndPassword(String email,String password) throws EtAuthExeption;
    public UserModel FindById(Integer Id);
    public boolean FindByMailPhoneLogin(String mail, String phone_number, String login);
}
