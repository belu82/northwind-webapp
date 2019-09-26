package com.codecool.northwindwevapp.servlet;

import com.codecool.northwindwevapp.dao.Database.DbTaskDao;
import com.codecool.northwindwevapp.dao.TaskDao;
import com.codecool.northwindwevapp.model.Task3;
import com.codecool.northwindwevapp.service.TaskFilterService;
import com.codecool.northwindwevapp.service.TaskService;
import com.codecool.northwindwevapp.service.exception.ServiceException;
import com.codecool.northwindwevapp.service.simple.SimpleTaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/Task3")
public class Task3Servlet extends AbstractServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String company = request.getParameter("text");

        response.setContentType("text/html;charset=UTF-8");
        try(Connection connection = getConnection(request.getServletContext())){
            DbTaskDao dbTaskDao = new DbTaskDao(connection);
            SimpleTaskService simpleTaskService = new SimpleTaskService(dbTaskDao);
            List<Task3> task3List = simpleTaskService.Task3Service();

            request.setAttribute("task3", task3List);
            request.getRequestDispatcher("Task3.jsp").forward(request,response);
        } catch (SQLException | ServiceException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(Connection connection = getConnection(request.getServletContext())){
            TaskDao taskDao = new DbTaskDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            List<Task3> task3List = taskService.Task3Service();
            request.setAttribute("task3", task3List);
            request.getRequestDispatcher("Task3.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
