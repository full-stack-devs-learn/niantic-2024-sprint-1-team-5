package com.niantic.services;
import com.niantic.models.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionDao {
    private JdbcTemplate jdbcTemplate;

    public TransactionDao()
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

    public ArrayList<Transaction> getTransactionByUser(int owner_id){
        ArrayList<Transaction> transactions = new ArrayList<>();

        String sql = """
                SELECT transaction_id
                    , owner
                    , budget_id
                    , vendor_id
                    , subcategory_id
                    , amount
                    , date
                    , note
                FROM transactions
                WHERE owner = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, owner_id);

        while(row.next()){
            int transaction_id = row.getInt("transaction_id");
            owner_id = row.getInt("owner");
            int budget_id = row.getInt("budget_id");
            int vendor_id = row.getInt("vendor_id");
            int subcategory_id = row.getInt("subcategory_id");
            double amount = row.getDouble("amount");
            LocalDate date = row.getDate("date").toLocalDate();
            String note = row.getString("note");

            Transaction transaction = new Transaction(transaction_id, owner_id, budget_id, vendor_id, subcategory_id,
                    amount, date, note);

            transactions.add(transaction);
        }
        return transactions;
    }

    
}
