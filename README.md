# HW 18 - JDBC

## Task: 
Разобраться с JDBC. Синтаксис SQL. Умень выполнять запросы на вставку,
удаление, редактирование и получение данных. В ваших проектах сделать
сохранение и получение данных из базы данных.


## SQL:
    CREATE TABLE employee (
        client_id INT PRIMARY KEY AUTO_INCREMENT, 
        name VARCHAR(50) NOT NULL, 
        salary INT NOT NULL, 
        department_id INT, 
        FOREIGN KEY (department_id)  REFERENCES department (department_id) 
    );

    CREATE TABLE department (
        department_id INT PRIMARY KEY AUTO_INCREMENT, 
        department_name VARCHAR(50)
    );

    INSERT INTO department
    VALUES 
    (1, 'IBS'), 
    (2, 'AD');

    INSERT INTO employee
    VALUES 
    (1, 'Ivan', 1000, 1), 
    (2, 'Stepan', 1050, 2),
    (3, 'Mark', 500, null),
    (4, 'John', 500, null),
    (5, 'Bear', 500, null),
    (6, 'Stephan', 50, 2),
    (7, 'Stiven', 300, 2);
