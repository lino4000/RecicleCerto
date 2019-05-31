/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author lino4000
 */
public class TrashCan extends JLabel{
    
    private String color;
    
    public TrashCan(String color){
        super();
        this.color = color;
        this.setIcon( new ImageIcon( getClass().getResource("/resources/"+color+".png" )));
//        this.setLocation( (20 + this.count*10) + this.count * 67, 0);
        this.setVisible(true);
        this.setSize(new Dimension(77,92));
        this.setMinimumSize(new Dimension(77,112));
        this.setBorder(new EmptyBorder(10,10,10,0));
        this.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        /*
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                TrashCan t = (TrashCan) e.getComponent();
                t.mouseEntered();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                TrashCan t = (TrashCan) e.getComponent();
                t.mouseExit();
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                TrashCan t = (TrashCan) e.getComponent();
            }
        });*/
    }
    
    public String getColor(){
        return this.color;
    }
}
