/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TeaCupDao;
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
}
