package controller;

import java.awt.Color;
import java.awt.Graphics;

import entity.Cell;
import entity.Const;
import entity.Field;

public class PeintController {

    public PeintController() {
    }

    public PeintController(Graphics g) {
        printField(g);
    }

    public void printField(Graphics g) {
        for (int y = 0;y < Const.CELL_SIDE_COUNT;y++) {
            for (int x = 0;x < Const.CELL_SIDE_COUNT;x++) {
                printSquare(g, Color.GREEN, x, y);
                if (Field.getCell(x, y).equals(Cell.STONE_BLACK)) {
                    printCircle(g, Color.BLACK, x, y);
                } else if (Field.getCell(x, y).equals(Cell.STONE_WHITE)) {
                    printCircle(g, Color.WHITE, x, y);
                } else if (Field.getCell(x, y).equals(Cell.NEXT)) {
                    printSquare(g, Color.LIGHT_GRAY, x, y);
                }
                printFrame(g, Color.BLACK, x, y);
            }
        }
    }

    private void printFrame(Graphics g, Color color, int x, int y) {
        g.setColor(color);
        g.drawRect(x * Const.CELL_SIZE + 50, y * Const.CELL_SIZE + 100, Const.CELL_SIZE, Const.CELL_SIZE);
    }

    private void printSquare(Graphics g, Color color, int x, int y) {
        g.setColor(color);
        g.fillRect(x * Const.CELL_SIZE + 50, y * Const.CELL_SIZE + 100, Const.CELL_SIZE, Const.CELL_SIZE);
    }

    private void printCircle(Graphics g, Color color, int x, int y) {
        g.setColor(color);
        g.fillOval(x * Const.CELL_SIZE + 50, y * Const.CELL_SIZE + 100, Const.CELL_SIZE, Const.CELL_SIZE);
    }
}
