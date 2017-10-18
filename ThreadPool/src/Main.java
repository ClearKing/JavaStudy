import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
//        newCachedThreadPool();
//        newFixedThreadPool();
//        newScheduledExecutor();
        newSingleThreadExecutor();
    }
    //1.
    private static void  newCachedThreadPool(){
        //创建一个可缓存的线程池，如果线程池的大小超过了处理任务所需要的线程，那么就会回收空闲的部分线程
       ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
       for (int i = 0; i <= 10; i++){
           final int index = i;
           try {
               Thread.sleep(index * 1000);
           } catch ( InterruptedException e ) {
               e.printStackTrace();
           }

           cachedThreadPool.execute(new Runnable() {
               @Override
               public
               void run() {
                   String threadName = Thread.currentThread().getName();
                   System.out.println("执行：" + index + "，线程名称：" + threadName);

               }
           });
       }
   }

   //2.创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
    public static void newFixedThreadPool(){

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i <= 10; i++){
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public
                void run() {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("执行: "+index+"线程名称:"+threadName);
                    try {
                        Thread.sleep(2000);
                    } catch ( InterruptedException e ) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    //3.创建一个定长线程池，支持定时及周期性任务执行。延迟执行
    public static void newScheduledExecutor(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public
            void run() {
                System.out.println("表示延迟三秒执行");
            }
        }, 3, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public
            void run() {
                System.out.println("表示延迟1秒后，每3秒执行一次");
            }
        },1,3,TimeUnit.SECONDS);
    }

    //4. * 描述:创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
    public static void newSingleThreadExecutor(){
        ExecutorService signleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i <= 10; i++){
            final int index = i;
            signleThreadExecutor.execute(new Runnable() {
                @Override
                public
                void run() {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("执行: "+index+"线程名称:"+threadName);
                    try {
                        Thread.sleep(2000);
                    } catch ( InterruptedException e ) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}


//每次new Thread 新建对象性能差
//线程缺乏统一管理，可能无限新建线程，相互之间竞争，极可能占用过多系统资源而导致死机
//缺乏更多功能，如定时执行，定制执行，线程中断


//线程池好处
//重用存在的线程，减少对象创建，消亡
//可控制最大并发线程数，提高系统资源的使用率
//提供定时执行，定期执行，单线程，并发数控制等功能
