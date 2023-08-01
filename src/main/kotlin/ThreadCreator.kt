class ThreadCreator {
    internal class MyThread : Thread() {
        override fun run() {
            // 线程要执行的代码
        }
    }

    fun build1() {
        val thread = MyThread()
        thread.start()
    }

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