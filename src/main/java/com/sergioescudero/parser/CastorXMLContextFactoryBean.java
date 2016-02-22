package com.sergioescudero.parser;

import org.castor.spring.xml.CastorMarshallerFactoryBean;
import org.castor.spring.xml.CastorUnmarshallerFactoryBean;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.XMLContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * Clase para poder crear instancias marshaller y unmarshaller de castor en
 * tiempo de ejecuci�n y evitar problemas de concurrencia
 */
public class CastorXMLContextFactoryBean implements InitializingBean {

	private XMLContext xmlContextUnMarshaller;
	private XMLContext xmlContextMarshaller;

	private boolean ignoreExtraAttributes = true;
	private boolean ignoreExtraElements = true;
	private boolean validation = false;
	private boolean suppressXSIType = true;
	private boolean suppressNamespaces = true;
	private String rootElement;
	private String encoding = "UTF8";

	/**
	 * @return the xmlContextUnMarshaller
	 */
	public XMLContext getXmlContextUnMarshaller() {
		return xmlContextUnMarshaller;
	}

	/**
	 * @param xmlContextUnMarshaller
	 *            the xmlContextUnMarshaller to set
	 */
	public void setXmlContextUnMarshaller(XMLContext xmlContextUnMarshaller) {
		this.xmlContextUnMarshaller = xmlContextUnMarshaller;
	}

	/**
	 * @return the xmlContextMarshaller
	 */
	public XMLContext getXmlContextMarshaller() {
		return xmlContextMarshaller;
	}

	/**
	 * @param xmlContextMarshaller
	 *            the xmlContextMarshaller to set
	 */
	public void setXmlContextMarshaller(XMLContext xmlContextMarshaller) {
		this.xmlContextMarshaller = xmlContextMarshaller;
	}

	/**
	 * @return the ignoreExtraAttributes
	 */
	public boolean isIgnoreExtraAttributes() {
		return ignoreExtraAttributes;
	}

	/**
	 * @param ignoreExtraAttributes
	 *            the ignoreExtraAttributes to set
	 */
	public void setIgnoreExtraAttributes(boolean ignoreExtraAttributes) {
		this.ignoreExtraAttributes = ignoreExtraAttributes;
	}

	/**
	 * @return the ignoreExtraElements
	 */
	public boolean isIgnoreExtraElements() {
		return ignoreExtraElements;
	}

	/**
	 * @param ignoreExtraElements
	 *            the ignoreExtraElements to set
	 */
	public void setIgnoreExtraElements(boolean ignoreExtraElements) {
		this.ignoreExtraElements = ignoreExtraElements;
	}

	/**
	 * @return the validation
	 */
	public boolean isValidation() {
		return validation;
	}

	/**
	 * @param validation
	 *            the validation to set
	 */
	public void setValidation(boolean validation) {
		this.validation = validation;
	}

	/**
	 * @return the suppressXSIType
	 */
	public boolean isSuppressXSIType() {
		return suppressXSIType;
	}

	/**
	 * @param suppressXSIType
	 *            the suppressXSIType to set
	 */
	public void setSuppressXSIType(boolean suppressXSIType) {
		this.suppressXSIType = suppressXSIType;
	}

	/**
	 * @return the suppressNamespaces
	 */
	public boolean isSuppressNamespaces() {
		return suppressNamespaces;
	}

	/**
	 * @param suppressNamespaces
	 *            the suppressNamespaces to set
	 */
	public void setSuppressNamespaces(boolean suppressNamespaces) {
		this.suppressNamespaces = suppressNamespaces;
	}

	/**
	 * @return the rootElement
	 */
	public String getRootElement() {
		return rootElement;
	}

	/**
	 * @param rootElement
	 *            the rootElement to set
	 */
	public void setRootElement(String rootElement) {
		this.rootElement = rootElement;
	}

	/**
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * @param encoding
	 *            the encoding to set
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * Crea un Objecto Marshall (para grabar objetos en xml) en funcion de las
	 * variables globales
	 * 
	 * @return
	 * @throws OxferaException
	 */
	public Unmarshaller createUnmarshaller() throws Exception {
		try {
			CastorUnmarshallerFactoryBean factory = new CastorUnmarshallerFactoryBean();
			factory.setXmlContext(xmlContextUnMarshaller);
			factory.setIgnoreExtraAttributes(ignoreExtraAttributes);
			factory.setIgnoreExtraElements(ignoreExtraElements);
			factory.setValidation(validation);
			return (Unmarshaller) factory.getObject();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	/**
	 * Crea un Objecto Marshall (para leer objetos en xml) en funcion de las
	 * variables globales
	 * 
	 * @return
	 * @throws OxferaException
	 */
	public Marshaller createMarshaller() throws Exception {
		return createMarshaller(rootElement);
	}

	/**
	 * Crea un Objecto Marshall (para leer objetos en xml) en funcion de las
	 * variables globales partiendo del objeto rootElement pasado como par�metro
	 * 
	 * @return
	 * @throws OxferaException
	 */
	private Marshaller createMarshaller(String rootElement) throws Exception {
		try {
			CastorMarshallerFactoryBean factory = new CastorMarshallerFactoryBean();
			factory.setXmlContext(xmlContextMarshaller);
			factory.setRootElement(rootElement);
			factory.setSuppressXSIType(suppressXSIType);
			factory.setSuppressNamespaces(suppressNamespaces);
			factory.setValidation(validation);
			factory.setEncoding(encoding);
			return (Marshaller) factory.getObject();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public void afterPropertiesSet() {
		String nullMessage = " cannot be null";
		Assert.notNull(xmlContextUnMarshaller, "property xmlContextUnMarshaller".concat(nullMessage));
		Assert.notNull(xmlContextMarshaller, "property xmlContextMarshaller".concat(nullMessage));
		Assert.notNull(ignoreExtraAttributes, "property ignoreExtraAttributes ".concat(nullMessage));
		Assert.notNull(ignoreExtraElements, "property ignoreExtraElements".concat(nullMessage));
		Assert.notNull(validation, "property validation".concat(nullMessage));
		Assert.notNull(suppressXSIType, "property suppressXSIType".concat(nullMessage));
		Assert.notNull(suppressNamespaces, "property suppressNamespaces".concat(nullMessage));
		Assert.notNull(rootElement, "property rootElement".concat(nullMessage));
	}
}
