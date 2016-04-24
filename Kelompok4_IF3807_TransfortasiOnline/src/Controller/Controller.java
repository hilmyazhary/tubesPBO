/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AplikasiKonsol.Aplikasi;
import DataBase.DataBase;
import Model.Pelanggan;
import Model.Pengemudi;
import Views.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER E1
 */
public class Controller implements ActionListener {
    private View view;
    private Aplikasi app;
    private model model;
    private Pelanggan pelanggan;
    private Pesanan pesanan;
    ResultSet resultSet;
    private Kurir kurir;
    private DataBase database;
    

    public Controller (){
        model=new model();
        MenuUser menu=new MenuUser();
        menu.setVisible(true);
        menu.addListener(this);
        view = menu;
    }
    
    public void goToLoginPengemudi(){
        LoginPengemudi login = new LoginPengemudi();
        login.setVisible(true);
        login.addListener(this);
        view = login;
    }
     public void goToDataPerjalananBarang(){
        DataPerjalananBarang dpb = new DataPerjalananBarang();
        dpb.setVisible(true);
        dpb.addListener(this);
        view = dpb;
    }
     public void goToDetailBarang(){
        DetailBarang dpb = new DetailBarang();
        dpb.setVisible(true);
        dpb.addListener(this);
        view = dpb;      
    }
    public void goToDataPerjalananPelanggan(){
        DataPerjalananPelanggan dataPerj = new DataPerjalananPelanggan();
        dataPerj.setVisible(true);
        dataPerj.addListener(this);
        view =  dataPerj;
    }
    public void goToRegistrasiPengeumdi(){
        registrasiPengemudi reg = new registrasiPengemudi();
        reg.setVisible(true);
        reg.addListener(this);
        view = reg;
    }
    public void goToDataLayanan(){
        dataLayanan dl = new dataLayanan();
        dl.setVisible(true);
        dl.addListener(this);
        view = dl;
    }
    public void goToKonfirmasiPesanan(){
        konfirmasiPesanan konf = new konfirmasiPesanan();
        konf.setVisible(true);
        //konf.AddListener(this);
        //view = (View) konf;
    }
    public void goToNotifikasiPesanan(){
        konfirmasiPesanan konf = new konfirmasiPesanan();
        konf.setVisible(true);
        konf.addListener(this);
        view = konf;
    }
    public void goToDetailPelanggan(){
        DetailPelanggan dataPen=new DetailPelanggan();
        dataPen.setVisible(true);
        dataPen.addListener(this);
        view = dataPen;        
    }
    public void goToDataLoginPelanggan(){
        LoginPelanggan dataLogin=new LoginPelanggan();
        dataLogin.setVisible(true);
        dataLogin.addListener(this);
        view=dataLogin;
    }
    public void goToDataRegistrasiPelanggan(){
        RegistrasiPelanggan dataRegistrasi=new RegistrasiPelanggan();
        dataRegistrasi.setVisible(true);
        dataRegistrasi.addListener(this);
        view=dataRegistrasi;
    }
//    public void goToDataLayanan(){
//        DataLayanan dLayanan=new DataLayanan();
//        dLayanan.setVisible(true);
//        dLayanan.addLintener(this);
//        view=dLayanan;
//    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Object a = ae.getSource();
        if(view instanceof LoginPelanggan){
            LoginPelanggan login = (LoginPelanggan) view;
            if(a.equals(login.getLogin())){
                try {
                    if(model.loginPelanggan(login.getUsername(), login.getPassword())!=null){                        
                        resultSet=model.loginPelanggan(login.getUsername(), login.getPassword());
                        pelanggan.setIdPelanggan(resultSet.getString("id_pelanggan"));
                        pelanggan.setNama(resultSet.getString("nama"));
                        pelanggan.setEmail(resultSet.getString("email"));
                        pelanggan.setNoHp(resultSet.getString("no_hp"));
                        pelanggan.setUsername(resultSet.getString("username"));
                        pelanggan.setPassword(resultSet.getString("password"));
                        login.dispose();
//                    this.goToDataLayanan();
                    }
                    else{
                        login.clearField();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            else if(a.equals(login.getRegistrasi())){
                login.dispose();
                this.goToDataRegistrasiPelanggan();
            }
        }
        else if(view instanceof dataLayanan){
            dataLayanan dl = (dataLayanan) view;
            if(a.equals(dl.getBtnPenumpang())){
                dl.dispose();
                this.goToDataPerjalananPelanggan();
            }
            else if(a.equals(dl.getBtnBarang())){
                dl.dispose();
                this.goToDataPerjalananBarang();
            }
            else if(a.equals(dl.getBtnLogout())){
                dl.dispose();
                Controller c = new Controller();
            }
        }
        else if (view instanceof DataPerjalananBarang){
            DataPerjalananBarang dpb = (DataPerjalananBarang) view;
            if(a.equals(dpb.getBtnLanjut())){
                pesanan = new Pesanan(dpb.getTxtAsal(), dpb.getTxtTujuan(), dpb.getSpinJml(), dpb.getTxtPenerima());
                kurir = new Kurir(dpb.getTxtAsal(), dpb.getTxtTujuan(), dpb.getSpinJml(), dpb.getTxtPenerima());
                database.tambahDataPerjalananBarang(pesanan,kurir);
                dpb.dispose();
                this.goToDetailBarang();
            }
            else if(a.equals(dpb.getBtnBatal())){
               dpb.dispose();
               this.goToDataLayanan();
            }
        }
        else if(view instanceof LoginPengemudi){
            LoginPengemudi login = (LoginPengemudi) view;
            if(a.equals(login.getBtnLogin())){  
                if(database.cekLoginPengemudi(login.getUsername(), login.getPass())!=null){
                    login.dispose();
                    this.goToKonfirmasiPesanan();
                }
                else {
                    login.clearField();
                }
            }
            else if(a.equals(login.getBtnRegister())){
                login.dispose();
                this.goToRegistrasiPengeumdi();
            }
        }
        else if (view instanceof DetailBarang){
            DetailBarang db = (DetailBarang) view;
            Kurir k = database.getDataPerjalananBarang(this.pesanan.getIdPesanan());
            db.setLblAsal(k.getAsal());
            db.setLblTujuan(k.getTujuan());
            db.setLblHarga(k.getHarga());
            db.setLblPenerima(k.getNamaPenerima());
            if(a.equals(db.getBtnPesan())){
                db.dispose();
                goToNotifikasiPesanan();
            }
            else if(a.equals(db.getBtnBatal())){
                db.dispose();
                goToDataPerjalananBarang();
            }
        }
        else if (view instanceof DetailPelanggan){
            DetailPelanggan dp = (DetailPelanggan) view;
            
        }
        else if (view instanceof MenuUser){
            MenuUser menu = (MenuUser) view;
            if(a.equals(menu.getBtnLoginPelanggan())){
                menu.dispose();
                goToDataLoginPelanggan();
            }
            else if(a.equals(menu.getBtnLoginPengemudi())){
                menu.dispose();
                goToLoginPengemudi();
            }
        }
        else if (view instanceof RegistrasiPelanggan){
            RegistrasiPelanggan registrasi=(RegistrasiPelanggan) view;
            if(a.equals(registrasi.getSimpan())){
                pelanggan=new Pelanggan(registrasi.getNama(),registrasi.getEmail(),registrasi.getNoHp(),registrasi.getUsername(),registrasi.getPassword());
                if(model.tambahPelanggan(pelanggan)){
                    registrasi.dispose();
                    this.goToDataLoginPelanggan();  
                }else{
                    System.out.println("registrasi gagal");
                }
                             
            }
        }else if(view instanceof DataPerjalananPelanggan){
            DataPerjalananPelanggan dPelanggan=(DataPerjalananPelanggan) view;
            if(a.equals(dPelanggan.getLanjut())){
                pesanan=new Pesanan(dPelanggan.getAsal(),dPelanggan.getTujuan());
                model.tambahDataPerjalananPelanggan(pelanggan,pesanan);
                dPelanggan.dispose();
                this.goToDetailPelanggan();
            }
        }else if(view instanceof DetailPelanggan){
            String tempString="";
            DetailPelanggan dPelanggan=(DetailPelanggan) view;
            if(a.equals(dPelanggan.getOrder())){
                resultSet=model.detailPerjalananPelanggan(pelanggan.getIdPelanggan());                
                
               
                
                try {                      
                    tempString= resultSet.getString("asal");
                    dPelanggan.setAsal(tempString);                     
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                try {                      
                    tempString= resultSet.getString("tujuan");
                    dPelanggan.setTujuan(tempString);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {                      
                    tempString= resultSet.getString("harga");
                    dPelanggan.setHarga(tempString);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                dPelanggan.dispose();
//                this goToNotifikasiPesananPenumpang();
                                                            
            }
        }       
    }
    
}
