package Mini_Project;
import java.util.*;
import java.time.*;
import java.time.format.*;

class Time
{
	public static String currentTime()
	{
		LocalDateTime t=LocalDateTime.now();
		DateTimeFormatter tp=DateTimeFormatter.ofPattern("dd-mm-yy hh-mm-ss");
		String ct=tp.format(t);
		return ct;
	}
}

abstract class staffs
{
	private String id;
	private String name;
	private boolean signedIn;
	
	staffs(String id,String name)
	{
		this.id=id;
		this.name=name;
		this.signedIn=false;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	abstract public void signIn();
	
	abstract public void signOut();
	
	public boolean isSignedIn()
	{
		return signedIn;
	}
	
	public void setisSignedIn(boolean signedIn)
	{
		this.signedIn=signedIn;
	}
}

class csStaffs extends staffs
{
	csStaffs(String id,String name)
	{
		super(id,name);
	}
	
	public void signIn()
	{
		setisSignedIn(true);
		System.out.println("CS staff "+getName()+" with staff-id "+getId()+" signed  in at "+Time.currentTime()+"\n");
	}
	
	public void signOut()
	{
		if(isSignedIn())
		{
			setisSignedIn(false);
			System.out.println("CS staff "+getName()+" with staff-id "+getId()+" signed  out at "+Time.currentTime()+"\n");
		}
		else
		{
			System.out.println("CS staff " + getName() + " with staff id " + getId() + " has not signed in yet.\n");
		}
	}
}

class aimlStaffs extends staffs
{
	aimlStaffs(String id,String name)
	{
		super(id,name);
	}
	
	public void signIn()
	{
		setisSignedIn(true);
		System.out.println("AIML staff "+getName()+" with staff-id "+getId()+" signed  in at "+Time.currentTime()+"\n");
	}
	
	public void signOut()
	{
		if(isSignedIn())
		{
			setisSignedIn(false);
			System.out.println("AIML staff "+getName()+" with staff-id "+getId()+" signed  out at "+Time.currentTime()+"\n");
		}
		else
		{
			System.out.println("AIML staff " + getName() + " with staff id " + getId() + " has not signed in yet.\n");
		}
	}
}

class eceStaffs extends staffs
{
	eceStaffs(String id,String name)
	{
		super(id,name);
	}
	
	public void signIn()
	{
		setisSignedIn(true);
		System.out.println("ECE staff "+getName()+" with staff-id "+getId()+" signed  in at "+Time.currentTime()+"\n");
	}
	
	public void signOut()
	{
		if(isSignedIn())
		{
			setisSignedIn(false);
			System.out.println("ECE staff "+getName()+" with staff-id "+getId()+" signed  out at "+Time.currentTime()+"\n");
		}
		else
		{
			System.out.println("ECE staff " + getName() + " with staff id " + getId() + " has not signed in yet.\n");
		}
	}
}

class isStaffs extends staffs
{
	isStaffs(String id,String name)
	{
		super(id,name);
	}
	
	public void signIn()
	{
		setisSignedIn(true);
		System.out.println("IS staff "+getName()+" with staff-id "+getId()+" signed  in at "+Time.currentTime()+"\n");
	}
	
	public void signOut()
	{
		if(isSignedIn())
		{
			setisSignedIn(false);
			System.out.println("IS staff "+getName()+" with staff-id "+getId()+" signed  out at "+Time.currentTime()+"\n");
		}
		else
		{
			System.out.println("IS staff " + getName() + " with staff id " + getId() + " has not signed in yet.\n");
		}
	}
}

class Biometrics
{
	private staffs[] Staffs;
	
	Biometrics()
	{
		this.Staffs=new staffs[0];
	}
	
	public void addStaff(staffs Staff)
	{
		staffs[] newStaff=Arrays.copyOf(Staffs,Staffs.length+1);
		newStaff[Staffs.length]=Staff;
		Staffs=newStaff;
	}
	
	public void SignIn(String id)
	{
		for(staffs x:Staffs)
		{
			if(x.getId().equals(id))
			{
				x.signIn();
				return;
			}
		}
		System.out.println("Staff with staff-id "+id+" not found!!!\n");
	}
	
	public void SignOut(String id)
	{
		for(staffs x:Staffs)
		{
			if(x.getId().equals(id))
			{
				x.signOut();
				return;
			}
		}
		System.out.println("Staff with staff-id "+id+" not found!!!\n");
	}
}

public class staffBiometrics 
{
	public static void main(String[] args)
	{
		String id;
		int choice;
		Scanner sc=new Scanner(System.in);
		
		Biometrics biometrics=new Biometrics();
		csStaffs cstaff1=new csStaffs("CS001","Manish");
		aimlStaffs astaff1=new aimlStaffs("AI001","Joseph");
		eceStaffs estaff1=new eceStaffs("EC001","Abin");
		isStaffs istaff1=new isStaffs("IS001","Rahul");
		
		biometrics.addStaff(cstaff1);
		biometrics.addStaff(astaff1);
		biometrics.addStaff(estaff1);
		biometrics.addStaff(istaff1);
		
		while(true)
		{
			System.out.println("1.Sign in\n2.Sign out\n3.Exit");
			choice=sc.nextInt();
			
			switch(choice)
			{
				case 1 : System.out.println("Enter staff-id:");
						 id=sc.next();
						 biometrics.SignIn(id);
						 break;
						
				case 2 : System.out.println("Enter staff-id:");
						 id=sc.next();
						 biometrics.SignOut(id);
						 break;
						
				case 3 : return;
				
				default: System.out.println("INVALID CHOICE");
			}
		}
		
	}
}