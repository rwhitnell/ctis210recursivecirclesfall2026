package edu.guilford;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class RecursiveCirclePanel extends JPanel {

    private int panelHeight;
    private int panelWidth;
    private double initialX;
    private double initialY;
    private double radius;
    private Random rand = new Random();

    private ArrayList<ColorEllipse> circles = new ArrayList<ColorEllipse>();

    public RecursiveCirclePanel(int panelHeight, int panelWidth) {
        this.panelHeight = panelHeight;
        this.panelWidth = panelWidth;
        setPreferredSize(new Dimension(this.panelWidth, this.panelHeight));
        initialX = 500;
        initialY = 400;
        radius = rand.nextDouble() * 50 + 90;
        drawAllCircles();
        repaint();
    }

    public final void drawAllCircles() {
        circles.clear();
        addCircle(initialX, initialY, radius);
        System.out.println("Number of circles: " + circles.size());
        repaint();
    }

    public void addCircle(double cx, double cy, double radius) {
        ColorEllipse theCircle = new ColorEllipse(cx - radius, cy - radius,
                2 * radius, 2 * radius);
        circles.add(theCircle);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // magic code to use the right kind of graphics
        for (ColorEllipse circle : circles) {
            g2.setColor(circle.getEllipseColor());
            g2.fill(circle);
        }
    }

    private class UseMouse extends MouseAdapter {

    }

}
