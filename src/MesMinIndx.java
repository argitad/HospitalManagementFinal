public class MesMinIndx {
	
	public static double mesatare1(double[] a) {
		double[] input={2.2, 3 ,4.5, 2.1 ,1, 3.1 ,7.8, 4, 4.2, 3.6};
		double n=10,shuma=0;
		for(int i=0;i<n;i++) 
		{
			shuma=shuma+input[i];
		}
	       System.out.println("Mesatarja :"+shuma/n);
		return shuma;  
	       
	
}

}
