import java.util.Scanner;

/**
 * Kelas yang merepresentasikan bangun datar segitiga.
 */
class Triangle extends AbstractShape {
    private double base;
    private double height;
    private double sideA;
    private double sideB;
    private double sideC;

    /**
     * Konstruktor untuk kelas Triangle.
     *
     * @param base   panjang alas segitiga
     * @param height tinggi segitiga
     * @param sideA  panjang sisi pertama segitiga
     * @param sideB  panjang sisi kedua segitiga
     * @param sideC  panjang sisi ketiga segitiga
     */
    public Triangle(double base, double height, double sideA, double sideB, double sideC) {
        super("Segitiga");
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * Menghitung luas segitiga.
     *
     * @return luas dari segitiga
     */
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    /**
     * Menghitung keliling segitiga.
     *
     * @return keliling dari segitiga
     */
    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public static Triangle createTriangle(Scanner scanner) {
        ShapeParameters baseParam = new ShapeParameters("Masukkan panjang alas segitiga: ");
        ShapeParameters heightParam = new ShapeParameters("Masukkan tinggi segitiga: ");
        ShapeParameters sideAParam = new ShapeParameters("Masukkan panjang sisi pertama: ");
        ShapeParameters sideBParam = new ShapeParameters("Masukkan panjang sisi kedua: ");
        ShapeParameters sideCParam = new ShapeParameters("Masukkan panjang sisi ketiga: ");

        double base = baseParam.getValue(scanner);
        double height = heightParam.getValue(scanner);
        double sideA = sideAParam.getValue(scanner);
        double sideB = sideBParam.getValue(scanner);
        double sideC = sideCParam.getValue(scanner);

        return new Triangle(base, height, sideA, sideB, sideC);
    }
}
