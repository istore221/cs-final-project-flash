package cs.pkgfinal.project;

import java.sql.*;
import java.util.Arrays;
import cs.pkgfinal.project.lib.*;
import cs.pkgfinal.project.lib.CandidateAssignment;
import cs.pkgfinal.project.lib.CandidateSolution;
import cs.pkgfinal.project.lib.GeneticAlgorithm;
import cs.pkgfinal.project.lib.PreferenceTable;
import cs.pkgfinal.project.lib.SimulatedAnnealing;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BeanMain implements java.io.Serializable {
	String currentUserFilePath = null;

	public void setCurrentUserFilePath(String currentUserFilePath){
		this.currentUserFilePath = currentUserFilePath;
	}

	public String getCurrentUserFilePath(){
		return this.currentUserFilePath;
	}

	public String getSimulatedAnnealingSolution(long iterations, int noOfProjectsToOneStudent){
		JSONObject mainJson = new JSONObject();

		try{
			PreferenceTable prefs = new PreferenceTable(this.currentUserFilePath);
			SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(prefs, iterations);

			long start = System.currentTimeMillis();
			CandidateSolution solution = simulatedAnnealing.anneal(noOfProjectsToOneStudent);
			double time_took = System.currentTimeMillis() - start;

			String time_took_string = "ms";
				
			if(time_took > 1000){
				time_took = time_took / 1000;
				time_took_string = "secs";
				
				if(time_took > 60){
					time_took = time_took / 60;
					time_took_string = "mins";
				}
			}
		
			JSONObject summary1 = new JSONObject();
			summary1.put("title", "Energy");
			summary1.put("value", solution.getEnergy());
			
			JSONObject summary2 = new JSONObject();
			summary2.put("title", "Time taken to run");
			summary2.put("value", (Math.round(time_took * 100.0) / 100.0) + " " + time_took_string);
			
			JSONObject summary3 = new JSONObject();
			summary3.put("title", "Validity");
			summary3.put("value", solution.isValid() ? "Valid" : "Not Valid");
			
			JSONArray summary_values = new JSONArray();
			summary_values.add(summary1);
			summary_values.add(summary2);
			summary_values.add(summary3);

			mainJson.put("summary", summary_values);
			
			
			JSONObject tableheader1 = new JSONObject();
			tableheader1.put("tableheader", "#");
			
			JSONObject tableheader2 = new JSONObject();
			tableheader2.put("tableheader", "Student Name");
			
			JSONObject tableheader3 = new JSONObject();
			tableheader3.put("tableheader", "Preferences");

			JSONObject tableheader4 = new JSONObject();
			tableheader4.put("tableheader", "Current Project");
			
			JSONArray table_headers = new JSONArray();
			table_headers.add(tableheader1);
			table_headers.add(tableheader2);
			table_headers.add(tableheader3);
			table_headers.add(tableheader4);

			mainJson.put("tableheaders", table_headers);
			
			int row = 1;
			JSONArray table_data = new JSONArray();
	        for(CandidateAssignment caAss : solution.getCandidateAssignments()){
				
	        	JSONObject tabledata = new JSONObject();
	        	tabledata.put("col1", row++);
	        	
	        	tabledata.put("col2", caAss.getStudent().getStudentName());
	        	
	        	int prefCount = 1;
				JSONArray preferences = new JSONArray();
	        	for(String prefrns : caAss.getStudent().getOrderedPreferences()){
	        		JSONObject preference = new JSONObject();
	        		preference.put("pref", (prefCount++) + ". " + prefrns);
	        		preferences.add(preference);
	        	}
	        	
	        	tabledata.put("col3", preferences);
	        	
	        	tabledata.put("col4", caAss.getProject());

	        	if(solution.getDuplicateAssignedProjects().get(caAss.getProject()) != null && solution.getDuplicateAssignedProjects().get(caAss.getProject()) > 1){
                	tabledata.put("col5", true);
            	}
            	else {
                	tabledata.put("col5", false);
            	}

	        	table_data.add(tabledata);
	        }
			mainJson.put("tabledata", table_data);
		}
		catch (FileNotFoundException ex) {
	    	return ex.getMessage();        
	    } 
	    catch (IOException ex) {
	        return ex.getMessage();
	    }

		return mainJson.toJSONString();
	}

	public String getGeneticAlgorithmSolution(long initialPopulation, long generations, int noOfProjectsToOneStudent){
		JSONObject mainJson = new JSONObject();

		try{
			PreferenceTable prefs = new PreferenceTable(this.currentUserFilePath);
			GeneticAlgorithm geneticalgorithm = new GeneticAlgorithm(prefs, initialPopulation, generations);

			long start = System.currentTimeMillis();
			CandidateSolution solution = geneticalgorithm.populate(noOfProjectsToOneStudent);
			double time_took = System.currentTimeMillis() - start;

			String time_took_string = "ms";
				
			if(time_took > 1000){
				time_took = time_took / 1000;
				time_took_string = "secs";
				
				if(time_took > 60){
					time_took = time_took / 60;
					time_took_string = "mins";
				}
			}
		
			JSONObject summary1 = new JSONObject();
			summary1.put("title", "Fitness");
			summary1.put("value", solution.getFitness());
			
			JSONObject summary2 = new JSONObject();
			summary2.put("title", "Time taken to run");
			summary2.put("value", (Math.round(time_took * 100.0) / 100.0) + " " + time_took_string);
			
			JSONObject summary3 = new JSONObject();
			summary3.put("title", "Validity");
			summary3.put("value", solution.isValid() ? "Valid" : "Not Valid");
			
			JSONArray summary_values = new JSONArray();
			summary_values.add(summary1);
			summary_values.add(summary2);
			summary_values.add(summary3);

			mainJson.put("summary", summary_values);
			
			
			JSONObject tableheader1 = new JSONObject();
			tableheader1.put("tableheader", "#");
			
			JSONObject tableheader2 = new JSONObject();
			tableheader2.put("tableheader", "Student Name");
			
			JSONObject tableheader3 = new JSONObject();
			tableheader3.put("tableheader", "Preferences");

			JSONObject tableheader4 = new JSONObject();
			tableheader4.put("tableheader", "Current Project");
			
			JSONArray table_headers = new JSONArray();
			table_headers.add(tableheader1);
			table_headers.add(tableheader2);
			table_headers.add(tableheader3);
			table_headers.add(tableheader4);

			mainJson.put("tableheaders", table_headers);
			
			int row = 1;
			JSONArray table_data = new JSONArray();
	        for(CandidateAssignment caAss : solution.getCandidateAssignments()){
				
	        	JSONObject tabledata = new JSONObject();
	        	tabledata.put("col1", row++);
	        	
	        	tabledata.put("col2", caAss.getStudent().getStudentName());
	        	
	        	int prefCount = 1;
				JSONArray preferences = new JSONArray();
	        	for(String prefrns : caAss.getStudent().getOrderedPreferences()){
	        		JSONObject preference = new JSONObject();
	        		preference.put("pref", (prefCount++) + ". " + prefrns);
	        		preferences.add(preference);
	        	}
	        	
	        	tabledata.put("col3", preferences);
	        	
	        	tabledata.put("col4", caAss.getProject());

	        	if(solution.getDuplicateAssignedProjects().get(caAss.getProject()) != null && solution.getDuplicateAssignedProjects().get(caAss.getProject()) > 1){
                	tabledata.put("col5", true);
            	}
            	else {
                	tabledata.put("col5", false);
            	}

	        	table_data.add(tabledata);
	        }
			mainJson.put("tabledata", table_data);
		}
		catch (FileNotFoundException ex) {
	    	return ex.getMessage();        
	    } 
	    catch (IOException ex) {
	        return ex.getMessage();
	    }

		return mainJson.toJSONString();
	}
}