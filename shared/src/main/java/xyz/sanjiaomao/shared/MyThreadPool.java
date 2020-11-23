package xyz.sanjiaomao.shared.autoconfiguration;

import java.util.UUID;
import java.util.concurrent.*;

public class MyThreadPool {


  private static final BlockingQueue<Runnable> QUEUE =  new ArrayBlockingQueue<Runnable>(10){
    @Override
    public boolean offer(Runnable r) {
      return super.offer(new MyTask(TRACE.get(),r));
    }

    @Override
    public Runnable take() throws InterruptedException {
      Runnable take = super.take();
      MyTask myTask = (MyTask) take;
      String traceId = myTask.getTraceId();
      TRACE.set(traceId);
      return myTask;
    }
  };

  private static final ThreadLocal<String> TRACE = new ThreadLocal<>();

  /**
   * 自定义任务包装
   */
  public static class MyTask implements Runnable {

    Runnable runnable;

    private String traceId;

    public MyTask(String traceId, Runnable runnable){
      this.traceId = traceId;
      this.runnable = runnable;
    }

    public String getTraceId() {
      return traceId;
    }

    @Override
    public void run() {
      String traceId = this.getTraceId();
      TRACE.set(traceId);
      try {
        this.runnable.run();
      } finally {
        TRACE.remove();
      }
    }

  }

  public static final Executor EXECUTOR = new ThreadPoolExecutor(1, 10, 10, TimeUnit.SECONDS, QUEUE, new ThreadFactory() {
    @Override
    public Thread newThread(Runnable r) {
      r = new MyTask(TRACE.get(),r);
      return new Thread(r);
    }
  });

  public static void main(String[] args) {

    for (int i = 0; i < 10; i++) {
      String traceId = UUID.randomUUID().toString();
      System.out.println(Thread.currentThread().getId() + "=========" + traceId);
      //1.主线程先set一个traceId
      TRACE.set(traceId);
      //4.提交任务到线程池
      EXECUTOR.execute(() -> System.out.println(Thread.currentThread().getId() + "========" + TRACE.get()));
    }

  }


}
