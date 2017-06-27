import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static java.lang.System.out;

/**
 * Created by Ken Kelly (@kenhkelly) on 6/26/17.
 */
class Gui {

    static void runGui() {
        JFrame guiFrame = new JFrame();

        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("LoanCalcJava");
        guiFrame.setSize(300, 300);
        guiFrame.setLocationRelativeTo(null);

        final JTabbedPane pane = new JTabbedPane();
        pane.addTab("Monthly", MonthlyGui());
        pane.addTab("Loan", LoanGui());
        guiFrame.add(pane);
        guiFrame.setVisible(true);
    }

    private static JComponent LoanGui() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel header = new JLabel("Calculate Total Loan");
        header.setHorizontalAlignment(JLabel.CENTER);
        Font font = header.getFont();
        int size = (int) (font.getSize() * 1.2);
        header.setFont(new Font(font.getFontName(), Font.BOLD, size));
        addComponent(panel, header, 1, 1, 3,1);

        addComponent(panel, new JLabel("Monthly amount:"), 1,2,2,1);
        JTextField monthlyAmount = new JTextField();
        addComponent(panel, monthlyAmount, 3,2,1,1);

        addComponent(panel, new JLabel("Annual % Rate (APR):"), 1,3,2,1);
        JTextField aprAmount = new JTextField();
        addComponent(panel, aprAmount, 3,3,1,1);

        addComponent(panel, new JLabel("Loan Term in Years: "), 1,4,2,1);
        JTextField termAmount = new JTextField();
        addComponent(panel, termAmount, 3,4,1,1);

        addComponent(panel, new JLabel("Loan Is: "), 1,5,2,1);
        JTextField loanAmount = new JTextField();
        loanAmount.disable();
        addComponent(panel, loanAmount,3,5,1,1);


        Action action = new AbstractAction("Calculate") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (monthlyAmount.getText().length() == 0 || aprAmount.getText().length() == 0 || termAmount.getText().length() == 0) {
                    return;
                }
                float ma = Float.parseFloat(monthlyAmount.getText());
                float aa = Float.parseFloat(aprAmount.getText());
                float ta = Float.parseFloat(termAmount.getText());
                float loan = CalcLoan.calculate(ma, aa, ta);
                out.println(loan);
                loanAmount.setText(String.format("%.2f", loan));
            }
        };
        JButton button = new JButton(action);
        addComponent(panel, button, 1,6,3,1);

        InputMap input = panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        input.put(KeyStroke.getKeyStroke("ENTER"), "submit");
        panel.getActionMap().put("submit", action);

        return panel;
    }

    private static JComponent MonthlyGui() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel header = new JLabel("Calculate Monthly Payment");
        header.setHorizontalAlignment(JLabel.CENTER);
        Font font = header.getFont();
        int size = (int) (font.getSize() * 1.2);
        header.setFont(new Font(font.getFontName(), Font.BOLD, size));
        addComponent(panel, header, 1, 1, 3,1);

        addComponent(panel, new JLabel("Loan amount:"), 1,2,2,1);
        JTextField loanAmount = new JTextField();
        addComponent(panel, loanAmount, 3,2,1,1);

        addComponent(panel, new JLabel("Annual % Rate (APR):"), 1,3,2,1);
        JTextField aprAmount = new JTextField();
        addComponent(panel, aprAmount, 3,3,1,1);

        addComponent(panel, new JLabel("Loan Term in Years: "), 1,4,2,1);
        JTextField termAmount = new JTextField();
        addComponent(panel, termAmount, 3,4,1,1);

        addComponent(panel, new JLabel("Monthly Is: "), 1,5,2,1);
        JTextField monthlyAmount = new JTextField();
        monthlyAmount.disable();
        addComponent(panel, monthlyAmount,3,5,1,1);

        Action action = new AbstractAction("Calculate") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loanAmount.getText().length() == 0 || aprAmount.getText().length() == 0 || termAmount.getText().length() == 0) {
                    return;
                }

                float la = Float.parseFloat(loanAmount.getText());
                float aa = Float.parseFloat(aprAmount.getText());
                float ta = Float.parseFloat(termAmount.getText());
                float monthly = CalcMonthly.calculate(la, aa, ta);
                out.println(monthly);

                monthlyAmount.setText(String.format("%.2f", monthly));
            }
        };
        JButton button = new JButton(action);
        addComponent(panel, button, 1,6,3,1);

        InputMap input = panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        input.put(KeyStroke.getKeyStroke("ENTER"), "submit");
        panel.getActionMap().put("submit", action);

        return panel;
    }

    private static void addComponent(Container container, Component component, int x, int y, int width, int height) {
        GridBagConstraints gbc = new GridBagConstraints(x, y, width, height, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
                0, 0);
        container.add(component, gbc);
    }
}
