package com.gezi.GS.service.sys;

import com.gezi.GS.vo.sys.ScoreList;

public interface ScoreListService {
	Long getMyScore(Long userId);

	int updScoreList(ScoreList scoreList);
}
