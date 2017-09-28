/*
 * 演示字节流的缓冲区
 * 通过字节流的缓冲区完成复制
 * BufferedInputStream
 * 字节流读取缓冲区
 * BufferedOutputStream
 * 字节流写入缓冲区
 * */
import java.io.*;

class MyBufferedInputStream
{
	private InputStream in;
	private byte[] buf = new byte[1024];
	private int pos = 0, count = 0;

	MyBufferedInputStream(InputStream in)
	{
		this.in = in;
	}

	public int myRead()throws IOException
	{
		//首先判断字节数组中是否有数据
		//如果有就读取
		//如果没有就把文件数据读到数组中
		if(count == 0)
		{
			count = in.read(buf);//count就是将in关联文件读取到buf中的长度

			//说明没有数据了
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

	public void close()throws IOException
	{
		in.close();
	}
}
class Huan
{
	public static void main(String[] args)throws IOException
	{
		long start = System.currentTimeMillis();
		copy();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static void copy()throws IOException
	{
		//创建字节流读取缓冲区
		MyBufferedInputStream bufis = new MyBufferedInputStream(new FileInputStream("/home/zhshuang/桌面/p1.png"));
		//创建字节流写入缓冲区
		BufferedOutputStream buos = new BufferedOutputStream(new FileOutputStream("/home/zhshuang/桌面/p3.png"));

		int ch = 0;
		while((ch = bufis.myRead()) != -1)
			buos.write(ch);

		bufis.close();
		buos.close();


	}
}
