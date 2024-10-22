# 💻 Hitung Bangun Datar

Selamat datang di **Hitung Bangun Datar**! 🚀  
Proyek ini adalah program sederhana berbasis konsol untuk menghitung luas dari berbagai bangun datar, yaitu **Persegi** dan **Persegi Panjang**. Program ini dibuat dengan pendekatan **Object-Oriented Programming (OOP)**, memanfaatkan antarmuka, kelas abstrak, dan beberapa teknik refactoring untuk menjaga kode tetap bersih dan modular.

## 📝 Fitur Utama

- Menghitung luas **Persegi** berdasarkan sisi yang dimasukkan pengguna.
- Menghitung luas **Persegi Panjang** berdasarkan panjang dan lebar yang dimasukkan pengguna.
- Menampilkan hasil perhitungan dengan rapi di konsol.
- Pengguna dapat menghitung luas berkali-kali tanpa harus keluar dari program.
- Struktur kode modular dan mudah dikembangkan.

## 🔧 Teknologi yang Digunakan

- **Java**: Bahasa pemrograman utama yang digunakan.
- **OOP Concepts**: Menggunakan antarmuka, kelas abstrak, dan inheritance.
- **Scanner**: Untuk menangani input dari pengguna melalui konsol.

## 🚀 Cara Menjalankan Program

### Prasyarat

Pastikan Anda telah menginstal **JDK (Java Development Kit)** di komputer Anda. Jika belum, Anda dapat mengunduhnya [di sini](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

### Langkah-langkah

1. Clone atau unduh proyek ini ke direktori lokal Anda.

   ```bash
   git clone https://github.com/FFF9ep/HitungBangunDatarRefactored.git
   ```

2. Buka terminal atau Command Prompt, lalu navigasikan ke direktori tempat Anda menyimpan proyek ini.

   ```bash
   cd HitungBangunDatarRefactored
   ```

3. Kompilasi kode menggunakan perintah berikut:

   ```bash
   javac HitungBangunDatarRefactored.java
   ```

4. Jalankan program dengan perintah:

   ```bash
   java HitungBangunDatarRefactored
   ```

5. Ikuti instruksi di layar untuk menghitung luas bangun datar pilihan Anda. Anda dapat memilih untuk melanjutkan atau keluar setelah setiap perhitungan.

## 🎮 Cara Menggunakan Program

1. Setelah menjalankan program, Anda akan diminta memilih bangun datar yang ingin dihitung luasnya:

   - **1** untuk Persegi
   - **2** untuk Persegi Panjang

2. Masukkan angka sesuai dengan pilihan Anda. Program kemudian akan meminta Anda memasukkan nilai-nilai seperti panjang sisi atau panjang & lebar sesuai dengan bentuk yang dipilih.

3. Setelah perhitungan selesai, Anda akan ditanya apakah ingin melanjutkan perhitungan untuk bangun datar lain atau keluar dari program.

   - Ketik **ya** untuk menghitung lagi.
   - Ketik **tidak** untuk keluar dari program.

## 📂 Deskripsi Kelas dan Metode

Program ini terdiri dari beberapa kelas dan metode penting:

- **Shape**: Antarmuka yang mendefinisikan metode untuk menghitung dan mencetak luas bangun datar.
- **AbstractShape**: Kelas abstrak yang mengimplementasikan antarmuka `Shape` dan menyediakan fungsionalitas umum untuk bangun datar.
- **Square**: Kelas untuk menghitung luas persegi berdasarkan panjang sisi.
- **Rectangle**: Kelas untuk menghitung luas persegi panjang berdasarkan panjang dan lebar.
- **ShapeParameters**: Kelas untuk mengelola parameter input pengguna seperti panjang sisi atau panjang & lebar.
- **HitungBangunDatarRefactored**: Kelas utama yang mengelola logika pemilihan bangun datar, input pengguna, dan loop program.

## ✨ Peningkatan yang Dapat Dilakukan

- Menambahkan lebih banyak bangun datar seperti lingkaran, segitiga, dll.
- Memvalidasi input pengguna untuk mencegah kesalahan (misalnya, tidak mengizinkan input negatif atau non-numerik).
- Menyediakan UI berbasis GUI menggunakan **Java Swing** atau **JavaFX** untuk tampilan yang lebih interaktif.

## ✍️ Kontribusi

Kami selalu terbuka untuk kontribusi! Jika Anda ingin berkontribusi ke proyek ini, Anda dapat:

- Fork proyek ini.
- Buat branch fitur baru (`git checkout -b fitur-baru`).
- Lakukan commit terhadap perubahan Anda (`git commit -m 'Tambahkan fitur X'`).
- Push ke branch tersebut (`git push origin fitur-baru`).
- Buat **Pull Request**.

## 📞 Kontak

Jika Anda memiliki pertanyaan atau saran, jangan ragu untuk menghubungi saya melalui:

- Email: [fandardyy@gamil.com](mailto:fandardyy@gmail.com)
- LinkedIn: [Profil LinkedIn Saya](https://www.linkedin.com/in/fandiardyan111)

---

🌟 **Terima kasih telah menggunakan program ini!** Selamat menghitung luas bangun datar! 😊
