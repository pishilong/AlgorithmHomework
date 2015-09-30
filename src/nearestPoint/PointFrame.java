package nearestPoint;

import sun.java2d.pipe.SpanShapeRenderer;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pishilong on 15/9/30.
 */
public class PointFrame extends JFrame{
    private DrawBoard board;
    private JPanel toolbar;
    private JTextPane textPanel;
    private JScrollPane scrollPane;
    private Nlgn nlgn;

    private JButton caculateButton, resetButton, amountButton;

    public PointFrame() {
        setTitle("计算最近点对");
        setPreferredSize(new Dimension(800, 500));
        setResizable(false);

        Toolkit kit = Toolkit.getDefaultToolkit();    // 定义工具包
        Dimension screenSize = kit.getScreenSize();   // 获取屏幕的尺寸
        int screenWidth = screenSize.width/4;         // 获取屏幕的宽
        int screenHeight = screenSize.height/4;       // 获取屏幕的高
        int height = this.getHeight();
        int width = this.getWidth();
        setLocation(screenWidth-width/2, screenHeight-height/2);

        board = new DrawBoard();

        toolbar = new JPanel();
        caculateButton = new JButton("开始计算");
        resetButton = new JButton("重置");
        amountButton = new JButton("指定随机点数");
        toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        toolbar.add(caculateButton);
        toolbar.add(resetButton);
        toolbar.add(amountButton);
        MyItemListener listener = new MyItemListener();
        caculateButton.addActionListener(listener);
        resetButton.addActionListener(listener);
        amountButton.addActionListener(listener);

        textPanel = new JTextPane();
        textPanel.setPreferredSize(new Dimension(150, 500));
        textPanel.setBackground(Color.gray);
        scrollPane = new JScrollPane(textPanel);

        add(scrollPane, BorderLayout.EAST);

        add(toolbar, BorderLayout.SOUTH);
        add(board);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        nlgn = new Nlgn();

    }

    private class MyItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            if (obj == PointFrame.this.caculateButton) {
                board.resetPointSet();
                nlgn.performance(board.pointSet.toArray(new Point[0]));
                board.showResult(nlgn);
                textPanel.setText("总点数: " + board.pointSet.size() + "\n" +
                        "最短距离：" + nlgn.nearestDistance + "\n" +
                        "耗时: " + nlgn.timecost + "ms");
            } else if (obj == PointFrame.this.resetButton) {
                board.reset(nlgn);
            } else if (obj == PointFrame.this.amountButton) {
                int number = Integer.parseInt(JOptionPane.showInputDialog("请输入随机点数"));
                Point[] points = Point.generateRandomPoints(number);

                StringBuilder sb = new StringBuilder();
                /*打印太慢了
                for (Point p : points){
                    sb.append(p.toString() + "\n");
                    textPanel.setText(sb.toString());
                }
                */
                nlgn.performance(points);
                sb.append("总点数: " + points.length + "\n" +
                        "最短距离：" + nlgn.nearestDistance + "\n" +
                        "耗时: " + nlgn.timecost + "ms");
                textPanel.setText(sb.toString());


            }
        }
    }

    public static void main(String[] args){
        PointFrame f = new PointFrame();
        f.setVisible(true);
    }
}
