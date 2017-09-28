/*
 * readLine()原理
 * 底层调用read()方法，内存中创建一个字符数组，作为缓冲区，
 * 调用read()方法，将字符依次存到数组中，直到遇到换行符，就不存到数组中了
 * 会将该数组转成字符串返回
 * */
import java.io.*;

//自定义，实现readLine方法
//自己实现BufferedRead的readLine方法
//需要创建一个新的类,其中有个方法，可以一次读一行，模拟readLine方法
class MyBufferedReader
{
	//一初始化就有个流对象进来
	private FileReader r;

	MyBufferedReader(FileReader r)
	{
		this.r = r;
	}
	
	public String myReadLine()throws Exception
	{
		//定义一个临时容器，原BufferedRead封装的是字符数组
		//为了方便演示，可以定义StringBuilder容器，因为最终还是要变成字符串
		StringBuilder sb = new StringBuilder();

		int ch = 0;
		while((ch = r.read()) != -1)
		{
			if(ch == '\n')
				return sb.toString();

			sb.append((char)ch);
		}
		
		return null;
	}

	public void myClose()throws Exception
	{
		if(r != null)
			r.close();
	}
}

class MyDemo
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args)throws Exception
	{
		MyBufferedReader mbufr = new MyBufferedReader(new FileReader("BufferedReaderDemo.java"));

		String line = null;

		while((line = mbufr.myReadLine()) != null)
			sop(line);

		mbufr.myClose();

	}
}

