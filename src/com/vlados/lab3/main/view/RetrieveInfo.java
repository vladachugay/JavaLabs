package com.vlados.lab3.main.view;

import com.vlados.lab3.main.controllers.Controller;
import com.vlados.lab3.main.models.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Scanner;

public class RetrieveInfo {
    Validator validator = new Validator();
    View view = new View();
    private static final Logger logger = LogManager.getLogger(Controller.class);

    public String retrieveUsersLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public String retrieveType() {
        String type;
        view.showMessage(ResourceBundleKeys.INVITATION_TO_ENTER_TYPE);
        logger.info("User received invitation to enter type of shape.");
        while (true) {
            try {
                type = validator.checkString(retrieveUsersLine()).toLowerCase();
                if (!type.equalsIgnoreCase("triangle") && !type.equalsIgnoreCase("rectangle")
                        && !type.equalsIgnoreCase("circle")) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException exception) {
                logger.error("Incorrect type of shape");
                view.showMessage(ResourceBundleKeys.INCORRECT_INPUT);
                continue;
            }
            break;
        }
        return type;
    }

    public String retrieveColor() {
        String color;
        view.showMessage(ResourceBundleKeys.INVITATION_TO_ENTER_COLOR);
        logger.info("User received invitation to enter color of shape.");
        while (true) {
            try {
                color = validator.checkString(retrieveUsersLine());
            } catch (IllegalArgumentException exception) {
                view.showMessage(ResourceBundleKeys.INCORRECT_INPUT);
                logger.error("Incorrect input");
                continue;
            }
            break;
        }
        return color;
    }

    public File retrieveFile() {
        String path;
        String filename;
        File file;
        while (true) {
            try {
                view.showMessage(ResourceBundleKeys.INVITATION_TO_ENTER_FILE_LOCATION);
                logger.info("User received invitation to enter file location.");
                path = validator.checkString(retrieveUsersLine());
                view.showMessage(ResourceBundleKeys.INVITATION_TO_ENTER_FILENAME);
                logger.info("User received invitation to enter filename.");
                filename = validator.checkString(retrieveUsersLine());
            }
            catch (IllegalArgumentException exception) {
                view.showMessage(ResourceBundleKeys.INCORRECT_INPUT);
                logger.error("Incorrect input");
                continue;
            }
            file = new File(path, filename);
            if(file.exists()) break;
            else view.showMessage(ResourceBundleKeys.INCORRECT_FILE);
        }
        return file;
    }
}
