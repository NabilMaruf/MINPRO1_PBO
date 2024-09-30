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
