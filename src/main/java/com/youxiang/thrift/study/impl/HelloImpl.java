package com.youxiang.thrift.study.impl;

import com.youxiang.thrift.study.Hello;
import org.apache.thrift.TException;

/**
 * @author: Rivers
 * @date: 2018/6/19
 */
public class HelloImpl implements Hello.Iface {

    @Override
    public String helloString(String param) throws TException {
        return param;
    }

    @Override
    public int helloInt(int param) throws TException {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return param;
    }

    @Override
    public boolean helloBoolean(boolean param) throws TException {
        return param;
    }

    @Override
    public void helloVoid() throws TException {
        System.out.println("Hello World");
    }

    @Override
    public String helloNull() throws TException {
        return null;
    }
}
