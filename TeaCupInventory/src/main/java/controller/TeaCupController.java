
package controller;
import dao.TeaCupDao;
import dao.TeaCupPersistenceException;
import dto.TeaCups;
import io.TeaCupView;

/**
 *
 * @author keelybrennan
 */
public class TeaCupController {

    TeaCupView view;
    TeaCupDao dao;

    public TeaCupController(TeaCupDao dao, TeaCupView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            while (keepGoing) {

                try {
                    menuSelection = getMenuSelection();
                } catch (NumberFormatException e) {
//                view.displayErrorMessage(e.getMessage());
                    continue;
                }
                switch (menuSelection) {
                    case 1:
                    createTeaCup();
                        break;
                    case 2:
//                    getAllTeaCups();
                        break;
                    case 3:
//                    searchTeaCupName();
                        break;
                    case 4:
//                    removeTeaCup();
                        break;
                    case 5:
//                    editTeaCup();
                        break;

                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
            
        }
    }
    
 


    public void getAllTeaCups() throws TeaCupPersistanceException {
        view.displayDisplayAllTeaCupsBanner();
        List<teacup> teaCupList = dao.getAllTeaCups();
        view.displayTeacupList(teaCupList);
    }
    
    private void searchTeaCupName() throws TeaCupPersistanceException {
        view.displayDisplayTeaCupBanner();
        String name = view.getNameChoice();
        Teacup teacup = dao.getTeacup(name);
        view.displayTeaCup(Teacup);
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void unknownCommand() {
//        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();

    }
    
    private void createTeaCup() {
        view.displayCreateTeaCupBanner();
        TeaCups newTeaCup = view.getNewTeaCupInfo();
        dao.createTeaCup(newTeaCup);
        view.displayCreateSuccessBanner();
    }
    
    
    
//==CASE 4: REMOVE TEACUP   
    //private void removeTeaCup() throws TeaCupPersistenceException {
    private void removeTeaCup(){
        view.displayRemoveBanner(); //write in view 
        String name = view.getName(); //write in view 
        //dao.removeTeaCup(name);// write in dao
        view.displayRemoveSuccessBanner(); //write in view 
    }
    
//==CASE 5: EDIT TEACUP 
//private void editTeaCup() throws TeaCupPersistenceException {
    private void editTeaCup() {
        String name = view.getName();
        TeaCups teaCup = dao.getTeaCup(name);
        
        boolean keepGoing = true;
        int choice;
        if(teaCup != null){
            choice = view.displayEditMenuAndGetChoice(teaCup);
        
            switch(choice){
                case 1: 
                    teaCup.setName(view.getName());
                    break;
                case 2: 
                    teaCup.setColor(view.getColor());
                    break;
                case 3: 
                    //teaCup.setTimeAcquired(view.getTimeAcquired());
                    break;
                case 4: 
                    teaCup.setManufacturer(view.getManufacturer());
                    break;
                case 5: 
                    teaCup.setPrice(view.getPrice());
                    break;
                default: 
                    keepGoing = false;
                    break;
            } 
            //if TeaCup to edit does not already exist, add it 
            dao.addTeaCup(teaCup.getName(), teaCup);
            if(keepGoing == true){
               //keepGoing = view.displayEditMenuAndGetChoice(promptEditContine());
               
            }
        }else {
            //add error in view later
           // view.displayMissingTeaCupError();
            System.out.println("error");
        }
    }

}
