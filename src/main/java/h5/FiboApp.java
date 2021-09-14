package h5;

class FiboApp{

    static int n1=0;
    static int n2=1;
    static int n3=0;

    public static void main(String[] args){
        int n=10;
        int start = 2;
        int f1 = 5;
        int f2 = 6;

 //    run(n);
//        run(start, n);
 //       run(f2, n);
    }

    public static void run(int n){
        int i;
        for(i=2;i<n;++i)
        {
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }
    }

    public static void run (int start, int n){
        n2 = start;
        int i;
        for (i = 1; i < n; ++i)
        {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
    }

    public static void run(int f1, int f2, int n) {
        n1 = f1;
        n2 = f2;
        System.out.print(n1 + " " + n2);
        int i;
        for (i = 2; i < n; ++i)
        {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
    }
}