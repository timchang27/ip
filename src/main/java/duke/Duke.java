package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;
import java.util.*;
import java.lang.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Duke {
    static ArrayList<Task> tasks = new ArrayList<Task>();
    public static void main(String[] args) throws IndexOutOfBoundsException {

        Scanner sc = new Scanner(System.in);
        DukeException ex = new DukeException();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";



        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke.Duke\n" + "What can I do for you?");
        displayOptions();
        String userInput;
        do {
            userInput = sc.nextLine();
            if(userInput.equals("list")){
                System.out.println("-------------------------------------------------------------------------\n" + "Here are the tasks in your list:");

                int i=1;
                for(Task task: tasks){
                    System.out.println(i + ": " + task.getDescription());
                    i++;
                }
                i=0;
                System.out.println("-------------------------------------------------------------------------");
            }
            else if(userInput.equals("bye")){
                break;
            }
            else if(userInput.startsWith("mark")){
                String[] input = new String[10];
                input  = userInput.split(" ");
                int index = Integer.parseInt(input[1]); //index of task to be marked
                if(tasks.get(index-1).getTaskStatus() == true){
                    System.out.println("The task is already marked!");
                    System.out.println("-------------------------------------------------------------------------");
                }
                else{
                    tasks.get(index-1).setMark();
                    System.out.println("-------------------------------------------------------------------------\n" + "Nice! I've marked this task as done: ");
                    System.out.println(tasks.get(index-1).getDescription());
                }
            }
            else if(userInput.startsWith("unmark")){
                String[] input = new String[10];
                input  = userInput.split(" ");
                int index = Integer.parseInt(input[1]); //index of task to be unmarked
                if(tasks.get(index-1).getTaskStatus()==false){
                    System.out.println("The task is not completed yet!");
                    System.out.println("-------------------------------------------------------------------------");
                }
                else {
                    tasks.get(index - 1).setUnmark();
                    System.out.println("-------------------------------------------------------------------------\n" + "OK, I've marked this task as not done yet:");
                    System.out.println(tasks.get(index - 1).getDescription());
                }
            }
            else if(userInput.startsWith("todo")){
                try{
                    String newtodo = userInput.split("todo")[1].trim();
                    Todo newTodo = new Todo(newtodo);
                    tasks.add(newTodo);
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("Got it! I've added this task: " + newTodo.getDescription());
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                } catch(IndexOutOfBoundsException e){
                    ex.missingDescription("todo");
                } finally{
                    System.out.println("What else should I do for you?");
                }
            }
            else if(userInput.startsWith("deadline")){
                try{
                    String[] input = userInput.split("/by");
                    String ddate = input[1].trim();
                    String deadline = input[0].split("deadline")[1].trim();
                    Deadline newDeadline = new Deadline(deadline, ddate);
                    tasks.add(newDeadline);
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("Got it! I've added this task: ");
                    System.out.println(newDeadline.getDescription());
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                } catch(IndexOutOfBoundsException e){
                    ex.missingDescription("deadline");
                } finally{
                    System.out.println("What else should I do for you?");
                }
            }
            else if(userInput.startsWith("event")){
                try{
                    String[] input = userInput.split("/at");
                    String eventDate = input[1].trim();
                    String event = input[0].split("event")[1].trim();
                    Event newEvent = new Event(event, eventDate);
                    tasks.add(newEvent);
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("Got it! I've added this task: ");
                    System.out.println(newEvent.getDescription());
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                } catch(IndexOutOfBoundsException e){
                    ex.missingDescription("event");
                } finally{
                    System.out.println("What else should I do for you?");
                }
            }
            else if(userInput.startsWith("delete")){
                String[] input = new String[10];
                input  = userInput.split(" ");
                //index of task to be deleted
                int index = Integer.parseInt(input[1]) - 1;
                if(tasks.size() > index){
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("Noted. I've removed this task: \n" + tasks.get(index).getDescription());
                    tasks.remove(index);
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                } else {
                    System.out.println("Task index not found");
                }
            }
            else{
                Task newTask = new Task(userInput);
                tasks.add(newTask);
                System.out.println("added: "+ userInput);
            }
        }while(!userInput.equals("bye"));

        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void displayOptions(){
        System.out.println("Enter todo to create new todo (...)\n" +
                "Enter event (... /at {eventDate}) to create new event\n" +
                "Enter deadline (... /by {dueDate}) to create new Deadline");
    }

    public static void saveTasks() {
        String toFile = "";
        try {
            FileWriter writer = new FileWriter("src/main/java/duke/tasks.txt");
            for (int i = 0; i < tasks.size(); i++) {
                toFile += tasks.get(i).getDescription() + "\n";
            }
            writer.write(toFile);
            writer.close();
            System.out.println("Task saved");
            System.out.println("______________________________________");
        } catch (Exception e) {
            System.out.println("Error occurred");
        }
    }

}
