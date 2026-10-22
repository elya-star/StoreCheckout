import java.util.Scanner;

class StoreCheckout {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        int quantity;
//        for bonus 1:
        double quantityDiscount = 0;
        int subtotal = 0;
        int itemPurchased = 0;
        int mousePrice = 20;
        int keyboardPrice = 40;
        int headphonesPrice = 50;
        int standPrice = 30;

//      For bonus 3:
        int mouseCount = 0;
        int keyboardCount = 0;
        int headpCount = 0;
        int standCount = 0;

//        Store menu:

        while (true) {
            System.out.println("===SIMPLE STORE===");
            System.out.println("1. Mouse - $20");
            System.out.println("2. keyboard - $40");
            System.out.println("3. headphones - $50");
            System.out.println("4. Laptop stand - $30");
            System.out.println("5. Checkout");
/*
for checkout break
 */
            System.out.println("Choose a product: ");
            choice = input.nextInt();
            if (choice == 5) {
                break;
            }
//            if the user chose wrong option
            if (choice < 1 || choice > 5) {
                System.out.println("Valid option.");
                System.out.println("Please, choose option from 1 to 5.");
                continue;
            }


//            for view a product and his price
            int price = 0;
            String productName = " ";
            if (choice == 1) {
                productName = "Mouse";
                price = mousePrice;
            } else if (choice == 2) {
                productName = "Keyboard";
                price = keyboardPrice;
            } else if (choice == 3) {
                productName = "Headphones";
                price = headphonesPrice;
            } else if (choice == 4) {
                productName = "Laptop stand";
                price = standPrice;
            }

            System.out.println("You selected: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Enter quantity: ");
            quantity = input.nextInt();
            if (quantity <= 0) {
                System.out.println("Invalid quantity.");
                System.out.println("Quantity must be greater than 0.");
                continue;
            }

//            to count chosen product cost and his quantity

            int itemcost = price * quantity;
            subtotal = subtotal + itemcost;
            itemPurchased = itemPurchased + quantity;

//            Bonus 1: 5% discount for 5 or more units
            if (quantity >= 5) {
                double itemDiscount = itemcost * 0.05;
                quantityDiscount = quantityDiscount + itemDiscount;

                System.out.println("You received a 5% quantity discount!");
                System.out.println("Discount: $" + itemDiscount);
            }

            if (choice == 1) {
                mouseCount = mouseCount + quantity;
            } else if (choice == 2) {
                keyboardCount = keyboardCount + quantity;
            } else if (choice == 3) {
                headpCount = headpCount + quantity;
            } else if (choice == 4) {
                standCount = standCount + quantity;
            }

            System.out.println("Current total before discount: " + subtotal);
        }

            System.out.println("===CHECKOUT===");
            System.out.println("Items purchased: " + itemPurchased);
            System.out.println("Subtotal: " + subtotal);

            double discountSubtotal = subtotal - quantityDiscount;

            double orderDiscount = 0;
            if (discountSubtotal >= 200) {
                orderDiscount = discountSubtotal * 0.15;
            } else if (discountSubtotal >= 100) {
                orderDiscount = discountSubtotal * 0.10;
            }

        double totalDiscount = quantityDiscount + orderDiscount;
            double finalTotal = subtotal - totalDiscount;

            System.out.println("Discount: $" + totalDiscount);
        System.out.println("Quantity discount: $" + quantityDiscount);
        System.out.println("Order discount: $" + orderDiscount);
            System.out.println("Final total: $" + finalTotal);
// to pay and to calculate change
            double payment;
            double totalPaid = 0;
            while (totalPaid < finalTotal) {
                System.out.println("Enter payment amount: $");
                payment = input.nextDouble();

                if(payment <= 0) {
                    System.out.println("Enter a positive payment amount.!");
                    continue;
                }
                totalPaid = totalPaid + payment;

                if (totalPaid < finalTotal) {
                    System.out.println("Insufficient payment.");
                    System.out.println("You still pay: $" + (finalTotal - totalPaid));
                }

            }

            double change = totalPaid - finalTotal;

        System.out.println("Payment successful!");
        System.out.println("Change: $" + change);

        System.out.println("===== ITEMS PURCHASED =====");
        System.out.println("Mouse: " + mouseCount);
        System.out.println("Keyboard: " + keyboardCount);
        System.out.println("Headphones: " + headpCount);
        System.out.println("Laptop Stand: " + standCount);



        System.out.println("===== SIMPLE STORE =====");
        System.out.println("Items purchased: " + itemPurchased );
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Discount: $" + totalDiscount);
        System.out.println("Quantity discount: $" + quantityDiscount);
        System.out.println("Order discount: $" + orderDiscount);
        System.out.println("Final total: $" + finalTotal);
        System.out.println("Total Payment: $" + totalPaid);
        System.out.println("Change: $" + change);

//        bonus 5, having a coupon
        if (itemPurchased >= 10) {
            System.out.println("You earned a $10 coupon for your next visit!");
        }



        System.out.println("Thank you for shopping!");

        input.close();
    }
}