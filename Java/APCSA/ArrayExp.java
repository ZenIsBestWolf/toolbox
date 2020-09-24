/**
 * In this exploratory you will instantiate a 1-D static array, use both loop structures, work with error messages, 
 * see the difference between deep and shallow memory values, and swap array elements.
 * 
 * @author Mr. Redacted
 * @version 12.15.16
 */
public class ArrayExp
{
    public static void main(String[] args)
    {
        //Create a String array called names and populate it with 11 names. You can do this either with an initializer list 
        //or one index at a time.
        String[] names = {"R","e","d","a","c","t","e","d","!","!!","!!!"};
        int x = 5;
        int y = 10;
        System.out.println("pre-swap x is:  " + x);
        System.out.println("pre-swap y is:  " + y);
        swap(x, y);
        System.out.println("post-swap x is:  " + x);
        System.out.println("post-swap y is:  " + y);
        //Use the 'old' for loop to print every name. Use the 'length' field, not 11. 
        for (int i=0;i<names.length;i++) 
            System.out.println(names[i]);
        printarray(names);
        //Use the enhanced for..each loop to print every name.
        for (String bruh: names)
            System.out.println(bruh);
        //Use the enhanced for..each loop to change the elements of names and print.  Did it work? Why/not?
        for (String hee: names) {
            hee = hee + " B.";
        }
        printarray(names); 
        //Print 4 random names from the array. Use either a Random object or the random method.
        for (int i=0;i<4;i++) {
            int r = (int) (Math.random() * 11);
            System.out.println(names[r]);
        }
        //Little Johnny is trying to print the last name in your list.
        //Uncomment the next line and look at the error message.  What is happening?  Fix it so it prints the last name.
        System.out.println(names[names.length - 1]);
        
        //Pass your array to the print statement below.  What happened?  why?
        //System.out.println(PUT YOUR ARRAY NAME HERE);
        //Fix the issue so that you can print the names in the list - perhaps write a new method (outside the main) and call it.
        
        // You did this for us.

        //Correctly swap the first two names in the list and print the list again to check. Write a method for swapping.

        arraySwap(names, 0, 10);
        printarray(names);
        
        //Swap every other element using a loop. Elements 0 and 1 should swap, then 2 and 3 , and so on. 
        //Being that your list has an odd number of elements, it should not swap the last element.
        //the method should work for any size array > 1. (Use a variable for the ending index)
        
        for (int i=0;i<names.length-1;i+=2) {
            arraySwap(names, i,i+1);
        }
        printarray(names);
        //Write a method called toBetty() that accepts a String array and changes all the names to 'Betty'.
        //names = toBetty(names);
        //printarray(names);
        //OOOOOps!! We have more names to add to the array.  Write code with loops (plural) that will put the elements of the two arrays into a third, longer array.
        //These new elements should be at the end of the array.
        // String [] oops = {"Alpha", "Beta", "Gamma", "Delta", "Epsilon"};
        //Write code that creates an array named 'odds' and stores all odd numbers between -6 and 38 using a for loop. 
        //Make the array's size exactly large enough to store the numbers.
    
        // printarray(odds);
        ///////////////////////////////   END OF FIRST PART OF THE EXPLORATORY  //////////////////////////////////
        
    } //END OF MAIN
    ////////////////////   PUT METHODS BELOW HERE   //////////////////////
    public static void printarray(String[] arr){
        System.out.print("[");
        for(int k = 0; k < arr.length-1; k++)
            System.out.print(arr[k] + ", ");  //no braces needed b/c it's only one line.
        System.out.println( arr[arr.length-1] + "]");
    }
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
    public static void arraySwap(String[] in, int a, int b) {
        String tmp = in[a];
        in[a] = in[b];
        in[b] = tmp;
    }
    public static String[] toBetty(String[] in) {
        String[] n = in;
        for (int i = 0; i < n.length; i++) {
            n[i] = "Betty";
        }
        return n;
    }
}    //END OF CLASS