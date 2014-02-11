package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public class NormalTweetModel extends AbstractTweetModel
{

	public NormalTweetModel(String text) {
		super(text);
	}

	@Override
	public Date getTimeStamp()
	{
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isImportant(){
		return false;
	}

}
