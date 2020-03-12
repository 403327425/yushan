package com.gezi.GS.service.sys;

import com.gezi.GS.vo.sys.UserList;

public interface UserListService {
	public int add(UserList userList);

	public void updateUser(UserList userList);

	public UserList getUserByOpenId(String openid);
}
