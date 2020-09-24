// Lab04vst.java
// This is the student, starting version of the Lab04 assignment.


import java.awt.*;
import java.applet.*;


public class Lab04vst extends Applet
{
	public void paint(Graphics g)
	{
     this.setSize(1000, 800);
		int width = 980;
		int height = 630;
		int x1 = 10;
		int y1 = 640;
		int x2 = 990;
		int y2 = 640;
		g.drawRect(10,10,width,height);
      doIt(g,width,height,x2,y1,x1,x2,false,true);
      doIt(g,width,height,x1,y1,x1,x1,true,true);
      doIt(g,width,height,x2,x1,y2,x2,false,false);
      doIt(g,width,height,x1,x1,y1,x1,true,false);
	}
   static void doIt(Graphics g, int width, int height, int tmpA, int staticA, int tmpB, int staticB, boolean isFirstAdding, boolean isSecondAdding) {
      for (int i=0;i<=51;i++) {
         g.drawLine(tmpA,staticA,staticB,tmpB);
         if (isFirstAdding) {
            tmpA+=width/50;
         } else if (!isFirstAdding) {
            tmpA-=width/50;
         }
         if (isSecondAdding) {
            tmpB+=height/50;
         } else if (!isSecondAdding) {
            tmpB-=height/50;
         }
      }
   }
}