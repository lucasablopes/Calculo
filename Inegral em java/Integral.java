public class Integral{
    public static final double precisao = 1E-4;

    public static void swap(double a, double b, boolean isNegativo){
        double tmp = a;
        a = b;
        b = tmp;
        isNegativo = true;
    }

    public static double calcular(double a, double b, Funcao funcao){
        double area = 0;
        boolean isNegativo = false;

        if(a > b)
            swap(a, b, isNegativo);

        for(double i = a + precisao; i < b; i += precisao){
            double distancia = i - a;
            area += (precisao/2) * (funcao.f(a + distancia) + funcao.f(a + distancia - precisao));
        }

        if(isNegativo)
            area = -area;

        return area;
    }

    public static void main(String[] args){
        System.out.println(calcular(0, 2, x -> Math.pow(x, 2)));
    }
}