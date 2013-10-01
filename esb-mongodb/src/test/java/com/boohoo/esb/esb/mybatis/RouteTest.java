package com.boohoo.esb.esb.mybatis;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;

import org.junit.Test;

public class RouteTest extends CamelBlueprintTestSupport {
	
    @Override
    protected String getBlueprintDescriptor() {
        return "/OSGI-INF/blueprint/esb-mybatis-context.xml";
    }

    @Test
    public void testRoute() throws Exception {
       
    }

}
