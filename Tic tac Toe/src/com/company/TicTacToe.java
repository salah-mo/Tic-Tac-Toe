package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

/**
 * @author Salah
 */

public class TicTacToe implements ActionListener
{
    JFrame window = new JFrame();
    JPanel upperPanel = new JPanel();
    JPanel lowerPanel = new JPanel();
    JLabel title = new JLabel();
    JButton[] bton = new JButton[9];
    Random random = new Random();
    boolean pl1Chance;
    int chance = 0;

    TicTacToe()
    {
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(800, 730);
        window.setTitle("Tic Tac Toe");
        window.setLayout(new BorderLayout());
        window.setVisible(true);

        title.setBackground(new Color(73, 218, 199));
        title.setForeground(new Color(30, 70, 52));
        title.setFont(new Font("Britannic Bold", Font.BOLD, 100));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("Tic Tac Toe");
        title.setOpaque(true);

        upperPanel.setLayout(new BorderLayout());

        lowerPanel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++)
        {
            bton[i] = new JButton();
            lowerPanel.add(bton[i]);
            bton[i].setFont(new Font("Ink Free", Font.BOLD, 120));
            bton[i].setFocusable(false);
            bton[i].addActionListener(this);
            bton[i].setBackground(new Color(62, 97, 155));
        }

        upperPanel.add(title);
        window.add(upperPanel, BorderLayout.NORTH);
        window.add(lowerPanel);

        startGame();
    }

    public void startGame()
    {
        int chance = random.nextInt(100);

        if (chance % 2 == 0)
        {
            pl1Chance = true;
            title.setText("X turn");
        }
        else
        {
            pl1Chance = false;
            title.setText("O turn");
        }
    }

    public void gameOver(String s)
    {
        chance = 0;
        Object[] option = {"Restart", "Exit"};
        int n = JOptionPane.showOptionDialog(window, "Game Over\n" + s, "Winner", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);

        if (n == 0)
        {
            window.dispose();
            new TicTacToe();
        }
        else
        {
            window.dispose();
        }
    }

    public void checker() {
        if (("X".equals(bton[0].getText())) && ("X".equals(bton[1].getText())) && ("X".equals(bton[2].getText())))
        {
            xWins(0, 1, 2);
        }
        else if (("X".equals(bton[0].getText())) && ("X".equals(bton[4].getText())) && ("X".equals(bton[8].getText())))
        {
            xWins(0, 4, 8);
        }
        else if (("X".equals(bton[0].getText())) && ("X".equals(bton[3].getText())) && ("X".equals(bton[6].getText())))
        {
            xWins(0, 3, 6);
        }
        else if (("X".equals(bton[1].getText())) && ("X".equals(bton[4].getText())) && (Objects.equals(bton[7].getText(), "X")))
        {
            xWins(1, 4, 7);
        }
        else if ((Objects.equals(bton[2].getText(), "X")) && (Objects.equals(bton[4].getText(), "X")) && (Objects.equals(bton[6].getText(), "X")))
        {
            xWins(2, 4, 6);
        }
        else if ((Objects.equals(bton[2].getText(), "X")) && (Objects.equals(bton[5].getText(), "X")) && (Objects.equals(bton[8].getText(), "X")))
        {
            xWins(2, 5, 8);
        }
        else if ((Objects.equals(bton[3].getText(), "X")) && (Objects.equals(bton[4].getText(), "X")) && (Objects.equals(bton[5].getText(), "X")))
        {
            xWins(3, 4, 5);
        }
        else if ((Objects.equals(bton[6].getText(), "X")) && (Objects.equals(bton[7].getText(), "X")) && (Objects.equals(bton[8].getText(), "X")))
        {
            xWins(6, 7, 8);
        }
        else if ((Objects.equals(bton[0].getText(), "O")) && (Objects.equals(bton[1].getText(), "O")) && (Objects.equals(bton[2].getText(), "O")))
        {
            oWins(0, 1, 2);
        }
        else if ((Objects.equals(bton[0].getText(), "O")) && (Objects.equals(bton[3].getText(), "O")) && (Objects.equals(bton[6].getText(), "O")))
        {
            oWins(0, 3, 6);
        }
        else if ((Objects.equals(bton[0].getText(), "O")) && (Objects.equals(bton[4].getText(), "O")) && (Objects.equals(bton[8].getText(), "O")))
        {
            oWins(0, 4, 8);
        }
        else if ((Objects.equals(bton[1].getText(), "O")) && (Objects.equals(bton[4].getText(), "O")) && (Objects.equals(bton[7].getText(), "O")))
        {
            oWins(1, 4, 7);
        }
        else if ((Objects.equals(bton[2].getText(), "O")) && (Objects.equals(bton[4].getText(), "O")) && (Objects.equals(bton[6].getText(), "O")))
        {
            oWins(2, 4, 6);
        }
        else if ((Objects.equals(bton[2].getText(), "O")) && (Objects.equals(bton[5].getText(), "O")) && (Objects.equals(bton[8].getText(), "O")))
        {
            oWins(2, 5, 8);
        }
        else if ((Objects.equals(bton[3].getText(), "O")) && (Objects.equals(bton[4].getText(), "O")) && (Objects.equals(bton[5].getText(), "O")))
        {
            oWins(3, 4, 5);
        }
        else if ((Objects.equals(bton[6].getText(), "O")) && (Objects.equals(bton[7].getText(), "O")) && (Objects.equals(bton[8].getText(), "O")))
        {
            oWins(6, 7, 8);
        }
        else if (chance == 9)
        {
            title.setText("No Winner");
            gameOver("No Winner");
        }
    }

    public void xWins(int x1, int x2, int x3)
    {
        bton[x1].setBackground(new Color(170, 201, 245));
        bton[x2].setBackground(new Color(170, 201, 245));
        bton[x3].setBackground(new Color(170, 201, 245));

        for (int i = 0; i < 9; i++)
        {
            bton[i].setEnabled(false);
        }

        title.setText("X wins");
        gameOver("X Wins");
    }

    public void oWins(int x1, int x2, int x3) {
        bton[x1].setBackground(new Color(170, 201, 245));
        bton[x2].setBackground(new Color(170, 201, 245));
        bton[x3].setBackground(new Color(170, 201, 245));

        for (int i = 0; i < 9; i++) {
            bton[i].setEnabled(false);
        }
        title.setText("O Wins");
        gameOver("O Wins");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < 9; i++)
        {
            if (e.getSource() == bton[i])
            {
                if (pl1Chance)
                {
                    if (Objects.equals(bton[i].getText(), ""))
                    {
                        bton[i].setForeground(new Color(233, 233, 235));
                        bton[i].setText("X");
                        pl1Chance = false;
                        title.setText("O turn");
                        chance++;
                        checker();
                    }
                }
                else
                {
                    if (Objects.equals(bton[i].getText(), ""))
                    {
                        bton[i].setForeground(new Color(32, 50, 90));
                        bton[i].setText("O");
                        pl1Chance = true;
                        title.setText("X turn");
                        chance++;
                        checker();
                    }
                }
            }
        }
    }
}
// The End