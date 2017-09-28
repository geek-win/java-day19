/*
 * BufferedWriter是Writer的子类
 * 表示写入流缓冲区，用来提高写入流的效率。缓冲区的出现提高了数据的写入和读取效率
 * 创建缓冲区之前必须先创建要提高效率的流对象，因为缓冲区是为了提高流对象的效率存在的，所以创建缓冲区之前必须要有流对象
 * FileWriter fw = new FileWriter("hh.txt");
 * BufferedWriter bufw = new BufferedWriter(fw);//bufw是用来提高fw的写入效率的
 * bufw.write(str/char[], int off, int len/str, int off, int len/char c/char[]);
 *	将数据写入缓冲区
 * bufw.flush();将数据从缓冲区写入文件中
 * bufw.close();关闭缓冲区，其实就是关闭被提高效率的流对象，所以可以不用关闭流对象
 *
 *
 * */
import java.io.*;

class BufferedWriterDemo
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args)throws Exception
	{
		//创建文件写入流，和被写的文件相关联
		FileWriter fw = new FileWriter("haha.txt");

		//创建写入流缓冲区，用来提高写入流fw的写入效率
		BufferedWriter bufw = new BufferedWriter(fw);

		char[] ch = "I love LL.".toCharArray();
		//将内容写到缓冲区中
	    for(int i = 0; i < 5; i++)
		{
			bufw.write("agagfa");
			bufw.newLine();//添加行分隔符
			bufw.write(ch);
			bufw.newLine();
			bufw.flush();//将缓冲区中的数据写入文件中，防止断电
		}

		//关闭缓冲区流
		//其实就是关闭被提高效率的写入流对象
		//所以写入流对象就不需要再关闭了
		bufw.close();
	}
}

