package Folha;

public class IRRF2026 implements Imposto {

    @Override
    public double calcular(double base) {

        if (base <= 2112.00) {
            return 0;
        } 
        else if (base <= 2826.65) {
            return (base * 0.075) - 158.40;
        } 
        else if (base <= 3751.05) {
            return (base * 0.15) - 370.40;
        } 
        else if (base <= 4664.68) {
            return (base * 0.225) - 651.73;
        } 
        else {
            return (base * 0.275) - 884.96;
        }
    }
}