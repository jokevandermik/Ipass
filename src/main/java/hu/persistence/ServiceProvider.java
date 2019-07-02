//Dit is de laag tussen de dao's en de webservice
package hu.persistence;

public class ServiceProvider {
	private static ProfielService profielService = new ProfielService();
	
	public static ProfielService getProfielService() {
		return profielService;
	}
}
