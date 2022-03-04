
/**
 * @Author Zhanglinag Ma
 * 
 * This program is a demo of a fan implementation
 * 
 * the fan has 2 keys: 
 *      key1 : increases the speed each time it is pulled
 *             reset the speed to zero if pulled on max speed  
 *      key2 : reverse the direction of the fan 
 * 
 * Press 1 or 2 of the number key to choose the switch, 
 *      other inputs will terminate the program
 */

import java.util.Scanner;

class Fan {

    /**
     * speed denote:
     * -3 = reverse high
     * -2 = reverse medium
     * -1 = reverse low
     * 0 = stop
     * 1 = low
     * 2 = medium
     * 3 = high
     */
    private int speed;
    private boolean reverse;

    /**
     * Constructor
     * 
     * @param None
     */
    public Fan() {
        this.speed = 0;
        reverse = false;
    }

    /**
     * Pulling Switch 1, change the speed of the fan
     * if the speed reaches maximum, reset to stop
     * 
     * @param None
     */
    public void PullSwitch1() {
        if (!reverse) {
            assert (speed >= 0);
            if (this.speed == 3)
                this.speed = 0;
            else
                this.speed += 1;
        } else {
            assert (speed <= 0);
            if (this.speed == -3)
                this.speed = 0;
            else
                this.speed -= 1;
        }
    }

    /**
     * Pulling Switch 2: reverse the current speed
     * 
     * @param None
     */
    public void PullSwitch2() {
        reverse = !reverse;
        this.speed *= -1;
    }

    /**
     * returns the current state of the fan
     * 
     * @param None
     * @return String indicating Speed
     */
    public String getSpeed() {
        switch (this.speed) {
            case -3:
                return "REVERSE_HIGH";
            case -2:
                return "REVERSE_MEDIUM";
            case -1:
                return "REVERSE_LOW";
            case 1:
                return "LOW";
            case 2:
                return "MEDIUM";
            case 3:
                return "HIGH";
            default:
                return "STOP";
        }
    }

    /**
     * returns the current spining direction of the fan
     * 
     * @param None
     * @return Speed indicating Direction
     */
    public String getDirection() {
        if (!reverse)
            return "Forward";
        return "Backward";
    }
}

public class CeilingFan {
    public static void main(String[] args) {
        Fan fan = new Fan();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Which switch to pull? (1 => Increase Speed; 2 => Reverse Direction; other => Quit) ");
            String input = scanner.next();

            int switchNumber;
            // error checking: if it is not an integer, then quit
            try {
                switchNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("    Illegal switch: " + input);
                break;
            }

            // switching modes
            if (switchNumber == 1) {
                // increase speed
                pullSwitch_1_DisplayInfo(fan);
            } else if (switchNumber == 2) {
                // reverse direction
                pullSwitch_2_DisplayInfo(fan);
            } else {
                // if it is not an integer, then quit
                System.out.println("    Illegal switch number: " + input);
                break;
            }

            System.out.println();
        }

        System.out.println("Done.\n");
        scanner.close();
    }

    /**
     * pull the switch 1 and print the information
     * 
     * @param Fan
     */
    public static void pullSwitch_1_DisplayInfo(Fan fan) {
        System.out.println("    Previous speed of the fan: " + fan.getSpeed());
        System.out.println("    Previous direction of the fan: " + fan.getDirection());
        fan.PullSwitch1();
        System.out.println("    ==>");
        System.out.println("    Current speed of the fan: " + fan.getSpeed());
        System.out.println("    Current direction of the fan: " + fan.getDirection());
    }

    /**
     * pull the switch 2 and print the information
     * 
     * @param Fan
     */
    public static void pullSwitch_2_DisplayInfo(Fan fan) {
        System.out.println("    Previous speed of the fan: " + fan.getSpeed());
        System.out.println("    Previous direction of the fan: " + fan.getDirection());
        fan.PullSwitch2();
        System.out.println("    ==>");
        System.out.println("    Current speed of the fan: " + fan.getSpeed());
        System.out.println("    Current direction of the fan: " + fan.getDirection());
    }
}
