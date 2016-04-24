/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DataBase.DataBase;
import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER E1
 */
public class model {
    DataBase connection;
    private String query;
    public model(){
        connection=new DataBase();
        connection.connect();
    }
    public boolean tambahPelanggan(Pelanggan p) {
        // buat query dulu
        query = "INSERT INTO pelanggan(id_pelanggan,nama, email, no_hp,username,password)"
                + " VALUES ('"+p.getIdPelanggan()+"','" + p.getNama()+ "' , '" + p.getEmail()+ "','"+p.getNoHp()+"','"+p.getUsername()+"','"+p.getPassword()+"')";
        // eksekusi setelah itu
        return connection.manipulate(query);
    }
    public boolean tambahDataPerjalananPelanggan(Pelanggan pel,Pesanan p){
        query="insert into data_perjalanan_penumpang(id_pelanggan,asal,tujuan,harga) values('"+pel.getIdPelanggan()+"','"+p.getAsal()+"','"+p.getTujuan()+"',"+p.getHarga()+")";
        return connection.manipulate(query);
    }
    public ResultSet detailPerjalananPelanggan(String idPelanggan){
        query="select * from data_perjalanan_penumpang where id_pelanggan='"+ idPelanggan +"'";
        ResultSet st=connection.getData(query);
        try {
            st.last();
            return st;
        } catch (SQLException ex) {
            Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet loginPelanggan(String username,String password) throws SQLException{                
        query="select * from pelanggan where username='"+username+"' AND password='"+password+"'";
        ResultSet st=connection.getData(query);
                    
        st.last();
        if(st.getRow()==1){
            return st;
        }
        return null;
    }
    
}
