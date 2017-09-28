/*
 * 复制图片
 * 因为是媒体文件
 * 所以我们需要使用字节流
 *
 * */
import java.io.*;

class Co
{
	public static void main(String[] args)throws IOException
	{
		//创建字节流读取缓冲区，和原图片关联
//		BufferedInputStream bufin = new BufferedInputStream(new FileInputStream("/home/zhshuang/桌面/p1.png"));
		BO bufin = new BO(new FileInputStream("/home/zhshuang/桌面/p1.png"));

		//创建字节流写入缓冲区，和目标图片文件相关联
		BufferedOutputStream bufout = new BufferedOutputStream(new FileOutputStream("/home/zhshuang/桌面/7.png"));

		int ch = 0;
		while((ch = bufin.read()) != -1)
			bufout.write(ch);

		bufin.close();
		bufout.close();
	}
}

//自己创建字节流读取缓冲区类
class BO
{
	private InputStream in;
	private byte[] buf = new byte[1024];
	private int pos = 0, count = 0;

	BO(InputStream in)
	{
		this.in = in;
	}

	//读取字节
	//首先将文件内容从硬盘读取到内容缓冲区
	//然后从缓冲区依次读取
	public int read()throws IOException
	{
		if(count == 0)
		{
			count = in.read(buf);//通过InputStream的read(buf)方法将文件内容读到buf中
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
