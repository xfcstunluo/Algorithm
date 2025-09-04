package Interview;

//饿汉式
//类加载时创建好实例，不支持懒加载，天然线程安全
public class SingletonHungry {
    private static final SingletonHungry instance=new SingletonHungry();
    private SingletonHungry(){}
    public static SingletonHungry getInstance(){
        return instance;
    }
}
