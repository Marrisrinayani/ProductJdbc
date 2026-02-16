package com.example.Productjdbc.dao;

import com.example.Productjdbc.entity.product;


import java.util.List;

public interface daointerface {
    List<product> getallproducts();
    product getproductbyid(int id);
    void addproduct(product p);
    boolean existbyid(int id);

    void deleteproductbyid(int id);
    void sortbyprice();
    void sortbypricedesc();
    void updateproduct(String name,int price);
    List<product> filterbybrand(String brand);


}
