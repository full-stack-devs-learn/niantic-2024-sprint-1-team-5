package com.niantic.services;
import com.niantic.models.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
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

    public ArrayList<Transaction> getTransactions()
    {
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
                """;

        var row = jdbcTemplate.queryForRowSet(sql);

        while(row.next()){
            int transactionId = row.getInt("transaction_id");
            int ownerId = row.getInt("owner");
            int budgetId = row.getInt("budget_id");
            int vendorId = row.getInt("vendor_id");
            int subcategoryId = row.getInt("subcategory_id");
            double amount = row.getDouble("amount");
            LocalDate date = row.getDate("date").toLocalDate();
            String note = row.getString("note");

            Transaction transaction = new Transaction(transactionId, ownerId, budgetId, vendorId, subcategoryId,
                    amount, date, note);

            transactions.add(transaction);
        }
        return transactions;
    }

    public ArrayList<Transaction> getTransactionsByUser(int owner_id){
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
            int transactionId = row.getInt("transaction_id");
            int ownerId = row.getInt("owner");
            int budgetId = row.getInt("budget_id");
            int vendorId = row.getInt("vendor_id");
            int subcategoryId = row.getInt("subcategory_id");
            double amount = row.getDouble("amount");
            LocalDate date = row.getDate("date").toLocalDate();
            String note = row.getString("note");

            Transaction transaction = new Transaction(transactionId, ownerId, budgetId, vendorId, subcategoryId,
                    amount, date, note);

            transactions.add(transaction);
        }
        return transactions;
    }

    public ArrayList<Transaction> getTransactionsByMonth(int owner_id, int month_number)
    {   ArrayList<Transaction> transactions = new ArrayList<>();

        String sql = """
                SELECT *
                FROM transactions
                WHERE owner = ?
                AND MONTH(date) = ?
                """;

        var row = jdbcTemplate.queryForRowSet(sql, owner_id, month_number);

        while(row.next())
        {
            int transactionId = row.getInt("transaction_id");
            int ownerId = row.getInt("owner");
            int budgetId = row.getInt("budget_id");
            int vendorId = row.getInt("vendor_id");
            int subcategoryId = row.getInt("subcategory_id");
            double amount = row.getDouble("amount");
            LocalDate date = row.getDate("date").toLocalDate();
            String note = row.getString("note");

            Transaction transaction = new Transaction(transactionId, ownerId, budgetId, vendorId, subcategoryId, amount, date, note);

            transactions.add(transaction);
        }

       return transactions;
    }
    public ArrayList<Transaction> getTransactionsByYear(int owner_id, int year)
    {   ArrayList<Transaction> transactions = new ArrayList<>();

        String sql = """
                SELECT *
                FROM transactions
                WHERE owner = ?
                AND YEAR(date) = ?
                """;

        var row = jdbcTemplate.queryForRowSet(sql, owner_id, year);

        while(row.next())
        {
            int transactionId = row.getInt("transaction_id");
            int ownerId = row.getInt("owner");
            int budgetId = row.getInt("budget_id");
            int vendorId = row.getInt("vendor_id");
            int subcategoryId = row.getInt("subcategory_id");
            double amount = row.getDouble("amount");
            LocalDate date = row.getDate("date").toLocalDate();
            String note = row.getString("note");

            Transaction transaction = new Transaction(transactionId, ownerId, budgetId, vendorId, subcategoryId, amount, date, note);

            transactions.add(transaction);
        }

        return transactions;
    }
    public ArrayList<Transaction> getTransactionsByCategory(int owner_id, int categoryId)
    {
        ArrayList<Transaction> transactions = new ArrayList<>();

        String sql = """
                SELECT c.category_name
                , s.subcategory_name
                , t.*
                FROM transactions t
                JOIN subcategories s ON t.subcategory_id = s.subcategory_id
                JOIN categories c ON s.parent_id = c.category_id
                WHERE owner = ? AND category_id = ?
                ORDER BY t.date desc
                """;

        var row = jdbcTemplate.queryForRowSet(sql, owner_id, categoryId);

        while(row.next()){
            int transactionId = row.getInt("transaction_id");
            int ownerId = row.getInt("owner");
            int budgetId = row.getInt("budget_id");
            int vendorId = row.getInt("vendor_id");
            int subcategoryId = row.getInt("subcategory_id");
            double amount = row.getDouble("amount");
            LocalDate date = row.getDate("date").toLocalDate();
            String note = row.getString("note");

            Transaction transaction = new Transaction(transactionId, ownerId, budgetId, vendorId, subcategoryId, amount, date, note);

            transactions.add(transaction);
        }

        return transactions;
    }
    public Transaction getTransactionById(int transactionId)
    {
        String sql = """
                SELECT *
                FROM transactions
                WHERE transactionId = ?
                """;
        var row = jdbcTemplate.queryForRowSet(sql, transactionId);

        if(row.next()){
            transactionId = row.getInt("transaction_id");
            int ownerId = row.getInt("owner");
            int budgetId = row.getInt("budget_id");
            int vendorId = row.getInt("vendor_id");
            int subcategoryId = row.getInt("subcategory_id");
            double amount = row.getDouble("amount");
            LocalDate date = row.getDate("date").toLocalDate();
            String note = row.getString("note");

            Transaction transaction = new Transaction(transactionId, ownerId, budgetId, vendorId, subcategoryId, amount, date, note);

            return transaction;
        }
        return null;
    }

    public void addTransaction(Transaction transaction)
    {
        String sql = """
                INSERT INTO transactions
                (owner, vendor_id, subcategory_id, amount, date, note)
                VALUES (?, ?, ?, ?, ?, ?);
                """;

        jdbcTemplate.update(sql,
                    transaction.getOwnerId(),
                    transaction.getVendorId(),
                    transaction.getSubcategoryId(),
                    transaction.getAmount(),
                    transaction.getDate(),
                    transaction.getNote());
    }

    public void updateTransaction(Transaction transaction)
    {
        String sql = """
                UPDATE transactions
                SET owner = ?
                    , budget_id = ?
                    , vendor_id = ?
                    , subcategory_id = ?
                    , amount = ?
                    , date = ?
                    , note = ?
                WHERE transaction_id = ?;
                """;

        jdbcTemplate.update(sql,
                    transaction.getOwnerId(),
                    transaction.getBudgetId(),
                    transaction.getVendorId(),
                    transaction.getSubcategoryId(),
                    transaction.getAmount(),
                    transaction.getDate(),
                    transaction.getNote());
    }

    public void deleteTransaction(int transaction)
    {
        String sql = "DELETE FROM transactions WHERE transaction_id = ?";

        jdbcTemplate.update(sql, transaction);
    }

}
