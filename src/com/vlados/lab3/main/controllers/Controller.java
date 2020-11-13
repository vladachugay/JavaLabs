package com.vlados.lab3.main.controllers;

import com.vlados.lab3.main.models.Validator;
import com.vlados.lab3.main.models.services.IOService;
import com.vlados.lab3.main.models.services.ShapeService;
import com.vlados.lab3.main.view.ResourceBundleKeys;
import com.vlados.lab3.main.view.RetrieveInfo;
import com.vlados.lab3.main.view.View;



import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Controller {
    private static final ShapeService shapeService = new ShapeService();
    private static final IOService ioservice = new IOService();
    private static final View view = new View();
    private static final Validator validator = new Validator();
    private static final RetrieveInfo info = new RetrieveInfo();
    private static final Logger logger = LogManager.getLogger(Controller.class);

    public void start() {
        while (true) {
            view.showMessage(ResourceBundleKeys.MAIN_MENU);
            logger.debug("Main menu");
            logger.trace("trace");
            String choice = info.retrieveUsersLine();
            switch (choice.trim()) {
                case "1" -> {
                    logger.info("User chose to add shape.");
                    this.addShape(info.retrieveType());
                }
                case "2" -> {
                    logger.info("User chose to autofill shapes.");
                    shapeService.autofill();
                }
                case "3" -> {
                    logger.info("User chose to show add shapes.");
                    view.showShapes(shapeService.getShapes());
                }
                case "4" -> {
                    logger.info("User chose to sum all shape areas.");
                    view.showMessage(ResourceBundleKeys.SUM_AREA);
                    view.showMessage(String.valueOf(shapeService.sumAreaForAllShapes()));
                }
                case "5" -> {
                    logger.info("User chose to sum some shape type areas.");
                    this.sumAreaForType(info.retrieveType());
                }
                case "6" -> {
                    logger.info("User chose to sort shapes by area.");
                    shapeService.sortByArea(shapeService.getShapes());
                    view.showShapes(shapeService.getShapes());
                }
                case "7" -> {
                    logger.info("User chose to sort shapes by color.");
                    shapeService.sortByColor(shapeService.getShapes());
                    view.showShapes(shapeService.getShapes());
                }
                case "8" -> {
                    logger.info("User chose to write shapes to some file.");
                    ioservice.writeShapes(shapeService.getShapes(), info.retrieveFile());
                }
                case "9" -> {
                    logger.info("User chose to read shapes from some file.");
                    ioservice.readShapes(info.retrieveFile(), shapeService.getShapes());
                }
                case "10" -> {
                    logger.info("User chose to change language.");
                    this.changeLanguage();
                }
                case "11" -> {
                    logger.info("User exited the program.");
                    System.exit(1);
                }
                default -> {
                    logger.error("Incorrect choice in the main menu.");
                    view.showMessage(ResourceBundleKeys.INCORRECT_INPUT);
                }
            }
        }
    }

    public void addShape(String type) {
        List<Float> sides = new ArrayList<>();
        float side;
        switch (type) {
            case "triangle" -> {
                logger.info("User chose to add triangle.");
                view.showMessage(ResourceBundleKeys.INVITATION_TO_ENTER_TRIANGLE);
                logger.info("User received invitation to enter 3 sides of triangle.");
                while (sides.size() < 3) {
                    while (true) {
                        try {
                            side = validator.checkNumber(info.retrieveUsersLine());
                        } catch (IllegalArgumentException exception) {
                            logger.error("Incorrect input");
                            view.showMessage(ResourceBundleKeys.INCORRECT_INPUT);
                            continue;
                        }
                        sides.add(side);
                        break;
                    }
                }
                shapeService.addTriangle(sides.get(0), sides.get(1), sides.get(2), info.retrieveColor());
                logger.info("Triangle was added.");
                sides.clear();
            }
            case "rectangle" -> {
                float a;
                view.showMessage(ResourceBundleKeys.INVITATION_TO_ENTER_RECTANGLE);
                logger.info("User received invitation to enter 2 sides of rectangle.");
                while (sides.size() < 2) {
                    while (true) {
                        try {
                            side = validator.checkNumber(info.retrieveUsersLine());
                        } catch (IllegalArgumentException exception) {
                            logger.error("Incorrect input");
                            view.showMessage(ResourceBundleKeys.INCORRECT_INPUT);
                            continue;
                        }
                        sides.add(side);
                        break;
                    }
                }
                shapeService.addRectangle(sides.get(0), sides.get(1), info.retrieveColor());
                logger.info("Rectangle was added.");
                sides.clear();
            }
            case "circle" -> {
                view.showMessage(ResourceBundleKeys.INVITATION_TO_ENTER_CIRCLE);
                logger.info("User received invitation to radius of circle.");
                while (true) {
                    try {
                        side = validator.checkNumber(info.retrieveUsersLine());
                    } catch (IllegalArgumentException exception) {
                        logger.error("Incorrect input");
                        view.showMessage(ResourceBundleKeys.INCORRECT_INPUT);
                        continue;
                    }
                    break;
                }
                shapeService.addCircle(side, info.retrieveColor());
                logger.info("Circle was added.");
            }
            default -> {
                logger.error("Incorrect type of shape");
                view.showMessage(ResourceBundleKeys.INCORRECT_INPUT);
            }
        }
    }


    public void sumAreaForType(String type) {
        switch (type) {
            case "circle" -> {
                view.showMessage(ResourceBundleKeys.SUM_AREA_CIRCLE);
                view.showMessage(String.valueOf(shapeService.sumAreaForSomeShapes("Circle")));
            }
            case "triangle" -> {
                view.showMessage(ResourceBundleKeys.SUM_AREA_TRIANGLE);
                view.showMessage(String.valueOf(shapeService.sumAreaForSomeShapes("Triangle")));
            }
            case "rectangle" -> {
                view.showMessage(ResourceBundleKeys.SUM_AREA_RECTANGLE);
                view.showMessage(String.valueOf(shapeService.sumAreaForSomeShapes("Rectangle")));
            }
        }
    }

    public void changeLanguage() {
        view.showMessage(ResourceBundleKeys.LANGUAGE_MENU);
        logger.info("User received invitation to choose language to change.");
        String choice = info.retrieveUsersLine();
        switch (choice) {
            case "2" -> view.setLocale(new Locale("uk", "UA"));
            case "3" -> view.setLocale(new Locale("ru", "RU"));
            default -> view.setLocale(new Locale("en", "GB"));
        }
    }
}
