package spring5_rest_study.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import spring5_rest_study.dto.Member;

@Mapper
public interface MemberMapper {

	Member selectByEmail(String email);
	List<Member> selectAll();
	int insert(Member member);
	int update(Member member);
	int delete(Member member);
}
