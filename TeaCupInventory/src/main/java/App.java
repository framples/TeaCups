
import controller.TeaCupController;
import dao.TeaCupDao;
import dao.TeaCupDaoFileImpl;
import io.TeaCupView;
import io.UserIO;
import io.UserIOConsoleImpl;

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
        
        UserIO io = new UserIOConsoleImpl();
        
        TeaCupDao dao = new TeaCupDaoFileImpl();
        TeaCupView view = new TeaCupView(io);
        TeaCupController controller = new TeaCupController(dao, view);

        controller.run();
    
    }
 
}
