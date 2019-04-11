package code01;

import  java.awt.*;
import javax.swing.*;

public class ballgame2 extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("day01-code01-images/src/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("day01-code01-images/src/desk.jpg");

    double x = 100;//小球的横坐标
    double y = 100;//小球的纵坐标

    double degree = 3.14/3;//弧度。此处就是60°

    //画窗口的方法
    public void paint(Graphics g){
        System.out.println("窗口被画了一次！");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int)x, (int)y, null);


        x = x + 10*Math.cos(degree);
        y = y + 10*Math.sin(degree);

        if(y>500-40-30 || y<40+40){//500是窗口的高度，40是桌子边框，30是球直径，最后一个40是标题栏的高度
           degree = -degree;
        }

        //碰到左右边界
        if(x<40 || x>856-40-30){
            degree = 3.14 - degree;
        }

    }

    //窗口加载
    void launchFrame() {
        setSize(856, 500);
        setLocation(50, 50);
        setVisible(true);


        //重画窗口,每秒画25次
        while (true) {
            repaint();
            try {
                Thread.sleep(40);//40ms, 1s=1000ms,大约一秒画25次窗口
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //main方法是程序执行的入口
    public static void main(String[] args){
        System.out.println("初次体验编程的快感");
        ballgame2 game = new ballgame2();
        game.launchFrame();

    }
}