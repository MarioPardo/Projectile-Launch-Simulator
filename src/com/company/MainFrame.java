package com.company;

import javax.swing.*;

public class MainFrame extends JFrame
{
    DisplayPanel panel = new DisplayPanel();

    public MainFrame(String title)
    {
        super(title);

        add(panel);

    }


}
