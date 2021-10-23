package com.kulericek.grproj;

import java.awt.*;
import java.util.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.Timer;

public class CanvasTool extends JPanel implements MouseListener, MouseMotionListener {
   List<String>texts;
   BoxLayout boxlayout;


   public void mousePressed(MouseEvent e) {
      System.out.println("Mouse pressed " + e);
   }

   public void mouseReleased(MouseEvent e) {
      //System.out.println("Mouse released; # of clicks: " + e.getClickCount());
   }

   public void mouseEntered(MouseEvent e) {
      //System.out.println("Mouse entered");
   }

   public void mouseExited(MouseEvent e) {
      //System.out.println("Mouse exited");
   }

   public void mouseClicked(MouseEvent e) {
      //System.out.println("Mouse clicked (# of clicks: " + e.getClickCount() + ")");
   }

   public void mouseMoved(MouseEvent e) {
      //System.out.println("Mouse moved" + e);
   }

   public void mouseDragged(MouseEvent e) {
      //System.out.println("Mouse dragged" + e);
   }

   public CanvasTool() {
      texts = new ArrayList<String>();
      addMouseListener(this);
      addMouseMotionListener(this);

      Timer timer = new Timer(50, new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
             CanvasTool.this.repaint();
         }
     });
     timer.start();
   }

   public void print(String s) {
      texts.add(s);
   }

   void paintTexts(Graphics2D g) {
      int x = 20;
      int y = 20;
      g.setColor(Color.BLACK);
      for (String i: texts) {
         g.drawString(i, x, y);
         y += 20;
      }
   }

   @Override
   public void paintComponent(Graphics g) {
      Graphics2D graphic2d = (Graphics2D) g;
      g.clearRect(0, 0, getWidth(), getHeight());
      paintScreen(graphic2d);
      paintTexts(graphic2d);
      graphic2d.setStroke(new BasicStroke(1));
      // super.paintComponent(g);
   }

   public void paintScreen(Graphics2D g) {
      g.setColor(Color.BLUE);
      g.fillRect(100, 50, 60, 80);
   }

   void display() {
      JFrame frame = new JFrame("Demo");
      frame.add(this);

      boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
      setLayout(boxlayout);

      frame.setSize(800, 600);
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      CanvasTool pt = new CanvasTool();
      pt.display();
   }
}
