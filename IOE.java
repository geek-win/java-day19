/*
 * Exception和IO流的结合
 * */
import java.io.*;
import java.text.*;
import java.util.*;

class IOE
{
	public static void main(String[] args)
	{
		/*
		//异常信息输出到指定文件
		try
		{
			int[] arr = new int[2];
			System.out.println(arr[8]);
		}
		catch(Exception e)
		{
			//当有异常发生的时候创建打印输出流，用来存储异常信息
			try
			{
				PrintStream ps = new PrintStream("syslog.txt");
				
				//获取异常发生的时间
				String time = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(new Date());
				ps.println(time);//将time输出到ps关联的文件
				System.setOut(ps);
				System.out.println("HHHHHHHH");
				e.printStackTrace(ps);//把异常信息存储到ps关联的文件
			}
			catch(Exception e1)
			{
				throw new RuntimeException("创建文件失败");
			}
		}
		*/


		Properties prop = System.getProperties();
		prop.list(System.out);
		/*
		try
		{
			PrintStream ps1 = new PrintStream("properties.txt");
			prop.list(ps1);
		}
		catch(Exception e2)
		{
			throw new RuntimeException("创建异常");
		}
		*/

		
	}
}
