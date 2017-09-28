/*
 * 装饰设计模式
 * 定义修饰类，用于对已有类的功能进行增强
 * 需要将已有类对象作为形式参数传入修饰类的构造函数
 * 并且基于已有类的方法进行功能增强
 * */
class Person
{
	public void eat()
	{
		System.out.println("吃饭了");
	}
}

class SuperPerson
{
	//要想对Person的方法进行增强
	//需要将其对象传入
	private Person p;

	SuperPerson(Person p)
	{
		this.p = p;
	}

	//增强eat方法
	public void superEat()
	{
		System.out.println("洗手");
		p.eat();

		System.out.println("甜点");
		System.out.println("散步");
	}
}

class XiuDemo
{
	public static void main(String[] args)
	{
		SuperPerson sp = new SuperPerson(new Person());
		sp.superEat();
	}
}
