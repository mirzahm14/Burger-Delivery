import java.util.*;

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
                    sc.next(); //clear buffer
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
                        sc.next(); //clear buffer
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
                sc.nextLine(); //clear buffer
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
                    
                }while(location_mismatch==1 || customer_loc >10 || customer_loc<1); // repeat loop until a valid location is entered

            sc.nextLine(); // to clear input buffer
            clearScreen();
            do{
                System.out.print("\n\t\t\t\t\tnama: ");
                name= sc.nextLine();
                if(name.length()==0)  // check whether the input length is 0
                    System.out.print("\n\t\t\t\t\tIsi nama anda kembali!");
            }while(name.length()<1);  // repeat loop until a valid name is entered
            
            do{
                System.out.print("\n\t\t\t\t\tAlamat: ");
                addr= sc.nextLine();
                if(name.length()==0)  // check whether the input length is 0
                    System.out.print("\n\t\t\t\t\tIsi alamat anda kembali!");
            }while(name.length()<1);  // repeat loop until a valid address is entered
        
            accept_customer(name, addr, customer_loc, mobile); // add new customer details in the hashmap
        }

        int more=0;
        // arraylist to store the choice codes of ordered burgers
        ArrayList<Integer> burger_choice= new ArrayList<Integer>();  
        // arraylist to store the sizes of ordered burgers 
        ArrayList<Character> size_choice= new ArrayList<Character>();
        // arraylist to store the quantities of ordered burgers 
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
                    sc.next(); // to clear buffer
                    System.out.print("\n\t\t\t\t\tPilihan salah! Mohon isi kembali!");
                    burger_choice_mismatch=1;
                }
                if(burger_choice_mismatch==0)
                {
                    // check whether burger choice code is within range 1 to 10
                    if(burger_choice_temp < 1 || burger_choice_temp > 10) 
                        System.out.println("\n\t\t\t\t\tMohon isi kembali!");
                }
                
            }while(burger_choice_mismatch==1 || burger_choice_temp < 1 || burger_choice_temp > 10);  // repeat loop until valid burger choice code is entered
            
            burger_choice.add(burger_choice_temp); // add selected burger code to arraylist
            
            char size_choice_temp;
            do{
                System.out.print("\n\t\t\t\t\tPilih ukuran: (S/M/L) ");
                size_choice_temp= sc.next().charAt(0);
                
                // check whether burger is entered correctly
                if(size_choice_temp != 'S' && size_choice_temp != 's' && size_choice_temp != 'M'&& size_choice_temp != 'm' && size_choice_temp != 'L'&& size_choice_temp != 'l')
                    System.out.println("\n\t\t\t\t\tUkuran tidak ada! Pilih kembali. (S/M/L)");
            // repeat loop until a valid size is entered   
            }while(size_choice_temp != 'S' && size_choice_temp != 's' && size_choice_temp != 'M'&& size_choice_temp != 'm' && size_choice_temp != 'L'&& size_choice_temp != 'l');

            size_choice.add(size_choice_temp); // add selected burger size to arraylist

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
                    sc.next(); // to clear buffer
                    System.out.print("\n\t\t\t\t\tJumlah salah! Mohon isi kembali");
                    mismatch_flag=1;
                }
                if(mismatch_flag==0)
                {
                    // check whether at least one quantity is entered
                    if(qty_temp < 1)
                        System.out.println("\n\t\t\t\t\tMinimal memesan 1 burger!");  
                    // check whether entered quantity is less than limit
                    if(qty_temp > 10)
                        System.out.println("\n\t\t\t\t\tMaksimal memesan 10 burger!");  
                }
                
            }while(mismatch_flag==1 || qty_temp < 1 || qty_temp>10);  // repeat the loop if quantity entered is less than 1

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
            int per_km_time= 2;              // delivery time per km
        
            // calculate the shortest distance to customer's location
            double distance= shortest_dist(customer_loc);
            if(distance == 0){
                distance = 0.8;
            }
        
            clearScreen();
        
            int delivery_charge = 7500;
            delivery_charge += distance*per_km_charge;  // calculate delivery charges
            
            double estimated_time=(per_km_time*distance);   // calculate estimated time for delivery
        
            int total_bill = delivery_charge;             // add delivery charges to bill amount
        
            String nm=""; // a string to store ordered burger names
            for(int i=0; i<burger_choice.size(); i++) // iterate through the ordered pizzas list
            {
                // get the corresponding burger object from the burger code
                Burger selected = menu.get(burger_choice.get(i)-1);
        
                // add baking time for the burger to the estimated time
                estimated_time+= selected.time_reqd*qty.get(i);
        
                // add burger cost to the total bill according to size selected
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
               // add the ordered burger name to string 
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
            System.out.println("\t\t\t\t\t              TERIMA KASIH!               ");
            System.out.println("\t\t\t\t\t____________________________________________________");
       
            // ask for confirmation of the order
            System.out.print("\n\n\t\t\t\t\tApakah anda ingin 1. konfirmasi pesanan atau 2. membatalkan pesanan? ");
            int confirmation = sc.nextInt();
        
            if (confirmation==1) // user confirms his order
            {
                System.out.print("\n\n\t\t\t\t\t"+confirm_order_msg+"\n\n"); // print confirmation message
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
        int inf = Integer.MAX_VALUE;
        
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