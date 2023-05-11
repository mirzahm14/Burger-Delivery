package project;

import java.util.ArrayList;
import java.util.HashMap;

class Customer{
    String nama;
    String alamat;
    String nohp;
    int lokasi;

    public Customer(String n, String al, String no, int lo){
        nama = n;
        alamat = al;
        nohp = no;
        lokasi = lo;
    }
}

class Burger{
    String nama;
    int harga;
    int waktu;

    public Burger(String n, int h, int w){
        nama = n;
        harga = h;
        waktu = w;
    }
}

class Toko{
    ArrayList<Burger> menu;
    HashMap<String, Customer> customer_data = new HashMap<>();
    String delivery_location;

    String order_done = "\nTerima kasih!\n";

    public Toko(){
        menu = new ArrayList<Burger>();
        delivery_location = "\n1. Bogor Tengah\n2. Bogor Selatan\n3. Bogor Barat\n4. Bogor Timur\n5. Bogor Utara\n6. Tanah Sareal";
    }

    public void addMenu(String nama, int harga, int waktu){
        Burger new_burger = new Burger(nama, harga, waktu);
        menu.add(new_burger);
    }

    public void addCust(String nama, String alamat, String no, int lo){
        Customer new_cust = new Customer(nama, alamat, no, lo);
        customer_data.put(no, new_cust);
    }

    private boolean cek_no(String no){
        if(no.length()<10 || no.length()>12){
            return false;
        }else{
            for(int i = 0; i<no.length();i++){
                if(no.charAt(i)<48 || no.charAt(i)>57){
                    return false;
                }
            }
        }
        return true;
    }

    public double jarak_terpendek(int lokasi){
        int max = Integer.MAX_VALUE;

        double[][] adjMatrix = {
            
        };
    }
}


public class Main {
    public static void main(String[] args) {
        
    }
}
