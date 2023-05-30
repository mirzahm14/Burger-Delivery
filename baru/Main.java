import java.util.*;
class Customer {
    String name;             // menyimpan nama customer
    String address;          // menyimpan adress
    String mobile_no;        // menyimpan nomortelepon
    int location;            // menyimpan int lokasi dari customer

    public Customer(String n, String adr, int loc, String mn) 
    {
        name=n;
        address= adr;
        mobile_no= mn;
        location=loc;
    }
}

class Burger
{
    String name;                    // menyimpan nama menu
    int cost_L, cost_M, cost_S;     // harga tiap ukuran
    int time_reqd;                  // waktu yang dibutuhkan 

    public Burger(String n, int cl, int cm, int cs, int t)   
    {
        name=n;
        cost_L=cl;
        cost_S= cs;
        cost_M= cm;
        time_reqd=t;
    }
}
class BurgerQueen {
    ArrayList<Burger> menu;         // Arraylist berisi menu

    // Untuk memasukkan customer
    HashMap<String, Customer> customer_data = new HashMap<>();

    String delivery_locations;   // berisi alamat alamat kecamatan

    // pesan selesai
    String confirm_order_msg= String.join("\n\t\t\t\t\t",
                               "Terima kasih!",
                               "Burgermu sedang dalam perjalanan!");

    public BurgerQueen()      // constructor
    {
        menu= new ArrayList<Burger>();
        delivery_locations= "\n\t\t\t\t\t1. Bogor Barat\n\t\t\t\t\t2. Bogor Selatan\n\t\t\t\t\t3. Bogor Timur\n\t\t\t\t\t4. Bogor Utara\n\t\t\t\t\t5. Bogor Tengah\n\t\t\t\t\t6. Tanah Sareal";
    }         
    
    public void accept_customer(String name, String addr, int location, String mobile)
    {
        //buat data cust
        Customer new_customer= new Customer(name, addr,location, mobile);
        customer_data.put(mobile,new_customer); //tambah ke hashmap
    }

    public void accept_menu(String name, int cl, int cm, int cs, int time)
    {
        //buat menu            
        Burger new_burger = new Burger(name, cl,cm,cs,time);
        menu.add(new_burger); //tambah ke array list
    }

    public void clearScreen() //untuk membersihkan terminal
    {   
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
    }

    public void display_menu(){ // munculin menu
        System.out.println("\t\t\t\t\t __________________________________________________________________________________");
	    System.out.println("\t\t\t\t\t|                                                                                  |");
	    System.out.println("\t\t\t\t\t|\t\t\t\t  BURGER QUEEN MENU                                |");
	    System.out.println("\t\t\t\t\t|                                                                                  |");
	    System.out.println("\t\t\t\t\t|__________________________________________________________________________________|");
	    System.out.println("\t\t\t\t\t|                                                                                  |");
	    System.out.println("\t\t\t\t\t|  NO. \tNAMES\t\t\t\t\t\tPRICES        \t\t   |");
	    System.out.println("\t\t\t\t\t|__________________________________________________________________________________|");
	    System.out.println("\t\t\t\t\t|                                                                                  |");
	    System.out.println("\t\t\t\t\t|    \t\t\t\t\t  SMALL \t  MEDIUM \t   LARGE   |");
	    System.out.println("\t\t\t\t\t|                                                                                  |");
	    System.out.println("\t\t\t\t\t|  1. Cheese Whopper\t\t\t Rp30.000 \t Rp50.000   \t Rp70.000  |");
	    System.out.println("\t\t\t\t\t|  2. BBQ Beef Rasher\t\t\t Rp40.000 \t Rp55.000   \t Rp82.500  |");
	    System.out.println("\t\t\t\t\t|  3. BBQ Beef Rasher Supreme\t\t Rp45.000 \t Rp70.000   \t Rp90.000  |");
	    System.out.println("\t\t\t\t\t|  4. Mozzarella Beef Burger\t\t Rp30.000 \t Rp45.000   \t Rp60.000  |");
	    System.out.println("\t\t\t\t\t|  5. Chicken Royal Burger\t\t Rp35.000 \t Rp50.000   \t Rp65.000  |");
	    System.out.println("\t\t\t\t\t|  6. Double Cheese Burger\t\t Rp30.000 \t Rp50.000   \t Rp70.000  |");
	    System.out.println("\t\t\t\t\t|  7. Tropical Whopper\t\t\t Rp30.000 \t Rp40.000   \t Rp57.000  |");
	    System.out.println("\t\t\t\t\t|  8. BBQ Angus Burger\t\t\t Rp50.000 \t Rp70.000   \t Rp90.000  |");
	    System.out.println("\t\t\t\t\t|  9. Cheese Lava Angus Burger\t\t Rp45.000 \t Rp65.000   \t Rp80.000  |");
	    System.out.println("\t\t\t\t\t| 10. Double Spicy Beef Burger\t\t Rp45.000 \t Rp55.000   \t Rp65.000  |");
	    System.out.println("\t\t\t\t\t|__________________________________________________________________________________|");

    }

    private boolean validate_mobile(String mobile_no) //cek nomor yang dimasukkan sesuai/tidak
    {
        if(mobile_no.length()<11)
            return false;
        else
        {
            for(int i=0; i<mobile_no.length();i++)
            {
                if (mobile_no.charAt(i)<48 || mobile_no.charAt(i)>57)//cek angka semua atau tidak
                    return false;
            }
        }
        return true;    
    }

    public void take_order() 
    {
        Scanner sc= new Scanner(System.in);
        
        int customer_loc=0;
        String name, addr,mobile;     

        do{
        System.out.print("\n\t\t\t\t\tMasukkan Nomor Handphone : ");
        mobile = sc.next();
        if(!validate_mobile(mobile))
            System.out.println("\n\t\t\t\t\tMasukkan nomor yang benar! ");
        }while(validate_mobile(mobile)==false);
        

        if(customer_data.containsKey(mobile))          
        {
            Customer cust = customer_data.get(mobile);  

            name= cust.name;                        
            addr= cust.address;

            System.out.println("\n\t\t\t\t\tNomor "+mobile+" sudah terdaftar!");
            System.out.println("\n\t\t\t\t\tNama: "+name+"\n\t\t\t\t\tAlamat: "+addr);

            int addr_choice=0;
            int choice_mismatch=0;
            do
            {
                choice_mismatch=0;
                try
                {
                    System.out.print("\n\n\t\t\t\t\t1. Antar ke alamat yang terdaftar?   OR    2. Masukkan alamat baru? ");
                    addr_choice= sc.nextInt();
                }
                catch(InputMismatchException e)
                {
                    sc.next(); 
                    System.out.print("\n\t\t\t\t\tPilihan salah!");
                    choice_mismatch=1;
                }
                if(choice_mismatch==0)
                {   if(addr_choice<1 || addr_choice>2)
                    System.out.println("\n\t\t\t\t\tPilihan salah!");
                }
            }while(choice_mismatch==1 || addr_choice<1 || addr_choice>2);
            

            if(addr_choice==1)   
                customer_loc=cust.location;
            else if(addr_choice==2) 
            {   clearScreen();
                System.out.println("\n\t\t\t\t\tSaat ini kami hanya bisa mengantar ke: ");
                System.out.println(delivery_locations);
                int location_mismatch=0;
                do{
                    location_mismatch=0;
                    try
                    {
                        System.out.print("\n\t\t\t\t\tPilih kecamatan tempat tinggalmu: ");
                        customer_loc= sc.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        sc.next(); 
                        System.out.println("\n\t\t\t\t\tPilihan salah!");
                        location_mismatch=1;
                    }
                    if(location_mismatch==0)
                    {
                        if(customer_loc >10 || customer_loc<1)  
                            System.out.println("\n\t\t\t\t\tMohon isi kembali");
                    }
                    
                }while(location_mismatch==1 || customer_loc >10 || customer_loc<1);

                System.out.print("\n\t\t\t\t\tMasukkan alamat anda: "); 
                sc.nextLine(); 
                addr= sc.nextLine();
            } 
            cust.location= customer_loc;
            cust.address= addr;
        }
        else //customer baru
        {   clearScreen();
            System.out.println("\n\t\t\t\t\tSaat ini kami hanya bisa mengantar ke: ");
            System.out.println(delivery_locations);
            int location_mismatch=0;
                do{
                    location_mismatch=0;
                    try
                    {
                        System.out.print("\n\t\t\t\t\tPilih kecamatan tempat tinggalmu: ");
                        customer_loc= sc.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        sc.next(); // clear buffer
                        System.out.print("\n\n\t\t\t\t\tKecamatan salah!");
                        location_mismatch=1;
                    }
                    if(location_mismatch==0)
                    {
                        if(customer_loc >10 || customer_loc<1)  
                            System.out.println("\n\t\t\t\t\tMohon isi kembali");
                    }
                    
                }while(location_mismatch==1 || customer_loc >10 || customer_loc<1); //batas pesanan

            sc.nextLine();
            clearScreen();
            do{
                System.out.print("\n\t\t\t\t\tnama: ");
                name= sc.nextLine();
                if(name.length()==0)  
                    System.out.print("\n\t\t\t\t\tIsi nama anda kembali!");
            }while(name.length()<1);  
            
            do{
                System.out.print("\n\t\t\t\t\tAlamat: ");
                addr= sc.nextLine();
                if(name.length()==0)  
                    System.out.print("\n\t\t\t\t\tIsi alamat anda kembali!");
            }while(name.length()<1); 
        
            accept_customer(name, addr, customer_loc, mobile); //input customer
        }

        int more=0;
        
        ArrayList<Integer> burger_choice= new ArrayList<Integer>();  
        
        ArrayList<Character> size_choice= new ArrayList<Character>();
        
        ArrayList<Integer> quantities= new ArrayList<Integer>();

        do{
            clearScreen();
            display_menu();  // show menu card

            int burger_choice_temp=1;
            int burger_choice_mismatch=0;
            do{
                burger_choice_mismatch=0;
                try
                {
                    System.out.print("\n\t\t\t\t\tPilih burger: ");
                    burger_choice_temp= sc.nextInt();
                }
                catch(InputMismatchException e)
                {
                    sc.next(); 
                    System.out.print("\n\t\t\t\t\tPilihan salah! Mohon isi kembali!");
                    burger_choice_mismatch=1;
                }
                if(burger_choice_mismatch==0)
                {
                    // batas pesanan
                    if(burger_choice_temp < 1 || burger_choice_temp > 10) 
                        System.out.println("\n\t\t\t\t\tMohon isi kembali!");
                }
                
            }while(burger_choice_mismatch==1 || burger_choice_temp < 1 || burger_choice_temp > 10);  
            
            burger_choice.add(burger_choice_temp); 
            
            char size_choice_temp;
            do{
                System.out.print("\n\t\t\t\t\tPilih ukuran: (S/M/L) ");
                size_choice_temp= sc.next().charAt(0);
                
               
                if(size_choice_temp != 'S' && size_choice_temp != 's' && size_choice_temp != 'M'&& size_choice_temp != 'm' && size_choice_temp != 'L'&& size_choice_temp != 'l')
                    System.out.println("\n\t\t\t\t\tUkuran tidak ada! Pilih kembali. (S/M/L)");
             
            }while(size_choice_temp != 'S' && size_choice_temp != 's' && size_choice_temp != 'M'&& size_choice_temp != 'm' && size_choice_temp != 'L'&& size_choice_temp != 'l');

            size_choice.add(size_choice_temp); 
            int qty_temp=1;
            int mismatch_flag=0;
            do{
                mismatch_flag=0;
                try
                {
                    System.out.print("\n\t\t\t\t\tBeli berapa porsi? ");
                    qty_temp= sc.nextInt();
                }
                catch(InputMismatchException e)
                {
                    sc.next(); 
                    System.out.print("\n\t\t\t\t\tJumlah salah! Mohon isi kembali");
                    mismatch_flag=1;
                }
                if(mismatch_flag==0)
                {
                    // cek minimal pemesanan
                    if(qty_temp < 1)
                        System.out.println("\n\t\t\t\t\tMinimal memesan 1 burger!");  
                    // limit pesanan
                    if(qty_temp > 10)
                        System.out.println("\n\t\t\t\t\tMaksimal memesan 10 burger!");  
                }
                
            }while(mismatch_flag==1 || qty_temp < 1 || qty_temp>10);  // pengulangan loop sampai mememenuhi kondisi

            quantities.add(qty_temp); // add selected quantity to arraylist

            // ask user if he wants to order more pizzas
            System.out.print("\n\t\t\t\t\tIngin memesan kembali? (1=yes, 0=no)\n ");
            more= sc.nextInt();
        }while(more!=0);

        print_bill(customer_loc, burger_choice, size_choice, quantities);

    }
    
    void print_bill(int customer_loc, ArrayList<Integer> burger_choice, ArrayList<Character> sizes, ArrayList<Integer> qty)
    {
            Scanner sc= new Scanner(System.in);
        
            int per_km_charge= 1500;          // delivery charge per km
            int per_km_time= 4;              // delivery minute per km
        
            // menghitung jarak terpendek
            double distance= shortest_dist(customer_loc);
            if(distance == 0){
                distance = 0.8;
            }
        
            clearScreen();
        
            int delivery_charge = 7500;
            delivery_charge += distance*per_km_charge;  // menghitung charge
            
            double estimated_time=(per_km_time*distance);   // menghitung estimated time for delivery
        
            int total_bill = delivery_charge;             // add delivery charges to bill amount
        
            String nm=""; // string untuk menyimpan  nama burger
            for(int i=0; i<burger_choice.size(); i++) // iterasi setaip orederan
            {
                //mencek burger yang user input
                Burger selected = menu.get(burger_choice.get(i)-1);
        
                // waktu pesanan sampai
                estimated_time+= selected.time_reqd*qty.get(i);
        
                // ukuran yang dipilih
                switch(sizes.get(i))
              {
                case 's':
                case 'S': total_bill+= selected.cost_S * qty.get(i);
                          break;
                case 'm':          
                case 'M': total_bill+= selected.cost_M * qty.get(i);   
                          break; 
                case 'l':          
                case 'L': total_bill+= selected.cost_L* qty.get(i);
                          break;                 
              }
               // string nama burger
              nm= nm.concat("\n\t\t\t\t\t            "+(i+1)+") "+selected.name+ " (" + qty.get(i) + ")" +"                ");
        
            }

            System.out.println("\t\t\t\t\t____________________________________________________");
            System.out.println("\t\t\t\t\t                                                    ");
            System.out.println("\t\t\t\t\t                  BURGER QUEEN BILL                    ");
            System.out.println("\t\t\t\t\t                                                    ");
            System.out.println("\t\t\t\t\t____________________________________________________");
            System.out.println("\t\t\t\t\t                                                    ");
            System.out.println("\t\t\t\t\t               Burger yang dipesan: "+nm+          "");
            System.out.println("\t\t\t\t\t____________________________________________________");
            System.out.println("\t\t\t\t\t                                                    ");
            System.out.println("\t\t\t\t\t              Jumlah yang dipesan: "+qty+         "");
            System.out.println("\t\t\t\t\t____________________________________________________");
            System.out.println("\t\t\t\t\t                                                    ");
            System.out.println("\t\t\t\t\t              Total jarak = " + distance + " km     ");
            System.out.println("\t\t\t\t\t____________________________________________________");
            System.out.println("\t\t\t\t\t                                                    ");
            System.out.println("\t\t\t\t\t              Biaya ongkir= Rp" + delivery_charge + "");
            System.out.println("\t\t\t\t\t____________________________________________________");
            System.out.println("\t\t\t\t\t                                                    ");
            System.out.println("\t\t\t\t\t              Total harga= Rp" + total_bill  +   "");
            System.out.println("\t\t\t\t\t____________________________________________________");
            System.out.println("\t\t\t\t\t                                                    ");
            System.out.println("\t\t\t\t\t       Estimasi pengantaran pesanan = "+estimated_time+"                                       ");
            System.out.println("\t\t\t\t\t____________________________________________________");
            System.out.println("\t\t\t\t\t                                                    ");
            System.out.println("\t\t\t\t\t                                                    ");
            System.out.println("\t\t\t\t\t              TERIMA KASIH!               ");
            System.out.println("\t\t\t\t\t____________________________________________________");
       
            // konfirmasi
            System.out.print("\n\n\t\t\t\t\tApakah anda ingin 1. konfirmasi pesanan atau 2. membatalkan pesanan? ");
            int confirmation = sc.nextInt();
        
            if (confirmation==1) // confirm
            {
                System.out.print("\n\n\t\t\t\t\t"+confirm_order_msg+"\n\n");
                System.out.print("\n\n\t\t\t\t\t(Tekan 0 untuk kembali ke main menu)");
                sc.nextInt();
            }
            else 
            {
                System.out.println("\n\n\t\t\t\t\tTerima kasih sudah berkunjung! Semoga anda memesan di lain hari:)\n\n");
                System.out.println("\n\n\t\t\t\t\t(Tekan 0 untuk kembali ke main menu) ");
                sc.nextInt();
            }
    }

    double shortest_dist(int customer_loc)
    {
        int inf = Integer.MAX_VALUE; //nilai tak terhingga
        
        //adjacency matriks berfungsi untuk menyimpan jarak antar node 
        double[][] adjMat = {
            {0, 2.9, inf, inf, inf, 3.1}, //1. Bogor Barat - Lokasi Burger
            {2.9, 0, 1.6, inf, inf, inf}, //2. Bogor Selatan
            {inf, 1.6, 0, inf, 3.4, inf}, //3. Bogor Timur
            {inf, inf, inf, 0, 1.8, 1.9}, //4. Bogor Utara
            {inf, inf, 3.4, 1.8, 0, inf}, //5. Bogor Tengah
            {3.1, inf, inf, 1.9, inf, 0}  //6. Tanah Sareal
        };
        
        Dijkstra dijkstrasAlgorithm = new Dijkstra(6);
        dijkstrasAlgorithm.dijkstra_algorithm(adjMat);  
        
        for (int i = 0; i < dijkstrasAlgorithm.distances.length - 1; i++)
        {
            if (i == customer_loc-1)
                return dijkstrasAlgorithm.distances[i];
        }
    return inf;
    }
}
class Dijkstra
{
    double  distances[];                // untuk menyimpan jarak terdekat semua nodes
    private Set<Integer> settled;       // set yang berisi node yang sudah dievaluasi
    private Set<Integer> unsettled;     // set yang berisi node yang belum dievaluasi
    private int  number_of_nodes;       // menyimpan total no nodes
    private double adjacencyMatrix[][];  // untuk adjacency matrix sebagai interpretasi djikstra
    int inf = Integer.MAX_VALUE;

    public Dijkstra(int nodes)  // constructor
    {
        number_of_nodes = nodes;
        distances = new double[number_of_nodes + 1];
        settled = new HashSet<Integer>();   // searching  O(1)
        unsettled = new HashSet<Integer>(); // searching O(1)
        adjacencyMatrix = new double[number_of_nodes + 1][number_of_nodes + 1];
    }
 
    public void dijkstra_algorithm(double adjacency_mat[][])
    {
        int source=0;  // source merupakan letak burgershop
        int evaluationNode;

        for (int i = 0; i <number_of_nodes; i++)
            for (int j = 0; j < number_of_nodes; j++)
                adjacencyMatrix[i][j] = adjacency_mat[i][j];
        
        for (int i = 0; i < number_of_nodes; i++)
        {
            distances[i] = Integer.MAX_VALUE;
        }//inisialisasi djikstra awal dengan memberi tak  hingga pada jarak antar setiap node
        
        //menambah vertext pertama sebagai set unsettled
        unsettled.add(source);
        //membuat jarak 0 pada distance pada node itu sendiri
        distances[source] = 0;
        
        while (!unsettled.isEmpty()) // repeat loop while there are some nodes left for evaluation
        {
            evaluationNode = getNodeWithMinimumDistance();
            // setelah di evaluationnode dibalikkan, lalu pada usettled dilalukan penghapusan pada index yang sudah di evaluasi
            unsettled.remove(evaluationNode); 
            settled.add(evaluationNode);
            //dilakukan update pada settled setelah evaluation node
            calculateNeighbours(evaluationNode);
        }
    }
 
    private int getNodeWithMinimumDistance()
    {
        double min;
        int node = 0;
        
        // iterator untuk unsettled
        Iterator<Integer> iterator = unsettled.iterator();
        node = iterator.next();
        min = distances[0];
        // update distance untuk semua nodes dari node source lalu akan mengembalikan nilai minimum distance dari source
        for (int i = 0; i < distances.length; i++)
        {
            if (unsettled.contains(i))  //cek jika node pada belum dievaluasi atau di cek
            {
                if (distances[i] == min)  
                {
                    min = distances[i];
                    node = i;
                }
            }
        }
        return node;
    }
 
    private void calculateNeighbours(int evaluationNode)
    {
        double edgeDist = -1;
        double newDist = -1;
 
        for (int destinationNode = 0; destinationNode < number_of_nodes; destinationNode++)
        {
            // cek apabila settled node belum dihitung
            if (!settled.contains(destinationNode))  
            {
                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)
                {
                    edgeDist = adjacencyMatrix[evaluationNode][destinationNode];
                    newDist = distances[evaluationNode] + edgeDist;
                    
                    if (newDist < distances[destinationNode])
                    {
                        distances[destinationNode] = newDist;
                    }
                    unsettled.add(destinationNode);
                }
            }
        }
    }
}
public class Main{
    public static void main(String[] args)
    {
        BurgerQueen burger= new BurgerQueen();  
        Scanner sc= new Scanner(System.in);
        int choice=0;
        String art = String.join("\n\t\t\t\t\t", 
        "                                         ______                               _______                         ",
        "(____  )                             (_______)                        ",
        " ____)  )_   _  ____ ____ _____  ____ _    _  _   _ _____ _____ ____  ",
        "|  __  (| | | |/ ___) _  | ___ |/ ___) |  | || | | | ___ | ___ |  _  ) ",
        "| |__)  ) |_| | |  ( (_| | ____| |   | |__| || |_| | ____| ____| | | |",
        "|______/|____/|_|   (___ |_____)_|    (______)____/|_____)_____)_| |_|",
        "                   (_____|                                            "
        );

        // add all the available pizzas to menu
        burger.accept_menu("Cheese Whopper",30000, 50000, 70000, 15);
        burger.accept_menu("BBQ Beef Rasher", 40000, 55000, 82500, 22);
        burger.accept_menu("BBQ Beef Rasher Supreme", 45000, 70000, 90000, 22);
        burger.accept_menu("Mozzarella Beef Burger", 30000, 45000, 60000, 15);
        burger.accept_menu("Chicken Royal Burger", 35000, 50000, 65000, 22);
        burger.accept_menu("Double Cheese Burger", 30000, 50000, 70000, 12);
        burger.accept_menu("Tropical Whopper", 30000, 40000, 57000, 18);
        burger.accept_menu("BBQ Angus Burger", 50000, 70000, 90000, 25);
        burger.accept_menu("Cheese Lava Angus Burger", 45000, 65000, 80000, 25);
        burger.accept_menu("Cheese Lava Angus Burger", 45000, 55000, 65000, 25);

        burger.accept_customer("Mirza", "Jalan Paledang",1, "6281283309013");
        
        int main_choice_mismatch=0;
        do
        {
            burger.clearScreen();
            main_choice_mismatch=0;
            try
            {
                System.out.println(art);
                System.out.print("\n\t\t\t\t\tAda yang bisa kami bantu? \n\t\t\t\t\t1. Pesan\n\t\t\t\t\t2. Lihat menu\n\t\t\t\t\t3. Exit\n\t\t\t\t");
                choice= sc.nextInt();
            }
            catch(InputMismatchException e)  
            {
                sc.next();
                System.out.print("\n\t\t\t\t\tIncorrect choice! Please enter again!");
                main_choice_mismatch=1;
            }

            switch(choice)
            {
                case 1: burger.clearScreen();
                        burger.take_order();
                        break;
                case 2: burger.clearScreen();
                        burger.display_menu();
                        System.out.print("\n\n\t\t\t\t\t(Enter 0 to return to main menu) ");
                        sc.nextInt();
                        break;
                case 3: break;
                default: System.out.println("\n\t\t\t\t\tInvalid choice! Please enter again.");
            }
        }while(main_choice_mismatch==1 || choice!=3);

    }
}