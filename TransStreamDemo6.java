/*
 * 使用System.setIn()和System.setOut()
 * 就可以修改源和修改目的
 * */
import java.io.*;

class TransStreamDemo6
{
	public static void main(String[] args)throws IOException
	{
		//设置System.in
//		System.setIn(new FileInputStream("I.java"));

		//设置System.out
		System.setOut(new PrintStream("out.txt"));
		//默认是键盘录入
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		//默认是控制台，屏幕输出
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
	}
}
