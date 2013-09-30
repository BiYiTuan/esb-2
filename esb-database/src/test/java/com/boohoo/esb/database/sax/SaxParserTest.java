package com.boohoo.esb.database.sax;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
@Ignore
public class SaxParserTest {
	@Test
	public void test() throws TransformerException, UnsupportedEncodingException, FileNotFoundException, XMLStreamException, FactoryConfigurationError{
		Person person = new Person(null);
		new SaxParser().write(person);
	}
}
