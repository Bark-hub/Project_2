package com.company;

// Mubarik Abdi 3/1/2020

import java.util.*;

public class Main {

    public static Scanner input = new Scanner(System.in);
    //I used an ArrayList of objects which are instances of the Task class. Meaning each item in the list is a singular task.
    public static ArrayList<Task> ToDo = new ArrayList<>();

    public static void main(String[] args) {
        //Below is a selection of tasks just for the use of testing, I would like to have something in the list at all times.
        Task testing = new Task("bee", "horible", 1);
        Task testing2 = new Task("boo", "good", 2);
        Task testing3 = new Task("baa", "IDK", 1);
        Task testing4 = new Task("bunny", "cute", 2);
        ToDo.add(testing);
        ToDo.add(testing2);
        ToDo.add(testing3);
        ToDo.add(testing4);

        //The menu is below. Just a simple interface for the user.
        System.out.println("---MENU-------MENU-------MENU----");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(5) List Specific tasks.");
        System.out.println("(0) Exit.");
        System.out.println("Please Choose One: ");

        //It all begins with the userInput() method because it controls the looping and selection of other methods.
        //I used a switch case that is contained within a while loop. The switch selects the methods.
        String loop = userInput();

        while (!loop.equals("0")) {
            switch (loop) {
                case "1":
                    add();
                    System.out.println("what else do you wanna do? (1)add, (2)remove, (3)update, (4)list All, (5)list Specific, (0)exit");
                    loop = userInput();
                    break;
                case "2":
                    remove();
                    System.out.println("what else do you wanna do? (1)add, (2)remove, (3)update, (4)list All, (5)list Specific, (0)exit");
                    loop = userInput();
                    break;
                case "3":
                    update();
                    System.out.println("what else do you wanna do? (1)add, (2)remove, (3)update, (4)list All, (5)list Specific, (0)exit");
                    loop = userInput();
                    break;
                case "4":
                    listDemAll();
                    System.out.println("what else do you wanna do? (1)add, (2)remove, (3)update, (4)list All, (5)list Specific, (0)exit");
                    loop = userInput();
                    break;
                case "5":
                    listSpecifically();
                    System.out.println("what else do you wanna do? (1)add, (2)remove, (3)update, (4)list All, (5)list Specific, (0)exit");
                    loop = userInput();
                    break;
                case "0":
                    break;
            }
        }

    }

    //The input method is below and this particular method has exception handling.
    //This method is the only one with a returning value.
    public static String userInput(){
        String userChoice = input.nextLine();
        Boolean pass = false;
        while(!pass) {
            try {
                int userIntChoice = Integer.parseInt(userChoice);
                if (userIntChoice <= 5 && userIntChoice >= 0) {
                    pass = true;
                }else{
                    System.out.println(userChoice + " IS NOT A GOOD NUMBER, PLEASE ENTER A NUMBER OR ELSE. >:<");
                    userChoice = input.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println(userChoice + " IS NOT A GOOD NUMBER, PLEASE ENTER A NUMBER OR ELSE. >:<");
                userChoice = input.nextLine();
            }
        }
        return userChoice;
    }

    //Below is the method for adding a task. It simply creates an instance of the class Task while asking the user for input.
    //As you can see, after the exception handling in the method before, I did not do exception handling for the rest.
    //I believe that if the user got to this point, then their competent enough to not make mistakes.
    public static void add(){
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("Adding Task: ");

        System.out.println("Input title: ");
        String title = input.nextLine();
        System.out.println("Input Description: ");
        String description = input.nextLine();
        System.out.println("Input Priority: (from 0 to 5 being most important)");
        int priority = input.nextInt();

        Task item = new Task(title, description, priority);
        ToDo.add(item);
        System.out.println("------Successfully Added-------");
    }

    //The listing method which shows the specific priority level the user is looking for.
    public static void listSpecifically(){
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("Listing Task(s): ");
        System.out.println("What priority of tasks are you looking for?");
        int priorityIndex = input.nextInt();
        for (Task priority : ToDo) {
            if (priority.getPriority() == priorityIndex) {
                System.out.println(priority);
            }
        }
        System.out.println("------Successfully Listed-------");
    }

    //The listDemAll method is used to show all tasks.
    //NOTE: this method is used often in the update method and remove method.
    //I do not want our poor user to remove and add stuff blindly.
    public static void listDemAll(){
        System.out.println("");
        for(Task priority : ToDo){
            System.out.println(priority);
        }
        System.out.println("------Successfully Listed-------");
    }

    //The method below is the remove method. The user needs to specify which task to remove by number.
    public static void remove(){
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("Removing Task: ");
        listDemAll();
        System.out.println("Which would you like to Remove? (enter a number as in 1 for first Task or 2 as in second task)");
        int taskNumber = input.nextInt();
        int taskIndex = taskNumber - 1;
        ToDo.remove(taskIndex);
        System.out.println("------Successfully Removed-------");
    }

    //The method below is a combination of the remove and add method but with a twist.
    //It allows the user to specify which task to edit / update.
    public static void update(){
        System.out.println("Updating Task: ");
        listDemAll();
        System.out.println("Which would you like to Update? (enter a number as in 1 for first Task or 2 as in second task)");
        int taskNumber = input.nextInt();
        int taskIndex = taskNumber - 1;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter New Title: ");
        String newTitle = input.nextLine();
        System.out.println("Enter New Description: ");
        String newDescription = input.nextLine();
        System.out.println("Enter New Priority: ");
        int newPriority = input.nextInt();

        ToDo.get(taskIndex).setTitle(newTitle);
        ToDo.get(taskIndex).setDescription(newDescription);
        ToDo.get(taskIndex).setPriority(newPriority);
        System.out.println("------Successfully Updated-------");

    }

    //This was super fun but I got Lazy and distracted in the end. :)
    //Thanks for the challenge <3

}
