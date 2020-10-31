package com.vlados.ThirdLabLow.main.view;

import com.vlados.ThirdLabLow.main.models.Validator;

import java.io.File;
import java.util.Scanner;

public class RetrieveInfo {
    Validator validator = new Validator();
    View view = new View();

    public String retrieveUsersLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public String retrieveType() {
        String type;
        view.showMessage(View.INVITATION_TO_ENTER_TYPE);
        while (true) {
            try {
                type = validator.checkString(retrieveUsersLine()).toLowerCase();
                if (!type.equalsIgnoreCase("triangle") && !type.equalsIgnoreCase("rectangle")
                        && !type.equalsIgnoreCase("circle")) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException exception) {
                view.showMessage(View.INCORRECT_INPUT);
                continue;
            }
            break;
        }
        return type;
    }

    public String retrieveColor() {
        String color;
        view.showMessage(View.INVITATION_TO_ENTER_COLOR);
        while (true) {
            try {
                color = validator.checkString(retrieveUsersLine());
            } catch (IllegalArgumentException exception) {
                view.showMessage(View.INCORRECT_INPUT);
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
                view.showMessage(View.INVITATION_TO_ENTER_FILE_LOCATION);
                path = validator.checkString(retrieveUsersLine());
                view.showMessage(View.INVITATION_TO_ENTER_FILENAME);
                filename = validator.checkString(retrieveUsersLine());
            }
            catch (IllegalArgumentException exception) {
                view.showMessage(View.INCORRECT_INPUT);
                continue;
            }
            file = new File(path, filename);
            if(file.exists()) break;
            else view.showMessage(View.INCORRECT_FILE);
        }
        return file;
    }
}
