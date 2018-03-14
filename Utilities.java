import java.util.Scanner;

class Utilities{
	static int messin=0;
	static int messout=0;
	static int f=0;
	static int fr=0;
	SignUp s=new SignUp();
	SignUp[] user=new SignUp[10];
	
	Scanner o=new Scanner(System.in);
	//Utilities[] inbox=new Utilities[10];

	SignUp[] friend=new SignUp[10];
	SignUp[] friend_request=new SignUp[10];
	Utilities(){}
	Utilities(SignUp ob){

	}

	void add_friend(){
		SignUp obj1=new SignUp();
		System.out.print("\n enter the friend name:");

		String name=o.next();
		
			for(int i=0;i<(s.i);i++){
				System.out.println("true");
				System.out.println(name);
				
				String var=user[i].name;
				System.out.println("\n\n"+var);
				if(name.equals(s.name)){
					System.out.println("true222");
					obj1=user[i];
					break;
				}
				/*else{
					System.out.println("\n user doesnot exist.");
					System.out.println("\n enter again:");
					add_friend();
				}*/
			}

		for(int i=0;i<fr;i++){
			if((friend_request[i].name).equals(name)){
				
				friend[f]=obj1;
				f++;
				System.out.println("friend added");
				for(int j=i+1;j<fr;j++){
					friend_request[i]=friend_request[i+1];
				}
				fr--;
			}
			else{
				sent_request(obj1);		
				System.out.println("request sent");
			}
		}
	}

	void sent_request(SignUp ob){
		friend_request[fr]=ob;
		fr++;
		System.out.println("friend request sent");	
	}
	void total_friends(){
		System.out.println("\nFriend list:");
		for(int i=0;i<=f;i++)
			System.out.println("\n"+this.friend[i]);
	}

	void inbox(){
			System.out.println(">>>>>>INBOX<<<<<<");
		for(int i=0;i<messin;i++){
			System.out.println(s.messagein[i]);
		}	
	}
	void sent_message(){
		System.out.println("\n enter name to whom you want to send the message:");
		String name=o.next();
		SignUp obj1=new SignUp();
		for(int i=0;i<s.i;i++){
			if((s.user[i].name).equals(name)){
				obj1=s.user[i];
				break;
			}
			else{
				System.out.println("\n wrong user name");
				sent_message();
			}
		}
		System.out.println("\n enter the message:");
		String message=o.next();
		obj1.messagein[messin]=message;
		messin++;
	}
	void logout(){
		home();
	}
	void disp(){
		int n;
		char ch;
		String name;
		
		
		do
		{
			System.out.println("\n1. add friend");
			System.out.println("\n2. inbox");
			System.out.println("\n3. sent messagein");
			System.out.println("\n4. upcoming friend request");
			System.out.println("\n5. total number of friends");
			System.out.println("\n6. logout");
			n=o.nextInt();
			switch(n){
				case 1:	add_friend();
						break;

				case 2:	inbox();
						break;
				case 3:	sent_message();
						break;
				case 4:	System.out.println("\n Friend Requests:");
						for(int i=0;i<fr;i++){
							System.out.println(friend_request[i]);
						}
						break;
				case 5:	this.total_friends();
						break;
				case 6:	logout();		
						break;
				default:	System.out.println("\nWrong choice entered");
			}
			System.out.println("\ndo you want to continue (enter y or Y):");
			ch=o.next().charAt(0);
		}while(ch=='y'||ch=='Y');

	}
	void home(){
		int n,id;
		String password,name,date;
		char ch;
		//Scanner o=new Scanner(System.in);
		
		do
		{
			System.out.println("\n1. Sign in");
			System.out.println("\n2. Sign up");
			
			n=o.nextInt();
			switch(n){
				case 1:	System.out.println("\nEnter the Unique id:");
						id=o.nextInt();
						System.out.println("\nEnter the password:");
						password=o.next();
						SignIn si=new SignIn(id,password,s.user);
						break;

				case 2:	System.out.println("\nEnter your name:");
						name=o.next();
						System.out.println("\nEnter your dob:");
						date=o.next();
						System.out.println("\nEnter your id:");
						id=o.nextInt();
						System.out.println("\nEnter password:");
						password=o.next();
						s.create(name,date,id,password);
						break;
				
				default:	System.out.println("\nWrong choice entered");
									
			}
			System.out.println("\ndo you want to continue (enter y or Y):");
			ch=o.next().charAt(0);
		}while(ch=='y'||ch=='Y');		
	}
	


}

class Run{
	public static void main(String[] args) {
		Utilities ho=new Utilities();
		ho.home();
		
	}
}