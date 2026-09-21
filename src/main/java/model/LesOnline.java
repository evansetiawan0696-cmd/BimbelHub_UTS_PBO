/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class LesOnline extends ProgramLes {

    // Atribut private sesuai ketentuan subclass
    private String jenisLatihanSoal;
    private double diskonOnline;

    // Constructor
    public LesOnline(
            String kodeProgram,
            String namaMapel,
            String jadwal,
            double biayaDasar,
            String jenisLatihanSoal,
            double diskonOnline) {

        // constructor subclass
        super(kodeProgram, namaMapel, jadwal, biayaDasar);

        setJenisLatihanSoal(jenisLatihanSoal);
        setDiskonOnline(diskonOnline);
    }

    // Getter dan Setter jenisLatihanSoal
    public String getJenisLatihanSoal() {
        return jenisLatihanSoal;
    }

    public void setJenisLatihanSoal(String jenisLatihanSoal) {
        if (jenisLatihanSoal != null && !jenisLatihanSoal.trim().isEmpty()) {
            this.jenisLatihanSoal = jenisLatihanSoal.trim();
        } else {
            System.out.println(">> ERROR VALIDASI: Jenis latihan soal tidak boleh kosong.");
            this.jenisLatihanSoal = "Bank Soal PDF";
        }
    }

    // Getter dan Setter diskonOnline
    public double getDiskonOnline() {
        return diskonOnline;
    }

    public void setDiskonOnline(double diskonOnline) {
        if (diskonOnline >= 0) {
            this.diskonOnline = diskonOnline;
        } else {
            System.out.println(">> ERROR VALIDASI: Diskon online tidak boleh negatif.");
            this.diskonOnline = 0.0;
        }
    }

    // Override hitungTotalBiaya
    @Override
    public double hitungTotalBiaya() {
        return super.hitungTotalBiaya() - diskonOnline;
    }

    // Override tampilkanDetail
    @Override
    public void tampilkanDetail() {
        System.out.println("========================================");
        System.out.println("PROGRAM LES ONLINE");
        System.out.println("Kode Program    : " + getKodeProgram());
        System.out.println("Mata Pelajaran  : " + getNamaMapel());
        System.out.println("Jadwal          : " + getJadwal());
        System.out.println("Latihan Soal    : " + jenisLatihanSoal);
        System.out.printf("Biaya Dasar     : Rp%.2f%n", getBiayaDasar());
        System.out.printf("Diskon Online   : Rp%.2f%n", diskonOnline);
        System.out.printf("Total Biaya     : Rp%.2f%n", hitungTotalBiaya());
        System.out.println("========================================");
    }
}
