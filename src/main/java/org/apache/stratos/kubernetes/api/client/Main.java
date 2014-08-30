/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.apache.stratos.kubernetes.api.client;
import org.apache.stratos.kubernetes.api.model.Pod;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;


public class Main {

	public static void main(String[] args) throws Exception {
		
		final String KUBERNETES_API_ENDPOINT = "http://54.255.46.34:8080/api/v1beta1/pods/{podId}";
		ClientRequest req = new ClientRequest(KUBERNETES_API_ENDPOINT);
 
        ClientResponse<Pod> res = req.pathParameter("podId","redis-master-2").get(Pod.class);
        System.out.println(res.getEntity().getKind());



	}

}
