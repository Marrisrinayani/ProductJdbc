package com.example.Productjdbc.user;

import com.example.Productjdbc.dao.daoimpl;
import com.example.Productjdbc.dao.daointerface;
import com.example.Productjdbc.entity.product;


public class main {
    public static void main(String[] args) {
        daointerface dao=new daoimpl();
//        dao.addproduct(new product("Laptop", 1000, 4.5, "Dell"));
//        dao.addproduct(new product("Smartphone", 500, 4.0, "Samsung"));
//        dao.addproduct(new product("Headphones", 200, 4.2, "Sony"));
//        var plist=dao.getallproducts();
//        for(var i:plist)
//        {
//            System.out.println(i);
//        }
        var p1=dao.getproductbyid(2);
        System.out.println(p1);
        boolean exist=dao.existbyid(3);
        System.out.println(exist);
        dao.deleteproductbyid(1);
        dao.sortbyprice();
        System.out.println("descending order");
        dao.sortbypricedesc();
        dao.updateproduct("Smartphone", 45000);
        dao.filterbybrand("Samsung").forEach(System.out::println);

    }
}
