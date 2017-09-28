/*
 * BufferedReader是Reader的子类
 * 读取流缓冲区是用来提高读取流对象的读取效率的
 * 所以创建读取流缓冲区之前需要创建读取流对象
 * 使用读取流缓冲区的方法可以读取文本文件的数据
 * */
import java.io.*;

class BufferedReaderDemo
{
	public static void main(String[] args)throws Exception
	{
		//创建文件读取流对象，和被读的文本文件相关联
		FileReader fr = new FileReader("BufferedWriterDemo.java");

		//创建读取流缓冲区，用来提高读取流的读取数据的效率
		BufferedReader bufr = new BufferedReader(fr);

		/*
		//通过缓冲区的读取方法读取数据
		int ch;
		while((ch = bufr.read())!=-1)
			System.out.print((char)ch);
		*/

		/*
		//逐行读取文本文件的内容
		String str = null;
		while((str = bufr.readLine()) != null)
			System.out.println(str);
*/

		//将文本内容读到缓冲数组中
		char[] ch = new char[1024];
		int len = 0;

		while((len = bufr.read(ch)) != -1)
			System.out.print(new String(ch, 0, len));
		
		//关闭资源
		bufr.close();
	}

}
