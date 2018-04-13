/*Interface class*/
package controller;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public interface Add {
	
	public void addDoctor() throws Exception;

	public void addPatients();

	public void serchDoctor();

	public void searchPatient();

	public void takeAppointment() throws JsonGenerationException, JsonMappingException, IOException;

}
