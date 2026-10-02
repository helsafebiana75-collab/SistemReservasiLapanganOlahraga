package com.mycompany.sistemreservasilapanganolahraga;

public class LapanganFutsal extends Lapangan {
    private String jenisRumput;
    private boolean tersediaMalam;

    public LapanganFutsal(
            String namaLapangan,
            String lokasi,
            int hargaPerJam,
            String jenisRumput,
            boolean tersediaMalam) {

        super(namaLapangan, lokasi, hargaPerJam);
        this.jenisRumput = jenisRumput;
        this.tersediaMalam = tersediaMalam;
    }

    public String getJenisRumput() {
        return this.jenisRumput;
    }

    public void setJenisRumput(String jenisRumput) {
        if (jenisRumput != null && !jenisRumput.trim().isEmpty()) {
            this.jenisRumput = jenisRumput;
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
            "[FUTSAL]    %-18s | Lokasi: %-15s | Rp%,d/jam | Rumput: %-10s | Malam: %s%n",
            this.getNamaLapangan(),
            this.getLokasi(),
            this.getHargaPerJam(),
            this.jenisRumput,
            this.tersediaMalam ? "Ya" : "Tidak"
        );
    }

    @Override
    public void cekFasilitas() {
        System.out.println(
            "-> Fasilitas: gawang, lampu lapangan, ruang ganti, dan toilet."
        );
    }
}