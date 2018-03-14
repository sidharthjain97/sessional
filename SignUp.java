import java.util.*;

public class SignUp{
	String name;
	String date;

	String password;
	int id,f,fr;
	static int count=1;
	static int count_f=0;
	static int count_fr=0;
	Scanner o=new Scanner(System.in);
	ArrayList<SignUp> friend=new ArrayList<SignUp>(10);
	ArrayList<SignUp> friend_request=new ArrayList<SignUp>(10);
	ArrayList<SignUp> user=new ArrayList<SignUp>(10);
	//SignUp s=new SignUp();
	//SignUp[] friend=new SignUp(10);
	//SignUp[] friend_request=new SignUp(10);
	SignUp(){}

	SignUp(String name,String date,int id,String password){
		this.name=name;
		this.date=date;
		this.id=count;	
		this.password=password;
	//	SignUp[] friend=new SignUp(10);
	//SignUp[] friend_request=new SignUp(10);
	//	friend=new ArrayList<SignUp>(10);
	//	friend_request=new ArrayList<SignUp>(10);

	}
	void home(){
		
		char ch;
		do{
			System.out.println("1. Sign Up");
			System.out.println("2. Sign In");
			System.out.println("3. exit");
			System.out.println("enter your choice:");
			int a=o.nextInt();

			switch (a) {
				case 1:	System.out.println("Enter your name:");
						name=o.next();
						System.out.println("enter your date of birth:");
						date=o.next();
						System.out.println("your id is :"+count);
						System.out.println("enter your password:");
						password=o.next();
						create(name,date,count,password);
						break;

				case 2:	System.out.println("enter yur unique id:");
						id=o.nextInt();
						System.out.println("enter your password");
						password=o.next();
						sign_in(id,password);
						break;

				case 3:	System.exit(0);
						break;
				default:	System.out.println("wrong choice entered");
			}

		}while(true);

	} 

	void sign_in(int id,String password){
		
		int flag=0;
		for(int i=0;i<user.size();i++){
			if(id==(user.get(i)).id && user.get(i).password.equals(password)){
				System.out.println("Successfully logged in");
				flag=1;
				break;
			}
		}
		if(flag==0){
			System.out.println("wrong id or password");
			System.out.println("enter again:");
			home();
		}
		else{
			menu();
		}
	}

	void create(String name,String date,int id,String password){
		SignUp a=new SignUp(name,date,id,password);
		user.add(a);
		count++;
		System.out.println("user created");
	}

	void menu(){
		char ch;
		do{
			System.out.println("1. Add friend");
			System.out.println("2. inbox");
			System.out.println("3. sent message");
			System.out.println("4. upcoming friend request");
			System.out.println("5. total number of friends");
			System.out.println("6. logout");
		
			System.out.println("enter your choice:");
			int a=o.nextInt();

			switch (a) {
				case 1:	System.out.println("enter the name:");
						name=o.next();
						add_friend(name);
						break;
				case 2:	
						break;
				case 3: 
						break;
				case 4:	System.out.println(">>>>>FRIEND REQUESTS<<<<<");
						for(int i=0;i<friend_request.size();i++){
							System.out.println(friend_request.get(i).name+" ");
						} 
						break;
				case 5: System.out.println(">>>>>FRIENDs<<<<<");
						System.out.println(friend); 
						break;
				case 6:	home();
						break;

				default:	System.out.println("wrong choice entered");
			}
		}while(true);
	}

	void add_friend(String name){
		
		/*String l=user.get(0).name;
		String m=user.get(1).name;
		System.out.println(l);
		System.out.println(m);*/
		int flag=0;
		for(int i=0;i<user.size();i++){
			if((user.get(i).name).equals(name)){
				flag=1;
				//System.out.println("hello");
				break;
			}
		}
		if(flag==0){
			System.out.println("user not exist");
			System.out.println("enter again");
			return;
		}
		int flag1=0;
		
			for(int i=0;i<friend_request.size();i++){
				//System.out.println("hello22");
				if(((friend_request.get(i)).name).equals(name)){
					friend.add(friend_request.get(i));
					flag1=1;
					//f++;
					friend_request.remove(friend_request.get(i));
				}
				
			}
			if(flag1==0){
				//		System.out.println("hello3333");
						sent_request(this.name);
			}
		
	}

	void sent_request(String name){
		int i;
		for(i=0;i<user.size();i++){
			//System.out.println("sent");
			if(((user.get(i)).name).equals(name)){
				break;
			}
		}
			//System.out.println("sent1111");
		friend_request.add(user.get(i));
		//fr++;
	}	
}