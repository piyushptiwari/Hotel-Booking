import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

class Hotel {

    private static boolean option = true;
    private static boolean option1 = true;
    public static int counter = 0;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Room[] room = new Room[10];
        room[0] = new Room();
        room[1] = new Room();
        room[2] = new Room();
        room[3] = new Room();
        room[4] = new Room();
        room[5] = new Room();
        room[6] = new Room();
        room[7] = new Room();
        room[8] = new Room();
        room[9] = new Room();
        int roomNum = 0;
        initialise(room);
        while (option) {
            while (option1) {
       
             
                System.out.println("Please select one of the options.");
                System.out.println("1: Add a guest.");
               
                System.out.println("2: Add a room.");
                
                System.out.println("3: Add a booking.");
                
                System.out.println("4: View bookings.");
               
                System.out.println("5: exit.");
              
    

                String Selection = input.next();
                
                switch (Selection) {
                    case "1":
                        Add_a_guest();
                        break;
                    case "2":
                        Add_a_room(room,roomNum);
                        break;
                    case "3":
                        Add_a_booking(room,roomNum);
                        break;
                    case "4":
                         System.out.println("View bookings\n1 ) View guest bookings\n2 ) View room bookings");
                         
                          int opt = input.nextInt();
                          if(opt==1){
                       guest_booking(room) ;
                          }
                          if(opt==2){
                        ViewAllRooms(room) ;
                          }

                        break;
                    case "5":
                        System.exit(0);
                        break;

                   
                    default:
                        System.out.println("Invalid Selection");
                        break;
                }
              
                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");
              
                if (input.nextInt() == 1) {
                    option1 = true;
                } else {
                    option1 = false;
                }
            }
            option1 = true;
            
            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");
            
            if (input.nextInt() == 1) {
                option = true;
            } else {
                System.out.println("");
                System.exit(0);

            }
        }

    }

    private static void initialise(Room[] room) {
        for (int x = 0; x < room.length; x++) {
            room[x].setName("Empty");
        }
    }
     private static void Add_a_guest() {
        String guestName;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name of guest :");
        guestName = input.next();
           counter++;
            System.out.println(" guest id is:"+counter);

        
    }



 private static void Add_a_room(Room[] room, int roomNum) {
        System.out.println("Rooms available are:");
         for (int x = 0; x < room.length; x++) {
            if (room[x].getName().equals("Empty")) {
                System.out.println("room " + (x + 1) + " is empty");
            }
        }
        String guestName;
        Scanner input = new Scanner(System.in);
        System.out.println("Select Room number from (1-10):");
        roomNum = input.nextInt() - 1;
        System.out.println("max number of people can stay in this room is : 4");
        System.out.println("Enter name of guest " + (roomNum + 1) + " :");
        guestName = input.next();
        room[roomNum].setName(guestName);
    }

    
 private static void Add_a_booking(Room[] room, int roomNum){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter guest Id: ");
    int idd=input.nextInt();
    if(idd>0 && idd < 11){
        
    }
    else{
        System.out.println("Enter valid guest id. ");
    }
    System.out.println("Enter guest Name: ");
    String name=input.next();
    int count=0;
     for (int x = 0; x < room.length; x++) {
             if(name==room[x].getName()){
                count=1;
             }
        }
    if(count == 0)
       System.out.println(" "); 
    
    System.out.println("Enter Room number: ");
    int rom=input.nextInt();
    if(idd>0 && rom < 11)
    {}
    else
     System.out.println("Room number not valid: "); 

    System.out.println("Enter Number of people with guest: ");
    int maxx=4;
    int romp=input.nextInt();
    if(0<romp && romp<=maxx){
     room[rom].setpeople((romp));
    }
    else
        System.out.println("Number of people with guest exceeds the limit.please book new room. ");
    System.out.println("Enter the checkin date in format 'dd/mm/yy' : ");
    String strDate=input.next();
     SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
        sdfrmt.setLenient(false);
        try
        {
            Date javaDate = sdfrmt.parse(strDate); 
            System.out.println("Room is available on"+strDate);
            room[rom].setidate(strDate);
        }
        catch (ParseException e)
        {
            System.out.println(strDate+" is Invalid Date format");
           
        }
        System.out.println("Enter the checkin date in format 'dd/mm/yy' : ");
        String strDateout=input.next();
     
        sdfrmt.setLenient(false);
        try
        {
             room[rom].setodate(strDateout);
            Date javaDate = sdfrmt.parse(strDate); 
        }
        catch (ParseException e)
        {
            System.out.println(strDate+" is Invalid Date format");
           
        }
 }

   

    private static void ViewAllRooms(Room[] room) {
        for (int x = 0; x < room.length; x++) {
            System.out.println("room " + (x + 1) + " occupied by  " + room[x].getName()+" on check-in " +room[x].getidate() +"check-out date"+room[x].getodate());
        
        if(room[x].getpeople() != "4")
            System.out.println("people staying in room are 4");
        else
            System.out.println("people staying in room are"+room[x].getpeople());}

    }

    private static void guest_booking(Room[] room) {
        Scanner input = new Scanner(System.in);
        String guestName;
        System.out.println("Enter name to Search for:");
        guestName = input.next();
        int x;
        boolean Checker = false;
        for (x = 0; x < room.length; x++) {
            if (guestName.equals(room[x].getName())) {
                System.out.println("The Account That Matches That name is Account number " + x);
                Checker = true;
            }
        }
         System.out.println("room " + (x + 1) + " occupied by  " + room[x].getName()+" on check-in " +room[x].getidate() +"check-out date"+room[x].getodate());

        if (Checker == false) {
            System.out.println("There are no Rooms Booked with that name\n(make sure you've used the correct CAP's)");
        }
    }

    
   

    public static class Room {

     
        private String mainName;
        private String indate;
        private String outdate;
        private int nump;
        int guestsInRoom;

        public Room() {
            mainName = "k";
            indate="01/01/2001";
            outdate="01/01/2001";
            nump=0;

        }

        public void setName(String aName) {
       
            mainName = aName;
        }
         public void setidate(String cind) {
       
            indate = cind;
            

        }
         public void setodate(String cout) {
       
            
            outdate=cout;

        }
         public void setpeople(int peo) {
       
            nump = peo;
        }

        public String getName() {
            return mainName;
        }
        public String getidate() {
            return indate;
        }
        public String getodate() {
            return outdate;
        }
        public String getpeople() {
            return Integer.toString(nump);
        }
    }
}