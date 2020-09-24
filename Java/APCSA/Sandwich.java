class Sandwich {
    private String bread;
    Filling filling;
    private boolean isToasted;
    // Constructors
    public Sandwich(String b, Filling f, boolean isT) {
        bread = b;
        filling = f;
        isToasted = isT;
    }
    public String toString() {
        return "" + bread + ", " + filling + ", " + isToasted;
    }

    public static void main(String[] args) {
        Filling bruhFill = new Filling(true, 0);
        Sandwich bruh = new Sandwich("Italian", bruhFill,true);
        System.out.println(bruh);
        bruhFill.addTomato();
        System.out.println(bruh);
    }
}
class Filling {
    private boolean isPesc;
    private int numTomatoes;
    // Constructors
    public Filling(boolean isP, int nT) {
        isPesc = isP;
        numTomatoes = nT;
    }
    
    public void addTomato() {
        numTomatoes+=1;
    }
    public String toString() {
        return "[" + isPesc + ", " + numTomatoes + "]";
    }
}