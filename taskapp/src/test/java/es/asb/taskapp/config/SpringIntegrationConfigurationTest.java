package es.asb.taskapp.config;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.asb.taskapp.service.UserService;




public class SpringIntegrationConfigurationTest extends BaseIntegrationTest {

	private static final Logger LOG = Logger.getLogger(SpringIntegrationConfigurationTest.class);
	
	@Autowired
	private UserService userService;
	

	@Test
	public void testIntegrationWithResultSuccess() {
		try {
			assertNotNull(userService);
			
		} catch (Exception e) {
			LOG.error("Error, test integration with result success", e);
			fail();
		}
	}
	
	
}
