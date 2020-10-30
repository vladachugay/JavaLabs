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
//        view.showMessage(View.MAIN_MENU);
//        String choice = view.getUsersLine();
//        switch (choice.trim()) {
//            case "1":
//
//        }


//        view.showMessage(View.ALL_SHAPES);
//        view.showShapes(shapeService.getShapes());
//
//        view.showMessage(View.SUM_AREA);
//        view.showMessage(String.valueOf(shapeService.sumAreaForAllShapes()));
//
//        view.showMessage(View.SUM_AREA_CIRCLE);
//        view.showMessage(String.valueOf(shapeService.sumAreaForSomeShapes("Circle")));
//
//        view.showMessage(View.SUM_AREA_RECTANGLE);
//        view.showMessage(String.valueOf(shapeService.sumAreaForSomeShapes("Rectangle")));
//
//        view.showMessage(View.SUM_AREA_TRIANGLE);
//        view.showMessage(String.valueOf(shapeService.sumAreaForSomeShapes("Triangle")));
//
//        view.showMessage(View.AREA_SORT);
//        shapeService.sortByArea(shapeService.getShapes());
//        view.showShapes(shapeService.getShapes());
//
//        view.showMessage(View.COLOR_SORT);
//        shapeService.sortByColor(shapeService.getShapes());
//        view.showShapes(shapeService.getShapes());
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
}
