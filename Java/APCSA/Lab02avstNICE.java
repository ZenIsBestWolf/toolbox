import java.awt.*;
import java.applet.*;
public class Lab02avstNICE extends Applet {
	public void paint(Graphics g) {
		// Define color set.
		Color black = new Color(0,0,0);
		Color white = new Color(255,255,255);
		Color red = new Color(255,0,0);
		Color green  = new Color(0,255,0);
		Color blue = new Color(0,0,255);
		Color gray = new Color((float)0,(float)0,(float)0,(float)0.5);
		this.setSize(3000,1600); // Applet window size.
		g.setColor(black); // Make sure default color is set.
		drawCube(g,500,500,500); // Draw cube.
		drawSphere(g,450,450,500,130); // Draw sphere.
		drawFlower(g,1400,800,100); // Draw pacmen flower.
		// Draw inscribed triangle.
		g.drawOval(1500,500,400,400); // Draw outer circle.
		g.drawPolygon(new int[] {1600,1898,1600},new int[] {530,700,878},3); // Draw triangle.
		g.drawOval(1600,600,200,200); // Draw inner circle.
		// Draw APCS
		// Outside of A.
		g.setColor(red); // Color of outside.
		// Draw an fill the base.
		g.drawRect(500,1200,150,250);
		g.fillRect(500,1200,150,250);
		// Inside of A.
		g.setColor(white); // Appear translucent.
		// Draw and fill the larger lower detail.
		g.drawRect(550,1350,50,100);
		g.fillRect(550,1350,50,100);
		// Draw and fill the smaller upper detail.
		g.drawRect(550,1250,50,50);
		g.fillRect(550,1250,50,50);
		// Outside of P.
		g.setColor(blue); // Color of outside.
		// Draw an fill the base.
		g.drawRect(700,1200,150,250);
		g.fillRect(700,1200,150,250);
		// Inside of P.
		g.setColor(white); // Appear translucent.
		// Draw and fill the larger lower detail.
		g.drawRect(750,1350,100,100);
		g.fillRect(750,1350,100,100);
		// Draw and fill the smaller upper detail.
		g.drawRect(750,1250,50,50);
		g.fillRect(750,1250,50,50);
		// Outside of C.
		g.setColor(green); // Color of outside.
		// Draw an fill the base.
		g.drawRect(900,1200,150,250);
		g.fillRect(900,1200,150,250);
		// Inside of C.
		g.setColor(white); // Appear translucent.
		// Draw and fill the detail.
		g.drawRect(950,1250,100,150);
		g.fillRect(950,1250,100,150);
		// Outside of S.
		g.setColor(gray); // Color of outside.
		// Draw an fill the base.
		g.drawRect(1100,1200,150,250);
		g.fillRect(1100,1200,150,250);
		// Inside of S.
		g.setColor(white); // Appear translucent.
		// Draw and fill the upper detail.
		g.drawRect(1150,1250,100,50);
		g.fillRect(1150,1250,100,50);
		// Draw and fill the lower detail.
		g.drawRect(1100,1350,100,50);
		g.fillRect(1100,1350,100,50);
	}
	static void drawCube(Graphics g, int x, int y, int size) {
		int shift = size/4;
		int shiftedX = x-shift;
		int shiftedY = y-shift;
		g.drawRect(x,y,size,size); // Square one.
		g.drawRect(shiftedX,shiftedY,size,size); // Square two, which is a moved square one.
		// Draw the connecting lines to form the illusion of a cube.
		g.drawLine(x,y,shiftedX,shiftedY);
		g.drawLine(x+size,y,shiftedX+size,shiftedY);
		g.drawLine(x+size,y+size,shiftedX+size,shiftedY+size);
		g.drawLine(x,y+size,shiftedX,shiftedY+size);
	}
	static void drawSphere(Graphics g, int x, int y, int size, int stagger) {
		g.drawOval(x,y,size,size); // Draw outer large circle.
		for(int i=1;i<=3;i++) { // Draw horizontal ovals.
			int curStagger = stagger*i;
			int curHalfStagger = (stagger/2)*i;
			g.drawOval(x,y+curHalfStagger,size,size-curStagger);
		}
		for(int i=1;i<=3;i++) { // Draw veritcal ovals.
			int curStagger = stagger*i;
			int curHalfStagger = (stagger/2)*i;
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