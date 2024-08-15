package org.makerminds.jcoaching.restaurantapp.model.table;

import java.util.ArrayList;
import java.util.List;

public class TableProvider {
	
	//deklarimi
	private List<Table> tableList;
	public TableProvider() {
		createTableList();
		
	}
	
	//set method 
	private void createTableList() 
	{
		//inicializimi
		tableList = new ArrayList<>();
		Table table1 = new Table(100, 2);
		Table table2 = new Table(101, 4);
		Table table3 = new Table(102, 6);
		Table table4 = new Table(201, 8);
		Table table5 = new Table(202, 2);
		Table table6 = new Table(203, 4);
		
		tableList.add(table1);
		tableList.add(table2);
		tableList.add(table3);
		tableList.add(table4);
		tableList.add(table5);
		tableList.add(table6);
		
	}
	
	public List<Table> getTableList() {
		return tableList;
	}

}
