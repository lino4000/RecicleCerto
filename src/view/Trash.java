/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author lino4000
 */
public class Trash extends JLabel{
    private String color;

    public Trash(String color){
        super();
        this.color = color;
        File[] files;
        files = new File( getClass().getResource("/resources/"+color).getPath() ).listFiles();
        this.setIcon( new ImageIcon(files[new Random().nextInt(files.length)].getPath()) );
        this.setLocation(new Random().nextInt(548),new Random().nextInt(418) );
        this.setVisible(true);
        this.setSize(new Dimension(32,32));
    }
    
    public String getColor(){
        return this.color;
    }
}