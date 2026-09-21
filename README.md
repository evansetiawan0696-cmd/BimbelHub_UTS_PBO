# BimbelHub - Sistem Manajemen Bimbingan Belajar (Java CLI)

## Identitas
* **Nama** : Evan Setiawan
* **NIM**  : 2509116036
* **Kelas** : A 2025
* **Program Studi**: Sistem Informasi

---

## Deskripsi Program:
**BimbelHub** adalah aplikasi berbasis konsol (*Command Line Interface* / CLI) yang dirancang untuk mengelola pendaftaran dan pendataan program bimbingan belajar (les) secara terstruktur. Aplikasi ini membedakan program les menjadi dua kategori utama, yaitu **Les Offline** (tatap muka) dan **Les Online** (daring).

### Perbedaan Layanan:
* **Les Offline**: Memiliki opsi pemilihan fasilitas kelas fisik (seperti *Reguler* atau *VIP*) serta perhitungan `biayaFasilitas` (ruangan, AC, modul cetak).
* **Les Online**: Menawarkan akses ke sistem `jenisLatihanSoal` (seperti *Bank Soal PDF* atau *Tryout Interaktif*) serta skema `diskonOnline` sebagai potongan harga hemat operasional.

---
## Penerapan Konsep PBO (OOP)

1. **Package Management**
   * Mengelompokkan kelas data/entitas ke dalam `package model;` (`ProgramLes`, `LesOffline`, `LesOnline`).
   * Mengelompokkan kelas eksekusi/CLI ke dalam `package main;` (`BimbelHubApp`).

2. **Encapsulation (Enkapsulasi)**
   * Atribut menggunakan *access modifier* `protected` pada superclass dan `private` pada subclass.
   * Pintu akses data menggunakan metode **Getter** dan **Setter**.
   * Metode **Setter** dilengkapi dengan **validasi data** (misal: durasi/biaya tidak boleh bernilai <= 0, teks tidak boleh kosong).
   * Inisialisasi data pada *Constructor* memanggil metode Setter untuk memastikan validasi berlaku sejak objek dibuat.

3. **Inheritance (Pewarisan)**
   * Class `LesOffline` dan `LesOnline` menggunakan kata kunci `extends ProgramLes` untuk mewarisi atribut umum (`kodeProgram`, `namaMapel`, `jadwal`, `durasiBulan`, `biayaDasar`).
   * Pemanggilan `super(...)` diletakkan tepat pada **baris pertama** *constructor* subclass.

4. **Method Overriding & Polimorfisme**
   * Metode `hitungTotalBiaya()` di-*override* (`@Override`) pada kedua subclass:
     * **LesOffline**: `(durasiBulan * biayaDasar) + biayaFasilitas`
     * **LesOnline**: `(durasiBulan * biayaDasar) - diskonOnline`
   * Metode `tampilkanDetail()` di-*override* untuk menampilkan atribut spesifik milik masing-masing kategori les.

5. **Collection & Scanner Handling**
   * Menggunakan `ArrayList<ProgramLes>` pada class `BimbelHubApp` untuk menampung seluruh objek secara dinamis.
   * Menggunakan operator `instanceof` saat penelusuran data (*looping*) untuk memanggil detail spesifik subclass.
   * Menggunakan `scanner.nextLine()` setelah pembacaan angka (`nextInt()` / `nextDouble()`) untuk pembersihan *buffer*.
   * Menggunakan `.equalsIgnoreCase()` untuk pencarian string data.
  
---
##  Tangkapan Layar Output Program

### 1. Menu Utama Aplikasi
<img width="323" height="264" alt="image" src="https://github.com/user-attachments/assets/60360650-065c-4268-9428-5154d9d64aee" />


### 2. Tambah Data Les Offline & Online
<img width="351" height="302" alt="image" src="https://github.com/user-attachments/assets/9b5b3fd2-8bb1-46be-9f2b-ff22e7ee7bab" />
<img width="341" height="282" alt="image" src="https://github.com/user-attachments/assets/a70a39bb-c49f-4254-abe5-43a9cea9e7f0" />


### 3. Tampilkan Semua Data Les
<img width="332" height="419" alt="image" src="https://github.com/user-attachments/assets/f92f0d89-e12d-4564-8f32-57bd4307cabd" />


### 4. Hapus Data Les
<img width="356" height="111" alt="image" src="https://github.com/user-attachments/assets/9c536c3e-1828-4dbd-a7eb-46cff5248b6b" />


---

##  Hierarki Class & Diagram Structure

```text
                     +-------------------+
                     |    ProgramLes     |  <-- Superclass (package model)
                     +-------------------+
                     | # kodeProgram     |
                     | # namaMapel       |
                     | # jadwal          |
                     | # durasiBulan     |
                     | # biayaDasar      |
                     +-------------------+
                               |
               +---------------+---------------+
               |                               |
               v                               v
     +-------------------+           +-------------------+
     |    LesOffline     |           |     LesOnline     |  <-- Subclasses (package model)
     +-------------------+           +-------------------+
     | - namaKelas       |           | - jenisLatihanSoal|
     | - biayaFasilitas  |           | - diskonOnline    |
     +-------------------+           +-------------------+

-----------------------------------------------------------------
     +-------------------+
     |   BimbelHubApp    |  <-- Main Executable Class (package main)
     +-------------------+


---

