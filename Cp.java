/*
 * 复制文件
 * */
import java.io.*;

class Cp
{
	public static void main(String[] args)throws IOException
	{
//System.setIn(new FileInputStream("I.java"));

		System.setOut(new PrintStream("a.txt"));
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
	}
}
