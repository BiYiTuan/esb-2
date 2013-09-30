package com.boohoo.esb.database.sax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class SaxParser {
	public void write(Person person) throws XMLStreamException, UnsupportedEncodingException, FactoryConfigurationError, FileNotFoundException{
		OutputStream outputStream = new FileOutputStream(new File("target/doc.xml"));
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

		XMLStreamWriter out = xmlOutputFactory.createXMLStreamWriter(new OutputStreamWriter(outputStream, "utf-8"));
		out.writeStartDocument();
		try {
			out.writeStartElement(person.getClass().getSimpleName().toLowerCase());
			out.writeStartElement("name");
			out.writeCharacters(person.getName().toString());
			out.writeEndElement();
			out.writeEndElement();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.writeEndDocument();
			out.close();
		}
	}
}
