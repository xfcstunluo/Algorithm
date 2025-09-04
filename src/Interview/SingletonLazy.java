package Interview;

//线程安全懒汉式
public class SingletonLazy {
    private static volatile SingletonLazy instance;
    //外部类无法new，只有调用getInstance方法创建对象
    private SingletonLazy(){}
    //首次判断后在synchronized加锁时，仍然可能有并发的调用，可能导致不同线程同时创建两个对象。
    public static SingletonLazy getInstance(){
        if(instance==null){
            synchronized(SingletonLazy.class){
                if(instance==null){
                    instance=new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
