package com.vlados.lab3.main.controllers;
import com.vlados.lab3.main.models.Validator;
import com.vlados.lab3.main.models.services.IOService;
import com.vlados.lab3.main.models.services.ShapeService;
import com.vlados.lab3.main.view.RetrieveInfo;
import com.vlados.lab3.main.view.View;

import java.util.ArrayList;
import java.util.List;


public class Controller {
    private static final ShapeService shapeService = new ShapeService();
    private static final IOService ioservice = new IOService();
    private static final View view = new View();
    private static final Validator validator = new Validator();
    private static final RetrieveInfo info = new RetrieveInfo();

    public void start() {
        while (true) {
            view.showMessage(View.MAIN_MENU);
            String choice = info.retrieveUsersLine();
            switch (choice.trim()) {
                case "1" -> this.addShape(info.retrieveType());
                case "2" -> shapeService.autofill();
                case "3" -> view.showShapes(shapeService.getShapes());
                case "4" -> {
                    view.showMessage(View.SUM_AREA);
                    view.showMessage(String.valueOf(shapeService.sumAreaForAllShapes()));
                }
                case "5" -> this.sumAreaForType(info.retrieveType());
                case "6" -> {
                    shapeService.sortByArea(shapeService.getShapes());
                    view.showShapes(shapeService.getShapes());
                }
                case "7" -> {
                    shapeService.sortByColor(shapeService.getShapes());
                    view.showShapes(shapeService.getShapes());
                }
                case "8" -> ioservice.writeShapes(shapeService.getShapes(), info.retrieveFile());
                case "9" -> ioservice.readShapes(info.retrieveFile(), shapeService.getShapes());
                case "10" -> System.exit(1);
                default -> view.showMessage(View.INCORRECT_INPUT);
            }
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
                            side = validator.checkNumber(info.retrieveUsersLine());
                        } catch (IllegalArgumentException exception) {
                            view.showMessage(View.INCORRECT_INPUT);
                            continue;
                        }
                        sides.add(side);
                        break;
                    }
                }
                shapeService.addTriangle(sides.get(0), sides.get(1), sides.get(2), info.retrieveColor());
                sides.clear();
            }
            case "rectangle" -> {
                float a;
                view.showMessage(View.INVITATION_TO_ENTER_RECTANGLE);
                while (sides.size() < 2) {
                    while (true) {
                        try {
                            side = validator.checkNumber(info.retrieveUsersLine());
                        } catch (IllegalArgumentException exception) {
                            view.showMessage(View.INCORRECT_INPUT);
                            continue;
                        }
                        sides.add(side);
                        break;
                    }
                }
                shapeService.addRectangle(sides.get(0), sides.get(1), info.retrieveColor());
                sides.clear();
            }
            case "circle" -> {
                view.showMessage(View.INVITATION_TO_ENTER_CIRCLE);
                while (true) {
                    try {
                        side = validator.checkNumber(info.retrieveUsersLine());
                    } catch (IllegalArgumentException exception) {
                        view.showMessage(View.INCORRECT_INPUT);
                        continue;
                    }
                    break;
                }
                shapeService.addCircle(side, info.retrieveColor());
            }
            default -> view.showMessage(View.INCORRECT_INPUT);
        }
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
}
