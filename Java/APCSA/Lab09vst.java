// Lab09vst.java
// Redacted Classmate and Redacted
import java.applet.*;
import java.awt.*;

public class Lab09vst extends Applet {
    public void paint(Graphics g) {
        JackOLantern jack = new JackOLantern("scary", Color.BLACK);
        jack.draw(g);
    }
}

class Pumpkin {
    boolean hasStem;
    Color color;
    public Pumpkin () {
        hasStem = true;
        color = Color.ORANGE;
    }
    public Pumpkin (boolean hasStem) {
        this.hasStem = hasStem;
        color = Color.ORANGE;
    }
    public Pumpkin (Color color) {
        hasStem = true;
        this.color = color;
    }
    public Pumpkin (boolean hasStem, Color color) {
        this.hasStem = hasStem;
        this.color = color;
    }

    public String toString() {
        return "PUMPKIN DATA: [hasStem:" + hasStem + ", color:" + color + "]";
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(50,50,100,100);
        g.fillOval(50,50,100,100);
        if(hasStem) {
            g.setColor(Color.GREEN);
            g.drawRect(88,10,20,40);
            g.fillRect(88,10,20,40);
        }
    }
}

class JackOLantern extends Pumpkin {
    Face face;

    public JackOLantern() {
        super();
        face = new Face("scary");
    }
    public JackOLantern(Face face) {
        super();
        this.face = face;
    }
    public JackOLantern(String faceType) {
        super();
        face = new Face(faceType);
    }
    public JackOLantern(String faceType, Color faceColor) {
        super();
        face = new Face(faceType,faceColor);
    }

    public String toString() {
        return super.toString() + "\nJACKOLANTERN DATA: " + face;
    }

    public void draw(Graphics g) {
        super.draw(g);
        face.draw(g);
    }
}

class Face {
    Color faceColor;
    String type;

    public Face(String type) {
        if (validate(type)) {
            this.type = type;
            faceColor = Color.BLACK;
        }
    }
    public Face (String type, Color color) {
        if (validate(type)) {
            this.type = type;
            faceColor = color;
        }
    }

    public String toString() {
        return "face[type:" + type + ", faceColor:" + faceColor + "]";
    }

    public void draw(Graphics g) {
        g.setColor(faceColor);
        if (type == "neutral" || type == "scary") {
            g.drawRect(75,75,10,20);
            g.fillRect(75,75,10,20);
            g.drawRect(120,75,10,20);
            g.fillRect(120,75,10,20);
            g.drawOval(65,120,70,10);
            g.fillOval(65,120,70,10);
        }
        if (type == "scary") {
            g.drawLine(72,65,90,80);
            g.drawLine(130,65,112,80);
        }
    }

    private boolean validate(String val) {
        if (val == "scary") return true;
        else if (val == "neutral") return true;
        else return false;
    }
}