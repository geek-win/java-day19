/*
 * 练习字节流的读取和写入
 * 字节流的基类是InputStream，读取数据，输入流
 * OutputStream，写入数据，输出流
 * InputStream
 *	|--FileInputStream
 *  |--FilterInputStream
 *		|--BufferedInputStream
 * OutputStream
 *  |--FileOutputStream
 *  |--FilterOutputStream
 *		|--BufferedOutputStream
 * */
import java.io.*;

//模板设计
abstract class S1
{
	public void getTime()
	{
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();

		System.out.println(end-start);
	}

	public abstract void code();
}
class S2 extends S1
{
	/*
	//复制文本文件
	public static void code()throws IOException
	{
		//创建字节流文件读取对象
		FileInputStream fis = new FileInputStream("A.java");
		
		//创建字节流文件写入对象
		FileOutputStream fos = new FileOutputStream("P.java");

		//对源文件进行读取
		int ch = 0;
		while((ch = fis.read()) != -1)
			fos.write(ch);

		fis.close();
		fos.close();

		//读取图片
		FileInputStream fis = new FileInputStream("/home/zhshuang/桌面/p1.png");
		FileOutputStream fos = new FileOutputStream("/home/zhshuang/桌面/4.png");

		//通过数组来缓存图片信息存到目标文件中
		byte[] buf = new byte[fis.available()];
		fis.read(buf);
		fos.write(buf);

		fis.close();
		fos.close();
	}
*/
	//通过字节流缓冲区进行文件的复制
	//字节流读取缓冲区:BufferedInputStream
	//字节流写入缓冲区:BufferedOutputStream
	public void code()
	{
		//创建字节流读取缓冲区
		BufferedInputStream bufis = null;

		//创建字节流写入缓冲区
		BufferedOutputStream bufos = null;

		try
		{
			bufis = new BufferedInputStream(new FileInputStream("/home/zhshuang/桌面/p1.png"));
			bufos = new BufferedOutputStream(new FileOutputStream("/home/zhshuang/桌面/5.png"));

			//读到缓冲区中
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = bufis.read(buf)) != -1)
				bufos.write(buf, 0, len);
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			if(bufis != null)
			{
				try
				{
					bufis.close();
				}
				catch(IOException e)
				{
					System.out.println(e.toString());
				}
			}
			if(bufos != null)
			{
				try
				{
					bufos.close();
				}
				catch(IOException e)
				{
					System.out.println(e.toString());
				}
			}
		}
	}
}

class StreamDemo
{
	public static void main(String[] args)
	{
		new S2().getTime();
	}

}
