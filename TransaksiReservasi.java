package com.mycompany.sistemreservasilapanganolahraga;

public class TransaksiReservasi {

    public static void prosesTransaksi(
            Pelanggan pelanggan,
            Lapangan lapangan,
            int durasi) {

        System.out.println("\n================================");
        System.out.println("       TRANSAKSI RESERVASI");
        System.out.println("================================");

        System.out.println("\nData Pelanggan:");
        pelanggan.tampilkanInfoPelanggan();

        System.out.println("\nData Lapangan:");
        lapangan.tampilkanInfo();

        System.out.println("\nDetail Transaksi:");
        System.out.println("Durasi       : " + durasi + " jam");

        int totalHarga =
                lapangan.getHargaPerJam() * durasi;

        System.out.printf(
                "Total Harga  : Rp%,d%n",
                totalHarga
        );

        System.out.println("\nStatus: Reservasi berhasil!");
        System.out.println("================================");
    }
}
