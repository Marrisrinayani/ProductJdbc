package com.example.Productjdbc.dao;

import com.example.Productjdbc.entity.product;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoimpl implements daointerface {

    @Override
    public List<product> getallproducts() {
        String sql="select * from product";
        List<product> plist=new ArrayList<>();
        try{
            String url="jdbc:mysql://localhost:3306/testdb";
            String username="root";
            String password="root";
            Connection con= DriverManager.getConnection(url,username,password);
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int price=rs.getInt("price");
                double rating=rs.getDouble("rating");
                String brand=rs.getString("brand");
                product p=new product(id,name,price,rating,brand);
                plist.add(p);
            }

            return plist;
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public product getproductbyid(int id) {
        String sql="select * from product where id=?";
        try{
            String url="jdbc:mysql://localhost:3306/testdb";
            String username="root";
            String password="root";
            Connection con= DriverManager.getConnection(url,username,password);
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            var rs=ps.executeQuery();
            while(rs.next())
            {
                int id1=rs.getInt("id");
                String name=rs.getString("name");
                int price=rs.getInt("price");
                double rating=rs.getDouble("rating");
                String brand=rs.getString("brand");
                product p=new product(id1,name,price,rating,brand);
                return p;
            }
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void addproduct(product p) {
        String sql="insert into product(name,price,rating,brand) values(?,?,?,?)";
        try
        {
            String url="jdbc:mysql://localhost:3306/testdb";
            String username="root";
            String password="root";
            Connection con= DriverManager.getConnection(url,username,password);
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,p.getName());
            ps.setInt(2,p.getPrice());
            ps.setDouble(3,p.getRating());
            ps.setString(4,p.getBrand());
            int re=ps.executeUpdate();
            System.out.println("Rows inserted: "+re);
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }


    }

    @Override
    public boolean existbyid(int id) {
        String sql="select * from product where id=?";
        try{
            String url="jdbc:mysql://localhost:3306/testdb";
            String username="root";
            String password="root";
            Connection con=DriverManager.getConnection(url, username, password);
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            var rs=ps.executeQuery();
            return rs.next();
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteproductbyid(int id) {
        String sql="delete from product where id=?";
        try{
            String url="jdbc:mysql://localhost:3306/testdb";
            String username="root";
            String password="root";
            Connection con=DriverManager.getConnection(url, username, password);
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            int re=ps.executeUpdate();
            System.out.println("Rows deleted: "+re);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sortbyprice() {
        String sql="select * from product order by price";
        try{
            String url="jdbc:mysql://localhost:3306/testdb";
            String username="root";
            String password="root";
            Connection con=DriverManager.getConnection(url, username, password);
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int price=rs.getInt("price");
                double rating=rs.getDouble("rating");
                String brand=rs.getString("brand");
                product p=new product(id,name,price,rating,brand);
                System.out.println(p);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sortbypricedesc() {
        String sql="select * from product order by price desc";
        try{
            String url="jdbc:mysql://localhost:3306/testdb";
            String username="root";
            String password="root";
            Connection con=DriverManager.getConnection(url, username, password);
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int price=rs.getInt("price");
                double rating=rs.getDouble("rating");
                String brand=rs.getString("brand");
                product p=new product(id,name,price,rating,brand);
                System.out.println(p);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateproduct(String name, int price) {
        String sql="update product set price=? where name=?";
        try{
            String url="jdbc:mysql://localhost:3306/testdb";
            String username="root";
            String password="root";
            Connection con=DriverManager.getConnection(url, username, password);
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, price);
            ps.setString(2, name);
            int re=ps.executeUpdate();
            System.out.println("Rows updated: "+re);
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<product> filterbybrand(String brand) {
        String sql="select * from product where brand=?";
        List<product> plist = new ArrayList<>();
        try{
            String url="jdbc:mysql://localhost:3306/testdb";
            String username="root";
            String password="root";
            Connection con=DriverManager.getConnection(url, username, password);
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, brand);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int price=rs.getInt("price");
                double rating=rs.getDouble("rating");
                String brand1=rs.getString("brand");
                product p=new product(id,name,price,rating,brand1);
                plist.add(p);
            }
            return plist;

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }


    }
}
