package com.FavoRestaurant.modle;

import java.util.*;

public interface FavoRestaurantDAO_interface {
    public void insert(FavoRestaurantVO favoRestaurantVO);
    public void delete(Integer userId,Integer restaurantId);
    public List<FavoRestaurantVO> getAll();
    //�d�߬Y���������u(�@��h)(�^�� Set)
//    public Set<EmpVO> getEmpsByDeptno(Integer userId);
}