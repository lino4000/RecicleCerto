/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author lino4000
 */
public class Trash extends JLabel{

    public Trash(String icon){
        super();
        Random r = new Random();
        this.setIcon( new ImageIcon(getClass().getResource("/resources/"+icon)) );
        this.setLocation(r.nextInt(568),r.nextInt(418)+ 82 );
        this.setVisible(true);
        this.setSize(new Dimension(32,32));
    }
}