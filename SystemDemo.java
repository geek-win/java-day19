/*
 * 测试System的Properties能否在jvm启动的时候添加新的属性并可以被访问
 * */
import java.util.*;

class SystemDemo
{
	public static void main(String[] args)
	{
		Properties prop = System.getProperties();

		System.out.println(prop.get("hhh"));
	}
}
