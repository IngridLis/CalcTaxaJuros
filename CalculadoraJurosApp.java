import javax.swing.*;

public class CalculadoraJurosApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraJurosFrame frame = new CalculadoraJurosFrame();
            frame.setVisible(true);
        });
    }
}
