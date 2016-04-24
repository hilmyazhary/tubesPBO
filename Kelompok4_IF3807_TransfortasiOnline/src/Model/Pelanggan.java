/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Orang;
import java.util.ArrayList;

/**
 *
 * @author ACER E1
 */
public class Pelanggan extends Orang {
    private String idPelanggan;
    private static int autoinc; 
    private String username;
    private String password;
    private int nPesanan=-1;
    private ArrayList<Pesanan> daftarpesanan = new ArrayList<>();
    
    
    public Pelanggan(String nama, String tglLahir, String email, String noHp, String user, String pass) {
        super.setNama(nama);
        super.setTglLahir(tglLahir);
        super.setEmail(email);
        super.setNoHp(noHp);
        this.username = user;
        this.password = pass;
        this.idPelanggan = Integer.toString(autoinc);
        this.autoinc++;
        
    }
    public Pelanggan(String nama,String email, String noHp, String user, String pass){
        super.setNama(nama);        
        super.setEmail(email);
        super.setNoHp(noHp);
        this.username = user;
        this.password = pass;
        this.idPelanggan = Integer.toString(autoinc);
        this.autoinc++;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public ArrayList<Pesanan> getDaftarpesanan(){
        return daftarpesanan;
    }
    public Pesanan getPesanan(int n){
        return daftarpesanan.get(n);
    }
    public void createPesanan(String asal, String tujuan){
        daftarpesanan.add(new Pesanan(asal,tujuan));
    }
    public void createPesanan(String asal,String tujuan,int n,String penerima){
        daftarpesanan.add(new Pesanan(asal,tujuan,n,penerima));
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }
    
    public String getUsername() {
        return username;
    }   
    public String getPassword() {
        return password;
    }

}
