/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Kurir;

/**
 *
 * @author ACER E1
 */
public class Pesanan {
    private String idPesanan;
    protected static int urutan;
    private String tujuan;
    private String asal;   
    protected long harga;
    private boolean diterima=false;
    
    public Pesanan(){
        
    }
    public Pesanan(String asal,String tujuan,int n,String penerima){   
        Kurir kurir=new Kurir(n,penerima);
        urutan++;
        idPesanan=Integer.toString(urutan);  
        this.asal=asal;
        this.tujuan=tujuan;
        
    }
    public String getIdPesanan(){
        return idPesanan;
    }
    public Pesanan(String asal, String tujuan){
        urutan++;
        idPesanan=Integer.toString(urutan);  
        this.asal = asal;
        this.tujuan = tujuan;
        harga=10000;
    }
    
    public boolean konfirmasi(){
        if(diterima==false){
            diterima=true;
            return true;
        }else{
            return false;
        }
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }        

    public long getHarga() {
        return harga;
    }
    
}
