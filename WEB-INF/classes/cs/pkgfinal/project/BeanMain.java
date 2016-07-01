package cs.pkgfinal.project;
import java.sql.*;
import java.util.Arrays;
import cs.pkgfinal.project.lib.*;

public class BeanMain implements java.io.Serializable {
	String currentUserFilePath = null;
	int noOfProjectsToOneStudent = 0;

	public void setCurrentUserFilePath(String currentUserFilePath){
		this.currentUserFilePath = currentUserFilePath;
	}

	public String getCurrentUserFilePath(){
		return this.currentUserFilePath;
	}

	public void setNoOfProjectsToOneStudent(int noOfProjectsToOneStudent){
		this.noOfProjectsToOneStudent = noOfProjectsToOneStudent;
	}

	public int getNoOfProjectsToOneStudent(){
		return this.noOfProjectsToOneStudent;
	}
}