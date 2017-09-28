/*
 * 复习IO流
 * 1、面对需求如何创建流对象？
 * 1）根据需求确定源和目的
 *		源：输入流，读取，Reader或者InputStream。
 *		目的：输出流，写入，Writer或者OutputStream
 * 2）根据是否是纯文本确定使用哪个大类。
 *		是纯文本，选择字符流对象。Reader和Write
 *		不是纯文本，比如图片、视频、音频等媒体文件，选择字节流，InputStream和OutputStream
 * 3）体系确定后，根据设备确定具体使用哪个对象
 *		源：内存、硬盘（文件）、键盘
 *		目的：内存、硬盘（文件）、屏幕（控制台）
 * */
import java.io.*;

class TotalEx
{
	public static void main(String[] args)throws IOException
	{
		/*
		//需求一
		//将键盘录入的内容输出到屏幕
		//源：键盘录入
		//目的：屏幕即控制台
//		System.setIn(new FileInputStream("I.java"));
//		System.setOut(new PrintStream("out.txt"));
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
*/

		/*
		//需求二
		//将键盘录入读到文件中
		//源：键盘录入
		//目的：文本文件，Writer。FileWriter。BufferedWriter
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw = new BufferedWriter(new FileWriter("out.txt"));
		*/

		/*
		//需求三
		//将文本文件读到屏幕上
		//源：文本文件，Reader，FileReader，BufferedReader
		//目的：屏幕，字节流，但是想使用读取字符串，所以可以转换成字符流
		//OutputStreamWriter
		BufferedReader bufr = new BufferedReader(new FileReader("I.java"));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

*/
		/*
		//需求三
		//将文本文件复制到文本文件
		//源：InputStream或者Reader，文本文件，选择Reader字符流，设备是文件，FileReader，提高读取效率。BufferedReader
		//目的：OutputStream或者Writer，文本文件，选择Writer字符流，设备是文件，FileWriter，提高写入效率，OutputStreamWriter
		BufferedReader bufr = new BufferedReader(new FileReader("I.java"));
		BufferedWriter bufw = new BufferedWriter(new FileWriter("out.txt"));
*/

		/*
		//需求四
		//将图片文件复制到图片
		//源：InputStream或者Reader，不是文本文件，InputStream，FileInputStream。提高效率BufferedInputStream
		//目的：OutputStream或者Writer，不是文本文件，OutputStream，FileOutputStream。提高效率BufferOutputStream
		BufferedInputStream bufr = new BufferedInputStream(new FileInputStream("/home/zhshuang/桌面/p1.png"));
		BufferedOutputStream bufw = new BufferedOutputStream(new FileOutputStream("/home/zhshuang/桌面/5.png"));
		
		int ch = 0;
		while((ch = bufr.read()) != -1)
			bufw.write(ch);
*/


		//需求五
		//将文本文件打印到另一个文本文件
		//并且指定编码表
		//源：InputStream或者Reader。文本文件，Reader。FileReader。但是要求指定编码表，所以要使用转换流。读取转换流。InputStreamReader(InputStream in, String charsetName).提高效率使用缓冲区
		//目的：OutputStream或Writer。文本文件，Writer，FileWriter。但是要求指定编码表，所以使用转换流，写入转换流。OutputStreamWriter(OutStream out, String charsetName)。提高效率使用缓冲区
//		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("I.java"), "GBK"));
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));

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
