package com.mycompany.sistemreservasilapanganolahraga;

public abstract class Lapangan {
    public abstract void cekFasilitas();
    private String namaLapangan;
    private String lokasi;
    private int hargaPerJam;

    public static int totalLapanganBerhasilDibuat = 0;

    public Lapangan(String namaLapangan, String lokasi, int hargaPerJam) {
        this.setNamaLapangan(namaLapangan);
        this.setLokasi(lokasi);
        this.setHargaPerJam(hargaPerJam);
        totalLapanganBerhasilDibuat++;
    }

    public String getNamaLapangan() {
        return this.namaLapangan;
    }

    public void setNamaLapangan(String namaLapangan) {
        if (namaLapangan != null && !namaLapangan.trim().isEmpty()) {
            this.namaLapangan = namaLapangan;
        } else {
            this.namaLapangan = "Tidak diketahui";
        }
    }

    public String getLokasi() {
        return this.lokasi;
    }

    public void setLokasi(String lokasi) {
        if (lokasi != null && !lokasi.trim().isEmpty()) {
            this.lokasi = lokasi;
        } else {
            this.lokasi = "Tidak diketahui";
        }
    }

    public int getHargaPerJam() {
        return this.hargaPerJam;
    }

    public void setHargaPerJam(int hargaPerJam) {
        if (hargaPerJam > 0) {
            this.hargaPerJam = hargaPerJam;
        } else {
            this.hargaPerJam = 0;
            System.out.println("Harga per jam harus lebih dari 0.");
        }
    }

    public void tampilkanInfo() {
        System.out.printf(
            "Lapangan: %-18s | Lokasi: %-15s | Harga/Jam: Rp%,d%n",
            this.namaLapangan,
            this.lokasi,
            this.hargaPerJam
        );
    }


    
}