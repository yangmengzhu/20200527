/*
 * @program: 2020525
 * @description
 * set和map练习题
 * @author: mrs.yang
 * @create: 2020 -05 -26 20 :32
 */

import java.util.*;

public class TestDemo2 {
    //只出现一次的数字
    public static int  singleNum(int[] arr){
        Set<Integer> set=new HashSet<>();
        for (int val:arr) {
            if(!set.contains(val)){
                set.add(val);
            }else{
                set.remove(val);
            }
        }
        return set.iterator().next();
    }
    //找出十万个数据当中第一个重复的数据
    public static void main1(String[] args) {
        Random random=new Random();
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        Set<Integer> set=new HashSet<>();
        for (Integer val:list) {
            if(set.contains(val)){
                System.out.println(val);
                return;
            }else{
                set.add(val);
            }
        }
    }
    //十万个数据去重复
    public static void main2(String[] args) {
        Random random=new Random();
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        Set<Integer> set=new HashSet<>();
        for (Integer val:list) {
            set.add(val);
        }
        System.out.println(set);
    }
    //统计出现的重复数据和次数
    public static void main(String[] args){
        Random random=new Random();
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for (Integer key:list) {
            if(map.get(key)==null){
                map.put(key,1) ;
            }else{
               int value=map.get(key);
               map.put(key,value+1);
            }
        }
    }

}
