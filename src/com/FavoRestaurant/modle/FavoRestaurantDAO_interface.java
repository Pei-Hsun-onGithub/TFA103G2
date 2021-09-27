package com.FavoRestaurant.modle;

import java.util.*;

public interface FavoRestaurantDAO_interface {
    public void insert(FavoRestaurantVO favoRestaurantVO);
    public void delete(Integer userId,Integer restaurantId);
    public List<FavoRestaurantVO> getAll();
    //查詢某部門的員工(一對多)(回傳 Set)
//    public Set<EmpVO> getEmpsByDeptno(Integer userId);
}