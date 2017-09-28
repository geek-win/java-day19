/*
 * 创建UDP通信
 * 发送端
 * 1、创建UDPsocket服务，作为发送端
 * DatagramSocket
 * 2、确定要发送的信息，byte数组，并封装成数据报包
 * DatagramPacket
 * 确定目标主机的IP地址和端口号
 * 3、通过socket服务的send服务将信息发送到目的地
 * 4、关闭资源
 * 接收端
 * 1、创建UDPsocket服务，作为接收端
 * DatagramSocket
 * 2、创建缓冲区，并封装成数据报包，用来存储收到的数据包
 * DatagramPacket
 * 3、通过socket服务的receive方法接收数据到缓冲区
 * 4、通过数据报包的方法获取数据包的内容
 * 5、关闭资源
 * */
import java.io.*;
import java.net.*;

class UdpSend
{
	public static void main(String[] args)throws Exception
	{
		//创建udpsocket服务，作为发送端
		DatagramSocket ds = new DatagramSocket(6666);

		/*
		//确定要发送的内容并封装成数据报包
		byte[] buf = "I love Yulu Bai.".getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 8888);

		//发送数据报包到目的主机
		ds.send(dp);
*/

		//将键盘录入的内容发送到目标主机
		//所以需要使用IO流
		//源就是键盘录入
		//检测键盘录入的内容，并且封装成数据报包
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			DatagramPacket dp = new DatagramPacket(line.getBytes(), line.length(), InetAddress.getLocalHost(), 8888);
			
			ds.send(dp);
		}


		//关闭资源
		ds.close();
	}
}

class UdpReceive
{
	public static void main(String[] args)throws Exception
	{
		//创建udpsocket服务，作为接收端
		DatagramSocket ds = new DatagramSocket(8888);


		while(true)
		{
			//创建缓冲区，封装成数据报包，用来存储接收到的数据包
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);

			//通过udp服务的receive功能接收数据包
			ds.receive(dp);

			//通过dp的方法获取各个信息
			String ip = dp.getAddress().getHostAddress();
			int port = dp.getPort();
			String data = new String(dp.getData(), 0, dp.getLength());

			System.out.println("ip = "+ip);
			System.out.println("port = "+port);
			System.out.println("data = "+data);
		}

		//关闭资源
//		ds.close();
	}
}
