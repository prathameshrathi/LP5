
import java.net.MalformedURLException;
import java.rmi.*;
public class AddClient{
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException{
		String url = "rmi://" + args[0] + "/AddServer";
		AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(url);
		System.out.println("The first number is " + args[1]);
		double d1 = Double.valueOf(args[1]).doubleValue();
		System.out.println("The second number is " + args[2]);
		double d2 = Double.valueOf(args[2]).doubleValue();
		System.out.println("The sum is " + addServerIntf.add(d1, d2));
	}
}