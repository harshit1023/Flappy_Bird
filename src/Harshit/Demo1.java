package Harshit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Demo1 implements KeyListener , MouseListener,Runnable {
    public static int pappuYcord=295;
    public static int pappuVel=0;
    public static int pappuAcc=0;
    static boolean logVisible=true;
    public static boolean pause=false;
    public static  boolean buttonPause=false;
    private static AudioClip moveAudio;
    static boolean startSound=false;
    static boolean moveSound=false;
    public static boolean standEscape=true;
    static int j=0;
    static int counts=0;

    public static void main(String[] args) throws IOException {
        JFrame f=new JFrame();
        JPanel panel=new JPanel();
        f.setTitle("Bird Game");
        f.setLocation(400,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        Dimension d=new Dimension(1000,500);
        panel.setPreferredSize(d);
        panel.setFocusable(true);
        panel.addKeyListener(new Demo1());
        panel.addMouseListener(new Demo1());
        f.pack();
       Image image=new BufferedImage(1000,500,BufferedImage.TYPE_INT_RGB);

       Thread t=new Thread( new Demo1());
       t.setName("second");
       t.start();






        f.setVisible(true);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        panel.requestFocus();
        Graphics imageGraphics= image.getGraphics();
        Graphics g= panel.getGraphics();

        Image groundImage = null;
        Image pappu[]= new Image[8];
        Image playerImage;
        Image logImage=null;
        Image standImage=null;
        Image cloud=null;
        Image playImage=null,pauseImage=null;
        Image tree=null,backTree=null;
        Image apple=null;

        int stand1XCordinate=1200;
        int stand1YCordinate=250;
        int stand2XCordinate=1500;
        int stand2YCordinate=-300;
        int stand3XCordinate=1800;
        int stand3YCordinate=250;

        Demo1.moveAudio= Applet.newAudioClip(Demo1.class.getClassLoader().getResource("Harshit/sound/pappu.wav"));
        AudioClip hitSound= Applet.newAudioClip(Demo1.class.getClassLoader().getResource("Harshit/sound/hit.wav"));

        try{
            apple=ImageIO.read(Demo1.class.getClassLoader().getResourceAsStream("Harshit/image/apple.png"));
            tree=ImageIO.read(Demo1.class.getClassLoader().getResourceAsStream("Harshit/image/back_trees.png"));
           // backTree=ImageIO.read(Demo1.class.getClassLoader().getResourceAsStream("Harshit/image/back_trees.png"));
            logImage=ImageIO.read(Demo1.class.getClassLoader().getResourceAsStream("Harshit/image/log.png"));
            playImage = ImageIO.read(Demo1.class.getClassLoader().getResourceAsStream("Harshit/image/play.png"));
            pauseImage=ImageIO.read(Demo1.class.getClassLoader().getResourceAsStream("Harshit/image/pause.png"));
            cloud=ImageIO.read(Demo1.class.getClassLoader().getResourceAsStream("Harshit/image/bg_combined.png"));
            groundImage= ImageIO.read(Demo1.class.getClassLoader().getResourceAsStream("Harshit/image/ground.png"));
            pappu[0]= ImageIO.read(Demo1.class.getClassLoader().getResourceAsStream("Harshit/image/image1.png"));
            pappu[1]= ImageIO.read(Demo1.class.getClassLoader().getResourceAsStream("Harshit/image/image2.png"));
            pappu[2]= ImageIO.read(Demo1.class.getClassLoader().getResourceAsStream("Harshit/image/image3.png"));
            pappu[3]= ImageIO.read(Demo1.class.getClassLoader().getResourceAsStream("Harshit/image/image4.png"));
            pappu[4]= ImageIO.read(Demo1.class.getClassLoader().getResourceAsStream("Harshit/image/image5.png"));
            pappu[5]=pappu[3];
            pappu[6]=pappu[2];
            pappu[7]=pappu[1];



            standImage= ImageIO.read(Demo1.class.getClassLoader().getResourceAsStream("Harshit/image/branch.png"));


        }catch (Exception b){
            System.out.println("");
        }
        int i=0;
        int apple1XCord=2500;
        int apple1YCord=200;
        boolean apple1Visible=true;

        int apple2XCord=4500;
        int apple2YCord=300;
        boolean apple2Visible=true;

        int apple3XCord=6500;
        int apple3YCord=150;
        boolean apple3Visible=true;

        int count=150;


        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if ( Demo1.pause)
            {  counts=1;
                //g.clearRect();
                imageGraphics.drawImage(playImage,10,10,50,50,null);
                g.drawImage(image,0,0,null);


                continue;
            }

            if(Demo1.moveSound) {
                moveAudio.loop();
            }
            Random r=new Random();
            int a=r.nextInt(2);
            int b=r.nextInt(3);
            // System.out.println(a+"  "+b);
            i++;

            i=i%8;
            //g.drawImage(cloudImage,0,0,null);
            apple1XCord-=15;
            if(apple1XCord<-34)
            {
                if(b==0)
                {    apple1XCord=3000;
                    apple1Visible=true;

                }
            }
            apple2XCord-=15;
            if(apple2XCord<-34)
            {
                if(b==0)
                {    apple2XCord=3000;
                    apple2Visible=true;

                }
            }
            apple3XCord-=15;
            if(apple3XCord<-34)
            {
                if(b==0)
                {    apple3XCord=3000;
                    apple3Visible=true;

                }
            }


            stand1XCordinate-=12;
            if (stand1XCordinate<-59)
            {
                if(a==0)
                    stand1YCordinate=250;
                else

                    stand1YCordinate=-300;
                stand1XCordinate=900;
            }

            stand2XCordinate-=12;
            if (stand2XCordinate<-59)
            {
                if(a==0)
                    stand2YCordinate=250;
                else
                    stand2YCordinate=-300;
                stand2XCordinate=900;
            }

            stand3XCordinate-=12;
            if (stand3XCordinate<-59)
            {
                if(a==0)
                    stand3YCordinate=250;
                else
                    stand3YCordinate=-300;
                stand3XCordinate=900;
            }
            Demo1.pappuYcord +=Demo1.pappuVel;
            Demo1.pappuVel +=Demo1.pappuAcc;
//            if(Demo1.isColliding(50,Demo1.pappuYcord,stand1XCordinate,stand1YCordinate))
//            {
//                g.drawImage(pappu[i],50, Demo1.pappuYcord,null);
//                while (Demo1.pappuYcord<500)
//                {
//                    Demo1.pappuYcord +=10;
//                    g.drawImage(pappu[i],50,Demo1.pappuYcord,null);
//                }
//            }

            if(((Demo1.isAppleColliding(50,Demo1.pappuYcord,apple1XCord,apple1YCord)) )) {
                apple1Visible = false;
                hitSound.play();
                standEscape=false;
            }
            if( (Demo1.isAppleColliding(50,Demo1.pappuYcord,apple2XCord,apple2YCord)) )
            {
                apple2Visible = false;
                hitSound.play();
                standEscape=false;

            }
            if( (Demo1.isAppleColliding(50,Demo1.pappuYcord,apple3XCord,apple3YCord)))
            {
                apple3Visible = false;
                hitSound.play();
                standEscape=false;

            }

            if(((Demo1.pappuYcord)>=500 )|| Demo1.pappuYcord <=(-50))
            {

                imageGraphics.setColor(Color.green);
                imageGraphics.fillRect(0,0,1000,500);
                imageGraphics.setColor(Color.BLACK);
                imageGraphics.setFont(new Font("Arial",Font.BOLD,100));
                imageGraphics.drawString("Game Over",200,300);
                imageGraphics.setFont(new Font("Arial",Font.BOLD,20));
                imageGraphics.drawString("Your Score : "+String.valueOf(Demo1.j),800,100);

                g.drawImage(image,0,0,null);
                break;
            }


            if(standEscape && Demo1.isColliding(50,Demo1.pappuYcord,stand1XCordinate,stand1YCordinate))
            {

                imageGraphics.setColor(Color.green);
                imageGraphics.fillRect(0,0,1000,500);
                imageGraphics.setColor(Color.BLACK);
                imageGraphics.setFont(new Font("Arial",Font.BOLD,100));
                imageGraphics.drawString("Game Over",200,300);
                imageGraphics.setFont(new Font("Arial",Font.BOLD,20));
                imageGraphics.drawString("Your Score : "+String.valueOf(Demo1.j),800,100);
                g.drawImage(image,0,0,null);
                hitSound.play();
                break;
            }
            if(standEscape && Demo1.isColliding(50,Demo1.pappuYcord,stand2XCordinate,stand2YCordinate))
            {

                imageGraphics.setColor(Color.green);
                imageGraphics.fillRect(0,0,1000,500);
                imageGraphics.setColor(Color.BLACK);
                imageGraphics.setFont(new Font("Arial",Font.BOLD,100));
                imageGraphics.drawString("Game Over",200,300);
                imageGraphics.setFont(new Font("Arial",Font.BOLD,20));
                imageGraphics.drawString("Your Score : "+String.valueOf(Demo1.j),800,100);
                g.drawImage(image,0,0,null);
                hitSound.play();
                break;
            }
            if(standEscape && Demo1.isColliding(50,Demo1.pappuYcord,stand3XCordinate,stand3YCordinate))
            {

                imageGraphics.setColor(Color.green);
                imageGraphics.fillRect(0,0,1000,500);
                imageGraphics.setColor(Color.BLACK);
                imageGraphics.setFont(new Font("Arial",Font.BOLD,100));
                imageGraphics.drawString("Game Over",200,300);
                imageGraphics.setFont(new Font("Arial",Font.BOLD,20));
                imageGraphics.drawString("Your Score : "+String.valueOf(Demo1.j),800,100);
                g.drawImage(image,0,0,null);
                hitSound.play();
                break;
            }
            g.clearRect(0,0,1000,500);
            if (startSound) {
//
//
                imageGraphics.setFont(new Font("Arial",Font.BOLD,50));

                imageGraphics.drawString(String.valueOf(Demo1.j), 900, 50);
            }
            if(!standEscape) {
                count--;
                imageGraphics.setColor(Color.BLACK);
                imageGraphics.setFont(new Font("Arial",Font.BOLD,30));
                imageGraphics.drawString(String.valueOf(count),800,50);
            }
            if(count==0)
            {
                count =150;
                standEscape=true;
            }

            //g.fill3DRect(0,0,1000,500,false);
            imageGraphics.drawImage(cloud,0,0,null);

            imageGraphics.drawImage(tree,0,0,null);
            imageGraphics.drawImage(groundImage, 0, 0, null);
            if (startSound) {
//
//
                imageGraphics.setFont(new Font("Arial",Font.BOLD,50));

                imageGraphics.drawString(String.valueOf(Demo1.j), 900, 50);
                g.drawImage(image,0,0,null);
            }
            if(!standEscape) {
                count--;
                imageGraphics.setColor(Color.BLACK);
                imageGraphics.setFont(new Font("Arial",Font.BOLD,30));
                imageGraphics.drawString(String.valueOf(count),800,50);
                g.drawImage(image,0,0,null);
            }
            if(count==0)
            {
                count =150;
                standEscape=true;
            }
            if(logVisible){
                imageGraphics.drawImage(logImage, 60, 340, null);

            }
            imageGraphics.drawImage(pauseImage,10,10,50,50,null);
//            if (!Demo1.pause) {g.setFont(new Font("Arial",Font.BOLD,20));
//                g.drawString("Press To PAUSE", 50, 120);
//            }
            if(apple1Visible)
                imageGraphics.drawImage(apple,apple1XCord,apple1YCord,null);


            if(apple2Visible)
                imageGraphics.drawImage(apple,apple2XCord,apple2YCord,null);
            if(apple3Visible)
                imageGraphics.drawImage(apple,apple3XCord,apple3YCord,null);


            imageGraphics.drawImage(standImage,stand1XCordinate,stand1YCordinate,null);
            imageGraphics.drawImage(standImage,stand2XCordinate,stand2YCordinate,null);
            imageGraphics.drawImage(standImage,stand3XCordinate,stand3YCordinate,null);
            playerImage = pappu[i];
            imageGraphics.drawImage(playerImage, 50, Demo1.pappuYcord, null);


            g.drawImage(image,0,0,null);

        }




    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (Demo1.pause) {
            return;
        }

        if(e.getKeyCode()==KeyEvent.VK_SPACE)
        {
            Demo1.pappuVel=-30;


            Demo1.pappuAcc=6;
            Demo1.logVisible=false;
            Demo1.startSound=true;
            Demo1.j++;

        }
        else if(e.getKeyCode()==KeyEvent.VK_ENTER)
        {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    private static  boolean isColliding(int playerX,int playerY,int blockX,int blockY)
    {
        boolean yOverlap=false;
        boolean xOverlap=(playerX > blockX && playerX <blockX+59)||(blockX > playerX && blockX < playerX +60);
        if(blockY==250) {
            yOverlap= (playerY > 250 && playerY < 500) || (250 > playerY && 250 < playerY + 60);
        }else if(blockY==-300)
        {
            yOverlap=(playerY > 0 && 145 > playerY + 60)||(playerY < 145 && 145 < playerY  + 60 );
        }
        return xOverlap && yOverlap;
    }

    private static  boolean isAppleColliding(int playerX,int playerY,int appleX,int appleY)
    {
        boolean xOverlap=(playerX > appleX && playerX <appleX+32)||( appleX > playerX && appleX < playerX +60);
        boolean yOverlap=false;
        if(appleY==200)
        {
            yOverlap= (playerY > 200 && playerY < 232)||(200 > playerY && 200 < playerY +60);

        }if(appleY==300)
    {
        yOverlap=(playerY > 300 && playerY < 332)||(300 > playerY && 300 < playerY +60);

    }

        if(appleY==150)
        {
            yOverlap=(playerY > 150 && playerY < 183)||(150 > playerY && 150 < playerY +60);
        }






        return xOverlap && yOverlap;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getX() > 10 && e.getX() < 60 && e.getY() > 10 && e.getY() < 60) {
            Demo1.pause = !Demo1.pause;


        }
        if(e.getX() > 0 && e.getX() < 1000 && e.getY() > 0 && e.getY() < 500)
        {
            Demo1.moveSound=true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {
        if(counts==1)
        {
            moveAudio.loop();
        }


    }
}
