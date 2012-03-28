package org.rubychina.android.widget;

import java.util.List;

import org.rubychina.android.R;
import org.rubychina.android.activity.TopicsActivity;
import org.rubychina.android.type.Topic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TopicAdapter extends ArrayAdapter<Topic> {

	private List<Topic> items;
	private TopicsActivity activity;
	private int resource;
	
	public TopicAdapter(TopicsActivity activity, int resource,
			int textViewResourceId, List<Topic> items) {
		super(activity, resource, textViewResourceId, items);
		this.activity = activity;
		this.resource = resource;
		this.items = items;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if(convertView == null) {
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(activity).inflate(resource, null);
			viewHolder.gravatar = (ImageView) convertView.findViewById(R.id.gravatar);
			viewHolder.title = (TextView) convertView.findViewById(R.id.title);
			viewHolder.author = (TextView) convertView.findViewById(R.id.author);
			viewHolder.replies = (TextView) convertView.findViewById(R.id.reply_count);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		final Topic t = items.get(position);
		activity.requestUserAvatar(t.getUser(), viewHolder.gravatar, 0);
		viewHolder.title.setText(t.getTitle());
		viewHolder.author.setText(" >> " + t.getUser().getLogin() + " 在  " + t.getNodeName() + " 中发起");
		if(t.getRepliesCount() > 99) {
			viewHolder.replies.setText("99+");
		} else {
			viewHolder.replies.setText(t.getRepliesCount() + "");
		}
		viewHolder.gravatar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				activity.visitUserProfile(t.getUser());
			}
		});
		return convertView;
	}
	
	private class ViewHolder {
		
		public ImageView gravatar;
		public TextView title;
		public TextView author;
		public TextView replies;
		
	}
	
}