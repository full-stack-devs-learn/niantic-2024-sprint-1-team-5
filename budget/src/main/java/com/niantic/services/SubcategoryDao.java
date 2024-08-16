package com.niantic.services;

import com.niantic.models.Subcategory;
import com.niantic.models.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;

public class SubcategoryDao {
    private JdbcTemplate jdbcTemplate;

    public SubcategoryDao()
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

    public ArrayList<Subcategory> getAllSubcategories()
    {
        ArrayList<Subcategory> subcategories = new ArrayList<>();

        String sql = """
                SELECT *
                FROM subcategories;
                """;

        var row = jdbcTemplate.queryForRowSet(sql);

        while (row.next()){
            int subcategoryId = row.getInt("subcategory_id");
            String subcategoryName = row.getString("subcategory_name");
            int subcategoryOwner = row.getInt("subcategory_owner");
            int parentId = row.getInt("parent_id");

            Subcategory subcategory = new Subcategory(subcategoryId, subcategoryName, subcategoryOwner, parentId);

            subcategories.add(subcategory);
        }

        return subcategories;
    }

    public Subcategory getSubcategoryById(int id)
    {
        String sql = """
                SELECT *
                FROM subcategories
                WHERE subcategory_id = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, id);

        if(row.next()){
            int subcategoryId = row.getInt("subcategory_id");
            String subcategoryName = row.getString("subcategory_name");
            int subcategoryOwner = row.getInt("subcategory_owner");
            int parentId = row.getInt("parent_id");

            Subcategory subcategory = new Subcategory(subcategoryId, subcategoryName, subcategoryOwner, parentId);

            return subcategory;
        }

        return null;
    }

    public Subcategory getSubcategoryByName(String name)
    {
        String sql = """
                SELECT *
                FROM subcategories
                WHERE subcategory_name = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, name);

        if(row.next()){
            int subcategoryId = row.getInt("subcategory_id");
            String subcategoryName = row.getString("subcategory_name");
            int subcategoryOwner = row.getInt("subcategory_owner");
            int parentId = row.getInt("parent_id");

            Subcategory subcategory = new Subcategory(subcategoryId, subcategoryName, subcategoryOwner, parentId);

            return subcategory;
        }

        return null;
    }
}
