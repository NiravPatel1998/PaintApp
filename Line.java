/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.app;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author nirav
 */
public class Line extends Shape{
   /**
 * 
 * @param a  
 * constructor
 */
    public Line(int a) {
        super(a);
    }
/**
 * 
 * @param x1
 * @param y1
 * @param x2
 * @param y2
 * @param Strock
 * @param gc
 * @param strockColor
 * @param fillColor 
 */
    @Override
    public void setParameter(double x1, double y1, double x2, double y2, int Strock, GraphicsContext gc  , Color strockColor , Color fillColor) {
     
        setStrockColor(strockColor);
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
       gc.setStroke(getStrockColor());
       gc.setLineWidth( getStrock());
       gc.strokeLine(getX1(), getY1(), getX2(), getY2());
    }
     
}
