package taskScheduler;

import java.util.ArrayList;
import java.util.Collections;

public class Scheduler {
    public static void scheduleAndRun(ArrayList<Process> processes) {
        ProcessQueue processQueue = new ProcessQueue();
        int time = 0;
        int totalTime = 0;
        int waitingTime = 0;

        Collections.sort(processes, (p1, p2) -> Integer.compare(p1.getArrivalTime(), p2.getArrivalTime()));
        int processIndex = 0;

        while (processIndex < processes.size() || !processQueue.isEmpty()) {
            while (processIndex < processes.size() && processes.get(processIndex).getArrivalTime() <= time) {
                processQueue.addProcess(processes.get(processIndex));
                processIndex++;
            }

            if (!processQueue.isEmpty()) {
                Process currentProcess = processQueue.runNextProcess();
                System.out.println("t = " + time + " → " + currentProcess.getName() + " is running");
                time++;
                currentProcess.setRemainingTime(currentProcess.getRemainingTime() - 1);

                if (currentProcess.getRemainingTime() > 0) {
                    processQueue.addProcess(currentProcess);
                } else {
                    currentProcess.setFinishTime(time);
                    totalTime += time;
                    waitingTime += time - currentProcess.getBurstTime() - currentProcess.getArrivalTime();
                }
            } else {
                System.out.println("t = " + time + " → No process is running");
                time++;
            }
        }

        System.out.println("Total time taken: " + totalTime);
        double averageWaitingTime = (double) waitingTime / processes.size();
        System.out.println("Average waiting time: " + averageWaitingTime);
    }

    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 1, 4, 0));
        processes.add(new Process("P2", 2, 3, 0));
        processes.add(new Process("P3", 1, 7, 6));
        processes.add(new Process("P4", 3, 4, 11));
        processes.add(new Process("P5", 2, 2, 12));

        scheduleAndRun(processes);
    }
}

