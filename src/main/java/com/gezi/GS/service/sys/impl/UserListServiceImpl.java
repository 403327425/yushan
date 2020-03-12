package com.gezi.GS.service.sys.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.GS.example.sys.UserListExample;
import com.gezi.GS.service.AbstraceService;
import com.gezi.GS.service.sys.UserListService;
import com.gezi.GS.vo.sys.UserList;
@Service
@Transactional
public class UserListServiceImpl extends AbstraceService implements UserListService {

	@Override
	public int add(UserList userList) {
		// TODO Auto-generated method stub
		return userListMapper.insert(userList);
	}

	@Override
	public void updateUser(UserList userList) {
		// TODO Auto-generated method stub
		UserListExample example =new UserListExample();
		UserListExample.Criteria criteria= example.createCriteria();
		criteria.andOpenidEqualTo(userList.getOpenid());
		if(userListMapper.selectByExample(example).size()<=0){
			userListMapper.insert(userList);
		}else{
			UserList userList2=userListMapper.selectByExample(example).get(0);
			userList2.setCreateTime(userList.getCreateTime());
			userList2.setUserName(userList.getUserName());
			userList2.setReservedFields(userList.getReservedFields());
			userListMapper.updateByExample(userList2, example);
		}
		
	}

	@Override
	public UserList getUserByOpenId(String openid) {
		// TODO Auto-generated method stub
		UserListExample example =new UserListExample();
		UserListExample.Criteria criteria= example.createCriteria();
		criteria.andOpenidEqualTo(openid);
		List<UserList> list =userListMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
	}
	
}
