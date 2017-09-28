/*
 * IO流的练习
 * */
import java.io.*;
import java.util.*;
import java.text.*;

class Io
{
	public static void main(String[] args)throws Exception
	{
//		System.setIn(new FileInputStream("I.java"));

		System.setOut(new PrintStream("log.txt"));
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;
		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
		bufw.close();

		//获取属性信息
		Properties prop = System.getProperties();
		prop.list(new PrintStream("prop.txt"));

		try
		{
			int[] arr = new int[2];
			System.out.println(arr[6]);
		}
		catch(Exception e)
		{
			PrintStream ps = new PrintStream("exception.txt");
			String time = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(new Date());
			ps.println(time);
			System.setOut(ps);
			e.printStackTrace(System.out);
		}
		
	}
}
