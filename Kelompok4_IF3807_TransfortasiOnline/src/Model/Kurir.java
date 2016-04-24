/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ACER E1
 */
public class Kurir extends Pesanan {
//    private String idBarang;    
    private int nBarang;
    private String namaPenerima;   
    public Kurir(String asal,String tujuan, int n, String penerima){
        super.harga=15000;        
        this.namaPenerima = penerima;
        this.nBarang = n;
    }
    public Kurir(int n, String penerima){
        super.harga=15000;        
        this.namaPenerima = penerima;
        this.nBarang = n;
    }

    
    public void setNBarang(int nBarang){
        this.nBarang = nBarang;
    }
    
    public int getNBarang(){
        return nBarang;
    }
    
    public void setNamaPenerima(String namaPenerima){
        this.namaPenerima = namaPenerima;
    }
    
    public String getNamaPenerima(){
        return namaPenerima;
    }
    
    
}
