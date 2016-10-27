package com.example.zombie90.aplikasirestoran;

import static android.R.attr.name;

/**
 * Created by ZOMBIE90 on 10/27/2016.
 */

public class Makanan {

    private String nama_makanan, harga;
    private int gambar_makanan;

    public Makanan() {
    }

    public Makanan(String nama_makanan, int gambar_makanan, String harga) {
        this.nama_makanan = nama_makanan;
        this.gambar_makanan = gambar_makanan;
        this.harga = harga;
    }

    public String getNama_makanan() {
        return nama_makanan;
    }

    public void setNama_makanan(String nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public int getGambar_makanan() {
        return gambar_makanan;
    }

    public void setGambar_makanan(int gambar_makanan) {
        this.gambar_makanan = gambar_makanan;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }


}

