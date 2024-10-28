import java.util.Scanner;

/**
 * Interface yang mendefinisikan bentuk umum dari bangun datar.
 * Setiap bangun datar harus bisa menghitung luas dan mencetak hasilnya.
 */
interface Shape {
    /**
     * Menghitung luas bangun datar.
     *
     * @return luas dari bangun datar
     */
    double calculateArea();

    /**
     * Mencetak hasil perhitungan luas bangun datar.
     */
    void printArea();
}

/**
 * Kelas abstrak yang mengimplementasikan antarmuka Shape.
 * Ini menyediakan kerangka umum untuk bangun datar seperti persegi dan persegi
 * panjang.
 */
abstract class AbstractShape implements Shape, PerimeterCalculable {
    protected String name;

    /**
     * Konstruktor untuk kelas AbstractShape.
     *
     * @param name nama dari bangun datar
     */
    public AbstractShape(String name) {
        this.name = name;
    }

    /**
     * Mencetak luas dari bangun datar dengan format yang telah ditentukan.
     */
    public void printArea() {
        System.out.println("Luas " + name + " adalah: " + calculateArea());
    }

    public void printPerimeter() {
        System.out.println("Keliling " + name + " adalah: " + calculatePerimeter());
    }
}

/**
 * Kelas yang menyimpan konstanta untuk pilihan jenis bangun datar.
 */
class Constants {
    public static final int PERSEGI = 1;
    public static final int PERSEGI_PANJANG = 2;
}

/**
 * Kelas yang merepresentasikan bangun datar persegi.
 */
class Square extends AbstractShape {
    private double side;

    /**
     * Konstruktor untuk kelas Square.
     *
     * @param side panjang sisi dari persegi
     */
    public Square(double side) {
        super("Persegi");
        this.side = side;
    }

    /**
     * Menghitung luas dari persegi.
     *
     * @return luas dari persegi
     */
    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}

/**
 * Kelas yang merepresentasikan bangun datar persegi panjang.
 */
class Rectangle extends AbstractShape {
    private double length;
    private double width;

    /**
     * Konstruktor untuk kelas Rectangle.
     *
     * @param length panjang dari persegi panjang
     * @param width  lebar dari persegi panjang
     */
    public Rectangle(double length, double width) {
        super("Persegi Panjang");
        this.length = length;
        this.width = width;
    }

    /**
     * Menghitung luas dari persegi panjang.
     *
     * @return luas dari persegi panjang
     */
    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

/**
 * Kelas untuk menangani parameter yang dibutuhkan oleh bangun datar.
 */
class ShapeParameters {
    private String prompt;
    private double value;

    /**
     * Konstruktor untuk kelas ShapeParameters.
     *
     * @param prompt teks yang akan ditampilkan kepada pengguna untuk meminta input
     */
    public ShapeParameters(String prompt) {
        this.prompt = prompt;
    }

    /**
     * Mendapatkan nilai dari input pengguna berdasarkan prompt.
     *
     * @param scanner objek Scanner untuk membaca input pengguna
     * @return nilai input dari pengguna
     */
    public double getValue(Scanner scanner) {
        System.out.print(prompt);
        value = scanner.nextDouble();
        return value;
    }
}

/**
 * Kelas utama yang menjalankan program perhitungan luas bangun datar.
 * Menyediakan menu untuk memilih bangun datar dan menghitung luasnya.
 */
public class HitungBangunDatarRefactored {

    /**
     * Method utama yang menjalankan program.
     * Meminta input pengguna untuk memilih bangun datar dan menghitung luasnya.
     *
     * @param args argumen baris perintah
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        // Loop untuk menjalankan program hingga pengguna memilih untuk berhenti
        while (continueProgram) {
            showMenu();
            int choice = scanner.nextInt();
            handleUserChoice(choice, scanner);

            // Tanyakan apakah ingin mengulangi atau keluar
            continueProgram = askToContinue(scanner);
        }

        scanner.close();
        System.out.println("Terima kasih telah menggunakan program ini.");
    }

    /**
     * Menampilkan menu pilihan bangun datar kepada pengguna.
     */
    public static void showMenu() {
        System.out.println("Pilih bangun datar:");
        System.out.println(Constants.PERSEGI + ". Persegi");
        System.out.println(Constants.PERSEGI_PANJANG + ". Persegi Panjang");
        System.out.print("Masukkan pilihan Anda: ");
    }

    /**
     * Menghandle pilihan pengguna dan memproses perhitungan berdasarkan pilihan.
     *
     * @param choice  pilihan bangun datar (persegi atau persegi panjang)
     * @param scanner objek Scanner untuk membaca input pengguna
     */
    public static void handleUserChoice(int choice, Scanner scanner) {
        Shape shape = null;
        switch (choice) {
            case Constants.PERSEGI:
                shape = createSquare(scanner);
                break;
            case Constants.PERSEGI_PANJANG:
                shape = createRectangle(scanner);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }
        shape.printArea();
        if (shape instanceof PerimeterCalculable) {
            ((PerimeterCalculable) shape).printPerimeter();
        }
    }

    /**
     * Membuat objek Square (Persegi) berdasarkan input pengguna.
     *
     * @param scanner objek Scanner untuk membaca input pengguna
     * @return objek Square yang telah dibuat
     */
    public static Square createSquare(Scanner scanner) {
        ShapeParameters sideParam = new ShapeParameters("Masukkan panjang sisi persegi: ");
        double side = sideParam.getValue(scanner);
        return new Square(side);
    }

    /**
     * Membuat objek Rectangle (Persegi Panjang) berdasarkan input pengguna.
     *
     * @param scanner objek Scanner untuk membaca input pengguna
     * @return objek Rectangle yang telah dibuat
     */
    public static Rectangle createRectangle(Scanner scanner) {
        ShapeParameters lengthParam = new ShapeParameters("Masukkan panjang persegi panjang: ");
        ShapeParameters widthParam = new ShapeParameters("Masukkan lebar persegi panjang: ");
        double length = lengthParam.getValue(scanner);
        double width = widthParam.getValue(scanner);
        return new Rectangle(length, width);
    }

    /**
     * Menanyakan kepada pengguna apakah ingin melanjutkan perhitungan atau
     * berhenti.
     *
     * @param scanner objek Scanner untuk membaca input pengguna
     * @return true jika pengguna ingin melanjutkan, false jika tidak
     */
    public static boolean askToContinue(Scanner scanner) {
        System.out.print("Apakah Anda ingin menghitung lagi? (ya/tidak): ");
        String response = scanner.next();
        return response.equalsIgnoreCase("ya");
    }
}

interface PerimeterCalculable {
    double calculatePerimeter();

    void printPerimeter();
}
