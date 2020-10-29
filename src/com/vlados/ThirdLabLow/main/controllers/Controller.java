package com.vlados.ThirdLabLow.main.controllers;
import com.vlados.ThirdLabLow.main.models.services.ShapeService;
import com.vlados.ThirdLabLow.main.view.View;


public class Controller {
    private static final ShapeService shapeService = new ShapeService();
    private static final View view = new View();

    public void start() {
        view.showMessage(View.ALL_SHAPES);
        view.showShapes(shapeService.getShapes());

        view.showMessage(View.SUM_AREA);
        view.showMessage(String.valueOf(shapeService.sumAreaForAllShapes()));

        view.showMessage(View.SUM_AREA_CIRCLE);
        view.showMessage(String.valueOf(shapeService.sumAreaForSomeShapes("Circle")));

        view.showMessage(View.SUM_AREA_RECTANGLE);
        view.showMessage(String.valueOf(shapeService.sumAreaForSomeShapes("Rectangle")));

        view.showMessage(View.SUM_AREA_TRIANGLE);
        view.showMessage(String.valueOf(shapeService.sumAreaForSomeShapes("Triangle")));

        view.showMessage(View.AREA_SORT);
        shapeService.sortByArea(shapeService.getShapes());
        view.showShapes(shapeService.getShapes());

        view.showMessage(View.COLOR_SORT);
        shapeService.sortByColor(shapeService.getShapes());
        view.showShapes(shapeService.getShapes());
    }
}
