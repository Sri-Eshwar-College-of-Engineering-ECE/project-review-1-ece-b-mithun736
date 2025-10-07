package MAIN1;
import java.util.Scanner;
abstract class ParcelService{
	public abstract void createParcel();
	public abstract void trackParcel();
}

class Parcel{
	private int parcelId;
	private String senderName;
	private String recieverName;
	private String status;
	public Parcel(int parcelId,String senderName,String recieverName) {
		this.parcelId=parcelId;
		this.senderName=senderName;
		this.recieverName=recieverName;
		this.status="Created";
	}
	public int getParcelId() {
		return parcelId;
	}
	public String getSenderName() {
		return senderName;
	}
	public String getRecieverName() {
		return recieverName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	public void displayDetails() {
		System.out.println("Parcel ID : "+parcelId+" || Sender : "+senderName+" || Reciever : "+recieverName+" || Status : "+status);
	}
}

class CourierService extends ParcelService{
	private Parcel parcel;

	@Override
	public void createParcel() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Parcel ID: ");
		int id = sc.nextInt();
		System.out.println("Enter Sender Name: ");
		String sname = sc.next();
		System.out.println("Enter Reciever Name: ");
		String rname = sc.next();
		parcel=new Parcel(id,sname,rname);
		System.out.println("Parcel is ready to ship.");
	}

	@Override
	public void trackParcel() {
		if(parcel == null) {
			System.out.println("NO Parcel Found!");
			return;
		}
		parcel.displayDetails();
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you need to update courier status?");
		String ans =sc.nextLine();
		if(ans.equalsIgnoreCase("yes")) {
			System.out.println("Enter new status :");
			String status = sc.nextLine();
			parcel.setStatus(status);
			System.out.println("Status updated successfully.");
		}
		System.out.println("Updated Parcel Details :");
		parcel.displayDetails();
	}
	
}

public class CourierTracking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CourierService sv=new CourierService();
		System.out.println("Welcome to Courier Tracking System!!");
		while(true) {
			System.out.println("Choose : 1.Create Parcel 2.Track Parcel 3.Exit");
			System.out.println("Enter your choice:");
			int ch =sc.nextInt();
			switch(ch) {
			case 1 -> sv.createParcel();
			case 2 -> sv.trackParcel();
			case 3 -> {
				System.out.println("Thanks for using our Application.");
				return;
			}
			default -> System.out.println("Invalid number.Enter between 1 to 3.");
			}
		}
	}

}
