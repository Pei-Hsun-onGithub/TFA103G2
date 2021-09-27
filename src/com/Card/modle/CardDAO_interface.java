package com.Card.modle;

import java.util.List;

public interface CardDAO_interface {
    public void insert(CardVO cardVO);
    public void update(CardVO cardVO);
    public void delete(Integer cardId);
    public CardVO findByPK(Integer cardId);
    public List<CardVO> getAll();
    //查詢某部門的員工(一對多)(回傳 Set)
//    public Set<EmpVO> getEmpsByDeptno(Integer cardId);

}
