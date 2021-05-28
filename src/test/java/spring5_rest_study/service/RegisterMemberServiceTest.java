package spring5_rest_study.service;

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
public class RegisterMemberServiceTest {

	private static final Log log = LogFactory.getLog(RegisterMemberServiceTest.class);

	@Autowired
	private RegisterMemberService service;
	
	@Autowired
	private RemoveMemberService remService;
	
	@Test
	public void testRegisterMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member("testtest1122@test.com", "1111", "testtest", LocalDateTime.now());
		int res = service.registerMember(member);
		Assert.assertEquals(1, res);
		
		log.debug(member.toString());
		
		remService.removeMember(member.getId());
		
	}

}
