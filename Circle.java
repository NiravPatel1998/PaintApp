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
public class Circle extends Shape{
     double x,y,redius;
/**
 * 
 * @param a 
 * constructor of circle
 */
    public Circle(int a) {
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
    public void setParameter( double x1,double y1,double x2,double y2 , int Strock ,GraphicsContext gc , Color strockColor , Color fillColor  ){
        setStrock( Strock );
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
        setFillColor(fillColor);
        setStrockColor(strockColor);
        //setRedius( Math.sqrt( ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)) ) /2);
        x = getX1() + (getX2() - getX1()) / 2;
        y = getY1() + (getY2() - getY1()) / 2;
        setMidX((getX2() - getX1()) / 2);
       setMidY((getY2() - getY1()) / 2);
        redius = Math.sqrt(((getX2() - getX1()) * (getX2() - getX1())) + ((getY2() - getY1()) * (getY2() - getY1())));
        setRedius(redius / 2);
        setX(x);
        setY(y);
        draw(gc);
        
        
    }
    /**
     * 
     * @param gc 
     * draw method for circle
     */
    public void draw( GraphicsContext gc ){
    gc.setLineWidth( getStrock() );
    gc.setStroke( getStrockColor() );
    gc.setFill( getFillColor() );
    gc.strokeOval(getX() - getRedius() , getY() - getRedius(), getRedius() *2, getRedius() *2 );;
    gc.fillOval(getX() - getRedius() , getY() - getRedius() , getRedius() * 2, getRedius() * 2 );
    
    }
}
