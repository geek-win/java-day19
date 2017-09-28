/*
 * 复制图片
 * 源：输入流，图片字节流，InputStream。文件FileInputStream。加速BufferedInputStream
 * 目的：输出流，图片字节流。OutputStream，文件FileOutputStream，加速BufferedOutputStream
 * */
import java.io.*;

class D
{
	public static void main(String[] args)
	{
		BufferedInputStream bufin = null;
		BufferedOutputStream bufout = null;

		try
		{
			bufin = new BufferedInputStream(new FileInputStream("/home/zhshuang/桌面/p1.png"));
			bufout = new BufferedOutputStream(new FileOutputStream("/home/zhshuang/桌面/10.png"));

			//缓冲区
			byte[] buf = new byte[bufin.available()];
			bufin.read(buf);
			bufout.write(buf);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(bufin != null)
			{
				try
				{
					bufin.close();
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
		}
	}
}
