package com.luxoft.basics.part3.xtasks;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class T3_TanksFire extends JPanel
{

    final boolean COLORED_MODE = false;
    final boolean IS_GRID = true;

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    // 1 - top, 2 - right, 3 - down, 4 - left
    int tankDirection = 3;

    int tankX = 128;
    int tankY = 512;

    int bulletX = -100;
    int bulletY = -100;

    int cell_width = 64;
    int cell_height = 64;


    int tankSpeed = 10;
    int bulletSpeed = 5;

    final String BRICK = "B";
    final String BLANK = " ";

    String[][] battleField = {
            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
            {" ", " ", " ", " ", " ", " ", " ", " ", "B"},
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", "B", "B", " ", " ", " ", "B", "B", "B"},
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", "B", " ", "B", "B", "B", " ", "B", "B"},
            {"B", "B", " ", " ", " ", " ", " ", "B", "B"},
            {"B", " ", " ", "B", "B", "B", " ", " ", "B"},
            {"B", " ", " ", "B", "B", "B", " ", " ", "B"}
    };

    void runTheGame() throws Exception
    {
        printCurrentBattleField();

        while (true)
        {
            fire(tankDirection);
        }
    }

    /**
     *
     * When called tank should produce new bullet.
     * This bullet should smoothly move to the opposite side.
     *
     * Bullet should be destroyed when rich the opposite side.
     *
     * Ignore all the objects on battle field for now.
     *
     */
    void fire(int direction)
    {
        bulletX=tankX+cell_width/2;
        bulletY=tankY+cell_height/2;
        // TODO YOUR CODE HERE
        if (direction == 3)
        {
            int begincell=bulletY;
            int endcell=BF_HEIGHT;
            if (begincell >= 0)
            {
                System.out.println("Move down");
                while (bulletY<=endcell)
                {bulletY++;
                    repaint();
                    sleep(bulletSpeed);
                }

                repaint ();
                sleep(500);
                bulletY=tankY;
            }
            else System.out.println("Move down is not allowed from this position");
        }
        else         if (direction == 1)
        {
            int begincell=bulletY;
            int endcell=0;
            if (begincell >= endcell)
            {
                System.out.println("Move up");
                while (bulletY>=endcell )
                {bulletY--;
                    repaint();
                    sleep(bulletSpeed);
                }

                repaint ();
                sleep(500);
                bulletY=tankY;
            }
            else System.out.println("Move up is not allowed from this position");
        }
        else if (direction == 2)
        {
            int begincell=bulletX;
            int endcell=BF_HEIGHT;
            if (begincell >= 0)
            {
                System.out.println("Move right");
                while (bulletX<=endcell)
                {bulletX++;
                    repaint();
                    sleep(bulletSpeed);
                }

                repaint ();
                sleep(500);
                bulletX=tankX;
            }
            else System.out.println("Move right is not allowed from this position");}
        else if (direction == 4)
        {
            int begincell=bulletX;
            int endcell=0;
            if (begincell >= endcell)
            {
                System.out.println("Move up");
                while (bulletX>=endcell )
                {bulletX--;
                    repaint();
                    sleep(bulletSpeed);
                }

                repaint ();
                sleep(500);
                bulletX=tankX;
            }
            else System.out.println("Move left is not allowed from this position");
        }
        else
        {
            System.out.println("Direction is not recognized");
        }


    }

    private void printCurrentBattleField()
    {
        for (String[] row : battleField)
        {
            System.out.println(Arrays.toString(row));
        }
    }

    int[] getQuadrant(int x, int y)
    {
        return new int[] {x / 64, y / 64};
    }

    void move(int direction)
    {
        // TODO YOUR CODE HERE
        if (direction == 3)
        {
            int begincell=tankY;
            int endcell=tankY;
            if ((begincell >= 0) && (endcell <= BF_HEIGHT-cell_height))
            {
                System.out.println("Move down");
                while (tankY<=endcell)
                {tankY++;
                    repaint();
                    sleep(10);
                }

                repaint ();
                sleep(500);
            }
            else System.out.println("Move down is not allowed from this position");
        }
        else         if (direction == 1)
        {
            int begincell=tankY;
            int endcell=tankY+cell_height;
            if ((begincell >= cell_height) && (endcell <= BF_HEIGHT))
            {
                System.out.println("Move up");
                while (tankY>=begincell-cell_height)
                {tankY--;
                    repaint();
                    sleep(10);
                }

                repaint ();
                sleep(500);
            }
            else System.out.println("Move up is not allowed from this position");
        }
        else if (direction == 2)
        {
            int begincell=tankX;
            int endcell=tankX+cell_width;
            if ((begincell >= 0) && (endcell <= BF_WIDTH-cell_width))
            {
                System.out.println("Move right");
                while (tankX<=endcell)
                {tankX++;
                    repaint();
                    sleep(10);
                }

                repaint ();
                sleep(500);
            }
            else System.out.println("Move right is not allowed from this position");
        }
        else if (direction == 4)
        {
            int begincell=tankX;
            int endcell=tankX+cell_width;
            if ((begincell >= cell_width) && (endcell <= BF_WIDTH))
            {
                System.out.println("Move left");
                while (tankX>=begincell-cell_width)
                {tankX--;
                    repaint();
                    sleep(10);
                }

                repaint ();
                sleep(500);
            }
            else System.out.println("Move left is not allowed from this position");
        }
        else
        {
            System.out.println("Direction is not recognized");
        }


    }

    void turn(int direction)
    {
        tankDirection = direction;
        repaint();
    }

    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.


    public static void main(String[] args) throws Exception
    {
        T3_TanksFire bf = new T3_TanksFire();
        bf.runTheGame();
    }

    public T3_TanksFire() throws Exception
    {
        JFrame frame = new JFrame("YOUR TANK SHOULD FIRE!!!");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
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
        catch (Exception ignore)
        {
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        paintBF(g);

        paintBorders(g);

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tankX, tankY, 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (tankDirection == 1)
        {
            g.fillRect(tankX + 20, tankY, 24, 34);
        }
        else if (tankDirection == 3)
        {
            g.fillRect(tankX + 20, tankY + 30, 24, 34);
        }
        else if (tankDirection == 4)
        {
            g.fillRect(tankX, tankY + 20, 34, 24);
        }
        else
        {
            g.fillRect(tankX + 30, tankY + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bulletX, bulletY, 14, 14);
    }

    private void paintBorders(Graphics g)
    {
        for (int j = 0; j < battleField.length; j++)
        {
            for (int k = 0; k < battleField.length; k++)
            {
                if (battleField[j][k].equals("B"))
                {
                    String coordinates = getQuadrantXY(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates.substring(0, separator));
                    int x = Integer.parseInt(coordinates.substring(separator + 1));
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x, y, 64, 64);

                    if (IS_GRID)
                    {
                        g.setColor(new Color(0, 0, 0));
                        g.drawRect(x, y, 64, 64);
                    }
                }
            }
        }
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
                if (COLORED_MODE)
                {
                    if (i % 2 == 0)
                    {
                        cc = new Color(252, 241, 177);
                    }
                    else
                    {
                        cc = new Color(233, 243, 255);
                    }
                }
                else
                {
                    cc = new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }
    }

    private String getQuadrantXY(int v, int h)
    {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

}