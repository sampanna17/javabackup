package SmartphoneInventoryModel;
public class StoreApp {
    public static void main(String[] args) {
        StoreController storeController = new StoreController();

        // Demonstrate the usage of addNewProduct, deleteProduct, updateProduct, and getSmartphoneInfo methods
        storeController.addNewProduct();
        storeController.addNewProduct();
        
        // Attempt to delete a product
        storeController.deleteProduct("modelCode1");
        
        // Attempt to update a product
        storeController.updateProduct("modelCode2");
        
        // Attempt to get info of a product
        SmartphoneInventoryModel product = storeController.getSmartphoneInfo("modelCode3");
        
        if (product != null) {
            System.out.println("Smartphone model code 3 details:");
            System.out.println("Model Code 1: " + product.getModelCode1());
            System.out.println("Model Code 2: " + product.getModelCode2());
            // Repeat for other model codes...
        } else {
            System.out.println("Product not found!");
        }
    }
}
