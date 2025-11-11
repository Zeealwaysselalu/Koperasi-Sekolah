package jdbc.Inheritance;

import jdbc.*;
import java.sql.*;

public class inheritance {

    // Variabel kelas supaya bisa dipakai di semua method
    private Connection conn;
    private Statement state;

    // Method untuk koneksi
    public void connect() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc",
                    "root",
                    ""
            );
            state = conn.createStatement();
            System.out.println("Koneksi Berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal!");
            System.out.println("Alasan: " + e);
        }
    }

    // Method select data
    public void select() {
        try {
                ResultSet rs = state.executeQuery("SELECT * FROM Nama");
                
                while (rs.next()) { // loop semua baris
                    int id = rs.getInt("id");
                    String nama = rs.getString("nama");
                    String kelamin = rs.getString("kelamin");

                    System.out.println("Id       : " + id);
                    System.out.println("Nama     : " + nama);
                    System.out.println("Kelamin  : " + kelamin);
                    System.out.println("-----------------------");
                }

                // Tutup resource
                rs.close();
                state.close();
                conn.close();
        } catch (SQLException e) {
            System.out.println("Query gagal!");
            System.out.println("Alasan: " + e);
        }
    }

    // Method insert data
    public void insert(String nama, String kelamin) {
        try {
                String sql = "INSERT INTO Nama (nama, kelamin) VALUES ('" + nama + "', '" + kelamin + "')";
                int rows = state.executeUpdate(sql);
                System.out.println(rows + " data berhasil ditambahkan.");
        } catch (SQLException e) {
            System.out.println("Insert gagal!");
            System.out.println("Alasan: " + e);
        }
    }
}
