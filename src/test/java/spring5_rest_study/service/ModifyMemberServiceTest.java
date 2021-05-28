package spring5_rest_study.service;

import static org.junit.Assert.fail;

import java.time.LocalDateTime;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_rest_study.config.ContextRoot;
import spring5_rest_study.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextRoot.class)
@WebAppConfiguration
public class ModifyMemberServiceTest {

	private static final Log log = LogFactory.getLog(ModifyMemberServiceTest.class);

	@Autowired
	private ModifyMemberService service;

	@Test
	public void testModifyMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member("testtest@test.com", "1111", "testtest11", LocalDateTime.now());
		int res = service.modifyMember(member);

		Assert.assertEquals(1, res);

		log.debug(member.toString());
	}

}
