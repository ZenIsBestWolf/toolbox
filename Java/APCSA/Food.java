public class Food {
    private String mealType;
    private String color;
    private boolean isVegetarian;
    public Food() {
        mealType = "";
        color = "";
        isVegetarian = false;
    }
    public Food(String type, String col, boolean isVeg) {
        mealType = type;
        color = col;
        isVegetarian = isVeg;
    }
    public Food(String type, String col) {
        mealType = type;
        color = col;
        isVegetarian = false;
    }
    public Food(String type) {
        mealType = type;
        color = "";
        isVegetarian = false;
    }
    public void print() {
        System.out.println("Meal Type: " + mealType);
        System.out.println("Color: " + color);
        System.out.println("Is Vegetarian: " + isVegetarian);
    }
}