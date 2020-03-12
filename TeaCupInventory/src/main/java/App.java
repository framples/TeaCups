
import controller.TeaCupController;
import dao.TeaCupDao;
import dao.TeaCupDaoFileImpl;
import io.TeaCupView;
import io.UserIO;
import io.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author keelybrennan
 */
public class App {
    public static void main(String[] args) {
        
      /*  UserIO io = new UserIOConsoleImpl();
        
        TeaCupDao dao = new TeaCupDaoFileImpl();
        TeaCupView view = new TeaCupView(io);
        TeaCupController controller = new TeaCupController(dao, view); */
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeaCupController controller = ctx.getBean("controller", TeaCupController.class);

        controller.run();
    
    }
 
}
