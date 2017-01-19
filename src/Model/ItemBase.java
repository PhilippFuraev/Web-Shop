package Model;
import java.io.*;
import java.util.*;

public class ItemBase {

    public static String lastUri(String uri) {
        Scanner scanner = new Scanner(uri);
        String request = "";
        scanner.useDelimiter("[/]");
        while (scanner.hasNext()) {
            request = scanner.next();
        }
        System.out.println(request);
        return request;
    }
		public static boolean checkCatalog(String name) throws IOException{
	 Scanner fileScanner = new Scanner(new File("../webapps/Web-shop/Catalogs.txt"));
	while (fileScanner.hasNextLine()) {
	String catalogName = fileScanner.nextLine();
            if(catalogName.equals(name))
		return false;
}
fileScanner.close();
return true;
	
}
        	public static int addToNumberOfItems() throws IOException
{
	String file = new String();
        Scanner fileScanner = new Scanner((new File("../webapps/Web-shop/ItemBase.txt")));
	int numberOfItems = fileScanner.nextInt();
	numberOfItems+=1;
	file+=numberOfItems;
        while (fileScanner.hasNextLine()) {
            file += "\r\n" + fileScanner.nextLine();
}
fileScanner.close();
FileWriter fr = new FileWriter("../webapps/Web-shop/ItemBase.txt");
        fr.write(file);
        fr.flush();
        fr.close();
return numberOfItems-1;
}
		public static void addCatalog(String name) throws IOException{
	FileWriter fr = new FileWriter("../webapps/Web-shop/Catalogs.txt", true);
	fr.write("\r\n" + name);
	fr.flush();
	fr.close();
	
}

	public static String getItemBase() throws IOException{
String file = new String();
        Scanner fileScanner = new Scanner((new File("../webapps/Web-shop/ItemBase.txt")));
	if (fileScanner.hasNextLine())
file+=fileScanner.nextLine() + "\n";
        while (fileScanner.hasNextLine()) {
            file += "\n" + fileScanner.nextLine();
        }
	fileScanner.close();
	return file;
}

    public static void removeItem(String number) throws FileNotFoundException, IOException {
        String file = new String();
        Scanner fileScanner = new Scanner((new File("../webapps/Web-shop/ItemBase.txt")));
        while (fileScanner.hasNextLine()) {
            file += fileScanner.nextLine() + "\n";
        }

        String string = new String();
        System.out.println(file);
        fileScanner.close();
        Scanner scanner = new Scanner(file);
        Scanner itemScanner;
        String outputFile = new String();
        String item = new String();
        String numberOfItems;
        if (scanner.hasNextLine()) {
            numberOfItems=scanner.nextLine();
            outputFile = numberOfItems  + "\r\n";
        }
        while (scanner.hasNextLine()) {
            item = scanner.nextLine();
            itemScanner = new Scanner(item);
            itemScanner.useDelimiter("[~]");
            string = itemScanner.next();
            System.out.println("str " + string);
            if (!number.equals(string)) {
                outputFile += item;
            }
        }
        FileWriter fr = new FileWriter("../webapps/Web-shop/ItemBase.txt");
        fr.write(outputFile);
        fr.flush();
        fr.close();

    }

        public static int getPrice(String itemNumber) throws IOException {
        Scanner fileScanner = new Scanner(new File("../webapps/Web-shop/ItemBase.txt"));
        String role = "";
        while (fileScanner.hasNextLine()) {
            String user = fileScanner.nextLine();
            Scanner itemScanner = new Scanner(user);
            itemScanner.useDelimiter("[~]");
            if (itemScanner.hasNext()) {
                if (itemScanner.next().equals(itemNumber)) {
                    itemScanner.next();
		    itemScanner.next();
                    itemScanner.next();
                    return itemScanner.nextInt();
                }
            }
        }
        fileScanner.close();
        return 0;
    }
/*
    public static String getShopPage(String filename) {
        int numberOfItems = 0;
        int numberOfPages = 0;
        StringBuilder sb = new StringBuilder();
        InputStreamReader isr;
        try {
            isr = new InputStreamReader(new FileInputStream(filename));

            Scanner scanner = new Scanner(isr);
            if (scanner.hasNext()) {
                numberOfItems = scanner.nextInt();
            }
            numberOfPages = numberOfItems % 2;
            String str;
            Scanner itemScanner;
            String name;
            int number = 0;
            String price;
            int quantity=0;
            String description;
	    String catalog = new String();
	sb.append("<ul class=\"menu\">");
	String catalogs=getCatalogs();
	Scanner catalogScanner = new Scanner(catalogs);
	while (catalogScanner.hasNext())
{
	catalog = catalogScanner.next();
	sb.append("<li class=\"menu\"><a href=\"catalog/" +catalog + "\">" +catalog + "</a></li>");
}
	sb.append("</ul>");
	sb.append("<ul class=\"shop\">");
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                itemScanner = new Scanner(str);
                itemScanner.useDelimiter("[~]");
                while (itemScanner.hasNext()) {
                    number = itemScanner.nextInt();
		    itemScanner.next();
                    System.out.println(number);
                    name = itemScanner.next();
                    System.out.println(name);
                    quantity = itemScanner.nextInt();
                    System.out.println(quantity);
			price = itemScanner.next();
                    description = itemScanner.next();
			if(quantity>0)
{
                    System.out.println(description);
sb.append("<li class=\"shop\">");
		sb.append("<div class=\"img\">");
		
                    sb.append("<a href=\"/Web-shop/" + "item/" + number + "\">");
			sb.append("<img src =\"/Web-shop/DisplayImage/" + number + "\" style=\"width:100px;height:100px;\"></a>");
		sb.append("<div class=\"desc\">");
                    sb.append("price: " + price + "<br>");
                    sb.append("description: " + description + "</div>");
		sb.append("</li>");
}
                }
            }
            scanner.close();
            isr.close();

        } catch (IOException e) {
        }
		sb.append("</ul>");
        return sb.toString();
    }

    public static String getCatalogPage(String catalog, String filename) {
        int numberOfItems = 0;
        int numberOfPages = 0;
        StringBuilder sb = new StringBuilder();
        InputStreamReader isr;
        try {
            isr = new InputStreamReader(new FileInputStream(filename));

            Scanner scanner = new Scanner(isr);
            if (scanner.hasNext()) {
                numberOfItems = scanner.nextInt();
            }
            numberOfPages = numberOfItems % 2;
            String str;
            Scanner itemScanner;
            String name;
            int number = 0;
            String price;
            int quantity = 0;
            String description;
            String itemCatalog;
	String catalogName = new String();
	sb.append("<ul class=\"menu\">");
	String catalogs=getCatalogs();
	Scanner catalogScanner = new Scanner(catalogs);
	while (catalogScanner.hasNext())
{
	catalogName = catalogScanner.next();
	sb.append("<li class=\"menu\"><a href=\"../catalog/" + catalogName + "\">" +catalogName  + "</a></li>");
}
	sb.append("</ul>");
            sb.append("<ul class=\"shop\">");
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                itemScanner = new Scanner(str);
                System.out.println(str);
                itemScanner.useDelimiter("[~]");
                while (itemScanner.hasNext()) {
                    number = itemScanner.nextInt();
                    if (itemScanner.next().equals(catalog)) {
                        name = itemScanner.next();
                        quantity = itemScanner.nextInt();
                        System.out.println(quantity);
                        price = itemScanner.next();
                        description = itemScanner.next();
                        if (quantity > 0) {
                            System.out.println(description);
                            sb.append("<li class=\"shop\">");
                            sb.append("<div class=\"img\">");

                            sb.append("<a href=\"/Web-shop/" + "item/" + number + "\">");
                            sb.append("<img src =\"/Web-shop/DisplayImage/" + number + "\" style=\"width:100px;height:100px;\"></a>");
                            sb.append("<div class=\"desc\">");
                            sb.append("price: " + price + "<br>");
                            sb.append("description: " + description + "</div>");
                            sb.append("</li>");
                        }
                    } else {
                        break;
                    }
                }
            }
            scanner.close();
            isr.close();

        } catch (IOException e) {
        }
        sb.append("</ul>");
        return sb.toString();
    }


    public static String getItemProfile(String filename, String numberOfItem, boolean sessionCheck, boolean traderRules) {
        StringBuilder sb = new StringBuilder();
        InputStreamReader isr;
        Scanner scanner;

        try {
            isr = new InputStreamReader(new FileInputStream(filename));

            scanner = new Scanner(isr);
            if (scanner.hasNext()) {
                scanner.nextInt();
            }
            String str;
            Scanner itemScanner;
            String name;
            String number;
            String price = new String();
            String quantity;
            String description;
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                itemScanner = new Scanner(str);
                itemScanner.useDelimiter("[~]");
                while (itemScanner.hasNext()) {
                    number = itemScanner.next();
			itemScanner.next();
                    if (number.equals(numberOfItem)) {
                        name = itemScanner.next();
                        System.out.println(name);
                        quantity = itemScanner.next();
                        System.out.println(quantity);
                        price = itemScanner.next();
                        System.out.println(price);
                        description = itemScanner.next();
                        System.out.println(description);
                        sb.append("<p>" + name + "</p>\n");
			sb.append("<br>");
			sb.append("<img  src =\"/Web-shop/DisplayImage/" + number + "\" style=\"width:200px;height:200px;\" <br> ");
                        sb.append("<p> price : " + price + " </p>\n");
                        sb.append("<p> description:  " + description + " </p>\n");
                        sb.append("<a style=\"text-align:center;\" href=\"/Web-shop/item/return\">");
                        sb.append("<button>return</button></p> </a>");
	if(traderRules==true){
sb.append("<a style=\"text-align:center;\" href=\"/Web-shop/item/remove\">");
                        sb.append("<button>remove</button></p> </a>");
                       }
                        if (sessionCheck) {
                            sb.append("<a href=\"/Web-shop/item/Addtocart\">");
                            sb.append("<button> Add to cart</button> </p></a>");
                        } else {
                            sb.append("<p>" + "if you want to add this to your cart, please, login first!" + "</p>\n");
                        }
                        sb.append("<b>");
                    } else {
                        itemScanner.next();
                        itemScanner.next();
                        itemScanner.next();
                        itemScanner.next();
                    }

                }
                itemScanner.close();
            }
            scanner.close();
            isr.close();
        } catch (IOException e) {

        }



        return sb.toString();
    }
*/
    public static void takeQuantity(String number) throws FileNotFoundException, IOException {
        String file = new String();
        Scanner fileScanner = new Scanner((new File("../webapps/Web-shop/ItemBase.txt")));
        while (fileScanner.hasNextLine()) {
            file += fileScanner.nextLine() + "\n";
        }

        String itemNumber = new String();
        System.out.println(file);
        fileScanner.close();
        Scanner scanner = new Scanner(file);
        Scanner itemScanner;
        String itemName = new String();
        String outputFile = new String();
        String item = new String();
        String itemCatalog = new String();
        int quantity = 0;
        if (scanner.hasNextLine()) {
            outputFile = scanner.nextLine() + "\r\n";
        }
        while (scanner.hasNextLine()) {
            item = scanner.nextLine();
            itemScanner = new Scanner(item);
            itemScanner.useDelimiter("[~]");
            itemNumber = itemScanner.next();
            itemCatalog = itemScanner.next();
            System.out.println("str " + itemNumber);
            if (number.equals(itemNumber)) {
                itemName = itemScanner.next();
                quantity = itemScanner.nextInt();
                outputFile += itemNumber + "~" + itemCatalog + "~" + itemName + "~" + (quantity - 1) + "~" + itemScanner.next() + "~" + itemScanner.next() + "\r\n";

            } else {
                outputFile += item + "\r\n";
            }
        }
        FileWriter fr = new FileWriter("../webapps/Web-shop/ItemBase.txt");
        fr.write(outputFile);
        fr.flush();
        fr.close();

    }

	    public static void returnItem(String number) throws FileNotFoundException, IOException {
	boolean add = false;
        String file = new String();
        Scanner fileScanner = new Scanner((new File("../webapps/Web-shop/ItemBase.txt")));
        while (fileScanner.hasNextLine()) {
            file += fileScanner.nextLine() + "\n";
        }

        String itemNumber = new String();
        System.out.println(file);
        fileScanner.close();
        Scanner scanner = new Scanner(file);
        Scanner itemScanner;
        String itemName = new String();
	String itemCatalog = new String();
        String outputFile = new String();
        String item = new String();
        int quantity = 0;
        if (scanner.hasNextLine()) {
            outputFile = scanner.nextLine() + "\r\n";
        }
        while (scanner.hasNextLine()) {
            item = scanner.nextLine();
            itemScanner = new Scanner(item);
            itemScanner.useDelimiter("[~]");
            itemNumber = itemScanner.next();
	    itemCatalog = itemScanner.next();
            System.out.println("str " + itemNumber);
            if (number.equals(itemNumber) && !add) {
                itemName=itemScanner.next();
                quantity=itemScanner.nextInt();
                    outputFile += itemNumber + "~" + itemCatalog + "~" + itemName + "~" + (quantity+1) + "~" + itemScanner.next() + "~" + itemScanner.next() + "\r\n";
			add=true;
                
            }
            else
            {
                outputFile += item + "\r\n";
            }
        }
        FileWriter fr = new FileWriter("../webapps/Web-shop/ItemBase.txt");
        fr.write(outputFile);
        fr.flush();
        fr.close();

    }

		public static void addItemToBase(int number, String name, String catalog, String quantity, String price, String description) throws IOException
{
FileWriter fw = new FileWriter("../webapps/Web-shop/ItemBase.txt", true);
fw.write("\r\n" + number + "~" + name + "~" + catalog + "~" + quantity + "~" + price + "~" + description);
fw.flush();
fw.close();
}



	        public static void addItemToUser(String name, String number) throws IOException {
        Scanner fileScanner = new Scanner(new File("../webapps/Web-shop/UserBase.txt"));
        String role = "";
        String card = new String();
        String item = new String();
        Scanner cardScanner;
        String newFile = new String();
        String user = new String();
        String updateUser = new String();
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
                    if (card.equals("null")) {
                        card = number + " ";
                    } else {
                        card += " " + number;
                    }
                    updateUser += "~" + card + "\r\n";
                    newFile += updateUser;

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

/*
    public static String getItem(String filename, String numberOfItem) {
        StringBuilder sb = new StringBuilder();
        InputStreamReader isr;
        Scanner scanner;

        try {
            isr = new InputStreamReader(new FileInputStream(filename));

            scanner = new Scanner(isr);
            if (scanner.hasNext()) {
                scanner.nextInt();
            }
            String str;
            Scanner itemScanner;
            String name;
            String number;
            String price;
            String quantity;
            String description;
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                itemScanner = new Scanner(str);
                itemScanner.useDelimiter("[~]");
                while (itemScanner.hasNext()) {
                    number = itemScanner.next();
			itemScanner.next();
                    if (number.equals(numberOfItem)) {
                        name = itemScanner.next();
                        System.out.println(name);
                        quantity = itemScanner.next();
                        price = itemScanner.next();
                        System.out.println(quantity);
                        description = itemScanner.next();
                        System.out.println(description);
                        sb.append("<p>" + name + "</p>\n");
			sb.append("<br>");
			sb.append("<img src =\"/Web-shop/DisplayImage/" + number + "\" style=\"width:100px;height:100px;\">");
                        sb.append("<p>" + price + "</p>\n");
                        sb.append("<p>" + description + "</p>\n");
                        sb.append("<br>");
                    } else {
                        itemScanner.next();
                        itemScanner.next();
                        itemScanner.next();
                        itemScanner.next();
                    }

                }
                itemScanner.close();
            }
            scanner.close();
            isr.close();
        } catch (IOException e) {

        }
        return sb.toString();
    }
*/

    public static String getCatalogs() throws FileNotFoundException
    {
        String catalog = new String();
        Scanner fileScanner = new Scanner((new File("../webapps/Web-shop/Catalogs.txt")));
        while (fileScanner.hasNextLine())
            catalog+=fileScanner.nextLine() +"\r\n";
        catalog = catalog.substring(0,catalog.length()-1);
        fileScanner.close();
        return catalog;
            
    }

    public static void removeCatalog(String name) throws IOException {
        String catalogs = getCatalogs();
        Scanner scanner = new Scanner(catalogs);
        String newCatalog = new String();
        String catalog = new String();
        while (scanner.hasNext()) {
            catalog = scanner.next();
            if (!name.equals(catalog)) {
                newCatalog += catalog + "\r\n";
            }
        }
        newCatalog = newCatalog.substring(0, newCatalog.length() - 1);
        FileWriter fr = new FileWriter("../webapps/Web-shop/Catalogs.txt");
        fr.write(newCatalog);
        fr.flush();
        fr.close();
	removeCatalogItems(name);
    }

    public static void removeCatalogItems(String name) throws IOException {
        String file = new String();
        Scanner fileScanner = new Scanner((new File("../webapps/Web-shop/ItemBase.txt")));
        while (fileScanner.hasNextLine()) {
            file += fileScanner.nextLine() + "\n";
        }

        String string = new String();
        System.out.println(file);
        fileScanner.close();
        Scanner scanner = new Scanner(file);
        Scanner itemScanner;
        String outputFile = new String();
        String item = new String();
        if (scanner.hasNextLine()) {
            outputFile = scanner.nextLine() + "\r\n";
        }
        while (scanner.hasNextLine()) {
            item = scanner.nextLine();
            itemScanner = new Scanner(item);
            itemScanner.useDelimiter("[~]");
            itemScanner.next();
            string = itemScanner.next();
            System.out.println("str " + string);
            if (!name.equals(string)) {
                outputFile += item + "\r\n";
            }
        }
        FileWriter fr = new FileWriter("../webapps/Web-shop/ItemBase.txt");
        fr.write(outputFile);
        fr.flush();
        fr.close();
    }

	/*public static String getCatalogsInOptions() throws IOException
{
	StringBuilder sb = new StringBuilder();
	String catalogName = new String();
	sb.append("<form>");
	sb.append("<select name=\"catalog\">");
	String catalogs=getCatalogs();
	Scanner catalogScanner = new Scanner(catalogs);
	while (catalogScanner.hasNext())
{
	catalogName = catalogScanner.next();
	sb.append("<option value=\""+catalogName + "\">"+catalogName + "</option> ");
}
	sb.append("<input type = \"submit\" value =\"removeCatalog\">");
	sb.append("</form>");
	return sb.toString();
}

		public static String getCatalogsForAdmin() throws IOException
{
	StringBuilder sb = new StringBuilder();
	String catalogName = new String();
	sb.append("<select name=\"catalog\">");
	String catalogs=getCatalogs();
	Scanner catalogScanner = new Scanner(catalogs);
	while (catalogScanner.hasNext())
{
	catalogName = catalogScanner.next();
	sb.append("<option value=\""+catalogName + "\">"+catalogName + "</option> ");
}
	return sb.toString();
}
*/
}
