package com.mycompany.sistemreservasilapanganolahraga;

import java.util.Scanner;

public class SistemReservasiLapanganOlahraga {

    public static void cariLapangan(
            String namaLapangan,
            Lapangan[] daftarLapangan,
            int jumlahLapangan) {

        System.out.println("\nMencari lapangan: " + namaLapangan);

        boolean ditemukan = false;

        for (int i = 0; i < jumlahLapangan; i++) {

            if (daftarLapangan[i]
                    .getNamaLapangan()
                    .equalsIgnoreCase(namaLapangan)) {

                daftarLapangan[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Lapangan tidak ditemukan.");
        }
    }

    public static void cariLapangan(
            int harga,
            Lapangan[] daftarLapangan,
            int jumlahLapangan) {

        System.out.println("\nMencari lapangan dengan harga Rp" + harga);

        boolean ditemukan = false;

        for (int i = 0; i < jumlahLapangan; i++) {

            if (daftarLapangan[i].getHargaPerJam() == harga) {

                daftarLapangan[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Lapangan dengan harga tersebut tidak ditemukan.");
        }
    }


    public static void cariLapangan(
            String lokasi,
            String tipe,
            Lapangan[] daftarLapangan,
            int jumlahLapangan) {

        System.out.println(
            "\nMencari lapangan tipe " + tipe +
            " di lokasi " + lokasi
        );

        boolean ditemukan = false;

        for (int i = 0; i < jumlahLapangan; i++) {

            boolean cocokLokasi =
                    daftarLapangan[i]
                    .getLokasi()
                    .equalsIgnoreCase(lokasi);

            boolean cocokTipe = false;

            if (tipe.equalsIgnoreCase("Futsal")) {

                if (daftarLapangan[i] instanceof LapanganFutsal) {
                    cocokTipe = true;
                }

            } else if (tipe.equalsIgnoreCase("Badminton")) {

                if (daftarLapangan[i] instanceof LapanganBadminton) {
                    cocokTipe = true;
                }
            } else if (tipe.equalsIgnoreCase("Basket")) {

                if (daftarLapangan[i] instanceof LapanganBasket) {
                    cocokTipe = true;
                }
            }

            if (cocokLokasi && cocokTipe) {
                daftarLapangan[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Data lapangan tidak ditemukan.");
        }
    }

    public static void prosesReservasi(Lapangan lapangan) {
        System.out.println("\n===== PROSES RESERVASI =====");

        System.out.println("Lapangan yang dipilih:");
        lapangan.tampilkanInfo();

        System.out.println("Memeriksa fasilitas...");
        lapangan.1cekFasilitas();

        System.out.println("Reservasi berhasil diproses.");
     }
    
    public static void prosesReservasi(Lapangan lapangan, int durasi) {
        int totalHarga = lapangan.getHargaPerJam() * durasi;

        System.out.println("\n===== DETAIL RESERVASI =====");
        lapangan.tampilkanInfo();
        System.out.println("Durasi: " + durasi + " jam");
        System.out.printf("Total harga: Rp%,d%n", totalHarga);
        System.out.println("Reservasi berhasil diproses.");
        
        
        if (lapangan instanceof DapatDipesan) {
            DapatDipesan reservasi =
                    (DapatDipesan) lapangan;
            reservasi.tampilkanAturanReservasi();
        }
        System.out.println("Reservasi berhasil diproses.");
    }
            
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Lapangan[] daftarLapangan = new Lapangan[20];
        int jumlahLapangan = 0;
        boolean isRunning = true;

        daftarLapangan[jumlahLapangan++] =
                new LapanganFutsal(
                        "Futsal Arena 1",
                        "Rajabasa",
                        80000,
                        "Sintetis",
                        true
                );

        daftarLapangan[jumlahLapangan++] =
                new LapanganFutsal(
                        "Futsal Arena 2",
                        "Kedaton",
                        90000,
                        "Vinyl",
                        true
                );

        daftarLapangan[jumlahLapangan++] =
                new LapanganFutsal(
                        "Futsal Galaxy",
                        "Labuhan Ratu",
                        75000,
                        "Sintetis",
                        false
                );

        daftarLapangan[jumlahLapangan++] =
                new LapanganBadminton(
                        "Badminton Hall A",
                        "Rajabasa",
                        60000,
                        "Vinyl",
                        2
                );
        

        daftarLapangan[jumlahLapangan++] =
                new LapanganBadminton(
                        "Badminton Hall B",
                        "Kedaton",
                        70000,
                        "Karpet",
                        3
                );
        
        daftarLapangan[jumlahLapangan++] =
        new LapanganBasket(
                "Basket Arena",
                "Rajabasa",
                70000,
                "Vinyl",
                true
        );
    
        System.out.println("==============================================");
        System.out.println("       SISTEM RESERVASI LAPANGAN OLAHRAGA    ");
        System.out.println("==============================================");

        while (isRunning) {

            System.out.println("\n============== MENU UTAMA ==============");
            System.out.println("1. Tambah Data Lapangan");
            System.out.println("2. Tampilkan Seluruh Data");
            System.out.println("3. Pencarian Lapangan");
            System.out.println("4. Cek Fasilitas Lapangan");
            System.out.println("5. Proses Reservasi");
            System.out.println("6. Tampilkan Data Pelanggan");
            System.out.println("7. Keluar");
            System.out.println("=========================================");

            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {

                case 1:

                    if (jumlahLapangan < daftarLapangan.length) {

                        System.out.println("\n--- Pilih Jenis Lapangan ---");
                        System.out.println("1. Lapangan Futsal");
                        System.out.println("2. Lapangan Badminton");
                        System.out.println("3. Lapangan Basket");
                        System.out.print("Pilihan: ");

                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nama Lapangan: ");
                        String nama = scanner.nextLine();

                        System.out.print("Lokasi: ");
                        String lokasi = scanner.nextLine();

                        System.out.print("Harga per Jam: ");
                        int harga = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {

                            System.out.print("Jenis Rumput: ");
                            String rumput = scanner.nextLine();

                            System.out.print(
                                "Tersedia malam hari? (y/n): "
                            );

                            String malam = scanner.nextLine();

                            boolean tersediaMalam =
                                    malam.equalsIgnoreCase("y");

                            daftarLapangan[jumlahLapangan] =
                                    new LapanganFutsal(
                                            nama,
                                            lokasi,
                                            harga,
                                            rumput,
                                            tersediaMalam
                                    );

                            jumlahLapangan++;

                            System.out.println(
                                "Data lapangan futsal berhasil ditambahkan!"
                            );

                        } else if (jenis == 2) {

                            System.out.print("Jenis Lantai: ");
                            String lantai = scanner.nextLine();

                            System.out.print("Jumlah Net: ");
                            int jumlahNet = scanner.nextInt();
                            scanner.nextLine();

                            daftarLapangan[jumlahLapangan] =
                                    new LapanganBadminton(
                                            nama,
                                            lokasi,
                                            harga,
                                            lantai,
                                            jumlahNet
                                    );

                            jumlahLapangan++;

                            System.out.println(
                                "Data lapangan badminton berhasil ditambahkan!"
                            );

                        } else if (jenis == 3) {

                            System.out.print("Jenis Lantai: ");
                            String lantai = scanner.nextLine();

                            System.out.print(
                                "Tersedia malam hari? (y/n): "
                            );

                            String malam = scanner.nextLine();

                            boolean tersediaMalam =
                                    malam.equalsIgnoreCase("y");

                            daftarLapangan[jumlahLapangan] =
                                    new LapanganBasket(
                                            nama,
                                            lokasi,
                                            harga,
                                            lantai,
                                            tersediaMalam
                                    );

                            jumlahLapangan++;

                            System.out.println(
                                "Data lapangan basket berhasil ditambahkan!"
                            );

                                } else {

                                    System.out.println(
                                        "Jenis lapangan tidak valid."
                                    );
                                }

                            } else {

                                System.out.println(
                                    "Kapasitas penyimpanan lapangan sudah penuh."
                                );
                            }

                break;
                case 2:

                    System.out.println(
                        "\n========== DAFTAR LAPANGAN =========="
                    );

                    if (jumlahLapangan == 0) {

                        System.out.println(
                            "Belum ada data lapangan."
                        );

                    } else {

                        for (int i = 0; i < jumlahLapangan; i++) {

                            System.out.print((i + 1) + ". ");

                            // POLYMORPHISM
                            // Akan memanggil method overriding
                            daftarLapangan[i].tampilkanInfo();

                            daftarLapangan[i].cekFasilitas();

                            System.out.println();
                        }

                        System.out.println(
                            "Total objek lapangan dibuat: "
                            + Lapangan.totalLapanganBerhasilDibuat
                        );
                    }

                    break;

                case 3:

                    System.out.println(
                        "\n========== PENCARIAN LAPANGAN =========="
                    );

                    System.out.println("1. Berdasarkan Nama");
                    System.out.println("2. Berdasarkan Harga");
                    System.out.println("3. Berdasarkan Lokasi + Tipe");

                    System.out.print("Pilih pencarian: ");

                    int jenisCari = scanner.nextInt();
                    scanner.nextLine();

                    if (jenisCari == 1) {

                        System.out.print("Masukkan nama lapangan: ");

                        String namaCari = scanner.nextLine();

                        cariLapangan(
                                namaCari,
                                daftarLapangan,
                                jumlahLapangan
                        );

                    } else if (jenisCari == 2) {

                        System.out.print("Masukkan harga: ");

                        int hargaCari = scanner.nextInt();
                        scanner.nextLine();

                        cariLapangan(
                                hargaCari,
                                daftarLapangan,
                                jumlahLapangan
                        );

                    } else if (jenisCari == 3) {

                        System.out.print("Masukkan lokasi: ");

                        String lokasiCari = scanner.nextLine();

                        System.out.println("1. Futsal");
                        System.out.println("2. Badminton");
                        System.out.println("3. Basket");
                        System.out.print("Pilih tipe: ");

                        int tipeCari = scanner.nextInt();
                        scanner.nextLine();

                        String tipe;

                        if (tipeCari == 1) {

                            tipe = "Futsal";

                        } else if (tipeCari == 2) {

                            tipe = "Badminton";

                        } else if (tipeCari == 3) {

                            tipe = "Basket";

                        } else {

                            tipe = "";
                        }

                        cariLapangan(
                                lokasiCari,
                                tipe,
                                daftarLapangan,
                                jumlahLapangan
                        );

                    } else {

                        System.out.println(
                            "Pilihan pencarian tidak valid."
                        );
                    }

                    break;


                case 4:

                    System.out.println(
                        "\n======= CEK FASILITAS ======="
                    );

                    if (jumlahLapangan == 0) {

                        System.out.println(
                            "Belum ada lapangan."
                        );

                    } else {

                        for (int i = 0; i < jumlahLapangan; i++) {

                            System.out.println(
                                (i + 1) + ". "
                                + daftarLapangan[i].getNamaLapangan()
                            );
                        }

                        System.out.print(
                            "Pilih nomor lapangan: "
                        );

                        int nomor = scanner.nextInt();
                        scanner.nextLine();

                        if (nomor >= 1
                                && nomor <= jumlahLapangan) {

                            daftarLapangan[nomor - 1]
                                    .cekFasilitas();

                        } else {

                            System.out.println(
                                "Nomor lapangan tidak valid."
                            );
                        }
                    }

                    break;

                case 5:
                    System.out.println(
                        "\n======= PROSES RESERVASI ======="
                    );

                    if (jumlahLapangan == 0) {

                        System.out.println(
                            "Belum ada lapangan."
                        );

                    } else {

                        for (int i = 0; i < jumlahLapangan; i++) {

                            System.out.println(
                                (i + 1) + ". "
                                + daftarLapangan[i].getNamaLapangan()
                            );
                        }

                        System.out.print(
                            "Pilih nomor lapangan: "
                        );

                        int nomorReservasi =
                                scanner.nextInt();

                        System.out.print(
                            "Masukkan durasi (jam): "
                        );

                        int durasi =
                                scanner.nextInt();

                        scanner.nextLine();

                        if (nomorReservasi >= 1
                                && nomorReservasi <= jumlahLapangan
                                && durasi > 0) {

                            Lapangan lapanganDipilih =
                                    daftarLapangan[nomorReservasi - 1];

                            prosesReservasi(
                                    lapanganDipilih,
                                    durasi
                            );

                        } else {

                            System.out.println(
                                "Data reservasi tidak valid."
                            );
                        }
                    }

                    break;
                case 6 :
                    Pelanggan pelanggan1 =
                            new Pelanggan(
                                    "Andi",
                                    "081234567890",
                                    "Rajabasa"
                            );

                    Pelanggan pelanggan2 =
                            new Pelanggan(
                                    "Sinta",
                                    "082345678901",
                                    "Kedaton"
                            );

                    Pelanggan pelanggan3 =
                            new Pelanggan(
                                    "Rizky",
                                    "083456789012",
                                    "Labuhan Ratu"
                            );

                    System.out.println(
                        "\n========== DATA PELANGGAN =========="
                    );

                    pelanggan1.tampilkanInfoPelanggan();
                    pelanggan2.tampilkanInfoPelanggan();
                    pelanggan3.tampilkanInfoPelanggan();

                    System.out.println(
                        "Total pelanggan dibuat: "
                        + Pelanggan.totalPelanggan
                    );

                    break;


                case 7:

                    System.out.println(
                        "\n========================================"
                    );

                    System.out.println(
                        "Terima kasih telah menggunakan"
                    );

                    System.out.println(
                        "Sistem Reservasi Lapangan Olahraga!"
                    );

                    System.out.println(
                        "========================================"
                    );

                    isRunning = false;

                    break;

                default:

                    System.out.println(
                        "Pilihan menu tidak valid."
                    );
            }
        }

        scanner.close();
    }
}