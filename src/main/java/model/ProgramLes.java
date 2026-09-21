/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class ProgramLes {

    protected String kodeProgram;
    protected String namaMapel;
    protected String jadwal;
    protected double biayaDasar;

    // Constructor
    public ProgramLes(String kodeProgram, String namaMapel, String jadwal, double biayaDasar) {
        setKodeProgram(kodeProgram);
        setNamaMapel(namaMapel);
        setJadwal(jadwal);
        setBiayaDasar(biayaDasar);
    }

    // Getter dan Setter kodeProgram
    public String getKodeProgram() {
        return kodeProgram;
    }

    public void setKodeProgram(String kodeProgram) {
        if (kodeProgram != null && !kodeProgram.trim().isEmpty()) {
            this.kodeProgram = kodeProgram.trim();
        } else {
            System.out.println(">> ERROR VALIDASI: Kode program tidak boleh kosong.");
            this.kodeProgram = "UNKNOWN";
        }
    }

    // Getter dan Setter namaMapel
    public String getNamaMapel() {
        return namaMapel;
    }

    public void setNamaMapel(String namaMapel) {
        if (namaMapel != null && !namaMapel.trim().isEmpty()) {
            this.namaMapel = namaMapel.trim();
        } else {
            System.out.println(">> ERROR VALIDASI: Nama mata pelajaran tidak boleh kosong.");
            this.namaMapel = "Belum Diisi";
        }
    }

    // Getter dan Setter jadwal
    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        if (jadwal != null && !jadwal.trim().isEmpty()) {
            this.jadwal = jadwal.trim();
        } else {
            System.out.println(">> ERROR VALIDASI: Jadwal tidak boleh kosong.");
            this.jadwal = "Belum Ditentukan";
        }
    }

    // Getter dan Setter biayaDasar
    public double getBiayaDasar() {
        return biayaDasar;
    }

    public void setBiayaDasar(double biayaDasar) {
        if (biayaDasar >= 0) {
            this.biayaDasar = biayaDasar;
        } else {
            System.out.println(">> ERROR VALIDASI: Biaya dasar tidak boleh negatif.");
            this.biayaDasar = 0.0;
        }
    }

    // Method menghitung total biaya
    public double hitungTotalBiaya() {
        return biayaDasar;
    }

    // Method menampilkan detail
    public void tampilkanDetail() {
        System.out.println("========================================");
        System.out.println("Kode Program : " + kodeProgram);
        System.out.println("Mata Pelajaran : " + namaMapel);
        System.out.println("Jadwal : " + jadwal);
        System.out.printf("Biaya Dasar : Rp%.2f%n", biayaDasar);
        System.out.printf("Total Biaya : Rp%.2f%n", hitungTotalBiaya());
        System.out.println("========================================");
    }
}
