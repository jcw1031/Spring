package com.example.youtube.gui;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarFile;

@SpringBootApplication
public class MainGui extends JFrame {
    Container ct = getContentPane();

    public MainGui() {
        JButton jb = new JButton("asdf");
        ct.add(jb);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("agsdf");
    }

    public static void main(String[] args) {
        var ctx = new SpringApplicationBuilder(MainGui.class)
                .headless(false).run(args);

        EventQueue.invokeLater(() ->{
            var ex = ctx.getBean(MainGui.class);
            ex.setVisible(true);
        });
    }
}
