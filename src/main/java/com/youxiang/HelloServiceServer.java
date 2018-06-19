package com.youxiang;

import com.youxiang.thrift.study.Hello;
import com.youxiang.thrift.study.impl.HelloImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @author: Rivers
 * @date: 2018/6/19
 */
public class HelloServiceServer {

    public static void main(String[] args) {
        try {
            TServerSocket serverSocket = new TServerSocket(7911);
            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();
            TProcessor processor = new Hello.Processor(new HelloImpl());

            TThreadPoolServer.Args arg = new TThreadPoolServer.Args(serverSocket);
            arg.processor(processor);
            arg.protocolFactory(proFactory);
            TServer server = new TThreadPoolServer(arg);
            System.out.println("Start server on port 7911");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
