package zarazio.travel.android.bean;

import java.sql.Timestamp;

public class boardLIstDTO {
	private int board_Code;
    private String board_Title;
	private String board_Content;
	private double log_longtitude;
	private double log_latitude;
	private int share_Type;
	private Timestamp board_Date;
	private int board_Type_Code;
	private String user_id;
	private int place_Score;
	private int step_Log_Code;
	private int randomViewY;
	private String file_Type;
	private String file_Content;
	
	public int getBoard_Code() {
		return board_Code;
	}
	public void setBoard_Code(int board_Code) {
		this.board_Code = board_Code;
	}
	public String getBoard_Title() {
		return board_Title;
	}
	public void setBoard_Title(String board_Title) {
		this.board_Title = board_Title;
	}
	public String getBoard_Content() {
		return board_Content;
	}
	public void setBoard_Content(String board_Content) {
		this.board_Content = board_Content;
	}
	public double getLog_longtitude() {
		return log_longtitude;
	}
	public void setLog_longtitude(double log_longtitude) {
		this.log_longtitude = log_longtitude;
	}
	public double getLog_latitude() {
		return log_latitude;
	}
	public void setLog_latitude(double log_latitude) {
		this.log_latitude = log_latitude;
	}
	public int getShare_Type() {
		return share_Type;
	}
	public void setShare_Type(int share_Type) {
		this.share_Type = share_Type;
	}
	public int getBoard_Type_Code() {
		return board_Type_Code;
	}
	public void setBoard_Type_Code(int board_Type_Code) {
		this.board_Type_Code = board_Type_Code;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPlace_Score() {
		return place_Score;
	}
	public void setPlace_Score(int place_Score) {
		this.place_Score = place_Score;
	}
	public int getStep_Log_Code() {
		return step_Log_Code;
	}
	public void setStep_Log_Code(int step_Log_Code) {
		this.step_Log_Code = step_Log_Code;
	}
	public int getRandomViewY() {
		return randomViewY;
	}
	public void setRandomViewY(int randomViewY) {
		this.randomViewY = randomViewY;
	}
	public Timestamp getBoard_Date() {
		return board_Date;
	}
	public void setBoard_Date(Timestamp board_Date) {
		this.board_Date = board_Date;
	}
	public String getFile_Type() {
		return file_Type;
	}
	public void setFile_Type(String file_Type) {
		this.file_Type = file_Type;
	}
	public String getFile_Content() {
		return file_Content;
	}
	public void setFile_Content(String file_Content) {
		this.file_Content = file_Content;
	}
	
	
	
}