package com.java_api.java_api_db;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java_api.StoreData;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class Connector {
    String url = "jdbc:mysql://database-2.clfhspcuxzv5.ap-south-1.rds.amazonaws.com:3306/awsDatabase";
    String userName = "admin";
    String password = "SdoWEfcpUCLiNKUgoxUj";
    @GetMapping("/{typeOfCall}")
    public Map<String, StoreData> getAllCollections(@PathVariable String typeOfCall){
        Map<String, StoreData> allData = new LinkedHashMap<>();
        String sold = "IS NOT NULL";

        if (typeOfCall.equals("unsold")){
            sold = "=0";
        }else if (typeOfCall.equals("sold")){
            sold = "=1";
        }else if (typeOfCall.equals("all-collections")){}
        else{
            return allData;
        }
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement stmt = con.createStatement();
            String sqlQuery = "SELECT * FROM itemsData WHERE sold "+sold+" ORDER BY id ASC";
            System.out.println(sqlQuery);
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
            con.close();
        return allData;

            
        } catch (Exception e) {
            System.out.println(e);
        }
        return allData;

    }

    @GetMapping("/collection/{id}")
    public StoreData getOneCollectionItem(@PathVariable String id){
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
            con.close();
        return data;

            
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }
    
}