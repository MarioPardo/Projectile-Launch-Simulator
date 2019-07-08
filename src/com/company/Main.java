package com.company;

import javax.swing.*;

public class Main {

   public static MainFrame Frame = new MainFrame("Projectile Launch!");

    public static void main(String[] args)
    {


        Frame.setSize(1200,1200);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setVisible(true);
    }
}
