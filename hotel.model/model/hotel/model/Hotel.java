package hotel.model;

import java.util.Collection;

public class Hotel {
	public int id;
	public String user;
	public String pass;
	public String email;
	public String name;
	public String photo;
	public Collection<Establishment> establishment;
	
	public Hotel(String user,
			String pass,
			String name,
			String photo,
			Collection<Establishment> establishment,
			int id)
	{
		this.user = user;
		this.pass = pass;
		this.name = name;
		this.photo = photo;
		this.establishment = establishment;
		this.id = id;
	}

	public void setUser(String user)
	{
		this.user = user;
	}
	
	public String getUser()
	{
		return this.user;
	}
	
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	
	public String getPass()
	{
		return this.pass;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setPhoto(String photo)
	{
		this.photo = photo;
	}
	
	public String getPhoto()
	{
		return this.photo;
	}
	
	public void setEstablishment(Collection<Establishment> establishment)
	{
		this.establishment = establishment;
	}
	
	public Collection<Establishment> getEstablishment()
	{
		return this.establishment;
	}
	
	public Hotel searchUserHotel(String email, String pass)
	{
		return null;
	}
	
	public boolean userVerification(String email, String pass)
	{
		return this.email.equals(email) && this.pass.equals(pass);
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return this.id;
	}
}

