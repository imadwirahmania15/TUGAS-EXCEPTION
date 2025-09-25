/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tgsException;

/**
 *
 * @author imadw
 */

import java.io.*;

public class tugas2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line = br.readLine();

            // Validasi isi file
            if (line == null || line.trim().isEmpty()) {
                System.out.println("File kosong atau tidak berisi angka.");
                return;
            }

            int angka;
            try {
                angka = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Isi file bukan angka yang valid.");
                return;
            }

            // Validasi pembagian nol
            if (angka == 0) {
                System.out.println("Tidak bisa membagi dengan nol.");
                return;
            }

            // Jika semua valid
            System.out.println("Hasil: " + (10 / angka));

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }
    }
}
