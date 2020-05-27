/*
 *
 * @program: 2020525
 * @description
 * 基于比较的排序
 * @author: mrs.yang
 * @create: 2020 -05 -25 15 :58
 */

import java.util.Arrays;
import java.util.Stack;

public class TestDemo {
    //直接插入排序 稳定排序 时间复杂度最坏情况下O(N^2) 最好O(n) 空间复杂度O(1)
    public static void insertSort(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            int tmp=arr[i];
            int j;
            for (j = i-1; j >=0 ; j--) {
                if(arr[j]>tmp){//此处加等号会变成不稳定的排序
                    arr[j+1]=arr[j];
                }else{
                    break;
                }
            }
            arr[j+1]=tmp;
        }
    }
    //直接插入排序
    public void insert(int[] array){
        for (int i = 1; i <array.length ; i++) {
            int tmp=array[i];
            int j;
            for (j = i-1; j >=0 ; j--) {
                if(array[j]>tmp){
                    array[j+1]=array[j];
                }else{
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }
    //希尔排序
    public static void  shell(int[] array,int gap){
        for (int i = gap; i <array.length ; i++) {
            int tmp=array[i];
            int j;
            for (j = i-gap; j >=0 ; j-=gap) {
                if(array[j]>tmp){
                    array[j+gap]=array[j];
                }else{
                    break;
                }
            }
            array[j+gap]=tmp;
        }
    }
    public static void shellSort(int[] array){
        int[] drr={5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }
   //选择排序 时间复杂度：最好最坏都是O(N^2) 空间复杂度O(1)  不稳定的排序
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if(array[j]<array[i]){//比较的是i和j位置的值大小，然后j++
                    int tmp=array[i];
                    array[i]=array[j];
                    array[j]=tmp;
                }
            }
        }
    }
    //堆排 时间复杂度：有序无序都是O(n*logn) 空间复杂度：O(1) 稳定性：不稳定
    public static void adjustDown(int[] array,int root,int len){
        int parent=root;
        int child=2*parent+1;
        while(child<len){
           if(child+1<len&&array[child]<array[child+1]){
               child++;
           }
           if(array[child]>array[parent]){
               int tmp=array[child];
               array[child]=array[parent];
               array[parent]=tmp;
               parent=child;
               child=2*parent+1;
           }else{
               break;
           }
        }
    }
    public static void creatHeap(int[] array){
        for (int i = (array.length-1-1)/2; i >=0; i--) {
            adjustDown(array,i,array.length);
        }
    }
     public static void heapSort(int[] array){
        creatHeap(array);
        int end=array.length-1;
        while(end>0){
           int tmp=array[0];
           array[0]=array[end];
           array[end]=tmp;
           adjustDown(array,0,end);
            end--;
        }
     }
     //冒泡排序
    public static void bubbleSort(int[] array){
        boolean flag=false;
        for (int i = 0; i < array.length-1; i++) {
            flag=false;
            for (int j = 0; j <array.length-1-i ; j++) {
                if(array[j]>array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
                flag=true;
            }
        }
        if(flag==false){
            return;
        }
    }
    //快速排序(原理：二叉树递归）不稳定 时间复杂度：O(nlogn) 最坏情况下：有序O(N^2)
    // 空间复杂度：最好O(logn)  最坏O(n)
    //快排要快，每次划分序列是，都可以均匀划分效率最高
    public static int partition(int[] array,int low,int high){
        int tmp=array[low];
        while(low<high){
            while(low<high&&array[high]>=tmp){
                high--;
            }
            array[low]=array[high];
            while(low<high&&array[low]<=tmp){
                low++;
            }
            array[high]=array[low];
        }
        array[high]=tmp;
        return high;
    }
    public static void insertSort1(int[] array,int low,int high){
        for (int i = low+1; i <=high; i++) {
            int tmp=array[i];
            int j;
            for (j = i-1; j >=low ; j--) {
                if(array[j]>tmp){
                    array[j+1]=array[j];
                }else{
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }
    public static void threeNumMid(int[] array,int mid,int low,int high){
        //array[mid]<=array[low]<=array[high]
        if(array[mid]>array[low]){
            int tmp=array[mid];
            array[mid]=array[low];
            array[low]=tmp;
        }
        if(array[mid]>array[high]){
            int tmp=array[mid];
            array[mid]=array[high];
            array[high]=tmp;
        }
        if(array[low]>array[high]){
            int tmp=array[low];
            array[low]=array[high];
            array[high]=tmp;
        }
    }
    public static void quick(int[] array,int left,int right){
        if(left>=right){
            return;
        }
        //优化方式一：
        if(right-left+1<=100){
            insertSort1(array,left,right);
            return;
        }
        //当数据有序时，三数取中法
        threeNumMid(array,(left+right)/2,left,right);
        int par=partition(array,left,right);
        quick(array,left,par-1);
        quick(array,par+1,right);
    }
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }
 //非递归实现快速排序(利用栈）
    public static void quickSortNor(int[] array){
        int left=0;
        int right=array.length-1;
        Stack<Integer> stack=new Stack<>();
        int par=partition(array,left,right);
        if(par>left+1){//par左边元素个数大于1
            stack.push(left);
            stack.push(par-1); 
        }
        if(right-1>par){
            stack.push(par+1);
            stack.push(right);
        }
        while(!stack.empty()){
            right=stack.pop();
            left=stack.pop();
            par=partition(array,left,right);
            if(par>left+1){//par左边元素个数大于1
                stack.push(left);
                stack.push(par-1);
            }
            if(right-1>par){
                stack.push(par+1);
                stack.push(right);
            }
        }
    }
    //递归实现归并排序  稳定  时间复杂度：O(n*logn)       空间复杂度O(N)
    public static void merge(int[] arr,int mid,int low,int high){
        int s1=low;
        int s2=mid+1;
        int[] ret=new int[high-low+1];
        int i=0;
        while(s1<=mid&&s2<=high){//两个段都有值
            if(arr[s1]<=arr[s2]){
                ret[i++]=arr[s1++];
            }else{
                ret[i++]=arr[s2++];
            }
        }
        while(s1<=mid){
            ret[i++]=arr[s1++];
        }
        while(s2<=high){
            ret[i++]=arr[s2++];
        }
        for (int j = 0; j < ret.length; j++) {
            arr[j+low]=ret[j];
        }
    }
    public static void mergeSortInternal(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int mid=(low+high)/2;
        mergeSortInternal(arr,low,mid);
        mergeSortInternal(arr,mid+1,high);
        merge(arr,mid,low,high);
    }
    public static void mergeSort(int[] arr){
        mergeSortInternal(arr,0,arr.length-1);
    }
    //非递归实现归并排序
    public static void mergeNor(int[] arr,int gap){
        int[] ret=new int[arr.length];
        int k=0;
        int s1=0;
        int e1=s1+gap-1;
        int s2=e1+1;
        int e2=s2+gap-1<arr.length?s2+gap-1:arr.length-1;
        while(s2<arr.length){//肯定有两个归并段
            //比较对应的s1和s2
            while(s1<=e1&&s2<=e2){
                if(arr[s1]<=arr[s2]){//不写等号就变成不稳定的排序
                    ret[k++]=arr[s1++];
                }else{
                    ret[k++]=arr[s2++];
                }
            }
            //s1 或者s2走完
            while(s1<=e1){
                ret[k++]=arr[s1++];
            }
            while(s2<=e2){
                ret[k++]=arr[s2++];
            }
            //确定新的s1e1s2e2
            s1=e2+1;
            e1=s1+gap-1;
            s2=s1+1;
            e2=s2+gap-1<arr.length?s2+gap-1:arr.length-1;
        }
        //只有一个归并段
        while(s1<=arr.length-1){
            ret[k++]=arr[s1++];
        }
        //拷贝到arr数组中
        for (int i = 0; i < ret.length; i++) {
            arr[i]=ret[i];
        }
    }
    public static void mergeNorSort(int[] arr){
        for (int i = 1; i < arr.length; i*=2) {
            mergeNor(arr,i);
        }
    }
    //非递归实现归并排序

    public static void main(String[] args) {
        int[] array={10,5,8,1,4,9};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
       // heapSort(array);
        //bubbleSort(array);
        //quickSort(array);
       // mergeSort(array) ;
        mergeNorSort(array);
        System.out.println(Arrays.toString(array));
    }
}
