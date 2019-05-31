/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.BorderLayout;
import model.Game;
import view.MainWindow;

/**
 *
 * @author lino4000
 */
public class Bootloader {
    
    public static void main(String[] args) {
        Game.open(new MainWindow());
    }
}
