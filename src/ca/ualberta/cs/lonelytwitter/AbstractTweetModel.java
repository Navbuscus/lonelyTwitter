package ca.ualberta.cs.lonelytwitter;
import java.util.Date;

public abstract class AbstractTweetModel{
	protected String text;
	protected Date timestamp;
	
	public AbstractTweetModel(String text, Date timestamp){
		super();
		this.text = text;
		this.timestamp = timestamp;
	}
	
	public AbstractTweetModel(String text){
		super();
		this.text = text;
		timestamp = new Date();
	}
	
	public void setText(String text) throws Exception {
		if (text.length() > 140){
			throw new IllegalArgumentException();
		}
			this.text = text;
	}
	
	public String getText(){
		return text;
	}
	
	public abstract Date getTimeStamp();
	
	public void setTimeStamp(Date timestamp){
		this.timestamp = timestamp;
	}
	
	public abstract boolean isImportant();	
}
