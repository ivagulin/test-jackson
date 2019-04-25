/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.ivagulin;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import com.google.common.collect.ImmutableMap;

public class MyBenchmark {

	@State(Scope.Thread)
	public static class MyState {
		public ObjectMapper defaultMapper = new ObjectMapper();

		private String user = "   {\n" + "      \"addressPostal\":{\n" + "         \"streetAddress\":\"street\",\n"
				+ "         \"postalCode\":\"123123\",\n" + "         \"locality\":\"Moscow\",\n"
				+ "         \"countryName\":\"ru\",\n" + "         \"extendedAddress\":\"\",\n"
				+ "         \"region\":\"st\"\n" + "      },\n" + "      \"displayName\":\"Test Test\",\n"
				+ "      \"givenName\":\"Test\",\n" + "      \"fullName\":\"Test Test\",\n" + "      \"services\":[\n"
				+ "\n" + "      ],\n" + "      \"telWork\":\"7#123#1231212#\",\n" + "      \"locale\":\"en_US\",\n"
				+ "      \"login\":\"273dc686-5476-486e-880a-63dd44498615\",\n" + "      \"title\":\"\",\n"
				+ "      \"userId\":6,\n" + "      \"telFax\":\"\",\n" + "      \"isAccountAdmin\":true,\n"
				+ "      \"familyName\":\"Test\",\n" + "      \"disabled\":false,\n" + "      \"locked\":false,\n"
				+ "      \"additionalName\":\"\",\n" + "      \"email\":\"root@example.com\",\n" + "      \"memberId\":5,\n"
				+ "      \"servicesMode\":\"NONE\"\n" + "   }";
		
		@Setup(Level.Trial)
		public void doSetup() {
			defaultMapper = new ObjectMapper();
//			defaultMapper.registerModule(new AfterburnerModule());
		}
	}

	private Map<String, String> generateApsInfo() {
		return ImmutableMap.of("modified", "2019-02-28T08:28:18Z", "id", "c5d43bb6-92b0-4607-9b57-bd120215d9dc", "type",
				"http://parallels.com/aps/types/pa/admin-user/1.2", "status", "aps:ready", "revision", "2");

	}

    @Benchmark
    public void testMaps(MyState state) throws Exception {
    	@SuppressWarnings("unchecked")
		Map<String, String> properties = state.defaultMapper.readValue(state.user, Map.class);
    	Map<String,Object> rv = new HashMap<>();
    	rv.putAll(properties);
    	rv.put("aps", generateApsInfo());
    	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    	JsonGenerator generator = state.defaultMapper.getFactory().createGenerator(outStream);
    	generator.writeStartArray();
    	for(int i=0; i<1000; i++) {
    		generator.writeObject(rv);
    	}
    	generator.writeEndArray();
    	generator.flush();
    }

//	@Benchmark
//	public void testNodes(MyState state) throws Exception {
//		ObjectNode properties = (ObjectNode) state.defaultMapper.readTree(state.user);
//		properties.set("aps", state.defaultMapper.convertValue(generateApsInfo(), JsonNode.class));
//		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//		JsonGenerator generator = state.defaultMapper.getFactory().createGenerator(outStream);
//		generator.writeStartArray();
//		for (int i = 0; i < 1000; i++) {
//			generator.writeObject(properties);
//		}
//		generator.writeEndArray();
//		generator.flush();
//		generator.close();
//	}
//	
//	@Benchmark
//	public void testArrayNode(MyState state) throws Exception {
//		ObjectNode properties = (ObjectNode) state.defaultMapper.readTree(state.user);
//		properties.set("aps", state.defaultMapper.convertValue(generateApsInfo(), JsonNode.class));
//		ArrayNode rv = state.defaultMapper.createArrayNode();
//		for (int i = 0; i < 1000; i++) {
//			rv.add(properties);
//		}
//		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//		state.defaultMapper.writeValue(outStream, rv);
//	}
//	
//
}
