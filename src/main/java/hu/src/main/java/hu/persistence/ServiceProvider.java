package hu.persistence;

public class ServiceProvider {
	private static ProfielService profielService = new ProfielService();
	
	public static ProfielService getProfielService() {
		return profielService;
	}
}
