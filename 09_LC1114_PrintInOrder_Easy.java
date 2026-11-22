class Foo {
    java.util.concurrent.CountDownLatch afterFirst = new java.util.concurrent.CountDownLatch(1);
    java.util.concurrent.CountDownLatch afterSecond = new java.util.concurrent.CountDownLatch(1);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        afterFirst.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        afterFirst.await();
        printSecond.run();
        afterSecond.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        afterSecond.await();
        printThird.run();
    }
}
