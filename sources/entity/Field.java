package entity;

public class Field {
    private static Cell[][] field;

    public static void init() {
        field = new Cell[Const.CELL_SIDE_COUNT][Const.CELL_SIDE_COUNT];
        for (int y = 0;y < Const.CELL_SIDE_COUNT;y++) {
            for (int x = 0;x < Const.CELL_SIDE_COUNT;x++) {
                field[y][x] = Cell.NONE;
            }
        }
        field[2][4] = Cell.NEXT;
        field[3][3] = Cell.STONE_BLACK;
        field[3][4] = Cell.STONE_WHITE;
        field[3][5] = Cell.NEXT;
        field[4][2] = Cell.NEXT;
        field[4][3] = Cell.STONE_WHITE;
        field[4][4] = Cell.STONE_BLACK;
        field[5][3] = Cell.NEXT;
    }

    public static void setCell(int x, int y, Cell cell) {
        field[y][x] = cell;
    }

    public static Cell getCell(int x, int y) {
        return field[y][x];
    }
}
