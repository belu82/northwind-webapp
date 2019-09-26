package com.codecool.northwindwevapp.dao;

import com.codecool.northwindwevapp.model.Task1;
import com.codecool.northwindwevapp.model.Task2;
import com.codecool.northwindwevapp.model.Task3;

import java.sql.SQLException;
import java.util.List;

public interface TaskDao {
    List<Task1> getTaks1() throws SQLException;
    List<Task2> getTask2() throws  SQLException;
    List<Task3> getTask3() throws SQLException;
}
