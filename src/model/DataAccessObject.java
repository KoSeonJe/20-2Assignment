package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.Vector;


public class DataAccessObject {



	public MModel getAModel(String fileName, Class<?> clazz, String key) {
		try {			
			File file = new File("data/" + fileName);
			if(!file.exists()) {
				try {
					file.createNewFile();
					return null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Scanner scanner = new Scanner(file);
			
			Constructor<?> constructor = clazz.getConstructor();
			MModel mModel = (MModel) constructor.newInstance();
			while (scanner.hasNext()) {
				String mModelKey = mModel.read(scanner , key);
				if(key.contentEquals(mModelKey)) {
					return mModel;
				}
			}
			scanner.close();
		} catch (FileNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	public Vector<MModel> getModels(String filename, Class<?> clazz) {
		Vector<MModel> mModels = new Vector<MModel>();
		try {
			File file = new File("data/" + filename);
			if(!file.exists()) {
				try {
					file.createNewFile();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNext()) {
			 Constructor<?> constructor = clazz.getConstructor();
			 MModel mModel = (MModel) constructor.newInstance();
				mModel.read(scanner, "1");
				mModels.add(mModel);
				
			}
			scanner.close();
		} catch (FileNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
       
		
		return mModels;
	}
	

	public void save(String filename, Vector<MModel> mModels) {
		// TODO Auto-generated method stub
		try {
			File file = new File("data/" + filename);
			if(filename != "LoginInfo.txt") {
			file.delete();
			}
			if(!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			FileWriter fileWriter = new FileWriter(file,true);
			
			for(MModel mModel : mModels) {
				mModel.save(fileWriter);
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	}
	

