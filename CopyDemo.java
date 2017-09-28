/*
 * 通过缓冲区实现文本文件的复制
 * */
import java.io.*;


class CopyDemo
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args)
	{
		//创建写入流缓冲区，用于提高数据的写入效率
		//创建读取流缓冲区，用于提高数据的读取效率
		BufferedReader bufr = null;
		BufferedWriter bufw = null;

		//创建实体，需要对异常进行处理
		try
		{
			//构造函数中传入文件读取流对象
			//并和源文件进行关联
			//构造函数中传入文件写入流对象
			//并和目标文件相关联
			bufr = new BufferedReader(new FileReader("BufferedReaderDemo.java"));
			bufw = new BufferedWriter(new FileWriter("A.java"));

			/*
			//逐个字符遍历源文件的内容
			int num = 0;
			while((num = bufr.read()) != -1)
			{
				bufw.write(num);
			}
			*/

			/*
			//通过字符数组缓冲区将源文件复制到目的文件
			int len = 0;
			char[] ch = new char[1024];
			while((len = bufr.read(ch)) != -1)
			{
				bufw.write(ch, 0, len);
			}
			*/

			//通过逐行读取的方式将源文件复制到目标文件
			String line = null;
			while((line = bufr.readLine()) != null)
			{
				bufw.write(line);
				bufw.newLine();
				bufw.flush();
			}
		}
		catch(Exception e)
		{
			sop("缓冲区创建读写异常啦");
			sop(e.toString());
		}
		finally
		{
			if(bufr != null)
			{
				try
				{
					bufr.close();
				}
				catch(Exception e)
				{
					sop("bufr关闭异常啦");
					sop(e.toString());
				}
			}
			if(bufw != null)
			{
				try
				{
					bufw.close();
				}
				catch(Exception e)
				{
					sop("bufw关闭异常啦");
					sop(e.toString());
				}
			}
		}

	}

}
