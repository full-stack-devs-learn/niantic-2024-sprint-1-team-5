# Sprint 1 - Mini Capstone - Budget Tracker

This capstone project is a web version of the budget tracker that you created in your DAO review project.

You will work in teams to create a web application to track your expenses. 

## Requirements

Your project must meet the following requirements:

* The website must follow the MVC pattern
* Create controllers for each table in the `budget` database
* Create a DTO model for each table in the `budget` database
* Create a DAO for each table in the `budget` database
* Use the Thymeleaf view engine to create view templates and pages for the budget app

## Starting Your Project

As a team take time to plan your website. 

* Map out a list of the requirements for your budget tracking website.
* Sort your list or requirements in order of priority.
* Complete the requirements one page at a time beginning with the highest 
  priority requirements first


You will most likely not have time to complete all of the pages in your list
of requirements. Be realistic in your expectations, and work to complete the tasks
that will give you an overall functioning website. This means that not all aspects 
of each section will be fully complete. 

Ensure that users can add transactions. Then you can focus on other functionality. 
For example, you need to allow the user to add new  users, categories, or vendors. 

**NOTE:** initially you do not need the ability to edit or delete categories, or users, 
you just need the ability to add them, so that you canselect them when adding a new transaction.

## Project Planning

You will use [Trello](https://www.trello.com) to manage your tasks. Use the Kanban board to create tasks
and move them from `backlog` through to `done`.

![Trello Board](./images/trello.png)


## Database

The database script and design that is included with this project has been simplified 
a little bit to include just a transaction category, without a sub-category.

You may use the database script provided, or you can use one that you created in an earlier
exercise.

![ER Diagram](./images/database.png)

## Models - Data Transfer Objects

The DTOs associated with the database design would follow this design.
![DTOs](./images/dtos.png)


## DAOs (Data Access Objects)

The DAOs with the database could include the following design.
![DAOs](./images/daos.png)

## Screens

Below are a few screen designs that you might consider when creating your website. 
You are not required to use these designs, they are just some designs to help spark some 
ideas.

### Transactions List
![Transactions List](./images/screen_transaction_list.png)

### Add Transaction
![Add Transaction](./images/screen_transaction_add.png)

### Reports List
![Reports List](./images/screen_reports.png)

### User List
![User List](./images/screen_user_list.png)

### Add User
![Add User](./images/screen_user_add.png)

### Other Website Design Options

You may want to search for other website design, such as admin templates at [TemplateMonster.com](https://www.templatemonster.com/website-templates.php?text=admin) or at [StartBootstrap.com](https://startbootstrap.com/themes/admin-dashboard).
