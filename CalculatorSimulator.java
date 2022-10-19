package operator;

class CountryNoValidException extends Exception { 									
	CountryNoValidException(String str) {
		super(str);}}

class EmployeeNameInvalidException extends Exception { 									
	EmployeeNameInvalidException(String str) {
		super(str);}}

class TaxNotEligibleException extends Exception { 									
	TaxNotEligibleException(String str) {
		super(str);}}

class TaxCalculator{ 			 //class with calculateTax method									 					
	public double calculateTax(String empName, double empSal, boolean isIndian) throws Exception{
		double taxAmount=0;
		if(isIndian==false) { 	//checking Indian									
			throw new CountryNoValidException("The employee should be an Indian citizen for calculating tax");
		}
		else if(empName==null) { 	//check employee name empty								
			throw new EmployeeNameInvalidException("The employee does not need to pay tax");
		}
		//calculating tax											
			if(empSal>=100000 && isIndian==true) {
				taxAmount=empSal*8/100;}
			else if(empSal<100000 && empSal>=50000 && isIndian==true) {
				taxAmount=empSal*6/100;}
			else if(empSal<50000 && empSal>=30000 && isIndian==true) {
				taxAmount=empSal*5/100;}
			else if(empSal<30000 && empSal>=10000 && isIndian==true) {
				taxAmount=empSal*4/100;}
					else { 										
			throw new TaxNotEligibleException("The employee name cannot be empty");
			//return taxAmount;
			}
			return taxAmount;}}
	
	public class  CalculatorSimulator {   	//class with main method
		 public static void main(String[] args) throws Exception{
				// creating object
				TaxCalculator tax = new TaxCalculator();
				//calling method with different inputs
				{try{
					System.out.print("The amount is : " + tax.calculateTax("Ron",34000,false));}
				catch(Exception e) {
					System.out.println("The employee should be an Indian");
					System.out.println(e.getMessage());}}
				{try{System.out.print("The amount is : " + tax.calculateTax("Tim",1000,true));}
				catch(Exception e) {
					System.out.println(e.getMessage());}}
				System.out.println("The amount is : " + tax.calculateTax("Jack",55000,true));
				{try{System.out.print("The amount is : " + tax.calculateTax(null,30000,true));}
				catch(Exception e) {
					System.out.println(e.getMessage());}}
			}
		}
	 
	