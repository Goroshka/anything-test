package com.koldakov.callback;

class Caller {

    public Caller(CallBack callBack) {
        this.callBack = callBack;
    }

    private CallBack callBack;

    public static void main(String[] args) {
        new Caller(() -> System.out.println("Call back method")).doWork();
        new Caller(() -> System.out.println("Abracadabra")).doWork();
    }

    private void doWork() {
        System.out.println("Performing callback before synchronous Task");
        callBack.methodToCallBack();
    }
}
