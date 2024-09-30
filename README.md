# Biodata
Nama : Muhammad Nabil Ma'ruf\
NIM : 2309116035\
Sistem Informasi A

# Deskripsi Program
Penjelasan singkat Program\
Program Sistem Manajemen Ojek Online, adalah program yang terdiri dari 3 package yaitu AplikasiOjek, Driver & Order yang masing-masing packagenya terdapat class dan fungsi masing-masing. Program ini juga bertujuan untuk menerapkan Manajemen pada Ojek Online.

# Source Code
## AplikasiOjek
```
package com.mycompany.aplikasiojek;

import Driver.Driver;
import Order.Order;
import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiOjek {
    public static void main(String[] args) {
        ArrayList<Driver> drivers = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("=== Sistem Manajemen Ojek Online ===");
            System.out.println("1. Menambahkan Driver");
            System.out.println("2. Menampilkan Drivers");
            System.out.println("3. Update Driver");
            System.out.println("4. Hapus Driver");
            System.out.println("5. Order Ojek");
            System.out.println("6. Menampilkan Orderan");
            System.out.println("7. Exit");
            System.out.print("Masukkan Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    // Logika yang saya buat untuk menambahakan Driver
                    System.out.print("Masukkan nama anda: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan jenis kendaraan: ");
                    String jenisKendaraan = scanner.nextLine();
                    System.out.print("Masukkan ID Anda: ");
                    int idDriver = scanner.nextInt();
                    scanner.nextLine();
                    Driver newDriver = new Driver(nama, jenisKendaraan, idDriver);
                    drivers.add(newDriver);
                    System.out.println("Driver added successfully!");
                    break;

                case 2:
                    // Logika yang saya buat untuk melihat seluruh Driver
                    if (drivers.isEmpty()) {
                        System.out.println("No drivers available.");
                    } else {
                        for (Driver driver : drivers) {
                            driver.menampilkanDriver();
                            System.out.println("------------------");
                        }
                        Driver.menampilkanTotalDriver();
                    }
                    break;

                case 3:
                    // Logika Update Driver
                    System.out.print("Masukkan ID Driver yang ingin di-update: ");
                    int updateID = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;

                    for (Driver driver : drivers) {
                        if (driver.getID() == updateID) {
                            found = true;
                            System.out.print("Masukkan nama baru (kosongkan jika tidak ingin mengubah): ");
                            String newName = scanner.nextLine();
                            if (!newName.isEmpty()) {
                                driver.setName(newName);
                            }

                            System.out.print("Masukkan jenis kendaraan baru (kosongkan jika tidak ingin mengubah): ");
                            String newVehicleType = scanner.nextLine();
                            if (!newVehicleType.isEmpty()) {
                                driver.setVehicleType(newVehicleType);
                            }
                            System.out.println("Driver updated successfully!");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Driver dengan ID tersebut tidak ditemukan.");
                    }
                    break;

                case 4:
                    // Delete Driver
                    System.out.print("Masukkan ID Driver yang ingin dihapus: ");
                    int deleteID = scanner.nextInt();
                    scanner.nextLine();
                    Driver driverToRemove = null;

                    for (Driver driver : drivers) {
                        if (driver.getID() == deleteID) {
                            driverToRemove = driver;
                            break;
                        }
                    }

                    if (driverToRemove != null) {
                        drivers.remove(driverToRemove);
                        System.out.println("Driver berhasil dihapus.");
                    } else {
                        System.out.println("Driver dengan ID tersebut tidak ditemukan.");
                    }
                    break;

                case 5:
                    // Logika menambahakan Order
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String namaCustomer = scanner.nextLine();
                    System.out.print("Masukkan Lokasi Penjemputan: ");
                    String pickupLocation = scanner.nextLine();
                    System.out.print("Masukkan Tujuan: ");
                    String destination = scanner.nextLine();
                    Order newOrder = new Order(namaCustomer, pickupLocation, destination);
                    orders.add(newOrder);
                    System.out.println("Order added successfully!");
                    break;

                case 6:
                    // Code untuk menampilkan Orderan
                    if (orders.isEmpty()) {
                        System.out.println("No orders available.");
                    } else {
                        for (Order order : orders) {
                            order.MenampilkanOrderan();
                            System.out.println("------------------");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 7);

        scanner.close();
    }
}

```
## Driver
```
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
```
## Order
```
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
```
# 3 Package
![image](https://github.com/user-attachments/assets/6a9a4ba8-adda-4820-9ca6-7602742c6629)
# Menu Utama Program
![image](https://github.com/user-attachments/assets/a7557354-29af-46bd-85a9-8fce7c2d0049)
# Menu Menambahkan Driver
![image](https://github.com/user-attachments/assets/8a77894b-a929-474c-9aa2-a77c0bf9c5ce)
# Menu Menampilkan Driver
![image](https://github.com/user-attachments/assets/6e2432d2-e314-490d-8a5d-b5c0c6d885d6)
# Menu Mengupdate Driver
![image](https://github.com/user-attachments/assets/469674d9-48b6-49fd-b0fd-a9929934cf30)
# Menu Menghapus Driver
![image](https://github.com/user-attachments/assets/1e149bf2-6eea-42ee-9ba3-83800459398e)
# Menu Order Ojek
![image](https://github.com/user-attachments/assets/c2b9b80e-d1d3-4927-8b85-9317120f31b4)
# Menu Menampilkan Orderan
![image](https://github.com/user-attachments/assets/855ee223-5c54-4171-be89-ac8104ea7c44)
# Menu Exit
![image](https://github.com/user-attachments/assets/1c289a28-7109-45c7-a1f5-30bf0648c006)






