import java.util.*;

public class Duke {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        ArrayList<Task> tasks = new ArrayList<Task>();

        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");
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
            else if(userInput.contains("mark")){
                String[] input = new String[10];
                input  = userInput.split(" ");
                int index = Integer.parseInt(input[1]); //index of task to be marked
                tasks.get(index-1).setMark();
                System.out.println("-------------------------------------------------------------------------\n" + "Nice! I've marked this task as done: ");
                System.out.println("[X] "+ tasks.get(index-1).getDescription());
            }
            else if(userInput.contains("unmark")){
                String[] input = new String[10];
                input  = userInput.split(" ");
                int index = Integer.parseInt(input[1]); //index of task to be unmarked
                tasks.get(index-1).setUnmark();
                System.out.println("-------------------------------------------------------------------------\n" + "OK, I've marked this task as not done yet:");
                System.out.println("[ ] "+ tasks.get(index-1).getDescription());
            }
            else{
                Task newTask = new Task(userInput);
                tasks.add(newTask);
                System.out.println("added: "+ userInput);
            }

        }while(!userInput.equals("bye"));

        System.out.println("Bye. Hope to see you again soon!");
    }
}
