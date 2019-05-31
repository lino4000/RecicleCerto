/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import view.DraggingTrash;
import view.MainWindow;
import view.Trash;
import view.TrashCan;

/**
 *
 * @author lino4000
 */
public class Game {

    private static Integer score = 0;
    private static Integer time = 0;
    private static Timer timer = new Timer(true);
    private static volatile Boolean start = false;
    private static MainWindow window;
    private static JPanel tcPanel = new JPanel();
    private static DraggingTrash dt = new DraggingTrash();
    private static ArrayList<Trash> trashes = new ArrayList<Trash>();
    private static ArrayList<TrashCan> trashCans = new ArrayList<TrashCan>();
    private static ArrayList<String> types = new ArrayList<String>(
        Arrays.asList(
            "blue",    // Papel
            "red",     // Plástico
            "green",   // Vidro
            "yellow",  // Metal
            "black",   // Madeira
            "orange",  // Perigosos
            "white",   // Hospitalares
            "purple",  // Radioativos
            "brown",   // Organicos
            "gray"     // Não aproveitável/ Aterro sanitário
        )
    );

    public static void open(MainWindow window){

        tcPanel.setOpaque(false);
        tcPanel.setLayout(new BoxLayout(tcPanel, BoxLayout.LINE_AXIS));

        Game.window = window;
        Game.window.setVisible(true);
        Game.window.setTrashCansViewport(tcPanel);
        Game.startTimer();
    }

    public static void start(){
        Game.clearBoard();
                
        Game.trashes.addAll(
            Game.createTrashes(20, types)
        );
        
        Game.trashes.stream().map((t) -> {
            Game.window.boardAdd(t);
            return t;
        }).forEachOrdered((t) -> {
            Game.dt.registerComponent(t);
        });
        
        Game.types.forEach((t) -> {
            Game.trashCans.add( new TrashCan(t));
        });

        Game.trashCans.get(Game.trashCans.size() - 1).setBorder(new EmptyBorder(10,10,10,10));
        
        Game.trashCans.forEach((t) -> {
            tcPanel.add(t);
        });

        Game.window.pack();
        Game.window.repaint();
        Game.start = true;
    }
    
    public static void clearBoard(){
        Game.trashes.forEach((c) -> {
            Game.window.boardRemove(c);
        });
        Game.trashes.clear();
        Game.tcPanel.removeAll();
        Game.trashCans.clear();
        Game.time = 0;
        Game.score = 0;
    }
    
    private static ArrayList createTrashes(Integer qtd, ArrayList<String> types){
        
        ArrayList<Trash> trashes = new ArrayList<Trash>();
        do{
            if( trashes.size() < types.size() )
                trashes.add(
                    new Trash(
                        types.get(
                            trashes.size()
                        )
                    )
                );
            else
                trashes.add( 
                    new Trash( 
                        types.get(
                            new Random().nextInt(
                                types.size()
                            )
                        )
                    )
                );
        } while(trashes.size() < qtd);
        return trashes;
    }
    
    public static void throwTrash( Trash t, TrashCan tc){
        if( t.getColor() ==  tc.getColor() )
            Game.increaseScore();
        Game.trashes.remove(t);
        Game.window.boardRemove(t);
        Game.window.repaint();
        if (Game.trashes.isEmpty())
            Game.finished();
    }
    
    private static void increaseScore(){
        if( Game.time < 50)
            Game.score += 500;
        if( Game.time < 100)
            Game.score += 400;
        if( Game.time < 150)
            Game.score += 250;
        if( Game.time < 300)
            Game.score += 100;
        if( Game.time < 600)
            Game.score += 50;
        Game.score += 10;
    }
    
    private static void finished(){
        Game.start = false;
    }
    
    private static void startTimer(){
        Game.timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (Game.start){
                    Game.time++;
                    Game.window.updateScore(Game.score.toString());
                    Game.window.updateTimer(
                        String.format(
                                "%02d:%02d.%01d", 
                                (Game.time % 36000) / 600,
                                (Game.time % 600) / 10,
                                (Game.time % 10)
                        )
                    );
                };
            }
        }, 0, 100);
    }
}