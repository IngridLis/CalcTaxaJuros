import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraJurosFrame extends JFrame implements ActionListener {

    private JTextField tfParcelas, tfValorParcela, tfValorTotal, tfTaxaJuros, tfResultado;
    private JButton btnCalcular;

    public CalculadoraJurosFrame() {
        setTitle("Calculadora de Taxa de Juros");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Número de Parcelas:"));
        tfParcelas = new JTextField();
        add(tfParcelas);

        add(new JLabel("Valor da Parcela:"));
        tfValorParcela = new JTextField();
        add(tfValorParcela);

        add(new JLabel("Valor Total:"));
        tfValorTotal = new JTextField();
        add(tfValorTotal);

        add(new JLabel("Taxa de Juros (%):"));
        tfTaxaJuros = new JTextField();
        add(tfTaxaJuros);

        add(new JLabel("Resultado (Taxa de Juros Total):"));
        tfResultado = new JTextField();
        tfResultado.setEditable(false);
        add(tfResultado);

        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(this);
        add(btnCalcular);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            try {
                int parcelas = Integer.parseInt(tfParcelas.getText());
                double valorParcela = Double.parseDouble(tfValorParcela.getText().replace(",", "."));
                double valorTotal = Double.parseDouble(tfValorTotal.getText().replace(",", "."));

                double taxaJuros = CalculadoraJurosUtil.calcularTaxaJuros(parcelas, valorParcela, valorTotal);
                tfTaxaJuros.setText(String.format("%.2f", taxaJuros * 100));

                tfResultado.setText("A taxa de juros total é de " + String.format("%.2f", taxaJuros * 100) + "%");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, "Não é possível calcular a taxa de juros.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
