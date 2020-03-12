package com.gezi.hdlw.service.sys.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.dao.sys.ChatGroupMapper;
import com.gezi.hdlw.example.sys.ChatGroupExample;
import com.gezi.hdlw.service.AbstraceService;
import com.gezi.hdlw.service.sys.ChatGroupService;
import com.gezi.hdlw.vo.sys.ChatGroup;
@Service
@Transactional
public class ChatGroupServiceImpl   extends AbstraceService implements ChatGroupService {

	@Override
	public int addCG(ChatGroup chatGroup) {
		// TODO Auto-generated method stub
		
		return chatGroupMapper.insert(chatGroup);
	}

	@Override
	public int updateCG(ChatGroup chatGroup) {
		// TODO Auto-generated method stub
		ChatGroupExample example=new ChatGroupExample();
		ChatGroupExample.Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(chatGroup.getId());
		return chatGroupMapper.updateByExample(chatGroup, example);
	}

	@Override
	public int delectCG(int id) {
		// TODO Auto-generated method stub
		
		return chatGroupMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ChatGroup> selectALLCG() {
		// TODO Auto-generated method stub
		ChatGroupExample example=new ChatGroupExample();
		return chatGroupMapper.selectByExample(example);
	}

}
