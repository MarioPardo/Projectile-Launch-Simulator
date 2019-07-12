package com.company;

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

    ArrayList travelPoints = new ArrayList();


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

        //equation is -4.9T^2 + yvelocity*t + initialHeight

        //1 dimenstions////////////////

        //flight time
        double root1 = -yvelocity + Math.sqrt((Math.pow(yvelocity, 2) - (4 * -4.9)));  //polus
        root1 = root1 / -9.8;


        double root2 = -yvelocity - Math.sqrt((Math.pow(yvelocity, 2) - (4 * -4.9)));  //minus
        root2 = root2 / -9.8;


        flightTime  = root2  + root1;  //not exact, rounding issues, likely
        System.out.println("Flight time is "+ flightTime);


        //max distance
        maxDistance = (flightTime * xvelocity);  //negative makes the answer positive
        System.out.println("Max Distance is " + maxDistance);


        //max height
        maxHeight = Math.pow(yvelocity,2) / 19.6;
        System.out.println("Max Height is " +  maxHeight);



        //2 dimensions//////////////

        //root2 (landing point)
        root2_2d[0] = maxDistance;  root2_2d[1] = 0;

        vertex[0] = maxDistance/2;
        vertex[1] = maxHeight;

        Grid.drawPoint(vertex);


    }

    public void getYDistanceAtTime(double t)
    {

    }

    public void getXDistanceAtTime(double t)
    {

    }

}
