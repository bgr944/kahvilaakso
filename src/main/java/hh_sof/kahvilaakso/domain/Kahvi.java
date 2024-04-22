package hh_sof.kahvilaakso.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import java.util.List;
import jakarta.persistence.OneToMany;



@Entity
public class Kahvi {


		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long kahviId;
		private String nimi, kuvaus, alkupera;
		private int paahtoaste;
		private boolean luomu;

		@OneToMany(mappedBy = "kahvi", cascade = CascadeType.ALL)
		private List<Arvostelu> arvostelut;

	
	    public Kahvi(String nimi, String kuvaus, String alkupera, int paahtoaste, boolean luomu)
	    {  
	    	super();
	    	this.nimi=nimi;
	    	this.kuvaus=kuvaus;
	        this.alkupera=alkupera;
			this.paahtoaste = paahtoaste;
			this.luomu = luomu;

	    }
	    

		public Kahvi() {
		}
	 
		public Long getKahviId()
	    {
	        return kahviId;
	    }

	    public String getNimi()
	    {
	        return nimi;
	    }
	    
	     public String getKuvaus()
	    {
	        return kuvaus;
	    }
	    public String getAlkupera()
	    {
	        return alkupera;
	    }
	    public int getPaahtoaste()
		{
			return paahtoaste;
		}
		public boolean getLuomu()
		{
			return luomu;
		}


		public void setId(long kahviId)
	    {
	        this.kahviId = kahviId;
	    }

	    public void setNimi(String nimi)
	    {
	        this.nimi=nimi;
	    }
	    
	     public void setKuvaus(String kuvaus)
	    {
	       this.kuvaus=kuvaus;
	    }
	    public void setAlkupera(String alkupera)
	    {
	        this.alkupera=alkupera;
	    }
	    public void setPaahtoaste(int paahtoaste)
		{
			this.paahtoaste = paahtoaste;
		}

		public void setLuomu(boolean luomu)
		{
			this.luomu = luomu;
		}

	    
	    @Override
	    public String toString()
	    {
	        return  nimi + ", " + kuvaus + ", " + alkupera + ", " + "paahtoaste:" + paahtoaste;
	    }
	
}
