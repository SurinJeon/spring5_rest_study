package spring5_rest_study.mappers;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_rest_study.config.ContextRoot;
import spring5_rest_study.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextRoot.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberMapperTest {

	private static final Log log = LogFactory.getLog(MemberMapperTest.class);

	@Autowired
	private MemberMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test03selectById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Member searchMem = mapper.selectById(5L);
		log.debug(searchMem.toString());
		Assert.assertNotNull(searchMem);
	}

	@Test
	public void test01SelectAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Member> list = mapper.selectAll();
		Assert.assertNotNull(list);

		list.stream().forEach(m -> log.debug(m.toString()));
	}

	@Test
	public void test02Insert() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member("test545@test.co.kr", "1111", "test255", LocalDateTime.now());

		int res = mapper.insert(member);
		Assert.assertEquals(1, res);
		
		log.debug("res id >> " + member.getId());
		mapper.delete(member.getId());
	}

	@Test
	public void test04Update() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member newMember = new Member("test300@test.co.kr", "1111", "test300", LocalDateTime.now());
		mapper.insert(newMember);
		
		newMember.setPassword("2222");
		int res = mapper.update(newMember); // 비번바꿈
		
		Assert.assertEquals(1, res);
		
		mapper.delete(newMember.getId());
	}

	@Test
	public void test05Delete() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member newMember = new Member("test500@test.co.kr", "1111", "test500", LocalDateTime.now());
		mapper.insert(newMember);
		
		int res = mapper.delete(newMember.getId());
		Assert.assertEquals(1, res);
	}

}
