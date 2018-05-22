package hotel.model;

public class Service {
	public int idService;
	
	public Service(int id)
	{
		this.idService = id;
	}
	
	public void setidService(int id)
	{
		this.idService = id;
	}
	
	public int getIdService()
	{
		return this.idService;
	}
	
	public boolean serviceValidation(int idService)
	{
		return this.idService == idService;
	}
}
