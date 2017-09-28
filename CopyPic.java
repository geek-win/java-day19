/*
 *
 * 复制图片
 * 思路：
 * 1、用字节读取流对象关联图片文件，作为复制的源文件
 * 2、用字节写入流对象创建图片文件，用来存储收到的文件，作为目标文件
 * 3、通过循环读写，完成数据的复制
 * 4、关闭资源
 * */
import java.io.*;

class CopyPic
{
	public static void main(String[] args)
	{
		copyPic();

	}

	//复制图片文件
	//1、用字节读取流对象关联图片文件，作为源文件
	//2、用字节写入流对象创建图片文件，用来存储收到的图片数据，作为目标文件
	//3、通过循环读取，完成数据的复制
	//4、关闭资源
	public static void copyPic()
	{
		//创建字节流读取对象关联图片文件，作为源文件
		//以桌面的图片文件为源文件
		FileInputStream fis = null;
		//用字节流写入对象创建图片文件，作为目的文件
		FileOutputStream fos = null;

		try
		{
			//字节流读取对象
			fis = new FileInputStream("/home/zhshuang/桌面/p1.png");
			//fis = new FileInputStream("BufferedReaderDemo.java");
			//字节流写入对象
			fos = new FileOutputStream("Y.java");

			/*
			//通过字节流读取对象的读取功能读取图片文件数据
			//写入字节流写入对象对应的目标文件
			int ch = 0;
			while((ch = fis.read()) != -1)
				fos.write(ch);
			*/

			//通过字节流读取对象的读取功能读取图片文件数据
			//通过字节数组写入目标文件
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = fis.read(buf)) != -1)
				fos.write(buf, 0, len);
		}
		catch(IOException e)
		{
			System.out.println("读写异常");
			System.out.println(e.toString());
		}
		finally
		{
			if(fis != null)
			{
				try
				{
					fis.close();
				}
				catch(IOException e)
				{
					System.out.println(e.toString());
				}
			}

			if(fos != null)
			{
				try
				{
					fos.close();
				}
				catch(IOException e)
				{
					System.out.println(e.toString());
				}
			}
		}
	}
}
