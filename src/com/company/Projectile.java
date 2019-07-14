package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Projectile
{
    double time = 0;

    //pixels
    int x = 0;
    int y = 0;
    int diameter = 20;

    //meters
    double x_m;
    double y_m;

    int angle;
    double velocity;

    double yvelocity;
    double xvelocity;

    //1dimension
    double flightTime;
    double maxHeight;
    double maxDistance;


    //2dimension
    double[] root2_2d = new double[2];
    double[] vertex = new double[2];


    static ArrayList<double[]> travelPoints = new ArrayList<double[]>();


    int height; //how many m from ground
    int distance; //how much distance from starting point

    public Projectile(int xcoord, int ycoord, int anglee, double velocityy)
    {
        x = xcoord;
        y = ycoord;

        angle = anglee;
        velocity = velocityy;
    }

    public void calcComponent()
    {
        yvelocity = (velocity * (Math.sin(Math.toRadians(angle))));
        xvelocity = (velocity * Math.cos(Math.toRadians(angle))); //cos expects radians


    }

    public void calculations()
    {

        //1 dimenstions////////////////

        //flight time
        double root1 = -yvelocity + Math.sqrt((Math.pow(yvelocity, 2) - (4 * -4.9)));  //polus
        root1 = root1 / -9.8;


        double root2 = -yvelocity - Math.sqrt((Math.pow(yvelocity, 2) - (4 * -4.9)));  //minus
        root2 = root2 / -9.8;


        flightTime  = root2  + root1;  //not exact, rounding issues, likely
        flightTime = Math.floor(flightTime * 10000)/ 10000;
        System.out.println("Flight Time is : " + flightTime);


        //max distance
        maxDistance = (flightTime * xvelocity);  //negative makes the answer positive
        maxDistance = Math.floor(maxDistance * 10000)/ 10000;
        System.out.println("Max Distance is  : " + maxDistance);


        //max height
        maxHeight = Math.pow(yvelocity,2) / 19.6;
        maxHeight = Math.floor(maxHeight * 10000) / 10000;
        System.out.println("Max Height is  : " + maxHeight);



        //2 dimensions//////////////

        //root2 (landing point)
        root2_2d[0] = maxDistance;  root2_2d[1] = 0;

        vertex[0] = maxDistance/2;
        vertex[1] = maxHeight;


        calculateTrajectory();



    }


    public double[] getCoordinatesAtTime(double t) //meters
    {
        double height =-4.9 * Math.pow(t,2);
        height = height + yvelocity * t;

        height = Math.floor(height * 10000)/10000;

        double distance = xvelocity * t;
        distance = Math.floor(distance * 10000)/10000;

        double[] coordinates = {distance, height};

        return  coordinates;

    }


    public void calculateTrajectory()
    {
        for(int i = 0; i <= flightTime * 10000; i ++)  //int because using double or float gave weird inaccuracies
        {
           float f = i / 10000f;
           travelPoints.add(getCoordinatesAtTime(f));


        }


    }

    public void setCoordinates(int xcoord, int ycoord)
    {
        x = xcoord;
        y = ycoord;

        double[] mcoords = getCoordinatesAtTime(time);

        x_m = mcoords[0];
        y_m = mcoords[1];



    }


    public void drawBall(Graphics g)
    {

        g.setColor(Color.black); //border
        g.drawOval(x - diameter/2, y - diameter, diameter, diameter);
        g.setColor(Color.red); //ball
        g.fillOval(x - diameter/2, y- diameter, diameter , diameter);

        //Over the ball
        g.drawString("X: " + x_m, x, y - diameter - 10);
        g.drawString("Y: " + y_m, x, y - diameter - 20);



    }



}
