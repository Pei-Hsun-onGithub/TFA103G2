package com.card.model;

import java.util.*;
import com.card.model.CardVO;

public interface CardDAO_interface {
    public void insert(CardVO cardVO);
    public void update(CardVO cardVO);
    public void delete(Integer cardId);
    public CardVO findByPK(Integer cardId);
    public List<CardVO> getAll();
    public Set<CardVO> getCardByUserId(Integer userId);
    //�d�߬Y���������u(�@��h)(�^�� Set)
//    public Set<EmpVO> getEmpsByDeptno(Integer cardId);

}
