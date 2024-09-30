package Driver; // package Driver untuk memisahkan class Driver beserta property dan methodnya

public class Driver {
    // Property yang saya sediakan di dalam Driver
    private String nama;
    private String jenisKendaraan;
    private int idDriver;
    private static int totalDriver = 0;

    // Konstruktor untuk mengisi nilai dari Property yang saya buat di atas
    public Driver(String nama, String jenisKendaraan, int idDriver) {
        this.nama = nama;
        this.jenisKendaraan = jenisKendaraan;
        this.idDriver = idDriver;
        totalDriver++;
    }

    // Metode untuk menampilkan informasi Driver
    public void menampilkanDriver() {
        System.out.println("Driver Name: " + nama);
        System.out.println("Vehicle Type: " + jenisKendaraan);
        System.out.println("Driver ID: " + idDriver);
    }

    // Metode Static untuk menampilkan jumlah total Driver
    public static void menampilkanTotalDriver() {
        System.out.println("Total Drivers: " + totalDriver);
    }

    // Getter dan Setter untuk properti nama, jenisKendaraan, dan idDriver
    // Getter untuk mengambil suatu nilai atau value dari suatu property
    // Setter untuk mengubah atau mengisi nilainya atau valuenya menjadi yang baru
    public String getName() {
        return nama;
    }

    public void setName(String nama) {
        this.nama = nama;
    }

    public String getVehicleType() {
        return jenisKendaraan;
    }

    public void setVehicleType(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public int getID() {
        return idDriver;
    }

    public void setID(int idDriver) {
        this.idDriver = idDriver;
    }
}
