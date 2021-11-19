package Methods;

public class Averages {
    public static double avgPPG = 0;
    public static double avgAPG = 0;
    public static double avgStPG = 0;
    public static double avgSPG = 0;

    public static void avgFinder(double p, double a, double st, double s, double t) {
        avgPPG = p/t;
        avgAPG = a/t;
        avgStPG = st/t;
        avgSPG = s/t;
    }
}
