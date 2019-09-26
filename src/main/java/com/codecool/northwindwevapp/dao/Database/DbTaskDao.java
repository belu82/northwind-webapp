package com.codecool.northwindwevapp.dao.Database;

import com.codecool.northwindwevapp.dao.TaskDao;
import com.codecool.northwindwevapp.model.Task1;
import com.codecool.northwindwevapp.model.Task2;
import com.codecool.northwindwevapp.model.Task3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbTaskDao extends AbstractDao implements TaskDao {
    public DbTaskDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task1> getTaks1() throws SQLException {
        String sql = "SELECT product_name, company_name from suppliers join products \n" +
                "on products.supplier_id = suppliers.supplier_id order by product_name,company_name asc";
        List<Task1> task1s = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    String product_name = resultSet.getString("product_name");
                    String company_name = resultSet.getString("company_name");
                    Task1 task1 = new Task1(product_name, company_name);
                    task1s.add(task1);
                }
            }
        }
        return task1s;
    }

    public List<Task2> getTask2() throws SQLException{
        List<Task2> taks2List = new ArrayList<>();
        String sql = "SELECT company_name, count(products.product_name) as products FROM suppliers join products\n" +
                "on suppliers.supplier_id = products.supplier_id group by company_name order by products desc";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    String product = resultSet.getString("company_name");
                    int products = resultSet.getInt("products");
                    Task2 task2 = new Task2(product, products);
                    taks2List.add(task2);
                }
            }
        }
        return taks2List;
    }

    public List<Task3> getTask3() throws SQLException{
        List<Task3> task3List = new ArrayList<>();
        String sql = "select company_name as company\n" +
                "from suppliers\n" +
                "join products\n" +
                "\ton suppliers.supplier_id = products.supplier_id\n" +
                "\tgroup by suppliers.company_name\n" +
                "\thaving count(products.product_name) > 4\n" +
                "\torder by company_name asc";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    String company = resultSet.getString("company");
                    Task3 task3 = new Task3(company);
                    task3List.add(task3);
                }
            }
        }
        return task3List;
    }


    private Task1 fetchTask1(ResultSet resultSet) throws SQLException {
        String product_name = resultSet.getString("product_name");
        String company_name = resultSet.getString("company_name");
        return new Task1(product_name, company_name);
    }
}
