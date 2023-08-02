import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ReusableThread {

    /**
     * 参数：
     * corePoolSize - 在池中保持的线程数，即使它们处于空闲状态，除非设置了allowCoreThreadTimeOut
     * maximumPoolSize - 允许在池中的最大线程数
     * keepAliveTime - 当线程数大于核心池大小时，这是多余的空闲线程在终止之前等待新任务的最大时间
     * unit - keepAliveTime参数的时间单位
     * workQueue - 在执行任务之前用于持有任务的队列。这个队列将只保存通过execute方法提交的Runnable任务。
     *
     * 抛出：
     * IllegalArgumentException - 如果满足以下条件之一：corePoolSize < 0、keepAliveTime < 0、maximumPoolSize <= 0、maximumPoolSize < corePoolSize
     * NullPointerException - 如果workQueue为空。
     */

    private fun buildFixedThreadPool(): ExecutorService {
        return Executors.newFixedThreadPool(5) // 创建一个固定大小的线程池，最多同时运行5个线程
    }

    private fun buildSingleThreadExecutor(): ExecutorService {
        return Executors.newSingleThreadExecutor() // 创建一个单线程池
    }

    private fun buildCachedThreadPool(): ExecutorService {
        return Executors.newCachedThreadPool() // 创建一个缓存线程池
    }

    private fun buildScheduledThreadPool(): ExecutorService {
        return Executors.newScheduledThreadPool(5) // 创建一个定时任务和周期性任务的线程池
    }

    fun executeFixedThreadPool() {
        val executor = buildCachedThreadPool()
        executor.execute{

        }
        executor.shutdown()
    }

    fun executeSingleThreadExecutor() {
        val executor = buildSingleThreadExecutor()
        executor.execute{

        }
        executor.shutdown()
    }

    fun executeCachedThreadPool() {
        val executor = buildCachedThreadPool()
        executor.execute{

        }
        executor.shutdown()
    }

    fun executeScheduledThreadPool() {
        val executor = buildScheduledThreadPool()
        executor.execute{

        }
        executor.shutdown()
    }

    /**
     * corePoolSize：
     * 类型：int
     * 含义：线程池中保持的核心线程数，即使它们处于空闲状态。
     * 注意：这些核心线程在池中一直保持活动，除非设置了allowCoreThreadTimeOut参数。
     *
     * maximumPoolSize：
     * 类型：int
     * 含义：线程池允许的最大线程数。
     * 注意：当任务数量超过核心线程数时，线程池可以创建新的线程，但数量不能超过该最大值。
     *
     * keepAliveTime：
     * 类型：long
     * 含义：当线程数大于核心池大小时，多余的空闲线程在终止之前等待新任务的最大时间。
     * 单位由下一个参数unit指定。
     *
     * unit：
     * 类型：TimeUnit
     * 含义：keepAliveTime参数的时间单位。可以是纳秒、微秒、毫秒、秒等。
     *
     * workQueue：
     * 类型：BlockingQueue<Runnable>
     * 含义：用于持有任务的队列，等待执行的任务将被放入该队列。
     * 注意：这个队列通常是一个阻塞队列，可以是ArrayBlockingQueue、LinkedBlockingQueue等。
     * threadFactory：
     * 类型：ThreadFactory
     * 含义：用于创建新线程的工厂。可以自定义ThreadFactory，也可以使用默认的线程工厂。
     *
     * handler：
     * 类型：RejectedExecutionHandler
     * 含义：当线程池和任务队列都满了，无法处理新任务时，用于处理被拒绝的任务。
     * 可选的处理方式有：AbortPolicy（默认，抛出RejectedExecutionException）、CallerRunsPolicy（使用提交任务的线程来执行任务）、DiscardOldestPolicy（丢弃队列中最旧的任务）、DiscardPolicy（丢弃被拒绝的任务）。
     */
}