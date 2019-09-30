package compornent;

import java.awt.Graphics;

import javax.swing.JFrame;

import controller.PeintController;
import entity.Const;
import entity.Field;
import system.MouseListener;

public class Frame extends JFrame {

    public Frame() {
        super();
        setTitle(Const.FRAME_TITLE);
        setSize(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addMouseListener(new MouseListener(getGraphics()));
    }

    public void paint(Graphics g) {
        Field.init();
        new PeintController(g);
    }
}
