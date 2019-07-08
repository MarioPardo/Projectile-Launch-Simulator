package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayPanel extends JPanel implements ActionListener
{
    //project variables such as timer
    Timer timer = new Timer(100, this);


    //objects
    Grid grid = new Grid(0,0);

    Projectile projectile = new Projectile(0,0,30,15);


    public DisplayPanel()
    {

        projectile.calcComponent();


        System.out.println(projectile.xvelocity);
        System.out.println(projectile.yvelocity);

    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        setBackground(Color.white);

        grid.drawGrid(g);
    }

    public void actionPerformed(ActionEvent e)
    {
    repaint();
    }


}
