package moodleassignment_2;

public class TypeCasting_And_typeConversions {
	
	public static void main(String[] args) {

		int a = 120;
		double b =  a;   //implicit type cast(smaller to bigger data type)

		System.out.println("a="+ a);
System.out.println("The double value of in a is "+b);
double d= 18.72;
int c = (int)d;      //explicit type cast (bigger to smaller data type)
System.out.println("d ="+ d);
System.out.println("trancated value of d is " + c);
	}

}
