package weather;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Angphurba
 */
public class Weather {

    private double temperature;
    
    private double chanceOfPrecipitation;
    
    private double humidity;
    
    private int sunRiseTimeInHours;
    
    private int sunSetTimeInHours;
    
    private int sunRiseTimeInMinutes;
    
    private int sunSetTimeInMinutes;
    
    private double windSpeed;
    
    private ArrayList <String> alerts;
    
    public Weather(double temperature, double chanceOfPrecipitation, double humidity, int  sunRiseTimeInHours, int sunRiseTimeInMinutes,
          int sunSetTimeInHours, int sunSetTimeInMinutes, double windSpeed) {
           
        this.temperature = temperature;
        
        this.chanceOfPrecipitation = chanceOfPrecipitation;
        
        this.humidity = humidity;
        
        this.sunRiseTimeInHours = sunRiseTimeInHours;
        
        this.sunRiseTimeInMinutes = sunRiseTimeInMinutes;
        
        this.sunSetTimeInHours = sunSetTimeInHours;
        
        this.sunSetTimeInMinutes = sunSetTimeInMinutes;
        
        this.windSpeed = windSpeed;
        
        this.alerts = new ArrayList<String>();
        
    }
    
    public static boolean isSunRiseSunSetValid (int timeInHours) {
             
        if (timeInHours >= 5 && timeInHours <= 8) {
              
            return true;
        }
        
        else {
              
            return false;
        }
    }
    
    public static boolean isPercentDataValid (double percentData) {
           
           if (percentData >= 0 && percentData <= 100) {
                  
               return true;
           }
           
           else {
                 
               return false;
           }
    }
    
    public void checkForAlerts() {
           
        /*If temperature is above 90 it is a heat advisory, 
        if above 105 it is a heat warning, 
        if below 32 it is a freeze advisory, 
        if below 20 it is a freeze warning. */
        
        if(this.temperature > 90) {
            
            if(this.temperature > 105) {
               
            this.alerts.add("Heat Warning");
            
        }
            
            else {
            
            this.alerts.add("Heat Advisory");
            }
            
        }
        
        
        
        if (this.temperature < 32) {
             
            
            
            if(this.temperature < 20) {
               
            this.alerts.add("Freeze Warning");
        }
            
            else {
                this.alerts.add("Freeze advisory");
            }
            
            
        }
        
        
        
        /*If precipitation is < 25 % than it is a low chance, 
        if it is between 25 % and 75 % chance then it is a decent chance and 
        if it is greater than 75 % then it is a likely chance of rain. (Pair this with temperature though. 
        If its below freezing it won’t be rain but snow that comes down) */
        
        if (this.chanceOfPrecipitation < 25) {
               
            this.alerts.add("Low Chance of  Precipitation");
        }
        
        if(this.chanceOfPrecipitation > 25 && this.chanceOfPrecipitation < 75) {
              
            this.alerts.add("Decent Chance of Precipitation");
                    
        }
        
        if (this.chanceOfPrecipitation > 75) {
            
            if(this.temperature < 20){
                
                this.alerts.add("Likely Chance of snow");
            }
            
            else {
              
            this.alerts.add("Likely chance of rain");
            
            }
        }
        
        /* If about 80 degrees with low humidity and no precipitation then it is a fire warning.
        If wind speed is greater than 40MPH then it is a wind advisory. If above 60MPH then it is a wind warning. */
        
        if(this.temperature >= 80 && this.humidity <= 30) {
              
            this.alerts.add("Fire Warning");
        }
        
        if (this.windSpeed > 40) {
            
            if(this.windSpeed > 60) {
              
            this.alerts.add("Wind Advisory");
            
            }
            
            else {
                  
                this.alerts.add("Wind warning");
            }
        }
        
        
    }
    
    public void printData() {
        
        System.out.println("========================");
        System.out.println("DATA GIVEN");
        
        System.out.println("Sunrise: " + this.sunRiseTimeInHours + ":" + this.sunRiseTimeInMinutes + " AM");
        System.out.println("Sunset: " + this.sunSetTimeInHours + ":" + this.sunSetTimeInMinutes + " PM");
        System.out.println("Temperature: " + this.temperature);
        System.out.println("Precipitation: " + this.chanceOfPrecipitation);
        System.out.println("Humidity: " + this.humidity);
        System.out.println("Wind Speed: " + this.windSpeed);
        
    }
    
    public void printAlerts() {
          
        if (this.alerts.size() > 0) {
               
            System.out.println("Watch out for following alerts: ");
            
            for (int i =0; i < this.alerts.size();i++) {
                   
                System.out.println(this.alerts.get(i));
                
            }
        }
        
        else {
              
            System.out.println("There are no alerts given the weather data. " );
        }
    }
    
    
   
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
       
           System.out.println("Please enter temperature in Farhenheit");
           double temperature = sc.nextDouble();
           System.out.println("Please enter percent chance of precipitation: (0-100)");
           double precipitation = sc.nextDouble();
           while(true){
                
               if(!Weather.isPercentDataValid(precipitation)){
                     
                   System.out.println("The percent data should be 0-100. Please try again.");
                   precipitation = sc.nextDouble();
               }
               else {
                     
                   break;
               }
           }
           System.out.println("Please enter humidity percent");
           double humidity = sc.nextDouble();
           while(true){
                
               if(!Weather.isPercentDataValid(humidity)){
                     
                   System.out.println("The percent data should be 0-100. Please try again.");
                   humidity = sc.nextDouble();
               }
               else {
                     
                   break;
               }
           }
           System.out.println("Please enter hour of sunrise in AM (5-8)");
           int hour = sc.nextInt();
           System.out.println("Please enter minute of sunrise  (0-59)");
           int minute = sc.nextInt();
           while (true) {
                 
               if(!Weather.isSunRiseSunSetValid(hour)){
                     
                   System.out.println("Invalid input. Hours of Sunrise should be between 5am - 8 am. Try again");
                   hour = sc.nextInt();
                   
               }
               
               else {
                   break;
               }
           }
           
           System.out.println("Please enter hour of sunset in PM (5-8)");
           int sunsetHour = sc.nextInt();
           System.out.println("Please enter minute of sunset in PM  (0-59)");
           int sunsetMinute = sc.nextInt();
            while (true) {
                 
               if(!Weather.isSunRiseSunSetValid(hour)){
                     
                   System.out.println("Invalid input. Hours of Sunset should be between 5pm - 8 pm. Try again");
                   sunsetHour = sc.nextInt();
                   
               }
               
               else {
                   break;
               }
           }
            
            System.out.println("Please enter wind speed in MPH");
            double windSpeed = sc.nextDouble();
            
            Weather weather = new Weather(temperature, precipitation, humidity, hour, minute, sunsetHour, sunsetMinute, windSpeed);
            weather.checkForAlerts();
            weather.printData();
            weather.printAlerts();
                    
    }
    
}

