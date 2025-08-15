package HUAWEI25;

import java.util.*;

public class HUAWEI052101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //add 任务id 优先级0-99，数小的高； 运行时间
        //FIFO队列
        PriorityQueue<Task> queue=new PriorityQueue<>((a,b)->{
            if(a.priority!=b.priority)  return a.priority-b.priority;
            else return a.order-b.order;
        });
        int order=0;
        while(sc.hasNextLine()){
            String line = sc.nextLine().trim();
            if(line.isEmpty()) break;
            String[] cur=line.split(" ");
            if(cur[0].equals("add")){
                int taskId=Integer.parseInt(cur[1]);
                int priority=Integer.parseInt(cur[2]);
                int time=Integer.parseInt(cur[3]);
                queue.offer(new Task(taskId,priority,time,order++));
            }else if(cur[0].equals("run")){
                int excuteTime=Integer.parseInt(cur[1]);
                //如果任务time<=所给时间，该任务出队；所给时间减去该任务时间；
                //不出队，但是修改该任务的执行时间；
                while(excuteTime>0&&!queue.isEmpty()){
                    Task tmp=queue.poll();
                    if(tmp.time<=excuteTime) excuteTime-=tmp.time;
                    else{
                        tmp.time-=excuteTime;
                        excuteTime=0;
                        queue.offer(tmp);
                    }
                }
            }
        }
        System.out.println(queue.isEmpty()?"idle":queue.peek().taskId);
    }

    static class Task{
        int taskId;
        int priority;
        int time;
        int order;
        public Task(int taskId, int priority, int time, int order) {
            this.taskId = taskId;
            this.priority = priority;
            this.time = time;
            this.order = order;
        }
    }
}


