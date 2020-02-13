package com.github.fx;

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
            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            canvas.getGraphicsContext2D().strokePolygon(new double[]{x, x, event.getX(), event.getX()},
                    new double[]{y, event.getY(), event.getY(), y}, 4);
        }
        if (MouseEvent.MOUSE_RELEASED.equals(eventType)) {
            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            scalable.scale(Math.min(x, event.getX()), Math.max(x, event.getX()), Math.min(y, event.getY()), Math.max(y, event.getY()));
        }
    }

    public interface Scalable {
        void scale(double x1, double x2, double y1, double y2);
    }
}
