/*
 * 模拟
 * BufferedReader
 * 底层调用的就是Reader的read方法，封装了字符数组，然后存储read读到的一行内容
 * 这就是readLine的原理
 * LineNumberReader
 * */
import java.io.*;

class MyBufferedReader2 extends Reader
{
	//是个装饰类
	//用来对字符流读取流对象的读取速度进行加速
	//所以内部应该有个字符流读取流对象
	//并且继承了Reader类
	private Reader r;

	MyBufferedReader2(Reader r)
	{
		this.r = r;
	}

	//复写关闭功能
	public void close()throws IOException
	{
		if(r != null)
			r.close();
	}

	//复写read方法
	public int read(char[] buf, int off, int len)throws IOException
	{
		return r.read(buf, off, len);
	}

	//实现readLine方法
	public String myReadLine()throws IOException
	{
		//无论是读取文本行还是多个字符
		//底层调用的都是read方法
		//底层有个字符数组用来存储文本行
		char[] buf = new char[1024];
		int point = 0;//指针

		int ch = 0;
		while((ch = r.read()) != -1)
		{
			if(ch == '\n')
				return new String(buf, 0, point);

		    buf[point++] = (char)ch;
		}

		if(point != 0)
			return new String(buf, 0, point);

		return null;
	}
}

class LineNumberReader2 
{
	//内部有一个字符流读取流对象
	//应该有行号
	private Reader r;
	private int lineNumber;

	LineNumberReader2(Reader r)
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

	//读取文本行
	//每读一行，行号就加一
	public String myReadLine()throws IOException
	{
		//行号+1
		lineNumber++;

		int ch = 0;
		StringBuilder sb = new StringBuilder();

		while((ch = r.read()) != -1)
		{
			if(ch == '\n')
				return sb.toString();

			sb.append((char)ch);
		}

		if(sb.length() > 0)
			return sb.toString();

		return null;
	}

	//关闭资源
	public void myClose()throws IOException
	{
		if(r != null)
			r.close();
	}
}

class LineNumberReader3 extends MyBufferedReader2
{
	//内容有行号和字符流读取流对象
	//父类中有字符流读取流对象
	//所以这里可以不进行设置
	//但是构造函数要有体现

	private int lineNumber;
	
	LineNumberReader3(Reader r)
	{
		super(r);
	}

	//设置行号
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}

	//获取当前行号
	public int getLineNumber()
	{
		return this.lineNumber;
	}

	//读取文本行
	public String myReadLine()throws IOException
	{
		lineNumber++;

		return super.myReadLine();
	}
}

class LineNumberReaderDemo
{
	public static void main(String[] args)
	{
		//对MyBufferedReader2进行测试
		MyBufferedReader2 mybuf = null;

		//对LineNumberReader2进行测试
		LineNumberReader2 l2 = null;
		
		//对LineNumberReader3进行测试
		LineNumberReader3 l3 =null;

		try
		{
			mybuf = new MyBufferedReader2(new FileReader("A.java"));
			l2 = new LineNumberReader2(new FileReader("A.java"));
			l3 = new LineNumberReader3(new FileReader("A.java"));

			/*
			//读取行
			String line = null;
			while((line = mybuf.myReadLine()) != null)
				System.out.println(line);
			*/

			/*
			//读取行号和文本行
			String line = null;
			l2.setLineNumber(100);
			while((line = l2.myReadLine()) != null)
				System.out.println(l2.getLineNumber()+"--"+line);
		    */

			//读取行号和文本行
			String line = null;
			l3.setLineNumber(20);
			while((line = l3.myReadLine()) != null)
				System.out.println(l3.getLineNumber()+"  "+line);
		}
		catch(IOException e)
		{
			System.out.println("读取异常");
		}
		finally
		{
			if(mybuf != null)
			{
				try
				{
					mybuf.close();
				}
				catch(IOException e)
				{
					System.out.println(e.toString());
				}
			}

			if(l2 != null)
			{
				try
				{
					l2.myClose();
				}
				catch(IOException e)
				{
					System.out.println(e.toString());
				}
			}

			if(l3 != null)
			{
				try
				{
					l3.close();
				}
				catch(IOException e)
				{
					System.out.println(e.toString());
				}
			}
		}
	}
}
