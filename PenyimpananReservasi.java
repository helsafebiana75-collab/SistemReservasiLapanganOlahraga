package com.mycompany.sistemreservasilapanganolahraga;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Date;

public class PenyimpananReservasi {

    private static final String FILE_DATA = "data_reservasi.dat";
    private static final String FILE_LOG = "riwayat_aktivitas.txt";

    // Menyimpan data lapangan dan pelanggan
    public static void simpanData(
            ArrayList<Lapangan> daftarLapangan,
            HashMap<String, Pelanggan> dataPelanggan) {

        try (ObjectOutputStream output =
                new ObjectOutputStream(
                        new FileOutputStream(FILE_DATA))) {

            output.writeObject(daftarLapangan);
            output.writeObject(dataPelanggan);

            System.out.println("Data berhasil disimpan.");

        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    // Memuat data lapangan dan pelanggan
    @SuppressWarnings("unchecked")
    public static void muatData(
            ArrayList<Lapangan> daftarLapangan,
            HashMap<String, Pelanggan> dataPelanggan) {

        File file = new File(FILE_DATA);

        if (!file.exists()) {
            System.out.println("File data belum tersedia.");
            return;
        }

        try (ObjectInputStream input =
                new ObjectInputStream(
                        new FileInputStream(FILE_DATA))) {

            ArrayList<Lapangan> lapanganTersimpan =
                    (ArrayList<Lapangan>) input.readObject();

            HashMap<String, Pelanggan> pelangganTersimpan =
                    (HashMap<String, Pelanggan>) input.readObject();

            daftarLapangan.clear();
            daftarLapangan.addAll(lapanganTersimpan);

            dataPelanggan.clear();
            dataPelanggan.putAll(pelangganTersimpan);

            System.out.println("Data berhasil dimuat.");
            System.out.println("Jumlah lapangan: " + daftarLapangan.size());
            System.out.println("Jumlah pelanggan: " + dataPelanggan.size());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }

    // Mencatat aktivitas ke file TXT
    public static void catatLog(String aktivitas) {

        try (FileWriter writer = new FileWriter(FILE_LOG, true)) {

            writer.write(new Date() + " - " + aktivitas);
            writer.write(System.lineSeparator());

        } catch (IOException e) {
            System.out.println("Gagal mencatat aktivitas: " + e.getMessage());
        }
    }

    // Membaca riwayat aktivitas
    public static void bacaLog() {

        File file = new File(FILE_LOG);

        if (!file.exists()) {
            System.out.println("Belum ada riwayat aktivitas.");
            return;
        }

        try (Scanner pembaca = new Scanner(file)) {

            System.out.println("\n===== RIWAYAT AKTIVITAS =====");

            while (pembaca.hasNextLine()) {
                System.out.println(pembaca.nextLine());
            }

        } catch (IOException e) {
            System.out.println("Gagal membaca log: " + e.getMessage());
        }
    }
}
