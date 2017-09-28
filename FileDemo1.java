/*
 * 文件的方法练习
 * 1、创建
 * boolean createNewFile()//创建新的文件，如果已经存在就返回false，否则true
 * boolean createTempFile(String prefix, String suffix)//创建空的临时文件
 * boolean createTempFile(String prefix, String suffix, File directory)//创建临时文件，并且设置前缀后缀名以及目录
 * 2、删除
 * boolean delete()//删除成功就是true，否则就是false
 * void deleteOnExit()//为了防止异常跳转而无法删除垃圾文件
 * 可以使用该方法，表示在程序结束后删除该文件
 * 
 * */
import java.io.*;
class FileDemo1
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args)throws IOException
	{
		File f = new File("abc.txt");

		sop("create abc.txt: "+f.createNewFile());
		sop("delete abc.txt: "+f.delete());

		File d = new File("/home");
		File f1 = File.createTempFile("temp", "temp", d);
		//f1.deleteOnExit();//当程序结束后删除
	}
}
