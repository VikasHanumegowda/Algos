class Base {

    public void func3() {
        System.out.println("func2");
    }
}

class Derived extends Base {
    @Override
    public void func3(){   //  Is this an overriding method?
        System.out.println("In Derived Class func method");
    }
}

public class InheritDemo {
    public static void main(String [] args) {
        Base D = new Derived();
        D.func3();
    }
}