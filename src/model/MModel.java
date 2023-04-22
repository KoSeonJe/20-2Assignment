package model;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;

public abstract class MModel {
	public MModel() {
		
	}

	public String read(Scanner scanner, String sign) {
		String key = null;
		try {
			Field[] fields=	this.getClass().getDeclaredFields();
			for(Field field : fields) {
				String fieldValue = scanner.next();
				field.setAccessible(true);
				field.set(this, fieldValue);
				
			}
			
			if(sign.contentEquals((String)fields[2].get(this)) ) {
				key = (String)fields[2].get(this);

			}else {
				key = (String)fields[0].get(this);

			}
			
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	
	return key;
	}

	public void save(FileWriter fileWriter) {
		try {
			Field[] fields=	this.getClass().getDeclaredFields();
			for(Field field : fields) {
				field.setAccessible(true);
				try {
					fileWriter.write(field.get(this) + " ");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
			try {
				fileWriter.write("\r");
				fileWriter.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
