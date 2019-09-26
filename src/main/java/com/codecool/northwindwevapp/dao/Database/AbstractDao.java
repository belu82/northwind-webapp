package com.codecool.northwindwevapp.dao.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractDao {

    final Connection connection;


    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    void executeInsert(PreparedStatement preparedStatement) throws SQLException{
        int insertCount = preparedStatement.executeUpdate();
        if(insertCount !=1){
            connection.rollback();
            throw new SQLException("valami nem jó????");
        }
    }

    int fetchGenerate(PreparedStatement preparedStatement) throws SQLException{
        int id;
        try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){
            if(resultSet.next()){
                id = resultSet.getInt(1);
            }else {
                connection.rollback();
                throw new SQLException("valami megint");
            }
        }
        connection.rollback();
        return id;
    }
}
