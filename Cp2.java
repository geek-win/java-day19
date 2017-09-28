/*
 * 自己实现BufferedReader
 * LineNumberReader
 * BufferedInputStream
 * */
import java.io.*;
import java.util.*;
import java.text.*;

class MBufferedReader extends Reader
{
	//需要被装饰的字符读取流对象
	private Reader r;

	MBufferedReader(Reader r)
	{
		this.r = r;
	}

	//读取文本行
	public String myReadLine()throws IOException
	{
		//创建缓冲区，存储文本行
		char[] buf = new char[1024];
		int pos = 0;

		int ch = 0;
		while((ch = r.read()) != -1)
		{
			if(ch == '\n')
			{
				return new String(buf, 0, pos);
			}
			else
				buf[pos++] = (char)ch;
		}
		if(pos > 0)
			return new String(buf, 0, pos);

		return null;
	}

	//复写抽象函数
	public int read(char[] buf, int off, int len)throws IOException
	{
		return r.read(buf, off, len);
	}

	//复写抽象函数
	public void close()throws IOException
	{
		if(r != null)
			r.close();
	}
}

class MLineNumberReader
{
	private Reader r;
	private int lineNumber;

	MLineNumberReader(Reader r)
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
	public String myReadLine()throws IOException
	{
		//每读一行，行号+1
		lineNumber++;

		char[] buf = new char[1024];
		int pos = 0;

		int ch = 0;

		while((ch = r.read()) != -1)
		{
			if(ch == '\n')
			{
				return new String(buf, 0, pos);
			}
			else
				buf[pos++] = (char)ch;
		}
		if(pos > 0)
			return new String(buf, 0, pos);
		return null;
	}

	//关闭资源
	public void myClose()throws IOException
	{
		if(r != null)
			r.close();
	}
}

class MLineNumberReader1 extends MBufferedReader
{
	private int lineNumber;

	MLineNumberReader1(Reader r)
	{
		super(r);
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
	public String myReadLine()throws IOException
	{
		lineNumber++;

		return super.myReadLine();
	}
}

class MBufferedInputStream
{
	//其中应该有字节读取流
	//缓冲区字节数组
	//指针，计数器
	private InputStream in;
	private byte[] buf = new byte[1024];
	private int pos = 0, count = 0;

	MBufferedInputStream(InputStream in)
	{
		this.in = in;
	}

	//读的方法
	public int myRead()throws IOException
	{
		//首先判断缓冲区是否是空的
		//如果是空的，需要将文件数据导入缓冲区
		//如果不是空的，就直接读取
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
	public void close()throws IOException
	{
		if(in != null)
			in.close();
	}

}


class Cp2
{
	public static void main(String[] args)
	{
		//创建字符流读取缓冲区
		MBufferedReader mybufr = null;
		//创建字节流读取缓冲区
		MBufferedInputStream mybufin = null;
		//创建LineNumberReader
		MLineNumberReader myline = null;
		MLineNumberReader1 myline1 = null;

		//字节输出流和字符输出流
		BufferedOutputStream bufout = null;
		BufferedWriter bufw = null;

		try
		{
			mybufr = new MBufferedReader(new InputStreamReader(System.in))	;
			mybufin = new MBufferedInputStream(new FileInputStream("I.java"));
			myline = new MLineNumberReader(new FileReader("I.java"));
			myline1 = new MLineNumberReader1(new FileReader("I.java"));

			//对应屏幕输出
			bufw = new BufferedWriter(new OutputStreamWriter(System.out));

			//在进行文件复制的时候，输入和输出流应该对应存在
			//不可以字符流和字节流对应，会出问题
			bufout = new BufferedOutputStream(System.out);
			/*
			String line = null;
			myline.setLineNumber(100);
			while((line = myline.myReadLine()) != null)
			{
				if("over".equals(line))
					break;

				bufw.write(myline.getLineNumber()+"--"+line);
				bufw.newLine();
				bufw.flush();				
			}
			*/
			int ch = 0;
			while((ch = mybufin.myRead()) != -1)
			{
				bufout.write(ch);
			//	bufout.flush();
			}

			
		}
		catch(IOException e)
		{
			try
			{
				//创建打印输出流用来存储异常信息
				PrintStream ps = new PrintStream("err.log");
				//获取异常发生的时间
				String time = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(new Date());
				ps.println(time);

				//把异常信息输出到ps对应的文件中
				e.printStackTrace(ps);
			}
			catch(IOException e1)
			{
				throw new RuntimeException("打印流输出异常");
			}
		}
		finally
		{
			if(mybufr != null)
			{
				try
				{
					mybufr.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			if(mybufin != null)
			{
			
				try
				{
					mybufin.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			if(myline != null)
			{
				try
				{
					myline.myClose();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			if(myline1 != null)
			{
				try
				{
					myline1.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			if(bufout != null)
			{
				try
				{
					bufout.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			if(bufw != null)
			{
				try
				{
					bufw.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}

