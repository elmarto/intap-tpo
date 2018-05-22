package hotel.model;

public class Request {
	public Establishment establishment;
	public int status;
	
	public Request(Establishment establishment, int status)
	{
		this.establishment = establishment;
		this.status = status;
	}
	
	public void setEstablishment(Establishment establishment)
	{
		this.establishment = establishment;
	}
	
	public Establishment getEstablishment()
	{
		return this.establishment;
	}
	
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	public int getStatus()
	{
		return this.status;
	}
	
	public void establishmentRequest(int id, int idEstablishment)
	{
		
	}
}
