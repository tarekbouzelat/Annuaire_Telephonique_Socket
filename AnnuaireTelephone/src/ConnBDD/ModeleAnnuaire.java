package ConnBDD;

import javax.swing.table.AbstractTableModel;
import java.sql.*;





public class ModeleAnnuaire extends AbstractTableModel {
ResultSet res=null;






public ModeleAnnuaire(){
	super();		
    res = getsource();
	}

private ResultSet getsource() {
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/telephone", "root", "");
		java.sql.Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    ResultSet res = stmt.executeQuery("SELECT * FROM annuaire");
	
	    return res;
	}catch(SQLException | ClassNotFoundException e){
		
		System.out.println(e.getMessage());
	}        
			
	return null;
}

public void addPersonne(AnnuairePersonne pers) {

	
	try {
		res.last();
		int size = res.getRow();
		res.moveToInsertRow();
		res.updateString(1,pers.getNom());
		res.updateString(2,pers.getNumero());
		res.insertRow();
		fireTableRowsInserted(size -1,size -1);
	}catch(SQLException e) {
		throw new RuntimeException(e);
	}
}

public void afficherpersonne() {
	
	//recuperer la personne ici
	try {
		res.getString("NumTel");
		
	}catch(SQLException e) {
		throw new RuntimeException(e);
	}
	
	
	
}
/*
public AnnuairePersonne getNumero(String nom ) {
    for(AnnuairePersonne l:afficherpersonne()) {
        if(l.getNom()==nom) {
            return l;
        }

    }
    return null;
    


}*/




public int getRowCount() {
    try {
        res.last();
        int nb = res.getRow();
        return nb;
    } catch (SQLException e) {
        // TODO Auto- generated catch block
        e.printStackTrace(); 
    } return 0; 
    }

public int getColumnCount() {
    try {
        ResultSetMetaData x = res.getMetaData();
       int col = x.getColumnCount();
        return col; 
    }  catch (SQLException e) {
        // TODO Auto- generated catch block
        e.printStackTrace();
    }
    return 0;
}
public String getColumnName(int columnIndex) {
    try {
        ResultSetMetaData x = res.getMetaData();
       String col = x.getColumnName(columnIndex+1);
        return col; 
    }  catch (SQLException e) {
        // TODO Auto- generated catch block
        e.printStackTrace();
    }
    return "";
}
public Object getValueAt(int rowIndex, int columnIndex) {
   try {res.absolute(rowIndex+1);
  return res.getObject(columnIndex+1); 
 } catch (SQLException e) {
        // TODO Auto- generated catch block
        e.printStackTrace();
 }
    return null;
}

public boolean isCellEditable(int rowIndex,int columnIndex) {
	return true;
	
}

public void setValueAt(Object aValue,int rowIndex,int columnIndex) {
	if(aValue!=null) {
		try {
			
			res.absolute(rowIndex+1);
			res.updateObject(columnIndex+1,aValue);
			res.updateRow();
			
			
		}catch (SQLException e) {
	        // TODO Auto- generated catch block
	        e.printStackTrace();
	 }
	    
}
}

public void removePersonne(int rowIndex) throws SQLException {
	
	
		res.absolute(rowIndex);
		res.deleteRow();
		fireTableDataChanged();
	
}
public void addPersonne(int rowIndex) throws SQLException {
	
	
}
}

