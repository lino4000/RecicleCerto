/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import model.Game;

/**
 *
 * @author lino4000
 */
public class DraggingTrash extends ComponentMover{
    
    @Override
    public void mouseReleased(MouseEvent e){
        super.mouseReleased(e);
        Component c = (Component) DraggingTrash.findComponentUnderMouse( e.getLocationOnScreen() );
        if( c instanceof TrashCan){
            TrashCan t = (TrashCan) c;
            Game.throwTrash((Trash) e.getComponent(), t);
        }
    }
    
    
    public static Component findComponentUnderMouse( Point l ) {
        Window window = findWindow();
        SwingUtilities.convertPointFromScreen(l, window);
        return SwingUtilities.getDeepestComponentAt(window, l.x, l.y);
    }

    private static Window findWindow() {
        for (Window window : Window.getWindows()) {
            if (window.getMousePosition(true) != null)
                return window;
        }

        return null;
    }
}
