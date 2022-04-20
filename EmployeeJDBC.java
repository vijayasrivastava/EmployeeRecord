import java.sql.*;
import java.util.*;

public class EmployeeJDBC {
	public static void main(String[] args) throws Exception{
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/","root123","root123");
		Statement st = con.createStatement();
		st.execute("USE EMPLOYEE");
		
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
				System.out.println("Enter employee id: ");
				int eno=sc.nextInt();
				String query="SELECT COUNT(*) FROM EMPDATA WHERE ID="+eno;
				st.executeQuery(query);
				ResultSet rs = st.getResultSet();
				rs.next();
				int id_found=rs.getInt(1);
				if(id_found>0){
				System.out.println("Employee id already exists");}
				else {
				
				System.out.println("Enter employee first name: ");
				String efirstname=sc1.nextLine();
				System.out.println("Enter employee last name: ");
				String elastname=sc1.nextLine();
				System.out.println("Enter company name");
				String ecom=sc1.nextLine();
				System.out.println("Enter address");
				String eadd=sc1.nextLine();
				System.out.println("Enter city");
				String ecity=sc1.nextLine();
				System.out.println("Enter county");
				String ecounty=sc1.nextLine();
				System.out.println("Enter postal");
				String epostal=sc1.nextLine();
				System.out.println("Enter phone");
				String ephone=sc1.nextLine();
				System.out.println("Enter email");
				String eemail=sc1.nextLine();
				System.out.println("Enter web");
				String eweb=sc1.nextLine();
				
				query="INSERT INTO EMPDATA(ID,FIRST_NAME,LAST_NAME,COMPANY_NAME,ADDRESS,CITY,COUNTY,POSTAL,PHONE,EMAIL,WEB) VALUES ("+eno+", '"+efirstname+"','"+elastname+"','"+ecom+"','"+eadd+"','"+
						ecity+"','"+ecounty+"','"+epostal+"','"+ephone+"','"+eemail+"','"+eweb+"')";
				
				st.executeUpdate(query);
				
				System.out.println("Employee data has been inserted");
				}
			break;
				
			
			case 2:
				System.out.println("--------------------------");
				query="SELECT * FROM EMPDATA";
				ResultSet rs2=st.executeQuery(query);
				rs2.next();
				do {
					System.out.println(rs2.getString(1)+","+rs2.getString(2)+","+rs2.getString(3)+","+rs2.getString(4)+","+rs2.getString(5)+","+rs2.getString(6)+","+rs2.getString(7)+","+rs2.getString(8)+","+rs2.getString(9)+","+rs2.getString(10)+","+rs2.getString(11)+".");
				}while(rs2.next());
				System.out.println("--------------------------");
			break;
			
			case 3:
				boolean found=false;
				System.out.println("Enter employee number to search: ");
				int empno=sc.nextInt();
				System.out.println("--------------------------");
				query="SELECT COUNT(*) FROM EMPDATA WHERE ID="+empno;
				st.executeQuery(query);
				rs = st.getResultSet();
				rs.next();
				id_found=rs.getInt(1);
				if(id_found>0){
					System.out.println("Employee with the following details found:");
					query="SELECT * FROM EMPDATA WHERE ID="+empno;
					rs2=st.executeQuery(query);
					rs2.next();
					System.out.println(rs2.getString(1)+","+rs2.getString(2)+","+rs2.getString(3)+","+rs2.getString(4)+","+rs2.getString(5)+","+rs2.getString(6)+","+rs2.getString(7)+","+rs2.getString(8)+","+rs2.getString(9)+","+rs2.getString(10)+","+rs2.getString(11)+".");
				}
				else
					System.out.println("Employee with this id is not found");
				System.out.println("--------------------------");
			break;
			
			case 4:
				
				System.out.println("Enter employee number to delete: ");
				empno=sc.nextInt();
				query="SELECT COUNT(*) FROM EMPDATA WHERE ID="+empno;
				st.executeQuery(query);
				rs = st.getResultSet();
				rs.next();
				id_found=rs.getInt(1);
				if(id_found<0) {
					System.out.println("Employee with id not found.");
				}
				else {
					query="DELETE FROM EMPDATA WHERE ID="+empno;
					st.executeUpdate(query);
					System.out.println("Employee details successfully deleted.");
				}
				System.out.println("--------------------------");
			break;
			
			case 5:
				System.out.println("Enter employee number to update: ");
				empno=sc.nextInt();
				System.out.println("--------------------------");
				query="SELECT COUNT(*) FROM EMPDATA WHERE ID="+empno;
				st.executeQuery(query);
				rs = st.getResultSet();
				rs.next();
				id_found=rs.getInt(1);
				if(id_found<0) {
					System.out.println("Employee with id not found.");
				}
				else {
					System.out.println("Enter employee first name: ");
					String efirstname=sc1.nextLine();
					System.out.println("Enter employee last name: ");
					String elastname=sc1.nextLine();
					System.out.println("Enter company name");
					String ecom=sc1.nextLine();
					System.out.println("Enter address");
					String eadd=sc1.nextLine();
					System.out.println("Enter city");
					String ecity=sc1.nextLine();
					System.out.println("Enter county");
					String ecounty=sc1.nextLine();
					System.out.println("Enter postal");
					String epostal=sc1.nextLine();
					System.out.println("Enter phone");
					String ephone=sc1.nextLine();
					System.out.println("Enter email");
					String eemail=sc1.nextLine();
					System.out.println("Enter web");
					String eweb=sc1.nextLine();
					
					query="UPDATE EMPDATA SET FIRST_NAME='"+efirstname+"', LAST_NAME='"+elastname+"', COMPANY_NAME='"+ecom+"', ADDRESS='"+eadd+"', CITY='"+ecity+"', COUNTY='"+ecounty+"', POSTAL='"+epostal+"', PHONE='"+ephone+"', EMAIL='"+eemail+"', WEB='"+eweb+"' WHERE ID="+empno;
					st.executeUpdate(query);
					System.out.println("Employee details successfully updated.");
				}
				System.out.println("--------------------------");
			break;
			
			default:
				System.out.println("Please enter a valid option.");
			}
		}while(ch!=0);
		
		st.close();
		con.close();
	}
}
