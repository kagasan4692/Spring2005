public class exercise15 {
    public static void main(String[] args){
        // первый корень ax+b = 0 =>  ax = -b =>  x = -b/a;
        // второй корень cx+d = 0 =>  cx = -d =>  x = -d/c;
        int a, b, c, d;
        a = 2;
        b = 4;
        c = 3;
        d = 6;

        int x1 = b/a * (-1);
        int x2 = d/c * (-1);

        System.out.println(x1);
        System.out.println(x2);
    }
}
