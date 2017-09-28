/*
 * 练习
 * */
import java.io.*;
class Exe
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	/*
	//通过不同的方式将文件复制
	public static void copyTxt()
	{
		//创建文件写入流和文件读取流
		FileReader fr = null;
		FileWriter fw = null;

		try
		{
			fr = new FileReader("BufferedReaderDemo.java");
			fw = new FileWriter("B.java");

			int ch = 0;
			while((ch = fr.read()) != -1)
			{
				fw.write(ch);
				fw.flush();
			}

		
			char[] buf = new char[1024];
			int len = 0;
			while((len = fr.read(buf)) != -1)
			{
				fw.write(buf, 0, len);
				fw.flush();
			}
		


		}
		catch(IOException e)
		{
			sop("读写异常");
			sop(e.toString());
		}
		finally
		{
			if(fr != null)
			{
				try
				{
					fr.close();
				}
				catch(IOException e)
				{
					sop("fr关闭异常");
					sop(e.toString());
				}
			}
			if(fw != null)
			{
				try
				{
					fw.close();
				}
				catch(IOException e)
				{
					sop("fw关闭异常");
					sop(e.toString());
				}
			}
		}

	}
	*/

	//通过缓冲区技术实现文件的复制
	//BufferedReader和BufferedWriter
	public static void copyBu()
	{
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader bufr = null;
		BufferedWriter bufw = null;

		try
		{
			bufr = new BufferedReader(new FileReader("BufferedReaderDemo.java"));
			bufw = new BufferedWriter(new FileWriter("C.java"));

			//使用缓冲区的读取行的方法读取并复制
			String line = null;

			while((line = bufr.readLine()) != null)
			{
				bufw.write(line);
				bufw.newLine();
				bufw.flush();
			}
		}
		catch(IOException e)
		{
			sop("读写异常");
			sop(e.toString());
		}
		finally
		{
			try
			{
				if(bufr != null)
					bufr.close();
			}
			catch(IOException e)
			{
				sop("bufr关闭异常");
				sop(e.toString());
			}
			finally
			{
				try
				{
					if(bufw != null)
						bufw.close();
				}
				catch(IOException e)
				{
					sop("bufw关闭异常");
					sop(e.toString());
				}

			}
		}

	}
	public static void main(String[] args)
	{
		copyBu();

	}
}
