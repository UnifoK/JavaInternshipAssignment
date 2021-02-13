package assignment;

import java.util.*;

class table{
	String name=null,type=null;
	int qty=0,price=0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
		
}

class Data
{
   String name,type;
   int qty,price;

  public Data(String name,String type,int qty,int price)
   {
	   this.name=name;
	   this.type=type;
	   this.qty=qty;
	   this.price=price;

   }

public String getName() {
	return name;
}


public String getType() {
	return type;
}

public int getQty() {
	return qty;
}

public int getPrice() {
	return price;
}
  
}

public class JIA {

public static double tax(int price,String Type)
 {double temp = 0.1*price;
		if(Type.equalsIgnoreCase("Raw"))
			return 0.125*price;
			
		else if(Type.equalsIgnoreCase("Manufactured"))
			return 0.125*price+0.02*(price+0.125*price);
		else if(Type.equalsIgnoreCase("Imported"))
		{if(temp<=100)
			return (0.1*price+5);
		else if(temp>100 && temp<=200)
		{
			return temp+10;
		}
		else
		{
			return 0.05*price+temp;
		}
		}
		return 0;
	}

public static void main(String[] args)
{System.out.println("Assignment By Sazid!\n");
ArrayList<Data> items= new ArrayList<Data>();
 Scanner sc=new Scanner(System.in);
 char ch='y';
 
 table obj1 = new table();
 while(ch=='y') 
 {
	 System.out.println("\nEnter the Command from Following"+"\nName"+"\nType"+"\nQuantity"+"\nPrice\nNote: If its the Starting of New Data, Select Name First!\n");
 System.out.print("Command: ");
 String command=sc.next();
 if(command.equalsIgnoreCase("name"))
	 {
	 System.out.print("Name= ");
	 String name= sc.next();
	 obj1.setName(name);
	
		 while(obj1.price==0 || obj1.qty==0 || obj1.type==null)
		 {	 System.out.print("Next Command: ");
		 command=sc.next();

	 	 if(command.equalsIgnoreCase("type"))
	 	 {  System.out.print("Type= ");
	 	 	 String type=sc.next();
	 	 	 obj1.setType(type);
	 	 }
				 
	 	 else if(command.equalsIgnoreCase("quantity"))
	 	 {System.out.print("Quantity= ");
		 int qty=sc.nextInt();
		 obj1.setQty(qty);
	 	 }
	 	 else if(command.equalsIgnoreCase("price"))
	 	 {System.out.print("Price= ");
		 int price=sc.nextInt();
		 obj1.setPrice(price);
	 	 }
		 }
		 items.add(new Data(obj1.name,obj1.type,obj1.qty,obj1.price));	 
		 }
	
 else 
	 System.out.println("Put the name first!");
obj1.name=null;
obj1.price=0;
obj1.qty=0;
obj1.type=null;
 System.out.print("Do you want to enter details of any other item (y/n):" );
 ch=sc.next().charAt(0);
 

 
 }
 for(Data item: items)
 {double temp=tax(item.getPrice(),item.getType());
	 System.out.println("\nName: "+item.getName());
	 System.out.println("Price: "+item.getPrice());
	 System.out.println("Sales Tax: "+temp);
	 System.out.println("Final Price: "+(item.getPrice()+temp)*item.getQty());
	 
 }
  sc.close();
}
}
