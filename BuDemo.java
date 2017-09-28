/*
 * 自己实现BufferedReader类的模拟类
 * FileReader有read方法但是效率低
 * 所以可以创建装饰类，将要修饰的类传入其构造函数，并且增强功能
 * */
import java.io.*;

//创建LineNumberReader类的模拟类并且继承了BuReader
class LineN1 extends BuReader
{
	private int lineNumber;

	//传入要提高效率的读取流对象
	LineN1(Reader r)
	{
		super(r);
	}

	//设置行号
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}

	//获取行
	public int getLineNumber()
	{
		return this.lineNumber;
	}

	//读取一行
	public String myReadLine()throws IOException
	{
		//每读一行行号就会自增1
		lineNumber++;

		//调用父类的读一行的方法
		return super.myReadLine();
	}
}


//创建LineNumberReader类的模拟类
class LineN
{
	//行号
	private int lineNumber;
	private Reader r;

	//构造函数
	//传入读取流
	LineN(Reader r)
	{
		this.r = r;
	}

	//设置行号
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}

	//获取行号
	public int getLineNumber()
	{
		return this.lineNumber;
	}

	//读取一行
	public String myReadLine()throws IOException
	{
		//读取一次，行号加1
		lineNumber++;

		//设置缓冲区的数组
		char[] buf = new char[1024];

		int ch = 0;

		//其实就是存入数组中的有效个数
		int point = 0;

		while((ch = r.read()) != -1)
		{
			if(ch == '\n')
				return new String(buf, 0, point);

			buf[point++] = (char)ch;
		}

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

//创建装饰类
//将需要功能增强的类对象传入其构造函数
//基于已有类的方法，提高加强功能，该类称为装饰类
class BuReader extends Reader
{
	//要有被操作的读取流对象
	private Reader r;

	BuReader(Reader r)
	{
		this.r = r;
	}

	//读取行
	public String myReadLine()throws IOException
	{
		//创建缓冲区
		char[] buf = new char[1024];
		int ch = 0;
		int point = 0;

		while((ch = r.read()) != -1)
		{
			if(ch == '\n')
				return new String(buf, 0, point);

			buf[point++] = (char)ch;
		}

		//当数组中有内容时，就需要返回其字符串形式
		if(point > 0)
			return new String(buf, 0, point);

		return null;
	}

	//关闭资源
	public void close()throws IOException
	{
		if(r != null)
			r.close();
	}

	//复写Reader的read方法
	public int read(char[] buf, int off, int len)throws IOException
	{
		return r.read(buf, off, len);
	}

}

class BuDemo
{
	public static void main(String[] args)
	{
		/*
		BuReader bufr = null;

		try
		{
			bufr = new BuReader(new FileReader("BufferedReaderDemo.java"));

			String line = null;

			while((line = bufr.myReadLine()) != null)
			{
				System.out.println(line);
			}
		}
		catch(IOException e)
		{
			System.out.println("bufr读取异常");
			System.out.println(e.toString());
		}
		finally
		{
			if(bufr != null)
			{
				try
				{
					bufr.close();
				}
				catch(IOException e)
				{
					System.out.println("bufr关闭异常");
					System.out.println(e.toString());
				}
			}
		}
		*/
		/*

		//读取文件及其行号
		//其实LineNumberReader就是比BufferedReader多了个读取行号的方法
		LineN l = null;

		try
		{
			l = new LineN(new FileReader("BufferedReaderDemo.java"));

			String line = null;

			l.setLineNumber(100);
			while((line = l.myReadLine()) != null)
				System.out.println(l.getLineNumber()+"  "+line);

		}
		catch(IOException e)
		{
			System.out.println("l读取异常");
			System.out.println(e.toString());
		}
		finally
		{
			if(l != null)
			{
				try
				{
					l.myClose();
				}
				catch(IOException e)
				{
					System.out.println("l关闭异常");
					System.out.println(e.toString());
				}
			}
		}
		*/

		//利用LineN1获取文件内容和行号
		LineN1 l = null;

		try
		{
			l = new LineN1(new FileReader("BufferedReaderDemo.java"));

			String line = null;
			l.setLineNumber(20);

			while((line = l.myReadLine()) != null)
				System.out.println(l.getLineNumber()+"  "+line);
		}
		catch(IOException e)
		{
			System.out.println("l异常了");
			System.out.println(e.toString());
		}
		finally
		{
			if(l != null)
			{
				try
				{
					l.close();
				}
				catch(IOException e)
				{
					System.out.println("关闭异常");
					System.out.println(e.toString());
				}
			}
		}

	}

}
