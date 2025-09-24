/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tgsException;

/**
 *
 * @author imadw
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UnknownHostTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // minta input URL dari user
        System.out.print("Masukkan URL (misal: https://www.google.com): ");
        String host = scanner.nextLine();

        try {
            URL url = new URL(host);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();

            // tampilkan response code + artinya
            System.out.println("Response Code: " + responseCode + getMeaning(responseCode));

        } catch (UnknownHostException e) {
            System.out.println( "UnknownHostException: Host tidak ditemukan " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException lain: " + e.getMessage());
        }

        scanner.close();
    }

    // Method helper: arti dari response code
    private static String getMeaning(int code) {
        switch (code) {
            case 200: return " Permintaan berhasil";
            case 301: return " Moved Permanently (Halaman dipindah)";
            case 302: return " Found / Redirect";
            case 400: return " Bad Request (Permintaan salah)";
            case 401: return " Unauthorized (Tidak ada izin)";
            case 403: return " Forbidden (Akses dilarang)";
            case 404: return " Not Found (Halaman tidak ditemukan)";
            case 500: return " Internal Server Error (Kesalahan server)";
            case 503: return " Service Unavailable (Layanan tidak tersedia)";
            default:  return " Kode lain (tidak dikenali secara spesifik)";
        }
    }
}
