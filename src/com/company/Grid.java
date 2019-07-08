package com.company;

import java.awt.*;

public class Grid
{
    int widthpx = 1000;
    int heightpx = 1000;

    int heightm = 100;
    int widthm = 100;

    int pixelsToMeters = heightpx / heightm;

    int x;
    int y;

    public Grid(int xcoord, int ycoord)
    {
        x = xcoord;
        y = ycoord;
    }

    public int[] getMeterCoordinates(int xcoord, int ycoord)
    {
        //for x   coord / 10;

        //for y (1000 - coord)/ 10;

    return null;
    }

    public int[] getPixelCoordinates(int x, int y)
    {
        //reverse the above

        return null;
    }




    public void drawGrid(Graphics g)
    {
        g.setColor(Color.black);


        g.setFont(new Font("TimesRoman", Font.PLAIN, 10));  //creates new font



        //up and down
        int xcount = x;
        for(int i = 0; i < 11 ; i ++)
        {
           g.drawLine(xcount, y, xcount, heightpx + y);

           if(xcount % 100 == 0)
           {
               g.drawString("" + (xcount / 10) + "m", xcount, 990);
           }

           xcount += pixelsToMeters * 10;
        }

        //across
        int ycount = y;
        for(int i = 0; i < 11; i ++)
        {
            g.drawLine(x, ycount, widthpx + x, ycount);
            if(ycount % 100 == 0)
            {
                g.drawString("" + ((1000 - ycount)/ 10) + "m", 10, ycount);
            }
            ycount += pixelsToMeters * 10;
        }

        g.fillRect(widthpx + x,heightpx + y, 20, 20);



    }


}
