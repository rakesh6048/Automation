package main;

public class Demo {

	public static void main(String[] args) {

		String s1= "My Name Is Rakesh and My company name is HCL";

		String val[]=s1.split(" ");

		int duplicate =0;

		for(int i=1;i<=val.length;i++){
			for(int j=i+1;j<=val.length;j++){

				if(val[i]==val[j]){
					duplicate++;
				}
				System.out.println(val[i]+" : "+duplicate);
			}
		}

	}

}
