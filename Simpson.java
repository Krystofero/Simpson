package Simpson;

import java.util.Scanner;

public class Simpson {

    public double Funkcja(double x) {
        double fun;
        // fun = (float) Math.pow(x, 2);
        fun = (double) (Math.sin(0.4 * Math.pow(x, 2) - 2.1) / Math.sqrt(1.1 * x + 0.3));
        return fun;
    }

    public static void main(String[] args) {
        Simpson s = new Simpson();
        int n;
        double a, b, h, calka;

        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj przedział od: (a)");
        a = sc.nextFloat();
        System.out.println("do: (b)");
        b = sc.nextFloat();
        System.out.println("Podaj wartosc n(na ile części dzielimy przedział):");
        n = sc.nextInt();

        h = (b - a) / (2 * n); // h = odleglosc miedzy xi a ti ;(odleglość między xi a xi+1 dzielona na 2)

        double x[] = new double[2 * n + 1]; //mamy 2 razy więcej punktów w porównaniu z metodą trapezów, gdyż dochodzą jeszcze punkty ti pomiędzy xi
        x[0] = a; //pierwszy równy a
        x[2 * n] = b; //ostatni równy b
        calka = 0;
        calka += s.Funkcja(x[0]);
        calka += s.Funkcja(x[2 * n]);

        for (int i = 1; i < 2 * n; i++) {//wyznaczam punkty xi:
            x[i] = x[i - 1] + h;
        }
        for (int i = 1; i < 2 * n; i++) {
            if ((i % 2) != 0) { //jeśli punktem jest ti
                calka += 4 * s.Funkcja(x[i]);
            } else if ((i % 2) == 0) {//jeśli punktem jest xi
                calka += 2 * s.Funkcja(x[i]);
            }
        }
        calka = h / 3 * calka;
        System.out.println("Calka: " + calka);
    }

}


//    public static void main(String[] args) {
//        Simpson s = new Simpson();
//        int n;
//        float a,b,h,ti;
//        float calka = 0;
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Podaj przedział od: (a)");
//        a = sc.nextFloat();
//        System.out.println("do: (b)");
//        b = sc.nextFloat();
//        System.out.println("Podaj wartosc n(na ile części dzielimy przedział):");
//        n = sc.nextInt();
//
//
//        float xi[]= new float[n+1]; //wartości funkcji punktów w przedziale(skoro mamy n przedziałów to jest n+1 punktów xi)
//        xi[0] = a; //pierwszy równy a
//        xi[n] = b; //ostatni równy b
//
//        h = (b-a) / (2*n); //odleglość między xi a xi+1 dzielona na 2 ;w porównaniu z metodą trapezów dzielimy jeszcze przez 2(mamy h = odległość między xi a ti)
//
//
//
//        calka += s.Funkcja(xi[0]);
//        calka += s.Funkcja(xi[n]);
//
//        for(int i=1;i<n;i++){ //wyznaczam punkty xi:
//            xi[i] = a + i*h;
//        }
//        int sum1 = 0;
//        for(int i=0;i<n;i++){
//            ti = (xi[i+1] + xi[i]) / 2;
//            sum1 += s.Funkcja(ti);
//        }
//        calka += 4*sum1;
//
//        int sum2 = 0;
//        for(int i=1;i<n;i++){
//            sum2 += s.Funkcja(xi[i]);
//        }
//        calka += 2*sum2;
//
//        calka = h/3 * calka;
//        System.out.println("Calka: " + calka);
//
//
//
////        for(int i=1;i<n;i++){ //wyznaczam punkty xi:
////            xi[i] = a + i*h;
////        }
////        for(int i=0;i<n;i++){
////            ti = (xi[i+1] + xi[i]) / 2;
////            calka += (4*s.Funkcja(ti) + s.Funkcja(xi[i+1]));
////        }
////        calka += s.Funkcja(xi[0]) + s.Funkcja(xi[n]);
////        calka = h/3 * calka;
////        System.out.println("Calka: " + calka);
//    }
//}
