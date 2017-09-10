package com.c4networks.vrms.handler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class C4NetworksSOAPHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public void close(MessageContext msgCtxt) {
		System.out.println("C4NetworksSOAPHandler.close");

	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("C4NetworksSOAPHandler.handleFault");
		return false;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("C4NetworksSOAPHandler.handleMessage");
		Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (isRequest) {
			try {
				SOAPMessage soapMsg = context.getMessage();
				SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
				SOAPHeader soapHeader = soapEnv.getHeader();
				this.printFormattedXML(soapMsg);

			} catch (SOAPException e) {
				System.err.println(e);
			} catch (IOException e) {
				System.err.println(e);
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("C4NetworksSOAPHandler.handleMessage");
		return null;
	}

	private void printFormattedXML(SOAPMessage message) throws Exception {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		message.writeTo(bout);
		String xml = bout.toString();

		Source xmlInput = new StreamSource(new StringReader(xml));
		StringWriter stringWriter = new StringWriter();
		StreamResult xmlOutput = new StreamResult(stringWriter);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		transformerFactory.setAttribute("indent-number", 5);
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(xmlInput, xmlOutput);
		String xmlString = xmlOutput.getWriter().toString();

		System.out.println(xmlString);
	}

}
