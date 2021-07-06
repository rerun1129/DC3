public class Test {
    public int a = 10;
    public double x = 1.23;

    public boolean equals(Test other) {
        return a == other.a && x == other.x;
    }

    public static void main(String[] args) {
        Test test = new Test();
        Test test2 = new Test();
        // test2.a = 5;
        // test2.x = 1.2938457;

        if (test2.equals(test)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        test();


        //System.out.println(test.toString());
    }
    public static void test(){

        Object [] array = new Object[100];
        int a = 20;
        array[0] =  a;

        int b = (Integer) array[0];

        System.out.println(a);

        String str = "1234";
        int c = Integer.parseInt(str);
        System.out.println(str+str);
    }
}
