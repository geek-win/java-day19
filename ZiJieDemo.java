/*
 * 字符流
 * FileReader
 * FileWriter
 *
 * BufferedReader
 * BufferedWriter
 *
 * 字节流：
 * 操作的数据都是字节数据。其实字符流操作的也是字节数据，只是有编码表
 * FileWriter和FileReader使用的编码表使用的是默认的,System.getProperties()可以获取
 * 默认编码表
 * 现在想操作图片等媒体数据
 * 可以使用字节流。
 * 需求：想要操作图片数据，这时就要用到字节流。
 * 字节流体系中能操作文件的对象：FileInputStream、FileOutputStream
 * 字节流中的两个基类，凡是输出的是写，OutputStrean
 * void close();
 * void write(byte[] b)
 * void write(int b)
 * void write(byte[] b, int off, int len)//将指定数组b中的off开始的len内容存到文件中
 *
 * 
 * */
import java.io.*;

class ZiJjieDemo
{
	public static void main(String[] args)throws IOException
	{
		writeFile();
//		readFile1();
//		readFile2();
		readFile3();
	}

	//字节流的写入功能
	public static void writeFile()throws IOException
	{
		//创建文件写入流
		FileOutputStream fos = new FileOutputStream("hh.txt");

		//写入内容
		byte[] buf = "abcded\n\n".getBytes();
		fos.write(buf);

		//关闭资源
		fos.close();
	}

	//字节流的读取功能
	public static void readFile1()throws IOException
	{
		//创建文件读取流
		FileInputStream fis = new FileInputStream("hh.txt");

		//逐个字节读取文件内容
		int ch = 0;
		while((ch = fis.read()) != -1)
			System.out.println((char)ch);

		fis.close();
	}

	//字节流的读取功能
	//读到字节数组中
	public static void readFile2()throws IOException
	{
		//创建文件读取流对象
		//字节流
		FileInputStream fis = new FileInputStream("hh.txt");

		//创建缓冲区数组，用来存储内容
		byte[] buf = new byte[1024];

		int len = 0;
		while((len = fis.read(buf)) != -1)
			System.out.print(new String(buf, 0, len));

		fis.close();
	}

	//这种方法不是特别恰当
	//字节流的读取功能
	//使用available方法
	public static void readFile3()throws IOException
	{
		//创建文件读取流，字节流
		FileInputStream fis = new FileInputStream("hh.txt");

		//使用available方法获取该文件的字节数
		//创建同等大小的字节数组即可
		//available方法返回的是文件中估计的字节数
		//字节流可以操作媒体文件
		//如果是电影等，特别大，available方法返回的数很大
		//如果new数组可能会内存溢出
		//虚拟机启动默认是64M
		//虽然可以调整虚拟机内存大小。但是如果文件大小超过了内存容量，就会溢出
		//如果数据不大可以使用该方法
		//所以最好使用定义1024×n的数组
		byte[] buf = new byte[fis.available()];

		System.out.println(fis.available());
		fis.read(buf);

		System.out.print(new String(buf));

		fis.close();
	}
}
