package Interview;
import java.util.*;
public class CreateMQ {
    //队列最大长度
    static private int queueSize=10;
    static private Deque<Integer> q=new ArrayDeque<>();
    public static void main(String[] args) {
        CreateMQ mq=new CreateMQ();
        Consumer consumer=new Consumer();
        consumer.start();
        //创建生产者线程
        for(int i=0;i<10;i++){
            Producer producer=new Producer();
            producer.start();
        }
    }

    //生产者
    static class Producer extends Thread{
        @Override
        public void run() {
            synchronized (q) {
                //判断当前队列长度是否小于最大长度
                //若小于，往队列添加消息，唤醒消费者；
                //若大于，wait
                if(q.size()<queueSize){
                    //模拟加入任务
                    q.offer(q.size()+1);
                    System.out.println("生产者往队列中加入消息，当前长度："+q.size());
                    //模拟业务处理
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    q.notify();
                }else{
                    try {
                        q.wait();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                        q.notify();
                    }
                }
            }
        }
    }

    //创建消费者
    static class Consumer extends Thread{
        @Override
        public void run() {
            //消费者需要重复工作
            while(true){
                //保证消费过程线程安全
                synchronized(q){
                    //若队列为空，消费者睡眠
                    if(q.isEmpty()){
                        System.out.println("当前队列为空");
                        try{
                            q.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                            //一旦出现异常，手动唤醒
                            q.notify();
                        }
                    }else{
                        //消费
                        Integer val=q.poll();
                        System.out.println("消费者往队列中消费了消息："+val+"，队列当前长度："+q.size());
                        //唤醒生产者继续生产
                        q.notify();
                        try {
                            Thread.sleep(1000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}


