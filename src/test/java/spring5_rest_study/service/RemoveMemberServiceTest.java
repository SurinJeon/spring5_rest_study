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
public class RemoveMemberServiceTest {
	private static final Log log = LogFactory.getLog(RemoveMemberServiceTest.class);

	@Autowired
	private RemoveMemberService service;

	@Autowired
	private RegisterMemberService regService;

	@Test
	public void testRemoveMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member newMember = new Member("testing123@test.com", "1111", "testing123", LocalDateTime.now());
		regService.registerMember(newMember);

		int res = service.removeMember(newMember.getId());
		Assert.assertEquals(1, res);

		log.debug("res >> " + res);

	}

}
