package Proj3;

public class ListJobs {
	//variable list:
    private String jobTitle; 
    private int startingTime, time; 
    private boolean state = false; //signifies if its running or not

    //Default constructor
    public ListJobs() {
        this.jobTitle = null;
        this.startingTime = -1;
        this.time = -1;
    }
    
    //Constructor to initialize objects in ListJobs
    public ListJobs(String jobTitle,int startingTime, int time) {
        this.jobTitle = jobTitle;
        this.startingTime = startingTime;
        this.time = time;
    }

    public boolean getState() {
        return this.state;
    }

    public void currentState() {
    	this.state = ((this.state) ? false : true);	//returns true or false
    }

    //Get the string
    public String toString() {
        return this.jobTitle + "\nStart time : " + this.startingTime + "\nTotal time elapsed : "+ this.time + "\n";
    }
}