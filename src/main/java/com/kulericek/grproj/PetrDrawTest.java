package com.kulericek.grproj;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.event.MouseEvent;

public class PetrDrawTest extends CanvasTool {
    List<Point>line = new ArrayList<Point>();

    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed " + e);
        line.clear();
    }

    public void mouseDragged(MouseEvent e) {
      line.add(e.getPoint());
    }

    public void paintScreen(Graphics2D g) {
        g.setColor(Color.RED);
        g.setStroke(new BasicStroke(10));
        for (int i = 1; i < line.size(); i++) {
            g.drawLine(line.get(i-1).x, line.get(i-1).y, line.get(i).x, line.get(i).y);
        }
    }

    PetrDrawTest() {
        super();
        JButton b1 = new JButton("AHOJ");
        JButton b2 = new JButton("Nazdar");
        JButton b3 = new JButton("Medved");
        add(b1);
        add(b2);
        add(b3);
    }

    public static void main(String[] args) {
        PetrDrawTest pt = new PetrDrawTest();
        pt.display();
    }
}