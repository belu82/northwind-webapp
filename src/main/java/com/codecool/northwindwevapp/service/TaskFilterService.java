package com.codecool.northwindwevapp.service;

import com.codecool.northwindwevapp.model.Task1;
import com.codecool.northwindwevapp.model.Task2;
import com.codecool.northwindwevapp.model.Task3;

import java.util.ArrayList;
import java.util.List;

public class TaskFilterService {

    public List<Task1> Task1Filter(List<Task1> task1List, String product, String company) {
        List<Task1> returnList = new ArrayList<>();
        if (product.equals("") && company.equals("")) {
            return task1List;
        }
        if (product.equals("")) {
            for (int i = 0; i < task1List.size(); i++) {
                if (task1List.get(i).getCompany().equals(company)) {
                    returnList.add(task1List.get(i));
                }
            }
            return returnList;
        } else if (company.equals("")) {
            for (int i = 0; i < task1List.size(); i++) {
                if (task1List.get(i).getProduct().equals(product)) {
                    returnList.add(task1List.get(i));
                }
            }
            return returnList;
        }
        return null;
    }

    public List<Task2> Task2Filter(List<Task2> task2List, String productName, Integer products){
        List<Task2> task2s = new ArrayList<>();
        if(productName.equals("") && products.equals(0)){
            return task2List;
        }
        if(productName.equals("")){
            for(int i = 0; i<task2List.size();i++){
                if(task2List.get(i).getProducts().equals(products)){
                    task2s.add(task2List.get(i));
                }
            }
            return task2s;
        }if(products == 0){
            for (int i = 0; i<task2List.size();i++){
                if(task2List.get(i).getProductName().equals(productName)){
                    task2s.add(task2List.get(i));
                }
            }
            return task2s;
        }
        return null;
    }

    /* NOT necessary
    public List<Task3> Task3Filter(List<Task3> task3List, String company){
        List<Task3> task3s = new ArrayList<>();
        if(company.equals("")){
            for(int i = 0; i<task3List.size();i++){
                if(task3List.get(i).getCompany().equals(company)){
                    task3s.add(task3List.get(i));
                }
            }
            return task3s;
        }
        return null;
    }

     */

}
