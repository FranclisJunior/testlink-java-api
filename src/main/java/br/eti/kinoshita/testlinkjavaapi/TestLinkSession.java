package br.eti.kinoshita.testlinkjavaapi;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConversionException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.eti.kinoshita.testlinkjavaapi.constants.TestLinkMethods;
import br.eti.kinoshita.testlinkjavaapi.constants.TestLinkParams;
import br.eti.kinoshita.testlinkjavaapi.model.Authentication;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

public class TestLinkSession {
	
	private static final Logger LOG = LoggerFactory.getLogger(TestLinkSession.class);
	
	 // Constants for properties
    private static final String XMLRPC_BASIC_ENCODING = "xmlrpc.basicEncoding";
    private static final String XMLRPC_BASIC_PASSWORD = "xmlrpc.basicPassword";
    private static final String XMLRPC_BASIC_USERNAME = "xmlrpc.basicUsername";
    private static final String XMLRPC_CONNECTION_TIMEOUT = "xmlrpc.connectionTimeout";
    private static final String XMLRPC_CONTENT_LENGTH_OPTIONAL = "xmlrpc.contentLengthOptional";
    private static final String XMLRPC_ENABLED_FOR_EXCEPTIONS = "xmlrpc.enabledForExceptions";
    private static final String XMLRPC_ENCODING = "xmlrpc.encoding";
    private static final String XMLRPC_GZIP_COMPRESSION = "xmlrpc.gzipCompression";
    private static final String XMLRPC_GZIP_REQUESTING = "xmlrpc.gzipRequesting";
    private static final String XMLRPC_REPLY_TIMEOUT = "xmlrpc.replyTimeout";
    private static final String XMLRPC_USER_AGENT = "xmlrpc.userAgent";
	
	private XmlRpcClient xmlRpcClient;
	
	private Authentication authentication;
	
	
	public TestLinkSession(URL url, Authentication authentication){
		this.authentication = authentication;
		this.xmlRpcClient = new XmlRpcClient();
        final CompositeConfiguration appConfig = this.createApplicationConfiguration();
        final XmlRpcClientConfigImpl config = this.createXmlRpcClientConfiguration(url, appConfig);
        this.xmlRpcClient.setConfig(config);
	}
	
	public String generateDevKey() throws TestLinkAPIException {
		try {
			Map<String, Object> executionData = new HashMap<String, Object>();
			executionData.put(TestLinkParams.USER.toString(), authentication.getUsername());
			executionData.put(TestLinkParams.PASSWORD.toString(), authentication.getPassword());
			
			List<Object> params = new ArrayList<Object>();
			params.add(executionData);
			
			Object object = xmlRpcClient.execute(TestLinkMethods.GENERATOR_DEV_KEY.toString(), params);
			String devKey = (String) object;
			
			return devKey;
		} catch (XmlRpcException xmlrpcex) {
			 throw new TestLinkAPIException("Error retrieving dev key: verify user and password"
						    + xmlrpcex.getMessage(), xmlrpcex);
		}
	}
	
	private CompositeConfiguration createApplicationConfiguration() {
        CompositeConfiguration appConfig = new CompositeConfiguration();
        appConfig.addConfiguration(new SystemConfiguration());
        try {
            appConfig.addConfiguration(new PropertiesConfiguration("testlinkjavaapi.properties"));
        } catch (ConfigurationException ce) {
            this.debug(ce);
        }
        return appConfig;
    }
	
    private XmlRpcClientConfigImpl createXmlRpcClientConfiguration(URL url, CompositeConfiguration appConfig) {
        final XmlRpcClientConfigImpl xmlRpcClientConfig = new XmlRpcClientConfigImpl();

        xmlRpcClientConfig.setServerURL(url);
        xmlRpcClientConfig.setEnabledForExtensions(true);

        xmlRpcClientConfig.setBasicEncoding(appConfig.getString(XMLRPC_BASIC_ENCODING));
        xmlRpcClientConfig.setBasicPassword(appConfig.getString(XMLRPC_BASIC_PASSWORD));
        xmlRpcClientConfig.setBasicUserName(appConfig.getString(XMLRPC_BASIC_USERNAME));

        try {
            xmlRpcClientConfig.setConnectionTimeout(appConfig.getInt(XMLRPC_CONNECTION_TIMEOUT));
        } catch (ConversionException ce) {
            this.debug(ce);
        } catch (NoSuchElementException nsee) {
            this.debug(nsee);
        }

        try {
            xmlRpcClientConfig.setContentLengthOptional(appConfig.getBoolean(XMLRPC_CONTENT_LENGTH_OPTIONAL));
        } catch (ConversionException ce) {
            this.debug(ce);
        } catch (NoSuchElementException nsee) {
            this.debug(nsee);
        }

        try {
            xmlRpcClientConfig.setEnabledForExceptions(appConfig.getBoolean(XMLRPC_ENABLED_FOR_EXCEPTIONS));
        } catch (ConversionException ce) {
            this.debug(ce);
        } catch (NoSuchElementException nsee) {
            this.debug(nsee);
        }

        xmlRpcClientConfig.setEncoding(appConfig.getString(XMLRPC_ENCODING));

        try {
            xmlRpcClientConfig.setGzipCompressing(appConfig.getBoolean(XMLRPC_GZIP_COMPRESSION));
        } catch (ConversionException ce) {
            this.debug(ce);
        } catch (NoSuchElementException nsee) {
            this.debug(nsee);
        }

        try {
            xmlRpcClientConfig.setGzipRequesting(appConfig.getBoolean(XMLRPC_GZIP_REQUESTING));
        } catch (ConversionException ce) {
            this.debug(ce);
        } catch (NoSuchElementException nsee) {
            this.debug(nsee);
        }

        try {
            xmlRpcClientConfig.setReplyTimeout(appConfig.getInt(XMLRPC_REPLY_TIMEOUT));
        } catch (ConversionException ce) {
            this.debug(ce);
        } catch (NoSuchElementException nsee) {
            this.debug(nsee);
        }

        xmlRpcClientConfig.setUserAgent(appConfig.getString(XMLRPC_USER_AGENT));

        return xmlRpcClientConfig;
    }
	
    private void debug(Throwable throwable) {
        if (LOG.isDebugEnabled()) {
            LOG.debug(throwable.getMessage(), throwable);
        }
    }
    
}
