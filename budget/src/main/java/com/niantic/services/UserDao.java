package com.niantic.services;

import com.niantic.models.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public UserDao()
    {
        String databaseUrl = "jdbc:mysql://localhost:3306/financial";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource(){{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<User> getAllUsers()
    {
        ArrayList<User> users = new ArrayList<>();

        String sql = """
                SELECT *
                FROM users
                """;

        var row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            int user_id = row.getInt("user_id");
            String first_name = row.getString("first_name");
            String last_name = row.getString("last_name");
            String full_name = row.getString("full_name");

            User user = new User(user_id, first_name, last_name, full_name);

            users.add(user);
        }
        return users;
    }

    public User getUserById(int userId){

        String sql = """
                SELECT *
                FROM users
                WHERE user_id = ?
                """;

        var row = jdbcTemplate.queryForRowSet(sql, userId);

        if (row.next())
        {
            int user_id = row.getInt("user_id");
            String first_name = row.getString("first_name");
            String last_name = row.getString("last_name");
            String full_name = row.getString("full_name");

            User user = new User(user_id, first_name, last_name, full_name);
            return user;
        }
        return null;
    }
    public User getUserByName(String fullName){

        String sql = """
                SELECT *
                FROM users
                WHERE full_name = ?
                """;

        var row = jdbcTemplate.queryForRowSet(sql, fullName);

        if (row.next())
        {
            int user_id = row.getInt("user_id");
            String first_name = row.getString("first_name");
            String last_name = row.getString("last_name");
            String full_name = row.getString("full_name");

            User user = new User(user_id, first_name, last_name, full_name);
            return user;
        }
        return null;
    }
}
