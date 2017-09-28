/*
 * boolean canExecute()
 * 判断抽象路径表示的文件是否可执行
 * */
import java.io.*;
import java.util.*;


class FileDemo3
{
	public static void main(String[] args)throws IOException
	{
		File f = new File("aaa.txt");
		File f1 = new File("FileDemo.java");

		System.out.println("f.canExecute(): "+f+"--"+f.canExecute());
		System.out.println("f1.canExecute(): "+f1+"--"+f1.canExecute());
		System.out.println("f.exists(): "+f.exists());

		File d = new File("./file");
		System.out.println("创建目录："+d.mkdir());
		File f2 = new File(d, "a.txt");
		f2.createNewFile();//创建f2
		String[] s = d.list();
		System.out.println("目录下的文件："+Arrays.toString(s));
		
		//创建多级目录
		File d1 = new File("abc/haha/hehe");
		System.out.println("创建多级目录："+d1+"--"+d1.mkdirs());
		File f3 = new File(d1, "hhh.txt");
		System.out.println("f3.createNewFile():"+f3+"--"+f3.createNewFile());

		//判断是否是文件是否是目录
		System.out.println("f是否是目录："+f.isDirectory());
		System.out.println("d1是否是目录："+d1.isDirectory());
		System.out.println("f是否存在："+f.exists()+"f是否是文件: "+f.isFile());

		//判断是否是绝对路径
		//不管是否已经被创建
		//只是判断其对应的路径名称是否是绝对路径
		File f4 = new File("/a.txt");
		System.out.println("f4 = "+f4);
		System.out.println("f4是否是绝对路径："+f4.isAbsolute());
	}
}
