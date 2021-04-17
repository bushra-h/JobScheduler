package Proj3;

import java.util.Queue;

public class Scheduler {
	//SCHEDULING ALGORITHMS : 

    public void fcfs(Queue<ListJobs> job, int elapsedTime) {
        ListJobs val;
        System.out.println("First come first serve scheduling algorithm");
        
        //poll() method of Queue Interface returns and removes the element at the front of the container. 
        //It deletes the element in the container. 
        //The method does not throw an exception when the Queue is empty, it returns null instead.
        while((val = job.poll())!= null) {
        	//loop if true
        }
    }

    public void rr(Queue<ListJobs> job, int elapsedTime) {
        int quantum = 1;	//set quantum to 1
        System.out.println("Round Robin scheduling algorithm\n");
    }

    public void spn(Queue<ListJobs> job, int elapsedTime) {
        System.out.println("Shortest process next scheduling algorithm\n");
    }

    public void srt(Queue<ListJobs> job, int elapsedTime) {
        System.out.println("Shortest remaining time scheduling algorithm\n");
    }

    public void hrrn(Queue<ListJobs> job, int elapsedTime) {
        System.out.println("Highest response ratio next scheduling algorithm\n");
    }

    public void fb(Queue<ListJobs> job, int elapsedTime) {
        int quantum = 1;	//set quantum to 1
        System.out.println("Feedback scheduling algorithm\n");
    }

    public void everySchedAlg(Queue<ListJobs> job, int elapsedTime) {
        System.out.println("Every scheduling algorithm\n");
        fcfs(job, elapsedTime);
        rr(job, elapsedTime);
        spn(job, elapsedTime);
        srt(job, elapsedTime);
        hrrn(job,elapsedTime);
        fb(job, elapsedTime);
    }
}