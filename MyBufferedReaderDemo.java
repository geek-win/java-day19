/*
 * 模拟BufferedReader类的readLine方法
 * 创建一个类，代替BufferedReader类
 * */
import java.io.*;

class MyBufferedReader1 extends Reader
{
	//该类的成员变量
	Reader r;

	//构造函数，因为是缓冲区，所以需要读取流对象作为参数传进去
	MyBufferedReader1(Reader r)
	{
		this.r = r;
	}

	//自定义读取行的函数
	public String myReadLine()throws IOException
	{
		StringBuilder sb = new StringBuilder();

		int ch = 0;
		while((ch = r.read()) != -1)
		{
			if(ch == '\n')
				return sb.toString();

			sb.append((char)ch);
		}

		//有可能读到了最后一行但是没有\n
		//那么需要判断sb是否是空的
		//如果不是空的就返回字符串
		//如果是空的就返回null
		if(sb.length() != 0)
			return sb.toString();

		return null;
	}

	//自定义关闭资源功能
	public void myClose()throws Exception
	{
		if(r != null)
			r.close();

	}

	//复写Reader中的抽象函数
	//1、close方法
	public void close()throws IOException
	{
		if(r != null)
			r.close();
	}

	//2、int read(char[] buf, int off, int len)
	public int read(char[] buf, int off, int len)throws IOException
	{
		return r.read(buf, off, len);
	}
}

class MyBufferedReaderDemo
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args)throws Exception
	{
		//创建读取缓冲区
		MyBufferedReader1 mbufr = new MyBufferedReader1(new FileReader("BufferedReaderDemo.java"));

		//逐行读取并输出
		String line = null;

		while((line = mbufr.myReadLine()) != null)
			sop(line);

		//关闭资源
		mbufr.myClose();
	}
}
