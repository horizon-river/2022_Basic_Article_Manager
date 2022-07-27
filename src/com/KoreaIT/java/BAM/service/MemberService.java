package com.KoreaIT.java.BAM.service;

import com.KoreaIT.java.BAM.container.Container;
import com.KoreaIT.java.BAM.dto.Member;

public class MemberService {

	public Member getMemberByLoginId(String loginId) {
		
		int index = getMemberIndexByLoginId(loginId);
		
		if(index == -1) {
			return null;
		}
		
		return Container.memberDao.members.get(index);
	}

	public boolean isJoinableLoginId(String loginId) {
		int index = getMemberIndexByLoginId(loginId);
		
		if(index == -1) {
			return true;
		}
		
		return false;
	}
	
	private int getMemberIndexByLoginId(String loginId) {
		int i = 0;
		for(Member member : Container.memberDao.members) {
			if(member.loginId.equals(loginId)) {
				return i;
			}
			i++;
		}
		
		return -1;
	}

}
