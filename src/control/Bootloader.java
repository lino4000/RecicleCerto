/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Game;
import view.MainWindow;

/**
 *
 * @author lino4000
 */
public class Bootloader {
    
    public static void main(String[] args) {
        Game game = new Game(new MainWindow());
    }
}
