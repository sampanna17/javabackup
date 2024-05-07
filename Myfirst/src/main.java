public class Switch
{
    public static void main(String[] args){
    float markprice = 1440f;
    char category = 'A';
    int discountrate = 0;
    switch (category) {
        case 'A' : discountrate = 60 ; break;
        case 'B' : discountrate = 40 ; break;
        case 'C' : discountrate = 20 ; break;
        case 'D' : discountrate = 10 ; break;
        default: discountrate = 0 ; System.out.println("Invalid Category inpuy!");
        
    }
    float sp = markprice - (markprice * (discountrate/100f));
}
}
