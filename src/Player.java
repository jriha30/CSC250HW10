public class Player
{
	private String name;
	private int age;
	
	public Player(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public void display()
	{
		System.out.println(this.name + " (age " + this.age + ")");
	}
}