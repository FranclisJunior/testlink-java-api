package br.eti.kinoshita.testlinkjavaapi;

import java.util.HashMap;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;

import br.eti.kinoshita.testlinkjavaapi.constants.TestLinkMethods;
import br.eti.kinoshita.testlinkjavaapi.constants.TestLinkParams;
import br.eti.kinoshita.testlinkjavaapi.constants.TestLinkResponseParams;
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
	@SuppressWarnings("unchecked")
	public User createUser(String username, String firstName, String lastName, String email)
			throws TestLinkAPIException {

		try {
			User user = new User(username, firstName, lastName, email);

			Map<String, Object> executionData = Util.getUserMap(user);

			Object response = this.executeXmlRpcCall(TestLinkMethods.CREATE_USER.toString(), executionData);

			Object[] responseArray = (Object[]) response;
			Map<String, Object> responseMap = (Map<String, Object>) responseArray[0];

			Integer id = Util.getInteger(responseMap, TestLinkResponseParams.ID.toString());
			
			user.setDbID(id);
			
			return user;
		} catch (XmlRpcException xmlrpcex) {
			throw new TestLinkAPIException("Error create user: " + xmlrpcex.getMessage(), xmlrpcex);
		}
	}

}
