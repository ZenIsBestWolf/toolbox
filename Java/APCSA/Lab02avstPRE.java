// Lab02avst.java
// The AWT Graphics Program
// This is the student, starting version of Lab02a


import java.awt.*;
import java.applet.*;


public class Lab02avstPRE extends Applet
{

	public void paint(Graphics g)
	{
      Color black = new Color(0,0,0);
      Color white = new Color(255,255,255);
      Color red = new Color(255,0,0);
      Color green = new Color(0,255,0);
      Color blue = new Color(0,0,255);
      Color gray = new Color((float) 0, (float) 0,(float) 0,(float) 0.5);
      // Set screen size. This will be different on lower resolution screens an will likely break if lowered much further.
      this.setSize(3000,1600);
      // Set black color.
      g.setColor(black);
      // DRAW CUBE
      drawCube(g,500,500,500);
		// DRAW SPHERE
      drawSphere(g,450,450,500,130);
		// DRAW INSCRIBED/CIRCUMSCRIBED TRIANGLE
      g.drawOval(1500,500,400,400);
      g.drawPolygon(new int[] {1600,1898,1600},new int[] {530,700,878},3);
      g.drawOval(1600,600,200,200);
		// DRAW APCS
      // A outside
      g.setColor(red);
      g.drawRect(500,1200,150,250);
      g.fillRect(500,1200,150,250);
      // A inside
      g.setColor(white);
      g.drawRect(550,1350,50,100);
      g.fillRect(550,1350,50,100);
      g.drawRect(550,1250,50,50);
      g.fillRect(550,1250,50,50);
      // P outside
      g.setColor(blue);
      g.drawRect(700,1200,150,250);
      g.fillRect(700,1200,150,250);
      // P inside
      g.setColor(white);
      g.drawRect(750,1350,100,100);
      g.fillRect(750,1350,100,100);
      g.drawRect(750,1250,50,50);
      g.fillRect(750,1250,50,50);
      // C outside
      g.setColor(green);
      g.drawRect(900,1200,150,250);
      g.fillRect(900,1200,150,250);
      // C inside
      g.setColor(white);
      g.drawRect(950,1250,100,150);
      g.fillRect(950,1250,100,150);
      // S outside
      g.setColor(gray);
      g.drawRect(1100,1200,150,250);
      g.fillRect(1100,1200,150,250);
      // S inside
      g.setColor(white);
      g.drawRect(1150,1250,100,50);
		g.fillRect(1150,1250,100,50);
      g.drawRect(1100,1350,100,50);
      g.fillRect(1100,1350,100,50);
      // DRAW PACMEN FLOWER
      g.setColor(black);
      drawFlower(g,1400,800,100);
     }
   static void drawCube(Graphics g, int x, int y, int size) {
       int shift = size/4;
       int shiftedX = x - shift;
       int shiftedY = y - shift;
       g.drawRect(x,y,size,size); // Square one.
       g.drawRect(shiftedX,shiftedY,size,size); // Square two, which is a moved square one.
       g.drawLine(x,y,shiftedX,shiftedY); // This line and the next 3 draw the connecting lines to make it look like it's in a cube.
       g.drawLine(x+size,y,shiftedX+size,shiftedY);
       g.drawLine(x+size,y+size,shiftedX+size,shiftedY+size);
       g.drawLine(x,y+size,shiftedX,shiftedY+size);
   }
   static void drawSphere(Graphics g, int x, int y, int size, int stagger) {
       g.drawOval(x,y,size,size); // Draw big circle.
       for(int i=1;i<=3;i++) { // Draw horizontal ovals.
           int curStagger = stagger * i;
           int curHalfStagger = (stagger/2) * i;
           g.drawOval(x,y+curHalfStagger,size,size-curStagger);
       }
       for(int i=1;i<=3;i++) { // Draw veritcal ovals.
           int curStagger = stagger * i;
           int curHalfStagger = (stagger/2) * i;
           g.drawOval(x+curHalfStagger,y,size-curStagger,size);
       }
   }
   static void drawFlower(Graphics g, int x, int y, int petalSize) {
       // Top Right
       g.drawArc(x,y+petalSize,petalSize,petalSize,90,270);
       g.fillArc(x,y+petalSize,petalSize,petalSize,90,270);
       //Top Left
       g.drawArc(x-petalSize,y+petalSize,petalSize,petalSize,180,270);
       g.fillArc(x-petalSize,y+petalSize,petalSize,petalSize,180,270);
       // Bottom Right
       g.drawArc(x,y+petalSize*2,petalSize,petalSize,360,270);
       g.fillArc(x,y+petalSize*2,petalSize,petalSize,360,270);
       // Bottom Left
       g.drawArc(x-petalSize,y+petalSize*2,petalSize,petalSize,270,270);
       g.fillArc(x-petalSize,y+petalSize*2,petalSize,petalSize,270,270);
   }
}