package com.codecool.northwindwevapp.service.simple;

import com.codecool.northwindwevapp.dao.TaskDao;
import com.codecool.northwindwevapp.model.Task1;
import com.codecool.northwindwevapp.model.Task2;
import com.codecool.northwindwevapp.model.Task3;
import com.codecool.northwindwevapp.service.TaskService;
import com.codecool.northwindwevapp.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public final class SimpleTaskService implements TaskService {
    private  final TaskDao taskDao;

    public SimpleTaskService(TaskDao taskDao) {

        this.taskDao = taskDao;
    }

    @Override
    public List<Task1> Task1Service() throws ServiceException {
        try{
            return taskDao.getTaks1();
        }catch (SQLException e){
            throw new ServiceException(e.getMessage());
        }
    }

    public List<Task2> Task2Service() throws ServiceException{
        try{
            return taskDao.getTask2();
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public List<Task3> Task3Service() throws ServiceException{
        try {
            return taskDao.getTask3();
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
