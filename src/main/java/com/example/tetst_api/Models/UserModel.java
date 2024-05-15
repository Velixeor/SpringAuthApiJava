package com.example.tetst_api.Models;

import java.sql.Timestamp;
import java.util.TimeZone;

public class UserModel {
  Integer Id;
  String first_name;
  String last_name;
  String middle_name;
  String title;
  String login;
  String number_phone;
  Boolean is_admin;
  Boolean is_deleted;
  String mail;
  String password;
  Integer cabinet_id;
  Integer user_status_id;
  Timestamp date_created;

    public UserModel(Integer id, String first_name, String last_name, String middle_name, String title, String login, String number_phone, Boolean is_admin, Boolean is_deleted, String mail, String password, Integer cabinet_id, Integer user_status_id, Timestamp date_created, Timestamp date_deleted) {
        Id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.title = title;
        this.login = login;
        this.number_phone = number_phone;
        this.is_admin = is_admin;
        this.is_deleted = is_deleted;
        this.mail = mail;
        this.password = password;
        this.cabinet_id = cabinet_id;
        this.user_status_id = user_status_id;
        this.date_created = date_created;
        this.date_deleted = date_deleted;
    }

    Timestamp date_deleted;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNumber_phone() {
        return number_phone;
    }

    public void setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCabinet_id() {
        return cabinet_id;
    }

    public void setCabinet_id(Integer cabinet_id) {
        this.cabinet_id = cabinet_id;
    }

    public Integer getUser_status_id() {
        return user_status_id;
    }

    public void setUser_status_id(Integer user_status_id) {
        this.user_status_id = user_status_id;
    }

    public Timestamp getDate_created() {
        return date_created;
    }

    public void setDate_created(Timestamp date_created) {
        this.date_created = date_created;
    }

    public Timestamp getDate_deleted() {
        return date_deleted;
    }

    public void setDate_deleted(Timestamp date_deleted) {
        this.date_deleted = date_deleted;
    }

}
