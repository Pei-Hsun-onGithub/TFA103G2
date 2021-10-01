package com.memberinfo.model;

import java.util.List;

public interface MemberInfoDAO {
	
	void add(MemberInfo memberinfo);
	void update(MemberInfo memberinfo);
	void delete(int userId);
	MemberInfo findByPK(int userId);
	List<MemberInfo> getAll();

}
