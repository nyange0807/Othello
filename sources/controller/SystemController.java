package controller;

import java.awt.Point;

import entity.Cell;
import entity.Const;
import entity.Field;

public class SystemController {

    public SystemController() {
    }

    public boolean checkClickPoint(Point point) {
        int x = getXCellIndex(point);
        int y = getYCellIndex(point);
        if (0 <= x && x < 8 && 0 <= y && y < 8 && Field.getCell(x, y).equals(Cell.NEXT)) {
            return true;
        }
        return false;
    }

    public void putStone(Point point, boolean isBlackTurn) {
        int x = getXCellIndex(point);
        int y = getYCellIndex(point);

        Cell homeStone = isBlackTurn ? Cell.STONE_BLACK : Cell.STONE_WHITE;
        Cell awayStone = isBlackTurn ? Cell.STONE_WHITE : Cell.STONE_BLACK;
        Field.setCell(x, y, homeStone);

        // 左
        if (1 < x && Field.getCell(x - 1, y).equals(awayStone)) {
            for (int xx = x - 2;0 <= xx;xx--) {
                if (Field.getCell(xx, y).equals(homeStone)) {
                    for (int xxx = x - 1;xx < xxx;xxx--) {
                        Field.setCell(xxx, y, homeStone);
                    }
                    break;
                } else if (Field.getCell(xx, y).equals(awayStone)) {
                    continue;
                } else if (Field.getCell(xx, y).equals(Cell.NONE) || Field.getCell(xx, y).equals(Cell.NEXT)) {
                    break;
                }
            }
        }
        // 右
        if (x < 7 && Field.getCell(x + 1, y).equals(awayStone)) {
            for (int xx = x + 2;xx < Const.CELL_SIDE_COUNT;xx++) {
                if (Field.getCell(xx, y).equals(homeStone)) {
                    for (int xxx = x + 1;xxx < xx;xxx++) {
                        Field.setCell(xxx, y, homeStone);
                    }
                    break;
                } else if (Field.getCell(xx, y).equals(awayStone)) {
                    continue;
                } else if (Field.getCell(xx, y).equals(Cell.NONE) || Field.getCell(xx, y).equals(Cell.NEXT)) {
                    break;
                }
            }
        }
        // 上
        if (1 < y && Field.getCell(x, y - 1).equals(awayStone)) {
            for (int yy = y - 2;0 <= yy;yy--) {
                if (Field.getCell(x, yy).equals(homeStone)) {
                    for (int yyy = y - 1;yy < yyy;yyy--) {
                        Field.setCell(x, yyy, homeStone);
                    }
                    break;
                } else if (Field.getCell(x, yy).equals(awayStone)) {
                    continue;
                } else if (Field.getCell(x, yy).equals(Cell.NONE) || Field.getCell(x, yy).equals(Cell.NEXT)) {
                    break;
                }
            }
        }
        // 下
        if (y < 7 && Field.getCell(x, y + 1).equals(awayStone)) {
            for (int yy = y + 2;yy < Const.CELL_SIDE_COUNT;yy++) {
                if (Field.getCell(x, yy).equals(homeStone)) {
                    for (int yyy = y + 1;yyy < yy;yyy++) {
                        Field.setCell(x, yyy, homeStone);
                    }
                    break;
                } else if (Field.getCell(x, yy).equals(awayStone)) {
                    continue;
                } else if (Field.getCell(x, yy).equals(Cell.NONE) || Field.getCell(x, yy).equals(Cell.NEXT)) {
                    break;
                }
            }
        }
        // 左上
        if (1 < x && 1 < y && Field.getCell(x - 1, y - 1).equals(awayStone)) {
            for (int xx = x - 2, yy = y - 2;0 <= xx && 0 <= yy;xx--, yy--) {
                if (Field.getCell(xx, yy).equals(homeStone)) {
                    for (int xxx = x - 1, yyy = y - 1;xx < xxx && yy < yyy;xxx--, yyy--) {
                        Field.setCell(xxx, yyy, homeStone);
                    }
                    break;
                } else if (Field.getCell(xx, yy).equals(awayStone)) {
                    continue;
                } else if (Field.getCell(xx, yy).equals(Cell.NONE) || Field.getCell(xx, yy).equals(Cell.NEXT)) {
                    break;
                }
            }
        }
        // 左下
        if (1 < x && y < 7 && Field.getCell(x - 1, y + 1).equals(awayStone)) {
            for (int xx = x - 2, yy = y + 2;0 <= xx && yy < Const.CELL_SIDE_COUNT;xx--, yy++) {
                if (Field.getCell(xx, yy).equals(homeStone)) {
                    for (int xxx = x - 1, yyy = y + 1;xx < xxx && yyy < yy;xxx--, yyy++) {
                        Field.setCell(xxx, yyy, homeStone);
                    }
                    break;
                } else if (Field.getCell(xx, yy).equals(awayStone)) {
                    continue;
                } else if (Field.getCell(xx, yy).equals(Cell.NONE) || Field.getCell(xx, yy).equals(Cell.NEXT)) {
                    break;
                }
            }
        }
        // 左上
        if (x < 7 && 1 < y && Field.getCell(x + 1, y - 1).equals(awayStone)) {
            for (int xx = x + 2, yy = y - 2;xx < Const.CELL_SIDE_COUNT && 0 <= yy;xx++, yy--) {
                if (Field.getCell(xx, yy).equals(homeStone)) {
                    for (int xxx = x + 1, yyy = y - 1;xxx < xx && yy < yyy;xxx++, yyy--) {
                        Field.setCell(xxx, yyy, homeStone);
                    }
                    break;
                } else if (Field.getCell(xx, yy).equals(awayStone)) {
                    continue;
                } else if (Field.getCell(xx, yy).equals(Cell.NONE) || Field.getCell(xx, yy).equals(Cell.NEXT)) {
                    break;
                }
            }
        }
        // 右下
        if (x < 7 && y < 7 && Field.getCell(x + 1, y + 1).equals(awayStone)) {
            for (int xx = x + 2, yy = y + 2;xx < Const.CELL_SIDE_COUNT && yy < Const.CELL_SIDE_COUNT;xx++, yy++) {
                if (Field.getCell(xx, yy).equals(homeStone)) {
                    for (int xxx = x + 1, yyy = y + 1;xxx < xx && yyy < yy;xxx++, yyy++) {
                        Field.setCell(xxx, yyy, homeStone);
                    }
                    break;
                } else if (Field.getCell(xx, yy).equals(awayStone)) {
                    continue;
                } else if (Field.getCell(xx, yy).equals(Cell.NONE) || Field.getCell(xx, yy).equals(Cell.NEXT)) {
                    break;
                }
            }
        }
    }

    public void setNext(boolean isBlackTurn) {
        Cell homeStone = isBlackTurn ? Cell.STONE_BLACK : Cell.STONE_WHITE;
        Cell awayStone = isBlackTurn ? Cell.STONE_WHITE : Cell.STONE_BLACK;

        for (int x = 0;x < Const.CELL_SIDE_COUNT;x++) {
            for (int y = 0;y < Const.CELL_SIDE_COUNT;y++) {
                if (!Field.getCell(x, y).equals(Cell.STONE_BLACK) && !Field.getCell(x, y).equals(Cell.STONE_WHITE)) {
                    Field.setCell(x, y, Cell.NONE);
                    continue;
                }
            }
        }

        for (int x = 0;x < Const.CELL_SIDE_COUNT;x++) {
            for (int y = 0;y < Const.CELL_SIDE_COUNT;y++) {
                if (!Field.getCell(x, y).equals(homeStone)) {
                    continue;
                }

                // 左
                if (1 < x && Field.getCell(x - 1, y).equals(awayStone)) {
                    for (int xx = x - 2;0 <= xx;xx--) {
                        if (Field.getCell(xx, y).equals(homeStone)) {
                            break;
                        } else if (Field.getCell(xx, y).equals(awayStone)) {
                            continue;
                        } else if (Field.getCell(xx, y).equals(Cell.NONE) || Field.getCell(xx, y).equals(Cell.NEXT)) {
                            Field.setCell(xx, y, Cell.NEXT);
                            break;
                        }
                    }
                }
                // 右
                if (x < 6 && Field.getCell(x + 1, y).equals(awayStone)) {
                    for (int xx = x + 2;xx < Const.CELL_SIDE_COUNT;xx++) {
                        if (Field.getCell(xx, y).equals(homeStone)) {
                            break;
                        } else if (Field.getCell(xx, y).equals(awayStone)) {
                            continue;
                        } else if (Field.getCell(xx, y).equals(Cell.NONE) || Field.getCell(xx, y).equals(Cell.NEXT)) {
                            Field.setCell(xx, y, Cell.NEXT);
                            break;
                        }
                    }
                }
                // 上
                if (1 < y && Field.getCell(x, y - 1).equals(awayStone)) {
                    for (int yy = y - 2;0 <= yy;yy--) {
                        if (Field.getCell(x, yy).equals(homeStone)) {
                            break;
                        } else if (Field.getCell(x, yy).equals(awayStone)) {
                            continue;
                        } else if (Field.getCell(x, yy).equals(Cell.NONE) || Field.getCell(x, yy).equals(Cell.NEXT)) {
                            Field.setCell(x, yy, Cell.NEXT);
                            break;
                        }
                    }
                }
                // 左
                if (y < 6 && Field.getCell(y, y + 1).equals(awayStone)) {
                    for (int yy = y + 2;yy < Const.CELL_SIDE_COUNT;yy++) {
                        if (Field.getCell(x, yy).equals(homeStone)) {
                            break;
                        } else if (Field.getCell(x, yy).equals(awayStone)) {
                            continue;
                        } else if (Field.getCell(x, yy).equals(Cell.NONE) || Field.getCell(x, yy).equals(Cell.NEXT)) {
                            Field.setCell(x, yy, Cell.NEXT);
                            break;
                        }
                    }
                }
                // 左上
                if (1 < x && 1 < y && Field.getCell(x - 1, y - 1).equals(awayStone)) {
                    for (int xx = x - 2, yy = y - 2;0 <= xx && 0 <= yy;xx--, yy--) {
                        if (Field.getCell(xx, yy).equals(homeStone)) {
                            break;
                        } else if (Field.getCell(xx, yy).equals(awayStone)) {
                            continue;
                        } else if (Field.getCell(xx, yy).equals(Cell.NONE) || Field.getCell(xx, yy).equals(Cell.NEXT)) {
                            Field.setCell(xx, yy, Cell.NEXT);
                            break;
                        }
                    }
                }
                // 左下
                if (1 < x && y < 6 && Field.getCell(x - 1, y + 1).equals(awayStone)) {
                    for (int xx = x - 2, yy = y + 2;0 <= xx && yy < Const.CELL_SIDE_COUNT;xx--, yy++) {
                        if (Field.getCell(xx, yy).equals(homeStone)) {
                            break;
                        } else if (Field.getCell(xx, yy).equals(awayStone)) {
                            continue;
                        } else if (Field.getCell(xx, yy).equals(Cell.NONE) || Field.getCell(xx, yy).equals(Cell.NEXT)) {
                            Field.setCell(xx, yy, Cell.NEXT);
                            break;
                        }
                    }
                }
                // 左上
                if (x < 6 && 1 < y && Field.getCell(x + 1, y - 1).equals(awayStone)) {
                    for (int xx = x + 2, yy = y - 2;xx < Const.CELL_SIDE_COUNT && 0 <= yy;xx++, yy--) {
                        if (Field.getCell(xx, yy).equals(homeStone)) {
                            break;
                        } else if (Field.getCell(xx, yy).equals(awayStone)) {
                            continue;
                        } else if (Field.getCell(xx, yy).equals(Cell.NONE) || Field.getCell(xx, yy).equals(Cell.NEXT)) {
                            Field.setCell(xx, yy, Cell.NEXT);
                            break;
                        }
                    }
                }
                // 右下
                if (x < 6 && y < 6 && Field.getCell(x + 1, y + 1).equals(awayStone)) {
                    for (int xx = x + 2, yy = y + 2;xx < Const.CELL_SIDE_COUNT && yy < Const.CELL_SIDE_COUNT;xx++, yy++) {
                        if (Field.getCell(xx, yy).equals(homeStone)) {
                            break;
                        } else if (Field.getCell(xx, yy).equals(awayStone)) {
                            continue;
                        } else if (Field.getCell(xx, yy).equals(Cell.NONE) || Field.getCell(xx, yy).equals(Cell.NEXT)) {
                            Field.setCell(xx, yy, Cell.NEXT);
                            break;
                        }
                    }
                }
            }
        }
    }

    private int getXCellIndex(Point point) {
        return (int) point.getX() / Const.CELL_SIZE - 1;
    }

    private int getYCellIndex(Point point) {
        return (int) point.getY() / Const.CELL_SIZE - 2;
    }
}
