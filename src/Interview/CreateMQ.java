package Interview;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateMQ {
    //队列最大长度
    static private int queueSize=10;
    static private final BlockingQueue<Integer> q=new LinkedBlockingQueue<>(queueSize);
    static final AtomicInteger SEQ = new AtomicInteger(1);
    public static void main(String[] args) {
        new Thread(new Consumer(), "Consumer").start();
        for(int i=1;i<=2;i++){
            new Thread(new Producer(), "Producer").start();
        }
    }

    //生产者
    static class Producer implements Runnable{
        @Override
        public void run() {
            try{
                for (int i = 0; i < 10; i++){
                    int p=SEQ.getAndIncrement();
                    q.put(p);
                    System.out.println(Thread.currentThread().getName()+"生产:"+p+"队列长度="+q.size());
                    Thread.sleep(200);
                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    //创建消费者
    static class Consumer implements Runnable{
        @Override
        public void run() {
            try{
                while(true){
                    Integer c=q.take();
                    System.out.println(Thread.currentThread().getName()+"消费:"+c+"队列长度="+q.size());
                    Thread.sleep(200);
                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

}


