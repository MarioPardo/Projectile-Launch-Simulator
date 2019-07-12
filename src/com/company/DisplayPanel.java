package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayPanel extends JPanel implements ActionListener
{
    //project variables such as timer
    Timer timer = new Timer(100, this);
    static Graphics graphics;


    //objects
    Grid grid = new Grid(0,0);

    Projectile projectile = new Projectile(0,0,70,30);


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

        projectile.calculations();

    }

    public void actionPerformed(ActionEvent e)
    {
    repaint();
    }


}
