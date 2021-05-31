package type.sort.easy;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private volatile int count = 1;
    private volatile int countZero;
    private volatile int countOdd;
    private volatile int countEven;

    private Object lock = new Object();
    private volatile int zeroFlag = 1; // 0不可运行，1可运行
    private volatile int oddEvenFlag = 0; // 0不可运行，1可运行

    public ZeroEvenOdd(int n) {
        this.n = n;
        countZero = n;
        countOdd = n + 1 >> 1;
        countEven = n >> 1;
    }

    public static void main(String[] args) {
        ZeroEvenOdd obj = new ZeroEvenOdd(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.zero(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.odd(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.even(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (countZero > 0) {
            synchronized (lock) {
                while (zeroFlag == 0) {
                    lock.wait();
                }
                printNumber.accept(0);
                countZero--;
                zeroFlag = 0;
                oddEvenFlag = 1;
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (countEven > 0) {
            synchronized (lock) {
                while (oddEvenFlag == 0) {
                    lock.wait();
                }
                if (count % 2 == 0) {
                    printNumber.accept(count);
                    count++;
                    zeroFlag = 1;
                    oddEvenFlag = 0;
                    countEven--;
                }
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (countOdd > 0) {
            synchronized (lock) {
                while (oddEvenFlag == 0) {
                    lock.wait();
                }
                while (count % 2 == 1) {
                    printNumber.accept(count);
                    count++;
                    zeroFlag = 1;
                    oddEvenFlag = 0;
                    countOdd--;
                }
                lock.notifyAll();
            }
        }
    }
}