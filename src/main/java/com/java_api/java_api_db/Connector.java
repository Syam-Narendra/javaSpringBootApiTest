package com.java_api.java_api_db;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java_api.StoreData;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/collections")
public class Connector {
    String url = "jdbc:mysql://database-2.clfhspcuxzv5.ap-south-1.rds.amazonaws.com:3306/awsDatabase";
    String userName = "admin";
    String password = "SdoWEfcpUCLiNKUgoxUj";
    @GetMapping
    public Map<String, StoreData> getUser1(){
        Map<String, StoreData> allData = new HashMap<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement stmt = con.createStatement();
            String sqlQuery = "SELECT * FROM itemsData";
            ResultSet outPut= stmt.executeQuery(sqlQuery);
            while(outPut.next()){
                StoreData data = new StoreData();
                data.setId(outPut.getString("Id"));
                data.setTitle(outPut.getString("title"));
                data.setCategory(outPut.getString("category"));
                data.setDescription(outPut.getString("description"));
                data.setDateOfSale(outPut.getString("dateOfSale"));
                data.setSold(outPut.getString("sold"));
                data.setPrice(outPut.getString("price"));
                data.setImageUrl(outPut.getString("image"));
                allData.put(data.getId(), data);
            }
        return allData;

            
        } catch (Exception e) {
            System.out.println(e);
        }
        return allData;

    }

    @GetMapping("/{id}")
    public StoreData getUser2(@PathVariable String id){
        StoreData data = new StoreData();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement stmt = con.createStatement();
            String sqlQuery = "SELECT * FROM itemsData where id="+id;
            ResultSet outPut= stmt.executeQuery(sqlQuery);
            while(outPut.next()){
                data.setId(outPut.getString("Id"));
                data.setTitle(outPut.getString("title"));
                data.setCategory(outPut.getString("category"));
                data.setDescription(outPut.getString("description"));
                data.setDateOfSale(outPut.getString("dateOfSale"));
                data.setSold(outPut.getString("sold"));
                data.setPrice(outPut.getString("price"));
                data.setImageUrl(outPut.getString("image"));
            }
        return data;

            
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }
    
}