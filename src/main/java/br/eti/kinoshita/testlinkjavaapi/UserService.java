package br.eti.kinoshita.testlinkjavaapi;

import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;

import br.eti.kinoshita.testlinkjavaapi.constants.TestLinkMethods;
import br.eti.kinoshita.testlinkjavaapi.constants.TestLinkParams;
import br.eti.kinoshita.testlinkjavaapi.model.User;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import br.eti.kinoshita.testlinkjavaapi.util.Util;

/**
 * Class responsible for User services.
 * 
 * @author Franclis Galdino da Silva
 * @since 1.9.8-4
 */
class UserService extends BaseService {

	/**
	 * @param xmlRpcClient
	 *            XML RPC Client.
	 * @param devKey
	 *            TestLink User DevKey.
	 */
	public UserService(XmlRpcClient xmlRpcClient, String devKey) {
		super(xmlRpcClient, devKey);
	}

	/**
	 * Creates a Test Project.
	 * 
	 * @return Created User object.
	 */
	protected User createUser(String username, String firstName, String lastName, String email, Boolean isAdmin)
			throws TestLinkAPIException {

		try {
			User user = new User(username, firstName, lastName, email);

			Map<String, Object> executionData = Util.getUserMap(user);
			executionData.put(TestLinkParams.ADMIN.toString(), isAdmin);

			Object response = this.executeXmlRpcCall(TestLinkMethods.CREATE_USER.toString(), executionData);

			Integer userId = Integer.parseInt(response.toString());
			
			user.setDbID(userId);
			
			return user;
		} catch (XmlRpcException xmlrpcex) {
			throw new TestLinkAPIException("Error on connection with api" + xmlrpcex.getMessage(), xmlrpcex);
		} catch (TestLinkAPIException tlEx) {
			throw new TestLinkAPIException("Error create user: " + tlEx.getMessage(), tlEx);
		}
	}

}
