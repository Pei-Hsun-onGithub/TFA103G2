package com.Card.modle;

import java.util.List;

public interface CardDAO_interface {
    public void insert(CardVO cardVO);
    public void update(CardVO cardVO);
    public void delete(Integer cardId);
    public CardVO findByPK(Integer cardId);
    public List<CardVO> getAll();
    //�d�߬Y���������u(�@��h)(�^�� Set)
//    public Set<EmpVO> getEmpsByDeptno(Integer cardId);

}
