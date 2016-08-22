import java.io.*;
import java.util.*;


public class beefyrobot
{
    static int xplace; //variable to save the x placement square
    static int yplace; //variable to save the y placement square
    static String direct;  //variable to save the direction
    
    
    public static void move () //method to run the move command
    {
        //move the robot one unit forward in the direction it is currently facing
        if( direct.equals("NORTH"))
        {
            yplace = yplace + 1;
            if(yplace > 4)  //stop the robot from going off the board
            {
                yplace = 4;
            }
        }
        else if( direct.equals("SOUTH"))
        {
            yplace = yplace -1;
            if(yplace < 0)  //stop the robot from going off the board
            {
                yplace = 0;
            }
        }
        else if( direct.equals("EAST"))
        {
            xplace = xplace + 1;
            if(xplace > 4)  //stop the robot from going off the board
            {
                xplace = 4;
            }
        }
        else if( direct.equals("WEST"))
        {
            xplace = xplace - 1;
            if(xplace < 0)  //stop the robot from going off the board
            {
                xplace = 0;
            }
        }
    }
    
    public static void left()  //Method to run the left command
    {
        //rotate the direction 90 degrees left from the corrent direction
        if( direct.equals("NORTH"))
        {
            direct = "WEST";
        }
        else if( direct.equals("SOUTH"))
        {
            direct = "EAST";
        }
        else if( direct.equals("EAST"))
        {
            direct = "NORTH";
        }
        else if( direct.equals("WEST"))
        {
            direct = "SOUTH";
        }
    }
    
    public static void right ()    //Method to run the right command
    {
            //rotate the direction 90 degrees right from the corrent direction
            if( direct.equals("NORTH"))
            {
                direct = "EAST";
            }
            else if( direct.equals("SOUTH"))
            {
                direct = "WEST";
            }
            else if( direct.equals("EAST"))
            {
                direct = "SOUTH";
            }
            else if( direct.equals("WEST"))
            {
                direct = "NORTH";
            }
    }
        
    public static void report()    //method to run the report command
    {
            //print out the report of the current placement of the robot
            System.out.println(xplace + "," + yplace + "," + direct);
    }
    
    public static void main(String[] args)
    {
        //enable keyboard inputs
        Scanner Keyboard = new Scanner(System.in);
        
        //read inputs until a valid place command is entered
        boolean keeprunning = true;
        while(keeprunning)
        {
            String placement = Keyboard.nextLine();
            //separate the placement string into the different parts
            String[] part = placement.split(" ");
            String s = part[0];
            String p = part[1];
            String [] parts = p.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            String f = parts[2];
            if(!s.equals("PLACE"))
            {
                System.out.println("Please place the robot before calling other commands");
            }
            else
            {
                //save the placement as the global placement variables
                xplace = x;
                yplace = y;
                direct = f;
                keeprunning = false;
            }
        }

        //read inputs until the report command is entered
        boolean keeprunning1 = true;
        while(keeprunning1)
        {
            String input = Keyboard.nextLine();
            if(input.equals("MOVE"))
            {
                move();
            }
            else if(input.equals("LEFT"))
            {
                left();
            }
            else if(input.equals("RIGHT"))
            {
                right();
            }
            else if(input.equals("REPORT"))
            {
                report();
                keeprunning1 = false;
            }
            else
            {
                System.out.println("Invalid Command");
            }
        }
        
    }
}
