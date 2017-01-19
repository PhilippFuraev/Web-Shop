package View;
import java.io.*;
import java.util.*;
import Model.*;


public class ItemBaseHtml {

   public static String getCatalogPage(String catalog) {
        int numberOfItems = 0;
        int numberOfPages = 0;
        StringBuilder sb = new StringBuilder();
        InputStreamReader isr;
        try {
            String base = ItemBase.getItemBase();

            Scanner scanner = new Scanner(base);
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
	String catalogs=ItemBase.getCatalogs();
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

        } catch (IOException e) {
        }
        sb.append("</ul>");
        return sb.toString();
    }
	 public static String getShopPage() {
        int numberOfItems = 0;
        int numberOfPages = 0;
        StringBuilder sb = new StringBuilder();
	String file = new String();
        try {
            file=ItemBase.getItemBase();
            Scanner scanner = new Scanner(file);
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
	String catalogs=ItemBase.getCatalogs();
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

        } catch (IOException e) {
        }
		sb.append("</ul>");
        return sb.toString();
    }
	public static String getItemProfile(String numberOfItem, boolean sessionCheck, boolean traderRules) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner;
	String file = new String();

        try {
	    file = ItemBase.getItemBase();
            scanner = new Scanner(file);
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
        } catch (IOException e) {

        }



        return sb.toString();
    }

public static String getItem(String numberOfItem) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner;
	String file = new String();
        try {
            file = ItemBase.getItemBase();
            scanner = new Scanner(file);
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
        } catch (IOException e) {

        }
        return sb.toString();
    }
	public static String getCatalogsInOptions() throws IOException
{
	StringBuilder sb = new StringBuilder();
	String catalogName = new String();
	sb.append("<form>");
	sb.append("<select name=\"catalog\">");
	String catalogs=ItemBase.getCatalogs();
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
	String catalogs=ItemBase.getCatalogs();
	Scanner catalogScanner = new Scanner(catalogs);
	while (catalogScanner.hasNext())
{
	catalogName = catalogScanner.next();
	sb.append("<option value=\""+catalogName + "\">"+catalogName + "</option> ");
}
	return sb.toString();
}

}
