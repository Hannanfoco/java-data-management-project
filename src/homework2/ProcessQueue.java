package homework2;

import java.util.PriorityQueue;

public class ProcessQueue {
    private PriorityQueue<Process> queue;

    public ProcessQueue() {
        this.queue = new PriorityQueue<>();
    }

    public void addProcess(Process process) {
        queue.add(process);
    }

    public Process runNextProcess() {
        return queue.poll();
    }

    public Process peekNextProcess() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
