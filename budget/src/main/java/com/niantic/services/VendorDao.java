package com.niantic.services;

import com.niantic.models.User;
import com.niantic.models.Vendor;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;

public class VendorDao {
    private JdbcTemplate jdbcTemplate;

    public VendorDao()
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

    public ArrayList<Vendor> getAllVendors()
    {
        ArrayList<Vendor> vendors = new ArrayList<>();

        String sql = """
                SELECT *
                FROM vendors
                """;

        var row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            int vendorId = row.getInt("vendor_id");
            String vendorName = row.getString("vendor_name");

            Vendor vendor = new Vendor(vendorId, vendorName);

            vendors.add(vendor);
        }

        return vendors;
    }

    public Vendor getVendorById(int id)
    {
        String sql = """
                SELECT *
                FROM vendors
                WHERE vendor_id = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, id);

        if(row.next())
        {
            int vendorId = row.getInt("vendor_id");
            String vendorName = row.getString("vendor_name");

            Vendor vendor = new Vendor(vendorId, vendorName);

            return vendor;
        }

        return null;
    }

    public Vendor getVendorByName(String name)
    {
        String sql = """
                SELECT *
                FROM vendors
                WHERE vendor_name = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, name);

        if(row.next())
        {
            int vendorId = row.getInt("vendor_id");
            String vendorName = row.getString("vendor_name");

            Vendor vendor = new Vendor(vendorId, vendorName);

            return vendor;
        }

        return null;
    }
}
