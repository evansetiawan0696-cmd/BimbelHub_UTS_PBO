/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.*;
/**
 *
 * @author ACER
 */
public class BimbelHubApp {

    // Scanner class main
    private static Scanner scanner = new Scanner(System.in);

    // ArrayList menggunakan tipe superclass
    private static ArrayList<ProgramLes> daftarLes = new ArrayList<>();

    public static void main(String[] args) {

        int pilihan;

        System.out.println("========================================");
        System.out.println("       SELAMAT DATANG DI BIMBELHUB");
        System.out.println(" Sistem Manajemen Bimbingan Belajar");
        System.out.println("========================================");

        do {
            tampilkanMenu();
            pilihan = bacaInt("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    tambahLesOffline();
                    break;

                case 2:
                    tambahLesOnline();
                    break;

                case 3:
                    tampilkanSemuaData();
                    break;

                case 4:
                    hapusData();
                    break;

                case 5:
                    System.out.println("\nTerima kasih telah menggunakan BimbelHub.");
                    break;

                default:
                    System.out.println(">> ERROR: Pilihan menu tidak tersedia.");
                    break;
            }

        } while (pilihan != 5);

        scanner.close();
    }

    // Method menampilkan menu
    private static void tampilkanMenu() {
        System.out.println("\n========================================");
        System.out.println("              MENU BIMBELHUB");
        System.out.println("========================================");
        System.out.println("1. Tambah Data Les Offline");
        System.out.println("2. Tambah Data Les Online");
        System.out.println("3. Tampilkan Semua Data");
        System.out.println("4. Hapus Data");
        System.out.println("5. Keluar");
        System.out.println("========================================");
    }

    // Tambah data Les Offline
    private static void tambahLesOffline() {
        System.out.println("\n--- TAMBAH LES OFFLINE ---");

        System.out.print("Masukkan Kode Program: ");
        String kodeProgram = scanner.nextLine();

        if (kodeSudahAda(kodeProgram)) {
            System.out.println(">> ERROR: Kode program sudah digunakan.");
            return;
        }

        System.out.println("Pilihan Mata Pelajaran:");
        System.out.println("1. Matematika");
        System.out.println("2. Fisika");

        int pilihanMapel = bacaInt("Pilih mata pelajaran: ");

        String namaMapel;

        switch (pilihanMapel) {
            case 1:
                namaMapel = "Matematika";
                break;

            case 2:
                namaMapel = "Fisika";
                break;

            default:
                System.out.println(">> ERROR: Pilihan mata pelajaran tidak valid.");
                return;
        }

        System.out.print("Masukkan Jadwal: ");
        String jadwal = scanner.nextLine();

        System.out.println("Pilihan Nama Kelas:");
        System.out.println("1. Kelas Reguler");
        System.out.println("2. VIP");

        int pilihanKelas = bacaInt("Pilih kelas: ");

        String namaKelas;

        switch (pilihanKelas) {
            case 1:
                namaKelas = "Kelas Reguler";
                break;

            case 2:
                namaKelas = "VIP";
                break;

            default:
                System.out.println(">> ERROR: Pilihan kelas tidak valid.");
                return;
        }

        double biayaDasar = bacaDouble("Masukkan Biaya Dasar: Rp");
        double biayaFasilitas = bacaDouble("Masukkan Biaya Fasilitas: Rp");

        LesOffline lesOffline = new LesOffline(
                kodeProgram,
                namaMapel,
                jadwal,
                biayaDasar,
                namaKelas,
                biayaFasilitas
        );

        daftarLes.add(lesOffline);

        System.out.println(">> Data les offline berhasil ditambahkan.");
    }

    // Tambah data Les Online
    private static void tambahLesOnline() {
        System.out.println("\n--- TAMBAH LES ONLINE ---");

        System.out.print("Masukkan Kode Program: ");
        String kodeProgram = scanner.nextLine();

        if (kodeSudahAda(kodeProgram)) {
            System.out.println(">> ERROR: Kode program sudah digunakan.");
            return;
        }

        System.out.println("Pilihan Mata Pelajaran:");
        System.out.println("1. Bahasa Inggris");
        System.out.println("2. Pemrograman Java");

        int pilihanMapel = bacaInt("Pilih mata pelajaran: ");

        String namaMapel;

        switch (pilihanMapel) {
            case 1:
                namaMapel = "Bahasa Inggris";
                break;

            case 2:
                namaMapel = "Pemrograman Java";
                break;

            default:
                System.out.println(">> ERROR: Pilihan mata pelajaran tidak valid.");
                return;
        }

        System.out.print("Masukkan Jadwal: ");
        String jadwal = scanner.nextLine();

        System.out.println("Pilihan Jenis Latihan Soal:");
        System.out.println("1. Bank Soal PDF");
        System.out.println("2. Tryout Interaktif");

        int pilihanLatihan = bacaInt("Pilih latihan soal: ");

        String jenisLatihanSoal;

        switch (pilihanLatihan) {
            case 1:
                jenisLatihanSoal = "Bank Soal PDF";
                break;

            case 2:
                jenisLatihanSoal = "Tryout Interaktif";
                break;

            default:
                System.out.println(">> ERROR: Pilihan jenis latihan tidak valid.");
                return;
        }

        double biayaDasar = bacaDouble("Masukkan Biaya Dasar: Rp");
        double diskonOnline = bacaDouble("Masukkan Diskon Online: Rp");

        LesOnline lesOnline = new LesOnline(
                kodeProgram,
                namaMapel,
                jadwal,
                biayaDasar,
                jenisLatihanSoal,
                diskonOnline
        );

        daftarLes.add(lesOnline);

        System.out.println(">> Data les online berhasil ditambahkan.");
    }

    // Menampilkan semua data menggunakan for-each dan instanceof
    private static void tampilkanSemuaData() {

        System.out.println("\n--- SEMUA DATA PROGRAM LES ---");

        if (daftarLes.isEmpty()) {
            System.out.println(">> Belum ada data program les.");
            return;
        }

        int nomor = 1;

        for (ProgramLes les : daftarLes) {

            System.out.println("\nData ke-" + nomor);

            // Pengecekan instanceof untuk subclass
            if (les instanceof LesOffline) {
                LesOffline offline = (LesOffline) les;
                offline.tampilkanDetail();

            } else if (les instanceof LesOnline) {
                LesOnline online = (LesOnline) les;
                online.tampilkanDetail();

            } else {
                les.tampilkanDetail();
            }

            nomor++;
        }
    }

    // Menghapus data berdasarkan kodeProgram
    private static void hapusData() {

        System.out.println("\n--- HAPUS DATA LES ---");

        if (daftarLes.isEmpty()) {
            System.out.println(">> Belum ada data yang dapat dihapus.");
            return;
        }

        System.out.print("Masukkan Kode Program yang ingin dihapus: ");
        String kodeHapus = scanner.nextLine();

        ProgramLes dataDitemukan = null;

        // Pencarian menggunakan equalsIgnoreCase()
        for (ProgramLes les : daftarLes) {
            if (les.getKodeProgram().equalsIgnoreCase(kodeHapus)) {
                dataDitemukan = les;
                break;
            }
        }

        if (dataDitemukan != null) {
            daftarLes.remove(dataDitemukan);
            System.out.println(">> Data dengan kode "
                    + dataDitemukan.getKodeProgram()
                    + " berhasil dihapus.");
        } else {
            System.out.println(">> ERROR: Kode program tidak ditemukan.");
        }
    }

    // Mengecek apakah kode program sudah digunakan
    private static boolean kodeSudahAda(String kodeProgram) {

        for (ProgramLes les : daftarLes) {
            if (les.getKodeProgram().equalsIgnoreCase(kodeProgram)) {
                return true;
            }
        }

        return false;
    }

    // Method input integer dengan pembersihan buffer
    private static int bacaInt(String pesan) {

        while (true) {
            System.out.print(pesan);

            try {
                int nilai = scanner.nextInt();
                scanner.nextLine();

                return nilai;

            } catch (InputMismatchException e) {
                System.out.println(">> ERROR INPUT: Masukkan angka bulat yang valid.");
                scanner.nextLine();
            }
        }
    }

    // Method input double
    private static double bacaDouble(String pesan) {

        while (true) {
            System.out.print(pesan);

            try {
                double nilai = scanner.nextDouble();
                scanner.nextLine();

                return nilai;

            } catch (InputMismatchException e) {
                System.out.println(">> ERROR INPUT: Masukkan angka biaya yang valid.");
                scanner.nextLine();
            }
        }
    }
}
