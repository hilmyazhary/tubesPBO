/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
import java.util.*;
import Model.*;
import DataBase.DataBase;
/**
 *
 * @author Giga
 */
public class DBCommand {

    DataBase con;
    private String query;
    
    public DBCommand(){
        con = new DataBase();
        con.connect();
    }
    
    public ResultSet cekLoginPengemudi(String username, String password) throws SQLException{
        query = "SELECT * FROM pengemudi WHERE username='" + username + "' AND password='" + password + "'"; 
        ResultSet rs = con.getData(query);
        rs.last();
        if(rs.getRow()==1){
            return rs;
        } 
        return null;
    } 

    public boolean tambahDataPerjalananBarang(Pesanan p, Kurir k){
        query = "INSERT INTO data_barang(id_pesanan, asal, tujuan, nbarang, penerima, harga) VALUES('" + p.getIdPesanan() + "','" +p.getAsal() + "','" + p.getTujuan() + "','" + 
                        "','" + k.getNBarang() + "','" + k.getNamaPenerima() + "','" + k.getHarga() + "')";
        return con.manipulate(query);
    }
    
    public Kurir getDataPerjalananBarang(String idPesanan) throws SQLException{
        Kurir k = null;
        String query = "SELECT * FROM data_barang WHERE idPesanan = '" + idPesanan + "'";
        ResultSet rs = con.getData(query);
        while(rs.next()){
            k = new Kurir(k.getAsal(), k.getTujuan(), k.getNBarang(), k.getNamaPenerima());
        }return k;
    }
}
