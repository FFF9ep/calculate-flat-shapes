import java.util.Scanner;

/**
 * Kelas yang merepresentasikan bangun datar lingkaran.
 */
class Circle extends AbstractShape {
    private double radius;

    /**
     * Konstruktor untuk kelas Circle.
     *
     * @param radius jari-jari dari lingkaran
     */
    public Circle(double radius) {
        super("Lingkaran");
        this.radius = radius;
    }

    /**
     * Menghitung luas lingkaran.
     *
     * @return luas dari lingkaran
     */
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Menghitung keliling lingkaran.
     *
     * @return keliling dari lingkaran
     */
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Metode statis untuk membuat objek Circle berdasarkan input pengguna.
     *
     * @param scanner objek Scanner untuk membaca input pengguna
     * @return objek Circle yang telah dibuat
     */
    public static Circle createCircle(Scanner scanner) {
        ShapeParameters radiusParam = new ShapeParameters("Masukkan jari-jari lingkaran: ");
        double radius = radiusParam.getValue(scanner);
        return new Circle(radius);
    }
}
