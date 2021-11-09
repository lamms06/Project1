package h4;

public class HourGlass {
    public static void main(String[] args) {

        int n = 9;
        int x = n*2-1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < x; k++) {
                System.out.print("*");
            }
            x-=2;
            System.out.println();
        }

        x = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n-1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < x; k++) {
                System.out.print("*");
            }
            x += 2;
            System.out.println();
        }

    }
}