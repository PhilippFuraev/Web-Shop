package Model;
import java.io.*;
import java.util.*;


public class UserBase {

 public static boolean checkPassword(String name, String password) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("../webapps/Web-shop/UserBase.txt"));
        while (fileScanner.hasNextLine()) {
            String user = fileScanner.nextLine();
            Scanner userScanner = new Scanner(user);
            userScanner.useDelimiter("[~]");
            if (userScanner.hasNext()) {
                if (userScanner.next().equals(name)) {
                    if (userScanner.hasNext()) {
                        if (userScanner.next().equals(password) ) {
				fileScanner.close();
                            return true;
                        } else {
				fileScanner.close();
                            return false;
                        }
                    } else {
			fileScanner.close();
                        return false;
                    }
                }
            }
        }
	fileScanner.close();
        return false;
    }
	public static void addUser(String name, String password, String role) throws IOException{
	FileWriter fr = new FileWriter("../webapps/Web-shop/UserBase.txt", true);
	fr.write("\n" + name + "~" + password + "~" + role +"~" + "null");
	fr.flush();
	fr.close();
	
}

	public static void addTrader(String name, String password, String role, String catalog) throws IOException{
	FileWriter fr = new FileWriter("../webapps/Web-shop/UserBase.txt", true);
	fr.write("\n" + name + "~" + password + "~" + role +"~" + "null" + "~" + catalog);
	fr.flush();
	fr.close();
	
}
	public static boolean checkUser(String name) throws IOException{
	 Scanner fileScanner = new Scanner(new File("../webapps/Web-shop/UserBase.txt"));
	while (fileScanner.hasNextLine()) {
	String user = fileScanner.nextLine();
            Scanner userScanner = new Scanner(user);
	userScanner.useDelimiter("[~]");
            if (userScanner.hasNext()) {
                if (userScanner.next().equals(name)) {
			fileScanner.close();
			return false;
}
}
}
fileScanner.close();
return true;
	
}
    public static String getRole(String name) throws IOException {
        Scanner fileScanner = new Scanner(new File("../webapps/Web-shop/UserBase.txt"));
        String role = "";
        while (fileScanner.hasNextLine()) {
            String user = fileScanner.nextLine();
            Scanner userScanner = new Scanner(user);
            userScanner.useDelimiter("[~]");
            if (userScanner.hasNext()) {
                if (userScanner.next().equals(name)) {
                    userScanner.next();
                    role = userScanner.next();
                }
            }
        }
        fileScanner.close();
        return role;
    }

public static String getCatalogFromTrader(String name) throws IOException{
	Scanner fileScanner = new Scanner(new File("../webapps/Web-shop/UserBase.txt"));
        String catalog = new String();
        while (fileScanner.hasNextLine()) {
            String user = fileScanner.nextLine();
            Scanner userScanner = new Scanner(user);
            userScanner.useDelimiter("[~]");
            if (userScanner.hasNext()) {
                if (userScanner.next().equals(name)) {
                    userScanner.next();
		    userScanner.next();
		    userScanner.next();
                    catalog = userScanner.next();
                }
            }
        }
        fileScanner.close();
        return catalog;
}

	public static String getUserBase() throws IOException{
String file = new String();
        Scanner fileScanner = new Scanner((new File("../webapps/Web-shop/UserBase.txt")));
	if (fileScanner.hasNextLine())
file+=fileScanner.nextLine() + "\n";
        while (fileScanner.hasNextLine()) {
            file += "\n" + fileScanner.nextLine();
        }
	fileScanner.close();
	return file;
}

	/*    public static String getCard(String name) throws IOException {
        Scanner fileScanner = new Scanner(new File("../webapps/Web-shop/UserBase.txt"));
        StringBuilder sb = new StringBuilder();
        String role = "";
        String card = new String();
        String item = new String();
        Scanner cardScanner;
        String newFile = new String();
        String user = new String();
        String updateUser = new String();
	int price = 0;
        while (fileScanner.hasNextLine()) {
            user = fileScanner.nextLine();
            Scanner userScanner = new Scanner(user);
            userScanner.useDelimiter("[~]");
            if (userScanner.hasNext()) {
                updateUser = userScanner.next();
                if (updateUser.equals(name)) {
                    updateUser += "~" + userScanner.next();
                    updateUser += "~" + userScanner.next();
                    card = userScanner.next();
                    System.out.println("card:" + card);
                    if (card.equals("null")) {
                        sb.append("<p> Your card is empty.</p>\n");
                    } else {
                        cardScanner = new Scanner(card);
                        while (cardScanner.hasNext()) {
				item=cardScanner.next();
                            sb.append(ItemBaseHtml.getItem(item));
			    sb.append("<a href=\"/Web-shop/removeFromCard/" + item + "\">");
                            sb.append("<button>remove</button> </a>");
			price+=ItemBase.getPrice(item);
                        }
                    }
                    updateUser += "~" + card + "\r\n";
                    newFile += updateUser;

                } else {
                    newFile += user + "\r\n";
                }

            }
        }
        fileScanner.close();
	sb.append("<p> price:" + price + ".</p>\n");
        return sb.toString();
    }
*/

	            public static void removeItemFromUser(String name, String number) throws IOException {
        boolean removeDone = false;
        Scanner fileScanner = new Scanner(new File("../webapps/Web-shop/UserBase.txt"));
        String role = "";
        String card = new String();
        String item = new String();
        Scanner cardScanner;
        String newFile = new String();
        String user = new String();
        String updateUser = new String();
        String updateCart = new String();
        Scanner userScanner;
        Scanner cartScanner;
        while (fileScanner.hasNextLine()) {
            user = fileScanner.nextLine();
            userScanner = new Scanner(user);
            userScanner.useDelimiter("[~]");
            if (userScanner.hasNext()) {
                updateUser = userScanner.next();
                if (updateUser.equals(name)) {
                    updateUser += "~" + userScanner.next();
                    updateUser += "~" + userScanner.next();
                    card = userScanner.next();
                    cartScanner = new Scanner(card);
                    while (cartScanner.hasNext()) {
                        item = cartScanner.next();
                        System.out.println("item" + item);
                        if (!item.equals(number) || removeDone) {
                            updateCart += item + " ";
                        } else {
                            removeDone = true;
                        }
                    }
		if(updateCart.length()>0)
{
		    updateCart = updateCart.substring(0, updateCart.length() - 1);
                    updateCart += "\r\n";
                    updateUser += "~" + updateCart;
                    newFile += updateUser;
}
else
{
updateCart="null";
updateUser+= "~" + updateCart + "\r\n";
newFile+=updateUser;
}

                } else {
                    newFile += user + "\r\n";
                }

            }
        }
        fileScanner.close();
        System.out.println(newFile);
        FileWriter fr = new FileWriter("../webapps/Web-shop/UserBase.txt");
        fr.write(newFile);
        fr.flush();
        fr.close();
    }

}
