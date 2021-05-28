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

		Member searchMem = mapper.selectById(1L);
		log.debug(searchMem.toString());
		Assert.assertNotNull(searchMem);
	}

	@Test
	public void test04SelectAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Member> list = mapper.selectAll();
		Assert.assertNotNull(list);

		list.stream().forEach(m -> log.debug(m.toString()));
	}

	@Test
	public void test01Insert() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member("test@test.co.kr", "1111", "test", LocalDateTime.now());

		int res = mapper.insert(member);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02Update() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member("test@test.co.kr", "1111", "test2", LocalDateTime.now());
		int res = mapper.update(member);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test05Delete() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member(1L);
		int res = mapper.delete(member);
		Assert.assertEquals(1, res);
	}

}
