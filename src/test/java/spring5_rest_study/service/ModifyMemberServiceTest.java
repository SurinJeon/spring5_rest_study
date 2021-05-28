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
public class ModifyMemberServiceTest {

	private static final Log log = LogFactory.getLog(ModifyMemberServiceTest.class);

	@Autowired
	private ModifyMemberService service;
	
	@Autowired
	private RegisterMemberService regService;
	
	@Autowired
	private RemoveMemberService remService;


	@Test
	public void testModifyMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member newMember = new Member("testtest1234@test.com", "1111", "testtest11", LocalDateTime.now());
		
		regService.registerMember(newMember);
		
		newMember.setPassword("2222");
		
		int res = service.modifyMember(newMember);
		Assert.assertEquals(1, res);

		log.debug(newMember.toString());
		
		remService.removeMember(newMember.getId());
	}

}
