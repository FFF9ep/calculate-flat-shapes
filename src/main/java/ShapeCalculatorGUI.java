import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeCalculatorGUI {
    private JFrame frame;
    private JTextField txtLength, txtWidth, txtRadius, txtBase, txtHeight, txtSide1, txtSide2, txtSide3;
    private JTable table;
    private DefaultTableModel tableModel;

    public ShapeCalculatorGUI() {
        frame = new JFrame("Hitung Luas dan Keliling Bangun Datar");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        JLabel lblLength = new JLabel("Panjang: ");
        JLabel lblWidth = new JLabel("Lebar: ");
        JLabel lblRadius = new JLabel("Jari Jari: ");
        JLabel lblBase = new JLabel("Basis: ");
        JLabel lblHeight = new JLabel("Tinggi: ");
        JLabel lblSide1 = new JLabel("Sisi 1: ");
        JLabel lblSide2 = new JLabel("Sisi 2: ");
        JLabel lblSide3 = new JLabel("Sisi 3: ");

        txtLength = new JTextField(10);
        txtWidth = new JTextField(10);
        txtRadius = new JTextField(10);
        txtBase = new JTextField(10);
        txtHeight = new JTextField(10);
        txtSide1 = new JTextField(10);
        txtSide2 = new JTextField(10);
        txtSide3 = new JTextField(10);

        JButton btnCalculateRectangle = new JButton("Hitung Persegi");
        JButton btnCalculateCircle = new JButton("Hitung Lingkaran");
        JButton btnCalculateTriangle = new JButton("Hitung Segitiga");

        tableModel = new DefaultTableModel(new Object[]{"Bentuk", "Luas", "Keliling"}, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 150));

        frame.add(lblLength);
        frame.add(txtLength);
        frame.add(lblWidth);
        frame.add(txtWidth);
        frame.add(btnCalculateRectangle);

        frame.add(lblRadius);
        frame.add(txtRadius);
        frame.add(btnCalculateCircle);

        frame.add(lblBase);
        frame.add(txtBase);
        frame.add(lblHeight);
        frame.add(txtHeight);
        frame.add(lblSide1);
        frame.add(txtSide1);
        frame.add(lblSide2);
        frame.add(txtSide2);
        frame.add(lblSide3);
        frame.add(txtSide3);
        frame.add(btnCalculateTriangle);

        frame.add(scrollPane);

        btnCalculateRectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtLength.getText().isEmpty() && !txtWidth.getText().isEmpty()) {
                    double length = Double.parseDouble(txtLength.getText());
                    double width = Double.parseDouble(txtWidth.getText());
                    Rectangle rectangle = new Rectangle(length, width);
                    addResultToTable("Persegi", rectangle.calculateArea(), rectangle.calculatePerimeter());
                } else {
                    JOptionPane.showMessageDialog(frame, "Isi semua area.");
                }
            }
        });

        btnCalculateCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtRadius.getText().isEmpty()) {
                    double radius = Double.parseDouble(txtRadius.getText());
                    Circle circle = new Circle(radius);
                    addResultToTable("Lingkaran", circle.calculateArea(), circle.calculatePerimeter());
                } else {
                    JOptionPane.showMessageDialog(frame, "Isi semua area.");
                }
            }
        });

        btnCalculateTriangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtBase.getText().isEmpty() && !txtHeight.getText().isEmpty() &&
                        !txtSide1.getText().isEmpty() && !txtSide2.getText().isEmpty() && !txtSide3.getText().isEmpty()) {
                    double base = Double.parseDouble(txtBase.getText());
                    double height = Double.parseDouble(txtHeight.getText());
                    double side1 = Double.parseDouble(txtSide1.getText());
                    double side2 = Double.parseDouble(txtSide2.getText());
                    double side3 = Double.parseDouble(txtSide3.getText());
                    Triangle triangle = new Triangle(base, height, side1, side2, side3);
                    addResultToTable("Segitiga", triangle.calculateArea(), triangle.calculatePerimeter());
                } else {
                    JOptionPane.showMessageDialog(frame, "Isi semua area.");
                }
            }
        });

        frame.setVisible(true);
    }

    private void addResultToTable(String shape, double area, double perimeter) {
        tableModel.addRow(new Object[]{shape, area, perimeter});
    }

    public static void main(String[] args) {
        new ShapeCalculatorGUI();
    }
}
