import java.util.Random;

public class Consuma extends Thread {
	private Dato D;
	private Semaforo S_C;
	private Semaforo S_P;
	
	public Consuma()
	{
		D = new Dato();
	}
	public Consuma(Dato _d, Semaforo _s_c, Semaforo _s_p)
	{
		D = _d;
		S_C =_s_c;
		S_P=_s_p;
	}
	
	public void azione()
	{
		for (int i=0;i<5;i++)
		{
			D.setD(D.getD()-1);
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
			S_C.R();
			{
				//if(D.getD() != 0) {
				D.setD(D.getD()-5);
				System.out.println(this.getName()+" Consuma "+ D.getD());
				//}
			}
			S_P.V();
		}
	}
}
