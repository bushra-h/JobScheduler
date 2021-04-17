package Proj3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SelectSched {
    static Queue<ListJobs> jobQueue = new LinkedList<>(); 
    static Scheduler schedule = new Scheduler();
    static int totalTime = 0;
    static File file;
    static BufferedReader buffRead;
    
    public static void main(String[] args) {
        //open the file
    	try {
    		//replace file path as needed
            file = new File("C:\\Users\\Bushra\\Documents\\CS 4348 OS\\Project 3\\Job1.txt");
            buffRead = new BufferedReader(new FileReader(file));
            readFile();
            displayJobQueue();
        } catch (FileNotFoundException excep) {
            System.out.println("ERROR: file not found");
            //error in console
            excep.printStackTrace();
        }
    }

    //read through the file
    public static void readFile() { 
        String text;
        int time;
        
        try { 
            while ((text = buffRead.readLine()) != null) {
            	//split jobs once a tab is reached
                String[] temp = text.split("\t");
                time = Integer.parseInt(temp[2]);
                totalTime += time;
                
                //add as a new job
                jobQueue.add(new ListJobs(temp[0],Integer.parseInt(temp[1]), time));
            }
        } catch (IOException excep){
            System.out.println("IO Exception");
            excep.printStackTrace();
        }
    }

    //display the job Queues
    private static void displayJobQueue() {
        for(ListJobs str : jobQueue) {
            System.out.println(str.toString());
        }
    }

    //list of selection algorithms 
    private static void selectionAlg() {
    	//print the prompt
        System.out.println("Enter the abbreviated selection algorithm, every scheduling algorithm, or exit the program\n"
        		+ "- FCFS : first come first served\n"
        		+ "- RR : Round Robin\n"
        		+ "- SPN : Shortest process next\n"
        		+ "- SRT : Shortest remaining time\n"
        		+ "- HRRN : Highest response ratio next\n"
        		+ "- FB : Feedback\n"
        		+ "- Every scheduling alg\n"
        		+ "- Exit");
        
        //read in user's entry
        Scanner input = new Scanner(System.in); 
        
        //select case in accordance to the user's entry
        switch (input.nextLine()) {
            case "FCFS": schedule.fcfs(jobQueue, totalTime); 
            break;
            case "RR": schedule.rr(jobQueue, totalTime); 
            break;
            case "SPN": schedule.spn(jobQueue, totalTime); 
            break;
            case "SRT": schedule.srt(jobQueue, totalTime); 
            break;
            case "HRRN": schedule.hrrn(jobQueue, totalTime); 
            break;
            case "FB": schedule.fb(jobQueue, totalTime); 
            break;
            case "Every scheduling alg": schedule.everySchedAlg(jobQueue, totalTime); 
            break;
            case "Exit": System.exit(0); 
            break;
            case " ": {
            	System.out.println("ERROR: please enter a valid scheduling algorithm"); 
            	selectionAlg(); 
            	break;
            }
            
            default: {
            	System.out.println("INVALID CHOICE"); 
            	selectionAlg(); 
            	break;
            }
        }
    }
}