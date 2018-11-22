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
public class Rectangle extends Shape{
    /**
 * 
 * @param a 
 * this is constructor
 */
    public Rectangle(int a) {
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
    public void setParameter( double x1,double y1,double x2,double y2, int Strock  ,GraphicsContext gc , Color strockColor , Color fillColor ){
        setStrock( Strock );
        /**
         * set all variables
         */
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
        setFillColor(fillColor);
        setStrockColor(strockColor);
        
        /**
         * this all condition is for to draw all shape in all direction
         */
       if( getX2() < getX1() ){
           setX( getX2() );
       }
       else{
           setX( getX1() );
       }
       if( getY2() < getY1() ){
           setY( getY2() );
       }
       else{
           setY( getY1() );
       }
       
        setHeight( Math.abs( getY2() - getY1() ) );
        setWidth(  Math.abs( getX2() - getX1() )  );
        draw( gc );
        
    }
    /**
     * 
     * @param gc 
     * draw  method draw the rectangle
     */
    public void draw( GraphicsContext gc ){
    gc.setLineWidth( getStrock() );
    gc.setStroke( getStrockColor() );
    gc.setFill( getFillColor() );
    gc.strokeRect(getX(), getY() , getWidth() , getHeight() );;
    gc.fillRect(getX(), getY() , getWidth() , getHeight() );
    
    }
}
