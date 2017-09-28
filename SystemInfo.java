/*
 * IO流
 * 系统信息
 * */
import java.io.*;
import java.util.*;

class SystemInfo
{
	public static void main(String[] args)
	{
		Properties prop = System.getProperties();

		try
		{
			prop.list(new PrintStream("system.txt"));
		}
		catch(Exception e)
		{
			e.printStackTrace(System.out);
		}

		//Properties有个功能
		//是list(PrintStream out)
		//将属性列表打印到指定的输出流
//		prop.list(System.out);
//		System.out.println(prop);
//		}
	}
}
