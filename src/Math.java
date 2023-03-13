public class Math {
    public static  int fact(int n){
        if (n == 1 || n == 0){
            return 1;
        }
        return n * fact(n -1);
    }
    public static int sign(int n){
        return Integer.compare(n, 0);
    }
}
    ч