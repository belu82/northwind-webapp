package com.codecool.northwindwevapp.service;

import com.codecool.northwindwevapp.model.Task1;
import com.codecool.northwindwevapp.model.Task2;
import com.codecool.northwindwevapp.model.Task3;
import com.codecool.northwindwevapp.service.exception.ServiceException;

import javax.servlet.ServletException;
import java.sql.SQLException;
import java.util.List;

public interface TaskService {
    List<Task1> Task1Service() throws SQLException, ServiceException;
    List<Task2> Task2Service() throws SQLException, ServiceException;
    List<Task3> Task3Service() throws SQLException, ServiceException;

}
