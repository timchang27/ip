package duke.task;

public class Task {

    protected String description;
    protected boolean isTaskDone;

    public Task(String description){
        this.description = description;
        this.isTaskDone = false;
    }

    public Task(String description, boolean isTaskDone){
        this.description = description;
        this.isTaskDone = isTaskDone;
    }

    public String getDescription(){
        return showStatus() + description;
    }
    public void setDescription(String input){
        description = input;
    }
    public boolean getTaskStatus(){
        return isTaskDone;
    }
    public void setMark(){
        this.isTaskDone = true;
    }
    public void setUnmark(){
        this.isTaskDone = false;
    }
    public String showStatus(){
        if(isTaskDone==true){
            return("[X]");
        }
        else{
            return("[ ]");
        }
    }

}
