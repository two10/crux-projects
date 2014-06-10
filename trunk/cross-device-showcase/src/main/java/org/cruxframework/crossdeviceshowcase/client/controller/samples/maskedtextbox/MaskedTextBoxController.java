package org.cruxframework.crossdeviceshowcase.client.controller.samples.maskedtextbox;

import java.util.Date;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.View;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox;
import org.cruxframework.crux.widgets.client.dialog.FlatMessageBox.MessageType;
import org.cruxframework.crux.widgets.client.maskedtextbox.MaskedTextBox;

import com.google.gwt.user.client.ui.Widget;

@Controller("maskedTextBoxController")
public class MaskedTextBoxController 
{
	@Inject
	private MaskedTextBoxMessages messages;
	
	private String MESSAGE_EMPTY_FIELD;
	private String MESSAGE_WRONG_FORMAT;
	private String MESSAGE_DATE;
	private String MESSAGE_INVALID_DATE;
	
	@Expose
	public void onLoad()
	{
		MESSAGE_EMPTY_FIELD = messages.emptyFild();
		MESSAGE_WRONG_FORMAT = messages.wrongFormat();
		MESSAGE_DATE = messages.infoDate();
		MESSAGE_INVALID_DATE = messages.invalidDate();
	}
	
	private MaskedTextBox getDateInput()
	{
		return View.of(this).getWidget("dateInput", MaskedTextBox.class);
	}
	
	private Widget getButton()
	{
		return View.of(this).getWidget("btnParseDate");
	}
	
	@Expose
	public void readDate()
	{
		MaskedTextBox widget = this.getDateInput();
		
        if(widget.getValue().isEmpty())
        {
        	FlatMessageBox.show(MESSAGE_EMPTY_FIELD, MessageType.WARN);
        }
        /*
         * This is a poor date format validation, just as an example, feel free to update it
         * as you need to.
         */
        else if(!widget.getValue().matches("[0-1][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]"))
        {
        	this.changeState("warn");
        	FlatMessageBox.show(MESSAGE_WRONG_FORMAT, MessageType.WARN);
        }
        else
        {
			try{
				Date date = (Date) widget.getUnformattedValue();
				this.changeState(null);
				FlatMessageBox.show(MESSAGE_DATE + date, MessageType.INFO);
			}catch(Exception e){
				this.changeState("warn");
				FlatMessageBox.show(MESSAGE_INVALID_DATE, MessageType.WARN);
			}
        	
        }
	}

	private void changeState(String type)
	{
		if(type == null)
		{
			type = "def";
		}
		
		MaskedTextBox widget = this.getDateInput();
		Widget button = this.getButton();
		
		widget.removeStyleName("warn");
		button.removeStyleName("warn");
		
		widget.setStyleName(type, true);
		button.setStyleName(type, true);
	}

	public void setMessages(MaskedTextBoxMessages messages) 
	{
		this.messages = messages;
	}
}
