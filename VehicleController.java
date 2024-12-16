import java.util.*;

interface vehicle {
  void gear_change(int speed);

  int speed_up(int inc);

  int apply_brakes(int dec);

}

class bicycle implements vehicle {
  private int speed = 0;
  private int gear = 0;

  public void gear_change(int speed) {
    if (speed == 0) {
      System.out.println("Bicycle is on neutral gear");
    } else if (speed > 0 && speed <= 10) {
      gear = 1;
      System.out.println("gear changed to:" + gear);
    } else if (speed > 10 && speed <= 20) {
      gear = 2;
      System.out.println("gear changed to:" + gear);
    } else if (speed > 20 && speed <= 30) {
      gear = 3;
      System.out.println("gear changed to:" + gear);
    } else if (speed > 30) {
      gear = 4;
      System.out.println("gear changed to:" + gear);
    }
  }

  public int speed_up(int inc) {
    if ((speed + inc) <= 80) {
      speed += inc;
      System.out.println("bicycle speed increase to:" + speed + "KM/H");
      return speed;
    } else {
      System.out.println("speed limit execeeded");
      return speed;
    }
  }

  public int apply_brakes(int dec) {
    if ((speed - dec) <= 0) {
      speed = 0;
      System.out.println("bicycle is neutral ");
      return 0;
    } else {
      speed -= dec;
      System.out.println("bicycle speed decrease to:" + speed + "KM/H");
    }
    return speed;
  }
}

class bike implements vehicle {
  private int speed = 0;
  private int gear = 0;

  public void gear_change(int speed) {
    if (speed == 0) {
      System.out.println("Bike is on neutral gear");
    } else if (speed > 0 && speed <= 10) {
      gear = 1;
      System.out.println("gear changed to:" + gear);
    } else if (speed > 10 && speed <= 30) {
      gear = 2;
      System.out.println("gear changed to:" + gear);
    } else if (speed > 30 && speed <= 50) {
      gear = 3;
      System.out.println("gear changed to:" + gear);
    } else if (speed > 50) {
      gear = 4;
      System.out.println("gear changed to:" + gear);
    }
  }

  public int speed_up(int inc) {
    if ((speed + inc) <= 120) {
      speed += inc;
      System.out.println("bike speed increase to:" + speed + "KM/H");
      return speed;
    } else {
      System.out.println("speed limit execeeded");
      return speed;
    }
  }

  public int apply_brakes(int dec) {
    if ((speed - dec) <= 0) {
      speed = 0;
      System.out.println("bike is neutral ");
      return 0;
    } else {
      speed -= dec;
      System.out.println("bike speed decrease to:" + speed + "KM/H");
    }
    return speed;
  }
}

class car implements vehicle {
  private int speed = 0;
  private int gear = 0;

  public void gear_change(int speed) {
    if (speed == 0) {
      System.out.println("car is on neutral gear");
    } else if (speed > 0 && speed <= 20) {
      gear = 1;
      System.out.println("gear changed to:" + gear);
    } else if (speed > 20 && speed <= 60) {
      gear = 2;
      System.out.println("gear changed to:" + gear);
    } else if (speed > 60 && speed <= 80) {
      gear = 3;
      System.out.println("gear changed to:" + gear);
    } else if (speed > 80) {
      gear = 4;
      System.out.println("gear changed to:" + gear);
    }
  }

  public int speed_up(int inc) {
    if ((speed + inc) <= 180) {
      speed += inc;
      System.out.println("car speed increase to:" + speed + "KM/H");
      return speed;
    } else {
      System.out.println("speed limit execeeded");
      return speed;
    }
  }

  public int apply_brakes(int dec) {
    if ((speed - dec) <= 0) {
      speed = 0;
      System.out.println("car is neutral ");
      return 0;
    } else {
      speed -= dec;
      System.out.println("car speed decrease to:" + speed + "KM/H");
    }
    return speed;
  }
}

public class VehicleController {
  public void exe(vehicle v) {
    int s, ch;
    String c;
    Scanner scr = new Scanner(System.in);
    do {
      System.out.println("\n1:Increase speed  2:Apply brakes  3:Exit \nEnter your choice:");
      ch = scr.nextInt();
      if (ch == 1) {
        do {
          s = v.speed_up(20);
          v.gear_change(s);
          System.out.println("Do you want to speed up more.'Y' or 'NO'");
          c = scr.next();
        } while (c.equalsIgnoreCase("y"));
      } else if (ch == 2) {
        do {
          s = v.apply_brakes(20);
          v.gear_change(s);
          System.out.println("Do you want to speed down more.'Y' or 'NO'");
          c = scr.next();
        } while (c.equalsIgnoreCase("y"));
      } else if (ch == 3) {
        return;
      }
    } while (ch != 3);
  }

  public static void main(String[] args) {
    int ch;
    VehicleController o = new VehicleController();
    vehicle mybic = new bicycle();
    vehicle mybik = new bike();
    vehicle mycar = new car();
    String choice;
    Scanner scr = new Scanner(System.in);
    do {
      System.out.println("\n1:bicycle  2:bike  3:car  4:Exit  \nenter choice:");
      ch = scr.nextInt();
      switch (ch) {
        case 1:
          o.exe(mybic);
          System.out.println("Do you want to continue.'Y' or 'NO'");
          choice = scr.next();
          break;
        case 2:
          o.exe(mybik);
          System.out.println("Do you want to continue.'Y' or 'NO'");
          choice = scr.next();
          break;
        case 3:
          o.exe(mycar);
          System.out.println("Do you want to continue.'Y' or 'NO'");
          choice = scr.next();
          break;
        case 4:
          System.out.println("Do you want to continue for other.'Y' or 'NO'");
          choice = scr.next();
          break;
        default:
          System.out.println("enter valid choice");
          return;
      }
    } while (choice.equalsIgnoreCase("y"));
  }
}
