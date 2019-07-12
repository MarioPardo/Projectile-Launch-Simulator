package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Projectile
{
    int x; //meters
    int y;
    int radius; //px

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


    ArrayList<double[]> travelPoints = new ArrayList<double[]>();


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


        //max distance
        maxDistance = (flightTime * xvelocity);  //negative makes the answer positive


        //max height
        maxHeight = Math.pow(yvelocity,2) / 19.6;



        //2 dimensions//////////////

        //root2 (landing point)
        root2_2d[0] = maxDistance;  root2_2d[1] = 0;

        vertex[0] = maxDistance/2;
        vertex[1] = maxHeight;

        Grid.drawPoint(vertex);

        calculateTrajectory();



    }


    public double[] getCoordinatesAtTime(double t)
    {
        double height =-4.9 * Math.pow(t,2);
        height = height + yvelocity * t;

        double distance = xvelocity * t;

        double[] coordinates = {distance, height};

        return  coordinates;

    }


    public void calculateTrajectory()
    {
        for(double i = 0; i < flightTime; i += 0.1)
        {
            travelPoints.add(getCoordinatesAtTime(i));
        }

        for(double[] coordinate : travelPoints)
        {
            Grid.drawPoint(coordinate);
        }
    }


  



}
