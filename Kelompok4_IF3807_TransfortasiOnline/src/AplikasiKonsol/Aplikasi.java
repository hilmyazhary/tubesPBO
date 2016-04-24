
package AplikasiKonsol;

import Model.Pesanan;
import Model.Pengemudi;
import Model.Pelanggan;
import java.util.*;

/**
 *
 * @author ACER E1
 */
public class Aplikasi {

    private ArrayList orang = new ArrayList();
    String idPengemudi="";
    String idPelanggan="";
    

    public void addPelanggan(Pelanggan pelanggan) {
        this.orang.add(pelanggan);
    }

    public void addPengemudi(Pengemudi pengemudi) {
        this.orang.add(pengemudi);
    }

    public Pengemudi getPengemudi(String idPengemudi) {
        for (Object i : orang) {
            if (i instanceof Pengemudi) {

                Pengemudi p = (Pengemudi) orang.get(orang.indexOf(i));
                if (p.getIdPengemudi() == idPengemudi) {
                    return p;
                }
            }
        }
        return null;
    }

    public Pelanggan getPelanggan(String idPelanggan) {
        for (Object i : orang) {
            if (i instanceof Pelanggan) {
                Pelanggan p = (Pelanggan) orang.get(orang.indexOf(i));
                if (p.getIdPelanggan() == idPelanggan) {
                    return p;
                }
            }
        }
        return null;
    }

    public void deletePengemudi(String idPengemudi) {
        for (Object i : orang) {
            if (i instanceof Pengemudi) {
                Pengemudi p = (Pengemudi) orang.get(orang.indexOf(i));
                if (p.getIdPengemudi() == idPengemudi) {
                    orang.remove(i);
                }
            }
        }
    }

    public int cekLoginPengemudi(String username, String password) {
        int temp = -1;
        for (Object i : this.orang) {
            if (i instanceof Pengemudi) {
                Pengemudi p = (Pengemudi) this.orang.get(this.orang.indexOf(i));
                if ((p.getUsername().equals(username)) && (p.getPassword().equals(password))) {
                    this.idPengemudi=p.getIdPengemudi();
                    temp = this.orang.indexOf(i);
                    //return temp;
                }
            }
        }
        return temp;
    }

    public boolean loginPengemudi(String username, String password) {

        if (this.cekLoginPengemudi(username, password) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public int cekLoginPelanggan(String username, String password) {
        int temp = -1;
        System.out.println(orang.size());
        for (int i=0; i<orang.size(); i++){
            if(orang.get(i) instanceof Pelanggan){
                System.out.println("cek");
                Pelanggan pelanggan = (Pelanggan) orang.get(i);
                System.out.println(pelanggan.getPassword());
                System.out.println(password);
                System.out.println(username);
                System.out.println(pelanggan.getUsername());
                if((pelanggan.getPassword().equals(password)) && (pelanggan.getUsername().equals(username))){
                    this.idPelanggan=pelanggan.getIdPelanggan();
                    temp = i;
                    System.out.println("wew");
                }
            }
        }
        for (Object i : this.orang) {
            if (i instanceof Pelanggan) {
                System.out.println(this.orang.indexOf(i));
                Pelanggan p = (Pelanggan) this.orang.get(this.orang.indexOf(i));
                if ((p.getUsername().equals(username)) && (p.getPassword().equals(password))) {
                    temp = this.orang.indexOf(i);
                    //return temp;
                }
            }
        }
//        System.out.println(temp);
        return temp;
        
    }

    public boolean loginPelanggan(String username, String password) {

        if (this.cekLoginPelanggan(username, password) == -1) {
            return false;
        } else if(this.cekLoginPelanggan(username, password)!=-1) {
            return true;
        }
        return true;
    }

    public void menuAntarPenumpang(Pelanggan pelanggan, Pengemudi pengemudi, String asal, String tujuan) {
        pelanggan.createPesanan(asal, tujuan);
        Pesanan pes = new Pesanan(asal, tujuan);
        pengemudi.addPesanan(pelanggan.getPesanan(pelanggan.getDaftarpesanan().indexOf(pes)));

    }
//    

    public void menuAntarBarang(Pelanggan pelanggan, Pengemudi pengemudi, String asal, String tujuan, int n, String penerima) {
        pelanggan.createPesanan(asal, tujuan, n, penerima);
        Pesanan pesanan = new Pesanan(asal, tujuan, n, penerima);
        pengemudi.addPesanan(pelanggan.getPesanan(pelanggan.getDaftarpesanan().indexOf(pesanan)));
    }

    public void mainMenu() {
        Scanner s = new Scanner(System.in);
        int plh=0;
        String nama;
        String tglLahir;
        String email;
        String noHp;
        String username;
        String password;
        String asal;
        String tujuan;
        int nBarang;
        String penerima;
        boolean exit = false;
        try{
        while (exit == false) {
            System.out.println("1.User sebagai Pengemudi");
            System.out.println("2.User sebagai Pelanggan");
            System.out.println("3.exit");
            System.out.println("Masukkan menu:  ");
            int pilih = s.nextInt();
            switch (pilih) {
                case 1: {
                    System.out.println("1.Register");
                    System.out.println("2.Login");
                    int pilih2 = s.nextInt();
                    switch (pilih2) {
                        case 1: {
                            System.out.println("Masukkan nama: ");
                            nama = s.next();
                            System.out.println("");
                            System.out.println("Msukkan tanggal lahir: ");
                            tglLahir = s.next();
                            System.out.println("");
                            System.out.println("Masukkan email: ");
                            email = s.next();
                            System.out.println("");
                            System.out.println("Masukkan no Hp: ");
                            noHp = s.next();
                            System.out.println("");
                            System.out.println("Masukkan username: ");
                            username = s.next();
                            System.out.println("");
                            System.out.println("Masukkan password: ");
                            password = s.next();
                            Pengemudi pengemudi = new Pengemudi(nama, tglLahir, email, noHp, username, password);
                            this.addPengemudi(pengemudi);
                            break;
                        }
                        case 2: {
                            System.out.println("Masukkan username: ");
                            username = s.next();
                            System.out.println("");
                            System.out.println("Masukkan password: ");
                            password = s.next();
                            if (this.loginPengemudi(username, password)) {
                                for(int ijk=0;ijk<=this.getPengemudi(this.idPengemudi).getDaftarpesanan().size();ijk++){
                                    System.out.print(ijk+" . ");
                                    System.out.print(this.getPengemudi(this.idPengemudi).getPesanan(ijk).getIdPesanan());
                                    System.out.print(this.getPengemudi(this.idPengemudi).getPesanan(ijk).getAsal());
                                    System.out.println(this.getPengemudi(this.idPengemudi).getPesanan(ijk).getTujuan());
                                }
                                System.out.println("pilih :");
                                plh=s.nextInt();
                                this.getPengemudi(this.idPengemudi).deletePesanan(plh);
                                
                                
                            }
                            break;
                        }

                    }
                    break;
                }
                case 2: {
                    System.out.println("1.Register");
                    System.out.println("2.Login");                    
                    System.out.println("Pilih: ");
                    int pilih2 = s.nextInt();
                    switch (pilih2) {
                        case 1: {
                            System.out.println("Masukkan nama: ");
                            nama = s.next();
                            System.out.println("");
                            System.out.println("Msukkan tanggal lahir: ");
                            tglLahir = s.next();
                            System.out.println("");
                            System.out.println("Masukkan email: ");
                            email = s.next();
                            System.out.println("");
                            System.out.println("Masukkan no Hp: ");
                            noHp = s.next();
                            System.out.println("");
                            System.out.println("Masukkan username: ");
                            username = s.next();
                            System.out.println("");
                            System.out.println("Masukkan password: ");
                            password = s.next();
                            Pelanggan pelanggan = new Pelanggan(nama, tglLahir, email, noHp, username, password);
                            this.addPelanggan(pelanggan);
                            break;
                        }
                        case 2: {
                            System.out.println("Masukkan username: ");
                            username = s.next();
                            System.out.println("");
                            System.out.println("Masukkan password: ");
                            password = s.next();
                            int indexPel = (this.cekLoginPelanggan(username, password));
                            if (indexPel!=-1) {
                                System.out.println("1.Antar Penumpang");
                                System.out.println("2.Antar Barang");
                                System.out.println("pilih jenis layanan: ");
                                pilih2 = s.nextInt();
                                switch (pilih2) {
                                    case 1: {
                                        Pelanggan p = (Pelanggan) this.orang.get(this.cekLoginPelanggan(username, password));
                                        Pengemudi peng = null;
                                        for (Object i : this.orang) {
                                            if (i instanceof Pengemudi) {
                                                peng = (Pengemudi) this.orang.get(this.orang.indexOf(i));
                                            }
                                        }
                                        System.out.println("Masukkan asal: ");
                                        asal = s.next();
                                        System.out.println("");
                                        System.out.println("Masukkan tujuan: ");
                                        tujuan = s.next();
                                        this.menuAntarPenumpang(p, peng, asal, tujuan);
                                        break;
                                    }
                                    case 2: {
                                        Pelanggan p = (Pelanggan) this.orang.get(this.cekLoginPelanggan(username, password));
                                        Pengemudi peng = null;
                                        for (Object i : this.orang) {
                                            if (i instanceof Pengemudi) {
                                                peng = (Pengemudi) this.orang.get(this.orang.indexOf(i));
                                            }
                                        }
                                        System.out.println("Masukkan asal: ");
                                        asal = s.next();
                                        System.out.println("");
                                        System.out.println("Masukkan tujuan: ");
                                        tujuan = s.next();
                                        System.out.println("");
                                        System.out.println("masukkan banyaknya barang: ");
                                        nBarang = s.nextInt();
                                        System.out.println("");
                                        System.out.println("masukkan nama penerima: ");
                                        penerima = s.next();
                                        this.menuAntarBarang(p, peng, asal, tujuan, nBarang, penerima);
                                        break;
                                    }
                                }
                            }else{
                                System.out.println("username atau password salah1");
                            }
                            break;
                        }
                        

                    }
                    break;
                }
                case 3: {
                            exit=true;
                            break;
                          
                        }

            }
        }  
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}
