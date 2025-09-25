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
import java.net.Socket;

public class tugas3 {
    public static void main(String[] args) {
        String host = "localhost"; // alamat server
        int port = 12345;          // port server
        String filePath = "data.txt"; // file lokal yang akan diunggah

        // Gunakan try-with-resources untuk menutup resource otomatis
        try (Socket socket = new Socket(host, port);
             FileInputStream fis = new FileInputStream(filePath);
             BufferedInputStream bis = new BufferedInputStream(fis);
             OutputStream os = socket.getOutputStream();
             BufferedOutputStream bos = new BufferedOutputStream(os)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            System.out.println("Mengunggah file: " + filePath);

            // Baca file lalu kirim ke server
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            bos.flush();
            System.out.println("File berhasil diunggah!");

        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan: " + filePath);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan jaringan/I/O: " + e.getMessage());
        }
    }
}
