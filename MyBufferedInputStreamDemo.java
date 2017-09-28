/*
 * 自定义字节流读取缓冲区
 * 内部的变量有：
 * 1、字节流读取流对象，用来操作文件
 * 2、字节数组缓冲区
 * 3、指针和计数器
 */
import java.io.*;

class MyBufferedInputStream1
{
	private InputStream in;
	private byte[] buf = new byte[1024*5];
	private int pos = 0, count = 0;

	MyBufferedInputStream1(InputStream in)
	{
		this.in = in;
	}

	//自定义读取方法
	//首先通过提高读取效率的字节流读取流对象的read(buf)
	//将关联文件内容从硬盘读取到缓冲区数组中
	//然后通过字节流读取缓冲区的read方法从缓冲区中读取
	//而不是从硬盘中读取，效率高
	public int myRead()throws IOException
	{
		//如果字节数组中没有元素，即长度为0
		if(count == 0)
		{
			count = in.read(buf);

			if(count < 0)
				return -1;

			pos = 0;
			byte b = buf[pos];
			pos++;
			count--;
			return b&255;
		}
		else if(count > 0)
		{
			byte b = buf[pos];
			pos++;
			count--;
			return b&255;
		}
		return -1;
	}

	//关闭资源
	public void myClose()throws IOException
	{
		if(in != null)
			in.close();
	}
}

class MyBufferedInputStreamDemo
{
	public static void main(String[] args)throws IOException
	{
		//字节流读取缓冲区
		MyBufferedInputStream1 mybufis = new MyBufferedInputStream1(new FileInputStream("/home/zhshuang/桌面/p1.png"));

		//字节流写入缓冲区
		BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("/home/zhshuang/桌面/6.png"));
		
		int ch = 0;
		while((ch = mybufis.myRead()) != -1)
			bufos.write(ch);

		mybufis.myClose();
		bufos.close();
	}
}
