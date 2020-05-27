/*
 *
 * @program: 2020525
 * @description
 * @author: mrs.yang
 * @create: 2020 -05 -26 19 :04
 */
class Generic<T extends Comparable<T>>{//泛型的上界 ，泛型没有下界
    T[] arr;
    public Generic(){
        this.arr=(T[])new Object[10];
    }
    public T max(){
        T max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].compareTo(max)>0 ){
                max=arr[i];
            }
        }
        return max;
    }
}
 class Generic2{
    public static <T extends Comparable<T>> T max(T[] arr){
        T max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].compareTo(max)>0 ){
                max=arr[i];
            }
        }
        return max;
    }
 }

public class TestDemo1 {
    public static void main(String[] args) {
        Generic2 generic2=new Generic2();
        Integer[] arr={1,5,3,8};
        System.out.println(Generic2.max(arr));
    }
}
