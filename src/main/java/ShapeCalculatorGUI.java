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
        frame = new JFrame("Shape Area and Perimeter Calculator");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        // Create components
        JLabel lblLength = new JLabel("Length: ");
        JLabel lblWidth = new JLabel("Width: ");
        JLabel lblRadius = new JLabel("Radius: ");
        JLabel lblBase = new JLabel("Base: ");
        JLabel lblHeight = new JLabel("Height: ");
        JLabel lblSide1 = new JLabel("Side 1: ");
        JLabel lblSide2 = new JLabel("Side 2: ");
        JLabel lblSide3 = new JLabel("Side 3: ");

        txtLength = new JTextField(10);
        txtWidth = new JTextField(10);
        txtRadius = new JTextField(10);
        txtBase = new JTextField(10);
        txtHeight = new JTextField(10);
        txtSide1 = new JTextField(10);
        txtSide2 = new JTextField(10);
        txtSide3 = new JTextField(10);

        JButton btnCalculateRectangle = new JButton("Calculate Rectangle");
        JButton btnCalculateCircle = new JButton("Calculate Circle");
        JButton btnCalculateTriangle = new JButton("Calculate Triangle");

        // Table to display results
        tableModel = new DefaultTableModel(new Object[]{"Shape", "Area", "Perimeter"}, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 150));

        // Add components to frame
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

        // Add action listeners
        btnCalculateRectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtLength.getText().isEmpty() && !txtWidth.getText().isEmpty()) {
                    double length = Double.parseDouble(txtLength.getText());
                    double width = Double.parseDouble(txtWidth.getText());
                    Rectangle rectangle = new Rectangle(length, width);
                    addResultToTable("Rectangle", rectangle.calculateArea(), rectangle.calculatePerimeter());
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields.");
                }
            }
        });

        btnCalculateCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtRadius.getText().isEmpty()) {
                    double radius = Double.parseDouble(txtRadius.getText());
                    Circle circle = new Circle(radius);
                    addResultToTable("Circle", circle.calculateArea(), circle.calculatePerimeter());
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields.");
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
                    addResultToTable("Triangle", triangle.calculateArea(), triangle.calculatePerimeter());
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields.");
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }

    private void addResultToTable(String shape, double area, double perimeter) {
        tableModel.addRow(new Object[]{shape, area, perimeter});
    }

    public static void main(String[] args) {
        new ShapeCalculatorGUI();
    }
}
