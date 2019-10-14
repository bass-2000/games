package gameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameOfLife extends JFrame {
    final String NAME_OF_GAME = "Conway's Game of Life";
    final int LIFE_SIZE = 50;
    final int POINT_RADIUS = 10;
    final int FIELD_SIZE = LIFE_SIZE * POINT_RADIUS + 7;
    final int BTN_PANEL_HEIGHT = 58 + 4;
    final int START_LOCATION = 200;
    // icons for buttons
    final ImageIcon icoFill = new ImageIcon(GameOfLife.class.getResource("img/btnFill.png"));
    final ImageIcon icoNew = new ImageIcon(GameOfLife.class.getResource("img/btnNew.png"));
    final ImageIcon icoOpen = new ImageIcon(GameOfLife.class.getResource("img/btnOpen.png"));
    final ImageIcon icoSave = new ImageIcon(GameOfLife.class.getResource("img/btnSave.png"));
    final ImageIcon icoStep = new ImageIcon(GameOfLife.class.getResource("img/btnStep.png"));
    final ImageIcon icoGo = new ImageIcon(GameOfLife.class.getResource("img/btnGo.png"));
    final ImageIcon icoStop = new ImageIcon(GameOfLife.class.getResource("img/btnStop.png"));
    final ImageIcon icoFaster = new ImageIcon(GameOfLife.class.getResource("img/btnFaster.png"));
    final ImageIcon icoSlower = new ImageIcon(GameOfLife.class.getResource("img/btnSlower.png"));
    final ImageIcon icoColor = new ImageIcon(GameOfLife.class.getResource("img/btnColor.png"));
    final ImageIcon icoNoColor = new ImageIcon(GameOfLife.class.getResource("img/btnNoColor.png"));
    final ImageIcon icoGrid = new ImageIcon(GameOfLife.class.getResource("img/btnGrid.png"));
    JFrame frame;
    Dimension btnDimension = new Dimension(30, 26);
    int countGeneration = 0;
    boolean[][] lifeGeneration = new boolean[LIFE_SIZE][LIFE_SIZE];
    boolean[][] nextGeneration = new boolean[LIFE_SIZE][LIFE_SIZE];
    boolean[][] tmp;
    Canvas canvasPanel;
    Random random = new Random();

    public static void main(String[] args) {
        new GameOfLife().start();
    }

    void start() {


        frame = new JFrame(NAME_OF_GAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FIELD_SIZE, FIELD_SIZE + BTN_PANEL_HEIGHT);
        frame.setLocation(START_LOCATION, START_LOCATION);
        frame.setResizable(false);

        // randomly fill cells
        JButton fillButton = new JButton();
        fillButton.setIcon(icoFill);
        fillButton.setPreferredSize(btnDimension);
        fillButton.setToolTipText("Fill randomly");
        fillButton.addActionListener(new FillButtonListener());
    }

    // randomly fill cells
    public class FillButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            countGeneration = 1;
            for (int x = 0; x < LIFE_SIZE; x++) {
                for (int y = 0; y < LIFE_SIZE; y++) {
                    lifeGeneration[x][y] = random.nextBoolean();
                }
            }
            canvasPanel.repaint();
        }
    }
}
