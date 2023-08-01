class ThreadCreator {

    /**
     * 优点：
     * Thread类提供了一些控制线程的方法，如start()用于启动线程，sleep()用于暂停线程等。
     *
     * 缺点：
     * Java不支持多重继承，如果已经继承了其他类，则无法再使用Thread类来创建线程。
     * Thread是一个类，而不是接口，这限制了线程的复用性。
     */
    internal class MyThread : Thread() {
        override fun run() {
            // 线程要执行的代码
        }
    }

    fun build1() {
        val thread = MyThread()
        thread.start()
    }

    /**
     * 优点：
     * 由于Java支持单一继承和多实现，使用Runnable接口可以更灵活地组织代码，同时支持实现其他接口。
     * 支持线程池，可以通过Executor框架更好地管理线程。
     */
    internal class MyRunnable : Runnable {
        override fun run() {
            // 线程要执行的代码
        }
    }

    fun build2() {
        val myRunnable = MyRunnable()
        val thread = Thread(myRunnable)
        thread.start()
    }

    /**
     * 综上所述，使用Runnable接口更灵活和推荐，因为它不会在继承方面限制你，同时也支持线程池的使用。
     * 使用Thread类也可以创建线程，但会有一些限制，并且在多重继承的情况下会产生一些问题。
     */

    /**
     * Thread类而不是Runnable的情况
     *
     * 继承Thread类允许直接操作线程对象：
     * 如果你需要直接操作线程对象，例如暂停、恢复、中断等，而不仅仅是执行一个简单的任务，那么继承Thread类可能更方便。
     * Thread类提供了一些控制线程状态的方法，如suspend()、resume()和interrupt()，虽然这些方法已被标记为不推荐使用，但在特定情况下可能仍然有用。
     *
     * 需要访问线程的状态和属性：
     * 通过继承Thread类，你可以轻松地访问线程的状态和属性，如线程的名称、优先级等。
     * Runnable接口没有直接提供这些功能，你需要通过Thread对象来获取。
     */

    /**
     * 自己的理解：
     *
     * Thread 是一个人，这个人可以做某件事，Runnable 是一件事，交给了 Thread 就能被做
     */

    // ########################################

    fun build3() {
        val runnable = Runnable {
            // 线程要执行的代码
        }
        val thread = Thread(runnable)
        thread.start()
    }

    fun build4() {
        val thread = Thread {
            // 线程要执行的代码
        }
        thread.start()
    }
}