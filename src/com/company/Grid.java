package com.company;

import java.awt.*;

public class Grid
{
    int widthpx = 1000;
    int heightpx = 1000;

    int heightm = 100;
    int widthm = 100;

    int pixelsToMeters = heightpx / heightm;

    static int x;
    static int y;

    public Grid(int xcoord, int ycoord)
    {
        x = xcoord;
        y = ycoord;
    }

    public static double[] getMeterCoordinates(int xcoord, int ycoord)  //input a pixel on the screen, outputs the corresponding coordinates in meters
    {
        int xx = xcoord - x;
        xx =   xcoord / 10;
        int yy = ycoord - y;
        yy =  (1000 - ycoord)/ 10;

        double[] coords = {xx, yy};
        return coords;
    }

    static public int[] getPixelCoordinates(double xcoord, double  ycoord) //input meter coordinates, outputs the corresponding pixel coordinates
    {
        int xx = (int) xcoord * 10;
        xx += x;
        int yy = (int) Math.round( 1000 - (ycoord * 10));
        yy += y;

        int coords[] = {xx, yy};


        return coords;
    }




    public void drawGrid(Graphics g)
    {
        g.setColor(Color.black);


        g.setFont(new Font("TimesRoman", Font.PLAIN, 10));  //creates new font


        //up and down
        int xcount = x;
        for(int i = 0; i < 11 ; i ++)
        {
           g.drawLine(xcount , y, xcount, heightpx + y);

           if((xcount - x) % 100 == 0)
           {
               g.drawString("" + ((xcount - x ) / 10)  + "m", xcount + 5, heightpx + y - 10);
           }

           xcount += pixelsToMeters * 10;
        }

        //across
        int ycount = y;
        for(int i = 0; i < 11; i ++)
        {
            g.drawLine(x, ycount, widthpx + x, ycount);
            if((ycount - y) % 100 == 0)
            {
                g.drawString("" + (((1000- ycount)/10 ) + 5) + "m", 10, ycount);
            }
            ycount += pixelsToMeters * 10;
        }

        g.fillRect(widthpx + x,heightpx + y, 20, 20);



    }


    static public void drawPoint(double[] coordinateArray) //coordinates in meters
    {
        Graphics g = DisplayPanel.graphics;

        int[] coordinates = getPixelCoordinates(coordinateArray[0],coordinateArray[1]);

        g.fillOval(coordinates[0], coordinates[1], 5, 5 );


    }



}
