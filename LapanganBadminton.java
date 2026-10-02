package com.mycompany.sistemreservasilapanganolahraga;

public class LapanganBadminton extends Lapangan {
    private String jenisLantai;
    private int jumlahNet;

    public LapanganBadminton(
            String namaLapangan,
            String lokasi,
            int hargaPerJam,
            String jenisLantai,
            int jumlahNet) {

        super(namaLapangan, lokasi, hargaPerJam);
        this.jenisLantai = jenisLantai;
        this.setJumlahNet(jumlahNet);
    }

    public String getJenisLantai() {
        return this.jenisLantai;
    }

    public void setJenisLantai(String jenisLantai) {
        if (jenisLantai != null && !jenisLantai.trim().isEmpty()) {
            this.jenisLantai = jenisLantai;
        }
    }

    public int getJumlahNet() {
        return this.jumlahNet;
    }

    public void setJumlahNet(int jumlahNet) {
        if (jumlahNet > 0) {
            this.jumlahNet = jumlahNet;
        } else {
            System.out.println("Jumlah net harus lebih dari 0.");
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf(
            "[BADMINTON] %-18s | Lokasi: %-15s | Rp%,d/jam | Lantai: %-10s | Net: %d%n",
            this.getNamaLapangan(),
            this.getLokasi(),
            this.getHargaPerJam(),
            this.jenisLantai,
            this.jumlahNet
        );
    }

    @Override
    public void cekFasilitas() {
        System.out.println(
            "-> Fasilitas: net badminton, lampu lapangan, tempat duduk, dan toilet."
        );
    }
}