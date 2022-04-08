import java.util.*;
public class employee {
	private int empno;
	private String ename;
	private int salary;
	
	employee(int empno, String ename, int salary){
		this.empno=empno;
		this.ename=ename;
		this.salary=salary;
	}
	
	public int getEmpno() {
		return empno;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public int getEname() {
		return ename;
	}
	
	public String toString() {
		return empno+" "+ename+" "+salary;
	}
	
	public static void main(String[] args) {
		List<employee> c=new ArrayList<employee>();
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		int ch;
		do {
			System.out.println("1. INSERT");
			System.out.println("2. DISPLAY");
			System.out.println("3. SEARCH");
			System.out.println("4. DELETE");
			System.out.println("5. UPDATE");
			System.out.print("Enter your choice: ");
			
			ch=sc.nextInt();
			
			switch(ch) {
			
			case 1:
				System.out.println("Enter Employee number: ");
				int eno=sc.nextInt();
				System.out.println("Enter Employee name: ");
				String ename=sc1.nextLine();
				System.out.println("Enter Salary: ");
				int salary=sc.nextInt();
				
				c.add(new employee(eno,ename,salary));
			break;
			
			case 2:
				System.out.println("--------------------------");
				Iterator<employee> i=c.iterator();
				while(i.hasNext()) {
					employee e=i.next();
					System.out.println(e);
				}
				System.out.println("--------------------------");
			break;
			
			case 3:
				boolean found=false;
				System.out.println("Enter employee number to search: ");
				int empno=sc.nextInt();
				System.out.println("--------------------------");
				i=c.iterator();
				while(i.hasNext()) {
					employee e=i.next();
					if(e.getEmpno()==empno) {
					System.out.println(e);
					found=true;
					}
				}
				if(!found)
					System.out.println("Record not found");
				System.out.println("--------------------------");
			break;
			
			case 4:
				found=false;
				System.out.println("Enter employee number to delete: ");
				empno=sc.nextInt();
				System.out.println("--------------------------");
				i=c.iterator();
				while(i.hasNext()) {
					employee e=i.next();
					if(e.getEmpno()==empno) {
					i.remove();;
					found=true;
					}
				}
				if(!found)
					System.out.println("Record not found");
				else
					System.out.println("Record deleted successfully");
				System.out.println("--------------------------");
			break;
			
			case 5:
				found=false;
				System.out.println("Enter employee number to update: ");
				empno=sc.nextInt();
				System.out.println("--------------------------");
				ListIterator<employee> li=c.listIterator();
				while(li.hasNext()) {
					employee e=li.next();
					if(e.getEmpno()==empno) {
						System.out.println("Enter new name:");
						ename=sc1.next();
						
						System.out.println("Enter new salary");
						salary=sc.nextInt();
						li.set(new employee(empno, ename, salary));
					found=true;
					}
				}
				if(!found)
					System.out.println("Record not found");
				System.out.println("--------------------------");
			break;
			}
		}while(ch!=0);
	}

}
