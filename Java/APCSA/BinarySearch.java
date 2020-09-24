import java.util.ArrayList;
public class BinarySearch {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(8);
        list.add(72);
        list.add(96);
        list.add(189);
        list.add(336);
        list.add(900);
        int sN = 8;
        boolean found = false;
        int min = 0;
        int max = list.size() - 1;
        int mid = (max+min)/2;
        while (!found && max>=min) {
            if (max-1 == mid && mid == min)
                break;
            if (list.get(mid) == sN)
                found = true;
            else if (list.get(mid) > sN)
                max = mid;
            else if (list.get(mid) < sN)
                min = mid;
            mid = (max+min)/2;
        }
        System.out.println(found);
        System.out.println(mid);
    }
}