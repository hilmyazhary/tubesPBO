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
public class Pengemudi extends Orang {

    private String idPengemudi;
    private static int urutan;
    private String username;
    private String password;
    private String noKendaraan;
    private static ArrayList<Pesanan> daftarpesanan = new ArrayList<Pesanan>();
    
    private int maxPesanan;
    private int nPesanan=-1;

    public Pengemudi(String nama,String tglLahir,String email,String noHp, String user, String pass) {
        super.setNama(nama);
        super.setTglLahir(tglLahir);
        super.setEmail(email);
        super.setNoHp(noHp);
        this.username = user;
        this.password = pass;
        urutan++;
        idPengemudi=Integer.toString(urutan);
    }
    public Pengemudi(String nama,String email,String noHp, String user, String pass) {
        super.setNama(nama);        
        super.setEmail(email);
        super.setNoHp(noHp);
        this.username = user;
        this.password = pass;
        urutan++;
        idPengemudi=Integer.toString(urutan);
    }
    public ArrayList<Pesanan> getDaftarpesanan(){
        return daftarpesanan;
    }
    public void deletePesanan(int i){
        this.daftarpesanan.remove(i);
        
    }
    public Pesanan getPesanan(int i) {
        return daftarpesanan.get(i);
    }

    public void addPesanan(Pesanan pesanan) {
        daftarpesanan.add(pesanan);
    }
    
    public void finishPesanan(int i){
        daftarpesanan.remove(i);
    }

    public String getIdPengemudi() {
        return idPengemudi;
    }

    public void setIdPengemudi(String idPengemudi) {
        this.idPengemudi = idPengemudi;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword(){
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNoKendaraan() {
        return noKendaraan;
    }

    public void setNoKendaraan(String noKendaraan) {
        this.noKendaraan = noKendaraan;
    }
    
    

}
