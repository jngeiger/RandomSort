import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomSort<T extends Comparable<T>> {
    public static void main(String[] args)
    {


        Integer[] array1 = new Integer[] {50,23,5,1,6,2,8,21,99,211,4141};
        Integer[] array2 = new Integer[] {50,23,5,1,6,2,8,21,99,211,4141};
        Integer[] array3 = new Integer[] {50,23,5,1,6,2,8,21,99,211,4141};
        Integer[] array4 = new Integer[] {50,23,5,1,6,2,8,21,99,211,4141};
        RandomSort rs = new RandomSort();
        Thread t1 = new Thread() {
            public void run()
            {
                rs.randomSort(Arrays.asList(array1));
            }
        };
        Thread t2 = new Thread() {
            public void run()
            {
                rs.randomSort(Arrays.asList(array2));
            }
        };
        Thread t3 = new Thread() {
            public void run()
            {
                rs.randomSort(Arrays.asList(array3));
            }
        };
        Thread t4 = new Thread() {
            public void run()
            {
                rs.randomSort(Arrays.asList(array4));
            }
        };
        t1.start(); t2.start();t3.start();t4.start();

        while (t1.isAlive() && t2.isAlive() && t3.isAlive() && t4.isAlive())
        { continue; }
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        t1.stop();
        t2.stop();
        t3.stop();
        t4.stop();
    }

    public void randomSort(List<T>list)
    {
        while(!isSorted(list))
        {
            Random dice = new Random();
            swapAtIndex(list, dice.nextInt(list.size()), dice.nextInt(list.size()));
        }
    }

    public Boolean isSorted(List<T> list)
    {
        for (int i = 1; i < list.size();i++)
        {
            if (list.get(i).compareTo(list.get(i-1))< 0)
                return false;
        }
        return true;
    }

    private void swapAtIndex(List<T> list, int one, int two)
    {
        T temp = list.get(one);
        list.set(one,list.get(two));
        list.set(two,temp);
    }
}
