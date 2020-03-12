package com.gezi.hdlw.service.sys.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.dao.sys.LwSeqenceMapper;
import com.gezi.hdlw.service.sys.LwSeqenceService;
import com.gezi.hdlw.vo.sys.LwSeqence;

@Service
@Transactional
public class LwSeqenceServiceImpl implements LwSeqenceService {
    
	private Object obj = new Object();
	@Autowired
	private LwSeqenceMapper  lwSeqenceMapper;
	
	private String getFormatDay(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
	
	@Override
	public String getSeqNoByType(Integer seqType) {
		String result = null;
		LwSeqence seq = lwSeqenceMapper.getSeqByType(seqType);
		if (seq == null) {
			return result;
		}
		String[] ret = new String[1];
		synchronized (this.obj) {
			Long crtValue = seq.getCrtValue();
			long len = seq.getLen().longValue();
			long newValue = crtValue.longValue();
			String prefix = seq.getPrefix();
			String bgcont = seq.getBgcont();
			if (bgcont == null)
				bgcont = "";
			for (int y = 0; y < 1; ++y) {
				newValue += 1L;
				//String spaceValue = "";
				String tmp1 = String.valueOf(newValue);
				if ((tmp1.length() > len) && (len != -1L))
					newValue = 1L;

				String tmp = String.valueOf(newValue);
			/*	if (len != -1L) {
					long spaceLen = len - tmp.length();
					for (int i = 0; i < spaceLen; ++i)
						spaceValue = spaceValue + "0";

				}*/

				if ((prefix != null) && (prefix.contains("yy"))) {
					prefix = getFormatDay(prefix);
				}
				if ((prefix == null) || (prefix.equals("null"))) {
					prefix = "";
				}
				seq.setCrtValue(Long.valueOf(newValue));

				ret[y] = bgcont + prefix + tmp;
				result = ret[0];
			}
			lwSeqenceMapper.updateSeqByType(seq);
		}
		return result;
	}

	@Override
	public void resetCrtvalue(Integer seqType) {
		lwSeqenceMapper.resetCrtvalue(seqType);
		
	}

}
