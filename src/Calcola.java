public class Calcola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dato V = new Dato();
		Semaforo S_C=new Semaforo(0);
		Semaforo S_P=new Semaforo(1);
		Produce[] pr=new Produce[3];
		Consuma[] co=new Consuma[3];	
		for(int i=0;i<pr.length;i++)
			pr[i]=new Produce(V, S_P, S_C);
		for(int i=0;i<co.length;i++) 
			co[i]=new Consuma(V,S_C, S_P);
		System.out.println("Inizio!!");
		for(int i=0;i<pr.length;i++)
			pr[i].start();
		for(int i=0;i<co.length;i++)
			co[i].start();
		try {
			for(int i=0;i<pr.length;i++)
				pr[i].join();
			for(int i=0;i<co.length;i++)
				co[i].join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		System.out.println("Fine!!");
		
	  }
}
