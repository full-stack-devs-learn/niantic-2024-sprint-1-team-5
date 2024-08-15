package com.niantic.services;
import com.niantic.models.Category;
import com.niantic.models.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class CategoriesDao {

    private JdbcTemplate jdbcTemplate;

    public CategoriesDao()
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

    public ArrayList<Category> getCategories()
    {
        ArrayList<Category> categories = new ArrayList<>();

        String sql = "SELECT * FROM categories";

        var row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            int categoryId = row.getInt("category_id");
            String categoryName = row.getString("category_name");
            int categoryOwner = row.getInt("category_owner");

            Category category = new Category(categoryId, categoryName, categoryOwner);

            categories.add(category);
        }

        return categories;
    }

    public Category getCategoryByName(String name) {
        Category category = null;

        String sql = """
                SELECT *
                FROM categories
                WHERE category_name = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, name);

        if (row.next()) {
            int categoryId = row.getInt("category_id");
            String categoryName = row.getString("category_name");
            int categoryOwner = row.getInt("category_owner");

            category = new Category(categoryId, categoryName, categoryOwner);
        }

        return category;
    }
    public void addCategory(Category category)
    {
        String sql = """
                INSERT INTO categories
                (category_name, category_owner)
                VALUES (?, ?)
                """;
        jdbcTemplate.update(sql, category.getCategoryName(), category.getCategoryOwner());
    }
    public void editCategory(Category category)
    {
        String sql = """
                UPDATE categories
                SET (category_name = ?)
                WHERE category_id = ?
                """;
        jdbcTemplate.update(sql, category.getCategoryName(), category.getCategoryId());
    }
    public void deleteCategory(Category category)
    {
        String sql = """
                DELETE categories
                WHERE category_id = ?
                """;
        jdbcTemplate.update(sql, category.getCategoryId());
    }

}
