package com.example.tetst_api.Repositories;

import com.example.tetst_api.Exeptions.EtAuthExeption;
import com.example.tetst_api.Models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Repository
public class UserRepository implements IUserRepository{
    private static final String SQL_CREATE="SELECT * FROM authjava.user__add(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_REPEAT_CHECK="SELECT * FROM authjava.user__check(?,?,?)";
    private static final String SQL_FIND_BY_ID="SELECT * FROM authjava.user__find_by_id(?)";
    private static final String SQL_FIND_BY_MAIL_AND_PASSWORD="SELECT * FROM authjava.user__find_by_mail_and_password(?,?)";
    private RowMapper<UserModel> userModelRowMapper=((rs, rowNum) -> {
        return  new UserModel(rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("middle_name"),
                rs.getString("last_name"),
                rs.getString("title"),
                rs.getString("login"),
                rs.getString("number_phone"),
                rs.getBoolean("is_admin"),
                rs.getBoolean("is_delete"),
                rs.getString("mail"),
                rs.getString("password"),
                rs.getInt("cabinet_id"),
                rs.getInt("user_status_id"),
                rs.getTimestamp("date_create"),
                rs.getTimestamp("date_delete"));
    });

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Integer Create(String first_name, String last_name, String middle_name, String title, String login, String number_phone, Boolean is_admin, String mail, String password, Integer cabinet_id, Integer user_status_id,Integer role_id) throws EtAuthExeption {
        try {
        ZonedDateTime now = ZonedDateTime.now();
        Timestamp timestamp = Timestamp.from(now.toInstant());

        Integer newId = jdbcTemplate.queryForObject(SQL_CREATE, new Object[] {title, login, password, first_name, middle_name, last_name, mail, number_phone, is_admin, timestamp, cabinet_id, user_status_id, role_id}, Integer.class);

        return newId;
        }catch (Exception e) {
            throw new EtAuthExeption("Invalid details. Failed to create.");
        }




    }

    @Override
    public UserModel FindUserByEmailAndPassword(String mail, String password) throws EtAuthExeption {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_MAIL_AND_PASSWORD, new Object[] {mail, password}, userModelRowMapper);
    }

    @Override
    public UserModel FindById(Integer id) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[] {id}, userModelRowMapper);
    }

    @Override
    public boolean FindByMailPhoneLogin(String mail, String phone_number, String login) {
        return jdbcTemplate.queryForObject(SQL_REPEAT_CHECK, new Object[]{mail, phone_number, login}, Boolean.class);

    }
}
