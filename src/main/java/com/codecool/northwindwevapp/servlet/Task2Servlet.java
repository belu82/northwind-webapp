package com.codecool.northwindwevapp.servlet;

import com.codecool.northwindwevapp.dao.Database.DbTaskDao;
import com.codecool.northwindwevapp.dao.TaskDao;
import com.codecool.northwindwevapp.model.Task2;
import com.codecool.northwindwevapp.service.TaskFilterService;
import com.codecool.northwindwevapp.service.TaskService;
import com.codecool.northwindwevapp.service.exception.ServiceException;
import com.codecool.northwindwevapp.service.simple.SimpleTaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/Task2"})
public class Task2Servlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName;
        Integer products;
        String param1 = request.getParameter("text");
        String param2 = request.getParameter("dropdown");

        if(param2.equals("productName")){
            products = 0;
            productName = param1;
        }else if(param2.equals("products")){
            try {
                products = Integer.valueOf(param1);

            }catch (NumberFormatException e){
                products = 0;
            }
            productName = "";
        }else {
            productName = "";
            products = 0;
        }

        response.setContentType("text/html;charset=UTF-8");
        try(Connection connection = getConnection(request.getServletContext())){
            DbTaskDao dbTaskDao = new DbTaskDao(connection);
            TaskService taskService = new SimpleTaskService(dbTaskDao);
            List<Task2> task2List = taskService.Task2Service();
            TaskFilterService taskFilterService = new TaskFilterService();
            List<Task2> task2s = taskFilterService.Task2Filter(task2List, productName, products);
            request.setAttribute("task2", task2s);
            request.getRequestDispatcher("Task2.jsp").forward(request, response);
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
            List<Task2> task2List = taskService.Task2Service();
            request.setAttribute("task2", task2List);
            request.getRequestDispatcher("Task2.jsp").forward(request, response);
        } catch (SQLException | ServiceException e) {
            e.printStackTrace();
        }
    }
}
