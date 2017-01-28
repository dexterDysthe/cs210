package bondpricing;
import java.util.Scanner;
import java.util.Arrays;

public class BondPricing {
    
    public static void main(String[] args) {
        
        System.out.println(" Welcome to The Bond Pricing Calculator!");
        Scanner userInput = new Scanner(System.in);  
        
        double coupon;
        int couponsPerYear;
        double YTM; 
        long faceValue;
        int periods;
        double optionFeature;
        double yieldChange = 0;
        
        System.out.print(" Annual Coupon Rate: ");
            coupon = userInput.nextDouble() / 100;
        System.out.print(" Coupons per Year: ");
            couponsPerYear = userInput.nextInt();
        System.out.print(" Yield to Maturity: ");
            YTM = userInput.nextDouble() / 100;
        System.out.print(" Face Value of Bond: ");
            faceValue = userInput.nextLong();
        System.out.print(" Number of Annual Periods: ");
            periods = userInput.nextInt();
        System.out.print(" Embedded Option Features (1 for Yes & 0 for No): ");
            optionFeature = userInput.nextDouble();
            if(optionFeature == 1){
                System.out.print(" Expected change in YTM: ");
                yieldChange = userInput.nextDouble();
            }else{
            }
            
        //Coupon adjusted for specificed coupon periods and converted to currency terms        
        double adjustedCoupon = ((coupon / couponsPerYear) * faceValue);
        //YTM adjusted for specified coupon periods
        double adjustedYTM = (YTM / couponsPerYear);
        //Periods converted to # of coupon distributions
        double adjustedPeriods = (periods * couponsPerYear);
        //Discounted face value of bond
        double discountedFV = ((faceValue)/(Math.pow((1 + adjustedYTM), adjustedPeriods)));
        //PV
        double discountFactor = ((1)/(Math.pow((1 + adjustedYTM), adjustedPeriods)));
            discountFactor = (1 - discountFactor) / (adjustedYTM);
        //Pricing formula 
        double Price = ((adjustedCoupon * discountFactor) + discountedFV);
        
        double couponPVweight;
        double pvOfCoupon = 0;
        double pvOfAllCoupons = 0;
        for(int i = 1; i <= adjustedPeriods; i++){
            couponPVweight = 1/(Math.pow(1 + adjustedYTM, i));
            //Discount factor for all future coupons based on period distributed 
            if(i < adjustedPeriods){
                pvOfCoupon = (couponPVweight * (adjustedCoupon * i));
                
            }else if(i == adjustedPeriods){
            //For final coupon period add in the value of the principle
                pvOfCoupon = couponPVweight * ((faceValue + adjustedCoupon) * i);
            }
            pvOfAllCoupons = pvOfCoupon + pvOfAllCoupons;
            //sum of all discounted coupons
        }
        double macaulayDuration;
        double modifiedDuration;
        double effectiveDuration;
        
        macaulayDuration = ((pvOfAllCoupons / (double) (couponsPerYear * Price)));
        System.out.printf(" Price of Bond: $ %.3f%n", Price);
        System.out.printf(" Macaulay Duration: %.3f%n", macaulayDuration);  
        //weighted average # of years before PV of cash flows pay off price of bond 
        
        if(optionFeature == 0){
            modifiedDuration = macaulayDuration/(1 + (YTM / couponsPerYear));
            System.out.printf(" Modified Duration: %.3f%n", modifiedDuration);
        /*
          price sensitivity; measures % change in price per 100 basis point 
          change in yield(interest rates). As yields increase, duration drecreases
        */
        
        }else if(optionFeature == 1){
            double adjustedYieldChange = yieldChange / 100 ;
            adjustedYieldChange *= macaulayDuration;
            double adjustedPriceChange = adjustedYieldChange * Price; 
            
            effectiveDuration = ((Price+adjustedPriceChange)-(Price-adjustedPriceChange));
            effectiveDuration = effectiveDuration /((couponsPerYear * Price) * ((adjustedYieldChange/faceValue)/macaulayDuration));
            effectiveDuration/=100;
            System.out.printf(" Effective Duration: %.3f%n", effectiveDuration);
            
        }
        
        
        /*
        int[]theArray = {16, 2, 9, 4, 51, 17, 6};
        for(int i = (theArray.length - 1); i < theArray.length; i--){
            for(int j = 0; j < i; j++){
                if(theArray[j]>theArray[j+1]){
                int temp = theArray[j];
                theArray[j]=theArray[j+1];
                theArray[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(theArray));
                */
    }
}

    

