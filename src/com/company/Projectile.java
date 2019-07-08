package com.company;

public class Projectile
{
    int x;
    int y;
    int radius;

    int angle;
    double velocity;

    double yvelocity;
    double xvelocity;


    int height; //how many m from ground
    int distance; //how much distance from starting point

    public Projectile(int xcoord, int ycoord, int anglee, int velocityy)
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
}
