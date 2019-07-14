package com.company;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayPanel extends JPanel implements ActionListener
{
    //project variables such as timer
    Timer timer = new Timer(1, this);
    static Graphics graphics;
    int frame = 0;

    //objects
    Grid grid = new Grid(50,50);

    Projectile projectile = new Projectile(0,0,50,10);


    public DisplayPanel()
    {
    timer.start();

    projectile.calcComponent();

    grid.widthm = 10;
    grid.heightm = 10;



    }


    public void paintComponent(Graphics g)
    {
        graphics = g;

        super.paintComponent(g);

        setBackground(Color.white);

        grid.drawGrid(g);

        if(frame == 0)
        {
            projectile.calculations();
        }

        animateBall();

       frame += 20;

       drawStats(g);

    }

    public void actionPerformed(ActionEvent e)
    {
    repaint();
    }

    public void animateBall()
    {
        if(frame <= projectile.travelPoints.size() - 1)
        {
            double[] array = projectile.travelPoints.get(frame);

            int[] coordinates = Grid.getPixelCoordinates(array[0], array[1]);

            projectile.time += 0.0020;


           projectile.setCoordinates(coordinates[0],coordinates[1]);

            projectile.drawBall(graphics);
        }else
        {
           projectile.y_m = 0;
           projectile.x_m = projectile.maxDistance;


            projectile.drawBall(graphics);
        }


    }

    public void drawStats(Graphics g)
    {

        g.setColor(Color.white);
        g.fillRect(Grid.x + grid.widthpx + 50, 0, 1400, 1200); //white background so that if ball goes over it's not displayed

        g.setColor(Color.black);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));  //creates new font

        g.drawString("Calculations", 1100, 80);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));  //creates new font

        g.drawString("Flight Time:" + projectile.flightTime + "s", 1100, 180);
        g.drawString("Max Height:" + projectile.maxHeight + "m", 1100, 260);
        g.drawString("Distance:" + projectile.maxDistance + "m", 1100, 340);

    }




}
