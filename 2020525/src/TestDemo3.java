/*
 * @program: 2020525
 * @description
 * 内部类
 * @author: mrs.yang
 * @create: 2020 -05 -27 14 :22
 */
class OuterClass{
    public int data1=2;
    public static int data2=3;
    class InnerClass{//实例内部类
        public int data1=1;
        public int data3=4;
        public static final int a=9;//实例内部类当中不可以有静态的数据成员
        //但是我们可以做到有：加final修饰（常量-》在编译时期确定/被初始化）
        public void func(){
            System.out.println(data1);//1局部变量优先
            System.out.println(OuterClass.this.data1);//2
            // OuterClass.this->外部类对象的引用->this是静态的引用（通过类名来调用）
            //实例内部类当中有额外的开销（包含外部类的this对象）
            System.out.println(data2);
            System.out.println(data3);
        }
    }
}
public class TestDemo3 {
    public static void main(String[] args) {
        OuterClass outerClass=new OuterClass();
        OuterClass.InnerClass innerClass=outerClass.new InnerClass();
        innerClass.func();
    }
}
