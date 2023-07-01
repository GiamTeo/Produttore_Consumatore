import java.util.Random;

public class Produce extends Thread{
	private Dato D;
	private Semaforo S_P;
	private Semaforo S_C;
	
	public Produce()
	{
		D = new Dato();
	}
	public Produce(Dato _d, Semaforo _s_p, Semaforo _s_c)
	{
		D = _d;
		S_P =_s_p;
		S_C = _s_c;
	}
	
	public void azione()
	{
		for (int i=0;i<5;i++)
		{
			D.setD(D.getD()+1);
			System.out.println(D.getD());
		}
	}
	
	public void run()
	{
		Random R=new Random();
		for (int i=0;i<5;i++)
		{
			try {
				sleep(R.nextInt(500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			S_P.R();
			
			{
				//if(D.getD() == 0) {
				D.setD(D.getD()+5);
				System.out.println(this.getName()+ " Produce " + D.getD());
				//}
			}
			S_C.V();
		}
	}
}
