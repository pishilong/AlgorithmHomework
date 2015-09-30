package nearestPoint;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

/**
 * Created by pishilong on 15/9/30.
 */
public class DrawBoard extends JPanel implements MouseListener{
    Set<Point> pointSet = new HashSet<Point>();

    public DrawBoard(){
        addMouseListener(this);
        setBackground(Color.white);
        setPreferredSize(new Dimension(300, 300));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Set<Point> result = new HashSet<Point>();

        //画点，如果是结果，则显示成红色
        for (Point p : pointSet){
            if (p.getSelected()){
                result.add(p);
                g.setColor(Color.red);
            }else {
                g.setColor(Color.black);
            }
            g.fillOval((int) p.getX(), (int) p.getY(), 3, 3);
        }

        //把结果点，连成线
        if (!result.isEmpty()){
            Point[] points = result.toArray(new Point[0]);
            g.setColor(Color.red);
            g.drawLine((int)points[0].getX(), (int)points[0].getY(),
                    (int)points[1].getX(), (int)points[1].getY());
        }
    }

    public void mousePressed(MouseEvent e){
        pointSet.add(new Point(e.getX(), e.getY()));
        repaint();
    }

    public void reset(Algorithem algorithem){
        algorithem.reset();
        pointSet.clear();
        repaint();
    }

    public void resetPointSet() {
        for (Point point : pointSet){
            point.unselect();
        }
    }

    public void showResult(Algorithem algorithem){
        for (Point point : pointSet){
            if (algorithem.nearestPoint.contains(point)){
                point.select();
            }
        }
        repaint();
    }

    public void mouseExited(MouseEvent e){}

    public void mouseReleased(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseClicked(MouseEvent e){}

}