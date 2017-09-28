/*
 * 将异常信息打印到指定文件
 * printStackTrace()将异常信息输出到标准输出设备即控制台
 * printStackTrace(PrintStream s)
 * 将异常信息输出到指定的输出流
 * printStackTrace(PrintWriter s)
 * 将异常信息输出到指定的PrintWriter
 * */
import java.io.*;
import java.text.*;
import java.util.*;

class ExceptionDemo
{
	public static void main(String[] args)
	{
		try
		{
			int[] arr = new int[2];
			System.out.println(arr[4]);
		}
		catch(Exception e)
		{
			//将异常信息输出到指定文件
			//创建异常日志信息文件
			try
			{
				//将日期添加到文件中
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  hh:mm:ss");
				String time = sdf.format(d);

				PrintStream ps = new PrintStream("err.txt");
				ps.println(time);//打印到指定内容中
				System.setOut(ps);
			}
			catch(Exception e1)
			{
				throw new RuntimeException("日志创建失败");
			}

			e.printStackTrace(System.out);
		}
	}

}
