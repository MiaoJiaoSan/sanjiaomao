package xyz.sanjiaomao.shared.autoconfiguration;

import org.slf4j.MDC;

import java.io.IOException;
import java.lang.reflect.*;
import java.util.Map;
import java.util.concurrent.*;

public class ThreadPoolUtil {


  /**
   * 自定义任务包装
   */
  private static class RunnableTask implements InvocationHandler {

    private final Map<String, String> context;

    private final Runnable runnable;


    public RunnableTask(Runnable runnable, Map<String, String> context) {
      this.context = context;
      this.runnable = runnable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      MDC.setContextMap(context);
      try {
        return method.invoke(runnable, args);
      } finally {
        MDC.clear();
      }
    }
  }

  private static class CallableTask<T> implements InvocationHandler {

    private final Map<String, String> context;

    private final Callable<T> callable;


    public CallableTask(Callable<T> callable, Map<String, String> context) {
      this.context = context;
      this.callable = callable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      MDC.setContextMap(context);
      try {
        return method.invoke(callable, args);
      } finally {
        MDC.clear();
      }
    }
  }


  public static ThreadPoolExecutor getExecutor(int corePoolSize,
                                               int maximumPoolSize,
                                               long keepAliveTime,
                                               TimeUnit unit,
                                               BlockingQueue<Runnable> queue) {
    return getExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, queue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
  }

  public static ThreadPoolExecutor getExecutor(int corePoolSize,
                                               int maximumPoolSize,
                                               long keepAliveTime,
                                               TimeUnit unit,
                                               BlockingQueue<Runnable> queue,
                                               ThreadFactory threadFactory,
                                               RejectedExecutionHandler handler) {


    return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, queue, threadFactory, handler) {
      @Override
      public Future<?> submit(Runnable task) {
        Runnable r = (Runnable) Proxy.newProxyInstance(Thread.class.getClassLoader(), new Class[]{Runnable.class}, new RunnableTask(task, MDC.getCopyOfContextMap()));
        return super.submit(r);
      }

      @Override
      public <T> Future<T> submit(Callable<T> task) {
        Callable<T> r = (Callable<T>) Proxy.newProxyInstance(Thread.class.getClassLoader(), new Class[]{Callable.class}, new CallableTask<T>(task, MDC.getCopyOfContextMap()));
        return super.submit(task);
      }

      @Override
      public <T> Future<T> submit(Runnable task, T result) {
        Runnable r = (Runnable) Proxy.newProxyInstance(Thread.class.getClassLoader(), new Class[]{Runnable.class}, new RunnableTask(task, MDC.getCopyOfContextMap()));
        return super.submit(r, result);
      }

      @Override
      public void execute(Runnable command) {
        Runnable r = (Runnable) Proxy.newProxyInstance(Thread.class.getClassLoader(), new Class[]{Runnable.class}, new RunnableTask(command, MDC.getCopyOfContextMap()));
        super.execute(r);
      }

    };

  }

  private static class ForkJoinTask0 implements InvocationHandler {

    private final Map<String, String> context;

    private final ForkJoinTask<?> forkJoinTask;


    public ForkJoinTask0(ForkJoinTask<?> forkJoinTask, Map<String, String> context) {
      this.context = context;
      this.forkJoinTask = forkJoinTask;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      MDC.setContextMap(context);
      try {
        return method.invoke(forkJoinTask, args);
      } finally {
        MDC.clear();
      }
    }
  }


  public static ForkJoinPool getForkJoinPool() {
    return new ForkJoinPool() {
      @Override
      public void execute(Runnable task) {
        Runnable r = (Runnable) Proxy.newProxyInstance(Thread.class.getClassLoader(), new Class[]{Runnable.class}, new RunnableTask(task, MDC.getCopyOfContextMap()));
        super.execute(r);
      }

      @Override
      public void execute(ForkJoinTask<?> task) {
        ForkJoinTask<?> r = (ForkJoinTask<?>) Proxy.newProxyInstance(Thread.class.getClassLoader(), new Class[]{ForkJoinTask.class}, new ForkJoinTask0(task, MDC.getCopyOfContextMap()));
        super.execute(r);
      }

      @Override
      public ForkJoinTask<?> submit(Runnable task) {
        Runnable r = (Runnable) Proxy.newProxyInstance(Thread.class.getClassLoader(), new Class[]{Runnable.class}, new RunnableTask(task, MDC.getCopyOfContextMap()));
        return super.submit(r);
      }

      @Override
      public <T> ForkJoinTask<T> submit(Callable<T> task) {
        Callable<T> r = (Callable) Proxy.newProxyInstance(Thread.class.getClassLoader(), new Class[]{Callable.class}, new CallableTask<T>(task, MDC.getCopyOfContextMap()));
        return super.submit(r);
      }

      @Override
      public <T> ForkJoinTask<T> submit(ForkJoinTask<T> task) {
        ForkJoinTask<T> r = (ForkJoinTask<T>) Proxy.newProxyInstance(Thread.class.getClassLoader(), new Class[]{ForkJoinTask.class}, new ForkJoinTask0(task, MDC.getCopyOfContextMap()));
        return super.submit(r);
      }

      @Override
      public <T> ForkJoinTask<T> submit(Runnable task, T result) {
        Runnable r = (Runnable) Proxy.newProxyInstance(Thread.class.getClassLoader(), new Class[]{Runnable.class}, new RunnableTask(task, MDC.getCopyOfContextMap()));
        return super.submit(r, result);
      }
    };
  }

  static {
    try {
      ForkJoinPool forkJoinPool = getForkJoinPool();
      Field asyncPool = CompletableFuture.class.getDeclaredField("ASYNC_POOL");
      asyncPool.setAccessible(true);
      Field modifiersField = Field.class.getDeclaredField("modifiers");
      modifiersField.setAccessible(true);
      modifiersField.setInt(asyncPool, asyncPool.getModifiers() & ~Modifier.FINAL);
      asyncPool.set(null, forkJoinPool);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {

    MDC.put("traceId", "123456");
    CompletableFuture.runAsync(() -> {
      System.out.println(MDC.get("traceId"));
    });
    CompletableFuture.runAsync(() -> {
      System.out.println(MDC.get("traceId"));
    });
    CompletableFuture.runAsync(() -> {
      System.out.println(MDC.get("traceId"));
    });
    System.in.read();
  }


}
