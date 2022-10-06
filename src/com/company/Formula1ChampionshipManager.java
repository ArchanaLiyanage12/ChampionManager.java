package com.company;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.*;
import java.io.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;


public class Formula1ChampionshipManager implements ChampionManager {
    static ArrayList<String> raceDate = new ArrayList<>();//create string arraylist for store race dates
    static ArrayList<Formula1Driver> driver = new ArrayList<>();//Declare an empty arraylist to store Formula1Drivers
    static Scanner input = new Scanner(System.in);//create a scanner object from scanner class
    Scanner input1=new Scanner(System.in).useDelimiter("\n");
    static ArrayList<String> teamNameArrayList = new ArrayList<>();


    /**
     * method for add a driver
     */

    @Override
    public void createNewDriver() {
        boolean run = false;
        boolean firstrun = true;//variable for control the first position loop
        boolean secondrun=true;//variable for control the second  position check  loop
        boolean thirdrun=true;//variable for control the third   position check  loop

        String name;
        int first = 0;
        int second=0;
        int third=0;
        int points=0;
        int numOfRaces=0;
        String team;

        do {

            System.out.println("Enter the driver name");
            name = input1.next();//set the use input to name variable

            System.out.println("Enter the location");
            String location = input1.next();// set the user input to location variable

            do {
                System.out.println("Enter the team ");//getting driver team
                team = input1.next().toLowerCase();
                if (teamNameArrayList.contains(team)){//check weather the team is already existing
                    System.out.println("This team  already has a driver select different team  ");
                }
            } while (teamNameArrayList.contains(team));
            teamNameArrayList.add(team);//add new driver in to driver team arraylist

             do {
                 System.out.println("Enter Number of first Positions ");// getting number of first points
                 if (input.hasNextInt())//validate user input
                    first = input.nextInt();//set the user input to first variable
                 else {
                     input.next();
                     System.out.println("invalid Input");
                     continue;
                 }
                 firstrun=false;
             }while (firstrun);


            do {
                System.out.println("Enter Number of Second Positions ");// getting number of second points
                if (input.hasNextInt())//validate user input
                    second = input.nextInt();//set the user input to second variable
                else {
                    input.next();
                    System.out.println("invalid Input");
                    continue;
                }
                secondrun=false;
            }while (secondrun);





            do {
                System.out.println("Enter Number of third Positions ");// getting number of third points
                if (input.hasNextInt())//validate user input
                    third = input.nextInt();//set the user input to second variable
                else {
                    input.next();
                    System.out.println("invalid Input");
                    continue;
                }
                thirdrun=false;
            }while (thirdrun);


                int value = ((first * 25) + (second * 18) + (third * 15));   //get the count of first point and second points and third point to validate the user input with it
                do {
                    System.out.println("Enter the points ");// getting number of  points

                    while(!input.hasNextInt()) {   //validate user input
                        System.out.println("Invalid Input! Try Again.\nEnter the points  ");
                        input.next();
                    }

                    points = input.nextInt();
                    if (points<value) {// check the user input points with pre created
                        System.out.println("Invalid Input! Try Again.");
                    }

                }while (points<value);


            int raceCount = (first+second+third);
            do {
                System.out.println("Enter the Number of races ");// getting number of races

                while(!input.hasNextInt()) {// validate the user input
                    System.out.println("Invalid Input! Try Again.\nEnter The Number of races  ");
                    input.next();
                }

                numOfRaces = input.nextInt();
                if (numOfRaces<raceCount) {// check the user entered
                    System.out.println("Invalid Input! Try Again.");
                }

            }while (numOfRaces<raceCount);



            driver.add(new Formula1Driver(name, location, team, first, second, third, points, raceCount));// add driver objects to the arraylist
            System.out.println("new driver"+" "+"'"+name+"'"+ " "+ "is added to the team"+ " "+"'"+team+"'");
            System.out.println("\n");

            while (true) {//
                System.out.println("---Do You Want To Enter Another Driver Or Do You Want Go Back To The Menu---");

                System.out.println("NO  : Back to menu \n"+       //ask from the use weather do you want to enter another driver
                                   "yes : To enter Another Driver");
                System.out.println("Enter your Option");

                String option = input.next().toUpperCase(Locale.ROOT);
                if (option.equals("NO")) {
                    run = false;
                } else {
                    run = true;
                }
                break;
            }

        }
        while (run);


    }


    /**
     * Delete a driver method
     */
    @Override
    public void DeleteDriver(){

        System.out.println("these are the drivers in the championship ");
        System.out.println();

        String leftAlignFormat = "| %-14s | %-9d | %n";//print a console table
        System.out.format("+----------------+-----------+%n");
        System.out.format("| Name           | Number    |%n");
        System.out.format("+----------------+-----------+%n");
        for (Formula1Driver delete :driver) {//for each loop for iterate through the arraylist and print the existing drivers and there number
            System.out.format(leftAlignFormat,delete.getDrivername(),driver.indexOf(delete)+1);

        }
        System.out.format("+----------------+-----------+%n");


        System.out.println("enter the number of the driver you want to delete");
        int option=input.nextInt();//get the number of the driver that user want to delete
        driver.remove(option-1);//remove the user selected driver from the driver arraylist
        System.out.println("you request is successful"+""+ driver.get(option-1).getDrivername() + " "+"is deleted ..... ");//print the deleted driver name

        System.out.println("these are the drivers  left in the championship ");// console table
        System.out.println();
        String leftAlignFormat1 = "| %-14s | %-9d | %n";
        System.out.format("+----------------+-----------+%n");
        System.out.format("| Name           | Number    | %n");
        System.out.format("+----------------+-----------+%n");
        for (Formula1Driver delete1 :driver) {//for each loop for iterate through the arraylist and print the rest of the  drivers and their numbers
            System.out.format(leftAlignFormat1,delete1.getDrivername(),driver.indexOf(delete1));

        }
        System.out.format("+----------------+-----------+%n");


    }

    /**
     * method for display existing driver statistics
     */
    @Override
    public void DisplayStatistic() {
        System.out.println("these are the drivers in the championship ");

        String leftAlignFormat = "| %-14s | %-9d | %n";
        System.out.format("+----------------+-----------+%n");
        System.out.format("| Name           | index     | %n");
        System.out.format("+----------------+-----------+%n");
        for (Formula1Driver display :driver) {//for each loop for iterate through the driver arraylist and print drivers name and number of the driver
            System.out.format(leftAlignFormat,display.getDrivername(),driver.indexOf(display)+1);

        }
        System.out.format("+----------------+-----------+%n");

        System.out.println("enter the index of the driver you want to see statistics");
        int optionDisplay=input.nextInt();//set use input into the optionDisplay variable

        System.out.println("Driver Name           :"+driver.get(optionDisplay-1).getDrivername());// print the use requested driver statistics
        System.out.println("Location              :"+driver.get(optionDisplay-1).getLocation());
        System.out.println("Team                  :"+driver.get(optionDisplay-1).getTeam());
        System.out.println("First Positions       :"+driver.get(optionDisplay-1).getNumoffirstposition());
        System.out.println("Second Positions      :"+driver.get(optionDisplay-1).getNumofsecondpositions());
        System.out.println("Third Positions       :"+driver.get(optionDisplay-1).getNumofthirdpositions());
        System.out.println("Number Of Points      :"+driver.get(optionDisplay-1).getPoints());
        System.out.println("Number Of Races       :"+driver.get(optionDisplay-1).getRaces());
    }

    /**
     * method for change  driver
     */
      @Override
       public void changeDriverINTeam() {

           String changeDriverTeamName=null;
           int newFirstPositions=0;
           int newSecondPositions=0;
           int newThirdPositions = 0;
           int newPoints;
           int newRaceCount;
           boolean firstRuNew=true; //
           boolean secondRuNnew=true;
           boolean thirdRunNew=true;



               System.out.println("Enter the team which you want to change the driver");//getting  team name
               changeDriverTeamName = input1.next().toLowerCase();
               if (teamNameArrayList.contains(changeDriverTeamName)){//check weather the team is already existing
                   int changeTeamIndex= teamNameArrayList.indexOf(changeDriverTeamName);
                   System.out.println("Enter the driver name");
                  String newDriverName = input1.next();//set the use input to newName variable

                   System.out.println("Enter the location");
                   String newDriverLocation = input1.next();// set the user input to newDriverLocation variable

                   do {
                       System.out.println("Enter Number of first Positions ");// getting number of first points
                       if (input.hasNextInt())//validate user input
                           newFirstPositions = input.nextInt();//set the user input to newFirstPositions variable
                       else {
                           input.next();
                           System.out.println("invalid Input");
                           continue;
                       }
                       firstRuNew=false;
                   }while (firstRuNew);


                   do {
                       System.out.println("Enter Number of Second Positions ");// getting number of second points
                       if (input.hasNextInt())//validate user input
                           newSecondPositions = input.nextInt();//set the user input to  newSecondPositions variable
                       else {
                           input.next();
                           System.out.println("invalid Input");
                           continue;
                       }
                       secondRuNnew=false;
                   }while (secondRuNnew);





                   do {
                       System.out.println("Enter Number of third Positions ");// getting number of third points
                       if (input.hasNextInt())//validate user input
                           newThirdPositions = input.nextInt();//set the user input to  newThirdPositions  variable
                       else {
                           input.next();
                           System.out.println("invalid Input");
                           continue;
                       }
                       thirdRunNew=false;
                   }while (thirdRunNew);


                   int newValue = ((newFirstPositions * 25) + (newSecondPositions * 18) + (newThirdPositions * 15));   //get the count of first point and second points and third point to validate the user input with it
                   do {
                       System.out.println("Enter the points ");// getting number of first points

                       while(!input.hasNextInt()) {   //validate user input
                           System.out.println("Invalid Input! Try Again.\nEnter the points  ");
                           input.next();
                       }

                       newPoints = input.nextInt();
                       if (newPoints<newValue) {// check the user input points with pre created
                           System.out.println("Invalid Input! Try Again.");
                       }

                   }while (newPoints<newValue);


                   int raceCountnew = (newFirstPositions+newSecondPositions+newThirdPositions);
                   do {
                       System.out.println("Enter the Number of races ");// getting number of races

                       while(!input.hasNextInt()) {// validate the user input
                           System.out.println("Invalid Input! Try Again.\nEnter The Number of races  ");
                           input.next();
                       }

                       newRaceCount = input.nextInt();
                       if (newRaceCount<raceCountnew) {// check the user entered
                           System.out.println("Invalid Input! Try Again.");
                       }

                   }while (newRaceCount<raceCountnew);

                // setting new driver details
                   driver.get(changeTeamIndex).setDrivername(newDriverName);
                   driver.get(changeTeamIndex).setLocation(newDriverLocation);
                   driver.get(changeTeamIndex).setNumoffirstposition(newFirstPositions);
                   driver.get(changeTeamIndex).setNumofsecondpositions(newSecondPositions);
                   driver.get(changeTeamIndex).setNumofthirdpositions(newThirdPositions);
                   driver.get(changeTeamIndex).setPoints(newPoints);
                   driver.get(changeTeamIndex).setRaces(newRaceCount);
                   System.out.println("You have successfully changed the driver of Team" +" " + teamNameArrayList.get(changeTeamIndex));
                   System.out.println();


               }else {
                   System.out.println("Team name is invalid check the name again");
                   changeDriverINTeam();// if user input is incorrect is wrong call the changedriver methord again


               }


       }




    /**
     * method for display formula 1 table
     */
    @Override
        public void DisplayFormula_1_table() {

            Collections.sort(driver);//Sort the driver class according to the driver points
            //Creating a console table for print sorted formula 1 championship drivers and their statistics
            System.out.println("---------------------------------- FORMULA 1 DRIVER TABLE-----------------------------------------------------");//print console table
            String leftAlignFormat = "| %-14s | %-9s | %-9d | %-14d | %-15d | %-14d | %-14d | %n";
            System.out.format("+----------------+-----------+-----------+----------------+-----------------+----------------+----------------+%n");
            System.out.format("| Name           | Team      | Points    | First Positions| Second Positions| Third Positions| Number Of Races|%n");
            System.out.format("+----------------+-----------+-----------+----------------+-----------------+----------------+----------------+%n");
            for (Formula1Driver FD :driver) {//For each loop for iterate through the driver arraylist and print the statistics
                System.out.format(leftAlignFormat,FD.getDrivername(),FD.getTeam(),FD.getPoints(),FD.getNumoffirstposition(),FD.getNumofsecondpositions(),FD.getNumofthirdpositions(),FD.getRaces());

            }
            System.out.format("+----------------+-----------+-----------+----------------+-----------------+----------------+----------------+%n");

            System.out.println("\n");

        }

    /**
     * method to add a new race
     */
        @Override
        public void AddRace(){
            int listSize=driver.size();//check the size of the array and set the value i n to listsize variable
            if (listSize==0){//using list size checking whether is there any drivers in the driver Arraylist
                System.out.println("There are no drivers in the competition add drivers before add a race!!!!!!");
                System.out.println("Enter : 1 to Add drivers or enter : 2 to back to the menu");
                int option=input.nextInt();// if there are no drivers give user to select to go back to menu or add a driver
                if (option==1 ){
                    createNewDriver();//if user want to add a driver call createDriver method
                }else{
                    System.out.println("*----Back to menu---*");}




            }else {

                System.out.println("Enter Race Date");//get the race date from the user
                String setRaceDate = input.next();// set user input in to setRace Variable
                raceDate.add(setRaceDate);//put the race date in to the raceDate arraylist


                for (Formula1Driver f4 : driver) {//create a for each loop for iterate through the array
                    System.out.println("Enter The Position of driver " + ":" + f4.getDrivername());
                    int newRace = input1.nextInt();


                    switch (newRace) {
                        case 1:
                            f4.setPoints(25);// if race position is "1" add '25' points to the drivers full points

                        case 2:
                            f4.setPoints(18);//if race position is "2" add "18 "points to the drivers full points

                        case 3:
                            f4.setPoints(15);//if race position is "3" add "15" points to the drivers full points
                        case 4:
                            f4.setPoints(12);//if race position is "4" add "12" points to the drivers full points
                        case 5:
                            f4.setPoints(10);//if race position is "5" add "10" points to the drivers full points
                        case 6:
                            f4.setPoints(8);//if race position is "6" add "8" points to the drivers full points
                        case 7:
                            f4.setPoints(6);//if race position is "7" add "6" points to the drivers full points
                        case 8:
                            f4.setPoints(4);//if race position is "8" add "4" points to the drivers full points
                        case 9:
                            f4.setPoints(2);//if race position is "9" add "2" points to the drivers full points
                        case 10:
                            f4.setPoints(1);//if race position is "10" add "1" points to the drivers full points
                    }
                    f4.setRaces(1);//increase every driver raceCount by "1"
                }
                Collections.sort(driver);//sort the drive arraylist again after add a race
            }
    }

    /**
     * method for store user entered data
     */
    @Override
    public void storeData(){
        File file=new File("src/com/company/driversdata");
        try {
            FileOutputStream output=new FileOutputStream(file,true);
            ObjectOutputStream output1=new ObjectOutputStream(output);

            Iterator it=driver.iterator();
            while (it.hasNext()){
                Formula1Driver driverNew=(Formula1Driver) it.next();
                output1.writeObject(driverNew);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * method for load user entered data from the saved file
     */
    @Override
    public void loadData() {
        driver.clear();
        try {
            FileInputStream input = new FileInputStream("src/com/company/driversdata");
            ObjectInputStream input1 = new ObjectInputStream(input);
            boolean load=true;
            do {

                Formula1Driver f = (Formula1Driver) input1.readObject();
                if (f != null) {
                    driver.add(f);
                } else {
                    System.out.println("No Data to load");
                load=false;  }

            }while (load);


        } catch (ClassNotFoundException e) {
                    e.printStackTrace();

        } catch (EOFException exception) {
                    System.out.println("");


        } catch (IOException exception) {
                    System.out.println("abc");
        }


    }

    public  void GUIOpen(){
        SwingUtilities.invokeLater(()-> new GUI());

    }



    public static void main(String[] args) {

        Formula1ChampionshipManager F1 = new Formula1ChampionshipManager();// creating an object from   Formula1ChampionshipManager to call non- static methods inside the main method
        boolean run = true;  //loop control variable of the menu
        F1.loadData();
        while (run) {//while loop for control the menu


            System.out.println("Welcome to the menu");//Print the options
            System.out.println("---------------------------------------");
            System.out.println("1 - For create new driver\n"+
                    "2 - For delete a driver\n"+
                    "3 - For change the team\n"+
                    "4 - For display statistics for existing driver\n"+
                    "5 - For display Formula 1 Table\n"+
                    "6 - For add race\n"+
                    "7 - For Open GUI Version\n" +
                    "8 - For exit from the program\n"+
                    "----------------------------------------");


            System.out.println("Choose and option");
            int control =input.nextInt();//getting the user option from the user


            switch (control) {  //switch statement
                case 1:
                    F1.createNewDriver();//if user option 'CND' execute create driver method

                    break;
                case 2:
                    F1.DeleteDriver();//if user option 'DAD' execute the delete driver
                    break;
                case 3:
                    F1.changeDriverINTeam();//if user option 'CTT' execute change driver team
                    break;
                case 4:
                    F1.DisplayStatistic();//if user option 'DS' execute displayExisting driver statistics
                    break;
                case 5:
                    F1.DisplayFormula_1_table();//if user  option  'DFDT 'execute displayFomula_1_Table
                    break;
                case 6:
                    F1.AddRace();//if user option 'AR' execute the addRace method
                    break;



                case  7:
                    F1.GUIOpen();
                    break;

                case 8:
                    System.out.println("Shutting Down............");
                    F1.storeData();//before exit from the program saving data in to a file.
                    run = false;//if user option 'EXT' Exit from the program
                    break;
                default:
                    System.out.println("Your input is invalid please try again");//if user enter invalid input let user know about it

            }

        }



    }
}


