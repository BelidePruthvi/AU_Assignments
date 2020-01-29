package com.accolite.au.web.xmldemo.dao;

import com.accolite.au.web.xmldemo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    List<User> users;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public User getUser(@RequestParam int id)
    {
//        return users.stream().filter(user->user.getId()==id).findFirst().get();
          return jdbcTemplate.queryForObject("select * from user where id="+id,User.class);
    }

    @Override
    public User setandGetUserservice(User user)
    {
        return user;
    }

    @Override
    public void addUserService(User user) {
//        users.add(user);
            System.out.println("works");
          jdbcTemplate.update("insert into user values(?,?,?,?)",user.getFirstname(),user.getLastname(),user.getAge(),user.getPhonenumber());
    }

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query("select * from user",new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rownumber) throws SQLException {

                System.out.println("all works");
                User u=new User();
                u.setFirstname(rs.getString(1));
                u.setLastname(rs.getString(2));
                u.setAge(rs.getInt(3));
                u.setPhonenumber(rs.getString(4));
                return u;
            }
        });

    }

    @Override
    public void editUserService(int id) {

    }

    @Override
    @PostConstruct
    public void setUp()
    {
//        users=new ArrayList<User>();
//        User u=new User();
//        u.setAge(21);
//        u.setName("pruthvi");
//        u.setId(1);
//        users.add(u);
//        User u1=new User();
//        u1.setAge(20);
//        u1.setId(2);
//        u1.setName("test");
//        users.add(u1);
    }
}
