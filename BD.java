import java.io.*;

class BD
{
	public static void main(String[] args)
	{
		//创建写入流对象和缓冲区
		FileWriter fw = null;
		BufferedWriter bufw = null;

		try
		{
			fw = new FileWriter("haha.txt");
			bufw = new BufferedWriter(fw);

			//向缓冲区写入数据
			for(int i = 0; i < 5; i++)
			{
				bufw.write("I love LL.");
				bufw.newLine();
				bufw.flush();
			}
		}
		catch(Exception e)
		{
			System.out.println("异常啦～～～");
			System.out.println(e.toString());
		}
		finally
		{
			if(bufw != null)
			{
				try
				{
					bufw.close();
				}
				catch(Exception e)
				{
					System.out.println("异常啦～～～");
					System.out.println(e.toString());
				}
			}
		}
	}
}
