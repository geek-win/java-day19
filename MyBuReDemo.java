/*
 * 模拟BufferedReader类
 * 定义和readLine方法相同的函数
 * 用于读取文件的行文本数据
 * */
import java.io.*;

//模拟BufferedReader类
//一初始化应该传入读取流对象
//为了让读取流对象在整个类中有意义
//定义成成员变量
class MyB
{
	private FileReader r;

	MyB(FileReader r)
	{
		this.r = r;
	}

	//逐行读取文本行
	public String myReadLine()throws IOException
	{
		//定义缓冲区数组，用来存储行文本数据
		char[] buf = new char[1024];

		int point = 0;
		int ch = 0;
		while((ch = r.read()) != -1)
		{
			if(ch == '\n')
				return new String(buf, 0, point);

			buf[point++] = (char)ch;
		}

		//如果是最后一行没有换行符的话，就需要判断数组长度是否是0
		//如果不是0就直接返回字符串
		if(point > 0)
			return new String(buf, 0, point);

		return null;
	}

	//关闭资源
	public void myClose()throws IOException
	{
		if(r != null)
			r.close();
	}
}

class MyBuReDemo
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args)throws IOException
	{
		MyB m = new MyB(new FileReader("BufferedReaderDemo.java"));

		String line = null;
		while((line = m.myReadLine()) != null)
			sop(line);

		m.myClose();
	}
}
