package com.mycompany.sistemreservasilapanganolahraga;

public class Pelanggan {
    private String nama;
    private String nomorTelepon;
    private String alamat;

    public static int totalPelanggan = 0;

    public Pelanggan(String nama, String nomorTelepon, String alamat) {
        this.setNama(nama);
        this.setNomorTelepon(nomorTelepon);
        this.setAlamat(alamat);
        totalPelanggan++;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        } else {
            this.nama = "Tanpa Nama";
        }
    }

    public String getNomorTelepon() {
        return this.nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        if (nomorTelepon != null && nomorTelepon.matches("[0-9]+")) {
            this.nomorTelepon = nomorTelepon;
        } else {
            this.nomorTelepon = "Tidak valid";
        }
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setAlamat(String alamat) {
        if (alamat != null && !alamat.trim().isEmpty()) {
            this.alamat = alamat;
        } else {
            this.alamat = "Tidak diketahui";
        }
    }

    public void tampilkanInfoPelanggan() {
        System.out.printf(
            "Nama: %-20s | No. HP: %-15s | Alamat: %s%n",
            this.nama,
            this.nomorTelepon,
            this.alamat
        );
    }
}