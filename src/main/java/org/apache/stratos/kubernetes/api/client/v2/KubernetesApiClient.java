package org.apache.stratos.kubernetes.api.client.v2;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.stratos.kubernetes.api.client.interfaces.KubernetesAPIClientInterface;
import org.apache.stratos.kubernetes.api.exceptions.KubernetesClientException;
import org.apache.stratos.kubernetes.api.model.Pod;
import org.apache.stratos.kubernetes.api.model.PodList;
import org.apache.stratos.kubernetes.api.model.ReplicationController;
import org.apache.stratos.kubernetes.api.model.Service;
import org.apache.stratos.kubernetes.api.model.ServiceList;

public class KubernetesApiClient implements KubernetesAPIClientInterface{

	private URI endpointURI;
	private KubernetesAPIClientInterface api;

	public KubernetesApiClient(String endpointUrl) {
		try {
			endpointURI = new URI(endpointUrl);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}		
		api = RestFactory.createAPI(endpointURI, null, null);
	}
	
	
	
	@Override
	public Pod getPod(String podId) throws KubernetesClientException {
		Pod pod = api.getPod(podId);
		return pod;
	}

	@Override
	public PodList getAllPods() throws KubernetesClientException {
		try {
			PodList pods = api.getAllPods();
			return pods;
		} catch(Exception e) {
			throw new KubernetesClientException(e);
		}
	}

	@Override
	public void createPod(Pod pod) throws KubernetesClientException {
		try {
			api.createPod(pod);
		} catch (Exception e) {
			throw new KubernetesClientException(e);
		}
	}

	@Override
	public void deletePod(String podId) throws KubernetesClientException {
		
		api.deletePod(podId);
	}

	@Override
	public ReplicationController getReplicationController(String controllerId)
			throws KubernetesClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReplicationController[] getAllReplicationControllers()
			throws KubernetesClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createReplicationController(ReplicationController controller)
			throws KubernetesClientException {
		
	}

	@Override
	public void deleteReplicationController(String controllerId)
			throws KubernetesClientException {
		
	}

	@Override
	public Service getService(String serviceId)
			throws KubernetesClientException {
		try {
			return api.getService(serviceId); 
		} catch (Exception e) {
			throw new KubernetesClientException(e);
		}
	}

	@Override
	public ServiceList getAllServices() throws KubernetesClientException {
		try {
			return api.getAllServices(); 
		} catch (Exception e) {
			throw new KubernetesClientException(e);
		}
	}

	@Override
	public void createService(Service service) throws KubernetesClientException {
		try {
			api.createService(service);
		} catch(Exception e) {
			throw new KubernetesClientException(e);
		}
		
	}

	@Override
	public void deleteService(String serviceId)
			throws KubernetesClientException {
		try {
			api.deleteService(serviceId);
		} catch(Exception e) {
			throw new KubernetesClientException(e);			
		}
	}

}
