package spring5_rest_study.service.impl;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import spring5_rest_study.dto.Member;
import spring5_rest_study.mappers.MemberMapper;
import spring5_rest_study.service.MemberListService;

public class MemberListServiceImpl implements MemberListService {

	static final Log log = LogFactory.getLog(GetMemberServiceImpl.class);
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public List<Member> getLists() {
		List<Member> list = mapper.selectAll();
		log.debug("service - getLists() > " + list.size());
		return list;
	}

}