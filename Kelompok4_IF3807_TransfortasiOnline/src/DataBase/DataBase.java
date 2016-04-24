/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Model.Kurir;
import Model.Pesanan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER E1
 */
public class DataBase {
    private Connection con;
    private Statement stmt;
    
    public void connect() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
//          con = DriverManager.getConnection("jdbc:mysql://10.5.15.215/responsi_terakhir", "praktikum", "jurnal");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tubes_pbo", "root", "");
            stmt = con.createStatement(); // untuk statementnya caranya harus diinstansiasi
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean manipulate(String q) {
         // jumlah row yang berubah (terupdate)
        boolean berhasil=false;
        try {
            stmt.executeUpdate(q); // jumlah row yang berubah (terupdate)
            berhasil=true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
//        if(x>=1){ // menandakan ada data yang terupdate
//            return true;
//        }
//        return false;

        return berhasil;
    }

    // tujuan method dari method dibawah adalah mengambil data

    public ResultSet getData(String q) { // tipe data dari database namanya ResultSet
        try {
            ResultSet st=stmt.executeQuery(q);
            return st; // untuk mengexecute query
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void tambahDataPerjalananBarang(Pesanan pesanan, Kurir kurir) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object cekLoginPengemudi(String username, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Kurir getDataPerjalananBarang(String idPesanan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
