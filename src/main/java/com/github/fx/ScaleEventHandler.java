package com.github.fx;

import com.github.global_coefficients.CanvasProperties;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;


public class ScaleEventHandler implements EventHandler<MouseEvent> {
    private Scalable scalable;
    private Canvas canvas;
    private double x;
    private double y;

    public ScaleEventHandler(Scalable scalable, Canvas canvas) {
        this.scalable = scalable;
        this.canvas = canvas;
    }

    @Override
    public void handle(MouseEvent event) {
        EventType<? extends MouseEvent> eventType = event.getEventType();
        if (MouseEvent.MOUSE_PRESSED.equals(eventType)) {
            x = event.getX();
            y = event.getY();
        }
        if (MouseEvent.MOUSE_DRAGGED.equals(eventType)) {
            double eventX = event.getX();
//            double eventY = event.getY();
            // (y2-y1)/(x2-x1) = k = CANVAS_DIAGONAL_FACTOR
            double fixedY = CanvasProperties.CANVAS_DIAGONAL_FACTOR * (eventX - x) + y;
            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            canvas.getGraphicsContext2D().strokePolygon(new double[]{x, x, eventX, eventX},
                    new double[]{y, fixedY, fixedY, y}, 4);
        }
        if (MouseEvent.MOUSE_RELEASED.equals(eventType)) {
            double eventX = event.getX();
//            double eventY = event.getY();
            // (y2-y1)/(x2-x1) = k = CANVAS_DIAGONAL_FACTOR
            double fixedY = CanvasProperties.CANVAS_DIAGONAL_FACTOR * (eventX - x) + y;
            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            scalable.scale(Math.min(x, eventX), Math.max(x, eventX), Math.min(y, fixedY), Math.max(y, fixedY));
        }
    }

    public interface Scalable {
        void scale(double x1, double x2, double y1, double y2);
    }
}
