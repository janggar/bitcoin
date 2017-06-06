package com.yunhai.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket 学习   server端
 * @description
 * @className: SocketServerDemo 
 * @author Jiayanxing
 * @time 2017年5月18日  下午2:28:28
 */
public class SocketServerDemo {
	
	
	/** 
	 ******************************非多线程************************************ 								
	 * 1.用指定的端口实例化一个SeverSocket对象。服务器就可以用这个端口监听从客户端发来的连接请求。
		2.调用ServerSocket的accept()方法，以在等待连接期间造成阻塞，监听连接从端口上发来的连接请求。
		3.利用accept方法返回的客户端的Socket对象，进行读写IO的操作
		4.关闭打开的流和Socket对象
	*/
	public static void socketServer(){
		try {
			//创建server 对象
			ServerSocket serverSocket = new ServerSocket(7777);
			//开始监听
			Socket socket = serverSocket.accept();
			/***************************获取客户端信息************************/
			InputStream is = socket.getInputStream();
			//将字节流转换成字符流
			InputStreamReader isr = new InputStreamReader(is);
			//使用缓存流
			BufferedReader bfr = new BufferedReader(isr);
			//读取客户端信息流
			String clientInfo = null;
			while ((clientInfo = bfr.readLine()) != null) {
				System.out.println("Hello,我是服务器，客户端说：" + clientInfo);
			}
			//关闭客户端输入流
			socket.shutdownInput();
			
			/***************************响应客户端信息************************/
//			OutputStream os = socket.getOutputStream();
//			PrintWriter pw = new PrintWriter(os);
//			pw.write("我是服务器 ,现在对你说:Hello World！");
//			pw.flush();
			
			//关闭所有资源
//			pw.close();
//			os.close();
			bfr.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
			
		} catch (Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		socketServer();
	}
	
//	private Socket socket;  
//    private ServerSocket ss;  
//  
//    public SocketServerDemo() throws IOException {  
//        ss = new ServerSocket(7777);  
//        while (true) {  
//            socket = ss.accept();  
//            BufferedReader br = new BufferedReader(new InputStreamReader(socket  
//                    .getInputStream()));  
//            System.out.println("you input is : " + br.readLine());  
//        }  
//    }  
//  
//    public static void main(String[] args) {  
//        try {  
//            new SocketServerDemo();  
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        }  
//    }  
}
