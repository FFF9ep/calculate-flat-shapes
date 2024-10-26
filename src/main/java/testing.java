import java.util.ArrayList;
import java.util.Scanner;

interface Shape {
    double calculateArea();

    double calculatePerimeter();

    void printArea();

    void printPerimeter();
}

abstract class AbstractShape implements Shape {
    protected String name;

    public AbstractShape(String name) {
        this.name = name;
    }

    public void printArea() {
        System.out.println("Luas " + name + " adalah: " + calculateArea());
    }

    public void printPerimeter() {
        System.out.println("Keliling " + name + " adalah: " + calculatePerimeter());
    }
}

class Constants {
    public static final int PERSEGI = 1;
    public static final int PERSEGI_PANJANG = 2;
    public static final int LINGKARAN = 3;
    public static final int SEGITIGA = 4;
}

class Square extends AbstractShape {
    private double side;

    public Square(double side) {
        super("Persegi");
        this.side = validatePositive(side, "Sisi Persegi");
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}

class Rectangle extends AbstractShape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super("Persegi Panjang");
        this.length = validatePositive(length, "Panjang");
        this.width = validatePositive(width, "Lebar");
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

class Circle extends AbstractShape {
    private double radius;

    public Circle(double radius) {
        super("Lingkaran");
        this.radius = validatePositive(radius, "Jari-jari");
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Triangle extends AbstractShape {
    private double base;
    private double height;
    private double sideA, sideB, sideC;

    public Triangle(double base, double height, double sideA, double sideB, double sideC) {
        super("Segitiga");
        this.base = validatePositive(base, "Alas");
        this.height = validatePositive(height, "Tinggi");
        this.sideA = validatePositive(sideA, "Sisi A");
        this.sideB = validatePositive(sideB, "Sisi B");
        this.sideC = validatePositive(sideC, "Sisi C");
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }
}

class ShapeParameters {
    private String prompt;

    public ShapeParameters(String prompt) {
        this.prompt = prompt;
    }

    public double getValue(Scanner scanner) {
        System.out.print(prompt);
        double value = scanner.nextDouble();
        return validatePositive(value, prompt);
    }

    public static double validatePositive(double value, String parameter) {
        if (value <= 0) {
            throw new IllegalArgumentException(parameter + " harus bernilai positif.");
        }
        return value;
    }
}

public class HitungBangunDatarRefactored {
    private static ArrayList<String> calculationHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            showMenu();
            int choice = scanner.nextInt();
            handleUserChoice(choice, scanner);
            continueProgram = askToContinue(scanner);
        }

        showHistory();
        scanner.close();
        System.out.println("Terima kasih telah menggunakan program ini.");
    }

    public static void showMenu() {
        System.out.println("Pilih bangun datar:");
        System.out.println(Constants.PERSEGI + ". Persegi");
        System.out.println(Constants.PERSEGI_PANJANG + ". Persegi Panjang");
        System.out.println(Constants.LINGKARAN + ". Lingkaran");
        System.out.println(Constants.SEGITIGA + ". Segitiga");
        System.out.print("Masukkan pilihan Anda: ");
    }

    public static void handleUserChoice(int choice, Scanner scanner) {
        Shape shape = null;
        switch (choice) {
            case Constants.PERSEGI:
                shape = createSquare(scanner);
                break;
            case Constants.PERSEGI_PANJANG:
                shape = createRectangle(scanner);
                break;
            case Constants.LINGKARAN:
                shape = createCircle(scanner);
                break;
            case Constants.SEGITIGA:
                shape = createTriangle(scanner);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        shape.printArea();
        shape.printPerimeter();
        calculationHistory.add(shape.toString());
    }

    public static Square createSquare(Scanner scanner) {
        ShapeParameters sideParam = new ShapeParameters("Masukkan panjang sisi persegi: ");
        double side = sideParam.getValue(scanner);
        return new Square(side);
    }

    public static Rectangle createRectangle(Scanner scanner) {
        ShapeParameters lengthParam = new ShapeParameters("Masukkan panjang persegi panjang: ");
        ShapeParameters widthParam = new ShapeParameters("Masukkan lebar persegi panjang: ");
        double length = lengthParam.getValue(scanner);
        double width = widthParam.getValue(scanner);
        return new Rectangle(length, width);
    }

    public static Circle createCircle(Scanner scanner) {
        ShapeParameters radiusParam = new ShapeParameters("Masukkan jari-jari lingkaran: ");
        double radius = radiusParam.getValue(scanner);
        return new Circle(radius);
    }

    public static Triangle createTriangle(Scanner scanner) {
        ShapeParameters baseParam = new ShapeParameters("Masukkan panjang alas segitiga: ");
        ShapeParameters heightParam = new ShapeParameters("Masukkan tinggi segitiga: ");
        ShapeParameters sideAParam = new ShapeParameters("Masukkan panjang sisi A: ");
        ShapeParameters sideBParam = new ShapeParameters("Masukkan panjang sisi B: ");
        ShapeParameters sideCParam = new ShapeParameters("Masukkan panjang sisi C: ");

        double base = baseParam.getValue(scanner);
        double height = heightParam.getValue(scanner);
        double sideA = sideAParam.getValue(scanner);
        double sideB = sideBParam.getValue(scanner);
        double sideC = sideCParam.getValue(scanner);

        return new Triangle(base, height, sideA, sideB, sideC);
    }

    public static boolean askToContinue(Scanner scanner) {
        System.out.print("Apakah Anda ingin menghitung lagi? (ya/tidak): ");
        String response = scanner.next();
        return response.equalsIgnoreCase("ya");
    }

    public static void showHistory() {
        System.out.println("\nRiwayat Perhitungan:");
        for (String record : calculationHistory) {
            System.out.println(record);
        }
    }
}
