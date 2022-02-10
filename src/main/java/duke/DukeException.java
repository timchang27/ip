package duke;

public class DukeException extends Exception {
    public void missingDescription(String command){
        System.out.println("☹ OOPS!!! The description of a " + command + " cannot be empty.");
    }
    public void missingCommand(){
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}