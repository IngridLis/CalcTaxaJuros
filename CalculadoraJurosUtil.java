public class CalculadoraJurosUtil {

    public static double calcularTaxaJuros(int parcelas, double valorParcela, double valorTotal) {
        return Math.pow((valorTotal / (parcelas * valorParcela)), 1.0 / parcelas) - 1;
    }
}