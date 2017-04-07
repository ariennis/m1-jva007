package com.luxoft.basics.part2.xtasks;

import javax.swing.*;
import java.awt.*;

public class T2_TanksMoveForever extends JPanel
{
    int tankX = 0;
    int tankY = 0;
    int cell_width = 64;
    int cell_height = 64;
    int field_sizeX=9;
    int field_sizeY=9;

    void runTheGame()
    {
        while (true)
        {
            while (tankX < BF_WIDTH - cell_width)
            {
                moveForward();
            }
            while (tankX > 0)
            {
                moveBackward();
            }
        }

        // TODO YOUR CODE HERE

    }

    void moveForward()
    {

        tankX++;
        if (tankX%cell_width==0)
        { repaint();
        sleep(500);}
        else { repaint();
            sleep(10);}

        // TODO YOUR CODE HERE
    }
    void moveBackward()
    {
        tankX--;

        if (tankX%cell_width==0)
        { repaint();
            sleep(500);}
        else { repaint();
            sleep(10);}

        // TODO YOUR CODE HERE
    }


    String getTankQuadrant(int x, int y)
    {
        // TODO YOUR CODE HERE
        String s="abcdefghi";
        int xplace=x/cell_width;
        int yplace=y/cell_height+1;
        char lp=s.charAt(xplace);
        String place=lp+"_"+yplace;
        // System.out.println(place);
        return place;
    }

    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    public static void main(String[] args) throws Exception
    {
        T2_TanksMoveForever bf = new T2_TanksMoveForever();
        bf.runTheGame();
    }

    public T2_TanksMoveForever() throws Exception
    {
        JFrame frame = new JFrame("MOVE TANK FORWARD");
        frame.setLocation(500, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH+30, BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    void sleep(int millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {

        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        paintBF(g);

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tankX, tankY, 64, 64);
    }

    private void paintBF(Graphics g)
    {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++)
        {
            for (int h = 0; h < 9; h++)
            {
                if (i % 2 == 0)
                {
                    cc = new Color(252, 241, 177);
                }
                else
                {
                    cc = new Color(233, 243, 255);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }
    }

}