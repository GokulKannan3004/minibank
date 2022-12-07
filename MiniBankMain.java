package gokulProject;

import java.util.Scanner;

class bankDetials{
	private String accno;
	private String name;
	private long balance;
	
	Scanner sc=new Scanner(System.in);
	public void openAccount() {
		System.out.println("Enter Account No: ");
		accno=sc.next();
		System.out.println("Enter Name: ");
		name=sc.next();
		System.out.println("Enter Balance: ");
		balance=sc.nextLong();
		}
	public void showAccount() {
		System.out.println("Name of account holder: "+name);
		System.out.println("Account no: "+accno);
		System.out.println("Balance: "+balance);
	}
	public void Deposit() {
		long amt;
		System.out.println("Enter the amount you to deposit");
		amt=sc.nextLong();
		balance=balance+amt;
	}
	public void WithDraw() {
		long amt;
		System.out.println("Enter the amount you to Withdrawl");
		amt=sc.nextLong();
		if(balance>=amt) {
			balance=balance-amt;
			System.out.println("Balance after withdrawal: "+balance);
		}
		else {
			System.out.println("your balance is less than"+amt+"\tTransaction failed...!!");
			}
		}
	public boolean search(String ac_no) {
		if(accno.equals(ac_no)) {
			showAccount();
			return(true);
		}
		return(false);
	}
}

public class MiniBankMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("How many number of client u want input?");
		int n=sc.nextInt();
		bankDetials C[]=new bankDetials[n];
        for(int i=0;i<C.length;i++) {
        	C[i]=new bankDetials();
        	C[i].openAccount();
        }
        int ch;
        do {
        	System.out.println("\n***Banking System Application***");
        	System.out.println("1.Display account balance");
        	System.out.println("2.Search account no");
        	System.out.println("3.Deposite amount");
        	System.out.println("4.Withdraw amount");
        	System.out.println("5.Exit");
        	System.out.println("Enter your chioce: ");
        	ch=sc.nextInt();
        	switch(ch) {
        	case 1:
        		for(int i=0;i<C.length;i++) {
        			C[i].showAccount();
        		}
        		break;
        	case 2:
        		System.out.println("enter account no.want to search: ");
        		String ac_no=sc.next();
        		boolean found=false;
        		for(int i=0;i<C.length;i++) {
        			found=C[i].search(ac_no);
        			if(found) {
        				break;
        			}
        		}
        		if(!found) {
        			System.out.println("search failed!!..acc_can't exist..!!");
        		}
        		break;
        	case 3:
        		System.out.println("enter account no:");
        		ac_no=sc.next();
        		found=false;
        		for(int i=0;i<C.length;i++) {
        			found=C[i].search(ac_no);
        			if(found) {
        				C[i].Deposit();
        				break;
        			}
        		}
        		if(!found) {
        			System.out.println("search failed!!Acc_can't exist..!!!");
        		}
        		break;
        	case 4:
        		System.out.println("enter Account no: ");
                 ac_no=sc.next();
                 found=false;
                 for(int i=0;i<C.length;i++) {
                	 found=C[i].search(ac_no);
                	 if(found) {
                		 C[i].WithDraw();
                		 break;
                	 }
                 }
                 if(!found) {
                	 System.out.println("search failed!!..acc_can't exist!!..");
                 }
                 break;
        	case 5:
        		System.out.println("**Visit Again**");
        		break;
        	}
        }while(ch!=5);
	}
}

        	
        
