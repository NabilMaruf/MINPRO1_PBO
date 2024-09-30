package Order;

public class Order {
    // Property yang saya masukkan di dalam Class Order
    private String namaCustomer;
    private String pickupLocation;
    private String destinasi;

    // Konstruktor untuk mendeklarasikan nilainya atau valuenya dari variabel yang saya buat di Class
    public Order(String namaCustomer, String pickupLocation, String destinasi) {
        this.namaCustomer = namaCustomer;
        this.pickupLocation = pickupLocation;
        this.destinasi = destinasi;
    }

    // Metode yang saya gunakan untuk memasukkan nilai kedalam Konstruktor
    public void MenampilkanOrderan() {
        System.out.println("Customer Name: " + namaCustomer);
        System.out.println("Pickup Location: " + pickupLocation);
        System.out.println("Destination: " + destinasi);
    }

    // Getter dan Setter untuk properti nama, jenisKendaraan, dan idDriver
    // Getter untuk mengambil suatu nilai atau value dari suatu property
    // Setter untuk mengubah atau mengisi nilainya atau valuenya menjadi yang baru
    public String getCustomerName() {
        return namaCustomer;
    }

    public void setCustomerName(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDestination() {
        return destinasi;
    }

    public void setDestination(String destinasi) {
        this.destinasi = destinasi;
    }
}
