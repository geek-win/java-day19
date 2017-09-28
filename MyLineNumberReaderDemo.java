/*
 * 自定义LineNumberReader类
 * 其中有行号和读取流对象
 * */
import java.io.*;

class MyLineNumberReader
{
	//私有变量
	private int lineNumber;
	private Reader r;

	//构造函数
	//需要传入读取流对象
	MyLineNumberReader(Reader r)
	{
		this.r = r;
	}

	//设置行号
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}

	//返回行号
	public int getLineNumber()
	{
		return this.lineNumber;
	}

	//读取行
	public String myReadLine()throws IOException
	{
		//一读取行，行号会加一
		lineNumber++;

		StringBuilder sb = new StringBuilder();

		int ch = 0;

		while((ch = r.read()) != -1)
		{
			if(ch == '\n')
				return sb.toString();

			sb.append((char)ch);
		}

		if(sb.length() != 0)
			return sb.toString();

		return null;
	}

	public void myClose()throws IOException
	{
		r.close();
	}
}

class MyLineNumberReaderDemo
{
	public static void main(String[] args)throws IOException
	{
		//创建MyLineNumberReader对象
		//打印文件的行号和内容
		MyLineNumberReader mylnr = new MyLineNumberReader(new FileReader("BufferedReaderDemo.java"));

		String line = null;

		while((line = mylnr.myReadLine()) != null)
			System.out.println(mylnr.getLineNumber()+"  "+line);

		mylnr.myClose();
	}
}
