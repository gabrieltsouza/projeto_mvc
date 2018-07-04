package webapp.extracao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import webapp.db.aws.doConnection;
import webapp.db.aws.readDataBase;

public class ExtracaoService {
	public Connection connect2db() {
		return doConnection.getRemoteConnection();
	}
	public void FillServiceOrders(Connection connect) throws Exception {
		readDataBase.ExecuteSqlQuery(connect);
	}
	 
	private static List<ServiceOrder> ServiceOrders = new ArrayList<ServiceOrder>();
	static {
		ServiceOrders.add(new ServiceOrder("Service order number", "Sales order number", "Store code"));
	}

	public List<ServiceOrder> retrieveExtracaoFull() throws Exception {
		FillServiceOrders(connect2db());
		return ServiceOrders;
	}

	public void addServiceOrder(ServiceOrder extracao) {
		ServiceOrders.add(extracao);
	}

	public void deleteServiceOrder(ServiceOrder extracao) {
		ServiceOrders.remove(extracao);
	}
}
