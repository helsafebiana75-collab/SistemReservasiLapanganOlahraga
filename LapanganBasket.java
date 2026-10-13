package com.mycompany.sistemreservasilapanganolahraga;

public class LapanganBasket extends Lapangan implements DapatDipesan {
    private String jenisLantai;
    private boolean tersediaMalam;

    public LapanganBasket(
            String namaLapangan,
            String lokasi,
            int hargaPerJam,
            String jenisLantai,
            boolean tersediaMalam) {

        super(namaLapangan, lokasi, hargaPerJam);
        this.jenisLantai = jenisLantai;
        this.tersediaMalam = tersediaMalam;
    }

    public String getJenisLantai() {
        return this.jenisLantai;
    }

    public void setJenisLantai(String jenisLantai) {
        if (jenisLantai != null && !jenisLantai.trim().isEmpty()) {
            this.jenisLantai = jenisLantai;
        }
    }

    public boolean isTersediaMalam() {
        return this.tersediaMalam;
    }

    public void setTersediaMalam(boolean tersediaMalam) {
        this.tersediaMalam = tersediaMalam;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf(
            "[BASKET]    %-18s | Lokasi: %-15s | Rp%,d/jam | Lantai: %-10s | Malam: %s%n",
            this.getNamaLapangan(),
            this.getLokasi(),
            this.getHargaPerJam(),
            this.jenisLantai,
            this.tersediaMalam ? "Ya" : "Tidak"
        );
    }

    @Override
    public void cekFasilitas() {
        System.out.println(
            "-> Fasilitas: ring basket, lampu lapangan, tempat duduk, dan toilet."
        );
    }
    
    
    @Override
    public void tampilkanAturanReservasi() {
        System.out.println(
            "Aturan: Reservasi basket dihitung berdasarkan durasi jam."
        );
    }
}