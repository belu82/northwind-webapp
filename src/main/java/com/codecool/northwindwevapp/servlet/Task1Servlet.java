package com.codecool.northwindwevapp.servlet;

import com.codecool.northwindwevapp.dao.Database.DbTaskDao;
import com.codecool.northwindwevapp.dao.TaskDao;
import com.codecool.northwindwevapp.model.Task1;
import com.codecool.northwindwevapp.service.TaskService;
import com.codecool.northwindwevapp.service.TaskFilterService;
import com.codecool.northwindwevapp.service.exception.ServiceException;
import com.codecool.northwindwevapp.service.simple.SimpleTaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/Task1"})
public class Task1Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        try(Connection connection = getConnection(request.getServletContext())) {
            TaskDao taskDao = new DbTaskDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);

            List<Task1> task1List = taskService.Task1Service();
            request.setAttribute("task1", task1List);
            request.getRequestDispatcher("Task1.jsp").forward(request, response);
        } catch (SQLException | ServiceException e) {
            throw new ServletException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String company;
        String product;

        String param = request.getParameter("text");
        String param1 = request.getParameter("dropdown");

        if(param1.equals("product")){
            company = "";
            product = param;
        }else if(param1.equals("company")){
            product = "";
            company = param;
        }else {
            product = "";
            company = "";
        }
        response.setContentType("text/html;charset=UTF-8");

        try(Connection connection = getConnection(request.getServletContext())) {
            DbTaskDao dbTaskDao = new DbTaskDao(connection);
            TaskService taskService = new SimpleTaskService(dbTaskDao);
            List<Task1> task1s = taskService.Task1Service();
            TaskFilterService taskFilterService =  new TaskFilterService();
            List<Task1> filteredTask = taskFilterService.Task1Filter(task1s, product, company);
            request.setAttribute("task1", filteredTask);
            request.getRequestDispatcher("Task1.jsp").forward(request, response);
        } catch (SQLException | ServiceException e) {
            e.printStackTrace();
        }
    }

}
