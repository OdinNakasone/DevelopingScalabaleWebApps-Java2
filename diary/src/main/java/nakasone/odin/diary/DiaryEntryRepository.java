package nakasone.odin.diary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class DiaryEntryRepository {
	
	private List<DiaryEntry> entries = new ArrayList<>();
	
	public void save(DiaryEntry entry) {
//		if(entries.stream().filter(e -> e.getId() == entry.getId()).count() > 0) {
//			throw new RuntimeException("The id" + entry.getId() + " already exists");
//		}
		try {

			// Initialize the database
			Connection con = DiaryDatabaseConnection.initializeDatabase();

			// Create a SQL query to insert data into demo table
			PreparedStatement pst = con.prepareStatement("insert into diaries values(?, ?, ?)");
			
			pst.setInt(1, entry.getId());
			pst.setString(2, entry.getText());
			pst.setString(3, String.valueOf(entry.getCreateDate()));

			

			// Execute the insert command using executeUpdate()
			// to make changes in database
			pst.executeUpdate();

			// Close all the connections
			pst.close();
			con.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		entries.add(entry);
	}
	
	public List<DiaryEntry> findAll(){
		return entries.stream().sorted(Comparator.comparing(DiaryEntry::getCreateDate).reversed()).collect(Collectors.toList());
	}
	
	public Optional<DiaryEntry> findById(int id) {
		return entries.stream().filter(e -> e.getId() == id).findFirst();
		
	}
	
}
