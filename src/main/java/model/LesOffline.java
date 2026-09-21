/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class LesOffline extends ProgramLes {

    // Atribut private sesuai ketentuan subclass
    private String namaKelas;
    private double biayaFasilitas;

    // Constructor
    public LesOffline(
            String kodeProgram,
            String namaMapel,
            String jadwal,
            double biayaDasar,
            String namaKelas,
            double biayaFasilitas) {

        // constructor subclass
        super(kodeProgram, namaMapel, jadwal, biayaDasar);

        setNamaKelas(namaKelas);
        setBiayaFasilitas(biayaFasilitas);
    }

    // Getter dan Setter namaKelas
    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        if (namaKelas != null && !namaKelas.trim().isEmpty()) {
            this.namaKelas = namaKelas.trim();
        } else {
            System.out.println(">> ERROR VALIDASI: Nama kelas tidak boleh kosong.");
            this.namaKelas = "Kelas Reguler";
        }
    }

    // Getter dan Setter biayaFasilitas
    public double getBiayaFasilitas() {
        return biayaFasilitas;
    }

    public void setBiayaFasilitas(double biayaFasilitas) {
        if (biayaFasilitas >= 0) {
            this.biayaFasilitas = biayaFasilitas;
        } else {
            System.out.println(">> ERROR VALIDASI: Biaya fasilitas tidak boleh negatif.");
            this.biayaFasilitas = 0.0;
        }
    }

    // Override hitungTotalBiaya
    @Override
    public double hitungTotalBiaya() {
        return super.hitungTotalBiaya() + biayaFasilitas;
    }

    // Override tampilkanDetail
    @Override
    public void tampilkanDetail() {
        System.out.println("========================================");
        System.out.println("PROGRAM LES OFFLINE");
        System.out.println("Kode Program    : " + getKodeProgram());
        System.out.println("Mata Pelajaran  : " + getNamaMapel());
        System.out.println("Jadwal          : " + getJadwal());
        System.out.println("Nama Kelas      : " + namaKelas);
        System.out.printf("Biaya Dasar     : Rp%.2f%n", getBiayaDasar());
        System.out.printf("Biaya Fasilitas : Rp%.2f%n", biayaFasilitas);
        System.out.printf("Total Biaya     : Rp%.2f%n", hitungTotalBiaya());
        System.out.println("========================================");
    }
}
