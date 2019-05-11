/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import view.ComponentMover;
import view.MainWindow;
import view.Trash;

/**
 *
 * @author lino4000
 */
public class Game {

    private static MainWindow window;
    private static ComponentMover cm = new ComponentMover();
    private static ArrayList<Trash> trashes = new ArrayList<Trash>();

    public Game(MainWindow window){
        Game.window = window;
        Game.window.setVisible(true);
    }

    public static void start(){
        for(int i=0;i<20;i++){
            Game.trashes.add(new Trash("banana.png"));
        }
        for(Trash t : trashes){
            Game.window.add(t);
            Game.cm.registerComponent(t);
        }
        Game.window.repaint();
    }
}