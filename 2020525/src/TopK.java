/*
 * @program: 2020525
 * @description
 * @author: mrs.yang
 * @create: 2020 -05 -27 13 :47
 */

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/*class MyComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;//大堆
    }
}*/
class Animal{
    public void func(){
        System.out.println("func");
    }
}
public class TopK {
    public static int[] topK(int[] arr,int k){
        //MyComparator myComparator=new MyComparator();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>(){
            @Override//匿名内部类
            public int compare(Integer o1, Integer o2) {
                return o2-o1;//大堆
            }
        });

       //将数组放入堆当中
        for (int i = 0; i <arr.length ; i++) {
            if(maxHeap.size()<k){
                maxHeap.offer(arr[i]);
            }else{
                Integer val=maxHeap.peek();
                if(val!=null&& arr[i]<val){
                    maxHeap.poll();
                    maxHeap.offer(arr[i]);
                }
            }
        }
        int[] ret=new int[k];
        for (int i = 0; i < k; i++) {
           int v= maxHeap.poll();
           ret[i]=v;
        }
        return ret;
    }

    public static void main(String[] args) {
        new Animal(){//匿名内部类
            //重写func 方法
            @Override
            public void func() {
                System.out.println("chongxie");
            }
        }.func();
    }
    public static void main1(String[] args) {
       int[] arr={13,5,8,1,5,6,9};
       int[] ret=topK(arr,4);
        System.out.println(Arrays.toString(ret));
    }
}
