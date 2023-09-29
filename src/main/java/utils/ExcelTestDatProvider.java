package utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class ExcelTestDatProvider {
	ExcelUtils Excelobj;
	int Rownum;
	int Colnum;
	JSONObject obj = new JSONObject();
	JSONArray array = new JSONArray();
	
	public JSONArray testdataprovider(String path, String sheetname) {
		
		Excelobj = new ExcelUtils(path, sheetname);
		Rownum =  Excelobj.getRownum();
		Colnum =  Excelobj.getColnum();
	
		for(int i=1;i<Rownum;i++) {
			for(int j=0;j<Colnum;j++) {
				
				obj.put(Excelobj.getStringcellData(0, j), Excelobj.getStringcellData(i, j));	
			}
			array.put(obj);
		}
		return array;
	}
	
	
	public void CloseExcelConnection() {
		Excelobj.closeExcelWB();
	}

}
