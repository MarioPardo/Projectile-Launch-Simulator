package com.company;

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

    Projectile projectile = new Projectile(0,0,60,20);


    public DisplayPanel()
    {
    timer.start();

    projectile.calcComponent();



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
            projectile.drawBall(graphics);
        }


    }



}
