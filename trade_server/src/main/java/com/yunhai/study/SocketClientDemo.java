package com.yunhai.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * socket 学习   client端
 * @description
 * @className: SocketClientDemo 
 * @author Jiayanxing
 * @time 2017年5月18日  下午2:28:28
 */
public class SocketClientDemo {
	
	
	/** 
	 ******************************非多线程************************************ 								
	 * 1.用指定的端口实例化一个SeverSocket对象。服务器就可以用这个端口监听从客户端发来的连接请求。
		2.调用ServerSocket的accept()方法，以在等待连接期间造成阻塞，监听连接从端口上发来的连接请求。
		3.利用accept方法返回的客户端的Socket对象，进行读写IO的操作
		4.关闭打开的流和Socket对象
	*/
	public static void socketClient(){
		try {
			//创建server 对象
			Socket socket = new Socket("localhost", 7777);
			//获取输出流
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("客户端用户名：admin；密码：admin");
			pw.flush();
			
			//获取输入流
//			InputStream is = socket.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is);
//			BufferedReader bfr = new BufferedReader(isr);
//			String serverIfo = null;
//			while((serverIfo =bfr.readLine()) !=null){
//				System.out.println("Hello,我是客户端，服务器说：" + serverIfo);
//			}
			//关闭所有资源
//			bfr.close();
//			isr.close();
//			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		socketClient();
		BigDecimal bigDecimal1 = new BigDecimal(511.801800);
		BigDecimal bigDecimal2 = new BigDecimal(499.999998);
		BigDecimal bigDecimal3 = new BigDecimal(763.25);
		BigDecimal bigDecimal0 = new BigDecimal(1.05);
		BigDecimal bigDecimal4 = new BigDecimal(1.07);
		BigDecimal bigDecimal5 = new BigDecimal(1.10);
		BigDecimal bigDecimal6 = new BigDecimal(1.20);
//		System.out.println(bigDecimal1.add(bigDecimal2));
//		System.out.println(bigDecimal3.multiply(bigDecimal0));
//		System.out.println(bigDecimal3.multiply(bigDecimal4));
//		System.out.println(bigDecimal3.multiply(bigDecimal5));
//		System.out.println(bigDecimal3.multiply(bigDecimal6));
	}
	
//	Socket client;  
//    PrintWriter pw;  
//    public SocketClientDemo() throws UnknownHostException, IOException {  
//        client=new Socket("127.0.0.1",7777);  
//        pw=new PrintWriter(client.getOutputStream());  
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
//        pw.write(br.readLine());  
//        pw.close();  
//        br.close();  
//    }  
//    public static void main(String[] args) {  
//        try {  
//            new SocketClientDemo();  
//        } catch (UnknownHostException e) {  
//            e.printStackTrace();  
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        }  
//    }  
}
