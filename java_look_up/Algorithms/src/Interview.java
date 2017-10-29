class T1{
    public void write(T1 e){
        print("T1/2 ");
        e.write();
    }
    protected void write(){
        print("T1 ");
    }
    protected void print(String s){
        System.out.print(s);
    }
}

class T2 extends T1{
    public void write(T2 e){
        print("T2/2 ");
        e.write();
    }
    protected void write(){
        print("T2 ");
    }
}

public class Interview{
    public static void main(String[] args){
        T1 t1 = new T1();
        T2 t2 = new T2();
        T1 t12 = new T2();

        t1.write(t1);
        t1.write(t2);
        t1.write(t12);

        t2.write(t1);
        t2.write(t2);
        t2.write(t12);
        t2.write((T2)t12);

        t12.write(t1);
        t12.write(t2);
        ((T2)t12).write(t2);
        t12.write(t12);
        ((T2)t12).write((T2)t12);
    }
}