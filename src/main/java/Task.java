public class Task {

    protected String description;
    protected boolean isTaskDone;

    public Task(String description){
        this.description = description;
        this.isTaskDone = false;
    }

    public String getDescription(){
        return description;
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


}
