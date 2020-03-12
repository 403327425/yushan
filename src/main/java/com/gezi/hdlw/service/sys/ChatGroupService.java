package com.gezi.hdlw.service.sys;

import java.util.List;

import com.gezi.hdlw.vo.sys.ChatGroup;

public interface ChatGroupService {
	//添加
	public int addCG(ChatGroup chatGroup);
	//修改
	public int updateCG(ChatGroup chatGroup);
	//删除
	public int delectCG(int id);
	//查
	public List<ChatGroup> selectALLCG();
}
