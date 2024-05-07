package SmartphoneInventoryModel;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreController {
    private ArrayList<SmartphoneInventoryModel> inventory = new ArrayList<>();

    // Method to add new product
    public void addNewProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter model codes for 6 smartphone models:");
        String modelCode1 = scanner.nextLine();
        String modelCode2 = scanner.nextLine();
        String modelCode3 = scanner.nextLine();
        String modelCode4 = scanner.nextLine();
        String modelCode5 = scanner.nextLine();
        String modelCode6 = scanner.nextLine();

        SmartphoneInventoryModel newProduct = new SmartphoneInventoryModel(modelCode1, modelCode2, modelCode3,
                modelCode4, modelCode5, modelCode6);
        inventory.add(newProduct);
        System.out.println("New product added successfully!");
    }
}
