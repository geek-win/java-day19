/*
 * 将异常信息输出到指定文件
 * */
import java.io.*;
import java.util.*;
import java.text.*;

class ExceptionDemo1
{
	public static void main(String[] args)
	{
		try
		{
			int[] arr = new int[2];
			System.out.println(arr[5]);
		}
		catch(Exception e)
		{
			try
			{
				//创建异常日志文件
				PrintStream ps = new PrintStream("err.txt");
				
				//获取发生异常的时间
				String time = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(new Date());
				ps.println(time);//将time打印到ps关联的文件中
				
				System.setOut(ps);
			}
			catch(Exception e1)
			{
				throw new RuntimeException("日志创建失败");
			}
			e.printStackTrace(System.out);//输出设备是err.txt
		}
	}
}
