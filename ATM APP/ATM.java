import java.util.*;

class ATM {
  private static Scanner sc;
  
  static int balance = 0;
  static int denominations[] = { 100, 200, 500, 2000 };
  static int adminlocker[] = { 0, 0, 0, 0 };
  static int userinput;
  static int bal;
  static int n = 0;
  static int total;
  static int rem;
  static int trans;
  static int pin;
  static int n1 = 0; 
  static int i = 0;
  static int count = 0;
  static int tot = 0;
  static int attempt = 0;
  static int ar[] = new int[10];
  static String name[] = { "Gokul", "Aravind", "Mani", "Deepak" };
  static int pass[] = { 1234, 2345, 3456, 4567};

  // homepage
  static void Homepage() {
    int n = 0;
    System.out.println("\033[H\033[2J");
    System.out.println("Welcome to ATM");
    System.out.println();
    System.out.println("1. Admin Login");
    System.out.println("2. User Login");
    System.out.println("3. Exit");
    System.out.print("\n"+"Enter your choice : ");
    n = sc.nextInt();

    switch (n) {
      case 1:
        System.out.println("\033[H\033[2J");
        adminlogin();
        break;

      case 2:
        System.out.println("\033[H\033[2J");
        userlogin();
        break;

      case 3:
        System.exit(0);
        break;

      default:
        System.out.println("Invalid");
        break;
    }
  }

  // Adminlogin
  static void adminlogin(){
    System.out.println("-----Welcome to User Admin console-----");
        System.out.print("\n"+"Enter your Login id : ");
        String login = sc.next();
        System.out.print("Enter your Password : ");
        int pass = sc.nextInt();
        if (login.equals("admin") && pass == 12345) {
          System.out.println("\n"+"Logged in successfully..!");
          System.out.println("\n"+"Press Enter to continue...");
          sc.nextLine();
          String s = sc.nextLine();
          if (s .equals("")) {
            System.out.println("\033[H\033[2J");
            Adminpage();
          }
        } else {
        attempt++;
        if(attempt != 3){
          System.out.println("\n"+"Invalid Admin name or password... Please try again...");
          sc.nextLine();
          String s = sc.nextLine();
          if (s .equals("")) {
            System.out.println("\033[H\033[2J");
            Homepage();
          }
        }
        else{
          System.out.println("\n"+"Attempt limit exceeded... Try again later...!");
          sc.nextLine();
          String s = sc.nextLine();
          if (s .equals("")) {
            System.exit(0);
          }
        }
      }
  }

  // Adminpage
  static void Adminpage() {
    System.out.println("\033[H\033[2J");
    int login = 0;
    System.out.println(".....Welcome Admin.....");
    System.out.println("\n"+"1. Load amount");
    System.out.println("2. Show amount");
    System.out.println("3. Back");
    System.out.println("4. Exit");
    System.out.print("\n"+"Enter your choice : ");
    login = sc.nextInt();

    switch (login) {
      case 1:
        addAmount();
        System.out.println("\033[H\033[2J");
        break;
      case 2:
        System.out.println("\033[h\033[2J");
        showAmount();
        break;
      case 3:
        System.out.println("\033[H\033[2J");
        Homepage();
        break;
      case 4:
        System.out.println("\033[H\033[2J");
        System.exit(0);
        break;
    }

  }

  //User login
  static void userlogin() {
    System.out.println("\033[H\033[2J");
    System.out.println("-----Welcome to User login console-----");
    System.out.print("\n"+"Enter your Name : ");
    String input = sc.next();
    System.out.print("Enter your PIN : ");
    pin = sc.nextInt();
    if (pin == pass[0] && input.equals(name[0])) {
      bal = 10000;
      usermodule(0);
    } else if (pin == pass[1] && input.equals(name[1])) {
      bal = 25000;
      usermodule(1);
    } else if (pin == pass[2] && input.equals(name[2])) {
      bal = 32000;
      usermodule(2);
    } else if (pin == pass[3] && input.equals(name[3])) {
      bal = 18000;
      usermodule(3);
    } else {
      attempt++;
        if(attempt != 3){
        System.out.println("\n"+"Invalid Admin name or password... Please try again...");
        sc.nextLine();
        String s = sc.nextLine();
        if (s .equals("")) {
          System.out.println("\033[H\033[2J");
          Homepage();
        }
      }
      else{
      System.out.println("\n"+"Attempt limit exceeded... Try again later...!");
      sc.nextLine();
        String st = sc.nextLine();
        if (st .equals("")) {
        System.exit(0);
      }
    }
  }
}

  // usermodule
  static void usermodule(int i) {
    
    System.out.println("\033[H\033[2J");
    System.out.println("-----Welcome "+name[i]+"-----");
    System.out.println("\n"+"1. Deposit Amount");
    System.out.println("2. Withdraw Amount");
    System.out.println("3. Show balance");
    System.out.println("4. Money Transfer");
    System.out.println("5. PIN Change");
    System.out.println("6. Mini Statement");
    System.out.println("7. Back");
    System.out.println("8. Exit");
    System.out.print("\n"+"Enter your choice : ");   
do{
    n1 = sc.nextInt();
    switch (n1) {
      case 1:
        deposit(i);
        break;
      case 2:
        withdraw(i);
        break;
      case 3:
        showBalance(i);
        break;
      case 4:
        moneyTransaction(i);
        break;
      case 5:
        changePin(i);
        break;
      case 6:
        ministatement(i);
        break;
      case 7:
        System.out.println("\033[H\033[2J");
        Homepage();
      case 8:
        System.exit(0);
        break;
    }
  }
  while(n1<=8);
}

  // change pin
  static void changePin(int i) {
    System.out.println("\033[H\033[2J");
    System.out.print("Enter old password : ");
    int password = sc.nextInt();
    if (pass[i] == password) {
      System.out.print("Enter New Password : ");
      int newpass = sc.nextInt();
      System.out.print("Confirm New Password : ");
      int newpass1 = sc.nextInt();
      if(pass[i] == newpass1){
        System.out.println("\n"+"Old & New passwords are same... Please try with a different New password...!");
        System.out.println("\n"+"Press Enter to continue...");
        sc.nextLine();
        String s0 = sc.nextLine();
        if (s0.equals("")) {
        usermodule(i);
        }
      }
      else{
        pass[i] = newpass1;
        System.out.println("\n"+"PIN changed successfully..!");
        System.out.println("\n"+"Press Enter to continue...");
        sc.nextLine();
        String s1 = sc.nextLine();
        if (s1.equals("")) {
        usermodule(i);
        }
      }
    } 
  }

  // addAmount
  static void addAmount() {
    System.out.println("\033[H\033[2J");
    System.out.println("Enter cash counts :");
    for (int i = 0; i < 4; i++) {
      System.out.print(denominations[i] + " = ");
      adminlocker[i] += sc.nextInt();  
      total += adminlocker[i] * denominations[i];
    }
    System.out.println("\n"+"Amount added successfully..!");
    System.out.println("\n"+"Press Enter to continue...");
    sc.nextLine();
    String s1 = sc.nextLine();
    if (s1.equals("")) {
      Adminpage();
    }
  }

  // showAmount
  static void showAmount() {
    System.out.println("\033[H\033[2J");
    for (int i = 0; i < 4; i++) {
    System.out.println( denominations[i] + " --> " + adminlocker[i]);
    }
    System.out.println("\n"+"Total amount available in ATM : "+total);
    System.out.println("\n"+"Press Enter to go back...");
    sc.nextLine();
    String s2 = sc.nextLine();
    if (s2.equals("")) {
      Adminpage();
    }

  }

  // remainder
  static void remainder(int userinput) {
    System.out.println("\033[H\033[2J");

    if (userinput % 100 == 0) {
      rem = userinput / 2000;
      userinput = userinput % 2000;
      System.out.println("2000 " + rem);
      adminlocker[3] -= rem;
      rem = userinput / 500;
      System.out.println("500 " + rem);
      adminlocker[2] -= rem;
      userinput = userinput % 500;
      rem = userinput / 200;
      System.out.println("200 " + rem);
      adminlocker[1] -= rem;
      rem = userinput / 100;
      System.out.println("100 " + rem);
      userinput = userinput % 100;
      adminlocker[0] -= rem;
    } else {
      System.out.println("Invalid input");
    }
  }

  // Deposit
  static void deposit(int i){
    System.out.println("\033[H\033[2J");
    System.out.println("Enter cash counts :");
    for (i = 0; i < 4; i++) {
      System.out.print(denominations[i] + " = ");
      adminlocker[i] += sc.nextInt();  
      bal += adminlocker[i] * denominations[i];
      total += adminlocker[i] * denominations[i];
    }
    System.out.println("\n"+"Amount deposited successfully..!");
    System.out.println("\n"+"Thankyou for visiting our ATM...");
    sc.nextLine();
    String s5 = sc.nextLine();
    if (s5.equals("")) {
    Homepage();   
  }
}

  // withdraw
  static void withdraw(int i) {
    System.out.println("\033[H\033[2J");
    System.out.println("Withdrawal amount : ");
    moneyTransaction(userinput);
    userinput = sc.nextInt();
    if (total == 0) {
      System.out.println("\n"+"Insufficient balance...!");
      System.out.println("\n"+"Press enter to go back...");
      sc.nextLine();
      String s3 = sc.nextLine();
      if (s3.equals("")) {
        usermodule(i);
      }
    } else if (total >= userinput) {
      ifcondition(i);
    } else {
      System.out.println("Amount Exceeded..!");
      System.out.println("\n"+"Press enter to go back...");
      sc.nextLine();
      String s4 = sc.nextLine();
      if (s4.equals("")) {
        usermodule(i);
      }
    }
  }

  // withdrawal ifcondition
  static void ifcondition(int i) {

    if (userinput % 100 == 0) {
      bal -= userinput;
      total -= userinput;
      System.out.println("\n"+"Please collect your cash...!");
      System.out.println("\n"+"Press enter to go back...");
      sc.nextLine();
      String back = sc.nextLine();
      if (back.equals("")) {
        usermodule(i);
      }
    } else {
      System.out.println("Invalid amount");
    }

  }

  // showbalance
  static void showBalance(int i) {
    System.out.println("\033[H\033[2J");
    System.out.println("Your current balance is : " + bal);
    System.out.println("\n"+"Press enter to go back...");
    sc.nextLine();
    String back = sc.nextLine();
    if (back.equals("")) {
      usermodule(i);
    }
  }

  // moneytransaction
  static void moneyTransaction(int n) {
    
  }

  // ministatement
  static void ministatement(int i) {
    
  }

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    Homepage();
  }
}