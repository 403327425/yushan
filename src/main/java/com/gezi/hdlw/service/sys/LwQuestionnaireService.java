package com.gezi.hdlw.service.sys;



import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.search.sys.LwQuestionnaireSearch;
import com.gezi.hdlw.vo.sys.LwQuestionnaire;

/**
 * @Author weixiong
 * @Time 2019年7月19日 上午10:34:25
 * @Version 1.0
 * <p>Description:调查问卷的接口</p>
 */
public interface LwQuestionnaireService {
	public int insert(LwQuestionnaire lwQuestionnaire);
	
	public ResultUtil getQuestionnaire(LwQuestionnaireSearch lwQuestionnaireSearch);
	
	public int deleteById(Integer qnId);
	
	public LwQuestionnaire getById(Integer qnId);
	
	public int updataQuestionnaire(LwQuestionnaire lwQuestionnaire);
	
}
