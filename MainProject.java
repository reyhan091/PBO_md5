package tugas_asistensimd5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class MainProject {
    static Scanner in = new Scanner(System.in);
    static Projectperpus bio = new Projectperpus();

    public static void main(String[] args) {
        insertEmailPass();
        menu();
    }

    public static void menu(){
        int pil;
        String npm, password;            
        do {
            System.out.println("1. Login");             
            System.out.println("2. Exit");
            System.out.print("Masukkan Pilihan Anda\t: ");
            pil = in.nextInt();
            in.nextLine();
            System.out.println();
            switch (pil) {
                case 1:
                    System.out.print("Masukkan Email Anda\t: ");
                    npm = in.nextLine();
                    System.out.print("Masukkan Password Anda\t: ");
                    password = in.nextLine();
                    login(npm, password);
            }
        }while(pil!=2);
            System.out.println("<Anda Berhasil Keluar Dari Menu Login>\n");
    }
    
    public static int login(String email, String pass){
        if (bio.getEmail().equals(email) && bio.getPassword().equals(pass)){
        Scanner keyboard = new Scanner (System.in);
        
        System.out.println();
        System.out.println("Akun Yang Anda Inputkan Benar");
        System.out.println("\n<ANDA BERHASIL MASUK MENU PERPUS>");
            
        List<Perpustakaan> c = new ArrayList<Perpustakaan>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;
        do{
            System.out.println("0.EXIT MENU");
            System.out.println("1.MASUKKAN DATA");
            System.out.println("2.TAMPILKAN DATA");
            System.out.println("3.MENCARI DATA");
            System.out.println("4.MENGHAPUS DATA");
            System.out.println("5.UPDATE DATA");
            System.out.print("Masukkan Pilihan : ");
            ch = s.nextInt();
            
            switch(ch){
                case 1:
                    System.out.print("\nMasukkan Nomor Buku : ");
                    int nobook = s.nextInt();
                    System.out.print("Masukkan Judul Buku : ");
                    String jubook = s1.nextLine();
                    System.out.print("Masukkan Jumlah Halaman : ");
                    int halbook = s.nextInt();
                    System.out.println();
                    
                    c.add(new Perpustakaan(nobook, jubook, halbook));
                break;
                case 2:
                    System.out.println("----------------------------");
                    Iterator<Perpustakaan> i = c.iterator();
                    while(i.hasNext()){
                        Perpustakaan e = i.next();
                        System.out.println(e);
                    }
                    System.out.println("----------------------------");
                break;
                case 3:
                    boolean found = false;
                    System.out.print("Masukkan Nomor Buku Yang Akan Dicari : ");
                    int nobuku = s.nextInt();
                    System.out.println("----------------------------");
                    i = c.iterator();
                    while(i.hasNext()){
                        Perpustakaan e = i.next();
                        if(e.getNobuku() == nobuku)
                            System.out.println(e);
                        found = true;
                    }
                    
                    if(!found){
                        System.out.println("Buku Tidak Ditemukan");
                    }
                    System.out.println("----------------------------");
                break;
                case 4:
                    found = false;
                    System.out.print("Masukkan Nomor Buku Yang Akan Dihapus : ");
                    nobuku = s.nextInt();
                    System.out.println("----------------------------");
                    i = c.iterator();
                    while(i.hasNext()){
                        Perpustakaan e = i.next();
                        if(e.getNobuku() == nobuku) {
                            i.remove();
                            found = true;
                        }
                    }
                    
                    if(!found) {
                        System.out.println("Buku Tidak Ditemukan");
                    }else{
                        System.out.println("Berhasil Menghapus Data Buku");
                    }
                    System.out.println("----------------------------");
                break;
                case 5:
                    found = false;
                    System.out.print("Masukkan Nomor Buku Yang Akan Diupdate : ");
                    nobuku = s.nextInt();
                    ListIterator<Perpustakaan> li = c.listIterator();
                    while(li.hasNext()){
                        Perpustakaan e = li.next();
                        if(e.getNobuku() == nobuku){
                            System.out.print("Masukkan Judul baru : ");
                            jubook = s1.nextLine();
                            
                            System.out.print("Masukkan Jumlah Halaman : ");
                            halbook = s.nextInt();
                            li.set(new Perpustakaan(nobuku, jubook, halbook));
                            found = true;
                        }
                    }
                    System.out.println("----------------------------");
                    if(!found) {
                        System.out.println("Data Buku Tidak DItemukan");
                    }else{
                        System.out.println("Berhasil Mengupdate Data Buku");
                    }
                    System.out.println("----------------------------");
            }
        }while(ch!=0);
            System.out.println("\n<Terimakasih Telah Menggunakan Menu Perpus>\n");
    }   else{
            System.out.println();
            System.out.println("Akun Yang Anda Inputkan Salah\n");
            System.out.println("<<<<<Silahkan Dicoba Kembali>>>>>\n");
        }
        return 0;
    }

    static int insertEmailPass() {
        String email = "reyhan@gmail.com";
        String pass = "07419";

         bio = new Projectperpus(email, pass);
         return 0;
    }
}