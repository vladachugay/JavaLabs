package com.vlados.ThirdLabLow.main.controllers;
import com.vlados.ThirdLabLow.main.models.Validator;
import com.vlados.ThirdLabLow.main.models.services.ShapeService;
import com.vlados.ThirdLabLow.main.view.View;

import java.util.ArrayList;
import java.util.List;


public class Controller {
    private static final ShapeService shapeService = new ShapeService();
    private static final View view = new View();
    private static final Validator validator = new Validator();

    public void start() {
        view.showMessage(View.MAIN_MENU);
        String choice = view.getUsersLine();
        switch (choice.trim()) {
            case "1" -> this.addShape(this.getTypeFromUser());
            case "2" -> shapeService.autofill();
            case "3" -> view.showShapes(shapeService.getShapes());
            case "4" -> {
                view.showMessage(View.SUM_AREA);
                view.showMessage(String.valueOf(shapeService.sumAreaForAllShapes()));
            }
            case "5" -> this.sumAreaForType(getTypeFromUser());
            case "6" -> {
                shapeService.sortByArea(shapeService.getShapes());
                view.showShapes(shapeService.getShapes());
            }
            case "7" -> {
                shapeService.sortByColor(shapeService.getShapes());
                view.showShapes(shapeService.getShapes());
            }
            case "8" -> this.saveShapesToFile();//save shapes to file
            case "9" -> this.readShapesFromFile();//read shapes from file
            case "10" -> System.exit(1);
            default -> view.showMessage(View.INCORRECT_INPUT);
        }
    }

    public void addShape(String type) {
        List<Float> sides = new ArrayList<>();
        float side;
        switch (type) {
            case "triangle" -> {
                view.showMessage(View.INVITATION_TO_ENTER_TRIANGLE);
                while (sides.size() < 3) {
                    while (true) {
                        try {
                            side = validator.checkNumber(view.getUsersLine());
                        } catch (IllegalArgumentException exception) {
                            view.showMessage(View.INCORRECT_INPUT);
                            continue;
                        }
                        sides.add(side);
                        break;
                    }
                }
                shapeService.addTriangle(sides.get(0), sides.get(1), sides.get(2), this.getColorFromUser());
                sides.clear();
            }
            case "rectangle" -> {
                float a;
                view.showMessage(View.INVITATION_TO_ENTER_RECTANGLE);
                while (sides.size() < 2) {
                    while (true) {
                        try {
                            side = validator.checkNumber(view.getUsersLine());
                        } catch (IllegalArgumentException exception) {
                            view.showMessage(View.INCORRECT_INPUT);
                            continue;
                        }
                        sides.add(side);
                        break;
                    }
                }
                shapeService.addRectangle(sides.get(0), sides.get(1), this.getColorFromUser());
                sides.clear();
            }
            case "circle" -> {
                view.showMessage(View.INVITATION_TO_ENTER_CIRCLE);
                while (true) {
                    try {
                        side = validator.checkNumber(view.getUsersLine());
                    } catch (IllegalArgumentException exception) {
                        view.showMessage(View.INCORRECT_INPUT);
                        continue;
                    }
                    break;
                }
                shapeService.addCircle(side, getColorFromUser());
            }
            default -> view.showMessage(View.INCORRECT_INPUT);
        }
    }

    public String getColorFromUser() {
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

    public String getTypeFromUser() {
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

    public void sumAreaForType(String type) {
        switch (type) {
            case "circle" -> {
                view.showMessage(View.SUM_AREA_CIRCLE);
                view.showMessage(String.valueOf(shapeService.sumAreaForSomeShapes("Circle")));
            }
            case "triangle" -> {
                view.showMessage(View.SUM_AREA_TRIANGLE);
                view.showMessage(String.valueOf(shapeService.sumAreaForSomeShapes("Triangle")));
            }
            case "rectangle" -> {
                view.showMessage(View.SUM_AREA_RECTANGLE);
                view.showMessage(String.valueOf(shapeService.sumAreaForSomeShapes("Rectangle")));
            }
        }
    }

    public void saveShapesToFile() {

    }

    public void readShapesFromFile() {

    }
}
