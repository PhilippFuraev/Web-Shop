package View;
import java.io.*;
import java.util.*;
import Model.*;

public class UserBaseHtml {
	    public static String getCard(String name) throws IOException {
        Scanner fileScanner = new Scanner(UserBase.getUserBase());
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
}
