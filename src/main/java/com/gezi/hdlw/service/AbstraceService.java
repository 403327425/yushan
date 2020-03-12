package com.gezi.hdlw.service;

import javax.annotation.Resource;

import com.gezi.hdlw.dao.common.LwEmployeeMapper;
import com.gezi.hdlw.dao.sys.ChatGroupMapper;
import com.gezi.hdlw.dao.sys.LwActivityMapper;
import com.gezi.hdlw.dao.sys.LwCandidateMapper;
import com.gezi.hdlw.dao.sys.LwDictionaryMapper;
import com.gezi.hdlw.dao.sys.LwDictionaryTypeMapper;
import com.gezi.hdlw.dao.sys.LwQuestionnaireMapper;
import com.gezi.hdlw.dao.sys.LwRecordMapper;
import com.gezi.hdlw.dao.sys.LwVoterMapper;
import com.gezi.hdlw.dao.sys.StudyDataMapper;
import com.gezi.hdlw.dao.sys.WxDataMapper;
import com.gezi.hdlw.example.sys.StudyDataExample;

/**
 * 
 * 
 * <p>
 * Title: AbstraceService
 * </p>
 * 
 * <p>
 * Description: 公共业务基类
 * </p>
 * 
 * @author lixinrong
 * 
 * @date 2019年3月28日
 */
public abstract class AbstraceService {
	@Resource
	protected LwDictionaryMapper lwDictionaryMapper;
	@Resource
	protected LwDictionaryTypeMapper lwDictionaryTypeMapper;
	@Resource
	protected LwEmployeeMapper lwEmployeeMapper;
	@Resource
	protected LwQuestionnaireMapper lwQuestionnaireMapper;
	@Resource
	protected LwRecordMapper lwRecordMapper;
	@Resource
	protected LwCandidateMapper lwCandidateMapper;
	@Resource
	protected LwActivityMapper lwActivityMapper;
	@Resource
	protected LwVoterMapper lwVoterMapper ;
	@Resource
	protected ChatGroupMapper chatGroupMapper  ;
	@Resource
	protected StudyDataMapper studyDataMapper;
	@Resource
	protected WxDataMapper wxDataMapper;
}
