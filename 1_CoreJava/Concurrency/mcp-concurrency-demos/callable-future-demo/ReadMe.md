###1. Callable + Future的问题

>1. 当调用future的get()方法时，当前主线程是堵塞的。

&nbsp;

###2. Java8 CompletableFuture介绍

####2-1) API介绍

- CompletableFuture源码中有四个静态方法用来执行异步任务
```
/*
    如果没有传入Executor对象将会使用ForkJoinPool.commonPool() 
    作为它的线程池执行异步代码
    在实际使用中,一般我们使用自己创建的线程池对象来作为参数传入使用，这样速度会快些
*/

// 执行没有返回值的任务
public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier){..}
public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier,Executor executor){..}

// 执行有返回值的任务
public static CompletableFuture<Void> runAsync(Runnable runnable){..}
public static CompletableFuture<Void> runAsync(Runnable runnable,Executor executor){..} 
```

