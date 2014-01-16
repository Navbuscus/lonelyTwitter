package ca.ualberta.cs.lonelytwitter;
import java.util.Date;

public class LonelyTweetModel
{
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
	
	public Date getTimeStamp(){
		return timestamp;
	}
	
	public void setTimeStamp(Date timestamp){
		this.timestamp = timestamp;
	}
	
		
}
