package com.vlados.ThirdLabLow.main.view;

import com.vlados.ThirdLabLow.main.models.Validator;

public class RetrieveInfo {
    Validator validator = new Validator();
    View view = new View();

    public String retrieveType() {
        String type;
        view.showMessage(View.INVITATION_TO_ENTER_TYPE);
        while (true) {
            try {
                type = validator.checkString(view.getUsersLine()).toLowerCase();
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
                color = validator.checkString(view.getUsersLine());
            } catch (IllegalArgumentException exception) {
                view.showMessage(View.INCORRECT_INPUT);
                continue;
            }
            break;
        }
        return color;
    }
}
