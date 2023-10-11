package Mobile.DemoDailer;

public class FindSingleDigitFromString {

    public static int[] findDigit(String numberString) {

        String number = numberString;

       String newNumber = reverseString(number);
       int inputNumber = Integer.parseInt(newNumber);
       int[] num = new int[newNumber.length()];
       
       
        //TO STORE THE STRING NUMBER INTO AN ARRAY
        for (int digit = 0; digit < newNumber.length(); digit++) {
        	//System.out.println(inputNumber);
        	int  singleDigitNumber = inputNumber%10;
        	inputNumber  = inputNumber/10;
        	//System.out.println(singleDigitNumber);
            num[digit] = singleDigitNumber;
        }
      
        for(int x : num) {
        	System.out.println(x);
        }
        return num;

    }
    
    public static String reverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
    
    
    /*
      public static void main(String[] args) {

        String number = "1234567890";

       String newNumber = reverseString(number);
       int inputNumber = Integer.parseInt(newNumber);
       int[] num = new int[newNumber.length()];
       
       
        //TO STORE THE STRING NUMBER INTO AN ARRAY
        for (int digit = 0; digit < newNumber.length(); digit++) {
        	//System.out.println(inputNumber);
        	int  singleDigitNumber = inputNumber%10;
        	inputNumber  = inputNumber/10;
        	//System.out.println(singleDigitNumber);
            num[digit] = singleDigitNumber;
        }
      
        for(int x : num) {
        	System.out.println(x);
        }

    }
     */
    
}
