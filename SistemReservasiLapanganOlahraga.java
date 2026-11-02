package com.mycompany.sistemreservasilapanganolahraga;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;

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
            
        public static Lapangan cariLapangan(
            String nama,
            ArrayList<Lapangan> daftarLapangan)
                throws LapanganTidakDitemukanException {

            if (nama == null || nama.trim().isEmpty()) {
                throw new LapanganTidakDitemukanException(
                        "Nama lapangan tidak boleh kosong."
                );
            }

            for (Lapangan lapangan : daftarLapangan) {

                if (lapangan.getNamaLapangan()
                        .equalsIgnoreCase(nama)) {

                    return lapangan;
                }
            }

            throw new LapanganTidakDitemukanException(
                    "Lapangan " + nama + " tidak ditemukan."
            );
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
        lapangan.cekFasilitas();

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
            DapatDipesan reservasi = (DapatDipesan) lapangan;
            reservasi.tampilkanAturanReservasi();
        }
        
        if (lapangan instanceof DapatDiperiksa) {
            DapatDiperiksa status = (DapatDiperiksa) lapangan;
            status.tampilkanStatusLapangan();
        }
        System.out.println("Reservasi berhasil diproses.");
    }
            
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Lapangan> daftarLapangan =
                new ArrayList<>();
        HashMap<String, Pelanggan> dataPelanggan =
                new HashMap<>();
        boolean isRunning = true;
        
        daftarLapangan.add(
                new LapanganFutsal(
                        "Futsal Arena 1",
                        "Rajabasa",
                        80000,
                        "Sintetis",
                        true
                )
                );

        daftarLapangan.add(
                new LapanganFutsal(
                        "Futsal Arena 2",
                        "Kedaton",
                        90000,
                        "Vinyl",
                        true
                )
                );

        daftarLapangan.add(
                new LapanganFutsal(
                        "Futsal Galaxy",
                        "Labuhan Ratu",
                        75000,
                        "Sintetis",
                        false
                )
                );

        daftarLapangan.add(
                new LapanganBadminton(
                        "Badminton Hall A",
                        "Rajabasa",
                        60000,
                        "Vinyl",
                        2
                )
                );
        

        daftarLapangan.add(
                new LapanganBadminton(
                        "Badminton Hall B",
                        "Kedaton",
                        70000,
                        "Karpet",
                        3
                )
                );
        
        daftarLapangan.add(
        new LapanganBasket(
                "Basket Arena",
                "Rajabasa",
                70000,
                "Vinyl",
                true
        )
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
            System.out.println("6. Kelola Data Pelanggan");
            System.out.println("7. Keluar");
            System.out.println("=========================================");

            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {

                case 1:

                    if (true) {

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

                            daftarLapangan.add(
                                    new LapanganFutsal(
                                            nama,
                                            lokasi,
                                            harga,
                                            rumput,
                                            tersediaMalam
                                    )
                                    );

                            System.out.println(
                                "Data lapangan futsal berhasil ditambahkan!"
                            );

                        } else if (jenis == 2) {

                            System.out.print("Jenis Lantai: ");
                            String lantai = scanner.nextLine();

                            System.out.print("Jumlah Net: ");
                            int jumlahNet = scanner.nextInt();
                            scanner.nextLine();

                            daftarLapangan.add(
                                    new LapanganBadminton(
                                            nama,
                                            lokasi,
                                            harga,
                                            lantai,
                                            jumlahNet
                                    )
                                    );


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

                            daftarLapangan.add(
                                    new LapanganBasket(
                                            nama,
                                            lokasi,
                                            harga,
                                            lantai,
                                            tersediaMalam
                                    )
                                    );

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

                    if (daftarLapangan.isEmpty()) {

                        System.out.println(
                            "Belum ada data lapangan."
                        );

                    } else {

                        for (int i = 0; i < daftarLapangan.size(); i++) {

                            System.out.print((i + 1) + ". ");
                            
                            daftarLapangan.get(i).tampilkanInfo();

                            daftarLapangan.get(i).cekFasilitas();


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
                        
                        try {
                            Lapangan hasil = cariLapangan(namaCari, daftarLapangan);
                            hasil.tampilkanInfo();
                        } catch (LapanganTidakDitemukanException e) {
                            System.out.println(e.getMessage());
                        }

                    } else if (jenisCari == 2) {

                        System.out.print("Masukkan harga: ");

                        int hargaCari = scanner.nextInt();
                        scanner.nextLine();

                        cariLapangan(
                                hargaCari,
                                daftarLapangan.toArray(new Lapangan[0]),
                                daftarLapangan.size()
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
                                daftarLapangan.toArray(new Lapangan[0]),
                                daftarLapangan.size()
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

                    if (daftarLapangan.isEmpty()) {

                        System.out.println(
                            "Belum ada lapangan."
                        );

                    } else {

                        for (int i = 0; i < daftarLapangan.size(); i++) {
                            
                        System.out.println(
                            (i + 1) + ". " +
                            daftarLapangan.get(i).getNamaLapangan()
                        );    
    
                        }

                        System.out.print(
                            "Pilih nomor lapangan: "
                        );

                        int nomor = scanner.nextInt();
                        scanner.nextLine();

                        if (nomor >= 1 && nomor <= daftarLapangan.size()) {

                            daftarLapangan.get(nomor - 1).cekFasilitas();

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

                    if (daftarLapangan.isEmpty()) {

                        System.out.println(
                            "Belum ada lapangan."
                        );

                    } else {

                        for (int i = 0; i < daftarLapangan.size(); i++) {

                            System.out.println(
                                (i + 1) + ". "
                                + daftarLapangan.get(i).getNamaLapangan()
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
                                && nomorReservasi <= daftarLapangan.size()
                                && durasi > 0) {

                            Lapangan lapanganDipilih =
                                    daftarLapangan.get(nomorReservasi - 1);

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
                    dataPelanggan.put(
                            "081234567890",
                            new Pelanggan(
                                    "Andi",
                                    "081234567890",
                                    "Rajabasa")
                    );

                    dataPelanggan.put(
                            "082345678901",
                            new Pelanggan(
                                    "Sinta",
                                    "082345678901",
                                    "Kedaton")
                    );

                    dataPelanggan.put(
                            "083456789012",
                            new Pelanggan(
                                    "Rizky",
                                    "083456789012",
                                    "Labuhan Ratu")
                    );

                    System.out.println(
                        "\n========== DATA PELANGGAN =========="
                    );

                    for (String key : dataPelanggan.keySet()) {
                        System.out.println("Nomor telepon: " + key);
                        dataPelanggan.get(key).tampilkanInfoPelanggan();
                    }
                    
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