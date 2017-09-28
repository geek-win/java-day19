/*
 * LineNumberReader类是BufferedReader的子类
 * 所以我们现在模拟
 * 产生LineNumberReader类相似的类
 * */
import java.io.*;

class MyL extends MyBufferedReader1
{
	private int lineNumber;

	MyL(Reader r)
	{
		super(r);
	}

	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}

	public int getLineNumber()
	{
		return this.lineNumber;
	}

	//获取一行
	public String myReadLine()throws IOException
	{
		lineNumber++;

		return super.myReadLine();
	}

	//关闭资源
}

class MyLDemo
{
	public static void main(String[] args)throws IOException
	{
		MyL myl = new MyL(new FileReader("BufferedReaderDemo.java"));

		String line = null;

		while((line = myl.myReadLine()) != null)
			System.out.println(myl.getLineNumber()+"  "+line);

		myl.close();
	}
}
