/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.app;

import javafx.application.Application;
import java.awt.Desktop.Action;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 *
 * @author nirav
 */
public class PaintApp extends Application{
     // TODO: Instance Variables for View Components and Model
    /**
     * declare the all parameter
     */
    
    int strock;
    int a = 0;
    boolean primary = false;
    Shape s, selectShape;
    GraphicsContext gc;
    Canvas c;
    ArrayList<Shape> sList = new ArrayList<Shape>();//this is Arraylist
    Shape selectS;
    
    /**
     * create colorPicker
     */
    ColorPicker colorPicker1 = null, colorPicker2 = null;  
    private double x1, x2, y1, y2, selectX, selectY, rx2, rx3;
    TextField txtStrock; // declare textField
    Button btnCircle, btnRectangle, btnLine, btnClear, btnUndo, btnDelete;
    
    /**
     * all are label for the instruction
     */
    Label l1, l2, l3, l4, l5, l6,l7,l8,l9;  
    ArrayList<GraphicsContext> al = new ArrayList<GraphicsContext>();

    
    /**
     *
     * @param me
     * this is pressHandler when user click in the canvas area 
     */
    
    private void PressHandler(MouseEvent me) {

        /**
         * This is a exceptionHandling to check the strock value which is passed
         * or not. if the strock value is not passed then the exception will be
         * popup as a alert.
         */
        try {

            strock = Integer.parseInt(txtStrock.getText());
            /**
             * get the X and Y value from using the getX and getY method.
             */
            
            x1 = me.getX();
            y1 = me.getY();
            /**
             * check the which key is clicked by user and check that was primaryButtonDown or secoundry key 
             */
            
            if (me.isPrimaryButtonDown()) {
                primary = true;
                selectShape = null;
                /**
                 * create all object of all the shape depend on the value 
                 * If a is 1 then it willl create the object of the circle
                 */
                
                if (a == 1) {
                    s = new Circle(a);

                } 
                /**
                * If a is 2 then it will create the object of the Rectangle
                */
                
                else if (a == 2) {
                    s = new Rectangle(a);
                }
                /**
                 * If a is 3 then it will create the object of the Line
                 */

                else {
                    s = new Line(a);
                }
            }
        } 
        /**
         * this is catch which is throw the exception for the number fromate exception 
         */

        catch (NumberFormatException e) {
            new Alert(Alert.AlertType.WARNING, "Please Enter Stroke size").showAndWait();//Give the alert and show the popup box 
        }

    }
    /**
     * 
     * @param me 
     * this is the release handler when user release the button and shape is draw
     */
    

    private void ReleseHandler(MouseEvent me) {

        if (x1 != me.getX()) {
            /**
             * this is list and all object add in the sList
             */
           

            sList.add(s);

        }
        /**
         * print the sList in console
         */
        
        System.out.println(sList);

    }
    /**
     * 
     * @param me 
     * this is the drag handler when user draw any shape then the all shape drag with the drag process
     */


    private void DraggedHandler(MouseEvent me) {
        try {

            x2 = me.getX();
            y2 = me.getY();
            /**
             * check the primary button clicked or not
             */
            

            if (primary == true) {
                /**
                 *set all parameter  in the supper class 
                 */
                
                s.setParameter(x1, y1, x2, y2, Integer.parseInt(txtStrock.getText()), gc, colorPicker1.getValue(), colorPicker2.getValue());
                gc.setFill(Color.MINTCREAM);
                gc.fillRect(0, 0, 1100, 500);
                /**
                 * this for loop draw again whole screen 
                 */
                
                for (Shape temp : sList) {
                    temp.setParameter(temp.getX1(), temp.getY1(), temp.getX2(), temp.getY2(), temp.getStrock(), gc, temp.getStrockColor(), temp.getFillColor());
                }
            }
            s.setParameter(x1, y1, x2, y2, Integer.parseInt(txtStrock.getText()), gc, colorPicker1.getValue(), colorPicker2.getValue());
        } catch (NumberFormatException e) {

        }

    }
    /**
     * 
     * @param me 
     * This is the circleHandler which is create the circle object
     */


    private void CircleHandler(ActionEvent me) {
        a = 1;
        s = new Circle(a);

    }
    /**
     * 
     * @param me 
     * This is the RectangleHandler which is create the circle object
     */


    private void RectanglerHandler(ActionEvent me) {
        a = 2;
        s = new Rectangle(a);

    }
    
    /**
     * 
     * @param me 
     * This is the LineHandler which is create the Line object
     */


    private void LineHandler(ActionEvent me) {
        a = 3;
        s = new Line(a);

    }
    /**
     * 
     * @param me 
     * this is a clearHandler which is clear all object from the canvas and clear the screen
     */


    private void ClearHandler(ActionEvent me) {
        gc.setFill(Color.MINTCREAM);
        gc.fillRect(0, 0, 1100, 500);
        sList.removeAll(sList);
    }
    /**
     * 
     * @param me 
     * this UndoHandler is worked as a remove all object from the last object
     */


    private void UndoHandler(ActionEvent me) {
        try {
            /**
             * remove the last object using this formula
             */
            sList.remove(sList.size() - 1);
            gc.setFill(Color.MINTCREAM);
            gc.fillRect(0, 0, 1100, 500);

            /**
             * Draw all shape again using this loop
             */
            
            for (Shape temp : sList) {
                temp.setParameter(temp.getX1(), temp.getY1(), temp.getX2(), temp.getY2(), temp.getStrock(), gc, temp.getStrockColor(), temp.getFillColor());
            }
            System.out.println(sList);

        }
        /**
         * this exception will occur when there is no any object in the screen or screen is clear
         */
        
        catch (ArrayIndexOutOfBoundsException e) {
            new Alert(Alert.AlertType.WARNING, "There is no any shape").showAndWait();//this give alert and show the popup box
        }
    }
    /**
     * 
     * @param me 
     * select handler select the any object when user clicked on the object 
     */


    private void SelectHandler(MouseEvent me) {
        /**
         * first it will check the clicked button is secondary or not. if that is primary then it will not go inside
         */
        
        if (me.isPrimaryButtonDown() == false) {
            selectShape = null;
            
            /**
             * this variables set the value depend on the selected object
             */
            
            selectX = me.getX();
            selectY = me.getY();

            for (Shape temp : sList) {
                if (((selectX < temp.getX2() && selectX > temp.getX1()) || (selectX < temp.getX1() && selectX > temp.getX2())) && ((selectY < temp.getY2() && selectY > temp.getY1()) || (selectY < temp.getY1() && selectY > temp.getY2())) || (Math.sqrt(((temp.getMidX() - me.getX()) * (temp.getMidX() - me.getX())) + ((temp.getMidY() - me.getY()) * (temp.getMidY() - me.getY()))) < temp.getRedius() || (Math.sqrt(((temp.getX2() - me.getX()) * (temp.getX2() - me.getX())) + ((temp.getY2() - me.getY()) * (temp.getY2() - me.getY())))) == Math.sqrt(((temp.getX2() - temp.getX1()) * (temp.getX2() - temp.getX1())) + ((temp.getY2() - temp.getY1()) * (temp.getY2() - temp.getY1()))))) {

                    selectShape = temp;

                }

            }

            for (Shape temp : sList) {
                temp.setParameter(temp.getX1(), temp.getY1(), temp.getX2(), temp.getY2(), temp.getStrock(), gc, temp.getStrockColor(), temp.getFillColor());
            }
            /**
             * if the shape is selected then the strock will be black
             */
            
            if (selectShape != null) {

                gc.setStroke(Color.BLACK);
                if (selectShape instanceof Rectangle) {
                    if (selectShape.getX2() < selectShape.getX1()) {
                        selectShape.setX(selectShape.getX2());
                    } else {
                        selectShape.setX(selectShape.getX1());
                    }
                    if (selectShape.getY2() < selectShape.getY1()) {
                        selectShape.setY(selectShape.getY2());
                    } else {
                        selectShape.setY(selectShape.getY1());
                    }
                    gc.strokeRect(selectShape.getX(), selectShape.getY(), selectShape.getWidth(), selectShape.getHeight());

                } else if (selectShape instanceof Circle) {
                    gc.strokeOval(selectShape.getX() - selectShape.getRedius(), selectShape.getY() - selectShape.getRedius(), selectShape.getRedius() * 2, selectShape.getRedius() * 2);;

                } else {
                    gc.setStroke(Color.RED);
                    gc.strokeLine(selectShape.getX1(), selectShape.getY1(), selectShape.getX2(), selectShape.getY2());
                }
            }
          //  sList.remove(selectShape);

        }

    }

    /**
     * 
     * @param me 
     * this is the deleteHandler when the user select object and click on the delete button
     */
    private void deleteHandler(ActionEvent me) {
        try {
            boolean checkNull = selectShape.equals(null);
            sList.remove(selectShape);
            gc.setFill(Color.MINTCREAM);
            gc.fillRect(0, 0, 1100, 500);
            for (Shape temp : sList) {
                temp.setParameter(temp.getX1(), temp.getY1(), temp.getX2(), temp.getY2(), temp.getStrock(), gc, temp.getStrockColor(), temp.getFillColor());
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "Please select object").showAndWait();
        }

    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        /**
        *set the scene area
        */
        Scene scene = new Scene(root, 1100, 700);
        
        // Set canvas Size in Pixels
        stage.setTitle("Paint App"); // Set window title

        stage.setScene(scene);

        // TODO: Add your GUI-building code here
        // 1. Create the model
        colorPicker1 = new ColorPicker(Color.RED);
        colorPicker2 = new ColorPicker(Color.BLUE);
        txtStrock = new TextField();
        btnCircle = new Button("Circle");
        btnRectangle = new Button("Rectangle");
        btnLine = new Button("Line");
        btnClear = new Button("Clear");
        btnUndo = new Button("Undo");
        btnDelete = new Button("Delete");
        l1 = new Label("**INSTRUCTION**");
        l2 = new Label("->Enter a stroke size to draw a object");
        l3 = new Label("->Right mouse click to select object");
        l4 = new Label("->Click on clear button to clear the screen");
        l5 = new Label("->Delete button click to delete selected object");
        l6 = new Label("->Please select object before delete");
        l7 = new Label("Border color");
        l8 =  new Label(" Fill color ");
        l9 =  new Label("Stroke Size");

        // 2. Create the GUI components
        c = new Canvas(1100, 500);
        gc = c.getGraphicsContext2D();
        // 3. Add components to the root
        root.getChildren().addAll(c, txtStrock, btnCircle, btnRectangle, btnClear, btnUndo, btnLine, colorPicker1, colorPicker2, l1, l2, l3, l4, l5, l6,l7,l8,l9, btnDelete);

        // 4. Configure the components (colors, fonts, size, location)
        gc.setFill(Color.MINTCREAM);
        gc.fillRect(0, 0, 1100, 500);
        gc.setStroke(Color.BLUE);
        /**
         * Set line between canvas and under view
         */
        gc.strokeLine(0, 500, 1100, 500);
        gc.setLineWidth(10);
        gc.setStroke(Color.BLUE);

        gc.strokeLine(0, 500, 1100, 500);
        /**
         * circle button set with the design 
         */
        btnCircle.relocate(0, 530);
        btnCircle.setPrefWidth(80);
        btnCircle.setPrefHeight(30);
        btnCircle.setStyle("-fx-background-color: lightpink;-fx-text-fill:darkblue;");
        btnCircle.setStyle("-fx-font: 18 arial ; \n"
                + "    \n"
                + "   -fx-border-color: rgb(49, 89, 23);");
        
        /**
         * set the button rectangle and design the view
         */
        btnRectangle.relocate(110, 530);
        btnRectangle.setPrefWidth(80);
        btnRectangle.setPrefHeight(30);
        btnRectangle.setStyle("-fx-background-color:lightpink;-fx-text-fill:darkblue;");
        btnRectangle.setStyle("-fx-font: 18 arial ; \n"
                + "   \n"
                + "   -fx-border-color: rgb(49, 89, 23);");
        /**
         * set the button line and design view
         */
        btnLine.relocate(220, 530);
        btnLine.setPrefWidth(80);
        btnLine.setPrefHeight(30);
        btnLine.setStyle("-fx-background-color: lightpink;-fx-text-fill:darkblue;");
        btnLine.setStyle("-fx-font: 18 arial ; \n"
                + " \n"
                + " -fx-border-color: rgb(49, 89, 23);");
        /**
         * clear button and set the design view 
         */
        btnClear.relocate(450, 530);
        btnClear.setPrefWidth(80);
        btnClear.setPrefHeight(30);
        btnClear.setStyle("-fx-background-color: lightpink;-fx-text-fill:darkblue;");
        btnClear.setStyle("-fx-font: 18 arial ; \n"
                + "  \n"
                + "   -fx-border-color: rgb(49, 89, 23);");
        
         /**
         * undo button and set the design view 
         */
        btnUndo.relocate(570, 530);
        btnUndo.setPrefWidth(80);
        btnUndo.setPrefHeight(30);
        btnUndo.setStyle("-fx-background-color: lightpink;-fx-text-fill:darkblue;");
        btnUndo.setStyle("-fx-font: 18 arial ; \n"
                + "   \n"
                + "   -fx-border-color: rgb(49, 89, 23);");
        /**
         * set the text field and background color 
         */
        txtStrock.relocate(300, 600);
        txtStrock.setPrefWidth(80);
        txtStrock.setPrefHeight(30);
        txtStrock.setStyle("-fx-background-color: lightpink;-fx-text-fill:darkblue;");
        l9.relocate(300, 630);
        l9.setFont(new Font(15));
        l9.setStyle("-fx-text-fill:blue;");

       /**
        * delete button 
        */
        btnDelete.relocate(500, 600);
        btnDelete.setPrefWidth(80);
        btnDelete.setPrefHeight(30);
        btnDelete.setStyle("-fx-font: 18 arial ;\n"
                + " \n"
                + "-fx-border-color: rgb(49, 89, 23);");
        /**
         * next two are colorpicker 
         */
        colorPicker1.relocate(20, 600);
        colorPicker1.setPrefWidth(80);
        colorPicker1.setPrefHeight(30);
        colorPicker1.setStyle("-fx-font: 18 arial ; \n"
                + "   \n"
                + "-fx-border-color: rgb(227, 236, 237);");
        l7.relocate(20, 630);
        l7.setFont(new Font(13));
        l7.setStyle("-fx-text-fill:blue;");

        colorPicker2.relocate(140, 600);
        colorPicker2.setPrefWidth(80);
        colorPicker2.setPrefHeight(30);
        
        
        colorPicker2.setStyle("-fx-font: 18 arial ; \n"
                + "   ;\n"
               + "   -fx-border-color: rgb(227, 236, 237);");
        l8.relocate(140, 630);
        l8.setFont(new Font(15));
        l8.setStyle("-fx-text-fill:blue;");
        
        
        /**
        * next all l1,l2,l3,l4,l5,l6 are the instruction label
        */
        l1.relocate(690, 510);
        l1.setFont(new Font(20));
        l1.setStyle("-fx-text-fill:red;");

        l2.relocate(690, 550);
        l2.setFont(new Font(15));
        l2.setStyle("-fx-text-fill:blue;");

        l3.relocate(690, 590);
        l3.setFont(new Font(15));
        l3.setStyle("-fx-text-fill:blue;");

        l4.relocate(690, 630);
        l4.setFont(new Font(15));
        l4.setStyle("-fx-text-fill:blue;");

        l5.relocate(690, 670);
        l5.setFont(new Font(15));
        l5.setStyle("-fx-text-fill:blue;");

        l6.relocate(690, 710);
        l6.setFont(new Font(15));
        l6.setStyle("-fx-text-fill:blue;");

        // 5. Add Event Handlers and do final setup
        c.addEventHandler(MouseEvent.MOUSE_PRESSED, this::PressHandler);
        c.addEventHandler(MouseEvent.MOUSE_RELEASED, this::ReleseHandler);
        c.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::DraggedHandler);
        c.addEventHandler(MouseEvent.MOUSE_CLICKED, this::SelectHandler);
        btnCircle.addEventHandler(ActionEvent.ACTION, this::CircleHandler);
        btnRectangle.addEventHandler(ActionEvent.ACTION, this::RectanglerHandler);
        btnLine.addEventHandler(ActionEvent.ACTION, this::LineHandler);
        btnClear.addEventHandler(ActionEvent.ACTION, this::ClearHandler);
        btnUndo.addEventHandler(ActionEvent.ACTION, this::UndoHandler);
        btnDelete.addEventHandler(ActionEvent.ACTION, this::deleteHandler);
        // 6. Show the stage

        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
}
