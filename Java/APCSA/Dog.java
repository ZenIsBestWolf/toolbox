/**
 * Makes dogs!
 */
public class Dog {
    private String breed;
    private String sex;
    private int age;
    private String name;
    /**
     * No params.
     */
    public Dog() {
        breed = "";
        sex = "Unknown";
        age = 0;
        name = "";
    }
    public Dog(String inBreed, String inSex, int inAge, String inName) {
        breed = inBreed;
        sex = inSex;
        age = inAge;
        name = inName;
    }
    public Dog(String inBreed) {
        breed = inBreed;
        sex = "Unknown";
        age = 0;
        name = "";
    }
    public void print() {
        System.out.println("Breed: " + breed);
        System.out.println("Sex: " + sex);
        System.out.println("Age: " + age);
        System.out.println("Name: " + name);
    }
    public static void main(String[] args) {
        Dog dog1 = new Dog("Bassett Hound", "Female", 13, "Jessie");
        Dog dog2 = new Dog("Golden Retriever");
        Dog dog3 = new Dog();
        dog1.print();
        dog2.print();
        dog3.print();
    }
}