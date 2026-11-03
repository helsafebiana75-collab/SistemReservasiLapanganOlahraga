package com.mycompany.sistemreservasilapanganolahraga;

import java.util.ArrayList;
import java.util.HashMap;

public class PengelolaReservasi {

    private ArrayList<Lapangan> daftarLapangan;
    private HashMap<String, Pelanggan> dataPelanggan;

    private FasilitasPengelola fasilitas;

    public PengelolaReservasi() {

        daftarLapangan = new ArrayList<>();
        dataPelanggan = new HashMap<>();

        fasilitas = new FasilitasPengelola(
                "Sistem Reservasi Lapangan Olahraga",
                "Universitas Lampung",
                "Reservasi Futsal, Badminton, dan Basket"
        );
    }

    public void tambahLapangan(Lapangan lapangan) {
        daftarLapangan.add(lapangan);

        System.out.println(
                "Data lapangan berhasil ditambahkan."
        );
    }

    public void tambahPelanggan(Pelanggan pelanggan) {

        dataPelanggan.put(
                pelanggan.getNomorTelepon(),
                pelanggan
        );

        System.out.println(
                "Data pelanggan berhasil ditambahkan."
        );
    }

    public Pelanggan cariPelanggan(String nomorTelepon) {
        return dataPelanggan.get(nomorTelepon);
    }

    public void lihatSemuaPelanggan() {

        System.out.println("\n===== DATA PELANGGAN =====");

        if (dataPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan.");
            return;
        }

        for (String key : dataPelanggan.keySet()) {
            System.out.println("Nomor Telepon: " + key);
            dataPelanggan.get(key).tampilkanInfoPelanggan();
        }
    }

    public ArrayList<Lapangan> getDaftarLapangan() {
        return daftarLapangan;
    }

    public HashMap<String, Pelanggan> getDataPelanggan() {
        return dataPelanggan;
    }
    
    public void tampilkanKomponen() {
        fasilitas.tampilkanFasilitas();
    }
}
