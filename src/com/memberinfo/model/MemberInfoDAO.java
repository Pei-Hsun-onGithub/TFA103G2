package com.memberinfo.model;

import java.util.List;

public interface MemberInfoDAO {
	
	void add(MemberInfo memberinfo);
	void update(MemberInfo memberinfo);
	void delete(Integer userId);
	boolean selectEmail(String email);
	MemberInfo findByPK(Integer userId);
	List<MemberInfo> getAll();

}
