import mapper.UserMapper;
import service.IUserService;
import po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        IUserService userService = (IUserService) applicationContext.getBean("userService");
        User user = userService.selectByPrimaryKey(2);
        System.out.println(user);
    }

    @Test
    public void testInsert() {
        IUserService userService = (IUserService) applicationContext.getBean("userService");
        User user = new User();
        user.setUserName("LMGD");
        user.setUserPwd("123");
        user.setLikes("sb");

        int index = userService.insert(user);
        System.out.println(index);
    }

}
