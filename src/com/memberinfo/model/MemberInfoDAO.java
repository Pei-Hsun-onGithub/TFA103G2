package com.memberinfo.model;

import java.util.List;

public interface MemberInfoDAO {
	
	MemberInfo add(MemberInfo memberinfo);
	void update(MemberInfo memberinfo);
	void delete(Integer userId);
	boolean selectEmail(String email);
	MemberInfo findMemberPwd(String pwd);
	MemberInfo selectEmail2(String email,String pwd);
	MemberInfo findByPK(Integer userId);
	List<MemberInfo> getAll();
	MemberInfo selectEmail3(String email);

}
