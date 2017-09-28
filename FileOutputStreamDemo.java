/*
 * 字节流
 * */
import java.io.*;

class FileOutputStreamDemo
{
	public static void main(String[] args)throws IOException
	{
		/*
		writeFile();
		readFile_1();
		*/
		readFile_3();
	}

	public static void writeFile()throws IOException
	{
		//创建文件写入字节流
		FileOutputStream fos = new FileOutputStream("hh.txt");

		//将内容传入数据
		byte[] buf = "abcdefgh".getBytes();

		fos.write(buf);

		fos.close();

	}
	public static void readFile_1()throws IOException
	{
		//创建文件读取流
		FileInputStream fis = new FileInputStream("hh.txt");

		//逐个读取
		int ch = 0;
		while((ch = fis.read()) != -1)
			System.out.print((char)ch);

		fis.close();
	}
	
	public static void readFile_2()throws IOException
	{
		//创建文件读取流对象
		FileInputStream fis = new FileInputStream("hh.txt");

		//将内容存到数组中
		//因为是字节流，所以创建的都是字节数组
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = fis.read(buf)) != -1)
			System.out.println(new String(buf, 0, len));

		//关闭资源
		fis.close();
	}

	public static void readFile_3()throws IOException
	{
		FileInputStream fis = new FileInputStream("hh.txt");

		int num = fis.available();
		byte[] b = new byte[num];
		fis.read(b);
		System.out.println(new String(b));

	}
}
