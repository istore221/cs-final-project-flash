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
		
			JSONObject tableheader1 = new JSONObject();
			tableheader1.put("tableheader", "#");
			
			JSONObject tableheader2 = new JSONObject();
			tableheader2.put("tableheader", "Student Name");
			
			JSONObject tableheader3 = new JSONObject();
			tableheader3.put("tableheader", "Preferences");

			JSONObject tableheader4 = new JSONObject();
			tableheader4.put("tableheader", "Current Project");

			JSONObject tableheader5 = new JSONObject();
			tableheader5.put("tableheader", "Disappointed");
			
			JSONArray table_headers = new JSONArray();
			table_headers.add(tableheader1);
			table_headers.add(tableheader2);
			table_headers.add(tableheader3);
			table_headers.add(tableheader4);
			table_headers.add(tableheader5);

			mainJson.put("tableheaders", table_headers);
			
			int row = 1, non_conflict_count = 0;
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
                	non_conflict_count++;
            	}

            	tabledata.put("col6", caAss.getDisappointment());

	        	table_data.add(tabledata);
	        }
			mainJson.put("tabledata", table_data);

			JSONObject summary1 = new JSONObject();
			summary1.put("title", "Energy");
			summary1.put("value", solution.getEnergy() + " (closer to 0 is better)");
			
			JSONObject summary2 = new JSONObject();
			summary2.put("title", "Time taken to run");
			summary2.put("value", (Math.round(time_took * 100.0) / 100.0) + " " + time_took_string);
			
			double nonConflctPrjs = (Math.round((((float)non_conflict_count / (float)solution.getCandidateAssignments().size()) * 100) * 100.0) / 100.0);
			
			JSONObject summary3 = new JSONObject();
			summary3.put("title", "Non conflicted projects");
			summary3.put("value", nonConflctPrjs + " %");
			
			JSONObject summary4 = new JSONObject();
			summary4.put("title", "Conflicted projects");
			summary4.put("value", (Math.round((100 - nonConflctPrjs) * 100.0) / 100.0) + " %");

			JSONArray conflicted_projects = new JSONArray();
			for(String projectName : solution.getDuplicateAssignedProjects().keySet()){
				JSONObject conflict_project = new JSONObject();
                conflict_project.put("confl", projectName + " - " + solution.getDuplicateAssignedProjects().get(projectName));
                conflicted_projects.add(conflict_project);
			}
			
			JSONObject summary5 = new JSONObject();
			summary5.put("title", "Conflicting projects");
			summary5.put("value", conflicted_projects);
			
			JSONArray summary_values = new JSONArray();
			summary_values.add(summary1);
			summary_values.add(summary2);
			summary_values.add(summary3);
			summary_values.add(summary4);
			summary_values.add(summary5);

			mainJson.put("summary", summary_values);
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
		
			JSONObject tableheader1 = new JSONObject();
			tableheader1.put("tableheader", "#");
			
			JSONObject tableheader2 = new JSONObject();
			tableheader2.put("tableheader", "Student Name");
			
			JSONObject tableheader3 = new JSONObject();
			tableheader3.put("tableheader", "Preferences");

			JSONObject tableheader4 = new JSONObject();
			tableheader4.put("tableheader", "Current Project");

			JSONObject tableheader5 = new JSONObject();
			tableheader5.put("tableheader", "Disappointed");
			
			JSONArray table_headers = new JSONArray();
			table_headers.add(tableheader1);
			table_headers.add(tableheader2);
			table_headers.add(tableheader3);
			table_headers.add(tableheader4);
			table_headers.add(tableheader5);

			mainJson.put("tableheaders", table_headers);
			
			int row = 1, non_conflict_count = 0;
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
                	non_conflict_count++;
            	}

            	tabledata.put("col6", caAss.getDisappointment());

	        	table_data.add(tabledata);
	        }
			mainJson.put("tabledata", table_data);

			JSONObject summary1 = new JSONObject();
			summary1.put("title", "Fitness");
			summary1.put("value", solution.getFitness() + " (closer to 0 is better)");
			
			JSONObject summary2 = new JSONObject();
			summary2.put("title", "Time taken to run");
			summary2.put("value", (Math.round(time_took * 100.0) / 100.0) + " " + time_took_string);
			
			double nonConflctPrjs = (Math.round((((float)non_conflict_count / (float)solution.getCandidateAssignments().size()) * 100) * 100.0) / 100.0);
			
			JSONObject summary3 = new JSONObject();
			summary3.put("title", "Non conflicted projects");
			summary3.put("value", nonConflctPrjs + " %");
			
			JSONObject summary4 = new JSONObject();
			summary4.put("title", "Conflicted projects");
			summary4.put("value", (Math.round((100 - nonConflctPrjs) * 100.0) / 100.0) + " %");

			JSONArray conflicted_projects = new JSONArray();
			for(String projectName : solution.getDuplicateAssignedProjects().keySet()){
				JSONObject conflict_project = new JSONObject();
                conflict_project.put("confl", projectName + " - " + solution.getDuplicateAssignedProjects().get(projectName));
                conflicted_projects.add(conflict_project);
			}
			
			JSONObject summary5 = new JSONObject();
			summary5.put("title", "Conflicting projects");
			summary5.put("value", conflicted_projects);
			
			JSONArray summary_values = new JSONArray();
			summary_values.add(summary1);
			summary_values.add(summary2);
			summary_values.add(summary3);
			summary_values.add(summary4);
			summary_values.add(summary5);

			mainJson.put("summary", summary_values);
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