package system;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.PeintController;
import controller.SystemController;

public class MouseListener extends MouseAdapter {
    boolean isBlackTurn;
    Graphics g;
    PeintController peintController;
    SystemController systemController;

    public MouseListener(Graphics g) {
        super();
        this.g = g;
        isBlackTurn = true;
        peintController = new PeintController();
        systemController = new SystemController();
    }

    public void mouseClicked(MouseEvent m) {
        if (!systemController.checkClickPoint(m.getPoint())) {
            Toolkit.getDefaultToolkit().beep();
            return;
        }
        systemController.putStone(m.getPoint(), isBlackTurn);
        isBlackTurn =! isBlackTurn;
        systemController.setNext(isBlackTurn);
        peintController.printField(g);
    }
}
