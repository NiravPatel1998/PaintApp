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
public abstract class Shape {
    /**
     * all are private variable
     */
    private double  x , y , redius , height , width , x1, x2 , y1, y2 ,midX,midY;
    private int a = 0; 
    private int strock;
    private Color strockColor = Color.BLUE , fillColor = Color.LIGHTBLUE;
    /**
     * 
     * @return X coordinate of the center of the circle
     */
    public double getMidX() {
        return midX;
    }
    /**
     * 
     * @param midX sets the value of x coordinate of the center point of circle
     */
    public void setMidX(double midX) {
        this.midX = midX;
    }
    /**
     * 
     * @return X coordinate of the center of the circle
     */
    public double getMidY() {
        return midY;
    }
    /**
     * 
     * @param midY sets the value of y coordinate of the center point of circle
     */
    public void setMidY(double midY) {
        this.midY = midY;
    }
    
    /**
     * Constructor set the value of a, which indicates the shape 1 for circle, 2 for rectangle , 3 for line
     * @param a 
     */
    public Shape(int a){
    
    this.a = a;
    }
    /**
     * return first x coordinate of current shape.
     * @return 
     */
    public double getX1() {
        return x1;
    }
    /**
     * sets first x coordinate of current shape.
     * @param x1 
     */
    public void setX1(double x1) {
        this.x1 = x1;
    }
    /**
     * indiates the type of shape by int a, 1 for circle, 2 for rectangle , 3 for line
     * @return 
     */
    public int getA() {
        return a;
    }
    /**
     * sets the type of object by integer, 1 for circle, 2 for rectangle , 3 for line
     * @param a 
     */
    public void setA(int a) {
        this.a = a;
    }
    /**
     * 
     * @return last x2 coordinate of current shape.
     */
    public double getX2() {
        return x2;
    }
    /**
     * 
     * @param sets last x2 coordinate of current shape.
     */
    public void setX2(double x2) {
        this.x2 = x2;
    }
    /**
     * 
     * @return first y1 coordinate of current shape.
     */
    public double getY1() {
        return y1;
    }
    /**
     * 
     * @param sets last y1 coordinate of current shape.
     */
    public void setY1(double y1) {
        this.y1 = y1;
    }
    /**
     * 
     * @return last y2 coordinate of current shape.
     */
    public double getY2() {
        return y2;
    }
    /**
     * 
     * @param  sets last y2 coordinate of current shape.
     */
    public void setY2(double y2) {
        this.y2 = y2;
    }
    
    /**
     * 
     * @return strock color
     */
    public Color getStrockColor() {
        return strockColor;
    }
    /**
     * set strock color
     * @param strockColor 
     */
    public void setStrockColor(Color strockColor) {
        this.strockColor = strockColor;
    }
    /**
     * 
     * @return fill color
     */
    public Color getFillColor() {
        return fillColor;
    }
    /**
     * 
     * @param fillColor to set fillcolor
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
    /**
     * 
     * @return X value 
     */
    public double getX() {
        return x;
    }
/**
 * 
 * @param x  set the value that is given by the user
 */
    public void setX(double x) {
        this.x = x;
    }
/**
 * 
 * @return Y value 
 */
    public double getY() {
        return y;
    }
    /**
     * 
     * @param set the Y parameter in double
     */

    public void setY(double y) {
        this.y = y;
    }
/**
 * 
 * @return the redius of the circle 
 */
    public double getRedius() {
        return redius;
    }
    /**
     * 
     * @param set the redius parameter
     */

    public void setRedius(double redius) {
        this.redius = redius;
    }
/**
 * 
 * @return height value
 */
    public double getHeight() {
        return height;
    }
/**
 * 
 * @param  set the value of height  
 */
    public void setHeight(double height) {
        this.height = height;
    }
/**
 * 
 * @return width value 
 */
    public double getWidth() {
        return width;
    }
    /**
     * 
     * @param set the value of width 
     */

    public void setWidth(double width) {
        this.width = width;
    }
/**
 * 
 * @return strock value in integer
 */
    public int getStrock() {
        return strock;
    }
/**
 * 
 * @param set the value for the strock 
 */
    public void setStrock(int strock) {
        this.strock = strock;
    }
    /**
     * Set the all parameter in the setParameter method
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param Strock
     * @param gc
     * @param strockColor
     * @param fillColor 
     */
    public abstract void setParameter( double x1,double y1,double x2,double y2 , int Strock ,GraphicsContext gc, Color strockColor , Color fillColor );
    public void draw( GraphicsContext gc ){}//This is draw  method which is in the shape class
}
