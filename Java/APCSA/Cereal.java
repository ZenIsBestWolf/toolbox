public class Cereal {
    String name;
    String mfr;
    String type;
    int calories;
    int protein;
    int fat;
    int sodium;
    int fiber;
    int carbo;
    int sugars;
    int potass;
    int vitamins;
    int shelf;
    double weight;
    double cups;
    double rating;
    public Cereal(String inName, String inMfr, String inType, int inCalories, int inProtein, int inFat, int inSodium, int inFiber, int inCarbo,int inSugars,int inPotass, int inVitamins, int inShelf, double inWeight, double inCups, double inRating) {
        name = inName;
        mfr = inMfr;
        type = inType;
        calories = inCalories;
        protein = inProtein;
        fat = inFat;
        sodium = inSodium;
        fiber = inFiber;
        carbo = inCarbo;
        sugars = inSugars;
        potass = inPotass;
        vitamins = inVitamins;
        shelf = inShelf;
        weight = inWeight;
        cups = inCups;
        rating = inRating;
    }
    public String getName() {
        return name;
    }
    public String getMfr() {
        return mfr;
    }
    public String getType() {
        return type;
    }
    public int getCalories() {
        return calories;
    }
    public int getProtein() {
        return protein;
    }
    public int getFat() {
        return fat;
    }
    public int getSodium() {
        return sodium;
    }
    public int getFiber() {
        return fiber;
    }
    public int getCarbo() {
        return carbo;
    }
    public int getSugars() {
        return sugars;
    }
    public int getPotass() {
        return potass;
    }
    public int getVitamins() {
        return vitamins;
    }
    public int getShelf() {
        return shelf;
    }
    public double getWeight() {
        return weight;
    }
    public double getCups() {
        return cups;
    }
    public double getRating() {
        return rating;
    }

    public String toString() {
        return "" + rating;
    }

    public static void main(String[] args) {
        Cereal kix = new Cereal("Kix", "General Mills","C",110,2,1,260,0,21,3,40,25,2,1.0,1.5,39.241114);
        System.out.println(kix.getName());
        System.out.println(kix.getMfr());
        System.out.println(kix.getType());
        System.out.println(kix.getCalories());
        System.out.println(kix.getProtein());
        System.out.println(kix.getFat());
        System.out.println(kix.getSodium());
        System.out.println(kix.getFiber());
        System.out.println(kix.getCarbo());
        System.out.println(kix.getSugars());
        System.out.println(kix.getPotass());
        System.out.println(kix.getVitamins());
        System.out.println(kix.getShelf());
        System.out.println(kix.getWeight());
        System.out.println(kix.getCups());
        System.out.println(kix.getRating());
        System.out.println(kix);
    }
}