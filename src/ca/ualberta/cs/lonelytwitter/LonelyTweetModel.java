package ca.ualberta.cs.lonelytwitter;
import java.util.Date;

public abstract class LonelyTweetModel{
	private String text;
	private Date timestamp;
	
	public LonelyTweetModel(String text, Date timestamp){
		super();
		this.text = text;
		this.timestamp = timestamp;
	}
	
	public LonelyTweetModel(String text){
		super();
		this.text = text;
		timestamp = new Date();
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public String getText(){
		return text;
	}
	
	public abstract Date getTimeStamp();
	
	public void setTimeStamp(Date timestamp){
		this.timestamp = timestamp;
	}
	
		
}
