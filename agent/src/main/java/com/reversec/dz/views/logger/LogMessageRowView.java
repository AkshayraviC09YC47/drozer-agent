package com.reversec.dz.views.logger;

import com.reversec.dz.R;
import com.reversec.jsolar.logger.LogMessage;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;

public class LogMessageRowView extends LinearLayout {
	
	private LogMessage message = null;
	private TextView message_label = null;
	private TextView message_message = null;
	
	public LogMessageRowView(Context context) {
		super(context);
		
		this.setUpView();
	}

	public LogMessageRowView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		this.setUpView();
	}
	
	private void setLevel(int level) {
		int bgColorRes;
		int textColorRes;
		int textRes;

		switch(level) {
		case LogMessage.ASSERT:
			textRes = R.string.log_level_tag_assert;
			bgColorRes = R.color.logAssertBg;
			textColorRes = R.color.logAssertText;
			break;
			
		case LogMessage.DEBUG:
			textRes = R.string.log_level_tag_debug;
			bgColorRes = R.color.logDebugBg;
			textColorRes = R.color.logDebugText;
			break;
		
		case LogMessage.ERROR:
			textRes = R.string.log_level_tag_error;
			bgColorRes = R.color.logErrorBg;
			textColorRes = R.color.logErrorText;
			break;
			
		case LogMessage.INFO:
			textRes = R.string.log_level_tag_info;
			bgColorRes = R.color.logInfoBg;
			textColorRes = R.color.logInfoText;
			break;
			
		case LogMessage.VERBOSE:
			textRes = R.string.log_level_tag_verbose;
			bgColorRes = R.color.logVerboseBg;
			textColorRes = R.color.logVerboseText;
			break;
			
		case LogMessage.WARN:
			textRes = R.string.log_level_tag_warn;
			bgColorRes = R.color.logWarnBg;
			textColorRes = R.color.logWarnText;
			break;
			
		default:
			textRes = R.string.log_level_tag_unknown;
			bgColorRes = R.color.logUnknownBg;
			textColorRes = R.color.logUnknownText;
			break;
		}

		this.message_label.setText(textRes);
		this.message_label.setTextColor(ContextCompat.getColor(getContext(), textColorRes));

		// Tint the badge background drawable
		GradientDrawable badge = (GradientDrawable) ContextCompat.getDrawable(getContext(), R.drawable.log_badge_background);
		if (badge != null) {
			badge = (GradientDrawable) badge.mutate();
			badge.setColor(ContextCompat.getColor(getContext(), bgColorRes));
			this.message_label.setBackground(badge);
		}
	}
	
	public void setLogMessage(LogMessage message) {
		this.message = message;
		
		this.setLevel(this.message.getLevel());
		this.message_message.setText(this.message.getMessage());
	}
	
	private void setUpView() {
		this.addView(View.inflate(this.getContext(), R.layout.list_view_row_log_message, null));
		
		this.message_label = (TextView)this.findViewById(R.id.log_message_level);
		this.message_message = (TextView)this.findViewById(R.id.log_message_message);
	}

}
